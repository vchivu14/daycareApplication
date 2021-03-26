package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Parent;
import com.standbystill.managementdaycare.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class PersonRepoImpl implements PersonRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addPerson(Person person, int addressId) {
        int CPR = person.getCpr();
        String sql = "INSERT INTO person (CPR, Address_id) VALUES (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, String.valueOf(CPR));
            ps.setString(2, String.valueOf(addressId));
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Person findPersonById(int personId) {
        String sql = "SELECT * FROM person WHERE id = ?";
        RowMapper<Person>rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,personId);
    }

    @Override
    public boolean updatePerson(Person person, int personId) {
        int cpr = person.getCpr();
        String sql = "UPDATE person SET CPR = ? WHERE id = ?";
        return jdbcTemplate.update(sql,cpr,personId)>=0;

    }
}
