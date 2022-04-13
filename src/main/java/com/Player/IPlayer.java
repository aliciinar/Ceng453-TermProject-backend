package com.Player;

public interface IPlayer {

     int getMoney();

     void goJail(int pos);

     void purchaseSpecialTile();

     int getNumOfSpecialTile();

     void moneyTransition(int amount);

     boolean turn();

     boolean purchaseSpace(int spacePrice);
}
