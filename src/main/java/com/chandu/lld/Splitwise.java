package com.chandu.lld;

import com.chandu.lld.splitwise.models.*;
import com.chandu.lld.splitwise.service.ExpenseManager;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    public static void main(String[] args) {
        User u1 = new User("u1", "Kundan", "kundan@gmail.com");
        User u2 = new User("u2", "Swaraj", "swaraj@gmail.com");
        User u3 = new User("u3", "Abhinav", "abhinav@gmail.com");
        User u4 = new User("u4", "Anshil", "anshil@gmail.com");
        User u5 = new User("u5", "Saket", "saket@gmail.com");

        ExpenseManager expenseManager = new ExpenseManager();
        expenseManager.addUser(u1);
        expenseManager.addUser(u2);
        expenseManager.addUser(u3);
        expenseManager.addUser(u4);
        expenseManager.addUser(u5);

        List<Split> splits = new ArrayList<>();
        splits.add(new EqualSplit(u1));
        splits.add(new EqualSplit(u2));
        splits.add(new EqualSplit(u3));
        splits.add(new EqualSplit(u4));
        ExpenseMetadata expenseMetadata = new ExpenseMetadata("Subway", "dummy", "Subway Food");
        expenseManager.addExpense(ExpenseType.EQUAL, 1000, u1, splits, expenseMetadata);
        expenseManager.showBalances();


        System.out.println("======================================================================");

        splits = new ArrayList<>();
        splits.add(new ExactSplit(u2, 400));
        splits.add(new ExactSplit(u3, 200));
        expenseMetadata = new ExpenseMetadata("Movie", "dummy", "Thor Love and War");
        expenseManager.addExpense(ExpenseType.EXACT, 600, u1, splits, expenseMetadata);
        expenseManager.showBalances();

        System.out.println("======================================================================");

        splits = new ArrayList<>();
        splits.add(new PercentSplit(u1, 30));
        splits.add(new PercentSplit(u2, 25));
        splits.add(new PercentSplit(u3, 30));
        splits.add(new PercentSplit(u4, 15));
        expenseMetadata = new ExpenseMetadata("Dinner", "dummy", "Barbeque Nation");
        expenseManager.addExpense(ExpenseType.PERCENT, 1000, u4, splits, expenseMetadata);
        expenseManager.showBalances();
    }
}
