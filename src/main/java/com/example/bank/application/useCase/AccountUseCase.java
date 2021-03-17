package com.example.bank.application.useCase;


import com.example.bank.application.helper.ClockHelper;
import com.example.bank.application.port.in.AccountUseCasePort;
import com.example.bank.application.port.out.TransactionDaoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AccountUseCase implements AccountUseCasePort {

    private TransactionDaoPort dao;
    private ClockHelper clockHelper;

    @Override
    public void deposit(int amount) {
        dao.addTransaction(clockHelper.dateAsString(),amount);
    }

    @Override
    public void withdraw(int amount) {
        dao.addTransaction(clockHelper.dateAsString(),-amount);
    }

    @Override
    public Integer balance() {
        return dao.all().stream().reduce(0,(balance,amount) -> balance + amount);
    }
}
