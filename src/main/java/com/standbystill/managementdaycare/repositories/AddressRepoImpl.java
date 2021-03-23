package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.Address;
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
public class AddressRepoImpl implements AddressRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addAddress(Address address) {
        String street = address.getStreet();
        int number = address.getNumber();
        String city = address.getCity();
        int zipcode = address.getZipcode();
        String country = address.getCountry();
        String sql = "INSERT INTO address (street, number, city, zipcode, country) VALUES (?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1, street);
                ps.setString(2, String.valueOf(number));
                ps.setString(3, city);
                ps.setString(4, String.valueOf(zipcode));
                ps.setString(5, country);
                return ps;
            }
        }, keyHolder);
        int i = keyHolder.getKey().intValue();
        return i;
    }
}
