package com.Spaces.TitleDeeds.SaleStates;

import com.Spaces.Player;
import com.Spaces.TitleDeeds.TitleDeed;

public class NotSaledStateProperties implements  ISaleState{

    @Override
    public void titleDeedAction(Player playingPlayer, TitleDeed titleDeed) {
        // ask whether to buy something or not
        // if comfirm to buy change state;
    }

    private  void  ChangeState(TitleDeed titleDeed,Player owner)
    {
        titleDeed.setState(new SaledStateProperties());
        titleDeed.setOwner(owner);
    }
}
