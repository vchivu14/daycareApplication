package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PersonRepoImpl implements PersonRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addPerson(Person person, int addressId) {
        int CPR = person.getCpr();
        String sql = "INSERT INTO person (CPR, Address_id) VALUES (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1, String.valueOf(CPR));
                ps.setString(2, String.valueOf(addressId));
                return ps;
            }
        }, keyHolder);
        int i = keyHolder.getKey().intValue();
        return i;
    }
}
