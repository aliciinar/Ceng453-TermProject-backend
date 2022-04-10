package com.Spaces.TitleDeeds;

import com.Spaces.TitleDeeds.SaleStates.NotSaledStateProperties;
import com.Spaces.TitleDeeds.SaleStates.NotSaledStateRailRoad;

public class RailRoad  extends  TitleDeed{

    public  RailRoad(String name){
       this.name = name;
       this.price = 250;
        state = new NotSaledStateRailRoad();
    }
}
