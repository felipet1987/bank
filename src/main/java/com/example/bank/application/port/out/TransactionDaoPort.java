package com.example.bank.application.port.out;

import java.util.List;

public interface TransactionDaoPort {
     void addTransaction(String date, int amount);


    List<Integer> all();
}
