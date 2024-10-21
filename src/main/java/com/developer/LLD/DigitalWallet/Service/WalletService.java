package com.developer.LLD.DigitalWallet.Service;

import com.developer.LLD.DigitalWallet.Dao.WalletDao;
import com.developer.LLD.DigitalWallet.model.Account;
import com.developer.LLD.DigitalWallet.model.Transaction;

public class WalletService {

    private WalletDao walletDao;

    public WalletService() {
        this.walletDao = new WalletDao();
    }

    public void createWallet(String name, String email, String phoneNumber, double amount) {
        Account account = new Account(name, email, phoneNumber, amount);
        walletDao.getAccountMap().put(account.getAccountNumber(), account);
        System.out.println("Account created for user " + name + " with account number " + account.getAccountNumber());
    }

    public void transfer(int from, int to, double amount) {

        if (!validate(from, to, amount)) {
            return;
        }

        Transaction transaction = new Transaction(from, to, amount);
        Account fromAccount = walletDao.getAccountMap().get(from);
        Account toAccount = walletDao.getAccountMap().get(to);

        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient balance");
            return;
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        fromAccount.getTransactions().add(transaction);
        toAccount.getTransactions().add(transaction);
        System.out.println("Transfer Successful");

    }

    private boolean validate(int fromAccNum, int toAccNum, double transferAmount) {
        if(fromAccNum == toAccNum) {
            System.out.println("Sender and Receiver cannot be same.");
            return false;
        }
        if (transferAmount <= 0) {
            System.out.println("Amount too low");
            return false;
        }
        if (!walletDao.getAccountMap().containsKey(fromAccNum)) {
            System.out.println("Invalid Sender account number");
            return false;
        }
        if (!walletDao.getAccountMap().containsKey(toAccNum)) {
            System.out.println("Invalid Receiver account number");
            return false;
        }
        return true;
    }

    public void statement(int accountNum) {
        Account account = walletDao.getAccountMap().get(accountNum);
        if(account == null) {
            System.out.println("Invalid Account Number");
            return;
        }
        System.out.println("Summary for account number: " + accountNum);
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Your Transaction History");
        System.out.println(account.getTransactions());
    }
    public void overview() {
        for (int accNum : walletDao.getAccountMap().keySet()) {
            System.out.print("Balance for account number " + accNum + ": ");
            System.out.println(walletDao.getAccountMap().get(accNum).getBalance());
        }
    }

    public WalletDao getWalletDao() {
        return walletDao;
    }
}
