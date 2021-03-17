package com.example.bank.adapter.persistence;

import com.example.bank.adapter.persistence.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<AccountTransaction,Long> {
}
