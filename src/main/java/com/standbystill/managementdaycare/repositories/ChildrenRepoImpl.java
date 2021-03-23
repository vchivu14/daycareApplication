package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Child;
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
    public List<Child> fetchAll() {
        String sql="SELECT * FROM child";
        RowMapper<Child> rowMapper = new BeanPropertyRowMapper<>(Child.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Child> fetchChildrenForFamily(int familyId) {
        String sql = "SELECT * FROM child WHERE Family_id = ?";
        RowMapper<Child> rowMapper = new BeanPropertyRowMapper<>(Child.class);
        return jdbcTemplate.query(sql,rowMapper,familyId);
    }

    @Override
    public Family fetchFamilyForChildren(int familyId){
        String sql = "SELECT * FROM family WHERE id = ?";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,familyId);
    }

    @Override
    public void addChild(Child child, int familyId, int personId) {
        String lastName = child.getLastName();
        String firstName = child.getFirstName();
        int age = child.getAge();
        String sql = "INSERT INTO child (FirstName, LastName, Age, Family_id, Person_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3, String.valueOf(age));
            ps.setString(4, String.valueOf(familyId));
            ps.setString(5, String.valueOf(personId));
            return ps;
        });
    }

    @Override
    public boolean updateChild(String firstName, String lastName, int age, int personId) {
        String sql = "UPDATE child SET LastName = ?, FirstName = ?, Age = ? WHERE Person_id = ?";
        return jdbcTemplate.update(sql,firstName,lastName,age,personId)>=0;
    }

    @Override
    public boolean deleteChild(int personId) {
        String sql = "DELETE FROM child WHERE Person_id = ?";
        return jdbcTemplate.update(sql,personId)>=0;
    }

    @Override
    public Child findChildById(int personId) {
        String sql = "SELECT * FROM child WHERE Person_id = ?";
        RowMapper<Child> rowMapper = new BeanPropertyRowMapper<>(Child.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,personId);
    }

    @Override
    public List<Child> findChildrenByLastName(String lastName) {
        String sql = "SELECT * FROM child WHERE LastName = ?";
        RowMapper<Child> rowMapper = new BeanPropertyRowMapper<>(Child.class);
        return jdbcTemplate.query(sql, rowMapper, lastName);
    }

}
