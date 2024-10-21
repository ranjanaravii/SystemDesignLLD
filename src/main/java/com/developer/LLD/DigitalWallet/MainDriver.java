package com.developer.LLD.DigitalWallet;

import com.developer.LLD.DigitalWallet.Service.WalletService;

import java.util.Scanner;

public class MainDriver {
    public static void main(String[] args) {
        WalletService walletService = new WalletService();
        Scanner sc = new Scanner(System.in);
        outer: while (true) {
            System.out.println("\nOPTIONS:");
            System.out.println("1. Create wallet");
            System.out.println("2. Transfer Amount");
            System.out.println("3. Account Statement");
            System.out.println("4. Overview");
            System.out.println("5. Exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("YOU SELECTED CREATE WALLET");
                    System.out.println("Enter name");
                    String name = sc.next();
                    System.out.println("Enter email:");
                    String email = sc.next();
                    System.out.println("Enter PhoneNumber:");
                    String phoneNumber = sc.next();
                    System.out.println("Enter initial amount");
                    double amount = sc.nextDouble();
                    walletService.createWallet(name, email, phoneNumber, amount);
                    break;
                case 2:
                    System.out.println("YOU SELECTED TRANSFER");
                    System.out.println("Enter SENDER account number");
                    int from = sc.nextInt();
                    if (!walletService.getWalletDao().getAccountMap().containsKey(from)) {
                        System.out.println("Invalid Sender account number");
                        break;
                    }
                    System.out.println("Enter RECEIVER account number");
                    int to = sc.nextInt();
                    if (!walletService.getWalletDao().getAccountMap().containsKey(to)) {
                        System.out.println("Invalid receiver account number");
                        break;
                    }
                    System.out.println("Enter transfer amount");
                    double amount1 = sc.nextDouble();
                    walletService.transfer(from, to, amount1);
                    break;
                case 3:
                    System.out.println("YOU SELECTED ACCOUNT STATEMENT");
                    System.out.println("Enter Account Number");
                    walletService.statement(sc.nextInt());
                    break;
                case 4:
                    System.out.println("YOU SELECTED OVERVIEW");
                    walletService.overview();
                    break;
                case 5:
                    System.out.println("APPLICATION STOPPED");
                    break outer;
                default:
                    System.out.println("YOU HAVE SELECTED INVALID OPTION. PLEASE REENTER");
                    break;
            }
        }
    }
}
