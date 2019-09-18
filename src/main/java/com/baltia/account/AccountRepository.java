package com.baltia.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        List<Account> listAccount = jdbcTemplate.query(
                "select id, name, email, date from accounts",
                (rs, rowNum) -> new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("date")
                )
        );
        return listAccount;
    }

    public void createAccount(String name, String email) {
        jdbcTemplate.update(
                "insert into accounts(name, email,date) values (?,?,?)",
                name, email, new Date()
        );
    }
}
