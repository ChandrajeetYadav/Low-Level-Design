package com.chandu.lld.splitwise.models;

import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    public boolean validate() {
        double totalPercent = 100;
        double splitPercent = 0;
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit))
                return false;
            splitPercent += ((PercentSplit) split).getPercent();
        }
        return splitPercent == totalPercent;
    }
}
