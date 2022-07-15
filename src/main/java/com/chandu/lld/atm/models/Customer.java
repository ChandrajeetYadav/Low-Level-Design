package com.chandu.lld.atm.models;

import com.chandu.lld.atm.service.BankService;

public class Customer {
    private String firstName;
    private String lastName;
    private CardInfo cardInfo;
    private Account account;

    private BankService bankService;
    private CustomerStatus customerStatus;
}
