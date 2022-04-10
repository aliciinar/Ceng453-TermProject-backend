package com.Spaces.PurchasableSpace;

import com.Player.Player;
import com.Spaces.AbstractSpace;

abstract class SpaceDeed extends AbstractSpace {

    protected Player owner = null;
    protected SpaceState state;
    protected int rent;
    protected int cost;

    protected void setOwner(Player player){
        this.owner = player;
    }
    abstract public void Purchase(Player player , int cost);

    public int GetCost(){return cost;}
    public int GetRent(){
        return rent;
    }
    public Player GetOwner(){
        return owner;
    }

}
