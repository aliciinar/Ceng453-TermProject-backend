package com.Spaces.NotPurchasableSpace;
import com.Player.Player;
import com.Spaces.AbstractSpace;


public class GoJail  extends AbstractSpace {

    private final int jailLocation = 0;

    public GoJail(String name ,int pos  ) {
        this.name = name;
        this.position = pos;
    }

    @Override
    public void action(Player player) {
        player.GoJail(jailLocation);
    }
}
