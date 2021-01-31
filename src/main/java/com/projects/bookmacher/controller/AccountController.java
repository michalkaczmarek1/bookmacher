package com.projects.bookmacher.controller;

import com.projects.bookmacher.domain.Account;
import com.projects.bookmacher.domain.AccountDto;
import com.projects.bookmacher.exception.AccountNotFoundException;
import com.projects.bookmacher.mapper.AccountMapper;
import com.projects.bookmacher.service.DbServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AccountController {

    @Autowired
    private DbServiceAccount dbServiceAccount;

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public List<AccountDto> getAccounts() {
        List<Account> accounts = dbServiceAccount.getAllAccount();
        List<AccountDto> accountDtos = accountMapper.mapToAccountDtos(accounts);
        return accountDtos;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public AccountDto getAccount(@PathVariable Long id) throws AccountNotFoundException {
        return accountMapper.mapToAccountDto(
                dbServiceAccount.getAccount(id).orElseThrow(AccountNotFoundException::new)
        );
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createAccount(@RequestBody AccountDto accountDto) {
//        //mapper lub service
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void updateAccount(@RequestBody AccountDto accountDto) {
//        //mapper lub service
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{id}")
//    public void deleteAccount(@PathVariable Long id) {
//        //mapper lub service
//    }

}
