package com.baltia;

import com.baltia.account.Account;
import com.baltia.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

import java.util.List;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringExampleJdbcMysqlApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AccountRepository accountRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringExampleJdbcMysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);

        System.out.println("============== Find all accoutns =========================");
        final int[] i = {0};
        accountRepository.findAll().forEach(account -> {
            i[0]++;
            System.out.println("============== Line " + i[0] + " =============");

            System.out.println("id: " + account.getId());
            System.out.println("name: " + account.getName());
            System.out.println("email: " + account.getEmail());
            System.out.println("date: " + account.getDate());
        });

        exit(0);
    }
}
