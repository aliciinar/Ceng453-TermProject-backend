package com.Spaces;
import com.Player.IPlayer;
import com.Player.Player;
public interface Space {

    void  action(IPlayer player); // when a player comes  a space do some action
    int GetPosition();
    String getName();
}
