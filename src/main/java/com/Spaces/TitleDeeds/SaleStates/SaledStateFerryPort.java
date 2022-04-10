package com.Spaces.TitleDeeds.SaleStates;

import com.Spaces.Player;
import com.Spaces.TitleDeeds.TitleDeed;

public class SaledStateFerryPort implements  ISaleState{
    @Override
    public void titleDeedAction( Player playingPlayer, TitleDeed titleDeed) {
        // increase owner money titleDeed.getOwner according to the ferry count
        // decrease playingPlayer money

    }
}
