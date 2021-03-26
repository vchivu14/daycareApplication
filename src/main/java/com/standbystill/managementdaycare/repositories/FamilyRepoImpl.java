package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Child;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FamilyRepoImpl implements FamilyRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Family> fetchAll() {
        String sql="SELECT * FROM family";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public int addFamily(Family family, int addressId) {
        String name = family.getName();
        Date date = family.getRegistration();
        int phone = family.getPhone();
        String sql = "INSERT INTO family (Name, Registration, Phone, Address_id) VALUES (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1, name);
                ps.setString(2, String.valueOf(date));
                ps.setString(3, String.valueOf(phone));
                ps.setString(4, String.valueOf(addressId));
                return ps;
            }
        }, keyHolder);
        int i = keyHolder.getKey().intValue();
        return i;
    }

    @Override
    public boolean updateFamily(Family family, int familyId) {
        String name = family.getName();
        int phone = family.getPhone();
        String sql = "UPDATE family SET Name = ?, Phone = ? WHERE id = ?";
        return jdbcTemplate.update(sql,name,phone,familyId)>=0;
    }

    @Override
    public boolean deleteFamily(int familyId) {
        String sql = "DELETE FROM family WHERE id = ?";
        return jdbcTemplate.update(sql,familyId)>=0;
    }

    @Override
    public Family findFamilyById(int familyId) {
        String sql = "SELECT * FROM family WHERE id = ?";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,familyId);
    }

    @Override
    public List<Family> findFamilyByName(String name) {
        String sql = "SELECT * FROM family WHERE Name = ?";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return jdbcTemplate.query(sql,rowMapper,name);
    }

    @Override
    public List<Parent> findParentsForFamily(int familyId) {
        String sql = "SELECT * FROM parent WHERE Family_id= ?";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        return jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public List<Child> findChildrenForFamily(int familyId) {
        String sql = "SELECT * FROM child WHERE Family_id = ?";
        RowMapper<Child> rowMapper = new BeanPropertyRowMapper<>(Child.class);
        return jdbcTemplate.query(sql, rowMapper, familyId);
    }
}
