package com.Spaces;

public abstract class AbstractSpace implements Space {

    protected String name;
    protected int position;

    @Override
    public String getName() {
        return name;
    }
    public int GetPosition(){return position;}

}
