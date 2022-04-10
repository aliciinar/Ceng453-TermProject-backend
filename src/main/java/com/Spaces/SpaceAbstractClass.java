package com.Spaces;

public abstract class SpaceAbstractClass implements  ISpace{

    protected String name;
    protected int price;

    @Override
    public String getName() {
        return name;
    }
}
