package com.developer.LLD.ATM;

public class AtmAndUser {
    Atm atm;
    User user;
    public static void main(String[] args) {
        AtmAndUser atmAndUser = new AtmAndUser();
        atmAndUser.initialize();
        atmAndUser.atm.printCurrentATMStatus();
        atmAndUser.atm.getAtmCurrentState().insertCard(atmAndUser.atm, atmAndUser.user.card);
        atmAndUser.atm.getAtmCurrentState().authenticatePin(atmAndUser.atm, atmAndUser.user.card, 1234);
        atmAndUser.atm.getAtmCurrentState().selectOperation(atmAndUser.atm, atmAndUser.user.card, TransactionType.CASH_WITHDRAWAL);
        atmAndUser.atm.getAtmCurrentState().cashWithdrawal(atmAndUser.atm, atmAndUser.user.card, 50000);
        atmAndUser.atm.getAtmCurrentState().displayBalance(atmAndUser.atm, atmAndUser.user.card);
        atmAndUser.atm.printCurrentATMStatus();

    }

    private void initialize() {

        //Create atm
        atm = Atm.getInstance();
        atm.setAtmBalance(30000, 10, 10, 50);

        //Create user
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){

        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 30000;

        return bankAccount;

    }

}
