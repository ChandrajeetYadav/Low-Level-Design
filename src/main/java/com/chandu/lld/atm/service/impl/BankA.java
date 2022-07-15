package com.chandu.lld.atm.service.impl;

import com.chandu.lld.atm.models.CardInfo;
import com.chandu.lld.atm.models.Customer;
import com.chandu.lld.atm.models.Transaction;
import com.chandu.lld.atm.models.TransactionDetail;
import com.chandu.lld.atm.service.BankService;

public class BankA implements BankService {
    @Override
    public boolean authenticateUser(int pin, CardInfo cardInfo) {
        return false;
    }

    @Override
    public Customer getCustomerDetails(CardInfo cardInfo) {
        return null;
    }

    @Override
    public TransactionDetail executeTransaction(Transaction transaction) {
        return null;
    }
}
