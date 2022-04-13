package com.Player;
import com.Spaces.Space;
import com.utils.Dices;

import java.util.List;

public class PlayerNotPrison implements PlayerState{

    private int diceThrow;

    PlayerNotPrison(){
        diceThrow = 2;
    }

    @Override
    public boolean Play(Player player ) {

        if(diceThrow == 0) return false;

        int[] dices ;

        dices = Dices.throwDice() ;

        player.MovePlayer(dices[0]);

        if (dices[1] == 0) {
            diceThrow = diceThrow - 1;
            return true ;
        }
        else {
            return false ;
        }

    }

    @Override
    public PlayerState EndPlay(){
        System.out.println(diceThrow);
        if (diceThrow > 0) {
            diceThrow = 2 ;
            return this ;
        }
        else return new PlayerPrison() ;
    }

    private void GetCardIndex(int pos){

    }


}
