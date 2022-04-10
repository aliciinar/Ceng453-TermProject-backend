package com.Spaces.TitleDeeds;

import com.Spaces.TitleDeeds.SaleStates.NotSaledStateProperties;

public class Properties extends  TitleDeed{

    public  Properties(String name, int price){
        this.name  = name;
        this.price = price;
        state = new NotSaledStateProperties();
    }
}
