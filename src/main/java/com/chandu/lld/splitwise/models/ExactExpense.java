package com.chandu.lld.splitwise.models;

import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    public boolean validate() {
        double totalAmount = getAmount();
        double splitAmount = 0;
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit))
                return false;
            splitAmount += split.getAmount();
        }
        return totalAmount == splitAmount;
    }
}
