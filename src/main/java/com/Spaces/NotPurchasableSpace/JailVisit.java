package com.Spaces.NotPurchasableSpace;

import com.Player.Player;
import com.Spaces.AbstractSpace;

public class JailVisit extends AbstractSpace {

    public  JailVisit(int pos){
        name = "JailVisit";
        position = pos;
    }
    @Override
    public void action(Player player) {
    }
}
