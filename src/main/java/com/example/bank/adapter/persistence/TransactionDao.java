package com.example.bank.adapter.persistence;

import com.example.bank.adapter.persistence.entity.AccountTransaction;
import com.example.bank.application.port.out.TransactionDaoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class TransactionDao implements TransactionDaoPort {

    private TransactionRepository repository;

    @Override
    public void addTransaction(String date, int amount) {
            repository.save(new AccountTransaction(date,amount));
    }

    @Override
    public List<Integer> all() {
        List<AccountTransaction> transactions = repository.findAll();

        return transactions.stream()
                .map(AccountTransaction::getAmount)
                .collect(Collectors.toList());
    }
}
