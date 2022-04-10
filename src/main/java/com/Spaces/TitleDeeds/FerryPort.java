package com.Spaces.TitleDeeds;

import com.Spaces.TitleDeeds.SaleStates.NotSaledStateFerryPort;

public class FerryPort extends  TitleDeed{

    public FerryPort(String name){
        this.name = name;
        this.price = 250;
        state = new NotSaledStateFerryPort();
    }


}
