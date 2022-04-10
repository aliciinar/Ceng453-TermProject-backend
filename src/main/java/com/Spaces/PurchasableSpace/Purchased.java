package com.Spaces.PurchasableSpace;

import com.Player.Player;
import com.Spaces.Space;

import javax.swing.*;

public class Purchased implements SpaceState{

    @Override
    public SpaceState Action(Player player , SpaceDeed space) {

        if(player.equals(space.GetOwner())) return this;

        int rent = space.GetRent();

        player.MoneyTransition(-rent);
        space.GetOwner().MoneyTransition(rent);
        return this;
    }

}
