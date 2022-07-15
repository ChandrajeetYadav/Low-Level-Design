package com.chandu.lld.atm.models;

import com.chandu.lld.atm.service.BankService;

public class ATM {
    private int atmId;
    private Address address;

    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private CashDeposit cashDeposit;
    private ChequeDeposit chequeDeposit;
    private Printer printer;

    private BankService bankService;
}
