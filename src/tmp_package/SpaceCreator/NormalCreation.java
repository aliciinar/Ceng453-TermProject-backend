package com.Spaces.SpaceCreator;

import com.Managers.SpaceManager;
import com.Spaces.ISpace;
import com.Spaces.NotPurchasableSpace.GoJail;
import com.Spaces.NotPurchasableSpace.IncomeTax;
import com.Spaces.NotPurchasableSpace.JailVisit;
import com.Spaces.NotPurchasableSpace.StartingPoint;
import com.Spaces.PurchasableSpace.FerryPort;
import com.Spaces.PurchasableSpace.Properties;
import com.Spaces.PurchasableSpace.RailRoad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class NormalCreation extends  CreationStrategy{


    public  void setSpaces(String[] propertyNames,String[] railRoadNames,String[] ferryPortNames ){
        //ISpace railRoad =  new RailRoad()0;
        HashMap<Integer, ISpace> spaces = new HashMap<>(); // hash map for storing spaces
        List<Integer> usedIndexes = new ArrayList<>(); // array for storing usedIndexes
        ISpace startingPoint = new StartingPoint(); // starting Point
        spaces.put(0,startingPoint);
        usedIndexes.add(0);
        ISpace jailVisit = new JailVisit(); // jail Visit
        spaces.put(5,jailVisit);
        usedIndexes.add(5);
        ISpace goJail = new GoJail(0); // jail
        spaces.put(15,goJail);
        usedIndexes.add(15);

        AddProperties(usedIndexes,spaces); // Add Properties
        AddRailRoadFerryPort(usedIndexes,spaces); // Add railRoads and FerryPorts
        AddIncomeTax(usedIndexes,spaces); // Add IncomeTax
        DeConstructor();


    }
    private  void AddProperties(List<Integer> usedIndexes,HashMap<Integer,ISpace> spaces){
        Random rand = new Random();
        List<Integer> usedPropertiesNames = new ArrayList<>(); // store already used names indexes
        int index; // index of the property in board
        int propertyName; // index of
        int initialCost = 100; // initial cost of properties

        for( int i =0; i < 12; i++){
            index = FindEmptySpace(usedIndexes); // find empty place from board
            usedIndexes.add(index);
            propertyName = rand.nextInt(12);
            while (usedPropertiesNames.contains(propertyName)){
                propertyName = rand.nextInt(12);
            }
            usedPropertiesNames.add(propertyName);
            ISpace property = new Properties(propertyNames[propertyName], propertyPriceCheck(100 * (1 + i/10)));
            spaces.put(index,property);
        }
    }

    private  int FindEmptySpace(List<Integer> usedIndexes){
        Random rand = new Random();
        int index = rand.nextInt(20);
        while (usedIndexes.contains(index)){
            index = rand.nextInt(20);
        }
        usedIndexes.add(index);
        return  index;
    }
    private  int  propertyPriceCheck(int price){ // check whether properties price is bigger than 500 or not
        if(price > 500){
            return  500;
        }
        return price;
    }

    private  void  AddRailRoadFerryPort(List<Integer> usedIndexes,HashMap<Integer,ISpace> spaces){

        int determiner; // if determiner equal to zero add rail else add ferry port
        Random rand = new Random();
        List<Integer> usedFerryNames= new ArrayList<>();
        List<Integer> usedRailNames = new ArrayList<>();
        int index;
        int nameIndex;
        for(int i=0;  i< 4; i++){
            determiner = rand.nextInt(2);
            if(determiner == 0){
                index = FindEmptySpace(usedIndexes);
                nameIndex = rand.nextInt(4);
                while (usedRailNames.contains(nameIndex)){
                    nameIndex = rand.nextInt(4);
                }
                ISpace railRoad = new RailRoad(railRoadNames[nameIndex] );
                spaces.put(index,railRoad);
            }else{
                index = FindEmptySpace(usedIndexes);
                nameIndex = rand.nextInt(4);
                while (usedFerryNames.contains(nameIndex)){
                    nameIndex = rand.nextInt(4);
                }
                ISpace ferryPort = new FerryPort(ferryPortNames[nameIndex] );
                spaces.put(index,ferryPort);
            }
        }

    }

    private  void  AddIncomeTax(List<Integer> usedIndexes,HashMap<Integer,ISpace> spaces){

        for(int i = 0; i < 20; i++){
            if(!usedIndexes.contains(i)){
                ISpace incomeTax = new IncomeTax(0);
                spaces.put(i,incomeTax);
            }
        }
    }

    private  void  SetSpaceArray(HashMap<Integer,ISpace> spaces){
        ISpace[] spacesArray = new ISpace[20];

        for(int i=0; i < 20; i++){
            spacesArray[i] =  spaces.get(spaces);
        }
        SpaceManager.getInstance().SetSpaces(spacesArray);

    }

    private  void  DeConstructor(){
        propertyNames = null ;
        railRoadNames = null;
        ferryPortNames = null;
    }
}
