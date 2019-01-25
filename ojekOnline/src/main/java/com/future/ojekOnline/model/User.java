package com.future.ojekOnline.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int balance;

    @Column
    private String password;

    public User(){}

    public User(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public User(String name, String password, int balance){
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
}
