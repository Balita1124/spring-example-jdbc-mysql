package com.baltia.account;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private int id;
    private String name;
    private String email;
    private Date date;
}
