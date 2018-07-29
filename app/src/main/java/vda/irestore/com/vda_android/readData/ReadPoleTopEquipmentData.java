package vda.irestore.com.vda_android.readData;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;



/**
 * Created by Malbel Technologies on 18-12-2017.
 */

public class ReadPoleTopEquipmentData {
    public static ReadPoleTopEquipmentData readPoleTopEquipmentData = null;

    public String transOnePicturePath = null, transTwoPicturePath = null, transThreePicturePath = null, transFourPicturePath = null, transFivePicturePath = null, transSixPicturePath = null, transSevenPicturePath = null, transEightPicturePath = null, transNinePicturePath = null, transTenPicturePath = null,
            crossArmOnePicturePath = null, crossArmTwoPicturePath = null, crossArmThreePicturePath = null, crossArmFourPicturePath = null, crossArmFivePicturePath = null, crossArmSixPicturePath = null, crossArmSevenPicturePath = null, crossArmEightPicturePath = null, crossArmNinePicturePath = null, crossArmTenPicturePath = null,
            fusedCutOutOnePicturePath = null, fusedCutOutTwoPicturePath = null, fusedCutOutThreePicturePath = null, fusedCutOutFourPicturePath = null, fusedCutOutFivePicturePath = null, fusedCutOutSixPicturePath = null, fusedCutOutSevenPicturePath = null, fusedCutOutEightPicturePath = null, fusedCutOutNinePicturePath = null, fusedCutOutTenPicturePath = null,
            poleAttachmentOnePicturePath = null, poleAttachmentTwoPicturePath = null, poleAttachmentThreePicturePath = null, poleAttachmentFourPicturePath = null, poleAttachmentFivePicturePath = null, poleAttachmentSixPicturePath = null, poleAttachmentSevenPicturePath = null, poleAttachmentEightPicturePath = null, poleAttachmentNinePicturePath = null, poleAttachmentTenPicturePath = null,
            streetLightOnePicturePath = null, streetLightTwoPicturePath = null, streetLightThreePicturePath = null, streetLightFourPicturePath = null, streetLightFivePicturePath = null, streetLightSixPicturePath = null, streetLightSevenPicturePath = null, streetLightEightPicturePath = null, streetLightNinePicturePath = null, streetLightTenPicturePath = null,
            poleTopPinOnePicturePath = null, poleTopPinTwoPicturePath = null, poleTopPinThreePicturePath = null, poleTopPinFourPicturePath = null, poleTopPinFivePicturePath = null, poleTopPinSixPicturePath = null, poleTopPinSevenPicturePath = null, poleTopPinEightPicturePath = null, poleTopPinNinePicturePath = null, poleTopPinTenPicturePath = null,
            insulatorOnePicturePath = null, insulatorTwoPicturePath = null, insulatorThreePicturePath = null, insulatorFourPicturePath = null, insulatorFivePicturePath = null, insulatorSixPicturePath = null, insulatorSevenPicturePath = null, insulatorEightPicturePath = null, insulatorNinePicturePath = null, insulatorTenPicturePath = null,
            primaryOnePicturePath = null, primaryTwoPicturePath = null, primaryThreePicturePath = null, primaryFourPicturePath = null, primaryFivePicturePath = null, primarySixPicturePath = null, primarySevenPicturePath = null, primaryEightPicturePath = null, primaryNinePicturePath = null, primaryTenPicturePath = null,
            secondaryOnePicturePath = null, secondaryTwoPicturePath = null, secondaryThreePicturePath = null, secondaryFourPicturePath = null, secondaryFivePicturePath = null, secondarySixPicturePath = null, secondarySevenPicturePath = null, secondaryEightPicturePath = null, secondaryNinePicturePath = null, secondaryTenPicturePath = null,
            serviceWireOnePicturePath = null, serviceWireTwoPicturePath = null, serviceWireThreePicturePath = null, serviceWireFourPicturePath = null, serviceWireFivePicturePath = null, serviceWireSixPicturePath = null, serviceWireSevenPicturePath = null, serviceWireEightPicturePath = null, serviceWireNinePicturePath = null, serviceWireTenPicturePath = null;
    public String transformTitle, crossArmTitle, fusedCutOutTitle, poleAttachTitle, poleTopPinTitle, insulatorTitle, primaryTitle, secondaryTitle, serviceWireTitle;
    String addNote, subtitle, kvaSize, displayName, testType, size;
    boolean isSelected, isChecked, isUtilityOwned;

    JSONObject damageDetailsTransOne = new JSONObject();
    JSONObject damageDetailsTransTwo = new JSONObject();
    JSONObject damageDetailsTransThree = new JSONObject();
    JSONObject damageDetailsTransFour = new JSONObject();
    JSONObject damageDetailsTransFive = new JSONObject();
    JSONObject damageDetailsTransSix = new JSONObject();
    JSONObject damageDetailsTransSeven = new JSONObject();
    JSONObject damageDetailsTransEight = new JSONObject();
    JSONObject damageDetailsTransNine = new JSONObject();
    JSONObject damageDetailsTransTen = new JSONObject();

    JSONObject damageDetailsCrossArmOne = new JSONObject();
    JSONObject damageDetailsCrossArmTwo = new JSONObject();
    JSONObject damageDetailsCrossArmThree = new JSONObject();
    JSONObject damageDetailsCrossArmFour = new JSONObject();
    JSONObject damageDetailsCrossArmFive = new JSONObject();
    JSONObject damageDetailsCrossArmSix = new JSONObject();
    JSONObject damageDetailsCrossArmSeven = new JSONObject();
    JSONObject damageDetailsCrossArmEight = new JSONObject();
    JSONObject damageDetailsCrossArmNine = new JSONObject();
    JSONObject damageDetailsCrossArmTen = new JSONObject();

    JSONObject damageDetailsFusedCutOne = new JSONObject();
    JSONObject damageDetailsFusedCutTwo = new JSONObject();
    JSONObject damageDetailsFusedCutThree = new JSONObject();
    JSONObject damageDetailsFusedCutFour = new JSONObject();
    JSONObject damageDetailsFusedCutFive = new JSONObject();
    JSONObject damageDetailsFusedCutSix = new JSONObject();
    JSONObject damageDetailsFusedCutSeven = new JSONObject();
    JSONObject damageDetailsFusedCutEight = new JSONObject();
    JSONObject damageDetailsFusedCutNine = new JSONObject();
    JSONObject damageDetailsFusedCutTen = new JSONObject();

    JSONObject damageDetailsPoleAttachOne = new JSONObject();
    JSONObject damageDetailsPoleAttachTwo = new JSONObject();
    JSONObject damageDetailsPoleAttachThree = new JSONObject();
    JSONObject damageDetailsPoleAttachFour = new JSONObject();
    JSONObject damageDetailsPoleAttachFive = new JSONObject();
    JSONObject damageDetailsPoleAttachSix = new JSONObject();
    JSONObject damageDetailsPoleAttachSeven = new JSONObject();
    JSONObject damageDetailsPoleAttachEight = new JSONObject();
    JSONObject damageDetailsPoleAttachNine = new JSONObject();
    JSONObject damageDetailsPoleAttachTen = new JSONObject();

    JSONObject damageDetailsStreetLightOne = new JSONObject();
    JSONObject damageDetailsStreetLightTwo = new JSONObject();
    JSONObject damageDetailsStreetLightThree = new JSONObject();
    JSONObject damageDetailsStreetLightFour = new JSONObject();
    JSONObject damageDetailsStreetLightFive = new JSONObject();
    JSONObject damageDetailsStreetLightSix = new JSONObject();
    JSONObject damageDetailsStreetLightSeven = new JSONObject();
    JSONObject damageDetailsStreetLightEight = new JSONObject();
    JSONObject damageDetailsStreetLightNine = new JSONObject();
    JSONObject damageDetailsStreetLightTen = new JSONObject();

    JSONObject damageDetailsPoleTopPinOne = new JSONObject();
    JSONObject damageDetailsPoleTopPinTwo = new JSONObject();
    JSONObject damageDetailsPoleTopPinThree = new JSONObject();
    JSONObject damageDetailsPoleTopPinFour = new JSONObject();
    JSONObject damageDetailsPoleTopPinFive = new JSONObject();
    JSONObject damageDetailsPoleTopPinSix = new JSONObject();
    JSONObject damageDetailsPoleTopPinSeven = new JSONObject();
    JSONObject damageDetailsPoleTopPinEight = new JSONObject();
    JSONObject damageDetailsPoleTopPinNine = new JSONObject();
    JSONObject damageDetailsPoleTopPinTen = new JSONObject();

    JSONObject damageDetailsInsulatorOne = new JSONObject();
    JSONObject damageDetailsInsulatorTwo = new JSONObject();
    JSONObject damageDetailsInsulatorThree = new JSONObject();
    JSONObject damageDetailsInsulatorFour = new JSONObject();
    JSONObject damageDetailsInsulatorFive = new JSONObject();
    JSONObject damageDetailsInsulatorSix = new JSONObject();
    JSONObject damageDetailsInsulatorSeven = new JSONObject();
    JSONObject damageDetailsInsulatorEight = new JSONObject();
    JSONObject damageDetailsInsulatorNine = new JSONObject();
    JSONObject damageDetailsInsulatorTen = new JSONObject();

    JSONObject damageDetailsPrimaryOne = new JSONObject();
    JSONObject damageDetailsPrimaryTwo = new JSONObject();
    JSONObject damageDetailsPrimaryThree = new JSONObject();
    JSONObject damageDetailsPrimaryFour = new JSONObject();
    JSONObject damageDetailsPrimaryFive = new JSONObject();
    JSONObject damageDetailsPrimarySix = new JSONObject();
    JSONObject damageDetailsPrimarySeven = new JSONObject();
    JSONObject damageDetailsPrimaryEight = new JSONObject();
    JSONObject damageDetailsPrimaryNine = new JSONObject();
    JSONObject damageDetailsPrimaryTen = new JSONObject();

