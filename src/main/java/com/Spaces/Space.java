package com.Spaces;
import com.Player.Player;
public interface Space {

    void  action(Player player); // when a player comes  a space do some action
    int GetPosition();
    String getName();
}
