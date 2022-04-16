package com.Spaces.PurchasableSpace;

import com.Player.IPlayer;

public interface SpaceState {

    SpaceState Action(IPlayer playingPlayer , SpaceDeed space);

}
