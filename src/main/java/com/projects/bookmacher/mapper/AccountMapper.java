package com.projects.bookmacher.mapper;

import com.projects.bookmacher.domain.Account;
import com.projects.bookmacher.domain.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountMapper {

    public Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getNumber(),
                accountDto.getValue()
        );
    }

    public AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getNumber(),
                account.getValue()
        );
    }

    public List<AccountDto> mapToAccountDtos(List<Account> accounts) {
        return accounts.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }

}
