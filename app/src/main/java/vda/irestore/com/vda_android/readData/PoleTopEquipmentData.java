package vda.irestore.com.vda_android.readData;

import java.util.ArrayList;

import vda.irestore.com.vda_android.Pojo.InspectionMetaData;


/**
 * Created by Malbel Technologies on 24-11-2017.
 */

public class PoleTopEquipmentData {

    private static PoleTopEquipmentData instance = null;

    public ArrayList<InspectionMetaData> transformerOne;
    public ArrayList<InspectionMetaData> transformerTwo;
    public ArrayList<InspectionMetaData> transformerThree;
    public ArrayList<InspectionMetaData> transformerFour;
    public ArrayList<InspectionMetaData> transformerFive;
    public ArrayList<InspectionMetaData> transformerSix;
    public ArrayList<InspectionMetaData> transformerSeven;
    public ArrayList<InspectionMetaData> transformerEight;
    public ArrayList<InspectionMetaData> transformerNine;
    public ArrayList<InspectionMetaData> transformerTen;

    public ArrayList<InspectionMetaData> crossArmOne;
    public ArrayList<InspectionMetaData> crossArmTwo;
    public ArrayList<InspectionMetaData> crossArmThree;
    public ArrayList<InspectionMetaData> crossArmFour;
    public ArrayList<InspectionMetaData> crossArmFive;
    public ArrayList<InspectionMetaData> crossArmSix;
    public ArrayList<InspectionMetaData> crossArmSeven;
    public ArrayList<InspectionMetaData> crossArmEight;
    public ArrayList<InspectionMetaData> crossArmNine;
    public ArrayList<InspectionMetaData> crossArmTen;

    public ArrayList<InspectionMetaData> fusedCutOne;
    public ArrayList<InspectionMetaData> fusedCutTwo;
    public ArrayList<InspectionMetaData> fusedCutThree;
    public ArrayList<InspectionMetaData> fusedCutFour;
    public ArrayList<InspectionMetaData> fusedCutFive;
    public ArrayList<InspectionMetaData> fusedCutSix;
    public ArrayList<InspectionMetaData> fusedCutSeven;
    public ArrayList<InspectionMetaData> fusedCutEight;
    public ArrayList<InspectionMetaData> fusedCutNine;
    public ArrayList<InspectionMetaData> fusedCutTen;

    public ArrayList<InspectionMetaData> poleAttacmentOne;
    public ArrayList<InspectionMetaData> poleAttacmentTwo;
    public ArrayList<InspectionMetaData> poleAttacmentThree;
    public ArrayList<InspectionMetaData> poleAttacmentFour;
    public ArrayList<InspectionMetaData> poleAttacmentFive;
    public ArrayList<InspectionMetaData> poleAttacmentSix;
    public ArrayList<InspectionMetaData> poleAttacmentSeven;
    public ArrayList<InspectionMetaData> poleAttacmentEight;
    public ArrayList<InspectionMetaData> poleAttacmentNine;
    public ArrayList<InspectionMetaData> poleAttacmentTen;

    public ArrayList<InspectionMetaData> streetlightOne;
    public ArrayList<InspectionMetaData> streetlightTwo;
    public ArrayList<InspectionMetaData> streetlightThree;
    public ArrayList<InspectionMetaData> streetlightFour;
    public ArrayList<InspectionMetaData> streetlightFive;
    public ArrayList<InspectionMetaData> streetlightSix;
    public ArrayList<InspectionMetaData> streetlightSeven;
    public ArrayList<InspectionMetaData> streetlightEight;
    public ArrayList<InspectionMetaData> streetlightNine;
    public ArrayList<InspectionMetaData> streetlightTen;

    public ArrayList<InspectionMetaData> poleTopPinOne;
    public ArrayList<InspectionMetaData> poleTopPinTwo;
    public ArrayList<InspectionMetaData> poleTopPinThree;
    public ArrayList<InspectionMetaData> poleTopPinFour;
    public ArrayList<InspectionMetaData> poleTopPinFive;
    public ArrayList<InspectionMetaData> poleTopPinSix;
    public ArrayList<InspectionMetaData> poleTopPinSeven;
    public ArrayList<InspectionMetaData> poleTopPinEight;
    public ArrayList<InspectionMetaData> poleTopPinNine;
    public ArrayList<InspectionMetaData> poleTopPinTen;

    public ArrayList<InspectionMetaData> insulatorOne;
    public ArrayList<InspectionMetaData> insulatorTwo;
    public ArrayList<InspectionMetaData> insulatorThree;
    public ArrayList<InspectionMetaData> insulatorFour;
    public ArrayList<InspectionMetaData> insulatorFive;
    public ArrayList<InspectionMetaData> insulatorSix;
    public ArrayList<InspectionMetaData> insulatorSeven;
    public ArrayList<InspectionMetaData> insulatorEight;
    public ArrayList<InspectionMetaData> insulatorNine;
    public ArrayList<InspectionMetaData> insulatorTen;

    public ArrayList<InspectionMetaData> primaryOne;
    public ArrayList<InspectionMetaData> primaryTwo;
    public ArrayList<InspectionMetaData> primaryThree;
    public ArrayList<InspectionMetaData> primaryFour;
    public ArrayList<InspectionMetaData> primaryFive;
    public ArrayList<InspectionMetaData> primarySix;
    public ArrayList<InspectionMetaData> primarySeven;
    public ArrayList<InspectionMetaData> primaryEight;
    public ArrayList<InspectionMetaData> primaryNine;
    public ArrayList<InspectionMetaData> primaryTen;

