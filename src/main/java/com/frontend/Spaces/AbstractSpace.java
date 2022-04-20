package com.frontend.Spaces;

public abstract class AbstractSpace implements ISpace {

    protected String name;
    protected int position;

    @Override
    public String getName() {
        return name;
    }
    public int GetPosition(){return position;}

}
