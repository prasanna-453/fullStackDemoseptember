package com.neoteric.fullstackdemo_318._4.controller;


import com.neoteric.fullstackdemo_318._4.exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_318._4.model.Account;
import com.neoteric.fullstackdemo_318._4.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
    @PostMapping(value ="/createAccount",consumes="application/json",
    produces = "application/Json")


    public Account getAccountNumber(@RequestBody Account account)
        throws AccountCreationFailedException {

        AccountService accountService=new AccountService();
        String accountNumber=accountService.createAccount(account);
        account.setAccountNumber(accountNumber);

        return account;

    }

}
