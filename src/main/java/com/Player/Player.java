package com.Player;

public class Player {

    private int position;
    private int money;
    private PlayerState state;
    private int ownedSpecialTile = 0;

    public Player(){
        position = 0;
        money = 1500;
        state = new PlayerNotPrison();
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
    }

    public boolean Turn(){

        boolean doubleDice;

        doubleDice = state.Play(this);

        if(doubleDice) Turn();
        else state = state.EndPlay();

        return money >= 0 ;
    }


}
