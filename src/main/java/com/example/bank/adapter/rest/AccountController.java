package com.example.bank.adapter.rest;


import com.example.bank.adapter.rest.request.TransactionRequest;
import com.example.bank.adapter.rest.response.BalanceResponse;
import com.example.bank.application.port.in.AccountUseCasePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AccountController {

    private AccountUseCasePort accountUseCase;

    @PostMapping(value = "/deposit")
    public void makeDeposit(@RequestBody  TransactionRequest request) {
        accountUseCase.deposit(request.getAmount());
    }

    @PostMapping(value = "/withdraw")
    public void makeWithdraw(@RequestBody  TransactionRequest request) {
        accountUseCase.withdraw(request.getAmount());
    }

    @PostMapping(value = "/balance")
    public BalanceResponse getBalance() {
        return new BalanceResponse(accountUseCase.balance());
    }
}
