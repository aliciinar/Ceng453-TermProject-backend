package com.Spaces.NotPurchasableSpace;
import com.Player.Player;
import com.Spaces.AbstractSpace;

public class IncomeTax extends AbstractSpace {

    private final int tax = -50;

    public  IncomeTax(int pos){
        name = "IncomeTax";
        position = pos;
    }

    @Override
    public void action(Player player) {
        player.MoneyTransition(tax);
    }
}
