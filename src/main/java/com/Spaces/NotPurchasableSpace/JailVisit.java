package com.Spaces.NotPurchasableSpace;

import com.Player.Player;
import com.Spaces.AbstractSpace;

public class JailVisit extends AbstractSpace {

    public  JailVisit(String name ,int pos ){
        this.name = name;
        position = pos;
    }
    @Override
    public void action(Player player) {
    }
}
