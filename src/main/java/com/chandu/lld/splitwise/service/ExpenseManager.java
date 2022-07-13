package com.chandu.lld.splitwise.service;

import com.chandu.lld.splitwise.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private List<Expense> expenses;
    private Map<String, User> userMap;
    private Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
        balanceSheet.put(user.getUserId(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        Expense expense = ExpenseService.createExpense(expenseType, amount, paidBy, splits, expenseMetadata);
        expenses.add(expense);
        for (Split split : splits) {
            String paidTo = split.getUser().getUserId();
            Map<String, Double> balance = balanceSheet.get(paidBy.getUserId());
            balance.put(paidTo, balance.getOrDefault(paidTo, 0.0) + split.getAmount());
            balance = balanceSheet.get(paidTo);
            balance.put(paidBy.getUserId(), balance.getOrDefault(paidBy.getUserId(), 0.0) - split.getAmount());
        }
    }

    public void showBalance(String userId) {
        boolean noDue = false;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                noDue = true;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }
        if (noDue)
            System.out.println("No Balances");
    }

    public void showBalances() {
        boolean noDue = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    noDue = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }
        if (noDue)
            System.out.println("No balances");
    }

    private void printBalance(String user1, String user2, double amount) {
        String userName1 = userMap.get(user1).getName();
        String userName2 = userMap.get(user2).getName();
        if (amount < 0)
            System.out.println(userName1 + " owes " + userName2 + ": " + Math.abs(amount));
        else if (amount > 0)
            System.out.println(userName2 + " owes " + userName1 + ": " + Math.abs(amount));
    }
}