    JSONObject damageDetailssecondaryOne = new JSONObject();
    JSONObject damageDetailssecondaryTwo = new JSONObject();
    JSONObject damageDetailssecondaryThree = new JSONObject();
    JSONObject damageDetailssecondaryFour = new JSONObject();
    JSONObject damageDetailssecondaryFive = new JSONObject();
    JSONObject damageDetailssecondarySix = new JSONObject();
    JSONObject damageDetailssecondarySeven = new JSONObject();
    JSONObject damageDetailssecondaryEight = new JSONObject();
    JSONObject damageDetailssecondaryNine = new JSONObject();
    JSONObject damageDetailssecondaryTen = new JSONObject();

    JSONObject damageDetailsserviceWireOne = new JSONObject();
    JSONObject damageDetailsserviceWireTwo = new JSONObject();
    JSONObject damageDetailsserviceWireThree = new JSONObject();
    JSONObject damageDetailsserviceWireFour = new JSONObject();
    JSONObject damageDetailsserviceWireFive = new JSONObject();
    JSONObject damageDetailsserviceWireSix = new JSONObject();
    JSONObject damageDetailsserviceWireSeven = new JSONObject();
    JSONObject damageDetailsserviceWireEight = new JSONObject();
    JSONObject damageDetailsserviceWireNine = new JSONObject();
    JSONObject damageDetailsserviceWireTen = new JSONObject();

    static Context context;

    public static synchronized ReadPoleTopEquipmentData getInstance() {

        if (readPoleTopEquipmentData == null)
            readPoleTopEquipmentData = new ReadPoleTopEquipmentData();
        else
            return readPoleTopEquipmentData;
        return readPoleTopEquipmentData;
    }

    public JSONObject readTransformOneData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;
        if (PoleTopEquipmentData.getInstance().transformerOne != null && PoleTopEquipmentData.getInstance().transformerOne.size() > 0) {
            try {
                if (damageDetailsTransOne == null) {
                    damageDetailsTransOne = new JSONObject();
                }
                Log.i("DINESH_LOG", "Size = " + PoleTopEquipmentData.getInstance().transformerOne.size());
                for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle() != null) {
                            damageDetailsTransOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle() != null) {
                            damageDetailsTransOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerOne.get(i).getDisplayName());

                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerOne.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerOne.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransOne.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getPicturePath() != null) {
                        transOnePicturePath = PoleTopEquipmentData.getInstance().transformerOne.get(i).getPicturePath();
//                        transOnePicturePath = transOnePicturePath.substring(transOnePicturePath.lastIndexOf("/") + 1);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsTransOne;
    }

