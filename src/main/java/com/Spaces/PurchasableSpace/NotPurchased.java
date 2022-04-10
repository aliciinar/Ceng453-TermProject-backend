package com.Spaces.PurchasableSpace;

import com.Player.Player;
import com.Spaces.Space;

public class NotPurchased implements SpaceState{
    @Override
    public SpaceState Action(Player player , SpaceDeed space) {

        boolean purchase = true;
        //Get Action From Player via GUI
        if(purchase) {
            space.Purchase(player , - space.GetCost());
            return new Purchased();
        }
        else return this;

    }
}
