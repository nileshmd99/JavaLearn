package com.db.application;

/**
 * @author Nilesh
 * @version 1.0
 */
public class ApplicationImpl implements IApplication {
    private double balance = 0;
    @Override
    public String getVersion() {
        return "1.0";
    }
    @Override
    public double deposit(String accountid, double amount) {
        return balance + amount;
    }
    @Override
    public double withdraw(String accountid, double amount) {
        return balance - amount;
    }
}
