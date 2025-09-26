package com.micro.account.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String id;
    @Column(unique = true,length = 16)
    private String accountNo;
    @Column(length = 100    )
    private  String bankName;
    @Column(length = 100)
    private  String ifsc;
    @Column(length = 100)
    private String address;
    private  String dateTime;
    private  String employeeId;
}
