package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.CPR;
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

@Repository
public class CPRRepoImpl implements CPRRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addCPR(CPR cpr, int personId) {
        int number = cpr.getNumber();
        String sql = "INSERT INTO cpr (Number, Person_id) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1, String.valueOf(number));
                ps.setString(2, String.valueOf(personId));
                return ps;
            }
        }, keyHolder);
        int i = keyHolder.getKey().intValue();
        return i;
    }

    @Override
    public CPR findCPRbyId(int cprId) {
        String sql = "SELECT * FROM cpr WHERE id = ?";
        RowMapper<CPR> rowMapper = new BeanPropertyRowMapper<>(CPR.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, cprId);
    }
}
