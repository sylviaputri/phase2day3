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

    public User(){}

    public User(String name, int balance){
        this.name = name;
        this.balance = balance;
    }
}
