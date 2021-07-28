package com.db.application;

public class GoldApplicationImpl extends ApplicationImpl {
    public GoldApplicationImpl() {
        super();
        System.out.println("Constructor Called");
    }

    @Override
    public double deposit(String accountid, double amount) {
        return super.deposit(accountid, amount);
    }

    @Override
    public String getVersion() {
        return "Gold " + super.getVersion();
    }
}
