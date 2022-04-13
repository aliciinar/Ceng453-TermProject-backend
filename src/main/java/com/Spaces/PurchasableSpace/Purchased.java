package com.Spaces.PurchasableSpace;

import com.Player.IPlayer;
import com.Player.Player;

public class Purchased implements SpaceState{

    @Override
    public SpaceState Action(IPlayer player , SpaceDeed space) {

        if(player.equals(space.GetOwner())) return this;

        int rent = space.GetRent();

        player.moneyTransition(-rent);
        space.GetOwner().moneyTransition(rent);
        return this;
    }

}
