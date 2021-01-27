package com.projects.bookmacher.controller;

import com.projects.bookmacher.domain.AccountDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public List<AccountDto> getAccounts() {
        //mapper lub service
        return new ArrayList<AccountDto>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public void getAccount(@PathVariable Long id) {
        //mapper lub service
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountDto accountDto) {
        //mapper lub service
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAccount(@RequestBody AccountDto accountDto) {
        //mapper lub service
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        //mapper lub service
    }

}
