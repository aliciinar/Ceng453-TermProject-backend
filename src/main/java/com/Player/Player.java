package com.Player;

import java.util.*;

public class Player extends  PlayerAbstract{


    @Override
    public boolean purchaseSpace(int spacePrice) {
        System.out.print("If u want to but write y");

        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        if(str.equals('y')){
            return  true;
        }
        return  false;
    }
}
