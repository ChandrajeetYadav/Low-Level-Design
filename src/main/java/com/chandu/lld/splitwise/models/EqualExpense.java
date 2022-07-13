package com.chandu.lld.splitwise.models;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit))
                return false;
        }
        return true;
    }
}
