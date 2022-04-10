package com.Spaces;

import com.Player.Player;
import com.Spaces.NotPurchasableSpace.IncomeTax;
import com.Spaces.PurchasableSpace.FerryPort;
import com.Spaces.PurchasableSpace.RailRoad;

public class UnitTestSpaces {

    public static void main(String[] args) {
        Space testRR = new RailRoad("1",250 , 100 ,0);
        Space testFP = new FerryPort("2",75 ,100 ,0);
        Space tax = new IncomeTax(0);

        Player player1 = new Player();
        Player player2 = new Player();

        testRR.action(player1);

        System.out.println(player1.GetMoney());
        System.out.println(player2.GetMoney());

        testRR.action(player2);
        System.out.println(player1.GetMoney());
        System.out.println(player2.GetMoney());

        testFP.action(player1);
        System.out.println(player1.GetMoney());
        System.out.println(player2.GetMoney());

        testFP.action(player2);
        System.out.println(player1.GetMoney());
        System.out.println(player2.GetMoney());

        tax.action(player2);
        System.out.println(player1.GetMoney());
        System.out.println(player2.GetMoney());


    }
}
