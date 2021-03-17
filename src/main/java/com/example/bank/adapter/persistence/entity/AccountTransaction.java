package com.example.bank.adapter.persistence.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
@ToString
public class AccountTransaction {

    private int amount;
    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public AccountTransaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }


    public AccountTransaction() {
    }
}
