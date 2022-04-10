package com.Spaces.NormalSpaces;

import com.Spaces.Player;

public class JailVisit extends  NormalSpace{

    public  JailVisit(){
        name = "JailVisit";
        price = 0;
    }
    @Override
    public void action(Player player) {
        // player is visiting jail. do nothing
    }
}
