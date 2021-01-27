package com.projects.bookmacher;

import com.projects.bookmacher.domain.Account;
import com.projects.bookmacher.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldAccountRepositorySave() {
        //Given
        Account account = new Account("12345678", new BigDecimal("0"));
        accountRepository.save(account);
        //When
        Long id = account.getId();
        Optional<Account> readAccount= accountRepository.findById(id);
        //Then
        assertTrue(readAccount.isPresent());
        //clean up
        accountRepository.deleteAll();
    }

    @Test
    void shouldAccountRepositoryDeleteById() {
        //Given
        Account account = new Account("12345678", new BigDecimal("0"));
        accountRepository.save(account);
        //When
        Long id = account.getId();
        accountRepository.deleteById(id);
        //Then
        assertFalse(accountRepository.findById(id).isPresent());
    }

    @Test
    void shouldAccountRepositoryfindAll() {
        //Given
        Account account1 = new Account("12345678", new BigDecimal("0"));
        accountRepository.save(account1);
        Account account2 = new Account("87654321", new BigDecimal("0"));
        accountRepository.save(account2);
        //When
        List<Account> accounts = accountRepository.findAll();
        //Then
        assertEquals(2, accounts.size());
        //clean up
        accountRepository.deleteAll();
    }

    @Test
    void shouldAccountRepositoryfindById() {
        //Given
        Account account1 = new Account("12345678", new BigDecimal("0"));
        accountRepository.save(account1);
        //When
        Long id = account1.getId();
        Optional<Account> readAccount = accountRepository.findById(id);
        //Then
        assertTrue(readAccount.isPresent());
        //clean up
        accountRepository.deleteAll();
    }

}
