package com.micro.account.service;

import com.micro.account.Repository.AccountRepository;
import com.micro.account.dto.AccountDto;
import com.micro.account.entities.Account;
import com.micro.account.exception.ResourceNotFoundException;
import com.micro.account.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl  implements  AccountService{
    private  final AccountRepository accountRepository;
    private  final ModelMapper modelMapper;
    @Override
    public ApiResponse<List<Account>> getAllAccount() {
        List<Account> all = accountRepository.findAll();
        if (all.isEmpty()){
            return new ApiResponse<>("Failed", "Account Not Found", Collections.emptyList());
        }
return  new ApiResponse<>("Sucess", "Account Found", all);

    }

    @Override
    public ApiResponse<Account> getSingleAccount(String id) {
        Account  savedAccount = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Does not exist"));

        return        new ApiResponse<>( "Sucess", "Account Found", savedAccount);

    }

    @Override
    public ApiResponse<Account> saveAccount(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account.setId(UUID.randomUUID().toString());
        account.setDateTime(LocalDateTime.now().toString());
        Account savedAccount = accountRepository.save(account);

        if (savedAccount == null){
            return new ApiResponse<>("Failed", "Account Not Created", null);
        }
        return new ApiResponse<>( "Sucess", "Account Created", savedAccount);
    }
}
