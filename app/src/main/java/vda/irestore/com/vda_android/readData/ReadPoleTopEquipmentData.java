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
            streetlightOnePicturePath = null, streetlightTwoPicturePath = null, streetlightThreePicturePath = null, streetlightFourPicturePath = null, streetlightFivePicturePath = null, streetlightSixPicturePath = null, streetlightSevenPicturePath = null, streetlightEightPicturePath = null, streetlightNinePicturePath = null, streetlightTenPicturePath = null,
            poleTopPinOnePicturePath = null, poleTopPinTwoPicturePath = null, poleTopPinThreePicturePath = null, poleTopPinFourPicturePath = null, poleTopPinFivePicturePath = null, poleTopPinSixPicturePath = null, poleTopPinSevenPicturePath = null, poleTopPinEightPicturePath = null, poleTopPinNinePicturePath = null, poleTopPinTenPicturePath = null,
            insulatorOnePicturePath = null, insulatorTwoPicturePath = null, insulatorThreePicturePath = null, insulatorFourPicturePath = null, insulatorFivePicturePath = null, insulatorSixPicturePath = null, insulatorSevenPicturePath = null, insulatorEightPicturePath = null, insulatorNinePicturePath = null, insulatorTenPicturePath = null,
            primaryOnePicturePath = null, primaryTwoPicturePath = null, primaryThreePicturePath = null, primaryFourPicturePath = null, primaryFivePicturePath = null, primarySixPicturePath = null, primarySevenPicturePath = null, primaryEightPicturePath = null, primaryNinePicturePath = null, primaryTenPicturePath = null,
            secondaryOnePicturePath = null, secondaryTwoPicturePath = null, secondaryThreePicturePath = null, secondaryFourPicturePath = null, secondaryFivePicturePath = null, secondarySixPicturePath = null, secondarySevenPicturePath = null, secondaryEightPicturePath = null, secondaryNinePicturePath = null, secondaryTenPicturePath = null,
            serviceWireOnePicturePath = null, serviceWireTwoPicturePath = null, serviceWireThreePicturePath = null, serviceWireFourPicturePath = null, serviceWireFivePicturePath = null, serviceWireSixPicturePath = null, serviceWireSevenPicturePath = null, serviceWireEightPicturePath = null, serviceWireNinePicturePath = null, serviceWireTenPicturePath = null;
    public String transformTitle, crossArmTitle, fusedCutOutTitle, poleAttachTitle, poleTopPinTitle, insulatorTitle, primaryTitle, secondaryTitle, serviceWireTitle;
    String addNote, addSize_Phase,addExtent,subtitle, kvaSize, displayName, testType, size;
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



    JSONObject damageDetailsstreetlightOne = new JSONObject();
    JSONObject damageDetailsstreetlightTwo = new JSONObject();
    JSONObject damageDetailsstreetlightThree = new JSONObject();
    JSONObject damageDetailsstreetlightFour = new JSONObject();
    JSONObject damageDetailsstreetlightFive = new JSONObject();
    JSONObject damageDetailsstreetlightSix = new JSONObject();
    JSONObject damageDetailsstreetlightSeven = new JSONObject();
    JSONObject damageDetailsstreetlightEight = new JSONObject();
    JSONObject damageDetailsstreetlightNine = new JSONObject();
    JSONObject damageDetailsstreetlightTen = new JSONObject();

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
        addSize_Phase =null;
        addExtent =null;
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
                for (int i = 0; i < PoleTopEquipmentData.getInstance().transformerOne.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransOne.put(subtitle, kvaSize);
                            else
                                damageDetailsTransOne.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle() != null) {
                            damageDetailsTransOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerOne.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle() != null) {
                            damageDetailsTransOne.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerOne.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerOne.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransOne.put(subtitle, addSize_Phase);
                           else
                                damageDetailsTransOne.remove(subtitle);
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
                        else
                        {
                            damageDetailsTransOne.remove(displayName);
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
        addSize_Phase =null;
        addExtent =null;
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
                        }else
                        {
                            damageDetailsTransTwo.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransTwo.put(subtitle, kvaSize);
                            else
                                damageDetailsTransTwo.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle() != null) {
                            damageDetailsTransTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransTwo.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransTwo.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerTwo.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerTwo.get(i).getSubTitle() != null) {
                            damageDetailsTransTwo.put(subtitle, addExtent);
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
        addSize_Phase=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;
        addExtent=null;

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
                        }else
                        {
                            damageDetailsTransThree.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransThree.put(subtitle, kvaSize);
                            else
                                damageDetailsTransThree.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle() != null) {
                            damageDetailsTransThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransThree.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransThree.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerThree.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerThree.get(i).getSubTitle() != null) {
                            damageDetailsTransThree.put(subtitle, addExtent);
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
        addSize_Phase=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;
        addExtent=null;

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
                        }else
                        {
                            damageDetailsTransFour.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransFour.put(subtitle, kvaSize);
                            else
                                damageDetailsTransFour.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle() != null) {
                            damageDetailsTransFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransFour.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransFour.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerFour.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerFour.get(i).getSubTitle() != null) {
                            damageDetailsTransFour.put(subtitle, addExtent);
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
        addSize_Phase=null;
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransFive.put(subtitle, kvaSize);
                            else
                                damageDetailsTransFive.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle() != null) {
                            damageDetailsTransFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerFive.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransFive.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransFive.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerFive.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerFive.get(i).getSubTitle() != null) {
                            damageDetailsTransFive.put(subtitle, addExtent);
                        }else
                        {
                            damageDetailsTransFive.remove(displayName);
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
        addSize_Phase=null;
        addExtent=null;
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
                        }else
                        {
                            damageDetailsTransSix.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransSix.put(subtitle, kvaSize);
                            else
                                damageDetailsTransSix.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransSix.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransSix.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle() != null) {
                            damageDetailsTransSix.put(subtitle, addNote);
                        }
                    } if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerSix.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerSix.get(i).getSubTitle() != null) {
                            damageDetailsTransSix.put(subtitle, addExtent);
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
        addSize_Phase=null;
        addExtent=null;
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
                        }else
                        {
                            damageDetailsTransSeven.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransSeven.put(subtitle, kvaSize);
                            else
                                damageDetailsTransSeven.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle() != null) {
                            damageDetailsTransSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransSeven.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransSeven.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerSeven.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerSeven.get(i).getSubTitle() != null) {
                            damageDetailsTransSeven.put(subtitle, addExtent);
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
        addSize_Phase=null;
        addExtent=null;
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
                        }else
                        {
                            damageDetailsTransEight.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransEight.put(subtitle, kvaSize);
                            else
                                damageDetailsTransEight.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle() != null) {
                            damageDetailsTransEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransEight.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransEight.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerEight.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerEight.get(i).getSubTitle() != null) {
                            damageDetailsTransEight.put(subtitle, addExtent);
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
        addSize_Phase=null;
        addExtent=null;
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
                        else
                        {
                            damageDetailsTransNine.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransNine.put(subtitle, kvaSize);
                            else
                                damageDetailsTransNine.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle() != null) {
                            damageDetailsTransNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransNine.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransNine.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerNine.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerNine.get(i).getSubTitle() != null) {
                            damageDetailsTransNine.put(subtitle, addExtent);
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
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;
        addSize_Phase=null;

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
                        else
                        {
                            damageDetailsTransTen.remove(displayName);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().transformerTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsTransTen.put(subtitle, kvaSize);
                            else
                                damageDetailsTransTen.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().transformerTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle() != null) {
                            damageDetailsTransTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getSize_phase() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle();
                        addSize_Phase = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSize_phase();
                        if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle() != null) {
                            if(!addSize_Phase.toString().trim().isEmpty())
                                damageDetailsTransTen.put(subtitle, addSize_Phase);
                            else
                                damageDetailsTransTen.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().transformerTen.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().transformerTen.get(i).getSubTitle() != null) {
                            damageDetailsTransTen.put(subtitle, addExtent);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmOne.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmOne.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmOne.put(subtitle, addExtent);
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
                            } else
                            {
                                damageDetailsCrossArmOne.remove(displayName);
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
        addExtent =null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmTwo.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmTwo.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmTwo.remove(displayName);
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
        addExtent =null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmThree.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmThree.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmThree.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmThree.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmFour.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmFour.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmFour.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmFour.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmFive.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmFive.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmFive.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmFive.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmSix.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmSix.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmSix.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmSix.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmSeven.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmSeven.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmSeven.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmEight.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmEight.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmEight.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmEight.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmNine.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmNine.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmNine.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmNine.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().crossArmTen.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().crossArmTen.get(i).getSubTitle() != null) {
                            damageDetailsCrossArmTen.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsCrossArmTen.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutOne.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutOne.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutOne.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutOne.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutOne.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutTwo.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutTwo.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutTwo.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTwo.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutTwo.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutThree.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutThree.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutThree.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutThree.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutThree.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutFour.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutFour.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutFour.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFour.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutFour.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutFive.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutFive.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutFive.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutFive.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutFive.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutSix.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutSix.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutSix.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSix.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutSix.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutSeven.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutSeven.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutSeven.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutSeven.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutEight.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutEight.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutEight.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutEight.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutEight.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutNine.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutNine.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutNine.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutNine.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutNine.remove(displayName);
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
        addExtent=null;
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
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsFusedCutTen.put(subtitle, kvaSize);
                            else
                                damageDetailsFusedCutTen.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().fusedCutTen.get(i).getSubTitle() != null) {
                            damageDetailsFusedCutTen.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsFusedCutTen.remove(displayName);
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


    public JSONObject readpoleTopPinOneData() {
        addNote = null;
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinOne.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinOne.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinOne.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinTwo.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinTwo.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinTwo.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinThree.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinThree.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinThree.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinFour.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinFour.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinFour.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinFive.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinFive.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinFive.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinSix.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinSix.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinSix.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinSeven.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinSeven.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinSeven.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinEight.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinEight.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinEight.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinNine.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinNine.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinNine.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().poleTopPinTen.get(i).getSubTitle() != null) {
                            damageDetailsPoleTopPinTen.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsPoleTopPinTen.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorOne.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorOne.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorOne.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorOne.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorTwo.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorTwo.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorTwo.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorThree.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorThree.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorThree.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorThree.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorFour.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorFour.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorFour.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorFour.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorFive.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorFive.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorFive.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorFive.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorSix.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorSix.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorSix.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorSix.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorSeven.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorSeven.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorSeven.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorEight.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorEight.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorEight.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorEight.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorNine.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorNine.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorNine.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorNine.remove(displayName);
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
        addExtent=null;
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
                    if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().insulatorTen.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().insulatorTen.get(i).getSubTitle() != null) {
                            damageDetailsInsulatorTen.put(subtitle, addExtent);
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
                            else
                            {
                                damageDetailsInsulatorTen.remove(displayName);
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


    public JSONObject readstreetlightOneData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightOne != null && PoleTopEquipmentData.getInstance().streetlightOne.size() > 0) {
            if (damageDetailsstreetlightOne == null)
                damageDetailsstreetlightOne = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getPicturePath() != null) {
                        streetlightOnePicturePath = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getPicturePath();
//                        streetlightOnePicturePath = streetlightOnePicturePath.substring(streetlightOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightOne.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightOne.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightOne.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightOne.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightOne.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightOne.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightOne.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightOne.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightOne.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightOne;
    }

    public JSONObject readstreetlightTwoData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightTwo != null && PoleTopEquipmentData.getInstance().streetlightTwo.size() > 0) {
            if (damageDetailsstreetlightTwo == null)
                damageDetailsstreetlightTwo = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getPicturePath() != null) {
                        streetlightTwoPicturePath = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getPicturePath();
//                        streetlightTwoPicturePath = streetlightTwoPicturePath.substring(streetlightTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightTwo.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightTwo.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightTwo.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightTwo.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightTwo.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightTwo.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightTwo.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightTwo.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightTwo;
    }

    public JSONObject readstreetlightThreeData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightThree != null && PoleTopEquipmentData.getInstance().streetlightThree.size() > 0) {
            if (damageDetailsstreetlightThree == null)
                damageDetailsstreetlightThree = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightThree.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getPicturePath() != null) {
                        streetlightThreePicturePath = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getPicturePath();
//                        streetlightThreePicturePath = streetlightThreePicturePath.substring(streetlightThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightThree.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightThree.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightThree.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightThree.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightThree.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightThree.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightThree.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightThree.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightThree.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightThree;
    }

    public JSONObject readstreetlightFourData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightFour != null && PoleTopEquipmentData.getInstance().streetlightFour.size() > 0) {
            if (damageDetailsstreetlightFour == null)
                damageDetailsstreetlightFour = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getPicturePath() != null) {
                        streetlightFourPicturePath = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getPicturePath();
//                        streetlightFourPicturePath = streetlightFourPicturePath.substring(streetlightFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightFour.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightFour.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightFour.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightFour.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightFour.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightFour.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightFour.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightFour.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightFour.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightFour;
    }

    public JSONObject readstreetlightFiveData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightFive != null && PoleTopEquipmentData.getInstance().streetlightFive.size() > 0) {
            if (damageDetailsstreetlightFive == null)
                damageDetailsstreetlightFive = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getPicturePath() != null) {
                        streetlightFivePicturePath = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getPicturePath();
//                        streetlightFivePicturePath = streetlightFivePicturePath.substring(streetlightFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightFive.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightFive.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightFive.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightFive.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightFive.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightFive.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightFive.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightFive.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightFive.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightFive;
    }

    public JSONObject readstreetlightSixData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightSix != null && PoleTopEquipmentData.getInstance().streetlightSix.size() > 0) {
            if (damageDetailsstreetlightSix == null)
                damageDetailsstreetlightSix = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getPicturePath() != null) {
                        streetlightSixPicturePath = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getPicturePath();
//                        streetlightSixPicturePath = streetlightSixPicturePath.substring(streetlightSixPicturePath.lastIndexOf("/") + 1);
                    }

                    if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightSix.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightSix.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightSix.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightSix.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightSix.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightSix.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightSix.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightSix.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightSix.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightSix;
    }

    public JSONObject readstreetlightSevenData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightSeven != null && PoleTopEquipmentData.getInstance().streetlightSeven.size() > 0) {
            if (damageDetailsstreetlightSeven == null)
                damageDetailsstreetlightSeven = new JSONObject();

            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightSeven.size(); i++) {

                    if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getPicturePath() != null) {
                        streetlightSevenPicturePath = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getPicturePath();
//                        streetlightSevenPicturePath = streetlightSevenPicturePath.substring(streetlightSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightSeven.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightSeven.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightSeven.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightSeven.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightSeven.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightSeven.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightSeven.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightSeven.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightSeven;
    }

    public JSONObject readstreetlightEightData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightEight != null && PoleTopEquipmentData.getInstance().streetlightEight.size() > 0) {
            if (damageDetailsstreetlightEight == null)
                damageDetailsstreetlightEight = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getPicturePath() != null) {
                        streetlightEightPicturePath = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getPicturePath();
//                        streetlightEightPicturePath = streetlightEightPicturePath.substring(streetlightEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightEight.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightEight.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightEight.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightEight.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightEight.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightEight.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightEight.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightEight.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightEight.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightEight;
    }

    public JSONObject readstreetlightNineData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightNine != null && PoleTopEquipmentData.getInstance().streetlightNine.size() > 0) {
            if (damageDetailsstreetlightNine == null)
                damageDetailsstreetlightNine = new JSONObject();
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getPicturePath() != null) {
                        streetlightNinePicturePath = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getPicturePath();
//                        streetlightNinePicturePath = streetlightNinePicturePath.substring(streetlightNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightNine.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightNine.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightNine.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightNine.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightNine.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightNine.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightNine.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightNine.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightNine.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightNine;
    }

    public JSONObject readstreetlightTenData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleTopEquipmentData.getInstance().streetlightTen != null && PoleTopEquipmentData.getInstance().streetlightTen.size() > 0) {
            if (damageDetailsstreetlightTen == null)
                damageDetailsstreetlightTen = null;
            try {
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getPicturePath() != null) {
                        streetlightTenPicturePath = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getPicturePath();
//                        streetlightTenPicturePath = streetlightTenPicturePath.substring(streetlightTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getKvaSize() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getSubTitle();
                        kvaSize = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getKvaSize();
                        if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getSubTitle() != null) {
                            if(!kvaSize.equalsIgnoreCase("select"))
                                damageDetailsstreetlightTen.put(subtitle, kvaSize);
                            else
                                damageDetailsstreetlightTen.remove(subtitle);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getNote() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getSubTitle();
                        addNote = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getNote();
                        if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getExtent() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getSubTitle();
                        addExtent = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getExtent();
                        if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getSubTitle() != null) {
                            damageDetailsstreetlightTen.put(subtitle, addExtent);
                        }
                    }
                    if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getSubTitle();
                        isChecked = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsstreetlightTen.put(subtitle, isChecked);
                        }
                    }
                }
                for (int i = 0; i < PoleTopEquipmentData.getInstance().streetlightTen.size(); i++) {
                    if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getDisplayName() != null)
