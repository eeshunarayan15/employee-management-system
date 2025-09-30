package com.micro.account.service;

import com.micro.account.Repository.AccountRepository;
import com.micro.account.dto.AccountDto;
import com.micro.account.dto.external.EmployeeResponse;
import com.micro.account.entities.Account;
import com.micro.account.exception.DublicateResourceException;
import com.micro.account.exception.ResourceNotFoundException;
import com.micro.account.external.client.EmployeeClient;
import com.micro.account.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;
    private  final  EmployeeClient employeeClient;

    @Override
    public ApiResponse<List<Account>> getAllAccount() {
        List<Account> all = accountRepository.findAll();
        if (all.isEmpty()) {
            return new ApiResponse<>("Failed", "Account Not Found", Collections.emptyList());
        }
        return new ApiResponse<>("Sucess", "Account Found", all);

    }

    @Override
    public ApiResponse<Account> getSingleAccount(String id) {
        Account savedAccount = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Does not exist"));

        return new ApiResponse<>("Sucess", "Account Found", savedAccount);

    }

    @Override
    public ApiResponse<Account> saveAccount(AccountDto accountDto) {

        //check if account already exits
        boolean present = accountRepository.findByAccountNo(accountDto.getAccountNo()).isPresent();
        if (present) {
            throw new DublicateResourceException("Account No Already Exists" + accountDto.getAccountNo());

        }
        //check if employee id is not present

//        ResponseEntity<ApiResponse<EmployeeResponse>> responseEmployee = restTemplate.exchange("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + accountDto.getEmployeeId(), HttpMethod.GET,
//                null,//null because this request is not post
//                new ParameterizedTypeReference<ApiResponse<EmployeeResponse>>() {
//                });
        //stop default excepiton handling behaviour
//        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
//            @Override
//            public boolean hasError(ClientHttpResponse response) throws IOException {
//                return super.hasError(response);
//            }
//        });
//        //check if employee id is not present
//        ResponseEntity<ApiResponse<EmployeeResponse>> response = restTemplate.exchange("http://localhost:8081/api/employees/" + accountDto.getEmployeeId(), HttpMethod.GET,
//                null,//null because this request is not post
//                new ParameterizedTypeReference<ApiResponse<EmployeeResponse>>() {
//                });
//        ApiResponse<EmployeeResponse> employeeResponse = response.getBody();
//
////        assert employeeResponse != null;
//        if (employeeResponse.getData() == null || !"SUCESS".equalsIgnoreCase(employeeResponse.getStatus()) || employeeResponse.getData() == null) {
//            throw new ResourceNotFoundException("Employee Id : " + accountDto.getAccountNo() + "Does not exist");
//        }
        System.out.println(accountDto.getAccountNo());

     employeeClient.getSingleEmployee(accountDto.getEmployeeId());


        Account account = modelMapper.map(accountDto, Account.class);
        account.setId(UUID.randomUUID().toString());
        account.setDateTime(LocalDateTime.now().toString());
        Account savedAccount = accountRepository.save(account);

        if (savedAccount == null) {
            return new ApiResponse<>("Failed", "Account Not Created", null);
        }
        return new ApiResponse<>("Sucess", "Account Created", savedAccount);
    }
}
