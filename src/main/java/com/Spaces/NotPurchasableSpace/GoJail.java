package com.Spaces.NotPurchasableSpace;
import com.Player.Player;
import com.Spaces.AbstractSpace;


public class GoJail  extends AbstractSpace {

    private final int jailLocation = 0;

    public GoJail(int pos ) {
        name = "GoJail";
        position = pos;
    }

    @Override
    public void action(Player player) {
        player.GoJail(jailLocation);
    }
}
