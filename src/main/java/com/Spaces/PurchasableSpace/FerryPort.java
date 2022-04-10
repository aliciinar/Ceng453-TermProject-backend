package com.Spaces.PurchasableSpace;

import com.Player.Player;


public class FerryPort extends SpaceDeed {


    public FerryPort(String name , int cost , int rent , int position){
        this.name = name;
        this.rent = rent;
        this.position = position;
        this.cost = cost;
        state = new NotPurchased();
    }

    @Override
    public void action(Player player) {
        state = state.Action(player , this);
    }

    public void Purchase(Player player , int cost){
        player.MoneyTransition(cost);
        player.PurchaseSpecialTile();
        setOwner(player);
        this.rent = player.GetNumOfSpecialTile() * rent;
    }

}
