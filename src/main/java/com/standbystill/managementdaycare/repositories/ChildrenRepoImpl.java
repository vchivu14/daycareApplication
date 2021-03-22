package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Children;
import com.standbystill.managementdaycare.entities.Family;
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
public class ChildrenRepoImpl implements ChildrenRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Children> fetchAll() {
        String sql="SELECT * FROM children";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Children> fetchChildrenForFamily(int familyId) {
        String sql = "SELECT * FROM children WHERE Family_id = ?";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        return jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public Family fetchFamilyForChildren(int familyId){
        String sql = "SELECT * FROM family WHERE id = ?";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,familyId);
    }

    @Override
    public int addChild(Children child, int familyId) {
        String lastName = child.getLastName();
        String firstName = child.getFirstName();
        int cpr = child.getCpr();
        String sql = "INSERT INTO children (FirstName, LastName, CPR, Family_id) VALUES (?, ?, ?, ?)";
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
    public boolean updateChild(String lastName, String firstName, int cpr, int id) {
        String sql = "UPDATE children SET LastName = ?, FirstName = ?, CPR = ? WHERE id = ?";
        return jdbcTemplate.update(sql,lastName,firstName,cpr,id)>=0;
    }

    @Override
    public boolean deleteChild(int childId) {
        String sql = "DELETE FROM children WHERE id = ?";
        return jdbcTemplate.update(sql,childId)>=0;
    }

    @Override
    public Children findChildById(int childId, int familyId) {
        String sql = "SELECT * FROM children WHERE id = ? AND children.Family_id = ?";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,childId,familyId);
    }

    @Override
    public List<Children> findChildrenByLastName(String lastName) {
        String sql = "SELECT * FROM children WHERE LastName = ?";
        RowMapper<Children> rowMapper = new BeanPropertyRowMapper<>(Children.class);
        return jdbcTemplate.query(sql, rowMapper, lastName);
    }

}
