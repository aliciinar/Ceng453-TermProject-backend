package com.Spaces.PurchasableSpace;

import com.Player.Player;
import com.Spaces.Space;

public interface SpaceState {

    SpaceState Action(Player playingPlayer , SpaceDeed space);

}
