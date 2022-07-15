package com.chandu.lld.atm.service;

import com.chandu.lld.atm.models.CardInfo;
import com.chandu.lld.atm.models.Customer;
import com.chandu.lld.atm.models.Transaction;
import com.chandu.lld.atm.models.TransactionDetail;

public interface BankService {
    boolean authenticateUser(int pin, CardInfo cardInfo);

    Customer getCustomerDetails(CardInfo cardInfo);

    TransactionDetail executeTransaction(Transaction transaction);
}