    public ArrayList<InspectionMetaData> secondaryOne;
    public ArrayList<InspectionMetaData> secondaryTwo;
    public ArrayList<InspectionMetaData> secondaryThree;
    public ArrayList<InspectionMetaData> secondaryFour;
    public ArrayList<InspectionMetaData> secondaryFive;
    public ArrayList<InspectionMetaData> secondarySix;
    public ArrayList<InspectionMetaData> secondarySeven;
    public ArrayList<InspectionMetaData> secondaryEight;
    public ArrayList<InspectionMetaData> secondaryNine;
    public ArrayList<InspectionMetaData> secondaryTen;

    public ArrayList<InspectionMetaData> serviceWireOne;
    public ArrayList<InspectionMetaData> serviceWireTwo;
    public ArrayList<InspectionMetaData> serviceWireThree;
    public ArrayList<InspectionMetaData> serviceWireFour;
    public ArrayList<InspectionMetaData> serviceWireFive;
    public ArrayList<InspectionMetaData> serviceWireSix;
    public ArrayList<InspectionMetaData> serviceWireSeven;
    public ArrayList<InspectionMetaData> serviceWireEight;
    public ArrayList<InspectionMetaData> serviceWireNine;
    public ArrayList<InspectionMetaData> serviceWireTen;

    private PoleTopEquipmentData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                tansformReferenceInitialization();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                crossArmReferenceInitialization();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fusedCutReferenceInitialization();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                streetlightInitialization();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                poleTopPinInitialization();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                insulatorInitialization();
            }
        }).start();

    }



    private void insulatorInitialization() {
        insulatorOne = new ArrayList<>();
        insulatorTwo = new ArrayList<>();
        insulatorThree = new ArrayList<>();
        insulatorFour = new ArrayList<>();
        insulatorFive = new ArrayList<>();
        insulatorSix = new ArrayList<>();
        insulatorSeven = new ArrayList<>();
        insulatorEight = new ArrayList<>();
        insulatorNine = new ArrayList<>();
        insulatorTen = new ArrayList<>();
    }

    private void poleTopPinInitialization() {
        poleTopPinOne = new ArrayList<>();
        poleTopPinTwo = new ArrayList<>();
        poleTopPinThree = new ArrayList<>();
        poleTopPinFour = new ArrayList<>();
        poleTopPinFive = new ArrayList<>();
        poleTopPinSix = new ArrayList<>();
        poleTopPinSeven = new ArrayList<>();
        poleTopPinEight = new ArrayList<>();
        poleTopPinNine = new ArrayList<>();
        poleTopPinTen = new ArrayList<>();
    }

    private void streetlightInitialization() {
        streetlightOne = new ArrayList<>();
        streetlightTwo = new ArrayList<>();
        streetlightThree = new ArrayList<>();
        streetlightFour = new ArrayList<>();
        streetlightFive = new ArrayList<>();
        streetlightSix = new ArrayList<>();
        streetlightSeven = new ArrayList<>();
        streetlightEight = new ArrayList<>();
        streetlightNine = new ArrayList<>();
        streetlightTen = new ArrayList<>();
    }

/*    private void poleAttachementReferenceInitialization() {
        poleAttacmentOne = new ArrayList<>();
        poleAttacmentTwo = new ArrayList<>();
        poleAttacmentThree = new ArrayList<>();
        poleAttacmentFour = new ArrayList<>();
        poleAttacmentFive = new ArrayList<>();
        poleAttacmentSix = new ArrayList<>();
        poleAttacmentSeven = new ArrayList<>();
        poleAttacmentEight = new ArrayList<>();
        poleAttacmentNine = new ArrayList<>();
        poleAttacmentTen = new ArrayList<>();
    }*/

    private void fusedCutReferenceInitialization() {
        fusedCutOne = new ArrayList<>();
        fusedCutTwo = new ArrayList<>();
        fusedCutThree = new ArrayList<>();
        fusedCutFour = new ArrayList<>();
        fusedCutFive = new ArrayList<>();
        fusedCutSix = new ArrayList<>();
        fusedCutSeven = new ArrayList<>();
        fusedCutEight = new ArrayList<>();
        fusedCutNine = new ArrayList<>();
        fusedCutTen = new ArrayList<>();
    }

    private void crossArmReferenceInitialization() {
        crossArmOne = new ArrayList();
        crossArmTwo = new ArrayList();
        crossArmThree = new ArrayList();
        crossArmFour = new ArrayList();
        crossArmFive = new ArrayList();
        crossArmSix = new ArrayList();
        crossArmSeven = new ArrayList();
        crossArmEight = new ArrayList();
        crossArmNine = new ArrayList();
        crossArmTen = new ArrayList();
    }

    private void tansformReferenceInitialization() {
        transformerOne = new ArrayList();
        transformerTwo = new ArrayList();
        transformerThree = new ArrayList();
        transformerFour = new ArrayList();
        transformerFive = new ArrayList();
        transformerSix = new ArrayList();
        transformerSeven = new ArrayList();
        transformerEight = new ArrayList();
        transformerNine = new ArrayList();
        transformerTen = new ArrayList();

    }

    public static synchronized PoleTopEquipmentData getInstance() {
        if (instance == null)
            instance = new PoleTopEquipmentData();
        else
            return instance;

        return instance;
    }
}