//                        Log.i("DINESH_LOG", "Display Name = " + PoleTopEquipmentData.getInstance().fusedCutSeven.get(i).getDisplayName());
                        if (PoleTopEquipmentData.getInstance().streetlightTen.get(i).getIsSelected() != null) {
                            isSelected = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getIsSelected();
                            displayName = PoleTopEquipmentData.getInstance().streetlightTen.get(i).getName();
                            if (isSelected) {

                                damageDetailsstreetlightTen.put(displayName, isSelected);
                            }
                            else
                            {
                                damageDetailsstreetlightTen.remove(displayName);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsstreetlightTen;
    }

    public void resetAllReference() {
        try {
            clearPicturePath();
            PoleTopEquipmentData.getInstance().transformerOne.clear();
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



        streetlightOnePicturePath = null;
        streetlightTwoPicturePath = null;
        streetlightThreePicturePath = null;
        streetlightFourPicturePath = null;
        streetlightFivePicturePath = null;
        streetlightSixPicturePath = null;
        streetlightSevenPicturePath = null;
        streetlightEightPicturePath = null;
        streetlightNinePicturePath = null;
        streetlightTenPicturePath = null;

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

    public void resetAllJSONObject() {
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


        damageDetailsstreetlightOne = null;
        damageDetailsstreetlightTwo = null;
        damageDetailsstreetlightThree = null;
        damageDetailsstreetlightFour = null;
        damageDetailsstreetlightFive = null;
        damageDetailsstreetlightSix = null;
        damageDetailsstreetlightSeven = null;
        damageDetailsstreetlightEight = null;
        damageDetailsstreetlightNine = null;
        damageDetailsstreetlightTen = null;

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
