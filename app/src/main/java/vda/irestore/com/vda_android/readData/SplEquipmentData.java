package vda.irestore.com.vda_android.readData;

import java.util.ArrayList;

import vda.irestore.com.vda_android.Pojo.InspectionMetaData;


/**
 * Created by Malbel Technologies on 07-12-2017.
 */

public class SplEquipmentData {

    private static SplEquipmentData SplEquipmentData = null;

    public ArrayList<InspectionMetaData> regulatorOne;
    public ArrayList<InspectionMetaData> regulatorTwo;
    public ArrayList<InspectionMetaData> regulatorThree;
    public ArrayList<InspectionMetaData> regulatorFour;
    public ArrayList<InspectionMetaData> regulatorFive;
    public ArrayList<InspectionMetaData> regulatorSix;
    public ArrayList<InspectionMetaData> regulatorSeven;
    public ArrayList<InspectionMetaData> regulatorEight;
    public ArrayList<InspectionMetaData> regulatorNine;
    public ArrayList<InspectionMetaData> regulatorTen;

    public ArrayList<InspectionMetaData> capacitorBankOne;
    public ArrayList<InspectionMetaData> capacitorBankTwo;
    public ArrayList<InspectionMetaData> capacitorBankThree;
    public ArrayList<InspectionMetaData> capacitorBankFour;
    public ArrayList<InspectionMetaData> capacitorBankFive;
    public ArrayList<InspectionMetaData> capacitorBankSix;
    public ArrayList<InspectionMetaData> capacitorBankSeven;
    public ArrayList<InspectionMetaData> capacitorBankEight;
    public ArrayList<InspectionMetaData> capacitorBankNine;
    public ArrayList<InspectionMetaData> capacitorBankTen;

    public ArrayList<InspectionMetaData> recloserOne;
    public ArrayList<InspectionMetaData> recloserTwo;
    public ArrayList<InspectionMetaData> recloserThree;
    public ArrayList<InspectionMetaData> recloserFour;
    public ArrayList<InspectionMetaData> recloserFive;
    public ArrayList<InspectionMetaData> recloserSix;
    public ArrayList<InspectionMetaData> recloserSeven;
    public ArrayList<InspectionMetaData> recloserEight;
    public ArrayList<InspectionMetaData> recloserNine;
    public ArrayList<InspectionMetaData> recloserTen;

    public ArrayList<InspectionMetaData> loadBreakSwitchOne;
    public ArrayList<InspectionMetaData> loadBreakSwitchTwo;
    public ArrayList<InspectionMetaData> loadBreakSwitchThree;
    public ArrayList<InspectionMetaData> loadBreakSwitchFour;
    public ArrayList<InspectionMetaData> loadBreakSwitchFive;
    public ArrayList<InspectionMetaData> loadBreakSwitchSix;
    public ArrayList<InspectionMetaData> loadBreakSwitchSeven;
    public ArrayList<InspectionMetaData> loadBreakSwitchEight;
    public ArrayList<InspectionMetaData> loadBreakSwitchNine;
    public ArrayList<InspectionMetaData> loadBreakSwitchTen;

    private SplEquipmentData(){
        new Thread(new Runnable() {
           @Override
           public void run() {
               initializeRegular();
           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializeCapacitorBank();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializeRecloser();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializeLoadBreakSwitch();
            }
        }).start();
    }

    private void initializeLoadBreakSwitch() {
        loadBreakSwitchOne = new ArrayList<>();
        loadBreakSwitchTwo = new ArrayList<>();
        loadBreakSwitchThree = new ArrayList<>();
        loadBreakSwitchFour = new ArrayList<>();
        loadBreakSwitchFive = new ArrayList<>();
        loadBreakSwitchSix = new ArrayList<>();
        loadBreakSwitchSeven = new ArrayList<>();
        loadBreakSwitchEight = new ArrayList<>();
        loadBreakSwitchNine = new ArrayList<>();
        loadBreakSwitchTen = new ArrayList<>();
    }

    private void initializeRecloser() {
        recloserOne = new ArrayList<>();
        recloserTwo = new ArrayList<>();
        recloserThree = new ArrayList<>();
        recloserFour = new ArrayList<>();
        recloserFive = new ArrayList<>();
        recloserSix = new ArrayList<>();
        recloserSeven = new ArrayList<>();
        recloserEight = new ArrayList<>();
        recloserNine = new ArrayList<>();
        recloserTen = new ArrayList<>();
    }

    private void initializeCapacitorBank() {
        capacitorBankOne = new ArrayList<>();
        capacitorBankTwo = new ArrayList<>();
        capacitorBankThree = new ArrayList<>();
        capacitorBankFour = new ArrayList<>();
        capacitorBankFive = new ArrayList<>();
        capacitorBankSix = new ArrayList<>();
        capacitorBankSeven = new ArrayList<>();
        capacitorBankEight = new ArrayList<>();
        capacitorBankNine = new ArrayList<>();
        capacitorBankTen = new ArrayList<>();
    }

    private void initializeRegular() {
        regulatorOne = new ArrayList<>();
        regulatorTwo = new ArrayList<>();
        regulatorThree = new ArrayList<>();
        regulatorFour = new ArrayList<>();
        regulatorFive = new ArrayList<>();
        regulatorSix = new ArrayList<>();
        regulatorSeven = new ArrayList<>();
        regulatorEight = new ArrayList<>();
        regulatorNine = new ArrayList<>();
        regulatorTen = new ArrayList<>();
    }

    public static synchronized SplEquipmentData getInstance (){
        if(SplEquipmentData == null)
            SplEquipmentData = new SplEquipmentData();
        else
            return SplEquipmentData;

        return SplEquipmentData;
    }
}
