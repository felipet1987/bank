package com.example.bank.application.useCase;


import com.example.bank.application.helper.ClockHelper;
import com.example.bank.application.port.out.TransactionDaoPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AccountUseCaseTest {


    @Mock
    private TransactionDaoPort transactionDao;

    @Mock
    ClockHelper helper;

    @InjectMocks
    private AccountUseCase useCase;



    @Test
    void deposit() {

        given(helper.dateAsString()).willReturn("11/11/2021");

        useCase.deposit(500);

        then(helper).should().dateAsString();
        then(transactionDao).should().addTransaction("11/11/2021",500);

    }

    @Test
    void withdraw() {

        given(helper.dateAsString()).willReturn("11/11/2021");

        useCase.withdraw(500);

        then(helper).should().dateAsString();
        then(transactionDao).should().addTransaction("11/11/2021",-500);

    }

    @Test
    void balance() {

        List<Integer> transactions = Arrays.asList(500,-100);
        given(transactionDao.all()).willReturn(transactions);

        Integer result = useCase.balance();

        assertThat(result,is(400));

    }
}