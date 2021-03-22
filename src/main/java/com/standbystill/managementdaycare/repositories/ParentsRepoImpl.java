package com.standbystill.managementdaycare.repositories;

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
public class ParentsRepoImpl implements ParentsRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Parents> fetchAll() {
        String sql="SELECT * FROM parents";
        RowMapper<Parents> rowMapper = new BeanPropertyRowMapper<>(Parents.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Parents> fetchParentsForFamily(int familyId) {
        String sql="SELECT * FROM parents WHERE Family_id=?";
        RowMapper<Parents> rowMapper = new BeanPropertyRowMapper<>(Parents.class);
        return jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public Family fetchFamilyForParent(int familyId) {
        String sql="SELECT * FROM family WHERE id = ?";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return (Family) jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public int addParent(Parents parent, int familyId) {
        String lastName = parent.getLastName();
        String firstName = parent.getFirstName();
        int cpr = parent.getCpr();
        String sql = "INSERT INTO parents (FirstName, LastName, CPR, Family_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1,firstName);
                ps.setString(2,lastName);
                ps.setString(3, String.valueOf(cpr));
                ps.setString(4, String.valueOf(familyId));
                return ps;
            }
        }, keyHolder);
        int i = keyHolder.getKey().intValue();
        return i;
    }

    @Override
    public boolean updateParent(String lastName, String firstName, int cpr, int id) {
        String sql = "UPDATE parents SET LastName = ?, FirstName = ?, CPR = ? WHERE id = ?";
        return jdbcTemplate.update(sql,lastName,firstName,cpr,id)>=0;
    }

    @Override
    public boolean deleteParent(int parentId) {
        String sql = "DELETE FROM parents WHERE id = ?";
        return jdbcTemplate.update(sql,parentId)>=0;
    }

    @Override
    public Parents findParentById(int parentId) {
        String sql = "SELECT * FROM parents WHERE id = ?";
        RowMapper<Parents> rowMapper = new BeanPropertyRowMapper<>(Parents.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,parentId);
    }

    @Override
    public List<Parents> findParentsByLastName(String lastName) {
        String sql = "SELECT * FROM parents WHERE LastName = ?";
        RowMapper<Parents> rowMapper = new BeanPropertyRowMapper<>(Parents.class);
        return jdbcTemplate.query(sql, rowMapper, lastName);
    }
}
