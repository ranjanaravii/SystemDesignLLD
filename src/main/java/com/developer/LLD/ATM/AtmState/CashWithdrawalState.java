package com.developer.LLD.ATM.AtmState;

import com.developer.LLD.ATM.AmoutWithdrawal.CashWithdrawProcessor;
import com.developer.LLD.ATM.AmoutWithdrawal.FiveHundredWithdrawProcessor;
import com.developer.LLD.ATM.AmoutWithdrawal.OneHundredWithdrawProcessor;
import com.developer.LLD.ATM.AmoutWithdrawal.TwoThousandWithdrawProcessor;
import com.developer.LLD.ATM.Atm;
import com.developer.LLD.ATM.Card;

public class CashWithdrawalState extends AtmState {
    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    public void cashWithdrawal(Atm atm, Card card, int amount) {
        if (atm.getAtmBalance() < amount) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atm);
        } else if (card.getBankBalance() < amount) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atm);
        }else {
            card.deductBalance(amount);
            atm.deductATMBalance(amount);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atm, amount);
            exit(atm);

        }
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setAtmCurrentState(new IdleState());
        System.out.println("Exit happens!");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
