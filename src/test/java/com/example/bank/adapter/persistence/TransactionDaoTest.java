package com.example.bank.adapter.persistence;

import com.example.bank.adapter.persistence.entity.AccountTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class TransactionDaoTest {


    @Mock
    TransactionRepository repository;

    @InjectMocks
    private TransactionDao dao;

    @Test
    void addTransaction() {
        dao.addTransaction("11/11/2021",500);

        AccountTransaction transaction = new AccountTransaction("11/11/2021",500);
        then(repository).should().save(transaction);
    }

    @Test
    void all() {

        List<AccountTransaction> list = asList(
                new AccountTransaction("",300),
                new AccountTransaction("",-200)
        );
        given(repository.findAll()).willReturn(list);
        List<Integer> result = dao.all();

        List<Integer> expected = asList(300,-200);
        assertThat(result,is(expected));


    }
}