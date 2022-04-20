package com.frontend.Spaces;

import com.frontend.Managers.SpaceManager;
import com.frontend.Spaces.NotPurchasableSpace.GoJail;
import com.frontend.Spaces.NotPurchasableSpace.IncomeTax;
import com.frontend.Spaces.NotPurchasableSpace.JailVisit;
import com.frontend.Spaces.NotPurchasableSpace.StartingPoint;
import com.frontend.Spaces.PurchasableSpace.FerryPort;
import com.frontend.Spaces.PurchasableSpace.Properties;
import com.frontend.Spaces.PurchasableSpace.RailRoad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class test {

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
    private void  setCards()
    {

        //ISpace railRoad =  new RailRoad()0;
        HashMap<Integer,ISpace> spaces = new HashMap<>(); // hash map for storing spaces
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
}
