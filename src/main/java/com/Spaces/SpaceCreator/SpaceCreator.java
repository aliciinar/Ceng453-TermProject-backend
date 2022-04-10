package com.Spaces.SpaceCreator;

public class SpaceCreator {

    private String[] propertyNames = new String[]{
            "Istanbul",
            "Ankara",
            "Antalya1",
            "Izmir",
            "Samsun",
            "Aydın",
            "Kocaeli",
            "Edirne",
            "Denizli",
            "Alanya",
            "Eskişehir",
            "Muğla"
    };

    private  String[] railRoadNames = new String[]{

            "Marmaray","a","b","c"
    };

    private  String[] ferryPortNames = new String[]{ "d","e","f","g"};

    public  SpaceCreator(CreationStrategy strategy){

        strategy.setSpaces(propertyNames,railRoadNames,ferryPortNames);
    }
}
