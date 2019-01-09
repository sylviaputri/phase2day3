package com.future.ojekOnline.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int balance;

    public Driver(){}

    public Driver(String name, int balance){
        this.name = name;
        this.balance = balance;
    }
}
