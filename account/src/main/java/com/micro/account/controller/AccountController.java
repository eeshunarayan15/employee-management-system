package com.micro.account.controller;
import com.micro.account.dto.AccountDto;
import com.micro.account.entities.Account;
import com.micro.account.payload.ApiResponse;
import com.micro.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/account")
public class AccountController {
    private  final AccountService accountService;
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Account>> getSingleAccount(@PathVariable  String  id){
        ApiResponse<Account> singleAccount = accountService.getSingleAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body(singleAccount);

    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Account>>> getAllAccount(){
        ApiResponse<List<Account>> allAccount = accountService.getAllAccount();

        return ResponseEntity.status(HttpStatus.OK).body(allAccount);

    }
    @PostMapping("/save")
    public ResponseEntity<ApiResponse<Account>> createAccount(@Valid @RequestBody AccountDto accountDto){
        ApiResponse<Account> accountApiResponse = accountService.saveAccount(accountDto);
        return ResponseEntity.status(HttpStatus.OK).body(accountApiResponse);
    }
}
