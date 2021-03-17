package com.example.bank.adapter.rest;

import com.example.bank.adapter.rest.request.TransactionRequest;
import com.example.bank.adapter.rest.response.BalanceResponse;
import com.example.bank.application.port.in.AccountUseCasePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    private AccountUseCasePort useCase;

    @InjectMocks
    private AccountController controller;

    @Test
    void makeDeposit() {
        TransactionRequest request = new TransactionRequest(500);
        controller.makeDeposit(request);

        then(useCase).should().deposit(500);
    }
    @Test
    void makeWithdraw() {
        TransactionRequest request = new TransactionRequest(500);
        controller.makeWithdraw(request);

        then(useCase).should().withdraw(500);
    }

    @Test
    void getCurrentBalance() {

        given(useCase.balance()).willReturn(100);
        BalanceResponse response = controller.getBalance();
        assertThat(response.getBalance(),is(100));

    }
}