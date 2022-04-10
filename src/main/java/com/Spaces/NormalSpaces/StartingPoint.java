package com.Spaces.NormalSpaces;

import com.Spaces.NormalSpaces.NormalSpace;
import com.Spaces.Player;

public class StartingPoint extends NormalSpace {

    public  StartingPoint(){
        name = "StartingPoint";
        price = 100;
    }
    @Override
    public void action(Player player) {
        // increase player 100 dollar
    }
}
