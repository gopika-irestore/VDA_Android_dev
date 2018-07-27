package vda.irestore.com.vda_android.readData;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dell on 21-12-2017.
 */

public class ReadPoleEquipmentData {
    public static ReadPoleEquipmentData readPoleEquipment = null;
    String addNote, subtitle, kvaSize, displayName, testType, size;
    boolean isSelected, isChecked, isUtilityOwned;
    public String poleTitle, guyWireTitle, anchorTitle, primaryRiserTitle, secondaryRiseTitle, poleGroundTitle, vegetationTitle;

    public String poleOnePicturePath = null, poleTwoPicturePath = null, poleThreePicturePath = null, poleFourPicturePath = null, poleFivePicturePath = null, poleSixPicturePath = null, poleSevenPicturePath = null, poleEightPicturePath = null, poleNinePicturePath = null, poleTenPicturePath = null,
            guyWireOnePicturePath = null, guyWireTwoPicturePath = null, guyWireThreePicturePath = null, guyWireFourPicturePath = null, guyWireFivePicturePath = null, guyWireSixPicturePath = null, guyWireSevenPicturePath = null, guyWireEightPicturePath = null, guyWireNinePicturePath = null, guyWireTenPicturePath = null,
            anchorOnePicturePath = null, anchorTwoPicturePath = null, anchorThreePicturePath = null, anchorFourPicturePath = null, anchorFivePicturePath = null, anchorSixPicturePath = null, anchorSevenPicturePath = null, anchorEightPicturePath = null, anchorNinePicturePath = null, anchorTenPicturePath = null,
            primaryRiserOnePicturePath = null, primaryRiserTwoPicturePath = null, primaryRiserThreePicturePath = null, primaryRiserFourPicturePath = null, primaryRiserFivePicturePath = null, primaryRiserSixPicturePath = null, primaryRiserSevenPicturePath = null, primaryRiserEightPicturePath = null, primaryRiserNinePicturePath = null, primaryRiserTenPicturePath = null,
            secondaryRiserOnePicturePath = null, secondaryRiserTwoPicturePath = null, secondaryRiserThreePicturePath = null, secondaryRiserFourPicturePath = null, secondaryRiserFivePicturePath = null, secondaryRiserSixPicturePath = null, secondaryRiserSevenPicturePath = null, secondaryRiserEightPicturePath = null, secondaryRiserNinePicturePath = null, secondaryRiserTenPicturePath = null,
            poleGroundOnePicturePath = null, poleGroundTwoPicturePath = null, poleGroundThreePicturePath = null, poleGroundFourPicturePath = null, poleGroundFivePicturePath = null, poleGroundSixPicturePath = null, poleGroundSevenPicturePath = null, poleGroundEightPicturePath = null, poleGroundNinePicturePath = null, poleGroundTenPicturePath = null,
            vegetationOnePicturePath = null, vegetationTwoPicturePath = null, vegetationThreePicturePath = null, vegetationFourPicturePath = null, vegetationFivePicturePath = null, vegetationSixPicturePath = null, vegetationSevenPicturePath = null, vegetationEightPicturePath = null, vegetationNinePicturePath = null, vegetationTenPicturePath = null,

    poleOneTestPicturePath = null, poleTwoTestPicturePath = null, poleThreeTestPicturePath = null, poleFourTestPicturePath = null, poleFiveTestPicturePath = null, poleSixTestPicturePath = null, poleSevenTestPicturePath = null, poleEightTestPicturePath = null, poleNineTestPicturePath = null, poleTenTestPicturePath = null,
            guyWireOneTestPicturePath = null, guyWireTwoTestPicturePath = null, guyWireThreeTestPicturePath = null, guyWireFourTestPicturePath = null, guyWireFiveTestPicturePath = null, guyWireSixTestPicturePath = null, guyWireSevenTestPicturePath = null, guyWireEightTestPicturePath = null, guyWireNineTestPicturePath = null, guyWireTenTestPicturePath = null,
            anchorOneTestPicturePath = null, anchorTwoTestPicturePath = null, anchorThreeTestPicturePath = null, anchorFourTestPicturePath = null, anchorFiveTestPicturePath = null, anchorSixTestPicturePath = null, anchorSevenTestPicturePath = null, anchorEightTestPicturePath = null, anchorNineTestPicturePath = null, anchorTenTestPicturePath = null,
            primaryRiserOneTestPicturePath = null, primaryRiserTwoTestPicturePath = null, primaryRiserThreeTestPicturePath = null, primaryRiserFourTestPicturePath = null, primaryRiserFiveTestPicturePath = null, primaryRiserSixTestPicturePath = null, primaryRiserSevenTestPicturePath = null, primaryRiserEightTestPicturePath = null, primaryRiserNineTestPicturePath = null, primaryRiserTenTestPicturePath = null,
            secondaryRiserOneTestPicturePath = null, secondaryRiserTwoTestPicturePath = null, secondaryRiserThreeTestPicturePath = null, secondaryRiserFourTestPicturePath = null, secondaryRiserFiveTestPicturePath = null, secondaryRiserSixTestPicturePath = null, secondaryRiserSevenTestPicturePath = null, secondaryRiserEightTestPicturePath = null, secondaryRiserNineTestPicturePath = null, secondaryRiserTenTestPicturePath = null,
            poleGroundOneTestPicturePath = null, poleGroundTwoTestPicturePath = null, poleGroundThreeTestPicturePath = null, poleGroundFourTestPicturePath = null, poleGroundFiveTestPicturePath = null, poleGroundSixTestPicturePath = null, poleGroundSevenTestPicturePath = null, poleGroundEightTestPicturePath = null, poleGroundNineTestPicturePath = null, poleGroundTenTestPicturePath = null,
            vegetationOneTestPicturePath = null, vegetationTwoTestPicturePath = null, vegetationThreeTestPicturePath = null, vegetationFourTestPicturePath = null, vegetationFiveTestPicturePath = null, vegetationSixTestPicturePath = null, vegetationSevenTestPicturePath = null, vegetationEightTestPicturePath = null, vegetationNineTestPicturePath = null, vegetationTenTestPicturePath = null,

    visualOneTestPicturePath = null, visualTwoTestPicturePath = null, visualThreeTestPicturePath = null, visualFourTestPicturePath = null, visualFiveTestPicturePath = null, visualSixTestPicturePath = null, visualSevenTestPicturePath = null, visualEightTestPicturePath = null, visualNineTestPicturePath = null, visualTenTestPicturePath = null,
            soundOneTestPicturePath = null, soundTwoTestPicturePath = null, soundThreeTestPicturePath = null, soundFourTestPicturePath = null, soundFiveTestPicturePath = null, soundSixTestPicturePath = null, soundSevenTestPicturePath = null, soundEightTestPicturePath = null, soundNineTestPicturePath = null, soundTenTestPicturePath = null,
            resistographOneTestPicturePath = null, resistographTwoTestPicturePath = null, resistographThreeTestPicturePath = null, resistographFourTestPicturePath = null, resistographFiveTestPicturePath = null, resistographSixTestPicturePath = null, resistographSevenTestPicturePath = null, resistographEightTestPicturePath = null, resistographNineTestPicturePath = null, resistographTenTestPicturePath = null;

    JSONObject damageDetailsPoleOne = new JSONObject();
    JSONObject damageDetailsPoleTwo = new JSONObject();
    JSONObject damageDetailsPoleThree = new JSONObject();
    JSONObject damageDetailsPoleFour = new JSONObject();
    JSONObject damageDetailsPoleFive = new JSONObject();
    JSONObject damageDetailsPoleSix = new JSONObject();
    JSONObject damageDetailsPoleSeven = new JSONObject();
    JSONObject damageDetailsPoleEight = new JSONObject();
    JSONObject damageDetailsPoleNine = new JSONObject();
    JSONObject damageDetailsPoleTen = new JSONObject();

    JSONObject damageDetailsguyWireOne = new JSONObject();
    JSONObject damageDetailsguyWireTwo = new JSONObject();
    JSONObject damageDetailsguyWireThree = new JSONObject();
    JSONObject damageDetailsguyWireFour = new JSONObject();
    JSONObject damageDetailsguyWireFive = new JSONObject();
    JSONObject damageDetailsguyWireSix = new JSONObject();
    JSONObject damageDetailsguyWireSeven = new JSONObject();
    JSONObject damageDetailsguyWireEight = new JSONObject();
    JSONObject damageDetailsguyWireNine = new JSONObject();
    JSONObject damageDetailsguyWireTen = new JSONObject();

    JSONObject damageDetailsanchorOne = new JSONObject();
    JSONObject damageDetailsanchorTwo = new JSONObject();
    JSONObject damageDetailsanchorThree = new JSONObject();
    JSONObject damageDetailsanchorFour = new JSONObject();
    JSONObject damageDetailsanchorFive = new JSONObject();
    JSONObject damageDetailsanchorSix = new JSONObject();
    JSONObject damageDetailsanchorSeven = new JSONObject();
    JSONObject damageDetailsanchorEight = new JSONObject();
    JSONObject damageDetailsanchorNine = new JSONObject();
    JSONObject damageDetailsanchorTen = new JSONObject();

    JSONObject damageDetailsprimaryRiserOne = new JSONObject();
    JSONObject damageDetailsprimaryRiserTwo = new JSONObject();
    JSONObject damageDetailsprimaryRiserThree = new JSONObject();
    JSONObject damageDetailsprimaryRiserFour = new JSONObject();
    JSONObject damageDetailsprimaryRiserFive = new JSONObject();
    JSONObject damageDetailsprimaryRiserSix = new JSONObject();
    JSONObject damageDetailsprimaryRiserSeven = new JSONObject();
    JSONObject damageDetailsprimaryRiserEight = new JSONObject();
    JSONObject damageDetailsprimaryRiserNine = new JSONObject();
    JSONObject damageDetailsprimaryRiserTen = new JSONObject();

    JSONObject damageDetailssecondaryRiserOne = new JSONObject();
    JSONObject damageDetailssecondaryRiserTwo = new JSONObject();
    JSONObject damageDetailssecondaryRiserThree = new JSONObject();
    JSONObject damageDetailssecondaryRiserFour = new JSONObject();
    JSONObject damageDetailssecondaryRiserFive = new JSONObject();
    JSONObject damageDetailssecondaryRiserSix = new JSONObject();
    JSONObject damageDetailssecondaryRiserSeven = new JSONObject();
    JSONObject damageDetailssecondaryRiserEight = new JSONObject();
    JSONObject damageDetailssecondaryRiserNine = new JSONObject();
    JSONObject damageDetailssecondaryRiserTen = new JSONObject();

    JSONObject damageDetailspoleGroundOne = new JSONObject();
    JSONObject damageDetailspoleGroundTwo = new JSONObject();
    JSONObject damageDetailspoleGroundThree = new JSONObject();
    JSONObject damageDetailspoleGroundFour = new JSONObject();
    JSONObject damageDetailspoleGroundFive = new JSONObject();
    JSONObject damageDetailspoleGroundSix = new JSONObject();
    JSONObject damageDetailspoleGroundSeven = new JSONObject();
    JSONObject damageDetailspoleGroundEight = new JSONObject();
    JSONObject damageDetailspoleGroundNine = new JSONObject();
    JSONObject damageDetailspoleGroundTen = new JSONObject();

    JSONObject damageDetailsvegetationOne = new JSONObject();
    JSONObject damageDetailsvegetationTwo = new JSONObject();
    JSONObject damageDetailsvegetationThree = new JSONObject();
    JSONObject damageDetailsvegetationFour = new JSONObject();
    JSONObject damageDetailsvegetationFive = new JSONObject();
    JSONObject damageDetailsvegetationSix = new JSONObject();
    JSONObject damageDetailsvegetationSeven = new JSONObject();
    JSONObject damageDetailsvegetationEight = new JSONObject();
    JSONObject damageDetailsvegetationNine = new JSONObject();
    JSONObject damageDetailsvegetationTen = new JSONObject();

    public static synchronized ReadPoleEquipmentData getInstance() {
        if (readPoleEquipment == null)
            readPoleEquipment = new ReadPoleEquipmentData();
        else
            return readPoleEquipment;
        return readPoleEquipment;
    }

