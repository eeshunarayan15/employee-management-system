package com.micro.account.Repository;

import com.micro.account.entities.Account;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
Optional  <Account> findByAccountNo(String accountNo);
}
