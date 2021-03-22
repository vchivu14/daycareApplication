package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Children;
import com.standbystill.managementdaycare.entities.Family;
import com.standbystill.managementdaycare.entities.Parents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
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
    public int addFamily(Family family) {
        String name = family.getName();
        Float fees = family.getFees();
        String sql = "INSERT INTO family (Name, Fees) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1, name);
                ps.setString(2, String.valueOf(fees));
                return ps;
            }
        }, keyHolder);
        int i = keyHolder.getKey().intValue();
        return i;
    }

    @Override
    public boolean updateFamily(String name, int familyId) {
        String sql = "UPDATE family SET Name = ? WHERE id = ?";
        return jdbcTemplate.update(sql,name,familyId)>=0;
    }

    @Override
    public boolean deleteFamily(int familyId) {
        String sql = "DELETE FROM family WHERE id = ?";
        return jdbcTemplate.update(sql,familyId)>=0;
    }

    @Override
    public Family findFamilyById(int familyId) {
        String sql = "SELECT id, Name, Fees FROM family WHERE id = ?";
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
    public List<Parents> findParentsForFamily(int familyId) {
        String sql = "SELECT * FROM parents WHERE Family_id= ?";
        RowMapper<Parents> rowMapper = new BeanPropertyRowMapper<>(Parents.class);
        return jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public List<Children> findChildrenForFamily(int familyId) {
        String sql = "SELECT * FROM children WHERE Family_id = ?";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        return jdbcTemplate.query(sql, rowMapper, familyId);
    }
}