    public JSONObject readTransformTwoData() {
        // Transformer defect Two
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerTwo != null && PoleTopEquipmentData.getInstance().transformerTwo.size() > 0) {
            Log.i("DINESH_LOG", "Size = " + PoleTopEquipmentData.getInstance().transformerTwo.size());
            if (damageDetailsTransTwo == null)
                damageDetailsTransTwo = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerTwo.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerTwo.get(i).getDisplayName());

                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransTwo.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle() != null) {
                            damageDetailsTransTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle() != null) {
                            damageDetailsTransTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getPicturePath() != null) {
                        transTwoPicturePath = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getPicturePath();
//                        transTwoPicturePath = transTwoPicturePath.substring(transTwoPicturePath.lastIndexOf("/") + 1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransTwo;
    }

    public JSONObject readTransformThreeData() {
        // Transformer defect Three
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerThree != null && PoleTopEquipmentData.getInstance().transformerThree.size() > 0) {
            if (damageDetailsTransThree == null)
                damageDetailsTransThree = new JSONObject();

            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerThree.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerThree.get(i).getDisplayName());
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerThree.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerThree.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransThree.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle() != null) {
                            damageDetailsTransThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle() != null) {
                            damageDetailsTransThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransThree.put(subtitle, isChecked);
                        }
                    }

                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getPicturePath() != null) {
                        transThreePicturePath = PoleTopEquipmentData.getInstance().transformerThree.get(i).getPicturePath();
//                        transThreePicturePath = transThreePicturePath.substring(transThreePicturePath.lastIndexOf("/") + 1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransThree;
    }

    public JSONObject readTransformFourData() {
        // Transformer defect four
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerFour != null && PoleTopEquipmentData.getInstance().transformerFour.size() > 0) {
            if (damageDetailsTransFour == null)
                damageDetailsTransFour = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerFour.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerFour.get(i).getDisplayName());

                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerFour.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerFour.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransFour.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle() != null) {
                            damageDetailsTransFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle() != null) {
                            damageDetailsTransFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getPicturePath() != null) {
                        transFourPicturePath = PoleTopEquipmentData.getInstance().transformerFour.get(i).getPicturePath();
//                        transFourPicturePath = transFourPicturePath.substring(transFourPicturePath.lastIndexOf("/") + 1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransFour;
    }

    public JSONObject readTransformFiveData() {
        // Transformer defect Five
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerFive != null && PoleTopEquipmentData.getInstance().transformerFive.size() > 0) {
            if (damageDetailsTransFive == null)
                damageDetailsTransFive = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerFive.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getPicturePath() != null) {
                        transFivePicturePath = PoleTopEquipmentData.getInstance().transformerFive.get(i).getPicturePath();
//                        transFivePicturePath = transFivePicturePath.substring(transFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerFive.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerFive.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerFive.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransFive.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle() != null) {
                            damageDetailsTransFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle() != null) {
                            damageDetailsTransFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransFive.put(subtitle, isChecked);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransFive;
    }

    public JSONObject readTransformSixData() {
        // Transformer defect Six
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerSix != null && PoleTopEquipmentData.getInstance().transformerSix.size() > 0) {
            if (damageDetailsTransSix == null)
                damageDetailsTransSix = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerSix.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getPicturePath() != null) {
                        transSixPicturePath = PoleTopEquipmentData.getInstance().transformerSix.get(i).getPicturePath();
//                        transSixPicturePath = transSixPicturePath.substring(transSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerSix.get(i).getDisplayName());

                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerSix.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerSix.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransSix.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle() != null) {
                            damageDetailsTransSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle() != null) {
                            damageDetailsTransSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransSix.put(subtitle, isChecked);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransSix;
    }

    public JSONObject readTransformSevenData() {
        // Transformer defect Seven
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerSeven != null && PoleTopEquipmentData.getInstance().transformerSeven.size() > 0) {
            if (damageDetailsTransSeven == null)
                damageDetailsTransSeven = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerSix.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getPicturePath() != null) {
                        transSevenPicturePath = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getPicturePath();
//                        transSevenPicturePath = transSevenPicturePath.substring(transSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getIsSelected() != null
                            && PoleTopEquipmentData.getInstance().transformerSeven.get(i).getDisplayName() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransSeven.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle() != null) {
                            damageDetailsTransSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle() != null) {
                            damageDetailsTransSeven.put(subtitle, addNote);
                        }
                    }

                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getTitle();

                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransSeven.put(subtitle, isChecked);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransSeven;
    }

    public JSONObject readTransformEightData() {
        // Transformer defect Eight
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerEight != null && PoleTopEquipmentData.getInstance().transformerEight.size() > 0) {
            if (damageDetailsTransEight == null)
                damageDetailsTransEight = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerEight.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getPicturePath() != null) {
                        transEightPicturePath = PoleTopEquipmentData.getInstance().transformerEight.get(i).getPicturePath();
//                        transEightPicturePath = transEightPicturePath.substring(transEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerEight.get(i).getDisplayName());

                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerEight.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerEight.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransEight.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle() != null) {
                            damageDetailsTransEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle() != null) {
                            damageDetailsTransEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransEight.put(subtitle, isChecked);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransEight;
    }

    public JSONObject readTransformNineData() {
        // Transformer defect Nine
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerNine != null && PoleTopEquipmentData.getInstance().transformerNine.size() > 0) {
            if (damageDetailsTransNine == null)
                damageDetailsTransNine = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerNine.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getPicturePath() != null) {
                        transNinePicturePath = PoleTopEquipmentData.getInstance().transformerNine.get(i).getPicturePath();
//                        transNinePicturePath = transNinePicturePath.substring(transNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerNine.get(i).getDisplayName());

                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerNine.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerNine.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransNine.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle() != null) {
                            damageDetailsTransNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle() != null) {
                            damageDetailsTransNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransNine.put(subtitle, isChecked);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransNine;
    }

    public JSONObject readTransformTenData() {
        // Transformer defect Ten
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().transformerTen != null && PoleTopEquipmentData.getInstance().transformerTen.size() > 0) {
            if (damageDetailsTransTen == null)
                damageDetailsTransTen = new JSONObject();
            for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerTen.size(); i++) {
                try {
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getPicturePath() != null) {
                        transTenPicturePath = PoleTopEquipmentData.getInstance().transformerTen.get(i).getPicturePath();
//                        transTenPicturePath = transTenPicturePath.substring(transTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getTitle() != null)
                        transformTitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().transformerTen.get(i).getDisplayName());

                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getIsSelected() != null) {
                        isSelected = PoleTopEquipmentData.getInstance().transformerTen.get(i).getIsSelected();
                        displayName = PoleTopEquipmentData.getInstance().transformerTen.get(i).getName();
                        if (isSelected) {

                            damageDetailsTransTen.put(displayName, isSelected);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle() != null) {
                            damageDetailsTransTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle() != null) {
                            damageDetailsTransTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().transformerTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsTransTen.put(subtitle, isChecked);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
        return damageDetailsTransTen;
    }

    public JSONObject readCrossArmOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmOne != null && PoleTopEquipmentData.getInstance().crossArmOne.size() > 0) {
            if (damageDetailsCrossArmOne == null)
                damageDetailsCrossArmOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getPicturePath() != null) {
                        crossArmOnePicturePath = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getPicturePath();
//                        crossArmOnePicturePath = crossArmOnePicturePath.substring(crossArmOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getTitle() != null)
                        crossArmTitle = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmOne.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmOne;
    }

    public JSONObject readCrossArmTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmTwo != null && PoleTopEquipmentData.getInstance().crossArmTwo.size() > 0) {
            if (damageDetailsCrossArmTwo == null)
                damageDetailsCrossArmTwo = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getPicturePath() != null) {
                        crossArmTwoPicturePath = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getPicturePath();
//                        crossArmTwoPicturePath = crossArmTwoPicturePath.substring(crossArmTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmTwo;
    }

    public JSONObject readCrossArmThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmThree != null && PoleTopEquipmentData.getInstance().crossArmThree.size() > 0) {
            if (damageDetailsCrossArmThree == null)
                damageDetailsCrossArmThree = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getPicturePath() != null) {
                        crossArmThreePicturePath = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getPicturePath();
//                        crossArmThreePicturePath = crossArmThreePicturePath.substring(crossArmThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmThree.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmThree;
    }

    public JSONObject readCrossArmFourData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmFour != null && PoleTopEquipmentData.getInstance().crossArmFour.size() > 0) {
            if (damageDetailsCrossArmFour == null)
                damageDetailsCrossArmFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getPicturePath() != null) {
                        crossArmFourPicturePath = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getPicturePath();
//                        crossArmFourPicturePath = crossArmFourPicturePath.substring(crossArmFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmFour.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmFour;
    }

    public JSONObject readCrossArmFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmFive != null && PoleTopEquipmentData.getInstance().crossArmFive.size() > 0) {
            if (damageDetailsCrossArmFive == null)
                damageDetailsCrossArmFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getPicturePath() != null) {
                        crossArmFivePicturePath = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getPicturePath();
//                        crossArmFivePicturePath = crossArmFivePicturePath.substring(crossArmFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmFive.size(); i++) {
//                    Log.i("DINESH_LOG", "\nInded i = " + i);
                    if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmFive.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmFive;
    }

    public JSONObject readCrossArmSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmSix != null && PoleTopEquipmentData.getInstance().crossArmSix.size() > 0) {
            try {
                if (damageDetailsCrossArmSix == null)
                    damageDetailsCrossArmSix = new JSONObject();
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getPicturePath() != null) {
                        crossArmSixPicturePath = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getPicturePath();
//                        crossArmSixPicturePath = crossArmSixPicturePath.substring(crossArmSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmSix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmSix.size(); i++) {
//                    Log.i("DINESH_LOG", "\nInded i = " + i);
                    if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmFive.get(i).getDisplayName());

                        if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmSix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmSix;
    }

    public JSONObject readCrossArmSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmSeven != null && PoleTopEquipmentData.getInstance().crossArmSeven.size() > 0) {
            if (damageDetailsCrossArmSeven == null)
                damageDetailsCrossArmSeven = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getPicturePath() != null) {
                        crossArmSevenPicturePath = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getPicturePath();
//                        crossArmSevenPicturePath = crossArmSevenPicturePath.substring(crossArmSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmSeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmSeven.size(); i++) {
//                    Log.i("DINESH_LOG", "\nInded i = " + i);
                    if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmFive.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmSeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmSeven;
    }

    public JSONObject readCrossArmEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmEight != null && PoleTopEquipmentData.getInstance().crossArmEight.size() > 0) {
            if (damageDetailsCrossArmEight == null)
                damageDetailsCrossArmEight = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getPicturePath() != null) {
                        crossArmEightPicturePath = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getPicturePath();
//                        crossArmEightPicturePath = crossArmEightPicturePath.substring(crossArmEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmEight.size(); i++) {
//                    Log.i("DINESH_LOG", "\nInded i = " + i);
                    if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmFive.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmEight;
    }

    public JSONObject readCrossArmNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmNine != null && PoleTopEquipmentData.getInstance().crossArmNine.size() > 0) {
            if (damageDetailsCrossArmNine == null)
                damageDetailsCrossArmNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getPicturePath() != null) {
                        crossArmNinePicturePath = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getPicturePath();
//                        crossArmNinePicturePath = crossArmNinePicturePath.substring(crossArmNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmNine.size(); i++) {
//                    Log.i("DINESH_LOG", "\nInded i = " + i);
                    if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmFive.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmNine;
    }

    public JSONObject readCrossArmTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().crossArmTen != null && PoleTopEquipmentData.getInstance().crossArmTen.size() > 0) {
            if (damageDetailsCrossArmTen == null)
                damageDetailsCrossArmTen = null;
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getPicturePath() != null) {
                        crossArmTenPicturePath = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getPicturePath();
//                        crossArmTenPicturePath = serviceWireTenPicturePath.substring(serviceWireTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsCrossArmTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().crossArmTen.size(); i++) {
//                    Log.i("DINESH_LOG", "\nInded i = " + i);
                    if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().crossArmFive.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsCrossArmTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsCrossArmTen;
    }

    public JSONObject readFusedCutOutOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutOne != null && PoleTopEquipmentData.getInstance().fusedCutOne.size() > 0) {
            if (damageDetailsFusedCutOne == null)
                damageDetailsFusedCutOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getPicturePath() != null) {
                        fusedCutOutOnePicturePath = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getPicturePath();
//                        fusedCutOutOnePicturePath = fusedCutOutOnePicturePath.substring(fusedCutOutOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getTitle() != null) {
                        fusedCutOutTitle = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getTitle();
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutOne;
    }

    public JSONObject readFusedCutOutTwoData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutTwo != null && PoleTopEquipmentData.getInstance().fusedCutTwo.size() > 0) {
            if (damageDetailsFusedCutTwo == null)
                damageDetailsFusedCutTwo = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getPicturePath() != null) {
                        fusedCutOutTwoPicturePath = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getPicturePath();
//                        fusedCutOutTwoPicturePath = fusedCutOutTwoPicturePath.substring(fusedCutOutTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutTwo;
    }

    public JSONObject readFusedCutOutThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutThree != null && PoleTopEquipmentData.getInstance().fusedCutThree.size() > 0) {
            if (damageDetailsFusedCutThree == null)
                damageDetailsFusedCutThree = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getPicturePath() != null) {
                        fusedCutOutThreePicturePath = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getPicturePath();
//                        fusedCutOutThreePicturePath = fusedCutOutThreePicturePath.substring(fusedCutOutThreePicturePath.lastIndexOf("/") + 1);
                    }

                    if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getDisplayName());

                        if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutThree;
    }

    public JSONObject readFusedCutOutFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutFour != null && PoleTopEquipmentData.getInstance().fusedCutFour.size() > 0) {
            if (damageDetailsFusedCutFour == null)
                damageDetailsFusedCutFour = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getPicturePath() != null) {
                        fusedCutOutFourPicturePath = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getPicturePath();
//                        fusedCutOutFourPicturePath = fusedCutOutFourPicturePath.substring(fusedCutOutFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutFour;
    }

    public JSONObject readFusedCutOutFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutFive != null && PoleTopEquipmentData.getInstance().fusedCutFive.size() > 0) {
            if (damageDetailsFusedCutFive == null)
                damageDetailsFusedCutFive = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getPicturePath() != null) {
                        fusedCutOutFivePicturePath = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getPicturePath();
//                        fusedCutOutFivePicturePath = fusedCutOutFivePicturePath.substring(fusedCutOutFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutFive;
    }

    public JSONObject readFusedCutOutSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutSix != null && PoleTopEquipmentData.getInstance().fusedCutSix.size() > 0) {
            if (damageDetailsFusedCutSix == null)
                damageDetailsFusedCutSix = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getPicturePath() != null) {
                        fusedCutOutSixPicturePath = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getPicturePath();
//                        fusedCutOutSixPicturePath = fusedCutOutSixPicturePath.substring(fusedCutOutSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutSix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutSix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutSix;
    }

    public JSONObject readFusedCutOutSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutSeven != null && PoleTopEquipmentData.getInstance().fusedCutSeven.size() > 0) {
            if (damageDetailsFusedCutSeven == null)
                damageDetailsFusedCutSeven = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getPicturePath() != null) {
                        fusedCutOutSevenPicturePath = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getPicturePath();
//                        fusedCutOutSevenPicturePath = fusedCutOutSevenPicturePath.substring(fusedCutOutSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutSeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutSeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutSeven;
    }

    public JSONObject readFusedCutOutEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutEight != null && PoleTopEquipmentData.getInstance().fusedCutEight.size() > 0) {
            if (damageDetailsFusedCutEight == null)
                damageDetailsFusedCutEight = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getPicturePath() != null) {
                        fusedCutOutEightPicturePath = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getPicturePath();
//                        fusedCutOutEightPicturePath = fusedCutOutEightPicturePath.substring(fusedCutOutEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutEight;
    }

    public JSONObject readFusedCutOutNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutNine != null && PoleTopEquipmentData.getInstance().fusedCutNine.size() > 0) {
            if (damageDetailsFusedCutNine == null)
                damageDetailsFusedCutNine = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getPicturePath() != null) {
                        fusedCutOutNinePicturePath = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getPicturePath();
//                        fusedCutOutNinePicturePath = fusedCutOutNinePicturePath.substring(fusedCutOutNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutNine;
    }


    public JSONObject readFusedCutOutTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().fusedCutTen != null && PoleTopEquipmentData.getInstance().fusedCutTen.size() > 0) {
            if (damageDetailsFusedCutTen == null)
                damageDetailsFusedCutTen = null;
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getPicturePath() != null) {
                        fusedCutOutTenPicturePath = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getPicturePath();
//                        fusedCutOutTenPicturePath = fusedCutOutTenPicturePath.substring(fusedCutOutTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsFusedCutTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().fusedCutTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsFusedCutTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsFusedCutTen;
    }

    public JSONObject readpoleAttacmentOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentOne != null && PoleTopEquipmentData.getInstance().poleAttacmentOne.size() > 0) {
            if (damageDetailsPoleAttachOne == null)
                damageDetailsPoleAttachOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getPicturePath() != null) {
                        poleAttachmentOnePicturePath = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getPicturePath();
//                        poleAttachmentOnePicturePath = poleAttachmentOnePicturePath.substring(poleAttachmentOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getTitle() != null) {
                        poleAttachTitle = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getTitle();
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachOne;
    }

    public JSONObject readpoleAttacmentTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentTwo != null && PoleTopEquipmentData.getInstance().poleAttacmentTwo.size() > 0) {
            if (damageDetailsPoleAttachTwo == null)
                damageDetailsPoleAttachTwo = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getPicturePath() != null) {
                        poleAttachmentTwoPicturePath = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getPicturePath();
//                        poleAttachmentTwoPicturePath = poleAttachmentTwoPicturePath.substring(poleAttachmentTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachTwo;
    }

    public JSONObject readpoleAttacmentThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentThree != null && PoleTopEquipmentData.getInstance().poleAttacmentThree.size() > 0) {
            if (damageDetailsPoleAttachThree == null)
                damageDetailsPoleAttachThree = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getPicturePath() != null) {
                        poleAttachmentThreePicturePath = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getPicturePath();
//                        poleAttachmentThreePicturePath = poleAttachmentThreePicturePath.substring(poleAttachmentThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachThree;
    }

    public JSONObject readpoleAttacmentFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentFour != null && PoleTopEquipmentData.getInstance().poleAttacmentFour.size() > 0) {
            if (damageDetailsPoleAttachFour == null)
                damageDetailsPoleAttachFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getPicturePath() != null) {
                        poleAttachmentFourPicturePath = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getPicturePath();
//                        poleAttachmentFourPicturePath = poleAttachmentFourPicturePath.substring(poleAttachmentFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachFour;
    }

    public JSONObject readpoleAttacmentFiveData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentFive != null && PoleTopEquipmentData.getInstance().poleAttacmentFive.size() > 0) {
            if (damageDetailsPoleAttachFive == null)
                damageDetailsPoleAttachFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getPicturePath() != null) {
                        poleAttachmentFivePicturePath = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getPicturePath();
//                        poleAttachmentFivePicturePath = poleAttachmentFivePicturePath.substring(poleAttachmentFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachFive;
    }

    public JSONObject readpoleAttacmentSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentSix != null && PoleTopEquipmentData.getInstance().poleAttacmentSix.size() > 0) {
            if (damageDetailsPoleAttachSix == null)
                damageDetailsPoleAttachSix = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getPicturePath() != null) {
                        poleAttachmentSixPicturePath = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getPicturePath();
//                        poleAttachmentSixPicturePath = poleAttachmentSixPicturePath.substring(poleAttachmentSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachSix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentSix.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachSix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachSix;
    }

    public JSONObject readpoleAttacmentSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentSeven != null && PoleTopEquipmentData.getInstance().poleAttacmentSeven.size() > 0) {
            if (damageDetailsPoleAttachSeven == null)
                damageDetailsPoleAttachSeven = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getPicturePath() != null) {
                        poleAttachmentSevenPicturePath = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getPicturePath();
//                        poleAttachmentSevenPicturePath = poleAttachmentSevenPicturePath.substring(poleAttachmentSevenPicturePath.lastIndexOf("/") + 1);
                    }

                    if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachSeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentSeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachSeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachSeven;
    }

    public JSONObject readpoleAttacmentEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentEight != null && PoleTopEquipmentData.getInstance().poleAttacmentEight.size() > 0) {
            if (damageDetailsPoleAttachEight == null)
                damageDetailsPoleAttachEight = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getPicturePath() != null) {
                        poleAttachmentEightPicturePath = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getPicturePath();
//                        poleAttachmentEightPicturePath = poleAttachmentEightPicturePath.substring(poleAttachmentEightPicturePath.lastIndexOf("/") + 1);
                    }

                    if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachEight;
    }

    public JSONObject readpoleAttacmentNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentNine != null && PoleTopEquipmentData.getInstance().poleAttacmentNine.size() > 0) {
            if (damageDetailsPoleAttachNine == null)
                damageDetailsPoleAttachNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getPicturePath() != null) {
                        poleAttachmentNinePicturePath = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getPicturePath();
//                        poleAttachmentNinePicturePath = poleAttachmentNinePicturePath.substring(poleAttachmentNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachNine;
    }

    public JSONObject readpoleAttacmentTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleAttacmentTen != null && PoleTopEquipmentData.getInstance().poleAttacmentTen.size() > 0) {
            if (damageDetailsPoleAttachTen == null)
                damageDetailsPoleAttachTen = null;
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentTen.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getPicturePath() != null) {
                        poleAttachmentTenPicturePath = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getPicturePath();
//                        poleAttachmentTenPicturePath = poleAttachmentTenPicturePath.substring(poleAttachmentTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getSubTitle() != null) {
                            damageDetailsPoleAttachTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleAttachTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleAttacmentTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleAttacmentTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleAttachTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleAttachTen;
    }
