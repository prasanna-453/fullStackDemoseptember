package com.neoteric.fullstackdemo_318._4.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="account",schema="bank")
@Data
public class AccountEntity {

    public AccountEntity(){

    }

    @Column (name="name",nullable = false)
    private String name;

    @Id
    @Column(name="accountNumber",nullable=false)
    private String accountNumber;
    @Column(name="pan",nullable = false)
    private String pan;
    @Column(name="mobileNumber",nullable = false)
    private String mobileNumber;
    @Column(name="balance",nullable = false)
    private double balance;
    @Column(name="address",nullable = false)
    private String address;
}
