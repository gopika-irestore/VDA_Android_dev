package vda.irestore.com.vda_android.readData;

import java.util.ArrayList;

import vda.irestore.com.vda_android.Pojo.InspectionMetaData;

/**
 * Created by Malbel Technologies on 08-12-2017.
 */

public class UnderGroundData {
    private static UnderGroundData underGroundData = null;

    public ArrayList<InspectionMetaData> padmountsOne;
    public ArrayList<InspectionMetaData> padmountsTwo;
    public ArrayList<InspectionMetaData> padmountsThree;
    public ArrayList<InspectionMetaData> padmountsFour;
    public ArrayList<InspectionMetaData> padmountsFive;
    public ArrayList<InspectionMetaData> padmountsSix;
    public ArrayList<InspectionMetaData> padmountsSeven;
    public ArrayList<InspectionMetaData> padmountsEight;
    public ArrayList<InspectionMetaData> padmountsNine;
    public ArrayList<InspectionMetaData> padmountsTen;

    public ArrayList<InspectionMetaData> pullBoxOne;
    public ArrayList<InspectionMetaData> pullBoxTwo;
    public ArrayList<InspectionMetaData> pullBoxThree;
    public ArrayList<InspectionMetaData> pullBoxFour;
    public ArrayList<InspectionMetaData> pullBoxFive;
    public ArrayList<InspectionMetaData> pullBoxSix;
    public ArrayList<InspectionMetaData> pullBoxSeven;
    public ArrayList<InspectionMetaData> pullBoxEight;
    public ArrayList<InspectionMetaData> pullBoxNine;
    public ArrayList<InspectionMetaData> pullBoxTen;

    public ArrayList<InspectionMetaData> spiceBoxOne;
    public ArrayList<InspectionMetaData> spiceBoxTwo;
    public ArrayList<InspectionMetaData> spiceBoxThree;
    public ArrayList<InspectionMetaData> spiceBoxFour;
    public ArrayList<InspectionMetaData> spiceBoxFive;
    public ArrayList<InspectionMetaData> spiceBoxSix;
    public ArrayList<InspectionMetaData> spiceBoxSeven;
    public ArrayList<InspectionMetaData> spiceBoxEight;
    public ArrayList<InspectionMetaData> spiceBoxNine;
    public ArrayList<InspectionMetaData> spiceBoxTen;

    public ArrayList<InspectionMetaData> sectionalizerCabinetOne;
    public ArrayList<InspectionMetaData> sectionalizerCabinetTwo;
    public ArrayList<InspectionMetaData> sectionalizerCabinetThree;
    public ArrayList<InspectionMetaData> sectionalizerCabinetFour;
    public ArrayList<InspectionMetaData> sectionalizerCabinetFive;
    public ArrayList<InspectionMetaData> sectionalizerCabinetSix;
    public ArrayList<InspectionMetaData> sectionalizerCabinetSeven;
    public ArrayList<InspectionMetaData> sectionalizerCabinetEight;
    public ArrayList<InspectionMetaData> sectionalizerCabinetNine;
    public ArrayList<InspectionMetaData> sectionalizerCabinetTen;

    private UnderGroundData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializePadmountsReference();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializePullBoxReference();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializeSpiceBoxReference();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializeSpectionalizerCabinetReference();
            }
        }).start();
    }

    private void initializeSpectionalizerCabinetReference() {
        sectionalizerCabinetOne = new ArrayList<>();
        sectionalizerCabinetTwo = new ArrayList<>();
        sectionalizerCabinetThree = new ArrayList<>();
        sectionalizerCabinetFour = new ArrayList<>();
        sectionalizerCabinetFive = new ArrayList<>();
        sectionalizerCabinetSix = new ArrayList<>();
        sectionalizerCabinetSeven = new ArrayList<>();
        sectionalizerCabinetEight = new ArrayList<>();
        sectionalizerCabinetNine = new ArrayList<>();
        sectionalizerCabinetTen = new ArrayList<>();
    }

    private void initializeSpiceBoxReference() {
        spiceBoxOne = new ArrayList<>();
        spiceBoxTwo = new ArrayList<>();
        spiceBoxThree = new ArrayList<>();
        spiceBoxFour = new ArrayList<>();
        spiceBoxFive = new ArrayList<>();
        spiceBoxSix = new ArrayList<>();
        spiceBoxSeven = new ArrayList<>();
        spiceBoxEight = new ArrayList<>();
        spiceBoxNine = new ArrayList<>();
        spiceBoxTen = new ArrayList<>();
    }

    private void initializePullBoxReference() {
        pullBoxOne = new ArrayList<>();
        pullBoxTwo = new ArrayList<>();
        pullBoxThree = new ArrayList<>();
        pullBoxFour = new ArrayList<>();
        pullBoxFive = new ArrayList<>();
        pullBoxSix = new ArrayList<>();
        pullBoxSeven = new ArrayList<>();
        pullBoxEight = new ArrayList<>();
        pullBoxNine = new ArrayList<>();
        pullBoxTen = new ArrayList<>();
    }

    private void initializePadmountsReference() {
        padmountsOne = new ArrayList<>();
        padmountsTwo = new ArrayList<>();
        padmountsThree = new ArrayList<>();
        padmountsFour = new ArrayList<>();
        padmountsFive = new ArrayList<>();
        padmountsSix = new ArrayList<>();
        padmountsSeven = new ArrayList<>();
        padmountsEight = new ArrayList<>();
        padmountsNine = new ArrayList<>();
        padmountsTen = new ArrayList<>();
    }

    public static synchronized UnderGroundData getInstance() {
        if (underGroundData == null)
            underGroundData = new UnderGroundData();
        else
            return underGroundData;
        return underGroundData;
    }
}
