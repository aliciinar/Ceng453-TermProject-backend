package com.Spaces.SpaceCreator;

public abstract class CreationStrategy {

    protected  String[] propertyNames  = new String[12];
    protected  String[] railRoadNames = new String[4];
    protected   String[] ferryPortNames = new String[4];

    public abstract void setSpaces(String[] propertyNames,String[] railRoadNames,String[] ferryPortNames);

}
