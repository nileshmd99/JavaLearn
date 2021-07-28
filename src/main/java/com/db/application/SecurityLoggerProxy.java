package com.db.application;

public class SecurityLoggerProxy implements IApplication {
    IApplication target = null;

    public SecurityLoggerProxy(IApplication target) {
        this.target = target;
    }

    @Override
    public String getVersion() {
        System.out.println("Before Get Version");
        return target.getVersion();
    }

    @Override
    public double deposit(String accountId, double amount) {
        System.out.println("Check if user is Authenticated");
        return  target.deposit(accountId, amount);
    }

    @Override
    public double withdraw(String accountiId, double amount) {
        System.out.println("Before Withdraw i can do all the audit then call target ");
        return withdraw(accountiId, amount);
    }
}
