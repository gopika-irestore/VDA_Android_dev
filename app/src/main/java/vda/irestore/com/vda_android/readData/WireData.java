package vda.irestore.com.vda_android.readData;

import java.util.ArrayList;

import vda.irestore.com.vda_android.Pojo.InspectionMetaData;

public class WireData {
    private static WireData wireData = null;

    public ArrayList<InspectionMetaData> primary_wireOne;
    public ArrayList<InspectionMetaData> primary_wireTwo;
    public ArrayList<InspectionMetaData> primary_wireThree;
    public ArrayList<InspectionMetaData> primary_wireFour;
    public ArrayList<InspectionMetaData> primary_wireFive;
    public ArrayList<InspectionMetaData> primary_wireSix;
    public ArrayList<InspectionMetaData> primary_wireSeven;
    public ArrayList<InspectionMetaData> primary_wireEight;
    public ArrayList<InspectionMetaData> primary_wireNine;
    public ArrayList<InspectionMetaData> primary_wireTen;

    public ArrayList<InspectionMetaData> secondary_wireOne;
    public ArrayList<InspectionMetaData> secondary_wireTwo;
    public ArrayList<InspectionMetaData> secondary_wireThree;
    public ArrayList<InspectionMetaData> secondary_wireFour;
    public ArrayList<InspectionMetaData> secondary_wireFive;
    public ArrayList<InspectionMetaData> secondary_wireSix;
    public ArrayList<InspectionMetaData> secondary_wireSeven;
    public ArrayList<InspectionMetaData> secondary_wireEight;
    public ArrayList<InspectionMetaData> secondary_wireNine;
    public ArrayList<InspectionMetaData> secondary_wireTen;


    public ArrayList<InspectionMetaData> service_wireOne;
    public ArrayList<InspectionMetaData> service_wireTwo;
    public ArrayList<InspectionMetaData> service_wireThree;
    public ArrayList<InspectionMetaData> service_wireFour;
    public ArrayList<InspectionMetaData> service_wireFive;
    public ArrayList<InspectionMetaData> service_wireSix;
    public ArrayList<InspectionMetaData> service_wireSeven;
    public ArrayList<InspectionMetaData> service_wireEight;
    public ArrayList<InspectionMetaData> service_wireNine;
    public ArrayList<InspectionMetaData> service_wireTen;

    private WireData() {
        initializeWirePrimary();
        initializeWireSecondary();
        initializeWireService();
    }
    private void initializeWirePrimary() {
        primary_wireOne = new ArrayList<>();
        primary_wireTwo = new ArrayList<>();
        primary_wireThree = new ArrayList<>();
        primary_wireFour = new ArrayList<>();
        primary_wireFive = new ArrayList<>();
        primary_wireSix = new ArrayList<>();
        primary_wireSeven = new ArrayList<>();
        primary_wireEight = new ArrayList<>();
        primary_wireNine = new ArrayList<>();
        primary_wireTen = new ArrayList<>();
    }

    private void initializeWireSecondary() {
        secondary_wireOne = new ArrayList<>();
        secondary_wireTwo = new ArrayList<>();
        secondary_wireThree = new ArrayList<>();
        secondary_wireFour = new ArrayList<>();
        secondary_wireFive = new ArrayList<>();
        secondary_wireSix = new ArrayList<>();
        secondary_wireSeven = new ArrayList<>();
        secondary_wireEight = new ArrayList<>();
        secondary_wireNine = new ArrayList<>();
        secondary_wireTen = new ArrayList<>();
    }


    private void initializeWireService() {
        service_wireOne = new ArrayList<>();
        service_wireTwo = new ArrayList<>();
        service_wireThree = new ArrayList<>();
        service_wireFour = new ArrayList<>();
        service_wireFive = new ArrayList<>();
        service_wireSix = new ArrayList<>();
        service_wireSeven = new ArrayList<>();
        service_wireEight = new ArrayList<>();
        service_wireNine = new ArrayList<>();
        service_wireTen = new ArrayList<>();
    }

    public static synchronized WireData getInstance(){
        if(wireData == null)
            wireData = new WireData();
        else
            return wireData;
        return wireData;
    }
}
