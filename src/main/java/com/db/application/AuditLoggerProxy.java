package com.db.application;

public class AuditLoggerProxy implements IApplication {
    IApplication target = null;

    public AuditLoggerProxy(IApplication target) {
        this.target = target;
    }

    @Override
    public String getVersion() {
        System.out.println("Before Get Version");
        return target.getVersion();
    }

    @Override
    public double deposit(String accountId, double amount) {
        System.out.println("Beofore deposit i can do all the audit");
        double returnValue = target.deposit(accountId, amount);
        System.out.println("After Target call i can do more audit ");
        return returnValue;
    }

    @Override
    public double withdraw(String accountiId, double amount) {
        System.out.println("Before Withdraw i can do all the audit then call target ");
        return withdraw(accountiId, amount);
    }
}
