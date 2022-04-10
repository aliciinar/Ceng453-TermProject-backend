package com.Spaces.TitleDeeds;

import com.Spaces.Player;
import com.Spaces.SpaceAbstractClass;
import com.Spaces.TitleDeeds.SaleStates.ISaleState;

public class TitleDeed extends SpaceAbstractClass {

    protected Player owner = null;
    protected ISaleState state;

    @Override
    public void action(Player player) {
            state.titleDeedAction(player,this);
    }



    public  Player getOwner(){
        return  owner;
    }

    public   void setOwner(Player player)
    {
        owner = player;
    }

    public  void  setState(ISaleState state){
        this.state = state;
    }
}
