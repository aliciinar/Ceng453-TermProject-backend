package com.Spaces.NotPurchasableSpace;
import com.Player.IPlayer;
import com.Player.Player;
import com.Spaces.AbstractSpace;

public class StartingPoint extends AbstractSpace {


    public  StartingPoint(String name ,int pos ){
        position = pos;
        this.name = name;
    }
    @Override
    public void action(IPlayer player) {

    }
}
