package com.example.bank.application.port.in;

public interface AccountUseCasePort {
    void deposit(int amount);

    void withdraw(int amount);

    Integer balance();
}
