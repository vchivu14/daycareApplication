package com.standbystill.managementdaycare.repositories;

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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ParentsRepoImpl implements ParentsRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Parent> fetchAll() {
        String sql="SELECT * FROM parent";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Parent> fetchParentsForFamily(int familyId) {
        String sql="SELECT * FROM parent WHERE Family_id=?";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        return jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public Family fetchFamilyForParent(int familyId) {
        String sql="SELECT * FROM family WHERE id = ?";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return (Family) jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public int addParent(Parent parent, int familyId, int personId) {
        String lastName = parent.getLastName();
        String firstName = parent.getFirstName();
        int age = parent.getAge();
        String email = parent.getEmail();
        int phone = parent.getPhone();
        int income = parent.getIncome();
        String sql = "INSERT INTO parent (FirstName, LastName, Age, Email, Phone, Income, Family_id, Person_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1,firstName);
                ps.setString(2,lastName);
                ps.setString(3, String.valueOf(age));
                ps.setString(4, email);
                ps.setString(5, String.valueOf(phone));
                ps.setString(6, String.valueOf(income));
                ps.setString(7, String.valueOf(familyId));
                ps.setString(8, String.valueOf(personId));
                return ps;
            }
        }, keyHolder);
        int i = keyHolder.getKey().intValue();
        return i;
    }

    @Override
    public boolean updateParent(String firstName, String lastName, int age, String email, int phone, int income, int parentId) {
        String sql = "UPDATE parent SET FirstName = ?, LastName = ?, Age = ?, Email = ?, Phone = ?, Income = ? WHERE id = ?";
        return jdbcTemplate.update(sql,firstName,lastName,age,email,phone,income,parentId)>=0;
    }

    @Override
    public boolean deleteParent(int parentId) {
        String sql = "DELETE FROM parent WHERE id = ?";
        return jdbcTemplate.update(sql,parentId)>=0;
    }

    @Override
    public Parent findParentById(int parentId) {
        String sql = "SELECT * FROM parent WHERE id = ?";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,parentId);
    }

    @Override
    public List<Parent> findParentsByLastName(String lastName) {
        String sql = "SELECT * FROM parent WHERE LastName = ?";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        return jdbcTemplate.query(sql, rowMapper, lastName);
    }
}
