package com.Spaces.TitleDeeds.SaleStates;

import com.Spaces.Player;
import com.Spaces.TitleDeeds.TitleDeed;

public class SaledStateRailRoad implements  ISaleState{
    @Override
    public void titleDeedAction( Player playingPlayer, TitleDeed titleDeed) {
        // increase owner money titleDeed.getOwner according to the rail count
        // decrease playingPlayer money

    }
}
