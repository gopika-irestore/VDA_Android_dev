package vda.irestore.com.vda_android.readData;

import java.util.ArrayList;

import vda.irestore.com.vda_android.Pojo.InspectionMetaData;


/**
 * Created by Malbel Technologies on 13-12-2017.
 */

public class PoleData {

    private static PoleData poleData = null;

    public ArrayList<InspectionMetaData> poleOne;
    public ArrayList<InspectionMetaData> poleTwo;
    public ArrayList<InspectionMetaData> poleThree;
    public ArrayList<InspectionMetaData> poleFour;
    public ArrayList<InspectionMetaData> poleFive;
    public ArrayList<InspectionMetaData> poleSix;
    public ArrayList<InspectionMetaData> poleSeven;
    public ArrayList<InspectionMetaData> poleEight;
    public ArrayList<InspectionMetaData> poleNine;
    public ArrayList<InspectionMetaData> poleTen;

    public ArrayList<InspectionMetaData> guyWireOne;
    public ArrayList<InspectionMetaData> guyWireTwo;
    public ArrayList<InspectionMetaData> guyWireThree;
    public ArrayList<InspectionMetaData> guyWireFour;
    public ArrayList<InspectionMetaData> guyWireFive;
    public ArrayList<InspectionMetaData> guyWireSix;
    public ArrayList<InspectionMetaData> guyWireSeven;
    public ArrayList<InspectionMetaData> guyWireEight;
    public ArrayList<InspectionMetaData> guyWireNine;
    public ArrayList<InspectionMetaData> guyWireTen;

    public ArrayList<InspectionMetaData> anchorOne;
    public ArrayList<InspectionMetaData> anchorTwo;
    public ArrayList<InspectionMetaData> anchorThree;
    public ArrayList<InspectionMetaData> anchorFour;
    public ArrayList<InspectionMetaData> anchorFive;
    public ArrayList<InspectionMetaData> anchorSix;
    public ArrayList<InspectionMetaData> anchorSeven;
    public ArrayList<InspectionMetaData> anchorEight;
    public ArrayList<InspectionMetaData> anchorNine;
    public ArrayList<InspectionMetaData> anchorTen;

    public ArrayList<InspectionMetaData> primaryRiserOne;
    public ArrayList<InspectionMetaData> primaryRiserTwo;
    public ArrayList<InspectionMetaData> primaryRiserThree;
    public ArrayList<InspectionMetaData> primaryRiserFour;
    public ArrayList<InspectionMetaData> primaryRiserFive;
    public ArrayList<InspectionMetaData> primaryRiserSix;
    public ArrayList<InspectionMetaData> primaryRiserSeven;
    public ArrayList<InspectionMetaData> primaryRiserEight;
    public ArrayList<InspectionMetaData> primaryRiserNine;
    public ArrayList<InspectionMetaData> primaryRiserTen;

    public ArrayList<InspectionMetaData> secondaryRiseOne;
    public ArrayList<InspectionMetaData> secondaryRiseTwo;
    public ArrayList<InspectionMetaData> secondaryRiseThree;
    public ArrayList<InspectionMetaData> secondaryRiseFour;
    public ArrayList<InspectionMetaData> secondaryRiseFive;
    public ArrayList<InspectionMetaData> secondaryRiseSix;
    public ArrayList<InspectionMetaData> secondaryRiseSeven;
    public ArrayList<InspectionMetaData> secondaryRiseEight;
    public ArrayList<InspectionMetaData> secondaryRiseNine;
    public ArrayList<InspectionMetaData> secondaryRiseTen;

    public ArrayList<InspectionMetaData> poleGroundOne;
    public ArrayList<InspectionMetaData> poleGroundTwo;
    public ArrayList<InspectionMetaData> poleGroundThree;
    public ArrayList<InspectionMetaData> poleGroundFour;
    public ArrayList<InspectionMetaData> poleGroundFive;
    public ArrayList<InspectionMetaData> poleGroundSix;
    public ArrayList<InspectionMetaData> poleGroundSeven;
    public ArrayList<InspectionMetaData> poleGroundEight;
    public ArrayList<InspectionMetaData> poleGroundNine;
    public ArrayList<InspectionMetaData> poleGroundTen;

