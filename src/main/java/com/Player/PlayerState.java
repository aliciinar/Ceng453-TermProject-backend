package com.Player;

import com.Spaces.Space;

import java.util.List;

public interface PlayerState {

    boolean Play(IPlayer player );
    PlayerState EndPlay();


}