    public JSONObject readpoleOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleOne != null && PoleData.getInstance().poleOne.size() > 0) {
            if (damageDetailsPoleOne == null)
                damageDetailsPoleOne = new JSONObject();
            try {
                for (int i = 0; i < PoleData.getInstance().poleOne.size(); i++) {
                    if (PoleData.getInstance().poleOne.get(i).getPicturePath() != null) {
                        poleOnePicturePath = PoleData.getInstance().poleOne.get(i).getPicturePath();
//                        poleOnePicturePath = poleOnePicturePath.substring(poleOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleOne.get(i).getTestType() != null && PoleData.getInstance().poleOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && PoleData.getInstance().poleOne.get(i).getTestPicturePath() != null) {
                        poleOneTestPicturePath = PoleData.getInstance().poleOne.get(i).getTestPicturePath();
                        poleOneTestPicturePath = poleOneTestPicturePath.substring(poleOneTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleOne.get(i).getTestType() != null && PoleData.getInstance().poleOne.get(i).getTestType().equalsIgnoreCase("Visual Test")
                            && PoleData.getInstance().poleOne.get(i).getTestPicturePath() != null) {
                        visualOneTestPicturePath = PoleData.getInstance().poleOne.get(i).getTestPicturePath();
                        visualOneTestPicturePath = visualOneTestPicturePath.substring(visualOneTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleOne.get(i).getTestType() != null && PoleData.getInstance().poleOne.get(i).getTestType().equalsIgnoreCase("Sound Test")
                            && PoleData.getInstance().poleOne.get(i).getTestPicturePath() != null) {
                        soundOneTestPicturePath = PoleData.getInstance().poleOne.get(i).getTestPicturePath();
                        soundOneTestPicturePath = soundOneTestPicturePath.substring(soundOneTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleOne.get(i).getTestType() != null && PoleData.getInstance().poleOne.get(i).getTestType().equalsIgnoreCase("resistograph Test")
                            && PoleData.getInstance().poleOne.get(i).getTestPicturePath() != null) {
                        resistographOneTestPicturePath = PoleData.getInstance().poleOne.get(i).getTestPicturePath();
                        resistographOneTestPicturePath = resistographOneTestPicturePath.substring(resistographOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleOne.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleOne.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleOne.get(i).getKvaSize();
                        if (PoleData.getInstance().poleOne.get(i).getSubTitle() != null) {
                            damageDetailsPoleOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleOne.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleOne.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleOne.get(i).getNote();
                        if (PoleData.getInstance().poleOne.get(i).getSubTitle() != null) {
                            damageDetailsPoleOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleOne.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleOne.get(i).getIsTesttingResult() != null) {
                            Log.i("vidisha","Testing typeeeee"+PoleData.getInstance().poleOne.get(i).getTestingType()+"  =="+PoleData.getInstance().poleOne.get(i).getIsTesttingResult());
                            damageDetailsPoleOne.put(PoleData.getInstance().poleOne.get(i).getTestingType(), PoleData.getInstance().poleOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleOne.get(i).getIsTesstingPassResult() != null) {
                            Log.i("vidisha","Testing typeeeee111"+PoleData.getInstance().poleOne.get(i).getTestingTypePass()+"  =="+PoleData.getInstance().poleOne.get(i).getIsTesstingPassResult());

                            damageDetailsPoleOne.put(PoleData.getInstance().poleOne.get(i).getTestingTypePass(), PoleData.getInstance().poleOne.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleOne.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleOne.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleOne.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleOne.get(i).getTitle();
                    if (PoleData.getInstance().poleOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleOne.get(i).getDisplayName());
                    if (PoleData.getInstance().poleOne.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleOne.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleOne.get(i).getName();
                        if (isSelected) {
                            /*displayName = displayName.replaceAll("\\s", "");
                            displayName = "is" + displayName;*/
                            Log.i("vidisha","helloooooooooooooo");
                            damageDetailsPoleOne.put(displayName, isSelected);

                        }
                        else
                        {
                            damageDetailsPoleOne.remove(displayName);
                         //   damageDetailsPoleOne.remove("isPoleRejected");
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleOne;
    }

    public JSONObject readpoleTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleTwo != null && PoleData.getInstance().poleTwo.size() > 0) {
            if (damageDetailsPoleTwo == null)
                damageDetailsPoleTwo = new JSONObject();
            try {
                for (int i = 0; i < PoleData.getInstance().poleTwo.size(); i++) {
                    if (PoleData.getInstance().poleTwo.get(i).getPicturePath() != null) {
                        poleTwoPicturePath = PoleData.getInstance().poleTwo.get(i).getPicturePath();
//                        poleTwoPicturePath = poleTwoPicturePath.substring(poleTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleTwo.get(i).getTestType() != null && PoleData.getInstance().poleTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleTwoTestPicturePath = PoleData.getInstance().poleTwo.get(i).getTestPicturePath();
                        poleTwoTestPicturePath = poleTwoTestPicturePath.substring(poleTwoTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleTwo.get(i).getTestType() != null && PoleData.getInstance().poleTwo.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualTwoTestPicturePath = PoleData.getInstance().poleTwo.get(i).getTestPicturePath();
                        visualTwoTestPicturePath = visualTwoTestPicturePath.substring(visualTwoTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleTwo.get(i).getTestType() != null && PoleData.getInstance().poleTwo.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundTwoTestPicturePath = PoleData.getInstance().poleTwo.get(i).getTestPicturePath();
                        soundTwoTestPicturePath = soundTwoTestPicturePath.substring(soundTwoTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleTwo.get(i).getTestType() != null && PoleData.getInstance().poleTwo.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographTwoTestPicturePath = PoleData.getInstance().poleTwo.get(i).getTestPicturePath();
                        resistographTwoTestPicturePath = resistographTwoTestPicturePath.substring(resistographTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleTwo.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleTwo.put(PoleData.getInstance().poleTwo.get(i).getTestingType(), PoleData.getInstance().poleTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleTwo.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleTwo.put(PoleData.getInstance().poleTwo.get(i).getTestingTypePass(), PoleData.getInstance().poleTwo.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleTwo.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleTwo.get(i).getKvaSize();
                        if (PoleData.getInstance().poleTwo.get(i).getSubTitle() != null) {
                            damageDetailsPoleTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleTwo.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleTwo.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleTwo.get(i).getNote();
                        if (PoleData.getInstance().poleTwo.get(i).getSubTitle() != null) {
                            damageDetailsPoleTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleTwo.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleTwo.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleTwo.get(i).getTitle();
                    if (PoleData.getInstance().poleTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleTwo.get(i).getDisplayName());
                    if (PoleData.getInstance().poleTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleTwo.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleTwo.get(i).getName();
                        if (isSelected) {
                           /* displayName = displayName.replaceAll("\\s", "");
                            displayName = "is" + displayName;*/
                            damageDetailsPoleTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTwo;
    }

    public JSONObject readpoleThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleThree != null && PoleData.getInstance().poleThree.size() > 0) {
            try {
                if (damageDetailsPoleThree == null)
                    damageDetailsPoleThree = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleThree.size(); i++) {

                    if (PoleData.getInstance().poleThree.get(i).getPicturePath() != null) {
                        poleThreePicturePath = PoleData.getInstance().poleThree.get(i).getPicturePath();
//                        poleThreePicturePath = poleThreePicturePath.substring(poleThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleThree.get(i).getTestType() != null && PoleData.getInstance().poleThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleThreeTestPicturePath = PoleData.getInstance().poleThree.get(i).getTestPicturePath();
                        poleThreeTestPicturePath = poleThreeTestPicturePath.substring(poleThreeTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleThree.get(i).getTestType() != null && PoleData.getInstance().poleThree.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualThreeTestPicturePath = PoleData.getInstance().poleThree.get(i).getTestPicturePath();
                        visualThreeTestPicturePath = visualThreeTestPicturePath.substring(visualThreeTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleThree.get(i).getTestType() != null && PoleData.getInstance().poleThree.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundThreeTestPicturePath = PoleData.getInstance().poleThree.get(i).getTestPicturePath();
                        soundThreeTestPicturePath = soundThreeTestPicturePath.substring(soundThreeTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleThree.get(i).getTestType() != null && PoleData.getInstance().poleThree.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographThreeTestPicturePath = PoleData.getInstance().poleThree.get(i).getTestPicturePath();
                        resistographThreeTestPicturePath = resistographThreeTestPicturePath.substring(resistographThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleThree.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleThree.put(PoleData.getInstance().poleThree.get(i).getTestingType(), PoleData.getInstance().poleThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleThree.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleThree.put(PoleData.getInstance().poleThree.get(i).getTestingTypePass(), PoleData.getInstance().poleThree.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleThree.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleThree.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleThree.get(i).getKvaSize();
                        if (PoleData.getInstance().poleThree.get(i).getSubTitle() != null) {
                            damageDetailsPoleThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleThree.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleThree.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleThree.get(i).getNote();
                        if (PoleData.getInstance().poleThree.get(i).getSubTitle() != null) {
                            damageDetailsPoleThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleThree.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleThree.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleThree.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleThree.get(i).getTitle();
                    if (PoleData.getInstance().poleThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleThree.get(i).getDisplayName());
                    if (PoleData.getInstance().poleThree.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleThree.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleThree.get(i).getName();
                        if (isSelected) {

                            damageDetailsPoleThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleThree;
    }

    public JSONObject readpoleFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleFour != null && PoleData.getInstance().poleFour.size() > 0) {
            try {
                if (damageDetailsPoleFour == null)
                    damageDetailsPoleFour = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleFour.size(); i++) {

                    if (PoleData.getInstance().poleFour.get(i).getPicturePath() != null) {
                        poleFourPicturePath = PoleData.getInstance().poleFour.get(i).getPicturePath();
//                        poleFourPicturePath = poleFourPicturePath.substring(poleFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleFour.get(i).getTestType() != null && PoleData.getInstance().poleFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleFourTestPicturePath = PoleData.getInstance().poleFour.get(i).getTestPicturePath();
                        poleFourTestPicturePath = poleFourTestPicturePath.substring(poleFourTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleFour.get(i).getTestType() != null && PoleData.getInstance().poleFour.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualFourTestPicturePath = PoleData.getInstance().poleFour.get(i).getTestPicturePath();
                        visualFourTestPicturePath = visualFourTestPicturePath.substring(visualFourTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleFour.get(i).getTestType() != null && PoleData.getInstance().poleFour.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundFourTestPicturePath = PoleData.getInstance().poleFour.get(i).getTestPicturePath();
                        soundFourTestPicturePath = soundFourTestPicturePath.substring(soundFourTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleFour.get(i).getTestType() != null && PoleData.getInstance().poleFour.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographFourTestPicturePath = PoleData.getInstance().poleFour.get(i).getTestPicturePath();
                        resistographFourTestPicturePath = resistographFourTestPicturePath.substring(resistographFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleFour.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleFour.put(PoleData.getInstance().poleFour.get(i).getTestingType(), PoleData.getInstance().poleFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleFour.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleFour.put(PoleData.getInstance().poleFour.get(i).getTestingTypePass(), PoleData.getInstance().poleFour.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleFour.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleFour.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleFour.get(i).getKvaSize();
                        if (PoleData.getInstance().poleFour.get(i).getSubTitle() != null) {
                            damageDetailsPoleFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleFour.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleFour.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleFour.get(i).getNote();
                        if (PoleData.getInstance().poleFour.get(i).getSubTitle() != null) {
                            damageDetailsPoleFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleFour.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleFour.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleFour.get(i).getTitle();
                    if (PoleData.getInstance().poleFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleFour.get(i).getDisplayName());
                    if (PoleData.getInstance().poleFour.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleFour.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleFour.get(i).getName();
                        if (isSelected) {
                           /* displayName = displayName.replaceAll("\\s", "");
                            displayName = "is" + displayName;*/
                            damageDetailsPoleFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleFour;
    }

    public JSONObject readpoleFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleFive != null && PoleData.getInstance().poleFive.size() > 0) {
            try {
                if (damageDetailsPoleFive == null)
                    damageDetailsPoleFive = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleFive.size(); i++) {

                    if (PoleData.getInstance().poleFive.get(i).getPicturePath() != null) {
                        poleFivePicturePath = PoleData.getInstance().poleFive.get(i).getPicturePath();
//                        poleFivePicturePath = poleFivePicturePath.substring(poleFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleFive.get(i).getTestType() != null && PoleData.getInstance().poleFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleFiveTestPicturePath = PoleData.getInstance().poleFive.get(i).getTestPicturePath();
                        poleFiveTestPicturePath = poleFiveTestPicturePath.substring(poleFiveTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleFive.get(i).getTestType() != null && PoleData.getInstance().poleFive.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualFiveTestPicturePath = PoleData.getInstance().poleFive.get(i).getTestPicturePath();
                        visualFiveTestPicturePath = visualFiveTestPicturePath.substring(visualFiveTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleFive.get(i).getTestType() != null && PoleData.getInstance().poleFive.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundFiveTestPicturePath = PoleData.getInstance().poleFive.get(i).getTestPicturePath();
                        soundFiveTestPicturePath = soundFiveTestPicturePath.substring(soundFiveTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleFive.get(i).getTestType() != null && PoleData.getInstance().poleFive.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographFiveTestPicturePath = PoleData.getInstance().poleFive.get(i).getTestPicturePath();
                        resistographFiveTestPicturePath = resistographFiveTestPicturePath.substring(resistographFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleFive.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleFive.put(PoleData.getInstance().poleFive.get(i).getTestingType(), PoleData.getInstance().poleFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleFive.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleFive.put(PoleData.getInstance().poleFive.get(i).getTestingTypePass(), PoleData.getInstance().poleFive.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleFive.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleFive.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleFive.get(i).getKvaSize();
                        if (PoleData.getInstance().poleFive.get(i).getSubTitle() != null) {
                            damageDetailsPoleFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleFive.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleFive.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleFive.get(i).getNote();
                        if (PoleData.getInstance().poleFive.get(i).getSubTitle() != null) {
                            damageDetailsPoleFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleFive.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleFive.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleFive.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleFive.get(i).getTitle();
                    if (PoleData.getInstance().poleFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleFive.get(i).getDisplayName());
                    if (PoleData.getInstance().poleFive.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleFive.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleFive.get(i).getName();
                        if (isSelected) {
                            damageDetailsPoleFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleFive;
    }

    public JSONObject readpoleSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleSix != null && PoleData.getInstance().poleSix.size() > 0) {
            try {
                if (damageDetailsPoleSix == null)
                    damageDetailsPoleSix = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleSix.size(); i++) {

                    if (PoleData.getInstance().poleSix.get(i).getPicturePath() != null) {
                        poleSixPicturePath = PoleData.getInstance().poleSix.get(i).getPicturePath();
//                        poleSixPicturePath = poleSixPicturePath.substring(poleSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleSix.get(i).getTestType() != null && PoleData.getInstance().poleSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleSixTestPicturePath = PoleData.getInstance().poleSix.get(i).getTestPicturePath();
                        poleSixTestPicturePath = poleSixTestPicturePath.substring(poleSixTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleSix.get(i).getTestType() != null && PoleData.getInstance().poleSix.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualSixTestPicturePath = PoleData.getInstance().poleSix.get(i).getTestPicturePath();
                        visualSixTestPicturePath = visualSixTestPicturePath.substring(visualSixTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleSix.get(i).getTestType() != null && PoleData.getInstance().poleSix.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundSixTestPicturePath = PoleData.getInstance().poleSix.get(i).getTestPicturePath();
                        soundSixTestPicturePath = soundSixTestPicturePath.substring(soundSixTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleSix.get(i).getTestType() != null && PoleData.getInstance().poleSix.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographSixTestPicturePath = PoleData.getInstance().poleSix.get(i).getTestPicturePath();
                        resistographSixTestPicturePath = resistographSixTestPicturePath.substring(resistographSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleSix.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleSix.put(PoleData.getInstance().poleSix.get(i).getTestingType(), PoleData.getInstance().poleSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleSix.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleSix.put(PoleData.getInstance().poleSix.get(i).getTestingTypePass(), PoleData.getInstance().poleSix.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleSix.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleSix.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleSix.get(i).getKvaSize();
                        if (PoleData.getInstance().poleSix.get(i).getSubTitle() != null) {
                            damageDetailsPoleSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleSix.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleSix.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleSix.get(i).getNote();
                        if (PoleData.getInstance().poleSix.get(i).getSubTitle() != null) {
                            damageDetailsPoleSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleSix.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleSix.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleSix.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleSix.get(i).getTitle();
                    if (PoleData.getInstance().poleSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleSix.get(i).getDisplayName());
                    if (PoleData.getInstance().poleSix.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleSix.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleSix.get(i).getName();
                        if (isSelected) {
                            damageDetailsPoleSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleSix;
    }

    public JSONObject readpoleSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleSeven != null && PoleData.getInstance().poleSeven.size() > 0) {
            try {
                if (damageDetailsPoleSeven == null)
                    damageDetailsPoleSeven = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleSeven.size(); i++) {

                    if (PoleData.getInstance().poleSeven.get(i).getPicturePath() != null) {
                        poleSevenPicturePath = PoleData.getInstance().poleSeven.get(i).getPicturePath();
//                        poleSevenPicturePath = poleSevenPicturePath.substring(poleSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleSeven.get(i).getTestType() != null && PoleData.getInstance().poleSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleSevenTestPicturePath = PoleData.getInstance().poleSeven.get(i).getTestPicturePath();
                        poleSevenTestPicturePath = poleSevenTestPicturePath.substring(poleSevenTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleSeven.get(i).getTestType() != null && PoleData.getInstance().poleSeven.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualSevenTestPicturePath = PoleData.getInstance().poleSeven.get(i).getTestPicturePath();
                        visualSevenTestPicturePath = visualSevenTestPicturePath.substring(visualSevenTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleSeven.get(i).getTestType() != null && PoleData.getInstance().poleSeven.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundSevenTestPicturePath = PoleData.getInstance().poleSeven.get(i).getTestPicturePath();
                        soundSevenTestPicturePath = soundSevenTestPicturePath.substring(soundSevenTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleSeven.get(i).getTestType() != null && PoleData.getInstance().poleSeven.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographSevenTestPicturePath = PoleData.getInstance().poleSeven.get(i).getTestPicturePath();
                        resistographSevenTestPicturePath = resistographSevenTestPicturePath.substring(resistographSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleSeven.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleSeven.put(PoleData.getInstance().poleSeven.get(i).getTestingType(), PoleData.getInstance().poleSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleSeven.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleSeven.put(PoleData.getInstance().poleSeven.get(i).getTestingTypePass(), PoleData.getInstance().poleSeven.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleSeven.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleSeven.get(i).getKvaSize();
                        if (PoleData.getInstance().poleSeven.get(i).getSubTitle() != null) {
                            damageDetailsPoleSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleSeven.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleSeven.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleSeven.get(i).getNote();
                        if (PoleData.getInstance().poleSeven.get(i).getSubTitle() != null) {
                            damageDetailsPoleSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleSeven.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleSeven.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleSeven.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleSeven.get(i).getTitle();
                    if (PoleData.getInstance().poleSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleSeven.get(i).getDisplayName());
                    if (PoleData.getInstance().poleSeven.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleSeven.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleSeven.get(i).getName();
                        if (isSelected) {
                            damageDetailsPoleSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleSeven;
    }

    public JSONObject readpoleEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleEight != null && PoleData.getInstance().poleEight.size() > 0) {
            try {
                if (damageDetailsPoleEight == null)
                    damageDetailsPoleEight = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleEight.size(); i++) {

                    if (PoleData.getInstance().poleEight.get(i).getPicturePath() != null) {
                        poleEightPicturePath = PoleData.getInstance().poleEight.get(i).getPicturePath();
//                        poleEightPicturePath = poleEightPicturePath.substring(poleEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleEight.get(i).getTestType() != null && PoleData.getInstance().poleEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleEightTestPicturePath = PoleData.getInstance().poleEight.get(i).getTestPicturePath();
                        poleEightTestPicturePath = poleEightTestPicturePath.substring(poleEightTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleEight.get(i).getTestType() != null && PoleData.getInstance().poleEight.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualEightTestPicturePath = PoleData.getInstance().poleEight.get(i).getTestPicturePath();
                        visualEightTestPicturePath = visualEightTestPicturePath.substring(visualEightTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleEight.get(i).getTestType() != null && PoleData.getInstance().poleEight.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundEightTestPicturePath = PoleData.getInstance().poleEight.get(i).getTestPicturePath();
                        soundEightTestPicturePath = soundEightTestPicturePath.substring(soundEightTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleEight.get(i).getTestType() != null && PoleData.getInstance().poleEight.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographEightTestPicturePath = PoleData.getInstance().poleEight.get(i).getTestPicturePath();
                        resistographEightTestPicturePath = resistographEightTestPicturePath.substring(resistographEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleEight.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleEight.put(PoleData.getInstance().poleEight.get(i).getTestingType(), PoleData.getInstance().poleEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleEight.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleEight.put(PoleData.getInstance().poleEight.get(i).getTestingTypePass(), PoleData.getInstance().poleEight.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleEight.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleEight.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleEight.get(i).getKvaSize();
                        if (PoleData.getInstance().poleEight.get(i).getSubTitle() != null) {
                            damageDetailsPoleEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleEight.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleEight.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleEight.get(i).getNote();
                        if (PoleData.getInstance().poleEight.get(i).getSubTitle() != null) {
                            damageDetailsPoleEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleEight.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleEight.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleEight.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleEight.get(i).getTitle();
                    if (PoleData.getInstance().poleEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleEight.get(i).getDisplayName());
                    if (PoleData.getInstance().poleEight.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleEight.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleEight.get(i).getName();
                        if (isSelected) {
                            damageDetailsPoleEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleEight;
    }

    public JSONObject readpoleNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleNine != null && PoleData.getInstance().poleNine.size() > 0) {
            try {
                if (damageDetailsPoleNine == null)
                    damageDetailsPoleNine = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleNine.size(); i++) {

                    if (PoleData.getInstance().poleNine.get(i).getPicturePath() != null) {
                        poleNinePicturePath = PoleData.getInstance().poleNine.get(i).getPicturePath();
//                        poleNinePicturePath = poleNinePicturePath.substring(poleNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleNine.get(i).getTestType() != null && PoleData.getInstance().poleNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleNineTestPicturePath = PoleData.getInstance().poleNine.get(i).getTestPicturePath();
                        poleNineTestPicturePath = poleNineTestPicturePath.substring(poleNineTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleNine.get(i).getTestType() != null && PoleData.getInstance().poleNine.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualNineTestPicturePath = PoleData.getInstance().poleNine.get(i).getTestPicturePath();
                        visualNineTestPicturePath = visualNineTestPicturePath.substring(visualNineTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleNine.get(i).getTestType() != null && PoleData.getInstance().poleNine.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundNineTestPicturePath = PoleData.getInstance().poleNine.get(i).getTestPicturePath();
                        soundNineTestPicturePath = soundNineTestPicturePath.substring(soundNineTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleNine.get(i).getTestType() != null && PoleData.getInstance().poleNine.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographNineTestPicturePath = PoleData.getInstance().poleNine.get(i).getTestPicturePath();
                        resistographNineTestPicturePath = resistographNineTestPicturePath.substring(resistographNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleNine.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleNine.put(PoleData.getInstance().poleNine.get(i).getTestingType(), PoleData.getInstance().poleNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleNine.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleNine.put(PoleData.getInstance().poleNine.get(i).getTestingTypePass(), PoleData.getInstance().poleNine.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleNine.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleNine.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleNine.get(i).getKvaSize();
                        if (PoleData.getInstance().poleNine.get(i).getSubTitle() != null) {
                            damageDetailsPoleNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleNine.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleNine.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleNine.get(i).getNote();
                        if (PoleData.getInstance().poleNine.get(i).getSubTitle() != null) {
                            damageDetailsPoleNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleNine.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleNine.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleNine.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleNine.get(i).getTitle();
                    if (PoleData.getInstance().poleNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleNine.get(i).getDisplayName());
                    if (PoleData.getInstance().poleNine.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleNine.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleNine.get(i).getName();
                        if (isSelected) {

                            damageDetailsPoleNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleNine;
    }

    public JSONObject readpoleTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleTen != null && PoleData.getInstance().poleTen.size() > 0) {
            try {
                if (damageDetailsPoleTen == null)
                    damageDetailsPoleTen = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleTen.size(); i++) {

                    if (PoleData.getInstance().poleTen.get(i).getPicturePath() != null) {
                        poleTenPicturePath = PoleData.getInstance().poleTen.get(i).getPicturePath();
//                        poleTenPicturePath = poleTenPicturePath.substring(poleTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleTen.get(i).getTestType() != null && PoleData.getInstance().poleTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleTenTestPicturePath = PoleData.getInstance().poleTen.get(i).getTestPicturePath();
                        poleTenTestPicturePath = poleTenTestPicturePath.substring(poleTenTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleTen.get(i).getTestType() != null && PoleData.getInstance().poleTen.get(i).getTestType().equalsIgnoreCase("Visual Test")) {
                        visualTenTestPicturePath = PoleData.getInstance().poleTen.get(i).getTestPicturePath();
                        visualTenTestPicturePath = visualTenTestPicturePath.substring(visualTenTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleTen.get(i).getTestType() != null && PoleData.getInstance().poleTen.get(i).getTestType().equalsIgnoreCase("Sound Test")) {
                        soundTenTestPicturePath = PoleData.getInstance().poleTen.get(i).getTestPicturePath();
                        soundTenTestPicturePath = soundTenTestPicturePath.substring(soundTenTestPicturePath.lastIndexOf("/") + 1);
                    } else if (PoleData.getInstance().poleTen.get(i).getTestType() != null && PoleData.getInstance().poleTen.get(i).getTestType().equalsIgnoreCase("resistograph Test")) {
                        resistographTenTestPicturePath = PoleData.getInstance().poleTen.get(i).getTestPicturePath();
                        resistographTenTestPicturePath = resistographTenTestPicturePath.substring(resistographTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleTen.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsPoleTen.put(PoleData.getInstance().poleTen.get(i).getTestingType(), PoleData.getInstance().poleTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleTen.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsPoleTen.put(PoleData.getInstance().poleTen.get(i).getTestingTypePass(), PoleData.getInstance().poleTen.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().poleTen.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleTen.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleTen.get(i).getKvaSize();
                        if (PoleData.getInstance().poleTen.get(i).getSubTitle() != null) {
                            damageDetailsPoleTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleTen.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleTen.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleTen.get(i).getNote();
                        if (PoleData.getInstance().poleTen.get(i).getSubTitle() != null) {
                            damageDetailsPoleTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleTen.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsPoleTen.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleTen.get(i).getTitle() != null)
                        poleTitle = PoleData.getInstance().poleTen.get(i).getTitle();
                    if (PoleData.getInstance().poleTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleTen.get(i).getDisplayName());
                    if (PoleData.getInstance().poleTen.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleTen.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleTen.get(i).getName();
                        if (isSelected) {
                            damageDetailsPoleTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsPoleTen;
    }

    public JSONObject readguyWireOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireOne != null && PoleData.getInstance().guyWireOne.size() > 0) {
            try {
                if (damageDetailsguyWireOne == null)
                    damageDetailsguyWireOne = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().guyWireOne.size(); i++) {
                    if (PoleData.getInstance().guyWireOne.get(i).getPicturePath() != null) {
                        guyWireOnePicturePath = PoleData.getInstance().guyWireOne.get(i).getPicturePath();
//                        guyWireOnePicturePath = guyWireOnePicturePath.substring(guyWireOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireOne.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireOne.get(i).getTestType() != null && PoleData.getInstance().guyWireOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireOneTestPicturePath = PoleData.getInstance().guyWireOne.get(i).getTestPicturePath();
                        guyWireOneTestPicturePath = guyWireOneTestPicturePath.substring(guyWireOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireOne.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireOne.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireOne.put(PoleData.getInstance().guyWireOne.get(i).getTestingType(), PoleData.getInstance().guyWireOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireOne.put(PoleData.getInstance().guyWireOne.get(i).getTestingTypePass(), PoleData.getInstance().guyWireOne.get(i).getIsTesstingPassResult());

                        }
                    }
                    if (PoleData.getInstance().guyWireOne.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireOne.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireOne.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireOne.get(i).getSubTitle() != null) {
                            damageDetailsguyWireOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireOne.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireOne.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireOne.get(i).getNote();
                        if (PoleData.getInstance().guyWireOne.get(i).getSubTitle() != null) {
                            damageDetailsguyWireOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireOne.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireOne.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireOne.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireOne.get(i).getTitle();
                    if (PoleData.getInstance().guyWireOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireOne.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireOne.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireOne.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireOne.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireOne.put(displayName, isSelected);

                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireOne;
    }

    public JSONObject readguyWireTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireTwo != null && PoleData.getInstance().guyWireTwo.size() > 0) {
            try {
                if (damageDetailsguyWireTwo == null)
                    damageDetailsguyWireTwo = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().guyWireTwo.size(); i++) {

                    if (PoleData.getInstance().guyWireTwo.get(i).getPicturePath() != null) {
                        guyWireTwoPicturePath = PoleData.getInstance().guyWireTwo.get(i).getPicturePath();
//                        guyWireTwoPicturePath = guyWireTwoPicturePath.substring(guyWireTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireTwo.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireTwo.get(i).getTestType() != null && PoleData.getInstance().guyWireTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireTwoTestPicturePath = PoleData.getInstance().guyWireTwo.get(i).getTestPicturePath();
                        guyWireTwoTestPicturePath = guyWireTwoTestPicturePath.substring(guyWireTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireTwo.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireTwo.put(PoleData.getInstance().guyWireTwo.get(i).getTestingType(), PoleData.getInstance().guyWireTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireTwo.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireTwo.put(PoleData.getInstance().guyWireTwo.get(i).getTestingTypePass(), PoleData.getInstance().guyWireTwo.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().guyWireTwo.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireTwo.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireTwo.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireTwo.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireTwo.get(i).getSubTitle() != null) {
                            damageDetailsguyWireTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireTwo.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireTwo.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireTwo.get(i).getNote();
                        if (PoleData.getInstance().guyWireTwo.get(i).getSubTitle() != null) {
                            damageDetailsguyWireTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireTwo.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireTwo.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireTwo.get(i).getTitle();
                    if (PoleData.getInstance().guyWireTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireTwo.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireTwo.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireTwo.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireTwo.put(displayName, isSelected);
                           // damageDetailsguyWireTwo.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireTwo;
    }

    public JSONObject readguyWireThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireThree != null && PoleData.getInstance().guyWireThree.size() > 0) {
            try {
                if (damageDetailsguyWireThree == null)
                    damageDetailsguyWireThree = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().guyWireThree.size(); i++) {
                    if (PoleData.getInstance().guyWireThree.get(i).getPicturePath() != null) {
                        guyWireThreePicturePath = PoleData.getInstance().guyWireThree.get(i).getPicturePath();
//                        guyWireThreePicturePath = guyWireThreePicturePath.substring(guyWireThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireThree.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireThree.get(i).getTestType() != null && PoleData.getInstance().guyWireThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireThreeTestPicturePath = PoleData.getInstance().guyWireThree.get(i).getTestPicturePath();
                        guyWireThreeTestPicturePath = guyWireThreeTestPicturePath.substring(guyWireThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireThree.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireThree.put(PoleData.getInstance().guyWireThree.get(i).getTestingType(), PoleData.getInstance().guyWireThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireThree.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireThree.put(PoleData.getInstance().guyWireThree.get(i).getTestingTypePass(), PoleData.getInstance().guyWireThree.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().guyWireThree.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireThree.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireThree.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireThree.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireThree.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireThree.get(i).getSubTitle() != null) {
                            damageDetailsguyWireThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireThree.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireThree.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireThree.get(i).getNote();
                        if (PoleData.getInstance().guyWireThree.get(i).getSubTitle() != null) {
                            damageDetailsguyWireThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireThree.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireThree.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireThree.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireThree.get(i).getTitle();
                    if (PoleData.getInstance().guyWireThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireThree.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireThree.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireThree.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireThree.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireThree.put(displayName, isSelected);
                           // damageDetailsguyWireThree.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireThree;
    }

    public JSONObject readguyWireFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireFour != null && PoleData.getInstance().guyWireFour.size() > 0) {
            try {
                if (damageDetailsguyWireFour == null)
                    damageDetailsguyWireFour = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().guyWireFour.size(); i++) {
                    if (PoleData.getInstance().guyWireFour.get(i).getPicturePath() != null) {
                        guyWireFourPicturePath = PoleData.getInstance().guyWireFour.get(i).getPicturePath();
//                        guyWireFourPicturePath = guyWireFourPicturePath.substring(guyWireFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireFour.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireFour.get(i).getTestType() != null && PoleData.getInstance().guyWireFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireFourTestPicturePath = PoleData.getInstance().guyWireFour.get(i).getTestPicturePath();
                        guyWireFourTestPicturePath = guyWireFourTestPicturePath.substring(guyWireFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireFour.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireFour.put(PoleData.getInstance().guyWireFour.get(i).getTestingType(), PoleData.getInstance().guyWireFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireFour.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireFour.put(PoleData.getInstance().guyWireFour.get(i).getTestingTypePass(), PoleData.getInstance().guyWireFour.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().guyWireFour.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireFour.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireFour.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireFour.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireFour.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireFour.get(i).getSubTitle() != null) {
                            damageDetailsguyWireFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireFour.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireFour.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireFour.get(i).getNote();
                        if (PoleData.getInstance().guyWireFour.get(i).getSubTitle() != null) {
                            damageDetailsguyWireFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireFour.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireFour.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireFour.get(i).getTitle();
                    if (PoleData.getInstance().guyWireFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireFour.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireFour.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireFour.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireFour.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireFour.put(displayName, isSelected);
                           // damageDetailsguyWireFour.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireFour;
    }

    public JSONObject readguyWireFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireFive != null && PoleData.getInstance().guyWireFive.size() > 0) {
            try {
                if (damageDetailsguyWireFive == null)
                    damageDetailsguyWireFive = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().guyWireFive.size(); i++) {

                    if (PoleData.getInstance().guyWireFive.get(i).getPicturePath() != null) {
                        guyWireFivePicturePath = PoleData.getInstance().guyWireFive.get(i).getPicturePath();
//                        guyWireFivePicturePath = guyWireFivePicturePath.substring(guyWireFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireFive.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireFive.get(i).getTestType() != null && PoleData.getInstance().guyWireFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireFiveTestPicturePath = PoleData.getInstance().guyWireFive.get(i).getTestPicturePath();
                        guyWireFiveTestPicturePath = guyWireFiveTestPicturePath.substring(guyWireFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireFive.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireFive.put(PoleData.getInstance().guyWireFive.get(i).getTestingType(), PoleData.getInstance().guyWireFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireFive.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireFive.put(PoleData.getInstance().guyWireFive.get(i).getTestingTypePass(), PoleData.getInstance().guyWireFive.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().guyWireFive.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireFive.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireFive.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireFive.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireFive.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireFive.get(i).getSubTitle() != null) {
                            damageDetailsguyWireFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireFive.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireFive.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireFive.get(i).getNote();
                        if (PoleData.getInstance().guyWireFive.get(i).getSubTitle() != null) {
                            damageDetailsguyWireFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireFive.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireFive.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireFive.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireFive.get(i).getTitle();
                    if (PoleData.getInstance().guyWireFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireFive.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireFive.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireFive.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireFive.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireFive.put(displayName, isSelected);
                           // damageDetailsguyWireFive.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireFive;
    }

    public JSONObject readguyWireSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireSix != null && PoleData.getInstance().guyWireSix.size() > 0) {
            try {
                if (damageDetailsguyWireSix == null)
                    damageDetailsguyWireSix = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().guyWireSix.size(); i++) {

                    if (PoleData.getInstance().guyWireSix.get(i).getPicturePath() != null) {
                        guyWireSixPicturePath = PoleData.getInstance().guyWireSix.get(i).getPicturePath();
//                        guyWireSixPicturePath = guyWireSixPicturePath.substring(guyWireSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireSix.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireSix.get(i).getTestType() != null && PoleData.getInstance().guyWireSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireSixTestPicturePath = PoleData.getInstance().guyWireSix.get(i).getTestPicturePath();
                        guyWireSixTestPicturePath = guyWireSixTestPicturePath.substring(guyWireSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireSix.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireSix.put(PoleData.getInstance().guyWireSix.get(i).getTestingType(), PoleData.getInstance().guyWireSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireSix.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireSix.put(PoleData.getInstance().guyWireSix.get(i).getTestingTypePass(), PoleData.getInstance().guyWireSix.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().guyWireSix.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireSix.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireSix.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireSix.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireSix.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireSix.get(i).getSubTitle() != null) {
                            damageDetailsguyWireSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireSix.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireSix.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireSix.get(i).getNote();
                        if (PoleData.getInstance().guyWireSix.get(i).getSubTitle() != null) {
                            damageDetailsguyWireSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireSix.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireSix.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireSix.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireSix.get(i).getTitle();
                    if (PoleData.getInstance().guyWireSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireSix.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireSix.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireSix.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireSix.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireSix.put(displayName, isSelected);
                          //  damageDetailsguyWireSix.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireSix;
    }

    public JSONObject readguyWireSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireSeven != null && PoleData.getInstance().guyWireSeven.size() > 0) {
            try {
                if (damageDetailsguyWireSeven == null)
                    damageDetailsguyWireSeven = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().guyWireSeven.size(); i++) {
                    if (PoleData.getInstance().guyWireSeven.get(i).getPicturePath() != null) {
                        guyWireSevenPicturePath = PoleData.getInstance().guyWireSeven.get(i).getPicturePath();
//                        guyWireSevenPicturePath = guyWireSevenPicturePath.substring(guyWireSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireSeven.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireSeven.get(i).getTestType() != null && PoleData.getInstance().guyWireSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireSevenTestPicturePath = PoleData.getInstance().guyWireSeven.get(i).getTestPicturePath();
                        guyWireSevenTestPicturePath = guyWireSevenTestPicturePath.substring(guyWireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireSeven.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireSeven.put(PoleData.getInstance().guyWireSeven.get(i).getTestingType(), PoleData.getInstance().guyWireSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireSeven.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireSeven.put(PoleData.getInstance().guyWireSeven.get(i).getTestingTypePass(), PoleData.getInstance().guyWireSeven.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().guyWireSeven.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireSeven.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireSeven.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireSeven.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireSeven.get(i).getSubTitle() != null) {
                            damageDetailsguyWireSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireSeven.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireSeven.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireSeven.get(i).getNote();
                        if (PoleData.getInstance().guyWireSeven.get(i).getSubTitle() != null) {
                            damageDetailsguyWireSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireSeven.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireSeven.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireSeven.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireSeven.get(i).getTitle();
                    if (PoleData.getInstance().guyWireSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireSeven.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireSeven.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireSeven.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireSeven.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireSeven.put(displayName, isSelected);
                           // damageDetailsguyWireSeven.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireSeven;
    }

    public JSONObject readguyWireEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireEight != null && PoleData.getInstance().guyWireEight.size() > 0) {
            try {
                if (damageDetailsguyWireEight == null)
                    damageDetailsguyWireEight = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().guyWireEight.size(); i++) {

                    if (PoleData.getInstance().guyWireEight.get(i).getPicturePath() != null) {
                        guyWireEightPicturePath = PoleData.getInstance().guyWireEight.get(i).getPicturePath();
//                        guyWireEightPicturePath = guyWireEightPicturePath.substring(guyWireEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireEight.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireEight.get(i).getTestType() != null && PoleData.getInstance().guyWireEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireEightTestPicturePath = PoleData.getInstance().guyWireEight.get(i).getTestPicturePath();
                        guyWireEightTestPicturePath = guyWireEightTestPicturePath.substring(guyWireEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireEight.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireEight.put(PoleData.getInstance().guyWireEight.get(i).getTestingType(), PoleData.getInstance().guyWireEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireEight.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireEight.put(PoleData.getInstance().guyWireEight.get(i).getTestingTypePass(), PoleData.getInstance().guyWireEight.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().guyWireEight.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireEight.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireEight.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireEight.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireEight.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireEight.get(i).getSubTitle() != null) {
                            damageDetailsguyWireEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireEight.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireEight.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireEight.get(i).getNote();
                        if (PoleData.getInstance().guyWireEight.get(i).getSubTitle() != null) {
                            damageDetailsguyWireEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireEight.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireEight.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireEight.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireEight.get(i).getTitle();
                    if (PoleData.getInstance().guyWireEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireEight.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireEight.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireEight.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireEight.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireEight.put(displayName, isSelected);
                           // damageDetailsguyWireEight.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireEight;
    }

    public JSONObject readguyWireNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireNine != null && PoleData.getInstance().guyWireNine.size() > 0) {
            try {
                if (damageDetailsguyWireNine == null)
                    damageDetailsguyWireNine = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().guyWireNine.size(); i++) {
                    if (PoleData.getInstance().guyWireNine.get(i).getPicturePath() != null) {
                        guyWireNinePicturePath = PoleData.getInstance().guyWireNine.get(i).getPicturePath();
//                        guyWireNinePicturePath = guyWireNinePicturePath.substring(guyWireNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireNine.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireNine.get(i).getTestType() != null && PoleData.getInstance().guyWireNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireNineTestPicturePath = PoleData.getInstance().guyWireNine.get(i).getTestPicturePath();
                        guyWireNineTestPicturePath = guyWireNineTestPicturePath.substring(guyWireNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireNine.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireNine.put(PoleData.getInstance().guyWireNine.get(i).getTestingType(), PoleData.getInstance().guyWireNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireNine.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireNine.put(PoleData.getInstance().guyWireNine.get(i).getTestingTypePass(), PoleData.getInstance().guyWireNine.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().guyWireNine.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireNine.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireNine.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireNine.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireNine.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireNine.get(i).getSubTitle() != null) {
                            damageDetailsguyWireNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireNine.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireNine.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireNine.get(i).getNote();
                        if (PoleData.getInstance().guyWireNine.get(i).getSubTitle() != null) {
                            damageDetailsguyWireNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireNine.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireNine.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireNine.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireNine.get(i).getTitle();
                    if (PoleData.getInstance().guyWireNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireNine.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireNine.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireNine.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireNine.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireNine.put(displayName, isSelected);
                           // damageDetailsguyWireNine.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireNine;
    }

    public JSONObject readguyWireTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().guyWireTen != null && PoleData.getInstance().guyWireTen.size() > 0) {
            try {
                if (damageDetailsguyWireTen == null)
                    damageDetailsguyWireTen = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().guyWireTen.size(); i++) {

                    if (PoleData.getInstance().guyWireTen.get(i).getPicturePath() != null) {
                        guyWireTenPicturePath = PoleData.getInstance().guyWireTen.get(i).getPicturePath();
//                        guyWireTenPicturePath = guyWireTenPicturePath.substring(guyWireTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireTen.get(i).getTestPicturePath() != null && PoleData.getInstance().guyWireTen.get(i).getTestType() != null && PoleData.getInstance().guyWireTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        guyWireTenTestPicturePath = PoleData.getInstance().guyWireTen.get(i).getTestPicturePath();
                        guyWireTenTestPicturePath = guyWireTenTestPicturePath.substring(guyWireTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().guyWireTen.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().guyWireTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsguyWireTen.put(PoleData.getInstance().guyWireTen.get(i).getTestingType(), PoleData.getInstance().guyWireTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().guyWireTen.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().guyWireTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsguyWireTen.put(PoleData.getInstance().guyWireTen.get(i).getTestingTypePass(), PoleData.getInstance().guyWireTen.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().guyWireTen.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsguyWireTen.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().guyWireTen.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().guyWireTen.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().guyWireTen.get(i).getKvaSize();
                        if (PoleData.getInstance().guyWireTen.get(i).getSubTitle() != null) {
                            damageDetailsguyWireTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().guyWireTen.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().guyWireTen.get(i).getSubTitle();
                        addNote = PoleData.getInstance().guyWireTen.get(i).getNote();
                        if (PoleData.getInstance().guyWireTen.get(i).getSubTitle() != null) {
                            damageDetailsguyWireTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().guyWireTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().guyWireTen.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().guyWireTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsguyWireTen.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().guyWireTen.get(i).getTitle() != null)
                        guyWireTitle = PoleData.getInstance().guyWireTen.get(i).getTitle();
                    if (PoleData.getInstance().guyWireTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().guyWireTen.get(i).getDisplayName());
                    if (PoleData.getInstance().guyWireTen.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().guyWireTen.get(i).getIsSelected();
                        displayName = PoleData.getInstance().guyWireTen.get(i).getName();
                        if (isSelected) {
                            damageDetailsguyWireTen.put(displayName, isSelected);
                           // damageDetailsguyWireTen.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsguyWireTen;
    }

    public JSONObject readanchorOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorOne != null && PoleData.getInstance().anchorOne.size() > 0) {
            try {
                if (damageDetailsanchorOne == null)
                    damageDetailsanchorOne = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().anchorOne.size(); i++) {

                    if (PoleData.getInstance().anchorOne.get(i).getPicturePath() != null) {
                        anchorOnePicturePath = PoleData.getInstance().anchorOne.get(i).getPicturePath();
//                        anchorOnePicturePath = anchorOnePicturePath.substring(anchorOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorOne.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorOne.get(i).getTestType() != null && PoleData.getInstance().anchorOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorOneTestPicturePath = PoleData.getInstance().anchorOne.get(i).getTestPicturePath();
                        anchorOneTestPicturePath = anchorOneTestPicturePath.substring(anchorOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorOne.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorOne.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorOne.put(PoleData.getInstance().anchorOne.get(i).getTestingType(), PoleData.getInstance().anchorOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorOne.put(PoleData.getInstance().anchorOne.get(i).getTestingTypePass(), PoleData.getInstance().anchorOne.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorOne.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorOne.put("isPoleRejected",true);
                            }*/
                        }
                    }

                  /*  if (PoleData.getInstance().anchorOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorTen.put(PoleData.getInstance().anchorOne.get(i).getTestingTypePass(), PoleData.getInstance().anchorOne.get(i).getIsTesstingPassResult());
                            if(!PoleData.getInstance().anchorOne.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorTen.put("isPoleRejected",true);
                            }
                        }
                    }*/
                    if (PoleData.getInstance().anchorOne.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorOne.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorOne.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorOne.get(i).getSubTitle() != null) {
                            damageDetailsanchorOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorOne.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorOne.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorOne.get(i).getNote();
                        if (PoleData.getInstance().anchorOne.get(i).getSubTitle() != null) {
                            damageDetailsanchorOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorOne.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorOne.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorOne.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorOne.get(i).getTitle();
                    if (PoleData.getInstance().anchorOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorOne.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorOne.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorOne.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorOne.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorOne.put(displayName, isSelected);
                           // damageDetailsanchorOne.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorOne;
    }

    public JSONObject readanchorTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorTwo != null && PoleData.getInstance().anchorTwo.size() > 0) {
            try {
                if (damageDetailsanchorTwo == null)
                    damageDetailsanchorTwo = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorTwo.size(); i++) {

                    if (PoleData.getInstance().anchorTwo.get(i).getPicturePath() != null) {
                        anchorTwoPicturePath = PoleData.getInstance().anchorTwo.get(i).getPicturePath();
//                        anchorTwoPicturePath = anchorTwoPicturePath.substring(anchorTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorTwo.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorTwo.get(i).getTestType() != null && PoleData.getInstance().anchorTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorTwoTestPicturePath = PoleData.getInstance().anchorTwo.get(i).getTestPicturePath();
                        anchorTwoTestPicturePath = anchorTwoTestPicturePath.substring(anchorTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorTwo.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorTwo.put(PoleData.getInstance().anchorTwo.get(i).getTestingType(), PoleData.getInstance().anchorTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorTwo.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorTwo.put(PoleData.getInstance().anchorTwo.get(i).getTestingTypePass(), PoleData.getInstance().anchorTwo.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorTwo.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorTwo.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorTwo.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorTwo.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorTwo.get(i).getSubTitle() != null) {
                            damageDetailsanchorTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorTwo.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorTwo.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorTwo.get(i).getNote();
                        if (PoleData.getInstance().anchorTwo.get(i).getSubTitle() != null) {
                            damageDetailsanchorTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorTwo.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorTwo.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorTwo.get(i).getTitle();
                    if (PoleData.getInstance().anchorTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorTwo.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorTwo.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorTwo.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorTwo.put(displayName, isSelected);
                           // damageDetailsanchorTwo.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorTwo;
    }

    public JSONObject readanchorThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorThree != null && PoleData.getInstance().anchorThree.size() > 0) {
            try {
                if (damageDetailsanchorThree == null)
                    damageDetailsanchorThree = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorThree.size(); i++) {

                    if (PoleData.getInstance().anchorThree.get(i).getPicturePath() != null) {
                        anchorThreePicturePath = PoleData.getInstance().anchorThree.get(i).getPicturePath();
//                        anchorThreePicturePath = anchorThreePicturePath.substring(anchorThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorThree.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorThree.get(i).getTestType() != null && PoleData.getInstance().anchorThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorThreeTestPicturePath = PoleData.getInstance().anchorThree.get(i).getTestPicturePath();
                        anchorThreeTestPicturePath = anchorThreeTestPicturePath.substring(anchorThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorThree.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorThree.put(PoleData.getInstance().anchorThree.get(i).getTestingType(), PoleData.getInstance().anchorThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorThree.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorThree.put(PoleData.getInstance().anchorThree.get(i).getTestingTypePass(), PoleData.getInstance().anchorThree.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorThree.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorThree.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorThree.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorThree.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorThree.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorThree.get(i).getSubTitle() != null) {
                            damageDetailsanchorThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorThree.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorThree.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorThree.get(i).getNote();
                        if (PoleData.getInstance().anchorThree.get(i).getSubTitle() != null) {
                            damageDetailsanchorThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorThree.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorThree.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorThree.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorThree.get(i).getTitle();
                    if (PoleData.getInstance().anchorThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorThree.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorThree.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorThree.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorThree.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorThree.put(displayName, isSelected);
                            //damageDetailsanchorThree.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorThree;
    }

    public JSONObject readanchorFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorFour != null && PoleData.getInstance().anchorFour.size() > 0) {
            try {
                if (damageDetailsanchorFour == null)
                    damageDetailsanchorFour = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorFour.size(); i++) {
                    if (PoleData.getInstance().anchorFour.get(i).getPicturePath() != null) {
                        anchorFourPicturePath = PoleData.getInstance().anchorFour.get(i).getPicturePath();
//                        anchorFourPicturePath = anchorFourPicturePath.substring(anchorFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorFour.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorFour.get(i).getTestType() != null && PoleData.getInstance().anchorFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorFourTestPicturePath = PoleData.getInstance().anchorFour.get(i).getTestPicturePath();
                        anchorFourTestPicturePath = anchorFourTestPicturePath.substring(anchorFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorFour.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorFour.put(PoleData.getInstance().anchorFour.get(i).getTestingType(), PoleData.getInstance().anchorFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorFour.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorFour.put(PoleData.getInstance().anchorFour.get(i).getTestingTypePass(), PoleData.getInstance().anchorFour.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorFour.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorFour.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorFour.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorFour.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorFour.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorFour.get(i).getSubTitle() != null) {
                            damageDetailsanchorFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorFour.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorFour.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorFour.get(i).getNote();
                        if (PoleData.getInstance().anchorFour.get(i).getSubTitle() != null) {
                            damageDetailsanchorFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorFour.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorFour.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorFour.get(i).getTitle();
                    if (PoleData.getInstance().anchorFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorFour.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorFour.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorFour.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorFour.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorFour.put(displayName, isSelected);
                            //damageDetailsanchorFour.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorFour;
    }

    public JSONObject readanchorFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorFive != null && PoleData.getInstance().anchorFive.size() > 0) {
            try {
                if (damageDetailsanchorFive == null)
                    damageDetailsanchorFive = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorFive.size(); i++) {
                    if (PoleData.getInstance().anchorFive.get(i).getPicturePath() != null) {
                        anchorFivePicturePath = PoleData.getInstance().anchorFive.get(i).getPicturePath();
//                        anchorFivePicturePath = anchorFivePicturePath.substring(anchorFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorFive.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorFive.get(i).getTestType() != null && PoleData.getInstance().anchorFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorFiveTestPicturePath = PoleData.getInstance().anchorFive.get(i).getTestPicturePath();
                        anchorFiveTestPicturePath = anchorFiveTestPicturePath.substring(anchorFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorFive.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorFive.put(PoleData.getInstance().anchorFive.get(i).getTestingType(), PoleData.getInstance().anchorFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorFive.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorFive.put(PoleData.getInstance().anchorFive.get(i).getTestingTypePass(), PoleData.getInstance().anchorFive.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorFive.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorFive.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorFive.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorFive.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorFive.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorFive.get(i).getSubTitle() != null) {
                            damageDetailsanchorFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorFive.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorFive.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorFive.get(i).getNote();
                        if (PoleData.getInstance().anchorFive.get(i).getSubTitle() != null) {
                            damageDetailsanchorFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorFive.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorFive.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorFive.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorFive.get(i).getTitle();
                    if (PoleData.getInstance().anchorFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorFive.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorFive.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorFive.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorFive.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorFive.put(displayName, isSelected);
                           // damageDetailsanchorFive.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorFive;
    }

    public JSONObject readanchorSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorSix != null && PoleData.getInstance().anchorSix.size() > 0) {
            try {
                if (damageDetailsanchorSix == null)
                    damageDetailsanchorSix = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorSix.size(); i++) {
                    if (PoleData.getInstance().anchorSix.get(i).getPicturePath() != null) {
                        anchorSixPicturePath = PoleData.getInstance().anchorSix.get(i).getPicturePath();
//                        anchorSixPicturePath = anchorSixPicturePath.substring(anchorSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorSix.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorSix.get(i).getTestType() != null && PoleData.getInstance().anchorSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorSixTestPicturePath = PoleData.getInstance().anchorSix.get(i).getTestPicturePath();
                        anchorSixTestPicturePath = anchorSixTestPicturePath.substring(anchorSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorSix.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorSix.put(PoleData.getInstance().anchorSix.get(i).getTestingType(), PoleData.getInstance().anchorSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorSix.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorSix.put(PoleData.getInstance().anchorSix.get(i).getTestingTypePass(), PoleData.getInstance().anchorSix.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().anchorSix.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorSix.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorSix.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorSix.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorSix.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorSix.get(i).getSubTitle() != null) {
                            damageDetailsanchorSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorSix.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorSix.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorSix.get(i).getNote();
                        if (PoleData.getInstance().anchorSix.get(i).getSubTitle() != null) {
                            damageDetailsanchorSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorSix.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorSix.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorSix.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorSix.get(i).getTitle();
                    if (PoleData.getInstance().anchorSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorSix.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorSix.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorSix.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorSix.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorSix.put(displayName, isSelected);
                           // damageDetailsanchorSix.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorSix;
    }

    public JSONObject readanchorSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorSeven != null && PoleData.getInstance().anchorSeven.size() > 0) {
            try {
                if (damageDetailsanchorSeven == null)
                    damageDetailsanchorSeven = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorSeven.size(); i++) {

                    if (PoleData.getInstance().anchorSeven.get(i).getPicturePath() != null) {
                        anchorSevenPicturePath = PoleData.getInstance().anchorSeven.get(i).getPicturePath();
//                        anchorSevenPicturePath = anchorSevenPicturePath.substring(anchorSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorSeven.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorSeven.get(i).getTestType() != null && PoleData.getInstance().anchorSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorSevenTestPicturePath = PoleData.getInstance().anchorSeven.get(i).getTestPicturePath();
                        anchorSevenTestPicturePath = anchorSevenTestPicturePath.substring(anchorSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorSeven.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorSeven.put(PoleData.getInstance().anchorSeven.get(i).getTestingType(), PoleData.getInstance().anchorSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorSeven.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorSeven.put(PoleData.getInstance().anchorSeven.get(i).getTestingTypePass(), PoleData.getInstance().anchorSeven.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorSeven.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorSeven.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorSeven.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorSeven.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorSeven.get(i).getSubTitle() != null) {
                            damageDetailsanchorSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorSeven.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorSeven.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorSeven.get(i).getNote();
                        if (PoleData.getInstance().anchorSeven.get(i).getSubTitle() != null) {
                            damageDetailsanchorSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorSeven.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorSeven.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorSeven.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorSeven.get(i).getTitle();
                    if (PoleData.getInstance().anchorSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorSeven.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorSeven.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorSeven.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorSeven.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorSeven.put(displayName, isSelected);
                          //  damageDetailsanchorSeven.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorSeven;
    }

    public JSONObject readanchorEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorEight != null && PoleData.getInstance().anchorEight.size() > 0) {
            try {
                if (damageDetailsanchorEight == null)
                    damageDetailsanchorEight = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().anchorEight.size(); i++) {
                    if (PoleData.getInstance().anchorEight.get(i).getPicturePath() != null) {
                        anchorEightPicturePath = PoleData.getInstance().anchorEight.get(i).getPicturePath();
//                        anchorEightPicturePath = anchorEightPicturePath.substring(anchorEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorEight.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorEight.get(i).getTestType() != null && PoleData.getInstance().anchorEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorEightTestPicturePath = PoleData.getInstance().anchorEight.get(i).getTestPicturePath();
                        anchorEightTestPicturePath = anchorEightTestPicturePath.substring(anchorEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorEight.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorEight.put(PoleData.getInstance().anchorEight.get(i).getTestingType(), PoleData.getInstance().anchorEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorEight.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorEight.put(PoleData.getInstance().anchorEight.get(i).getTestingTypePass(), PoleData.getInstance().anchorEight.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorEight.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorEight.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorEight.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorEight.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorEight.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorEight.get(i).getSubTitle() != null) {
                            damageDetailsanchorEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorEight.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorEight.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorEight.get(i).getNote();
                        if (PoleData.getInstance().anchorEight.get(i).getSubTitle() != null) {
                            damageDetailsanchorEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorEight.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorEight.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorEight.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorEight.get(i).getTitle();
                    if (PoleData.getInstance().anchorEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorEight.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorEight.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorEight.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorEight.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorEight.put(displayName, isSelected);
                          //  damageDetailsanchorEight.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorEight;
    }

    public JSONObject readanchorNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorNine != null && PoleData.getInstance().anchorNine.size() > 0) {
            try {
                if (damageDetailsanchorNine == null)
                    damageDetailsanchorNine = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorNine.size(); i++) {

                    if (PoleData.getInstance().anchorNine.get(i).getPicturePath() != null) {
                        anchorNinePicturePath = PoleData.getInstance().anchorNine.get(i).getPicturePath();
//                        anchorNinePicturePath = anchorNinePicturePath.substring(anchorNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorNine.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorNine.get(i).getTestType() != null && PoleData.getInstance().anchorNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorNineTestPicturePath = PoleData.getInstance().anchorNine.get(i).getTestPicturePath();
                        anchorNineTestPicturePath = anchorNineTestPicturePath.substring(anchorNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorNine.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorNine.put(PoleData.getInstance().anchorNine.get(i).getTestingType(), PoleData.getInstance().anchorNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorNine.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorNine.put(PoleData.getInstance().anchorNine.get(i).getTestingTypePass(), PoleData.getInstance().anchorNine.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorNine.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorNine.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorNine.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorNine.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorNine.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorNine.get(i).getSubTitle() != null) {
                            damageDetailsanchorNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorNine.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorNine.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorNine.get(i).getNote();
                        if (PoleData.getInstance().anchorNine.get(i).getSubTitle() != null) {
                            damageDetailsanchorNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorNine.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorNine.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorNine.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorNine.get(i).getTitle();
                    if (PoleData.getInstance().anchorNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorNine.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorNine.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorNine.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorNine.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorNine.put(displayName, isSelected);
                           // damageDetailsanchorNine.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorNine;
    }

    public JSONObject readanchorTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().anchorTen != null && PoleData.getInstance().anchorTen.size() > 0) {
            try {
                if (damageDetailsanchorTen == null)
                    damageDetailsanchorTen = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().anchorTen.size(); i++) {

                    if (PoleData.getInstance().anchorTen.get(i).getPicturePath() != null) {
                        anchorTenPicturePath = PoleData.getInstance().anchorTen.get(i).getPicturePath();
//                        anchorTenPicturePath = anchorTenPicturePath.substring(anchorTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorTen.get(i).getTestPicturePath() != null && PoleData.getInstance().anchorTen.get(i).getTestType() != null && PoleData.getInstance().anchorTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        anchorTenTestPicturePath = PoleData.getInstance().anchorTen.get(i).getTestPicturePath();
                        anchorTenTestPicturePath = anchorTenTestPicturePath.substring(anchorTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().anchorTen.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().anchorTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsanchorTen.put(PoleData.getInstance().anchorTen.get(i).getTestingType(), PoleData.getInstance().anchorTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().anchorTen.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().anchorTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsanchorTen.put(PoleData.getInstance().anchorTen.get(i).getTestingTypePass(), PoleData.getInstance().anchorTen.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().anchorTen.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsanchorTen.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().anchorTen.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().anchorTen.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().anchorTen.get(i).getKvaSize();
                        if (PoleData.getInstance().anchorTen.get(i).getSubTitle() != null) {
                            damageDetailsanchorTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().anchorTen.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().anchorTen.get(i).getSubTitle();
                        addNote = PoleData.getInstance().anchorTen.get(i).getNote();
                        if (PoleData.getInstance().anchorTen.get(i).getSubTitle() != null) {
                            damageDetailsanchorTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().anchorTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().anchorTen.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().anchorTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsanchorTen.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().anchorTen.get(i).getTitle() != null)
                        anchorTitle = PoleData.getInstance().anchorTen.get(i).getTitle();
                    if (PoleData.getInstance().anchorTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().anchorTen.get(i).getDisplayName());
                    if (PoleData.getInstance().anchorTen.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().anchorTen.get(i).getIsSelected();
                        displayName = PoleData.getInstance().anchorTen.get(i).getName();
                        if (isSelected) {
                            damageDetailsanchorTen.put(displayName, isSelected);
                           // damageDetailsanchorTen.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsanchorTen;
    }

    public JSONObject readprimaryRiserOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserOne != null && PoleData.getInstance().primaryRiserOne.size() > 0) {
            try {
                if (damageDetailsprimaryRiserOne == null)
                    damageDetailsprimaryRiserOne = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserOne.size(); i++) {

                    if (PoleData.getInstance().primaryRiserOne.get(i).getPicturePath() != null) {
                        primaryRiserOnePicturePath = PoleData.getInstance().primaryRiserOne.get(i).getPicturePath();
//                        primaryRiserOnePicturePath = primaryRiserOnePicturePath.substring(primaryRiserOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserOne.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserOne.get(i).getTestType() != null && PoleData.getInstance().primaryRiserOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserOneTestPicturePath = PoleData.getInstance().primaryRiserOne.get(i).getTestPicturePath();
                        primaryRiserOneTestPicturePath = primaryRiserOneTestPicturePath.substring(primaryRiserOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserOne.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserOne.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserOne.put(PoleData.getInstance().primaryRiserOne.get(i).getTestingType(), PoleData.getInstance().primaryRiserOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserOne.put(PoleData.getInstance().primaryRiserOne.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserOne.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().primaryRiserOne.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserOne.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().primaryRiserOne.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserOne.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserOne.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserOne.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserOne.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserOne.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserOne.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserOne.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserOne.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserOne.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserOne.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserOne.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserOne.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserOne.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserOne.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserOne.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserOne.put(displayName, isSelected);
                          //  damageDetailsprimaryRiserOne.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserOne;
    }

    public JSONObject readprimaryRiserTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserTwo != null && PoleData.getInstance().primaryRiserTwo.size() > 0) {
            try {
                if (damageDetailsprimaryRiserTwo == null)
                    damageDetailsprimaryRiserTwo = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserTwo.size(); i++) {
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getPicturePath() != null) {
                        primaryRiserTwoPicturePath = PoleData.getInstance().primaryRiserTwo.get(i).getPicturePath();
//                        primaryRiserTwoPicturePath = primaryRiserTwoPicturePath.substring(primaryRiserTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserTwo.get(i).getTestType() != null && PoleData.getInstance().primaryRiserTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserTwoTestPicturePath = PoleData.getInstance().primaryRiserTwo.get(i).getTestPicturePath();
                        primaryRiserTwoTestPicturePath = primaryRiserTwoTestPicturePath.substring(primaryRiserTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserTwo.put(PoleData.getInstance().primaryRiserTwo.get(i).getTestingType(), PoleData.getInstance().primaryRiserTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserTwo.put(PoleData.getInstance().primaryRiserTwo.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserTwo.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().primaryRiserTwo.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserTwo.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().primaryRiserTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserTwo.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserTwo.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserTwo.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserTwo.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserTwo.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserTwo.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserTwo.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserTwo.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserTwo.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserTwo.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserTwo.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserTwo.put(displayName, isSelected);
                           // damageDetailsprimaryRiserTwo.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserTwo;
    }

    public JSONObject readprimaryRiserThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserThree != null && PoleData.getInstance().primaryRiserThree.size() > 0) {
            try {
                if (damageDetailsprimaryRiserThree == null)
                    damageDetailsprimaryRiserThree = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().primaryRiserThree.size(); i++) {

                    if (PoleData.getInstance().primaryRiserThree.get(i).getPicturePath() != null) {
                        primaryRiserThreePicturePath = PoleData.getInstance().primaryRiserThree.get(i).getPicturePath();
//                        primaryRiserThreePicturePath = primaryRiserThreePicturePath.substring(primaryRiserThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserThree.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserThree.get(i).getTestType() != null && PoleData.getInstance().primaryRiserThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserThreeTestPicturePath = PoleData.getInstance().primaryRiserThree.get(i).getTestPicturePath();
                        primaryRiserThreeTestPicturePath = primaryRiserThreeTestPicturePath.substring(primaryRiserThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserThree.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserThree.put(PoleData.getInstance().primaryRiserThree.get(i).getTestingType(), PoleData.getInstance().primaryRiserThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserThree.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserThree.put(PoleData.getInstance().primaryRiserThree.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserThree.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().primaryRiserThree.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserThree.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().primaryRiserThree.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserThree.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserThree.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserThree.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserThree.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserThree.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserThree.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserThree.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserThree.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserThree.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserThree.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserThree.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserThree.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserThree.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserThree.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserThree.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserThree.put(displayName, isSelected);
                            //damageDetailsprimaryRiserThree.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserThree;
    }

    public JSONObject readprimaryRiserFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserFour != null && PoleData.getInstance().primaryRiserFour.size() > 0) {
            try {
                if (damageDetailsprimaryRiserFour == null)
                    damageDetailsprimaryRiserFour = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserFour.size(); i++) {
                    if (PoleData.getInstance().primaryRiserFour.get(i).getPicturePath() != null) {
                        primaryRiserFourPicturePath = PoleData.getInstance().primaryRiserFour.get(i).getPicturePath();
//                        primaryRiserFourPicturePath = primaryRiserFourPicturePath.substring(primaryRiserFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserFour.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserFour.get(i).getTestType() != null && PoleData.getInstance().primaryRiserFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserFourTestPicturePath = PoleData.getInstance().primaryRiserFour.get(i).getTestPicturePath();
                        primaryRiserFourTestPicturePath = primaryRiserFourTestPicturePath.substring(primaryRiserFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserFour.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserFour.put(PoleData.getInstance().primaryRiserFour.get(i).getTestingType(), PoleData.getInstance().primaryRiserFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFour.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserFour.put(PoleData.getInstance().primaryRiserFour.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserFour.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().primaryRiserFour.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserFour.put("isPoleRejected",true);
                            }*/
                        }
                    }

                    if (PoleData.getInstance().primaryRiserFour.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserFour.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserFour.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserFour.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFour.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserFour.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserFour.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserFour.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserFour.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFour.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserFour.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserFour.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserFour.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserFour.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserFour.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserFour.put(displayName, isSelected);
                          //  damageDetailsprimaryRiserFour.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserFour;
    }

    public JSONObject readprimaryRiserFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserFive != null && PoleData.getInstance().primaryRiserFive.size() > 0) {
            try {
                if (damageDetailsprimaryRiserFive == null)
                    damageDetailsprimaryRiserFive = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().primaryRiserFive.size(); i++) {

                    if (PoleData.getInstance().primaryRiserFive.get(i).getPicturePath() != null) {
                        primaryRiserFivePicturePath = PoleData.getInstance().primaryRiserFive.get(i).getPicturePath();
//                        primaryRiserFivePicturePath = primaryRiserFivePicturePath.substring(primaryRiserFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserFive.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserFive.get(i).getTestType() != null && PoleData.getInstance().primaryRiserFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserFiveTestPicturePath = PoleData.getInstance().primaryRiserFive.get(i).getTestPicturePath();
                        primaryRiserFiveTestPicturePath = primaryRiserFiveTestPicturePath.substring(primaryRiserFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserFive.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserFive.put(PoleData.getInstance().primaryRiserFive.get(i).getTestingType(), PoleData.getInstance().primaryRiserFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFive.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserFive.put(PoleData.getInstance().primaryRiserFive.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserFive.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().primaryRiserFive.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserFive.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFive.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserFive.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserFive.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserFive.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFive.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserFive.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserFive.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserFive.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserFive.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserFive.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserFive.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserFive.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserFive.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserFive.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserFive.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserFive.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserFive.put(displayName, isSelected);
                            //damageDetailsprimaryRiserFive.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserFive;
    }

    public JSONObject readprimaryRiserSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserSix != null && PoleData.getInstance().primaryRiserSix.size() > 0) {
            try {
                if (damageDetailsprimaryRiserSix == null)
                    damageDetailsprimaryRiserSix = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserSix.size(); i++) {
                    if (PoleData.getInstance().primaryRiserSix.get(i).getPicturePath() != null) {
                        primaryRiserSixPicturePath = PoleData.getInstance().primaryRiserSix.get(i).getPicturePath();
//                        primaryRiserSixPicturePath = primaryRiserSixPicturePath.substring(primaryRiserSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserSix.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserSix.get(i).getTestType() != null && PoleData.getInstance().primaryRiserSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserSixTestPicturePath = PoleData.getInstance().primaryRiserSix.get(i).getTestPicturePath();
                        primaryRiserSixTestPicturePath = primaryRiserSixTestPicturePath.substring(primaryRiserSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserSix.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserSix.put(PoleData.getInstance().primaryRiserSix.get(i).getTestingType(), PoleData.getInstance().primaryRiserSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSix.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserSix.put(PoleData.getInstance().primaryRiserSix.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserSix.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().primaryRiserSix.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserSix.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSix.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserSix.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserSix.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserSix.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSix.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserSix.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserSix.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserSix.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserSix.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserSix.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSix.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserSix.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserSix.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserSix.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserSix.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserSix.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserSix.put(displayName, isSelected);
                           // damageDetailsprimaryRiserSix.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserSix;
    }

    public JSONObject readprimaryRiserSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserSeven != null && PoleData.getInstance().primaryRiserSeven.size() > 0) {
            try {
                if (damageDetailsprimaryRiserSeven == null)
                    damageDetailsprimaryRiserSeven = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserSeven.size(); i++) {
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getPicturePath() != null) {
                        primaryRiserSevenPicturePath = PoleData.getInstance().primaryRiserSeven.get(i).getPicturePath();
//                        primaryRiserSevenPicturePath = primaryRiserSevenPicturePath.substring(primaryRiserSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserSeven.get(i).getTestType() != null && PoleData.getInstance().primaryRiserSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserSevenTestPicturePath = PoleData.getInstance().primaryRiserSeven.get(i).getTestPicturePath();
                        primaryRiserSevenTestPicturePath = primaryRiserSevenTestPicturePath.substring(primaryRiserSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserSeven.put(PoleData.getInstance().primaryRiserSeven.get(i).getTestingType(), PoleData.getInstance().primaryRiserSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserSeven.put(PoleData.getInstance().primaryRiserSeven.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserSeven.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().primaryRiserSeven.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserSeven.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserSeven.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserSeven.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserSeven.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserSeven.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserSeven.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserSeven.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserSeven.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserSeven.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserSeven.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserSeven.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserSeven.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserSeven.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserSeven.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserSeven.put(displayName, isSelected);
                          //  damageDetailsprimaryRiserSeven.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserSeven;
    }

    public JSONObject readprimaryRiserEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserEight != null && PoleData.getInstance().primaryRiserEight.size() > 0) {
            try {
                if (damageDetailsprimaryRiserEight == null)
                    damageDetailsprimaryRiserEight = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserEight.size(); i++) {

                    if (PoleData.getInstance().primaryRiserEight.get(i).getPicturePath() != null) {
                        primaryRiserEightPicturePath = PoleData.getInstance().primaryRiserEight.get(i).getPicturePath();
//                        primaryRiserEightPicturePath = primaryRiserEightPicturePath.substring(primaryRiserEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserEight.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserEight.get(i).getTestType() != null && PoleData.getInstance().primaryRiserEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserEightTestPicturePath = PoleData.getInstance().primaryRiserEight.get(i).getTestPicturePath();
                        primaryRiserEightTestPicturePath = primaryRiserEightTestPicturePath.substring(primaryRiserEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserEight.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserEight.put(PoleData.getInstance().primaryRiserEight.get(i).getTestingType(), PoleData.getInstance().primaryRiserEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserEight.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserEight.put(PoleData.getInstance().primaryRiserEight.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserEight.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().primaryRiserEight.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserEight.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().primaryRiserEight.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserEight.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserEight.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserEight.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserEight.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserEight.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserEight.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserEight.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserEight.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserEight.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserEight.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserEight.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserEight.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserEight.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserEight.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserEight.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserEight.put(displayName, isSelected);
                           // damageDetailsprimaryRiserEight.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserEight;
    }

    public JSONObject readprimaryRiserNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserNine != null && PoleData.getInstance().primaryRiserNine.size() > 0) {
            try {
                if (damageDetailsprimaryRiserNine == null)
                    damageDetailsprimaryRiserNine = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserNine.size(); i++) {

                    if (PoleData.getInstance().primaryRiserNine.get(i).getPicturePath() != null) {
                        primaryRiserNinePicturePath = PoleData.getInstance().primaryRiserNine.get(i).getPicturePath();
//                        primaryRiserNinePicturePath = primaryRiserNinePicturePath.substring(primaryRiserNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserNine.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserNine.get(i).getTestType() != null && PoleData.getInstance().primaryRiserNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserNineTestPicturePath = PoleData.getInstance().primaryRiserNine.get(i).getTestPicturePath();
                        primaryRiserNineTestPicturePath = primaryRiserNineTestPicturePath.substring(primaryRiserNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserNine.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserNine.put(PoleData.getInstance().primaryRiserNine.get(i).getTestingType(), PoleData.getInstance().primaryRiserNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserNine.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserNine.put(PoleData.getInstance().primaryRiserNine.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserNine.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().primaryRiserNine.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserNine.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().primaryRiserNine.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserNine.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserNine.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserNine.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserNine.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserNine.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserNine.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserNine.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserNine.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserNine.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserNine.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserNine.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserNine.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserNine.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserNine.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserNine.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserNine.put(displayName, isSelected);
                           // damageDetailsprimaryRiserNine.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserNine;
    }

    public JSONObject readprimaryRiserTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().primaryRiserTen != null && PoleData.getInstance().primaryRiserTen.size() > 0) {
            try {
                if (damageDetailsprimaryRiserTen == null)
                    damageDetailsprimaryRiserTen = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().primaryRiserTen.size(); i++) {

                    if (PoleData.getInstance().primaryRiserTen.get(i).getPicturePath() != null) {
                        primaryRiserTenPicturePath = PoleData.getInstance().primaryRiserTen.get(i).getPicturePath();
//                        primaryRiserTenPicturePath = primaryRiserTenPicturePath.substring(primaryRiserTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserTen.get(i).getTestPicturePath() != null && PoleData.getInstance().primaryRiserTen.get(i).getTestType() != null && PoleData.getInstance().primaryRiserTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        primaryRiserTenTestPicturePath = PoleData.getInstance().primaryRiserTen.get(i).getTestPicturePath();
                        primaryRiserTenTestPicturePath = primaryRiserTenTestPicturePath.substring(primaryRiserTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().primaryRiserTen.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().primaryRiserTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimaryRiserTen.put(PoleData.getInstance().primaryRiserTen.get(i).getTestingType(), PoleData.getInstance().primaryRiserTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTen.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().primaryRiserTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimaryRiserTen.put(PoleData.getInstance().primaryRiserTen.get(i).getTestingTypePass(), PoleData.getInstance().primaryRiserTen.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().primaryRiserTen.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsprimaryRiserTen.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTen.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().primaryRiserTen.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().primaryRiserTen.get(i).getKvaSize();
                        if (PoleData.getInstance().primaryRiserTen.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTen.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().primaryRiserTen.get(i).getSubTitle();
                        addNote = PoleData.getInstance().primaryRiserTen.get(i).getNote();
                        if (PoleData.getInstance().primaryRiserTen.get(i).getSubTitle() != null) {
                            damageDetailsprimaryRiserTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().primaryRiserTen.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().primaryRiserTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimaryRiserTen.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().primaryRiserTen.get(i).getTitle() != null)
                        primaryRiserTitle = PoleData.getInstance().primaryRiserTen.get(i).getTitle();
                    if (PoleData.getInstance().primaryRiserTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().primaryRiserTen.get(i).getDisplayName());
                    if (PoleData.getInstance().primaryRiserTen.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().primaryRiserTen.get(i).getIsSelected();
                        displayName = PoleData.getInstance().primaryRiserTen.get(i).getName();
                        if (isSelected) {
                            damageDetailsprimaryRiserTen.put(displayName, isSelected);
                          //  damageDetailsprimaryRiserTen.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimaryRiserTen;
    }

    public JSONObject readsecondaryRiseOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseOne != null && PoleData.getInstance().secondaryRiseOne.size() > 0) {
            try {
                if (damageDetailssecondaryRiserOne == null)
                    damageDetailssecondaryRiserOne = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().secondaryRiseOne.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseOne.get(i).getPicturePath() != null) {
                        secondaryRiserOnePicturePath = PoleData.getInstance().secondaryRiseOne.get(i).getPicturePath();
//                        secondaryRiserOnePicturePath = secondaryRiserOnePicturePath.substring(secondaryRiserOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseOne.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserOneTestPicturePath = PoleData.getInstance().secondaryRiseOne.get(i).getTestPicturePath();
                        secondaryRiserOneTestPicturePath = secondaryRiserOneTestPicturePath.substring(secondaryRiserOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseOne.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserOne.put(PoleData.getInstance().secondaryRiseOne.get(i).getTestingType(), PoleData.getInstance().secondaryRiseOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserOne.put(PoleData.getInstance().secondaryRiseOne.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseOne.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().secondaryRiseOne.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserOne.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseOne.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseOne.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseOne.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseOne.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseOne.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseOne.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseOne.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserOne.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseOne.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseOne.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseOne.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseOne.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseOne.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserOne.put(displayName, isSelected);
                         //   damageDetailssecondaryRiserOne.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserOne;
    }

    public JSONObject readsecondaryRiseTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseTwo != null && PoleData.getInstance().secondaryRiseTwo.size() > 0) {
            try {
                if (damageDetailssecondaryRiserTwo == null)
                    damageDetailssecondaryRiserTwo = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().secondaryRiseTwo.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getPicturePath() != null) {
                        secondaryRiserTwoPicturePath = PoleData.getInstance().secondaryRiseTwo.get(i).getPicturePath();
//                        secondaryRiserTwoPicturePath = secondaryRiserTwoPicturePath.substring(secondaryRiserTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseTwo.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserTwoTestPicturePath = PoleData.getInstance().secondaryRiseTwo.get(i).getTestPicturePath();
                        secondaryRiserTwoTestPicturePath = secondaryRiserTwoTestPicturePath.substring(secondaryRiserTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserTwo.put(PoleData.getInstance().secondaryRiseTwo.get(i).getTestingType(), PoleData.getInstance().secondaryRiseTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserTwo.put(PoleData.getInstance().secondaryRiseTwo.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseTwo.get(i).getIsTesstingPassResult());
                         /*   if(!PoleData.getInstance().secondaryRiseTwo.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserTwo.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseTwo.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseTwo.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseTwo.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseTwo.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseTwo.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseTwo.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseTwo.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseTwo.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseTwo.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseTwo.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseTwo.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserTwo.put(displayName, isSelected);
                           // damageDetailssecondaryRiserTwo.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserTwo;
    }

    public JSONObject readsecondaryRiseThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseThree != null && PoleData.getInstance().secondaryRiseThree.size() > 0) {
            try {
                if (damageDetailssecondaryRiserThree == null)
                    damageDetailssecondaryRiserThree = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().secondaryRiseThree.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseThree.get(i).getPicturePath() != null) {
                        secondaryRiserThreePicturePath = PoleData.getInstance().secondaryRiseThree.get(i).getPicturePath();
//                        secondaryRiserThreePicturePath = secondaryRiserThreePicturePath.substring(secondaryRiserThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseThree.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserThreeTestPicturePath = PoleData.getInstance().secondaryRiseThree.get(i).getTestPicturePath();
                        secondaryRiserThreeTestPicturePath = secondaryRiserThreeTestPicturePath.substring(secondaryRiserThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseThree.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserThree.put(PoleData.getInstance().secondaryRiseThree.get(i).getTestingType(), PoleData.getInstance().secondaryRiseThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserThree.put(PoleData.getInstance().secondaryRiseThree.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseThree.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().secondaryRiseThree.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserThree.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseThree.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseThree.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseThree.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseThree.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseThree.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseThree.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseThree.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserThree.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseThree.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseThree.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseThree.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseThree.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseThree.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserThree.put(displayName, isSelected);
                          //  damageDetailssecondaryRiserThree.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserThree;
    }

    public JSONObject readsecondaryRiseFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseFour != null && PoleData.getInstance().secondaryRiseFour.size() > 0) {
            try {
                if (damageDetailssecondaryRiserFour == null)
                    damageDetailssecondaryRiserFour = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().secondaryRiseFour.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseFour.get(i).getPicturePath() != null) {
                        secondaryRiserFourPicturePath = PoleData.getInstance().secondaryRiseFour.get(i).getPicturePath();
//                        secondaryRiserFourPicturePath = secondaryRiserFourPicturePath.substring(secondaryRiserFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseFour.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserFourTestPicturePath = PoleData.getInstance().secondaryRiseFour.get(i).getTestPicturePath();
                        secondaryRiserFourTestPicturePath = secondaryRiserFourTestPicturePath.substring(secondaryRiserFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseFour.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserFour.put(PoleData.getInstance().secondaryRiseFour.get(i).getTestingType(), PoleData.getInstance().secondaryRiseFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserFour.put(PoleData.getInstance().secondaryRiseFour.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseFour.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().secondaryRiseFour.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserFour.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseFour.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseFour.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseFour.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseFour.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseFour.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseFour.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseFour.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseFour.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseFour.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseFour.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseFour.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseFour.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserFour.put(displayName, isSelected);
                          //  damageDetailssecondaryRiserFour.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserFour;
    }

    public JSONObject readsecondaryRiseFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseFive != null && PoleData.getInstance().secondaryRiseFive.size() > 0) {
            try {
                if (damageDetailssecondaryRiserFive == null)
                    damageDetailssecondaryRiserFive = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().secondaryRiseFive.size(); i++) {
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getPicturePath() != null) {
                        secondaryRiserFivePicturePath = PoleData.getInstance().secondaryRiseFive.get(i).getPicturePath();
//                        secondaryRiserFivePicturePath = secondaryRiserFivePicturePath.substring(secondaryRiserFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseFive.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserFiveTestPicturePath = PoleData.getInstance().secondaryRiseFive.get(i).getTestPicturePath();
                        secondaryRiserFiveTestPicturePath = secondaryRiserFiveTestPicturePath.substring(secondaryRiserFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseFive.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserFive.put(PoleData.getInstance().secondaryRiseFive.get(i).getTestingType(), PoleData.getInstance().secondaryRiseFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserFive.put(PoleData.getInstance().secondaryRiseFive.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseFive.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().secondaryRiseFive.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserFive.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseFive.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseFive.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseFive.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseFive.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseFive.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseFive.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseFive.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserFive.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseFive.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseFive.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseFive.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseFive.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseFive.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserFive.put(displayName, isSelected);
                          //  damageDetailssecondaryRiserFive.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserFive;
    }

    public JSONObject readsecondaryRiseSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseSix != null && PoleData.getInstance().secondaryRiseSix.size() > 0) {
            try {
                if (damageDetailssecondaryRiserSix == null)
                    damageDetailssecondaryRiserSix = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().secondaryRiseSix.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseSix.get(i).getPicturePath() != null) {
                        secondaryRiserSixPicturePath = PoleData.getInstance().secondaryRiseSix.get(i).getPicturePath();
//                        secondaryRiserSixPicturePath = secondaryRiserSixPicturePath.substring(secondaryRiserSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseSix.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserSixTestPicturePath = PoleData.getInstance().secondaryRiseSix.get(i).getTestPicturePath();
                        secondaryRiserSixTestPicturePath = secondaryRiserSixTestPicturePath.substring(secondaryRiserSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseSix.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserSix.put(PoleData.getInstance().secondaryRiseSix.get(i).getTestingType(), PoleData.getInstance().secondaryRiseSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserSix.put(PoleData.getInstance().secondaryRiseSix.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseSix.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().secondaryRiseSix.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserSix.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseSix.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseSix.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseSix.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseSix.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseSix.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseSix.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseSix.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserSix.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseSix.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseSix.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseSix.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseSix.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseSix.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserSix.put(displayName, isSelected);
                          //  damageDetailssecondaryRiserSix.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserSix;
    }

    public JSONObject readsecondaryRiseSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseSeven != null && PoleData.getInstance().secondaryRiseSeven.size() > 0) {
            try {
                if (damageDetailssecondaryRiserSeven == null)
                    damageDetailssecondaryRiserSeven = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().secondaryRiseSeven.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getPicturePath() != null) {
                        secondaryRiserSevenPicturePath = PoleData.getInstance().secondaryRiseSeven.get(i).getPicturePath();
//                        secondaryRiserSevenPicturePath = secondaryRiserSevenPicturePath.substring(secondaryRiserSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseSeven.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserSevenTestPicturePath = PoleData.getInstance().secondaryRiseSeven.get(i).getTestPicturePath();
                        secondaryRiserSevenTestPicturePath = secondaryRiserSevenTestPicturePath.substring(secondaryRiserSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserSeven.put(PoleData.getInstance().secondaryRiseSeven.get(i).getTestingType(), PoleData.getInstance().secondaryRiseSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserSeven.put(PoleData.getInstance().secondaryRiseSeven.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseSeven.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().secondaryRiseSeven.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserSeven.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseSeven.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseSeven.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseSeven.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseSeven.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseSeven.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseSeven.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseSeven.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserSeven.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseSeven.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseSeven.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseSeven.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseSeven.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseSeven.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserSeven.put(displayName, isSelected);
                           // damageDetailssecondaryRiserSeven.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserSeven;
    }

    public JSONObject readsecondaryRiseEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseEight != null && PoleData.getInstance().secondaryRiseEight.size() > 0) {
            try {
                if (damageDetailssecondaryRiserEight == null)
                    damageDetailssecondaryRiserEight = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().secondaryRiseEight.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseEight.get(i).getPicturePath() != null) {
                        secondaryRiserEightPicturePath = PoleData.getInstance().secondaryRiseEight.get(i).getPicturePath();
//                        secondaryRiserEightPicturePath = secondaryRiserEightPicturePath.substring(secondaryRiserEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseEight.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserEightTestPicturePath = PoleData.getInstance().secondaryRiseEight.get(i).getTestPicturePath();
                        secondaryRiserEightTestPicturePath = secondaryRiserEightTestPicturePath.substring(secondaryRiserEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseEight.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserEight.put(PoleData.getInstance().secondaryRiseEight.get(i).getTestingType(), PoleData.getInstance().secondaryRiseEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserEight.put(PoleData.getInstance().secondaryRiseEight.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseEight.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().secondaryRiseEight.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserEight.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseEight.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseEight.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseEight.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseEight.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseEight.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseEight.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseEight.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserEight.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseEight.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseEight.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseEight.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseEight.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseEight.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserEight.put(displayName, isSelected);
                           // damageDetailssecondaryRiserEight.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserEight;
    }

    public JSONObject readsecondaryRiseNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseNine != null && PoleData.getInstance().secondaryRiseNine.size() > 0) {
            try {
                if (damageDetailssecondaryRiserNine == null)
                    damageDetailssecondaryRiserNine = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().secondaryRiseNine.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseNine.get(i).getPicturePath() != null) {
                        secondaryRiserNinePicturePath = PoleData.getInstance().secondaryRiseNine.get(i).getPicturePath();
//                        secondaryRiserNinePicturePath = secondaryRiserNinePicturePath.substring(secondaryRiserNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseNine.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserNineTestPicturePath = PoleData.getInstance().secondaryRiseNine.get(i).getTestPicturePath();
                        secondaryRiserNineTestPicturePath = secondaryRiserNineTestPicturePath.substring(secondaryRiserNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseNine.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserNine.put(PoleData.getInstance().secondaryRiseNine.get(i).getTestingType(), PoleData.getInstance().secondaryRiseNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserNine.put(PoleData.getInstance().secondaryRiseNine.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseNine.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().secondaryRiseNine.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserNine.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseNine.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseNine.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseNine.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseNine.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseNine.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseNine.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseNine.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserNine.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseNine.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseNine.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseNine.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseNine.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseNine.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserNine.put(displayName, isSelected);
                          //  damageDetailssecondaryRiserNine.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserNine;
    }

    public JSONObject readsecondaryRiseTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().secondaryRiseTen != null && PoleData.getInstance().secondaryRiseTen.size() > 0) {
            try {
                if (damageDetailssecondaryRiserTen == null)
                    damageDetailssecondaryRiserTen = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().secondaryRiseTen.size(); i++) {

                    if (PoleData.getInstance().secondaryRiseTen.get(i).getPicturePath() != null) {
                        secondaryRiserTenPicturePath = PoleData.getInstance().secondaryRiseTen.get(i).getPicturePath();
//                        secondaryRiserTenPicturePath = secondaryRiserTenPicturePath.substring(secondaryRiserTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getTestPicturePath() != null && PoleData.getInstance().secondaryRiseTen.get(i).getTestType() != null && PoleData.getInstance().secondaryRiseTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        secondaryRiserTenTestPicturePath = PoleData.getInstance().secondaryRiseTen.get(i).getTestPicturePath();
                        secondaryRiserTenTestPicturePath = secondaryRiserTenTestPicturePath.substring(secondaryRiserTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().secondaryRiseTen.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondaryRiserTen.put(PoleData.getInstance().secondaryRiseTen.get(i).getTestingType(), PoleData.getInstance().secondaryRiseTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().secondaryRiseTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondaryRiserTen.put(PoleData.getInstance().secondaryRiseTen.get(i).getTestingTypePass(), PoleData.getInstance().secondaryRiseTen.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().secondaryRiseTen.get(i).getIsTesstingPassResult())
                            {
                                damageDetailssecondaryRiserTen.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseTen.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().secondaryRiseTen.get(i).getKvaSize();
                        if (PoleData.getInstance().secondaryRiseTen.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseTen.get(i).getSubTitle();
                        addNote = PoleData.getInstance().secondaryRiseTen.get(i).getNote();
                        if (PoleData.getInstance().secondaryRiseTen.get(i).getSubTitle() != null) {
                            damageDetailssecondaryRiserTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().secondaryRiseTen.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().secondaryRiseTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondaryRiserTen.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getTitle() != null)
                        secondaryRiseTitle = PoleData.getInstance().secondaryRiseTen.get(i).getTitle();
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().secondaryRiseTen.get(i).getDisplayName());
                    if (PoleData.getInstance().secondaryRiseTen.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().secondaryRiseTen.get(i).getIsSelected();
                        displayName = PoleData.getInstance().secondaryRiseTen.get(i).getName();
                        if (isSelected) {
                            damageDetailssecondaryRiserTen.put(displayName, isSelected);
                          //  damageDetailssecondaryRiserTen.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondaryRiserTen;
    }

    public JSONObject readpoleGroundOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundOne != null && PoleData.getInstance().poleGroundOne.size() > 0) {
            try {
                if (damageDetailspoleGroundOne == null)
                    damageDetailspoleGroundOne = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundOne.size(); i++) {

                    if (PoleData.getInstance().poleGroundOne.get(i).getPicturePath() != null) {
                        poleGroundOnePicturePath = PoleData.getInstance().poleGroundOne.get(i).getPicturePath();
//                        poleGroundOnePicturePath = poleGroundOnePicturePath.substring(poleGroundOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundOne.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundOne.get(i).getTestType() != null && PoleData.getInstance().poleGroundOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundOneTestPicturePath = PoleData.getInstance().poleGroundOne.get(i).getTestPicturePath();
                        poleGroundOneTestPicturePath = poleGroundOneTestPicturePath.substring(poleGroundOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundOne.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundOne.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundOne.put(PoleData.getInstance().poleGroundOne.get(i).getTestingType(), PoleData.getInstance().poleGroundOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundOne.put(PoleData.getInstance().poleGroundOne.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundOne.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().poleGroundOne.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundOne.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundOne.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundOne.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundOne.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundOne.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundOne.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundOne.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundOne.get(i).getNote();
                        if (PoleData.getInstance().poleGroundOne.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundOne.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundOne.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundOne.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundOne.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundOne.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundOne.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundOne.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundOne.get(i).getName();
                        if (isSelected) {
                            damageDetailspoleGroundOne.put(displayName, isSelected);
                           // damageDetailspoleGroundOne.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundOne;
    }

    public JSONObject readpoleGroundTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundTwo != null && PoleData.getInstance().poleGroundTwo.size() > 0) {
            try {
                if (damageDetailspoleGroundTwo == null)
                    damageDetailspoleGroundTwo = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleGroundTwo.size(); i++) {

                    if (PoleData.getInstance().poleGroundTwo.get(i).getPicturePath() != null) {
                        poleGroundTwoPicturePath = PoleData.getInstance().poleGroundTwo.get(i).getPicturePath();
//                        poleGroundTwoPicturePath = poleGroundTwoPicturePath.substring(poleGroundTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundTwo.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundTwo.get(i).getTestType() != null && PoleData.getInstance().poleGroundTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundTwoTestPicturePath = PoleData.getInstance().poleGroundTwo.get(i).getTestPicturePath();
                        poleGroundTwoTestPicturePath = poleGroundTwoTestPicturePath.substring(poleGroundTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundTwo.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundTwo.put(PoleData.getInstance().poleGroundTwo.get(i).getTestingType(), PoleData.getInstance().poleGroundTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundTwo.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundTwo.put(PoleData.getInstance().poleGroundTwo.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundTwo.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().poleGroundTwo.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundTwo.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundTwo.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundTwo.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundTwo.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundTwo.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundTwo.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundTwo.get(i).getNote();
                        if (PoleData.getInstance().poleGroundTwo.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundTwo.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundTwo.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundTwo.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundTwo.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundTwo.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundTwo.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundTwo.put(displayName, isSelected);
                           // damageDetailspoleGroundTwo.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundTwo;
    }

    public JSONObject readpoleGroundThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundThree != null && PoleData.getInstance().poleGroundThree.size() > 0) {
            try {
                if (damageDetailspoleGroundThree == null)
                    damageDetailspoleGroundThree = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundThree.size(); i++) {

                    if (PoleData.getInstance().poleGroundThree.get(i).getPicturePath() != null) {
                        poleGroundThreePicturePath = PoleData.getInstance().poleGroundThree.get(i).getPicturePath();
//                        poleGroundThreePicturePath = poleGroundThreePicturePath.substring(poleGroundThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundThree.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundThree.get(i).getTestType() != null && PoleData.getInstance().poleGroundThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundThreeTestPicturePath = PoleData.getInstance().poleGroundThree.get(i).getTestPicturePath();
                        poleGroundThreeTestPicturePath = poleGroundThreeTestPicturePath.substring(poleGroundThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundThree.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundThree.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundThree.put(PoleData.getInstance().poleGroundThree.get(i).getTestingType(), PoleData.getInstance().poleGroundThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundThree.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundThree.put(PoleData.getInstance().poleGroundThree.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundThree.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().poleGroundThree.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundThree.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundThree.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundThree.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundThree.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundThree.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundThree.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundThree.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundThree.get(i).getNote();
                        if (PoleData.getInstance().poleGroundThree.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundThree.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundThree.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundThree.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundThree.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundThree.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundThree.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundThree.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundThree.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundThree.put(displayName, isSelected);
                           // damageDetailspoleGroundThree.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundThree;
    }

    public JSONObject readpoleGroundFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundFour != null && PoleData.getInstance().poleGroundFour.size() > 0) {
            try {
                if (damageDetailspoleGroundFour == null)
                    damageDetailspoleGroundFour = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().poleGroundFour.size(); i++) {

                    if (PoleData.getInstance().poleGroundFour.get(i).getPicturePath() != null) {
                        poleGroundFourPicturePath = PoleData.getInstance().poleGroundFour.get(i).getPicturePath();
//                        poleGroundFourPicturePath = poleGroundFourPicturePath.substring(poleGroundFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundFour.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundFour.get(i).getTestType() != null && PoleData.getInstance().poleGroundFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundFourTestPicturePath = PoleData.getInstance().poleGroundFour.get(i).getTestPicturePath();
                        poleGroundFourTestPicturePath = poleGroundFourTestPicturePath.substring(poleGroundFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundFour.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundFour.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundFour.put(PoleData.getInstance().poleGroundFour.get(i).getTestingType(), PoleData.getInstance().poleGroundFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundFour.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundFour.put(PoleData.getInstance().poleGroundFour.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundFour.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().poleGroundFour.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundFour.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundFour.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundFour.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundFour.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundFour.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundFour.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundFour.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundFour.get(i).getNote();
                        if (PoleData.getInstance().poleGroundFour.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundFour.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundFour.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundFour.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundFour.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundFour.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundFour.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundFour.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundFour.put(displayName, isSelected);
                          //  damageDetailspoleGroundFour.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundFour;
    }

    public JSONObject readpoleGroundFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundFive != null && PoleData.getInstance().poleGroundFive.size() > 0) {
            try {
                if (damageDetailspoleGroundFive == null)
                    damageDetailspoleGroundFive = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundFive.size(); i++) {
                    if (PoleData.getInstance().poleGroundFive.get(i).getPicturePath() != null) {
                        poleGroundFivePicturePath = PoleData.getInstance().poleGroundFive.get(i).getPicturePath();
//                        poleGroundFivePicturePath = poleGroundFivePicturePath.substring(poleGroundFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundFive.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundFive.get(i).getTestType() != null && PoleData.getInstance().poleGroundFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundFiveTestPicturePath = PoleData.getInstance().poleGroundFive.get(i).getTestPicturePath();
                        poleGroundFiveTestPicturePath = poleGroundFiveTestPicturePath.substring(poleGroundFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundFive.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundFive.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundFive.put(PoleData.getInstance().poleGroundFive.get(i).getTestingType(), PoleData.getInstance().poleGroundFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundFive.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundFive.put(PoleData.getInstance().poleGroundFive.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundFive.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().poleGroundFive.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundFive.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundFive.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundFive.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundFive.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundFive.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundFive.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundFive.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundFive.get(i).getNote();
                        if (PoleData.getInstance().poleGroundFive.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundFive.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundFive.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundFive.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundFive.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundFive.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundFive.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundFive.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundFive.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundFive.put(displayName, isSelected);
                         //   damageDetailspoleGroundFive.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundFive;
    }

    public JSONObject readpoleGroundSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundSix != null && PoleData.getInstance().poleGroundSix.size() > 0) {
            try {
                if (damageDetailspoleGroundSix == null)
                    damageDetailspoleGroundSix = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundSix.size(); i++) {
                    if (PoleData.getInstance().poleGroundSix.get(i).getPicturePath() != null) {
                        poleGroundSixPicturePath = PoleData.getInstance().poleGroundSix.get(i).getPicturePath();
//                        poleGroundSixPicturePath = poleGroundSixPicturePath.substring(poleGroundSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundSix.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundSix.get(i).getTestType() != null && PoleData.getInstance().poleGroundSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundSixTestPicturePath = PoleData.getInstance().poleGroundSix.get(i).getTestPicturePath();
                        poleGroundSixTestPicturePath = poleGroundSixTestPicturePath.substring(poleGroundSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundSix.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundSix.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundSix.put(PoleData.getInstance().poleGroundSix.get(i).getTestingType(), PoleData.getInstance().poleGroundSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundSix.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundSix.put(PoleData.getInstance().poleGroundSix.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundSix.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().poleGroundSix.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundSix.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundSix.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundSix.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundSix.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundSix.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundSix.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundSix.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundSix.get(i).getNote();
                        if (PoleData.getInstance().poleGroundSix.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundSix.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundSix.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundSix.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundSix.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundSix.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundSix.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundSix.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundSix.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundSix.put(displayName, isSelected);
                           // damageDetailspoleGroundSix.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundSix;
    }

    public JSONObject readpoleGroundSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundSeven != null && PoleData.getInstance().poleGroundSeven.size() > 0) {
            try {
                if (damageDetailspoleGroundSeven == null)
                    damageDetailspoleGroundSeven = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundSeven.size(); i++) {
                    if (PoleData.getInstance().poleGroundSeven.get(i).getPicturePath() != null) {
                        poleGroundSevenPicturePath = PoleData.getInstance().poleGroundSeven.get(i).getPicturePath();
//                        poleGroundSevenPicturePath = poleGroundSevenPicturePath.substring(poleGroundSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundSeven.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundSeven.get(i).getTestType() != null && PoleData.getInstance().poleGroundSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundSevenTestPicturePath = PoleData.getInstance().poleGroundSeven.get(i).getTestPicturePath();
                        poleGroundSevenTestPicturePath = poleGroundSevenTestPicturePath.substring(poleGroundSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundSeven.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundSeven.put(PoleData.getInstance().poleGroundSeven.get(i).getTestingType(), PoleData.getInstance().poleGroundSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundSeven.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundSeven.put(PoleData.getInstance().poleGroundSeven.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundSeven.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().poleGroundSeven.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundSeven.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundSeven.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundSeven.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundSeven.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundSeven.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundSeven.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundSeven.get(i).getNote();
                        if (PoleData.getInstance().poleGroundSeven.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundSeven.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundSeven.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundSeven.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundSeven.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundSeven.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundSeven.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundSeven.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundSeven.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundSeven.put(displayName, isSelected);
                            //damageDetailspoleGroundSeven.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundSeven;
    }

    public JSONObject readpoleGroundEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundEight != null && PoleData.getInstance().poleGroundEight.size() > 0) {
            try {
                if (damageDetailspoleGroundEight == null)
                    damageDetailspoleGroundEight = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundEight.size(); i++) {

                    if (PoleData.getInstance().poleGroundEight.get(i).getPicturePath() != null) {
                        poleGroundEightPicturePath = PoleData.getInstance().poleGroundEight.get(i).getPicturePath();
//                        poleGroundEightPicturePath = poleGroundEightPicturePath.substring(poleGroundEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundEight.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundEight.get(i).getTestType() != null && PoleData.getInstance().poleGroundEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundEightTestPicturePath = PoleData.getInstance().poleGroundEight.get(i).getTestPicturePath();
                        poleGroundEightTestPicturePath = poleGroundEightTestPicturePath.substring(poleGroundEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundEight.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundEight.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundEight.put(PoleData.getInstance().poleGroundEight.get(i).getTestingType(), PoleData.getInstance().poleGroundEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundEight.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundEight.put(PoleData.getInstance().poleGroundEight.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundEight.get(i).getIsTesstingPassResult());
                          /*  if(!PoleData.getInstance().poleGroundEight.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundEight.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundEight.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundEight.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundEight.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundEight.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundEight.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundEight.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundEight.get(i).getNote();
                        if (PoleData.getInstance().poleGroundEight.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundEight.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundEight.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundEight.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundEight.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundEight.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundEight.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundEight.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundEight.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundEight.put(displayName, isSelected);
                           // damageDetailspoleGroundEight.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundEight;
    }

    public JSONObject readpoleGroundNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundNine != null && PoleData.getInstance().poleGroundNine.size() > 0) {
            try {
                if (damageDetailspoleGroundNine == null)
                    damageDetailspoleGroundNine = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundNine.size(); i++) {

                    if (PoleData.getInstance().poleGroundNine.get(i).getPicturePath() != null) {
                        poleGroundNinePicturePath = PoleData.getInstance().poleGroundNine.get(i).getPicturePath();
//                        poleGroundNinePicturePath = poleGroundNinePicturePath.substring(poleGroundNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundNine.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundNine.get(i).getTestType() != null && PoleData.getInstance().poleGroundNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundNineTestPicturePath = PoleData.getInstance().poleGroundNine.get(i).getTestPicturePath();
                        poleGroundNineTestPicturePath = poleGroundNineTestPicturePath.substring(poleGroundNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundNine.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundNine.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundNine.put(PoleData.getInstance().poleGroundNine.get(i).getTestingType(), PoleData.getInstance().poleGroundNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundNine.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundNine.put(PoleData.getInstance().poleGroundNine.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundNine.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().poleGroundNine.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundNine.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundNine.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundNine.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundNine.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundNine.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundNine.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundNine.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundNine.get(i).getNote();
                        if (PoleData.getInstance().poleGroundNine.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundNine.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundNine.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundNine.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundNine.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundNine.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundNine.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundNine.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundNine.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundNine.put(displayName, isSelected);
                          //  damageDetailspoleGroundNine.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundNine;
    }

    public JSONObject readpoleGroundTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().poleGroundTen != null && PoleData.getInstance().poleGroundTen.size() > 0) {
            try {
                if (damageDetailspoleGroundTen == null)
                    damageDetailspoleGroundTen = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().poleGroundTen.size(); i++) {
                    if (PoleData.getInstance().poleGroundTen.get(i).getPicturePath() != null) {
                        poleGroundTenPicturePath = PoleData.getInstance().poleGroundTen.get(i).getPicturePath();
//                        poleGroundTenPicturePath = poleGroundTenPicturePath.substring(poleGroundTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundTen.get(i).getTestPicturePath() != null && PoleData.getInstance().poleGroundTen.get(i).getTestType() != null && PoleData.getInstance().poleGroundTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        poleGroundTenTestPicturePath = PoleData.getInstance().poleGroundTen.get(i).getTestPicturePath();
                        poleGroundTenTestPicturePath = poleGroundTenTestPicturePath.substring(poleGroundTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().poleGroundTen.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().poleGroundTen.get(i).getIsTesttingResult() != null) {
                            damageDetailspoleGroundTen.put(PoleData.getInstance().poleGroundTen.get(i).getTestingType(), PoleData.getInstance().poleGroundTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().poleGroundTen.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().poleGroundTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspoleGroundTen.put(PoleData.getInstance().poleGroundTen.get(i).getTestingTypePass(), PoleData.getInstance().poleGroundTen.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().poleGroundTen.get(i).getIsTesstingPassResult())
                            {
                                damageDetailspoleGroundTen.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().poleGroundTen.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().poleGroundTen.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().poleGroundTen.get(i).getKvaSize();
                        if (PoleData.getInstance().poleGroundTen.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().poleGroundTen.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().poleGroundTen.get(i).getSubTitle();
                        addNote = PoleData.getInstance().poleGroundTen.get(i).getNote();
                        if (PoleData.getInstance().poleGroundTen.get(i).getSubTitle() != null) {
                            damageDetailspoleGroundTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().poleGroundTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().poleGroundTen.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().poleGroundTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspoleGroundTen.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().poleGroundTen.get(i).getTitle() != null)
                        poleGroundTitle = PoleData.getInstance().poleGroundTen.get(i).getTitle();
                    if (PoleData.getInstance().poleGroundTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().poleGroundTen.get(i).getDisplayName());
                    if (PoleData.getInstance().poleGroundTen.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().poleGroundTen.get(i).getIsSelected();
                        displayName = PoleData.getInstance().poleGroundTen.get(i).getName();
                        if (isSelected) {

                            damageDetailspoleGroundTen.put(displayName, isSelected);
                           // damageDetailspoleGroundTen.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspoleGroundTen;
    }

    public JSONObject readvegetationOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationOne != null && PoleData.getInstance().vegetationOne.size() > 0) {
            try {
                if (damageDetailsvegetationOne == null)
                    damageDetailsvegetationOne = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().vegetationOne.size(); i++) {
                    if (PoleData.getInstance().vegetationOne.get(i).getPicturePath() != null) {
                        vegetationOnePicturePath = PoleData.getInstance().vegetationOne.get(i).getPicturePath();
//                        vegetationOnePicturePath = vegetationOnePicturePath.substring(vegetationOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationOne.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationOne.get(i).getTestType() != null && PoleData.getInstance().vegetationOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationOneTestPicturePath = PoleData.getInstance().vegetationOne.get(i).getTestPicturePath();
                        vegetationOneTestPicturePath = vegetationOneTestPicturePath.substring(vegetationOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationOne.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationOne.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationOne.put(PoleData.getInstance().vegetationOne.get(i).getTestingType(), PoleData.getInstance().vegetationOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationOne.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationOne.put(PoleData.getInstance().vegetationOne.get(i).getTestingTypePass(), PoleData.getInstance().vegetationOne.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().vegetationOne.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationOne.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationOne.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationOne.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationOne.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationOne.get(i).getSubTitle() != null) {
                            damageDetailsvegetationOne.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationOne.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationOne.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationOne.get(i).getNote();
                        if (PoleData.getInstance().vegetationOne.get(i).getSubTitle() != null) {
                            damageDetailsvegetationOne.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationOne.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationOne.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationOne.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationOne.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationOne.get(i).getTitle();
                    if (PoleData.getInstance().vegetationOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationOne.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationOne.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationOne.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationOne.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationOne.put(displayName, isSelected);
                           // damageDetailsvegetationOne.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationOne;
    }

    public JSONObject readvegetationTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationTwo != null && PoleData.getInstance().vegetationTwo.size() > 0) {
            try {
                for (int i = 0; i < PoleData.getInstance().vegetationTwo.size(); i++) {
                    if (damageDetailsvegetationTwo == null)
                        damageDetailsvegetationTwo = new JSONObject();

                    if (PoleData.getInstance().vegetationTwo.get(i).getPicturePath() != null) {
                        vegetationTwoPicturePath = PoleData.getInstance().vegetationTwo.get(i).getPicturePath();
//                        vegetationTwoPicturePath = vegetationTwoPicturePath.substring(vegetationTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationTwo.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationTwo.get(i).getTestType() != null && PoleData.getInstance().vegetationTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationTwoTestPicturePath = PoleData.getInstance().vegetationTwo.get(i).getTestPicturePath();
                        vegetationTwoTestPicturePath = vegetationTwoTestPicturePath.substring(vegetationTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationTwo.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationTwo.put(PoleData.getInstance().vegetationTwo.get(i).getTestingType(), PoleData.getInstance().vegetationTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationTwo.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationTwo.put(PoleData.getInstance().vegetationTwo.get(i).getTestingTypePass(), PoleData.getInstance().vegetationTwo.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().vegetationTwo.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationTwo.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationTwo.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationTwo.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationTwo.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationTwo.get(i).getSubTitle() != null) {
                            damageDetailsvegetationTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationTwo.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationTwo.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationTwo.get(i).getNote();
                        if (PoleData.getInstance().vegetationTwo.get(i).getSubTitle() != null) {
                            damageDetailsvegetationTwo.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationTwo.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationTwo.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationTwo.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationTwo.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationTwo.get(i).getTitle();
                    if (PoleData.getInstance().vegetationTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationTwo.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationTwo.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationTwo.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationTwo.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationTwo.put(displayName, isSelected);
                           // damageDetailsvegetationTwo.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationTwo;
    }

    public JSONObject readvegetationThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationThree != null && PoleData.getInstance().vegetationThree.size() > 0) {
            try {
                if (damageDetailsvegetationThree == null)
                    damageDetailsvegetationThree = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().vegetationThree.size(); i++) {

                    if (PoleData.getInstance().vegetationThree.get(i).getPicturePath() != null) {
                        vegetationThreePicturePath = PoleData.getInstance().vegetationThree.get(i).getPicturePath();
//                        vegetationThreePicturePath = vegetationThreePicturePath.substring(vegetationThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationThree.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationThree.get(i).getTestType() != null && PoleData.getInstance().vegetationThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationThreeTestPicturePath = PoleData.getInstance().vegetationThree.get(i).getTestPicturePath();
                        vegetationThreeTestPicturePath = vegetationThreeTestPicturePath.substring(vegetationThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationThree.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationThree.put(PoleData.getInstance().vegetationThree.get(i).getTestingType(), PoleData.getInstance().vegetationThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationThree.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationThree.put(PoleData.getInstance().vegetationThree.get(i).getTestingTypePass(), PoleData.getInstance().vegetationThree.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().vegetationThree.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationThree.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationThree.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationThree.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationThree.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationThree.get(i).getSubTitle() != null) {
                            damageDetailsvegetationThree.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationThree.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationThree.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationThree.get(i).getNote();
                        if (PoleData.getInstance().vegetationThree.get(i).getSubTitle() != null) {
                            damageDetailsvegetationThree.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationThree.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationThree.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationThree.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationThree.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationThree.get(i).getTitle();
                    if (PoleData.getInstance().vegetationThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationThree.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationThree.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationThree.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationThree.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationThree.put(displayName, isSelected);
                           // damageDetailsvegetationThree.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationThree;
    }

    public JSONObject readvegetationFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationFour != null && PoleData.getInstance().vegetationFour.size() > 0) {
            try {
                if (damageDetailsvegetationFour == null)
                    damageDetailsvegetationFour = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().vegetationFour.size(); i++) {

                    if (PoleData.getInstance().vegetationFour.get(i).getPicturePath() != null) {
                        vegetationFourPicturePath = PoleData.getInstance().vegetationFour.get(i).getPicturePath();
//                        vegetationFourPicturePath = vegetationFourPicturePath.substring(vegetationFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationFour.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationFour.get(i).getTestType() != null && PoleData.getInstance().vegetationFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationFourTestPicturePath = PoleData.getInstance().vegetationFour.get(i).getTestPicturePath();
                        vegetationFourTestPicturePath = vegetationFourTestPicturePath.substring(vegetationFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationFour.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationFour.put(PoleData.getInstance().vegetationFour.get(i).getTestingType(), PoleData.getInstance().vegetationFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationFour.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationFour.put(PoleData.getInstance().vegetationFour.get(i).getTestingTypePass(), PoleData.getInstance().vegetationFour.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().vegetationFour.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationFour.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationFour.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationFour.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationFour.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationFour.get(i).getSubTitle() != null) {
                            damageDetailsvegetationFour.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationFour.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationFour.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationFour.get(i).getNote();
                        if (PoleData.getInstance().vegetationFour.get(i).getSubTitle() != null) {
                            damageDetailsvegetationFour.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationFour.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationFour.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationFour.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationFour.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationFour.get(i).getTitle();
                    if (PoleData.getInstance().vegetationFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationFour.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationFour.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationFour.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationFour.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationFour.put(displayName, isSelected);
                           // damageDetailsvegetationFour.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationFour;
    }

    public JSONObject readvegetationFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationFive != null && PoleData.getInstance().vegetationFive.size() > 0) {
            try {
                if (damageDetailsvegetationFive == null)
                    damageDetailsvegetationFive = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().vegetationFive.size(); i++) {

                    if (PoleData.getInstance().vegetationFive.get(i).getPicturePath() != null) {
                        vegetationFivePicturePath = PoleData.getInstance().vegetationFive.get(i).getPicturePath();
//                        vegetationFivePicturePath = vegetationFivePicturePath.substring(vegetationFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationFive.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationFive.get(i).getTestType() != null && PoleData.getInstance().vegetationFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationFiveTestPicturePath = PoleData.getInstance().vegetationFive.get(i).getTestPicturePath();
                        vegetationFiveTestPicturePath = vegetationFiveTestPicturePath.substring(vegetationFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationFive.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationFive.put(PoleData.getInstance().vegetationFive.get(i).getTestingType(), PoleData.getInstance().vegetationFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationFive.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationFive.put(PoleData.getInstance().vegetationFive.get(i).getTestingTypePass(), PoleData.getInstance().vegetationFive.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().vegetationFive.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationFive.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationFive.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationFive.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationFive.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationFive.get(i).getSubTitle() != null) {
                            damageDetailsvegetationFive.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationFive.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationFive.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationFive.get(i).getNote();
                        if (PoleData.getInstance().vegetationFive.get(i).getSubTitle() != null) {
                            damageDetailsvegetationFive.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationFive.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationFive.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationFive.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationFive.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationFive.get(i).getTitle();
                    if (PoleData.getInstance().vegetationFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationFive.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationFive.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationFive.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationFive.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationFive.put(displayName, isSelected);
                           // damageDetailsvegetationFive.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationFive;
    }

    public JSONObject readvegetationSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationSix != null && PoleData.getInstance().vegetationSix.size() > 0) {
            try {
                if (damageDetailsvegetationSix == null)
                    damageDetailsvegetationSix = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().vegetationSix.size(); i++) {

                    if (PoleData.getInstance().vegetationSix.get(i).getPicturePath() != null) {
                        vegetationSixPicturePath = PoleData.getInstance().vegetationSix.get(i).getPicturePath();
//                        vegetationSixPicturePath = vegetationSixPicturePath.substring(vegetationSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationSix.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationSix.get(i).getTestType() != null && PoleData.getInstance().vegetationSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationSixTestPicturePath = PoleData.getInstance().vegetationSix.get(i).getTestPicturePath();
                        vegetationSixTestPicturePath = vegetationSixTestPicturePath.substring(vegetationSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationSix.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationSix.put(PoleData.getInstance().vegetationSix.get(i).getTestingType(), PoleData.getInstance().vegetationSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationSix.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationSix.put(PoleData.getInstance().vegetationSix.get(i).getTestingTypePass(), PoleData.getInstance().vegetationSix.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().vegetationSix.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationSix.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationSix.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationSix.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationSix.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationSix.get(i).getSubTitle() != null) {
                            damageDetailsvegetationSix.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationSix.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationSix.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationSix.get(i).getNote();
                        if (PoleData.getInstance().vegetationSix.get(i).getSubTitle() != null) {
                            damageDetailsvegetationSix.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationSix.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationSix.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationSix.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationSix.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationSix.get(i).getTitle();
                    if (PoleData.getInstance().vegetationSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationSix.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationSix.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationSix.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationSix.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationSix.put(displayName, isSelected);
                           // damageDetailsvegetationSix.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationSix;
    }

    public JSONObject readvegetationSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationSeven != null && PoleData.getInstance().vegetationSeven.size() > 0) {
            try {
                if (damageDetailsvegetationSeven == null)
                    damageDetailsvegetationSeven = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().vegetationSeven.size(); i++) {
                    if (PoleData.getInstance().vegetationSeven.get(i).getPicturePath() != null) {
                        vegetationSevenPicturePath = PoleData.getInstance().vegetationSeven.get(i).getPicturePath();
//                        vegetationSevenPicturePath = vegetationSevenPicturePath.substring(vegetationSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationSeven.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationSeven.get(i).getTestType() != null && PoleData.getInstance().vegetationSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationSevenTestPicturePath = PoleData.getInstance().vegetationSeven.get(i).getTestPicturePath();
                        vegetationSevenTestPicturePath = vegetationSevenTestPicturePath.substring(vegetationSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationSeven.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationSeven.put(PoleData.getInstance().vegetationSeven.get(i).getTestingType(), PoleData.getInstance().vegetationSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationSeven.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationSeven.put(PoleData.getInstance().vegetationSeven.get(i).getTestingTypePass(), PoleData.getInstance().vegetationSeven.get(i).getIsTesstingPassResult());
                            /*if(!PoleData.getInstance().vegetationSeven.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationSeven.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationSeven.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationSeven.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationSeven.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationSeven.get(i).getSubTitle() != null) {
                            damageDetailsvegetationSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationSeven.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationSeven.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationSeven.get(i).getNote();
                        if (PoleData.getInstance().vegetationSeven.get(i).getSubTitle() != null) {
                            damageDetailsvegetationSeven.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationSeven.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationSeven.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationSeven.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationSeven.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationSeven.get(i).getTitle();
                    if (PoleData.getInstance().vegetationSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationSeven.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationSeven.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationSeven.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationSeven.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationSeven.put(displayName, isSelected);
                            //damageDetailsvegetationSeven.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationSeven;
    }

    public JSONObject readvegetationEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationEight != null && PoleData.getInstance().vegetationEight.size() > 0) {
            try {
                if (damageDetailsvegetationEight == null)
                    damageDetailsvegetationEight = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().vegetationEight.size(); i++) {


                    if (PoleData.getInstance().vegetationEight.get(i).getPicturePath() != null) {
                        vegetationEightPicturePath = PoleData.getInstance().vegetationEight.get(i).getPicturePath();
//                        vegetationEightPicturePath = vegetationEightPicturePath.substring(vegetationEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationEight.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationEight.get(i).getTestType() != null && PoleData.getInstance().vegetationEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationEightTestPicturePath = PoleData.getInstance().vegetationEight.get(i).getTestPicturePath();
                        vegetationEightTestPicturePath = vegetationEightTestPicturePath.substring(vegetationEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationEight.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationEight.put(PoleData.getInstance().vegetationEight.get(i).getTestingType(), PoleData.getInstance().vegetationEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationEight.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationEight.put(PoleData.getInstance().vegetationEight.get(i).getTestingTypePass(), PoleData.getInstance().vegetationEight.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().vegetationEight.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationEight.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationEight.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationEight.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationEight.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationEight.get(i).getSubTitle() != null) {
                            damageDetailsvegetationEight.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationEight.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationEight.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationEight.get(i).getNote();
                        if (PoleData.getInstance().vegetationEight.get(i).getSubTitle() != null) {
                            damageDetailsvegetationEight.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationEight.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationEight.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationEight.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationEight.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationEight.get(i).getTitle();
                    if (PoleData.getInstance().vegetationEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationEight.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationEight.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationEight.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationEight.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationEight.put(displayName, isSelected);
                          //  damageDetailsvegetationEight.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationEight;
    }

    public JSONObject readvegetationNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationNine != null && PoleData.getInstance().vegetationNine.size() > 0) {
            try {
                if (damageDetailsvegetationNine == null)
                    damageDetailsvegetationNine = new JSONObject();
                for (int i = 0; i < PoleData.getInstance().vegetationNine.size(); i++) {

                    if (PoleData.getInstance().vegetationNine.get(i).getPicturePath() != null) {
                        vegetationNinePicturePath = PoleData.getInstance().vegetationNine.get(i).getPicturePath();
//                        vegetationNinePicturePath = vegetationNinePicturePath.substring(vegetationNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationNine.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationNine.get(i).getTestType() != null && PoleData.getInstance().vegetationNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationNineTestPicturePath = PoleData.getInstance().vegetationNine.get(i).getTestPicturePath();
                        vegetationNineTestPicturePath = vegetationNineTestPicturePath.substring(vegetationNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationNine.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationNine.put(PoleData.getInstance().vegetationNine.get(i).getTestingType(), PoleData.getInstance().vegetationNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationNine.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationNine.put(PoleData.getInstance().vegetationNine.get(i).getTestingTypePass(), PoleData.getInstance().vegetationNine.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().vegetationNine.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationNine.put("isPoleRejected",true);
                            }*/
                        }
                    }
                    if (PoleData.getInstance().vegetationNine.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationNine.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationNine.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationNine.get(i).getSubTitle() != null) {
                            damageDetailsvegetationNine.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationNine.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationNine.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationNine.get(i).getNote();
                        if (PoleData.getInstance().vegetationNine.get(i).getSubTitle() != null) {
                            damageDetailsvegetationNine.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationNine.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationNine.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationNine.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationNine.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationNine.get(i).getTitle();
                    if (PoleData.getInstance().vegetationNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationNine.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationNine.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationNine.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationNine.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationNine.put(displayName, isSelected);
                            //damageDetailsvegetationNine.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationNine;
    }

    public JSONObject readvegetationTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (PoleData.getInstance().vegetationTen != null && PoleData.getInstance().vegetationTen.size() > 0) {
            try {
                if (damageDetailsvegetationTen == null)
                    damageDetailsvegetationTen = new JSONObject();

                for (int i = 0; i < PoleData.getInstance().vegetationTen.size(); i++) {
                    if (PoleData.getInstance().vegetationTen.get(i).getPicturePath() != null) {
                        vegetationTenPicturePath = PoleData.getInstance().vegetationTen.get(i).getPicturePath();
//                        vegetationTenPicturePath = vegetationTenPicturePath.substring(vegetationTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationTen.get(i).getTestPicturePath() != null && PoleData.getInstance().vegetationTen.get(i).getTestType() != null && PoleData.getInstance().vegetationTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")) {
                        vegetationTenTestPicturePath = PoleData.getInstance().vegetationTen.get(i).getTestPicturePath();
                        vegetationTenTestPicturePath = vegetationTenTestPicturePath.substring(vegetationTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (PoleData.getInstance().vegetationTen.get(i).getTestingType() != null) {
                        if (PoleData.getInstance().vegetationTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsvegetationTen.put(PoleData.getInstance().vegetationTen.get(i).getTestingType(), PoleData.getInstance().vegetationTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (PoleData.getInstance().vegetationTen.get(i).getTestingTypePass() != null) {
                        if (PoleData.getInstance().vegetationTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsvegetationTen.put(PoleData.getInstance().vegetationTen.get(i).getTestingTypePass(), PoleData.getInstance().vegetationTen.get(i).getIsTesstingPassResult());
                           /* if(!PoleData.getInstance().vegetationTen.get(i).getIsTesstingPassResult())
                            {
                                damageDetailsvegetationTen.put("isPoleRejected",true);
                            }*/
                       }
                    }
                    if (PoleData.getInstance().vegetationTen.get(i).getKvaSize() != null) {
                        subtitle = PoleData.getInstance().vegetationTen.get(i).getSubTitle();
                        kvaSize = PoleData.getInstance().vegetationTen.get(i).getKvaSize();
                        if (PoleData.getInstance().vegetationTen.get(i).getSubTitle() != null) {
                            damageDetailsvegetationTen.put(subtitle, kvaSize);
                        }
                    }
                    if (PoleData.getInstance().vegetationTen.get(i).getNote() != null) {
                        subtitle = PoleData.getInstance().vegetationTen.get(i).getSubTitle();
                        addNote = PoleData.getInstance().vegetationTen.get(i).getNote();
                        if (PoleData.getInstance().vegetationTen.get(i).getSubTitle() != null) {
                            damageDetailsvegetationTen.put(subtitle, addNote);
                        }
                    }
                    if (PoleData.getInstance().vegetationTen.get(i).getCheckedOK() != null) {
                        subtitle = PoleData.getInstance().vegetationTen.get(i).getSubTitle();
                        isChecked = PoleData.getInstance().vegetationTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsvegetationTen.put(subtitle, isChecked);
                        }
                    }
                    if (PoleData.getInstance().vegetationTen.get(i).getTitle() != null)
                        vegetationTitle = PoleData.getInstance().vegetationTen.get(i).getTitle();
                    if (PoleData.getInstance().vegetationTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + PoleData.getInstance().vegetationTen.get(i).getDisplayName());
                    if (PoleData.getInstance().vegetationTen.get(i).getIsSelected() != null) {
                        isSelected = PoleData.getInstance().vegetationTen.get(i).getIsSelected();
                        displayName = PoleData.getInstance().vegetationTen.get(i).getName();
                        if (isSelected) {

                            damageDetailsvegetationTen.put(displayName, isSelected);
                          //  damageDetailsvegetationTen.put("isPoleRejected", true);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsvegetationTen;
    }

    public void resetAllReference() {
        try {
            clearPictureName();
            PoleData.getInstance().poleOne.clear();
            PoleData.getInstance().poleTwo.clear();
            PoleData.getInstance().poleThree.clear();
            PoleData.getInstance().poleFour.clear();
            PoleData.getInstance().poleFive.clear();
            PoleData.getInstance().poleSix.clear();
            PoleData.getInstance().poleSeven.clear();
            PoleData.getInstance().poleEight.clear();
            PoleData.getInstance().poleNine.clear();
            PoleData.getInstance().poleTen.clear();

            PoleData.getInstance().guyWireOne.clear();
            PoleData.getInstance().guyWireTwo.clear();
            PoleData.getInstance().guyWireThree.clear();
            PoleData.getInstance().guyWireFour.clear();
            PoleData.getInstance().guyWireFive.clear();
            PoleData.getInstance().guyWireSix.clear();
            PoleData.getInstance().guyWireSeven.clear();
            PoleData.getInstance().guyWireEight.clear();
            PoleData.getInstance().guyWireNine.clear();
            PoleData.getInstance().guyWireTen.clear();

            PoleData.getInstance().anchorOne.clear();
            PoleData.getInstance().anchorTwo.clear();
            PoleData.getInstance().anchorThree.clear();
            PoleData.getInstance().anchorFour.clear();
            PoleData.getInstance().anchorFive.clear();
            PoleData.getInstance().anchorSix.clear();
            PoleData.getInstance().anchorSeven.clear();
            PoleData.getInstance().anchorEight.clear();
            PoleData.getInstance().anchorNine.clear();
            PoleData.getInstance().anchorTen.clear();

            PoleData.getInstance().primaryRiserOne.clear();
            PoleData.getInstance().primaryRiserTwo.clear();
            PoleData.getInstance().primaryRiserThree.clear();
            PoleData.getInstance().primaryRiserFour.clear();
            PoleData.getInstance().primaryRiserFive.clear();
            PoleData.getInstance().primaryRiserSix.clear();
            PoleData.getInstance().primaryRiserSeven.clear();
            PoleData.getInstance().primaryRiserEight.clear();
            PoleData.getInstance().primaryRiserNine.clear();
            PoleData.getInstance().primaryRiserTen.clear();

            PoleData.getInstance().secondaryRiseOne.clear();
            PoleData.getInstance().secondaryRiseTwo.clear();
            PoleData.getInstance().secondaryRiseThree.clear();
            PoleData.getInstance().secondaryRiseFour.clear();
            PoleData.getInstance().secondaryRiseFive.clear();
            PoleData.getInstance().secondaryRiseSix.clear();
            PoleData.getInstance().secondaryRiseSeven.clear();
            PoleData.getInstance().secondaryRiseEight.clear();
            PoleData.getInstance().secondaryRiseNine.clear();
            PoleData.getInstance().secondaryRiseTen.clear();

            PoleData.getInstance().poleGroundOne.clear();
            PoleData.getInstance().poleGroundTwo.clear();
            PoleData.getInstance().poleGroundThree.clear();
            PoleData.getInstance().poleGroundFour.clear();
            PoleData.getInstance().poleGroundFive.clear();
            PoleData.getInstance().poleGroundSix.clear();
            PoleData.getInstance().poleGroundSeven.clear();
            PoleData.getInstance().poleGroundEight.clear();
            PoleData.getInstance().poleGroundNine.clear();
            PoleData.getInstance().poleGroundTen.clear();

            PoleData.getInstance().vegetationOne.clear();
            PoleData.getInstance().vegetationTwo.clear();
            PoleData.getInstance().vegetationThree.clear();
            PoleData.getInstance().vegetationFour.clear();
            PoleData.getInstance().vegetationFive.clear();
            PoleData.getInstance().vegetationSix.clear();
            PoleData.getInstance().vegetationSeven.clear();
            PoleData.getInstance().vegetationEight.clear();
            PoleData.getInstance().vegetationNine.clear();
            PoleData.getInstance().vegetationTen.clear();
        } catch (NullPointerException e) {

        }
    }

    private void clearPictureName() {
        poleOnePicturePath = null;
        poleTwoPicturePath = null;
        poleThreePicturePath = null;
        poleFourPicturePath = null;
        poleFivePicturePath = null;
        poleSixPicturePath = null;
        poleSevenPicturePath = null;
        poleEightPicturePath = null;
        poleNinePicturePath = null;
        poleTenPicturePath = null;
        guyWireOnePicturePath = null;
        guyWireTwoPicturePath = null;
        guyWireThreePicturePath = null;
        guyWireFourPicturePath = null;
        guyWireFivePicturePath = null;
        guyWireSixPicturePath = null;
        guyWireSevenPicturePath = null;
        guyWireEightPicturePath = null;
        guyWireNinePicturePath = null;
        guyWireTenPicturePath = null;
        anchorOnePicturePath = null;
        anchorTwoPicturePath = null;
        anchorThreePicturePath = null;
        anchorFourPicturePath = null;
        anchorFivePicturePath = null;
        anchorSixPicturePath = null;
        anchorSevenPicturePath = null;
        anchorEightPicturePath = null;
        anchorNinePicturePath = null;
        anchorTenPicturePath = null;
        primaryRiserOnePicturePath = null;
        primaryRiserTwoPicturePath = null;
        primaryRiserThreePicturePath = null;
        primaryRiserFourPicturePath = null;
        primaryRiserFivePicturePath = null;
        primaryRiserSixPicturePath = null;
        primaryRiserSevenPicturePath = null;
        primaryRiserEightPicturePath = null;
        primaryRiserNinePicturePath = null;
        primaryRiserTenPicturePath = null;

        secondaryRiserOnePicturePath = null;
        secondaryRiserTwoPicturePath = null;
        secondaryRiserThreePicturePath = null;
        secondaryRiserFourPicturePath = null;
        secondaryRiserFivePicturePath = null;
        secondaryRiserSixPicturePath = null;
        secondaryRiserSevenPicturePath = null;
        secondaryRiserEightPicturePath = null;
        secondaryRiserNinePicturePath = null;
        secondaryRiserTenPicturePath = null;
        poleGroundOnePicturePath = null;
        poleGroundTwoPicturePath = null;
        poleGroundThreePicturePath = null;
        poleGroundFourPicturePath = null;
        poleGroundFivePicturePath = null;
        poleGroundSixPicturePath = null;
        poleGroundSevenPicturePath = null;
        poleGroundEightPicturePath = null;
        poleGroundNinePicturePath = null;
        poleGroundTenPicturePath = null;
        vegetationOnePicturePath = null;
        vegetationTwoPicturePath = null;
        vegetationThreePicturePath = null;
        vegetationFourPicturePath = null;
        vegetationFivePicturePath = null;
        vegetationSixPicturePath = null;
        vegetationSevenPicturePath = null;
        vegetationEightPicturePath = null;
        vegetationNinePicturePath = null;
        vegetationTenPicturePath = null;

        poleOneTestPicturePath = null;
        poleTwoTestPicturePath = null;
        poleThreeTestPicturePath = null;
        poleFourTestPicturePath = null;
        poleFiveTestPicturePath = null;
        poleSixTestPicturePath = null;
        poleSevenTestPicturePath = null;
        poleEightTestPicturePath = null;
        poleNineTestPicturePath = null;
        poleTenTestPicturePath = null;
        guyWireOneTestPicturePath = null;
        guyWireTwoTestPicturePath = null;
        guyWireThreeTestPicturePath = null;
        guyWireFourTestPicturePath = null;
        guyWireFiveTestPicturePath = null;
        guyWireSixTestPicturePath = null;
        guyWireSevenTestPicturePath = null;
        guyWireEightTestPicturePath = null;
        guyWireNineTestPicturePath = null;
        guyWireTenTestPicturePath = null;
        anchorOneTestPicturePath = null;
        anchorTwoTestPicturePath = null;
        anchorThreeTestPicturePath = null;
        anchorFourTestPicturePath = null;
        anchorFiveTestPicturePath = null;
        anchorSixTestPicturePath = null;
        anchorSevenTestPicturePath = null;
        anchorEightTestPicturePath = null;
        anchorNineTestPicturePath = null;
        anchorTenTestPicturePath = null;
        primaryRiserOneTestPicturePath = null;
        primaryRiserTwoTestPicturePath = null;
        primaryRiserThreeTestPicturePath = null;
        primaryRiserFourTestPicturePath = null;
        primaryRiserFiveTestPicturePath = null;
        primaryRiserSixTestPicturePath = null;
        primaryRiserSevenTestPicturePath = null;
        primaryRiserEightTestPicturePath = null;
        primaryRiserNineTestPicturePath = null;
        primaryRiserTenTestPicturePath = null;

        secondaryRiserOneTestPicturePath = null;
        secondaryRiserTwoTestPicturePath = null;
        secondaryRiserThreeTestPicturePath = null;
        secondaryRiserFourTestPicturePath = null;
        secondaryRiserFiveTestPicturePath = null;
        secondaryRiserSixTestPicturePath = null;
        secondaryRiserSevenTestPicturePath = null;
        secondaryRiserEightTestPicturePath = null;
        secondaryRiserNineTestPicturePath = null;
        secondaryRiserTenTestPicturePath = null;
        poleGroundOneTestPicturePath = null;
        poleGroundTwoTestPicturePath = null;
        poleGroundThreeTestPicturePath = null;
        poleGroundFourTestPicturePath = null;
        poleGroundFiveTestPicturePath = null;
        poleGroundSixTestPicturePath = null;
        poleGroundSevenTestPicturePath = null;
        poleGroundEightTestPicturePath = null;
        poleGroundNineTestPicturePath = null;
        poleGroundTenTestPicturePath = null;
        vegetationOneTestPicturePath = null;
        vegetationTwoTestPicturePath = null;
        vegetationThreeTestPicturePath = null;
        vegetationFourTestPicturePath = null;
        vegetationFiveTestPicturePath = null;
        vegetationSixTestPicturePath = null;
        vegetationSevenTestPicturePath = null;
        vegetationEightTestPicturePath = null;
        vegetationNineTestPicturePath = null;
        vegetationTenTestPicturePath = null;

        visualOneTestPicturePath = null;
        visualTwoTestPicturePath = null;
        visualThreeTestPicturePath = null;
        visualFourTestPicturePath = null;
        visualFiveTestPicturePath = null;
        visualSixTestPicturePath = null;
        visualSevenTestPicturePath = null;
        visualEightTestPicturePath = null;
        visualNineTestPicturePath = null;
        visualTenTestPicturePath = null;
        soundOneTestPicturePath = null;
        soundTwoTestPicturePath = null;
        soundThreeTestPicturePath = null;
        soundFourTestPicturePath = null;
        soundFiveTestPicturePath = null;
        soundSixTestPicturePath = null;
        soundSevenTestPicturePath = null;
        soundEightTestPicturePath = null;
        soundNineTestPicturePath = null;
        soundTenTestPicturePath = null;
        resistographOneTestPicturePath = null;
        resistographTwoTestPicturePath = null;
        resistographThreeTestPicturePath = null;
        resistographFourTestPicturePath = null;
        resistographFiveTestPicturePath = null;
        resistographSixTestPicturePath = null;
        resistographSevenTestPicturePath = null;
        resistographEightTestPicturePath = null;
        resistographNineTestPicturePath = null;
        resistographTenTestPicturePath = null;
    }

    public void resetAllJSONObject() {
        damageDetailsPoleOne = null;
        damageDetailsPoleTwo = null;
        damageDetailsPoleThree = null;
        damageDetailsPoleFour = null;
        damageDetailsPoleFive = null;
        damageDetailsPoleSix = null;
        damageDetailsPoleSeven = null;
        damageDetailsPoleEight = null;
        damageDetailsPoleNine = null;
        damageDetailsPoleTen = null;

        damageDetailsguyWireOne = null;
        damageDetailsguyWireTwo = null;
        damageDetailsguyWireThree = null;
        damageDetailsguyWireFour = null;
        damageDetailsguyWireFive = null;
        damageDetailsguyWireSix = null;
        damageDetailsguyWireSeven = null;
        damageDetailsguyWireEight = null;
        damageDetailsguyWireNine = null;
        damageDetailsguyWireTen = null;

        damageDetailsanchorOne = null;
        damageDetailsanchorTwo = null;
        damageDetailsanchorThree = null;
        damageDetailsanchorFour = null;
        damageDetailsanchorFive = null;
        damageDetailsanchorSix = null;
        damageDetailsanchorSeven = null;
        damageDetailsanchorEight = null;
        damageDetailsanchorNine = null;
        damageDetailsanchorTen = null;

        damageDetailsprimaryRiserOne = null;
        damageDetailsprimaryRiserTwo = null;
        damageDetailsprimaryRiserThree = null;
        damageDetailsprimaryRiserFour = null;
        damageDetailsprimaryRiserFive = null;
        damageDetailsprimaryRiserSix = null;
        damageDetailsprimaryRiserSeven = null;
        damageDetailsprimaryRiserEight = null;
        damageDetailsprimaryRiserNine = null;
        damageDetailsprimaryRiserTen = null;

        damageDetailssecondaryRiserOne = null;
        damageDetailssecondaryRiserTwo = null;
        damageDetailssecondaryRiserThree = null;
        damageDetailssecondaryRiserFour = null;
        damageDetailssecondaryRiserFive = null;
        damageDetailssecondaryRiserSix = null;
        damageDetailssecondaryRiserSeven = null;
        damageDetailssecondaryRiserEight = null;
        damageDetailssecondaryRiserNine = null;
        damageDetailssecondaryRiserTen = null;

        damageDetailspoleGroundOne = null;
        damageDetailspoleGroundTwo = null;
        damageDetailspoleGroundThree = null;
        damageDetailspoleGroundFour = null;
        damageDetailspoleGroundFive = null;
        damageDetailspoleGroundSix = null;
        damageDetailspoleGroundSeven = null;
        damageDetailspoleGroundEight = null;
        damageDetailspoleGroundNine = null;
        damageDetailspoleGroundTen = null;

        damageDetailsvegetationOne = null;
        damageDetailsvegetationTwo = null;
        damageDetailsvegetationThree = null;
        damageDetailsvegetationFour = null;
        damageDetailsvegetationFive = null;
        damageDetailsvegetationSix = null;
        damageDetailsvegetationSeven = null;
        damageDetailsvegetationEight = null;
        damageDetailsvegetationNine = null;
        damageDetailsvegetationTen = null;

    }
}
