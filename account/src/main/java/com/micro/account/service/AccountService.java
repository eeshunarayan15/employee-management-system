package com.micro.account.service;

import com.micro.account.dto.AccountDto;
import com.micro.account.entities.Account;
import com.micro.account.payload.ApiResponse;

import java.util.List;

public interface AccountService {
    ApiResponse<List<Account>> getAllAccount();
    ApiResponse<Account>   getSingleAccount(String id);
    ApiResponse<Account> saveAccount(AccountDto employeeDto);
}
