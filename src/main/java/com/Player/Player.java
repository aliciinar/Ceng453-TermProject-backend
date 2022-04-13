package com.Player;


import com.Spaces.Space;
import java.util.List;

public class Player {


    private int playerID;
    private int position;
    private int money;
    private PlayerState state;
    private int ownedSpecialTile = 0;
    List<Space> spaces;


    public Player(int playerID , List<Space> spaces){

        this.playerID = playerID;
        this.position = 0;
        this.money = 1500;
        this.state = new PlayerNotPrison();
        this.spaces = spaces;
    }

    public int GetMoney() {
        return money;
    }

    public void GoJail(int pos){
        this.state = new PlayerPrison();
        this.position = pos;
    }

    public void PurchaseSpecialTile(){
        ownedSpecialTile = ownedSpecialTile + 1;
    }

    public int GetNumOfSpecialTile(){
        return ownedSpecialTile;
    }

    public void MoneyTransition(int amount){
        money = money + amount;
    }

    protected void MovePlayer(int move){
            if(position + move >= 20 ) MoneyTransition(1500);
            position = (position + move) / 20;

            this.spaces.get(position).action(this);

    }

    public boolean Turn(){

        boolean doubleDice;

        doubleDice = state.Play(this );

        if(doubleDice) Turn();
        else state = state.EndPlay();

        return money >= 0 ;
    }


}
