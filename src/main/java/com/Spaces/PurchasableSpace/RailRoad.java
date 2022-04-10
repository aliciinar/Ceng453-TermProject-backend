package com.Spaces.PurchasableSpace;

import com.Player.Player;


public class RailRoad  extends SpaceDeed {

    public  RailRoad(String name , int cost , int rent , int position){
       this.name = name;
       this.rent = rent;
       this.cost = cost;
       this.position = position;
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
