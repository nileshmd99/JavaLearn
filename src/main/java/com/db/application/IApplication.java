package com.db.application;

public interface IApplication {
    String getVersion();

    double deposit(String accountId, double amount);

    double withdraw(String accountiId, double amount);
}