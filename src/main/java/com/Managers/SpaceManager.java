package com.Managers;

import com.Spaces.ISpace;

public class SpaceManager {

    private  static  SpaceManager instance = null;
    private ISpace[] spaces = new ISpace[20];
    public  static  synchronized  SpaceManager getInstance(){
        if(instance == null){
            instance = new SpaceManager();
        }
        return  instance;
    }

    public  void  SetSpaces(ISpace[] spaces){
        this.spaces = spaces;
    }

}
