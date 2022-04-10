package com.Spaces.NotPurchasableSpace;
import com.Player.Player;
import com.Spaces.AbstractSpace;

public class StartingPoint extends AbstractSpace {


    public  StartingPoint(int pos){
        position = pos;
        name = "StartingPoint";
    }
    @Override
    public void action(Player player) {

    }
}
