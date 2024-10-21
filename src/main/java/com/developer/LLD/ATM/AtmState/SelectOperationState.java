package com.developer.LLD.ATM.AtmState;

import com.developer.LLD.ATM.Atm;
import com.developer.LLD.ATM.Card;
import com.developer.LLD.ATM.TransactionType;

public class SelectOperationState extends AtmState {

    public SelectOperationState() {
        showOperations();
    }

    @Override
    public void selectOperation(Atm atm, Card card, TransactionType txnType) {

        switch (txnType) {
            case CASH_WITHDRAWAL:
                atm.setAtmCurrentState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setAtmCurrentState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setAtmCurrentState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }


    private void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();

    }
}
