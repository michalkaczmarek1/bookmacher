package com.projects.bookmacher.service;

import com.projects.bookmacher.domain.Account;
import com.projects.bookmacher.domain.User;
import com.projects.bookmacher.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DbServiceAccount {

    @Autowired
    private final AccountRepository accountRepository;

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAllAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}
