package com.Spaces.PurchasableSpace;

import com.Player.IPlayer;
import com.Player.Player;
import com.Spaces.Space;

public interface SpaceState {

    SpaceState Action(IPlayer playingPlayer , SpaceDeed space);

}
