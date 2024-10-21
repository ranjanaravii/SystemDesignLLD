package com.developer.LLD.DigitalWallet.Dao;

import com.developer.LLD.DigitalWallet.model.Account;

import java.util.HashMap;
import java.util.Map;

public class WalletDao {
    private Map<Integer, Account> accountMap;

    public WalletDao() {
        this.accountMap = new HashMap<>();
    }

    public Map<Integer, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<Integer, Account> accountMap) {
        this.accountMap = accountMap;
    }
}