    public ArrayList<InspectionMetaData> vegetationOne;
    public ArrayList<InspectionMetaData> vegetationTwo;
    public ArrayList<InspectionMetaData> vegetationThree;
    public ArrayList<InspectionMetaData> vegetationFour;
    public ArrayList<InspectionMetaData> vegetationFive;
    public ArrayList<InspectionMetaData> vegetationSix;
    public ArrayList<InspectionMetaData> vegetationSeven;
    public ArrayList<InspectionMetaData> vegetationEight;
    public ArrayList<InspectionMetaData> vegetationNine;
    public ArrayList<InspectionMetaData> vegetationTen;

    private PoleData(){
        initializePole();

    }

    private void initializeVegetation() {
        vegetationOne = new ArrayList<>();
        vegetationTwo = new ArrayList<>();
        vegetationThree = new ArrayList<>();
        vegetationFour = new ArrayList<>();
        vegetationFive = new ArrayList<>();
        vegetationSix = new ArrayList<>();
        vegetationSeven = new ArrayList<>();
        vegetationEight = new ArrayList<>();
        vegetationNine = new ArrayList<>();
        vegetationTen = new ArrayList<>();
    }

    private void initializePoleGround() {
        poleGroundOne = new ArrayList<>();
        poleGroundTwo = new ArrayList<>();
        poleGroundThree = new ArrayList<>();
        poleGroundFour = new ArrayList<>();
        poleGroundFive = new ArrayList<>();
        poleGroundSix = new ArrayList<>();
        poleGroundSeven = new ArrayList<>();
        poleGroundEight = new ArrayList<>();
        poleGroundNine = new ArrayList<>();
        poleGroundTen = new ArrayList<>();
    }

    private void initializeSecondaryRise() {
        secondaryRiseOne = new ArrayList<>();
        secondaryRiseTwo = new ArrayList<>();
        secondaryRiseThree = new ArrayList<>();
        secondaryRiseFour = new ArrayList<>();
        secondaryRiseFive = new ArrayList<>();
        secondaryRiseSix = new ArrayList<>();
        secondaryRiseSeven = new ArrayList<>();
        secondaryRiseEight = new ArrayList<>();
        secondaryRiseNine = new ArrayList<>();
        secondaryRiseTen = new ArrayList<>();
    }

    private void initializePrimaryRise() {
        primaryRiserOne = new ArrayList<>();
        primaryRiserTwo = new ArrayList<>();
        primaryRiserThree = new ArrayList<>();
        primaryRiserFour = new ArrayList<>();
        primaryRiserFive = new ArrayList<>();
        primaryRiserSix = new ArrayList<>();
        primaryRiserSeven = new ArrayList<>();
        primaryRiserEight = new ArrayList<>();
        primaryRiserNine = new ArrayList<>();
        primaryRiserTen = new ArrayList<>();
    }

    private void initializeAnchor() {
        anchorOne = new ArrayList<>();
        anchorTwo = new ArrayList<>();
        anchorThree = new ArrayList<>();
        anchorFour = new ArrayList<>();
        anchorFive = new ArrayList<>();
        anchorSix = new ArrayList<>();
        anchorSeven = new ArrayList<>();
        anchorEight = new ArrayList<>();
        anchorNine = new ArrayList<>();
        anchorTen = new ArrayList<>();
    }

    private void initializeGuyWire() {
        guyWireOne = new ArrayList<>();
        guyWireTwo = new ArrayList<>();
        guyWireThree = new ArrayList<>();
        guyWireFour = new ArrayList<>();
        guyWireFive = new ArrayList<>();
        guyWireSix = new ArrayList<>();
        guyWireSeven = new ArrayList<>();
        guyWireEight = new ArrayList<>();
        guyWireNine = new ArrayList<>();
        guyWireTen = new ArrayList<>();
    }

    private void initializePole() {
        poleOne = new ArrayList<>();
        poleTwo = new ArrayList<>();
        poleThree = new ArrayList<>();
        poleFour = new ArrayList<>();
        poleFive = new ArrayList<>();
        poleSix = new ArrayList<>();
        poleSeven = new ArrayList<>();
        poleEight = new ArrayList<>();
        poleNine = new ArrayList<>();
        poleTen = new ArrayList<>();
    }

    public static synchronized PoleData getInstance(){
        if(poleData == null)
            poleData = new PoleData();
        else
            return poleData;
        return poleData;
    }
}
