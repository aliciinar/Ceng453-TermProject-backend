package com.Managers;

import com.Spaces.Space;

public class SpaceManager {

    private  static  SpaceManager instance = null;
    private Space[] spaces = new Space[20];
    public  static  synchronized  SpaceManager getInstance(){
        if(instance == null){
            instance = new SpaceManager();
        }
        return  instance;
    }

    public  void  SetSpaces(Space[] spaces){
        this.spaces = spaces;
    }

}
