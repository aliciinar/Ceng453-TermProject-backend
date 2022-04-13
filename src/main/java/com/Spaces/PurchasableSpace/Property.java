package com.Spaces.PurchasableSpace;

import com.Player.IPlayer;
import com.Player.Player;


public class Property extends SpaceDeed {

    public Property(String name , int cost , int rent , int position){
        this.name = name;
        this.rent = rent;
        this.position = position;
        this.cost = cost;
        state = new NotPurchased();
    }

    @Override
    public void action(IPlayer player) {
        state = state.Action(player , this);
    }

    public void Purchase(IPlayer player , int cost){
        player.moneyTransition(cost);
        player.purchaseSpecialTile();
        setOwner(player);

    }

}