//
//    public JSONObject readstreetlightOneData() {
//        // Transformer defect One
//        addNote = null;
//        subtitle = null;
//        kvaSize = null;
//        displayName = null;
//        isSelected = false;
//        isChecked = false;
//        isUtilityOwned = false;
//        testType = null;
//        size = null;
//        if (PoleTopEquipmentData.getInstance().streetlightOne.size() > 0) {
//            try {
//                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightOne.size(); i++) {
//                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getTestType() != null) {
//                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
//                        testType = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getTestType();
//                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle() != null) {
//                            damageDetailsStreetLightOne.put(subtitle, testType);
//                        }
//                    }
//                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getNote() != null) {
//                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
//                        addNote = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getNote();
//                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle() != null) {
//                            damageDetailsStreetLightOne.put(subtitle, addNote);
//                        }
//                    }
//                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getCheckedOK() != null) {
//                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
//                        isChecked = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getCheckedOK();
//                        if (isChecked) {
//                            damageDetailsStreetLightOne.put(subtitle, isChecked);
//                        }
//                    }
//                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getIsUtilityOwned() != null) {
//                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
//                        isUtilityOwned = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getIsUtilityOwned();
//                        if (isUtilityOwned) {
//                            damageDetailsStreetLightOne.put(subtitle, isUtilityOwned);
//                        }
//                    }
//                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).get() != null) {
//                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
//                        testType = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getTestType();
//                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle() != null) {
//                            damageDetailsStreetLightOne.put(subtitle, testType);
//                        }
//                    }
//                }
//                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightOne.size(); i++) {
//                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getDisplayName() != null)
////                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
//                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getIsSelected() != null) {
//                            isSelected = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getIsSelected();
//                            displayName = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getDisplayName();
//                            if (isSelected) {
//                                displayName = displayName.replaceAll("\\s","");
//                                displayName = "is" + displayName;
//                                damageDetailsStreetLightOne.put(displayName, isSelected);
//                            }
//                        }
//                }
//            }catch(JSONException e){
//                e.printStackTrace();
//            }
//        } else {
//            return null;
//        }
//        return damageDetailsStreetLightOne;
//    }

    public JSONObject readpoleTopPinOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinOne != null && PoleTopEquipmentData.getInstance().poleTopPinOne.size() > 0) {
            if (damageDetailsPoleTopPinOne == null)
                damageDetailsPoleTopPinOne = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getPicturePath() != null) {
                        poleTopPinOnePicturePath = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getPicturePath();
//                        poleTopPinOnePicturePath = poleTopPinOnePicturePath.substring(poleTopPinOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getTitle() != null) {
                        poleTopPinTitle = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getTitle();
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinOne;
    }

    public JSONObject readpoleTopPinTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinTwo != null && PoleTopEquipmentData.getInstance().poleTopPinTwo.size() > 0) {
            if (damageDetailsPoleTopPinTwo == null)
                damageDetailsPoleTopPinTwo = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinTwo.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getPicturePath() != null) {
                        poleTopPinTwoPicturePath = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getPicturePath();
//                        poleTopPinTwoPicturePath = poleTopPinTwoPicturePath.substring(poleTopPinTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinTwo;
    }

    public JSONObject readpoleTopPinThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinThree != null && PoleTopEquipmentData.getInstance().poleTopPinThree.size() > 0) {
            if (damageDetailsPoleTopPinThree == null)
                damageDetailsPoleTopPinThree = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getPicturePath() != null) {
                        poleTopPinThreePicturePath = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getPicturePath();
//                        poleTopPinThreePicturePath = poleTopPinThreePicturePath.substring(poleTopPinThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinThree;
    }

    public JSONObject readpoleTopPinFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinFour != null && PoleTopEquipmentData.getInstance().poleTopPinFour.size() > 0) {
            if (damageDetailsPoleTopPinFour == null)
                damageDetailsPoleTopPinFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getPicturePath() != null) {
                        poleTopPinFourPicturePath = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getPicturePath();
//                        poleTopPinFourPicturePath = poleTopPinFourPicturePath.substring(poleTopPinFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinFour;
    }

    public JSONObject readpoleTopPinFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinFive != null && PoleTopEquipmentData.getInstance().poleTopPinFive.size() > 0) {
            if (damageDetailsPoleTopPinFive == null)
                damageDetailsPoleTopPinFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getPicturePath() != null) {
                        poleTopPinFivePicturePath = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getPicturePath();
//                        poleTopPinFivePicturePath = poleTopPinFivePicturePath.substring(poleTopPinFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinFive;
    }

    public JSONObject readpoleTopPinSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinSix != null && PoleTopEquipmentData.getInstance().poleTopPinSix.size() > 0) {
            if (damageDetailsPoleTopPinSix == null)
                damageDetailsPoleTopPinSix = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getPicturePath() != null) {
                        poleTopPinSixPicturePath = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getPicturePath();
//                        poleTopPinSixPicturePath = poleTopPinSixPicturePath.substring(poleTopPinSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinSix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinSix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinSix;
    }

    public JSONObject readpoleTopPinSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinSeven != null && PoleTopEquipmentData.getInstance().poleTopPinSeven.size() > 0) {
            if (damageDetailsPoleTopPinSeven == null)
                damageDetailsPoleTopPinSeven = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getPicturePath() != null) {
                        poleTopPinSevenPicturePath = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getPicturePath();
//                        poleTopPinSevenPicturePath = poleTopPinSevenPicturePath.substring(poleTopPinSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinSeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinSeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinSeven;
    }

    public JSONObject readpoleTopPinEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinEight != null && PoleTopEquipmentData.getInstance().poleTopPinEight.size() > 0) {
            if (damageDetailsPoleTopPinEight == null)
                damageDetailsPoleTopPinEight = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getPicturePath() != null) {
                        poleTopPinEightPicturePath = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getPicturePath();
//                        poleTopPinEightPicturePath = poleTopPinEightPicturePath.substring(poleTopPinEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinEight;
    }

    public JSONObject readpoleTopPinNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinNine != null && PoleTopEquipmentData.getInstance().poleTopPinNine.size() > 0) {
            if (damageDetailsPoleTopPinNine == null)
                damageDetailsPoleTopPinNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getPicturePath() != null) {
                        poleTopPinNinePicturePath = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getPicturePath();
//                        poleTopPinNinePicturePath = poleTopPinNinePicturePath.substring(poleTopPinNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinNine;
    }

    public JSONObject readpoleTopPinTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().poleTopPinTen != null && PoleTopEquipmentData.getInstance().poleTopPinTen.size() > 0) {
            if (damageDetailsPoleTopPinTen == null)
                damageDetailsPoleTopPinTen = null;

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getPicturePath() != null) {
                        poleTopPinTenPicturePath = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getPicturePath();
//                        poleTopPinTenPicturePath = poleTopPinTenPicturePath.substring(poleTopPinTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTopPinTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().poleTopPinTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsPoleTopPinTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTopPinTen;
    }

    public JSONObject readInsulatorOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorOne != null && PoleTopEquipmentData.getInstance().insulatorOne.size() > 0) {
            if (damageDetailsInsulatorOne == null)
                damageDetailsInsulatorOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getPicturePath() != null) {
                        insulatorOnePicturePath = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getPicturePath();
//                        insulatorOnePicturePath = insulatorOnePicturePath.substring(insulatorOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getTitle() != null) {
                        insulatorTitle = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getTitle();
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorOne;
    }

    public JSONObject readinsulatorTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorTwo != null && PoleTopEquipmentData.getInstance().insulatorTwo.size() > 0) {
            if (damageDetailsInsulatorTwo == null)
                damageDetailsInsulatorTwo = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getPicturePath() != null) {
                        insulatorTwoPicturePath = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getPicturePath();
//                        insulatorTwoPicturePath = insulatorTwoPicturePath.substring(insulatorTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorTwo;
    }

    public JSONObject readinsulatorThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorThree != null && PoleTopEquipmentData.getInstance().insulatorThree.size() > 0) {
            if (damageDetailsInsulatorThree == null)
                damageDetailsInsulatorThree = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorThree.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getPicturePath() != null) {
                        insulatorThreePicturePath = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getPicturePath();
//                        insulatorThreePicturePath = insulatorThreePicturePath.substring(insulatorThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorThree;
    }

    public JSONObject readinsulatorFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorFour != null && PoleTopEquipmentData.getInstance().insulatorFour.size() > 0) {
            if (damageDetailsInsulatorFour == null)
                damageDetailsInsulatorFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getPicturePath() != null) {
                        insulatorFourPicturePath = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getPicturePath();
//                        insulatorFourPicturePath = insulatorFourPicturePath.substring(insulatorFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorFour;
    }

    public JSONObject readinsulatorFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorFive != null && PoleTopEquipmentData.getInstance().insulatorFive.size() > 0) {
            if (damageDetailsInsulatorFive == null)
                damageDetailsInsulatorFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getPicturePath() != null) {
                        insulatorFivePicturePath = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getPicturePath();
//                        insulatorFivePicturePath = insulatorFivePicturePath.substring(insulatorFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorFive;
    }

    public JSONObject readinsulatorSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorSix != null && PoleTopEquipmentData.getInstance().insulatorSix.size() > 0) {
            if (damageDetailsInsulatorSix == null)
                damageDetailsInsulatorSix = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getPicturePath() != null) {
                        insulatorSixPicturePath = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getPicturePath();
//                        insulatorSixPicturePath = insulatorSixPicturePath.substring(insulatorSixPicturePath.lastIndexOf("/") + 1);
                    }

                    if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorSix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorSix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorSix;
    }

    public JSONObject readinsulatorSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorSeven != null && PoleTopEquipmentData.getInstance().insulatorSeven.size() > 0) {
            if (damageDetailsInsulatorSeven == null)
                damageDetailsInsulatorSeven = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorSeven.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getPicturePath() != null) {
                        insulatorSevenPicturePath = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getPicturePath();
//                        insulatorSevenPicturePath = insulatorSevenPicturePath.substring(insulatorSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorSeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorSeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorSeven;
    }

    public JSONObject readinsulatorEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorEight != null && PoleTopEquipmentData.getInstance().insulatorEight.size() > 0) {
            if (damageDetailsInsulatorEight == null)
                damageDetailsInsulatorEight = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getPicturePath() != null) {
                        insulatorEightPicturePath = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getPicturePath();
//                        insulatorEightPicturePath = insulatorEightPicturePath.substring(insulatorEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorEight;
    }

    public JSONObject readinsulatorNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorNine != null && PoleTopEquipmentData.getInstance().insulatorNine.size() > 0) {
            if (damageDetailsInsulatorNine == null)
                damageDetailsInsulatorNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getPicturePath() != null) {
                        insulatorNinePicturePath = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getPicturePath();
//                        insulatorNinePicturePath = insulatorNinePicturePath.substring(insulatorNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorNine;
    }

    public JSONObject readinsulatorTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().insulatorTen != null && PoleTopEquipmentData.getInstance().insulatorTen.size() > 0) {
            if (damageDetailsInsulatorTen == null)
                damageDetailsInsulatorTen = null;
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getPicturePath() != null) {
                        insulatorTenPicturePath = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getPicturePath();
//                        insulatorTenPicturePath = insulatorTenPicturePath.substring(insulatorTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsInsulatorTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().insulatorTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsInsulatorTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsInsulatorTen;
    }

    public JSONObject readprimaryOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryOne != null && PoleTopEquipmentData.getInstance().primaryOne.size() > 0) {
            if (damageDetailsPrimaryOne == null)
                damageDetailsPrimaryOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getPicturePath() != null) {
                        primaryOnePicturePath = PoleTopEquipmentData.getInstance().primaryOne.get(i).getPicturePath();
//                        primaryOnePicturePath = primaryOnePicturePath.substring(primaryOnePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getKvaSize() != null) {
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryOne.get(i).getTitle();
                    }*/
                    if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryOne.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryOne;
    }

    public JSONObject readprimaryTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryTwo != null && PoleTopEquipmentData.getInstance().primaryTwo.size() > 0) {
            if (damageDetailsPrimaryTwo == null)
                damageDetailsPrimaryTwo = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getPicturePath() != null) {
                        primaryTwoPicturePath = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getPicturePath();
//                        primaryTwoPicturePath = primaryTwoPicturePath.substring(primaryTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryTwo;
    }

    public JSONObject readprimaryThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryThree != null && PoleTopEquipmentData.getInstance().primaryThree.size() > 0) {
            if (damageDetailsPrimaryThree == null)
                damageDetailsPrimaryThree = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getPicturePath() != null) {
                        primaryThreePicturePath = PoleTopEquipmentData.getInstance().primaryThree.get(i).getPicturePath();
//                        primaryThreePicturePath = primaryThreePicturePath.substring(primaryThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryThree.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryThree;
    }

    public JSONObject readprimaryFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryFour != null && PoleTopEquipmentData.getInstance().primaryFour.size() > 0) {
            if (damageDetailsPrimaryFour == null)
                damageDetailsPrimaryFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getPicturePath() != null) {
                        primaryFourPicturePath = PoleTopEquipmentData.getInstance().primaryFour.get(i).getPicturePath();
//                        primaryFourPicturePath = primaryFourPicturePath.substring(primaryFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryFour.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryFour;
    }

    public JSONObject readprimaryFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryFive != null && PoleTopEquipmentData.getInstance().primaryFive.size() > 0) {
            if (damageDetailsPrimaryFive == null)
                damageDetailsPrimaryFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getPicturePath() != null) {
                        primaryFivePicturePath = PoleTopEquipmentData.getInstance().primaryFive.get(i).getPicturePath();
//                        primaryFivePicturePath = primaryFivePicturePath.substring(primaryFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryFive.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryFive;
    }

    public JSONObject readprimarySixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primarySix != null && PoleTopEquipmentData.getInstance().primarySix.size() > 0) {
            if (damageDetailsPrimarySix == null)
                damageDetailsPrimarySix = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primarySix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primarySix.get(i).getPicturePath() != null) {
                        primarySixPicturePath = PoleTopEquipmentData.getInstance().primarySix.get(i).getPicturePath();
//                        primarySixPicturePath = primarySixPicturePath.substring(primarySixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().primarySix.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primarySix.get(i).getTitle();

                    if (PoleTopEquipmentData.getInstance().primarySix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primarySix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primarySix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primarySix.get(i).getSubTitle() != null) {
                            damageDetailsPrimarySix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primarySix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primarySix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primarySix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primarySix.get(i).getSubTitle() != null) {
                            damageDetailsPrimarySix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primarySix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primarySix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primarySix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimarySix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primarySix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primarySix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primarySix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primarySix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primarySix.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimarySix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimarySix;
    }

    public JSONObject readprimarySevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primarySeven != null && PoleTopEquipmentData.getInstance().primarySeven.size() > 0) {
            if (damageDetailsPrimarySeven == null)
                damageDetailsPrimarySeven = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primarySeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getPicturePath() != null) {
                        primarySevenPicturePath = PoleTopEquipmentData.getInstance().primarySeven.get(i).getPicturePath();
//                        primarySevenPicturePath = primarySevenPicturePath.substring(primarySevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primarySeven.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primarySeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primarySeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getSubTitle() != null) {
                            damageDetailsPrimarySeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primarySeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primarySeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getSubTitle() != null) {
                            damageDetailsPrimarySeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primarySeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primarySeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimarySeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primarySeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primarySeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primarySeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primarySeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimarySeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimarySeven;
    }

    public JSONObject readprimaryEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryEight != null && PoleTopEquipmentData.getInstance().primaryEight.size() > 0) {
            if (damageDetailsPrimaryEight == null)
                damageDetailsPrimaryEight = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getPicturePath() != null) {
                        primaryEightPicturePath = PoleTopEquipmentData.getInstance().primaryEight.get(i).getPicturePath();
//                        primaryEightPicturePath = primaryEightPicturePath.substring(primaryEightPicturePath.lastIndexOf("/") + 1);
                    }

                    if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryEight.get(i).getTitle();

                    if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryEight;
    }

    public JSONObject readprimaryNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryNine != null && PoleTopEquipmentData.getInstance().primaryNine.size() > 0) {
            if (damageDetailsPrimaryNine == null)
                damageDetailsPrimaryNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getPicturePath() != null) {
                        primaryNinePicturePath = PoleTopEquipmentData.getInstance().primaryNine.get(i).getPicturePath();
//                        primaryNinePicturePath = primaryNinePicturePath.substring(primaryNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryNine.get(i).getTitle();

                    if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryNine;
    }

    public JSONObject readPrimaryTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().primaryTen != null && PoleTopEquipmentData.getInstance().primaryTen.size() > 0) {
            if (damageDetailsPrimaryTen == null)
                damageDetailsPrimaryTen = null;

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getPicturePath() != null) {
                        primaryTenPicturePath = PoleTopEquipmentData.getInstance().primaryTen.get(i).getPicturePath();
//                        primaryTenPicturePath = primaryTenPicturePath.substring(primaryTenPicturePath.lastIndexOf("/") + 1);
                    }

                    if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getTitle() != null)
                        primaryTitle = PoleTopEquipmentData.getInstance().primaryTen.get(i).getTitle();

                    if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().primaryTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().primaryTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getSubTitle() != null) {
                            damageDetailsPrimaryTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().primaryTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().primaryTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPrimaryTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().primaryTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().primaryTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().primaryTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().primaryTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsPrimaryTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPrimaryTen;
    }

    public JSONObject readsecondaryOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryOne != null && PoleTopEquipmentData.getInstance().secondaryOne.size() > 0) {
            if (damageDetailssecondaryOne == null)
                damageDetailssecondaryOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getPicturePath() != null) {
                        secondaryOnePicturePath = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getPicturePath();
//                        secondaryOnePicturePath = secondaryOnePicturePath.substring(secondaryOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getTitle() != null) {
                        secondaryTitle = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getTitle();
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getSubTitle() != null) {
                            damageDetailssecondaryOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getSubTitle() != null) {
                            damageDetailssecondaryOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryOne.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryOne;
    }

    public JSONObject readsecondaryTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryTwo != null && PoleTopEquipmentData.getInstance().secondaryTwo.size() > 0) {
            if (damageDetailssecondaryTwo == null)
                damageDetailssecondaryTwo = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getPicturePath() != null) {
                        secondaryTwoPicturePath = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getPicturePath();
//                        secondaryTwoPicturePath = secondaryTwoPicturePath.substring(secondaryTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getSubTitle() != null) {
                            damageDetailssecondaryTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getSubTitle() != null) {
                            damageDetailssecondaryTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryTwo;
    }

    public JSONObject readsecondaryThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryThree != null && PoleTopEquipmentData.getInstance().secondaryThree.size() > 0) {
            if (damageDetailssecondaryThree == null)
                damageDetailssecondaryThree = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getPicturePath() != null) {
                        secondaryThreePicturePath = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getPicturePath();
//                        secondaryThreePicturePath = secondaryThreePicturePath.substring(secondaryThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getSubTitle() != null) {
                            damageDetailssecondaryThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getSubTitle() != null) {
                            damageDetailssecondaryThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryThree.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryThree;
    }

    public JSONObject readsecondaryFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryFour != null && PoleTopEquipmentData.getInstance().secondaryFour.size() > 0) {
            if (damageDetailssecondaryFour == null)
                damageDetailssecondaryFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getPicturePath() != null) {
                        secondaryFourPicturePath = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getPicturePath();
//                        secondaryFourPicturePath = secondaryFourPicturePath.substring(secondaryFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getSubTitle() != null) {
                            damageDetailssecondaryFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getSubTitle() != null) {
                            damageDetailssecondaryFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryFour.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryFour;
    }

    public JSONObject readsecondaryFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryFive != null && PoleTopEquipmentData.getInstance().secondaryFive.size() > 0) {
            if (damageDetailssecondaryFive == null)
                damageDetailssecondaryFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getPicturePath() != null) {
                        secondaryFivePicturePath = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getPicturePath();
//                        secondaryFivePicturePath = secondaryFivePicturePath.substring(secondaryFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getSubTitle() != null) {
                            damageDetailssecondaryFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getSubTitle() != null) {
                            damageDetailssecondaryFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryFive.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryFive;
    }

    public JSONObject readsecondarySixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondarySix != null && PoleTopEquipmentData.getInstance().secondarySix.size() > 0) {
            if (damageDetailssecondarySix == null)
                damageDetailssecondarySix = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondarySix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getPicturePath() != null) {
                        secondarySixPicturePath = PoleTopEquipmentData.getInstance().secondarySix.get(i).getPicturePath();
//                        secondarySixPicturePath = secondarySixPicturePath.substring(secondarySixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondarySix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondarySix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getSubTitle() != null) {
                            damageDetailssecondarySix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondarySix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondarySix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getSubTitle() != null) {
                            damageDetailssecondarySix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondarySix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondarySix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondarySix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondarySix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondarySix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondarySix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondarySix.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondarySix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondarySix;
    }

    public JSONObject readsecondarySevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondarySeven != null && PoleTopEquipmentData.getInstance().secondarySeven.size() > 0) {
            if (damageDetailssecondarySeven == null)
                damageDetailssecondarySeven = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondarySeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getPicturePath() != null) {
                        secondarySevenPicturePath = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getPicturePath();
//                        secondarySevenPicturePath = secondarySevenPicturePath.substring(secondarySevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getSubTitle() != null) {
                            damageDetailssecondarySeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getSubTitle() != null) {
                            damageDetailssecondarySeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondarySeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondarySeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondarySeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondarySeven.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondarySeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondarySeven;
    }

    public JSONObject readsecondaryEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryEight != null && PoleTopEquipmentData.getInstance().secondaryEight.size() > 0) {
            if (damageDetailssecondaryEight == null)
                damageDetailssecondaryEight = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getPicturePath() != null) {
                        secondaryEightPicturePath = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getPicturePath();
//                        secondaryEightPicturePath = secondaryEightPicturePath.substring(secondaryEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getSubTitle() != null) {
                            damageDetailssecondaryEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getSubTitle() != null) {
                            damageDetailssecondaryEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryEight.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryEight;
    }

    public JSONObject readsecondaryNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryNine != null && PoleTopEquipmentData.getInstance().secondaryNine.size() > 0) {
            if (damageDetailssecondaryNine == null)
                damageDetailssecondaryNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getPicturePath() != null) {
                        secondaryNinePicturePath = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getPicturePath();
//                        secondaryNinePicturePath = secondaryNinePicturePath.substring(secondaryNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getSubTitle() != null) {
                            damageDetailssecondaryNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getSubTitle() != null) {
                            damageDetailssecondaryNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryNine.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryNine;
    }

    public JSONObject readsecondaryTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().secondaryTen != null && PoleTopEquipmentData.getInstance().secondaryTen.size() > 0) {
            if (damageDetailssecondaryTen == null)
                damageDetailssecondaryTen = null;

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getPicturePath() != null) {
                        secondaryTenPicturePath = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getPicturePath();
//                        secondaryTenPicturePath = secondaryTenPicturePath.substring(secondaryTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getSubTitle() != null) {
                            damageDetailssecondaryTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getSubTitle() != null) {
                            damageDetailssecondaryTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().secondaryTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().secondaryTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().secondaryTen.get(i).getName();
                            if (isSelected) {

                                damageDetailssecondaryTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryTen;
    }

    public JSONObject readserviceWireOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireOne != null && PoleTopEquipmentData.getInstance().serviceWireOne.size() > 0) {
            if (damageDetailsserviceWireOne == null)
                damageDetailsserviceWireOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getPicturePath() != null) {
                        serviceWireOnePicturePath = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getPicturePath();
//                        serviceWireOnePicturePath = serviceWireOnePicturePath.substring(serviceWireOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getTitle() != null)
                        serviceWireTitle = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getTitle();
                    if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireOne;
    }

    public JSONObject readserviceWireTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireTwo != null && PoleTopEquipmentData.getInstance().serviceWireTwo.size() > 0) {
            if (damageDetailsserviceWireTwo == null)
                damageDetailsserviceWireTwo = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getPicturePath() != null) {
                        serviceWireTwoPicturePath = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getPicturePath();
//                        serviceWireTwoPicturePath = serviceWireTwoPicturePath.substring(serviceWireTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireTwo.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireTwo;
    }

    public JSONObject readserviceWireThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireThree != null && PoleTopEquipmentData.getInstance().serviceWireThree.size() > 0) {
            if (damageDetailsserviceWireThree == null)
                damageDetailsserviceWireThree = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getPicturePath() != null) {
                        serviceWireThreePicturePath = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getPicturePath();
//                        serviceWireThreePicturePath = serviceWireThreePicturePath.substring(serviceWireThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireThree.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireThree;
    }

    public JSONObject readserviceWireFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireFour != null && PoleTopEquipmentData.getInstance().serviceWireFour.size() > 0) {
            if (damageDetailsserviceWireFour == null)
                damageDetailsserviceWireFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getPicturePath() != null) {
                        serviceWireFourPicturePath = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getPicturePath();
//                        serviceWireFourPicturePath = serviceWireFourPicturePath.substring(serviceWireFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireFour.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireFour;
    }

    public JSONObject readserviceWireFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireFive != null && PoleTopEquipmentData.getInstance().serviceWireFive.size() > 0) {
            if (damageDetailsserviceWireFive == null)
                damageDetailsserviceWireFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getPicturePath() != null) {
                        serviceWireFivePicturePath = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getPicturePath();
//                        serviceWireFivePicturePath = serviceWireFivePicturePath.substring(serviceWireFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireFive.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireFive;
    }

    public JSONObject readserviceWireSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireSix != null && PoleTopEquipmentData.getInstance().serviceWireSix.size() > 0) {
            if (damageDetailsserviceWireSix == null)
                damageDetailsserviceWireSix = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getPicturePath() != null) {
                        serviceWireSixPicturePath = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getPicturePath();
//                        serviceWireSixPicturePath = serviceWireSixPicturePath.substring(serviceWireSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireSix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireSix.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireSix.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireSix;
    }

    public JSONObject readserviceWireSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireSeven != null && PoleTopEquipmentData.getInstance().serviceWireSeven.size() > 0) {
            if (damageDetailsserviceWireSeven == null)
                damageDetailsserviceWireSeven = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireSeven.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getPicturePath() != null) {
                        serviceWireSevenPicturePath = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getPicturePath();
//                        serviceWireSevenPicturePath = serviceWireSevenPicturePath.substring(serviceWireSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireSeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireSeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireSeven.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireSeven;
    }

    public JSONObject readserviceWireEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireEight != null && PoleTopEquipmentData.getInstance().serviceWireEight.size() > 0) {
            if (damageDetailsserviceWireEight == null)
                damageDetailsserviceWireEight = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getPicturePath() != null) {
                        serviceWireEightPicturePath = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getPicturePath();
//                        serviceWireEightPicturePath = serviceWireEightPicturePath.substring(serviceWireEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireEight.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireEight;
    }

    public JSONObject readserviceWireNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireNine != null && PoleTopEquipmentData.getInstance().serviceWireNine.size() > 0) {
            if (damageDetailsserviceWireNine == null)
                damageDetailsserviceWireNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getPicturePath() != null) {
                        serviceWireNinePicturePath = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getPicturePath();
//                        serviceWireNinePicturePath = serviceWireNinePicturePath.substring(serviceWireNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireNine.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireNine;
    }

    public JSONObject readserviceWireTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().serviceWireTen != null && PoleTopEquipmentData.getInstance().serviceWireTen.size() > 0) {
            if (damageDetailsserviceWireTen == null)
                damageDetailsserviceWireTen = null;
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getPicturePath() != null) {
                        serviceWireTenPicturePath = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getPicturePath();
//                        serviceWireTenPicturePath = serviceWireTenPicturePath.substring(serviceWireTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getSubTitle() != null) {
                            damageDetailsserviceWireTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsserviceWireTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().serviceWireTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().serviceWireTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsserviceWireTen.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsserviceWireTen;
    }

    public void resetAllReference() {
        try {
            clearPicturePath();
            PoleTopEquipmentData.getInstance().transformerOne.clear();
            PoleTopEquipmentData.getInstance().transformerOne.removeAll(PoleTopEquipmentData.getInstance().transformerOne);
            PoleTopEquipmentData.getInstance().transformerTwo.clear();
            PoleTopEquipmentData.getInstance().transformerThree.clear();
            PoleTopEquipmentData.getInstance().transformerFour.clear();
            PoleTopEquipmentData.getInstance().transformerFive.clear();
            PoleTopEquipmentData.getInstance().transformerSix.clear();
            PoleTopEquipmentData.getInstance().transformerSeven.clear();
            PoleTopEquipmentData.getInstance().transformerEight.clear();
            PoleTopEquipmentData.getInstance().transformerNine.clear();
            PoleTopEquipmentData.getInstance().transformerTen.clear();

            PoleTopEquipmentData.getInstance().crossArmOne.clear();
            PoleTopEquipmentData.getInstance().crossArmTwo.clear();
            PoleTopEquipmentData.getInstance().crossArmThree.clear();
            PoleTopEquipmentData.getInstance().crossArmFour.clear();
            PoleTopEquipmentData.getInstance().crossArmFive.clear();
            PoleTopEquipmentData.getInstance().crossArmSix.clear();
            PoleTopEquipmentData.getInstance().crossArmSeven.clear();
            PoleTopEquipmentData.getInstance().crossArmEight.clear();
            PoleTopEquipmentData.getInstance().crossArmNine.clear();
            PoleTopEquipmentData.getInstance().crossArmTen.clear();

            PoleTopEquipmentData.getInstance().fusedCutOne.clear();
            PoleTopEquipmentData.getInstance().fusedCutTwo.clear();
            PoleTopEquipmentData.getInstance().fusedCutThree.clear();
            PoleTopEquipmentData.getInstance().fusedCutFour.clear();
            PoleTopEquipmentData.getInstance().fusedCutFive.clear();
            PoleTopEquipmentData.getInstance().fusedCutSix.clear();
            PoleTopEquipmentData.getInstance().fusedCutSeven.clear();
            PoleTopEquipmentData.getInstance().fusedCutEight.clear();
            PoleTopEquipmentData.getInstance().fusedCutNine.clear();
            PoleTopEquipmentData.getInstance().fusedCutTen.clear();

            PoleTopEquipmentData.getInstance().poleAttacmentOne.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentTwo.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentThree.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentFour.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentFive.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentSix.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentSeven.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentEight.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentNine.clear();
            PoleTopEquipmentData.getInstance().poleAttacmentTen.clear();

            PoleTopEquipmentData.getInstance().streetlightOne.clear();
            PoleTopEquipmentData.getInstance().streetlightTwo.clear();
            PoleTopEquipmentData.getInstance().streetlightThree.clear();
            PoleTopEquipmentData.getInstance().streetlightFour.clear();
            PoleTopEquipmentData.getInstance().streetlightFive.clear();
            PoleTopEquipmentData.getInstance().streetlightSix.clear();
            PoleTopEquipmentData.getInstance().streetlightSeven.clear();
            PoleTopEquipmentData.getInstance().streetlightEight.clear();
            PoleTopEquipmentData.getInstance().streetlightNine.clear();
            PoleTopEquipmentData.getInstance().streetlightTen.clear();

            PoleTopEquipmentData.getInstance().poleTopPinOne.clear();
            PoleTopEquipmentData.getInstance().poleTopPinTwo.clear();
            PoleTopEquipmentData.getInstance().poleTopPinThree.clear();
            PoleTopEquipmentData.getInstance().poleTopPinFour.clear();
            PoleTopEquipmentData.getInstance().poleTopPinFive.clear();
            PoleTopEquipmentData.getInstance().poleTopPinSix.clear();
            PoleTopEquipmentData.getInstance().poleTopPinSeven.clear();
            PoleTopEquipmentData.getInstance().poleTopPinEight.clear();
            PoleTopEquipmentData.getInstance().poleTopPinNine.clear();
            PoleTopEquipmentData.getInstance().poleTopPinTen.clear();

            PoleTopEquipmentData.getInstance().insulatorOne.clear();
            PoleTopEquipmentData.getInstance().insulatorTwo.clear();
            PoleTopEquipmentData.getInstance().insulatorThree.clear();
            PoleTopEquipmentData.getInstance().insulatorFour.clear();
            PoleTopEquipmentData.getInstance().insulatorFive.clear();
            PoleTopEquipmentData.getInstance().insulatorSix.clear();
            PoleTopEquipmentData.getInstance().insulatorSeven.clear();
            PoleTopEquipmentData.getInstance().insulatorEight.clear();
            PoleTopEquipmentData.getInstance().insulatorNine.clear();
            PoleTopEquipmentData.getInstance().insulatorTen.clear();

            PoleTopEquipmentData.getInstance().primaryOne.clear();
            PoleTopEquipmentData.getInstance().primaryTwo.clear();
            PoleTopEquipmentData.getInstance().primaryThree.clear();
            PoleTopEquipmentData.getInstance().primaryFour.clear();
            PoleTopEquipmentData.getInstance().primaryFive.clear();
            PoleTopEquipmentData.getInstance().primarySix.clear();
            PoleTopEquipmentData.getInstance().primarySeven.clear();
            PoleTopEquipmentData.getInstance().primaryEight.clear();
            PoleTopEquipmentData.getInstance().primaryNine.clear();
            PoleTopEquipmentData.getInstance().primaryTen.clear();

            PoleTopEquipmentData.getInstance().secondaryOne.clear();
            PoleTopEquipmentData.getInstance().secondaryTwo.clear();
            PoleTopEquipmentData.getInstance().secondaryThree.clear();
            PoleTopEquipmentData.getInstance().secondaryFour.clear();
            PoleTopEquipmentData.getInstance().secondaryFive.clear();
            PoleTopEquipmentData.getInstance().secondarySix.clear();
            PoleTopEquipmentData.getInstance().secondarySeven.clear();
            PoleTopEquipmentData.getInstance().secondaryEight.clear();
            PoleTopEquipmentData.getInstance().secondaryNine.clear();
            PoleTopEquipmentData.getInstance().secondaryTen.clear();

            PoleTopEquipmentData.getInstance().serviceWireOne.clear();
            PoleTopEquipmentData.getInstance().serviceWireTwo.clear();
            PoleTopEquipmentData.getInstance().serviceWireThree.clear();
            PoleTopEquipmentData.getInstance().serviceWireFour.clear();
            PoleTopEquipmentData.getInstance().serviceWireFive.clear();
            PoleTopEquipmentData.getInstance().serviceWireSix.clear();
            PoleTopEquipmentData.getInstance().serviceWireSeven.clear();
            PoleTopEquipmentData.getInstance().serviceWireEight.clear();
            PoleTopEquipmentData.getInstance().serviceWireNine.clear();
            PoleTopEquipmentData.getInstance().serviceWireTen.clear();
        } catch (NullPointerException e) {

        }
    }

    private void clearPicturePath() {
        transOnePicturePath = null;
        transTwoPicturePath = null;
        transThreePicturePath = null;
        transFourPicturePath = null;
        transFivePicturePath = null;
        transSixPicturePath = null;
        transSevenPicturePath = null;
        transEightPicturePath = null;
        transNinePicturePath = null;
        transTenPicturePath = null;

        crossArmOnePicturePath = null;
        crossArmTwoPicturePath = null;
        crossArmThreePicturePath = null;
        crossArmFourPicturePath = null;
        crossArmFivePicturePath = null;
        crossArmSixPicturePath = null;
        crossArmSevenPicturePath = null;
        crossArmEightPicturePath = null;
        crossArmNinePicturePath = null;
        crossArmTenPicturePath = null;

        fusedCutOutOnePicturePath = null;
        fusedCutOutTwoPicturePath = null;
        fusedCutOutThreePicturePath = null;
        fusedCutOutFourPicturePath = null;
        fusedCutOutFivePicturePath = null;
        fusedCutOutSixPicturePath = null;
        fusedCutOutSevenPicturePath = null;
        fusedCutOutEightPicturePath = null;
        fusedCutOutNinePicturePath = null;
        fusedCutOutTenPicturePath = null;

        poleAttachmentOnePicturePath = null;
        poleAttachmentTwoPicturePath = null;
        poleAttachmentThreePicturePath = null;
        poleAttachmentFourPicturePath = null;
        poleAttachmentFivePicturePath = null;
        poleAttachmentSixPicturePath = null;
        poleAttachmentSevenPicturePath = null;
        poleAttachmentEightPicturePath = null;
        poleAttachmentNinePicturePath = null;
        poleAttachmentTenPicturePath = null;

        streetLightOnePicturePath = null;
        streetLightTwoPicturePath = null;
        streetLightThreePicturePath = null;
        streetLightFourPicturePath = null;
        streetLightFivePicturePath = null;
        streetLightSixPicturePath = null;
        streetLightSevenPicturePath = null;
        streetLightEightPicturePath = null;
        streetLightNinePicturePath = null;
        streetLightTenPicturePath = null;

        poleTopPinOnePicturePath = null;
        poleTopPinTwoPicturePath = null;
        poleTopPinThreePicturePath = null;
        poleTopPinFourPicturePath = null;
        poleTopPinFivePicturePath = null;
        poleTopPinSixPicturePath = null;
        poleTopPinSevenPicturePath = null;
        poleTopPinEightPicturePath = null;
        poleTopPinNinePicturePath = null;
        poleTopPinTenPicturePath = null;

        insulatorOnePicturePath = null;
        insulatorTwoPicturePath = null;
        insulatorThreePicturePath = null;
        insulatorFourPicturePath = null;
        insulatorFivePicturePath = null;
        insulatorSixPicturePath = null;
        insulatorSevenPicturePath = null;
        insulatorEightPicturePath = null;
        insulatorNinePicturePath = null;
        insulatorTenPicturePath = null;

        primaryOnePicturePath = null;
        primaryTwoPicturePath = null;
        primaryThreePicturePath = null;
        primaryFourPicturePath = null;
        primaryFivePicturePath = null;
        primarySixPicturePath = null;
        primarySevenPicturePath = null;
        primaryEightPicturePath = null;
        primaryNinePicturePath = null;
        primaryTenPicturePath = null;

        secondaryOnePicturePath = null;
        secondaryTwoPicturePath = null;
        secondaryThreePicturePath = null;
        secondaryFourPicturePath = null;
        secondaryFivePicturePath = null;
        secondarySixPicturePath = null;
        secondarySevenPicturePath = null;
        secondaryEightPicturePath = null;
        secondaryNinePicturePath = null;
        secondaryTenPicturePath = null;

        serviceWireOnePicturePath = null;
        serviceWireTwoPicturePath = null;
        serviceWireThreePicturePath = null;
        serviceWireFourPicturePath = null;
        serviceWireFivePicturePath = null;
        serviceWireSixPicturePath = null;
        serviceWireSevenPicturePath = null;
        serviceWireEightPicturePath = null;
        serviceWireNinePicturePath = null;
        serviceWireTenPicturePath = null;
    }

    public void resetALLJSONObject() {
        damageDetailsTransOne = null;
        damageDetailsTransTwo = null;
        damageDetailsTransThree = null;
        damageDetailsTransFour = null;
        damageDetailsTransFive = null;
        damageDetailsTransSix = null;
        damageDetailsTransSeven = null;
        damageDetailsTransEight = null;
        damageDetailsTransNine = null;
        damageDetailsTransTen = null;

        damageDetailsCrossArmOne = null;
        damageDetailsCrossArmTwo = null;
        damageDetailsCrossArmThree = null;
        damageDetailsCrossArmFour = null;
        damageDetailsCrossArmFive = null;
        damageDetailsCrossArmSix = null;
        damageDetailsCrossArmSeven = null;
        damageDetailsCrossArmEight = null;
        damageDetailsCrossArmNine = null;
        damageDetailsCrossArmTen = null;

        damageDetailsFusedCutOne = null;
        damageDetailsFusedCutTwo = null;
        damageDetailsFusedCutThree = null;
        damageDetailsFusedCutFour = null;
        damageDetailsFusedCutFive = null;
        damageDetailsFusedCutSix = null;
        damageDetailsFusedCutSeven = null;
        damageDetailsFusedCutEight = null;
        damageDetailsFusedCutNine = null;
        damageDetailsFusedCutTen = null;

        damageDetailsPoleAttachOne = null;
        damageDetailsPoleAttachTwo = null;
        damageDetailsPoleAttachThree = null;
        damageDetailsPoleAttachFour = null;
        damageDetailsPoleAttachFive = null;
        damageDetailsPoleAttachSix = null;
        damageDetailsPoleAttachSeven = null;
        damageDetailsPoleAttachEight = null;
        damageDetailsPoleAttachNine = null;
        damageDetailsPoleAttachTen = null;

        damageDetailsStreetLightOne = null;
        damageDetailsStreetLightTwo = null;
        damageDetailsStreetLightThree = null;
        damageDetailsStreetLightFour = null;
        damageDetailsStreetLightFive = null;
        damageDetailsStreetLightSix = null;
        damageDetailsStreetLightSeven = null;
        damageDetailsStreetLightEight = null;
        damageDetailsStreetLightNine = null;
        damageDetailsStreetLightTen = null;

        damageDetailsPoleTopPinOne = null;
        damageDetailsPoleTopPinTwo = null;
        damageDetailsPoleTopPinThree = null;
        damageDetailsPoleTopPinFour = null;
        damageDetailsPoleTopPinFive = null;
        damageDetailsPoleTopPinSix = null;
        damageDetailsPoleTopPinSeven = null;
        damageDetailsPoleTopPinEight = null;
        damageDetailsPoleTopPinNine = null;
        damageDetailsPoleTopPinTen = null;

        damageDetailsInsulatorOne = null;
        damageDetailsInsulatorTwo = null;
        damageDetailsInsulatorThree = null;
        damageDetailsInsulatorFour = null;
        damageDetailsInsulatorFive = null;
        damageDetailsInsulatorSix = null;
        damageDetailsInsulatorSeven = null;
        damageDetailsInsulatorEight = null;
        damageDetailsInsulatorNine = null;
        damageDetailsInsulatorTen = null;

        damageDetailsPrimaryOne = null;
        damageDetailsPrimaryTwo = null;
        damageDetailsPrimaryThree = null;
        damageDetailsPrimaryFour = null;
        damageDetailsPrimaryFive = null;
        damageDetailsPrimarySix = null;
        damageDetailsPrimarySeven = null;
        damageDetailsPrimaryEight = null;
        damageDetailsPrimaryNine = null;
        damageDetailsPrimaryTen = null;

        damageDetailssecondaryOne = null;
        damageDetailssecondaryTwo = null;
        damageDetailssecondaryThree = null;
        damageDetailssecondaryFour = null;
        damageDetailssecondaryFive = null;
        damageDetailssecondarySix = null;
        damageDetailssecondarySeven = null;
        damageDetailssecondaryEight = null;
        damageDetailssecondaryNine = null;
        damageDetailssecondaryTen = null;

        damageDetailsserviceWireOne = null;
        damageDetailsserviceWireTwo = null;
        damageDetailsserviceWireThree = null;
        damageDetailsserviceWireFour = null;
        damageDetailsserviceWireFive = null;
        damageDetailsserviceWireSix = null;
        damageDetailsserviceWireSeven = null;
        damageDetailsserviceWireEight = null;
        damageDetailsserviceWireNine = null;
        damageDetailsserviceWireTen = null;

    }
}
