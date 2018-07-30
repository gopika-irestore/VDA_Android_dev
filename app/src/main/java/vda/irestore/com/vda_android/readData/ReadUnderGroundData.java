package vda.irestore.com.vda_android.readData;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dell on 22-12-2017.
 */

public class ReadUnderGroundData {
    public static ReadUnderGroundData readUnderGroundData = null;
    public String padmountsOnePicturePath = null, padmountsTwoPicturePath = null, padmountsThreePicturePath = null, padmountsFourPicturePath = null, padmountsFivePicturePath = null, padmountsSixPicturePath = null, padmountsSevenPicturePath = null, padmountsEightPicturePath = null, padmountsNinePicturePath = null, padmountsTenPicturePath = null,
            pullBoxOnePicturePath = null, pullBoxTwoPicturePath = null, pullBoxThreePicturePath = null, pullBoxFourPicturePath = null, pullBoxFivePicturePath = null, pullBoxSixPicturePath = null, pullBoxSevenPicturePath = null, pullBoxEightPicturePath = null, pullBoxNinePicturePath = null, pullBoxTenPicturePath = null,
            spiceBoxOnePicturePath = null, spiceBoxTwoPicturePath = null, spiceBoxThreePicturePath = null, spiceBoxFourPicturePath = null, spiceBoxFivePicturePath = null, spiceBoxSixPicturePath = null, spiceBoxSevenPicturePath = null, spiceBoxEightPicturePath = null, spiceBoxNinePicturePath = null, spiceBoxTenPicturePath = null,
            sectionalizerCabinetOnePicturePath = null, sectionalizerCabinetTwoPicturePath = null, sectionalizerCabinetThreePicturePath = null, sectionalizerCabinetFourPicturePath = null, sectionalizerCabinetFivePicturePath = null, sectionalizerCabinetSixPicturePath = null, sectionalizerCabinetSevenPicturePath = null, sectionalizerCabinetEightPicturePath = null, sectionalizerCabinetNinePicturePath = null, sectionalizerCabinetTenPicturePath = null,

    padmountsOneTestPicturePath = null, padmountsTwoTestPicturePath = null, padmountsThreeTestPicturePath = null, padmountsFourTestPicturePath = null, padmountsFiveTestPicturePath = null, padmountsSixTestPicturePath = null, padmountsSevenTestPicturePath = null, padmountsEightTestPicturePath = null, padmountsNineTestPicturePath = null, padmountsTenTestPicturePath = null,
            pullBoxOneTestPicturePath = null, pullBoxTwoTestPicturePath = null, pullBoxThreeTestPicturePath = null, pullBoxFourTestPicturePath = null, pullBoxFiveTestPicturePath = null, pullBoxSixTestPicturePath = null, pullBoxSevenTestPicturePath = null, pullBoxEightTestPicturePath = null, pullBoxNineTestPicturePath = null, pullBoxTenTestPicturePath = null,
            spiceBoxOneTestPicturePath = null, spiceBoxTwoTestPicturePath = null, spiceBoxThreeTestPicturePath = null, spiceBoxFourTestPicturePath = null, spiceBoxFiveTestPicturePath = null, spiceBoxSixTestPicturePath = null, spiceBoxSevenTestPicturePath = null, spiceBoxEightTestPicturePath = null, spiceBoxNineTestPicturePath = null, spiceBoxTenTestPicturePath = null,
            sectionalizerCabinetOneTestPicturePath = null, sectionalizerCabinetTwoTestPicturePath = null, sectionalizerCabinetThreeTestPicturePath = null, sectionalizerCabinetFourTestPicturePath = null, sectionalizerCabinetFiveTestPicturePath = null, sectionalizerCabinetSixTestPicturePath = null, sectionalizerCabinetSevenTestPicturePath = null, sectionalizerCabinetEightTestPicturePath = null, sectionalizerCabinetNineTestPicturePath = null, sectionalizerCabinetTenTestPicturePath = null;
    ;

    String addNote, addExtent,subtitle, kvaSize, displayName, testType, size;
    boolean isSelected, isChecked, isUtilityOwned;
    public String poleTitle, padmountsTitle, pullBoxTitle, spiceBoxTitle, sectionalizerCabinetTitle;

    JSONObject damageDetailspadmountsOne = new JSONObject();
    JSONObject damageDetailspadmountsTwo = new JSONObject();
    JSONObject damageDetailspadmountsThree = new JSONObject();
    JSONObject damageDetailspadmountsFour = new JSONObject();
    JSONObject damageDetailspadmountsFive = new JSONObject();
    JSONObject damageDetailspadmountsSix = new JSONObject();
    JSONObject damageDetailspadmountsSeven = new JSONObject();
    JSONObject damageDetailspadmountsEight = new JSONObject();
    JSONObject damageDetailspadmountsNine = new JSONObject();
    JSONObject damageDetailspadmountsTen = new JSONObject();

    JSONObject damageDetailspullBoxOne = new JSONObject();
    JSONObject damageDetailspullBoxTwo = new JSONObject();
    JSONObject damageDetailspullBoxThree = new JSONObject();
    JSONObject damageDetailspullBoxFour = new JSONObject();
    JSONObject damageDetailspullBoxFive = new JSONObject();
    JSONObject damageDetailspullBoxSix = new JSONObject();
    JSONObject damageDetailspullBoxSeven = new JSONObject();
    JSONObject damageDetailspullBoxEight = new JSONObject();
    JSONObject damageDetailspullBoxNine = new JSONObject();
    JSONObject damageDetailspullBoxTen = new JSONObject();

    JSONObject damageDetailsspiceBoxOne = new JSONObject();
    JSONObject damageDetailsspiceBoxTwo = new JSONObject();
    JSONObject damageDetailsspiceBoxThree = new JSONObject();
    JSONObject damageDetailsspiceBoxFour = new JSONObject();
    JSONObject damageDetailsspiceBoxFive = new JSONObject();
    JSONObject damageDetailsspiceBoxSix = new JSONObject();
    JSONObject damageDetailsspiceBoxSeven = new JSONObject();
    JSONObject damageDetailsspiceBoxEight = new JSONObject();
    JSONObject damageDetailsspiceBoxNine = new JSONObject();
    JSONObject damageDetailsspiceBoxTen = new JSONObject();

    JSONObject damageDetailssectionalizerCabinetOne = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetTwo = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetThree = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetFour = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetFive = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetSix = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetSeven = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetEight = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetNine = new JSONObject();
    JSONObject damageDetailssectionalizerCabinetTen = new JSONObject();

    public static synchronized ReadUnderGroundData getInstance() {
        if (readUnderGroundData == null) {
            readUnderGroundData = new ReadUnderGroundData();
        } else {
            return readUnderGroundData;
        }
        return readUnderGroundData;
    }

    public JSONObject readpadmountsOneData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsOne != null && UnderGroundData.getInstance().padmountsOne.size() > 0) {
            if (damageDetailspadmountsOne == null)
                damageDetailspadmountsOne = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsOne.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getPicturePath() != null) {
                        padmountsOnePicturePath = UnderGroundData.getInstance().padmountsOne.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().padmountsOne.get(i).getTestPicturePath() != null) {
                        padmountsOneTestPicturePath = UnderGroundData.getInstance().padmountsOne.get(i).getTestPicturePath();
                        padmountsOneTestPicturePath = padmountsOneTestPicturePath.substring(padmountsOneTestPicturePath.lastIndexOf("/") + 1);
                    }*/
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsOne.get(i).getTestPicturePath() != null) {
                        padmountsOneTestPicturePath = UnderGroundData.getInstance().padmountsOne.get(i).getTestPicturePath();
                        padmountsOneTestPicturePath = padmountsOneTestPicturePath.substring(padmountsOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsOne.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsOne.put(UnderGroundData.getInstance().padmountsOne.get(i).getTestingType(), UnderGroundData.getInstance().padmountsOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsOne.put(UnderGroundData.getInstance().padmountsOne.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsOne.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsOne.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsOne.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsOne.get(i).getSubTitle() != null) {
                            damageDetailspadmountsOne.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsOne.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsOne.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsOne.get(i).getSubTitle() != null) {
                            damageDetailspadmountsOne.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsOne.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsOne.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsOne.get(i).getSubTitle() != null) {
                            damageDetailspadmountsOne.put(subtitle, addExtent);
                        }
                    }

                    if (UnderGroundData.getInstance().padmountsOne.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsOne.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsOne.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getTitle() != null)
                        padmountsTitle = UnderGroundData.getInstance().padmountsOne.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsOne.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsOne.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsOne.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsOne.get(i).getName();
                        Log.i("Shri_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsOne.get(i).getDisplayName()+" ");
                        Log.i("Shri_LOG", "Name = " + UnderGroundData.getInstance().padmountsOne.get(i).getName()+" ");

                        if (isSelected) {

                            damageDetailspadmountsOne.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailspadmountsOne.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsOne;
    }

    public JSONObject readpadmountsTwoData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsTwo != null && UnderGroundData.getInstance().padmountsTwo.size() > 0) {
            if (damageDetailspadmountsTwo == null)
                damageDetailspadmountsTwo = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsTwo.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getPicturePath() != null) {
                        padmountsTwoPicturePath = UnderGroundData.getInstance().padmountsTwo.get(i).getPicturePath();
//                        padmountsTwoPicturePath = padmountsTwoPicturePath.substring(padmountsTwoPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().padmountsTwo.get(i).getTestPicturePath() != null) {
                        padmountsTwoTestPicturePath = UnderGroundData.getInstance().padmountsTwo.get(i).getTestPicturePath();
                        padmountsTwoTestPicturePath = padmountsTwoTestPicturePath.substring(padmountsTwoTestPicturePath.lastIndexOf("/") + 1);
                    }*/
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsTwo.get(i).getTestPicturePath() != null) {
                        padmountsTwoTestPicturePath = UnderGroundData.getInstance().padmountsTwo.get(i).getTestPicturePath();
                        padmountsTwoTestPicturePath = padmountsTwoTestPicturePath.substring(padmountsTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsTwo.put(UnderGroundData.getInstance().padmountsTwo.get(i).getTestingType(), UnderGroundData.getInstance().padmountsTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsTwo.put(UnderGroundData.getInstance().padmountsTwo.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsTwo.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTwo.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsTwo.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsTwo.get(i).getSubTitle() != null) {
                            damageDetailspadmountsTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTwo.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsTwo.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsTwo.get(i).getSubTitle() != null) {
                            damageDetailspadmountsTwo.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTwo.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsTwo.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsTwo.get(i).getSubTitle() != null) {
                            damageDetailspadmountsTwo.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTwo.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsTwo.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsTwo.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsTwo.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsTwo.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsTwo.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsTwo.get(i).getName();
                        if (isSelected) {
                            //displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailspadmountsTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsTwo;
    }

    public JSONObject readpadmountsThreeData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsThree != null && UnderGroundData.getInstance().padmountsThree.size() > 0) {
            if (damageDetailspadmountsThree == null)
                damageDetailspadmountsThree = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsThree.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getPicturePath() != null) {
                        padmountsThreePicturePath = UnderGroundData.getInstance().padmountsThree.get(i).getPicturePath();
//                        padmountsThreePicturePath = padmountsThreePicturePath.substring(padmountsThreePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().padmountsThree.get(i).getTestPicturePath() != null) {
                        padmountsThreeTestPicturePath = UnderGroundData.getInstance().padmountsThree.get(i).getTestPicturePath();
                        padmountsThreeTestPicturePath = padmountsThreeTestPicturePath.substring(padmountsThreeTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().padmountsThree.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsThree.get(i).getTestPicturePath() != null) {
                        padmountsThreeTestPicturePath = UnderGroundData.getInstance().padmountsThree.get(i).getTestPicturePath();
                        padmountsThreeTestPicturePath = padmountsThreeTestPicturePath.substring(padmountsThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsThree.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsThree.put(UnderGroundData.getInstance().padmountsThree.get(i).getTestingType(), UnderGroundData.getInstance().padmountsThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsThree.put(UnderGroundData.getInstance().padmountsThree.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsThree.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsThree.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsThree.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsThree.get(i).getSubTitle() != null) {
                            damageDetailspadmountsThree.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsThree.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsThree.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsThree.get(i).getSubTitle() != null) {
                            damageDetailspadmountsThree.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsThree.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsThree.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsThree.get(i).getSubTitle() != null) {
                            damageDetailspadmountsThree.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsThree.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsThree.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsThree.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsThree.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsThree.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsThree.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsThree.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspadmountsThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsThree;
    }

    public JSONObject readpadmountsFourData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsFour != null && UnderGroundData.getInstance().padmountsFour.size() > 0) {
            if (damageDetailspadmountsFour == null)
                damageDetailspadmountsFour = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsFour.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getPicturePath() != null) {
                        padmountsFourPicturePath = UnderGroundData.getInstance().padmountsFour.get(i).getPicturePath();
//                        padmountsFourPicturePath = padmountsFourPicturePath.substring(padmountsFourPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().padmountsFour.get(i).getTestPicturePath() != null) {
                        padmountsFourTestPicturePath = UnderGroundData.getInstance().padmountsFour.get(i).getTestPicturePath();
                        padmountsFourTestPicturePath = padmountsFourTestPicturePath.substring(padmountsFourTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().padmountsFour.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsFour.get(i).getTestPicturePath() != null) {
                        padmountsFourTestPicturePath = UnderGroundData.getInstance().padmountsFour.get(i).getTestPicturePath();
                        padmountsFourTestPicturePath = padmountsFourTestPicturePath.substring(padmountsFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsFour.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsFour.put(UnderGroundData.getInstance().padmountsFour.get(i).getTestingType(), UnderGroundData.getInstance().padmountsFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsFour.put(UnderGroundData.getInstance().padmountsFour.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsFour.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().padmountsFour.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFour.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsFour.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsFour.get(i).getSubTitle() != null) {
                            damageDetailspadmountsFour.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFour.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsFour.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsFour.get(i).getSubTitle() != null) {
                            damageDetailspadmountsFour.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFour.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsFour.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsFour.get(i).getSubTitle() != null) {
                            damageDetailspadmountsFour.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFour.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsFour.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsFour.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsFour.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsFour.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsFour.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsFour.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspadmountsFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsFour;
    }

    public JSONObject readpadmountsFiveData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsFive != null && UnderGroundData.getInstance().padmountsFive.size() > 0) {
            if (damageDetailspadmountsFive == null)
                damageDetailspadmountsFive = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsFive.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getPicturePath() != null) {
                        padmountsFivePicturePath = UnderGroundData.getInstance().padmountsFive.get(i).getPicturePath();
//                        padmountsFivePicturePath = padmountsFivePicturePath.substring(padmountsFivePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().padmountsFive.get(i).getTestPicturePath() != null) {
                        padmountsFiveTestPicturePath = UnderGroundData.getInstance().padmountsFive.get(i).getTestPicturePath();
                        padmountsFiveTestPicturePath = padmountsFiveTestPicturePath.substring(padmountsFiveTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().padmountsFive.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsFive.get(i).getTestPicturePath() != null) {
                        padmountsFiveTestPicturePath = UnderGroundData.getInstance().padmountsFive.get(i).getTestPicturePath();
                        padmountsFiveTestPicturePath = padmountsFiveTestPicturePath.substring(padmountsFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsFive.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsFive.put(UnderGroundData.getInstance().padmountsFive.get(i).getTestingType(), UnderGroundData.getInstance().padmountsFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsFive.put(UnderGroundData.getInstance().padmountsFive.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsFive.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().padmountsFive.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFive.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsFive.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsFive.get(i).getSubTitle() != null) {
                            damageDetailspadmountsFive.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFive.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsFive.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsFive.get(i).getSubTitle() != null) {
                            damageDetailspadmountsFive.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFive.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsFive.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsFive.get(i).getSubTitle() != null) {
                            damageDetailspadmountsFive.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsFive.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsFive.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsFive.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsFive.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsFive.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsFive.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsFive.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailspadmountsFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsFive;
    }

    public JSONObject readpadmountsSixData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsSix != null && UnderGroundData.getInstance().padmountsSix.size() > 0) {
            if (damageDetailspadmountsSix == null)
                damageDetailspadmountsSix = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsSix.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getPicturePath() != null) {
                        padmountsSixPicturePath = UnderGroundData.getInstance().padmountsSix.get(i).getPicturePath();
//                        padmountsSixPicturePath = padmountsSixPicturePath.substring(padmountsSixPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().padmountsSix.get(i).getTestPicturePath() != null) {
                        padmountsSixTestPicturePath = UnderGroundData.getInstance().padmountsSix.get(i).getTestPicturePath();
                        padmountsSixTestPicturePath = padmountsSixTestPicturePath.substring(padmountsSixTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().padmountsSix.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsSix.get(i).getTestPicturePath() != null) {
                        padmountsSixTestPicturePath = UnderGroundData.getInstance().padmountsSix.get(i).getTestPicturePath();
                        padmountsSixTestPicturePath = padmountsSixTestPicturePath.substring(padmountsSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsSix.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsSix.put(UnderGroundData.getInstance().padmountsSix.get(i).getTestingType(), UnderGroundData.getInstance().padmountsSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsSix.put(UnderGroundData.getInstance().padmountsSix.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsSix.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().padmountsSix.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSix.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsSix.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsSix.get(i).getSubTitle() != null) {
                            damageDetailspadmountsSix.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSix.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsSix.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsSix.get(i).getSubTitle() != null) {
                            damageDetailspadmountsSix.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSix.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsSix.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsSix.get(i).getSubTitle() != null) {
                            damageDetailspadmountsSix.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSix.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsSix.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsSix.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsSix.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsSix.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsSix.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsSix.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspadmountsSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsSix;
    }

    public JSONObject readpadmountsSevenData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsSeven != null && UnderGroundData.getInstance().padmountsSeven.size() > 0) {
            if (damageDetailspadmountsSeven == null)
                damageDetailspadmountsSeven = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsSeven.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getPicturePath() != null) {
                        padmountsSevenPicturePath = UnderGroundData.getInstance().padmountsSeven.get(i).getPicturePath();
//                        padmountsSevenPicturePath = padmountsSevenPicturePath.substring(padmountsSevenPicturePath.lastIndexOf("/") + 1);
                    }

                   /* if (UnderGroundData.getInstance().padmountsSeven.get(i).getTestPicturePath() != null) {
                        padmountsSevenTestPicturePath = UnderGroundData.getInstance().padmountsSeven.get(i).getTestPicturePath();
                        padmountsSevenTestPicturePath = padmountsSevenTestPicturePath.substring(padmountsSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsSeven.get(i).getTestPicturePath() != null) {
                        padmountsSevenTestPicturePath = UnderGroundData.getInstance().padmountsSeven.get(i).getTestPicturePath();
                        padmountsSevenTestPicturePath = padmountsSevenTestPicturePath.substring(padmountsSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsSeven.put(UnderGroundData.getInstance().padmountsSeven.get(i).getTestingType(), UnderGroundData.getInstance().padmountsSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsSeven.put(UnderGroundData.getInstance().padmountsSeven.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsSeven.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSeven.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsSeven.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsSeven.get(i).getSubTitle() != null) {
                            damageDetailspadmountsSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSeven.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsSeven.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsSeven.get(i).getSubTitle() != null) {
                            damageDetailspadmountsSeven.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSeven.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsSeven.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsSeven.get(i).getSubTitle() != null) {
                            damageDetailspadmountsSeven.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsSeven.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsSeven.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsSeven.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsSeven.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsSeven.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsSeven.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsSeven.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspadmountsSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsSeven;
    }

    public JSONObject readpadmountsEightData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsEight != null && UnderGroundData.getInstance().padmountsEight.size() > 0) {
            if (damageDetailspadmountsEight == null)
                damageDetailspadmountsEight = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsEight.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getPicturePath() != null) {
                        padmountsEightPicturePath = UnderGroundData.getInstance().padmountsEight.get(i).getPicturePath();
//                        padmountsEightPicturePath = padmountsEightPicturePath.substring(padmountsEightPicturePath.lastIndexOf("/") + 1);
                    }

                   /* if (UnderGroundData.getInstance().padmountsEight.get(i).getTestPicturePath() != null) {
                        padmountsEightTestPicturePath = UnderGroundData.getInstance().padmountsEight.get(i).getTestPicturePath();
                        padmountsEightTestPicturePath = padmountsEightTestPicturePath.substring(padmountsEightTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().padmountsEight.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsEight.get(i).getTestPicturePath() != null) {
                        padmountsEightTestPicturePath = UnderGroundData.getInstance().padmountsEight.get(i).getTestPicturePath();
                        padmountsEightTestPicturePath = padmountsEightTestPicturePath.substring(padmountsEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsEight.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsEight.put(UnderGroundData.getInstance().padmountsEight.get(i).getTestingType(), UnderGroundData.getInstance().padmountsEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsEight.put(UnderGroundData.getInstance().padmountsEight.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsEight.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (UnderGroundData.getInstance().padmountsEight.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsEight.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsEight.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsEight.get(i).getSubTitle() != null) {
                            damageDetailspadmountsEight.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsEight.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsEight.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsEight.get(i).getSubTitle() != null) {
                            damageDetailspadmountsEight.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsEight.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsEight.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsEight.get(i).getSubTitle() != null) {
                            damageDetailspadmountsEight.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsEight.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsEight.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsEight.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsEight.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsEight.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsEight.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsEight.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspadmountsEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsEight;
    }

    public JSONObject readpadmountsNineData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsNine != null && UnderGroundData.getInstance().padmountsNine.size() > 0) {
            if (damageDetailspadmountsNine == null)
                damageDetailspadmountsNine = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsNine.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getPicturePath() != null) {
                        padmountsNinePicturePath = UnderGroundData.getInstance().padmountsNine.get(i).getPicturePath();
//                        padmountsNinePicturePath = padmountsNinePicturePath.substring(padmountsNinePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().padmountsNine.get(i).getTestPicturePath() != null) {
                        padmountsNineTestPicturePath = UnderGroundData.getInstance().padmountsNine.get(i).getTestPicturePath();
                        padmountsNineTestPicturePath = padmountsNineTestPicturePath.substring(padmountsNineTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().padmountsNine.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsNine.get(i).getTestPicturePath() != null) {
                        padmountsNineTestPicturePath = UnderGroundData.getInstance().padmountsNine.get(i).getTestPicturePath();
                        padmountsNineTestPicturePath = padmountsNineTestPicturePath.substring(padmountsNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsNine.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsNine.put(UnderGroundData.getInstance().padmountsNine.get(i).getTestingType(), UnderGroundData.getInstance().padmountsNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsNine.put(UnderGroundData.getInstance().padmountsNine.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsNine.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (UnderGroundData.getInstance().padmountsNine.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsNine.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsNine.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsNine.get(i).getSubTitle() != null) {
                            damageDetailspadmountsNine.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsNine.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsNine.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsNine.get(i).getSubTitle() != null) {
                            damageDetailspadmountsNine.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsNine.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsNine.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsNine.get(i).getSubTitle() != null) {
                            damageDetailspadmountsNine.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsNine.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsNine.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsNine.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsNine.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsNine.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsNine.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsNine.get(i).getName();
                        if (isSelected) {
                         //   displayName = displayName.replaceAll("\\s", "");
                         //   displayName = "is" + displayName;
                            damageDetailspadmountsNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsNine;
    }

    public JSONObject readpadmountsTenData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().padmountsTen != null && UnderGroundData.getInstance().padmountsTen.size() > 0) {
            if (damageDetailspadmountsTen == null)
                damageDetailspadmountsTen = null;
            try {
                for (int i = 0; i < UnderGroundData.getInstance().padmountsTen.size(); i++) {
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getPicturePath() != null) {
                        padmountsTenPicturePath = UnderGroundData.getInstance().padmountsTen.get(i).getPicturePath();
//                        padmountsTenPicturePath = padmountsTenPicturePath.substring(padmountsTenPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().padmountsTen.get(i).getTestPicturePath() != null) {
                        padmountsTenTestPicturePath = UnderGroundData.getInstance().padmountsTen.get(i).getTestPicturePath();
                        padmountsTenTestPicturePath = padmountsTenTestPicturePath.substring(padmountsTenPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().padmountsTen.get(i).getTestType() != null && UnderGroundData.getInstance().padmountsTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().padmountsTen.get(i).getTestPicturePath() != null) {
                        padmountsTenTestPicturePath = UnderGroundData.getInstance().padmountsTen.get(i).getTestPicturePath();
                        padmountsTenTestPicturePath = padmountsTenTestPicturePath.substring(padmountsTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().padmountsTen.get(i).getIsTesttingResult() != null) {
                            damageDetailspadmountsTen.put(UnderGroundData.getInstance().padmountsTen.get(i).getTestingType(), UnderGroundData.getInstance().padmountsTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().padmountsTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspadmountsTen.put(UnderGroundData.getInstance().padmountsTen.get(i).getTestingTypePass(), UnderGroundData.getInstance().padmountsTen.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().padmountsTen.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTen.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().padmountsTen.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().padmountsTen.get(i).getSubTitle() != null) {
                            damageDetailspadmountsTen.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTen.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().padmountsTen.get(i).getNote();
                        if (UnderGroundData.getInstance().padmountsTen.get(i).getSubTitle() != null) {
                            damageDetailspadmountsTen.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTen.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().padmountsTen.get(i).getExtent();
                        if (UnderGroundData.getInstance().padmountsTen.get(i).getSubTitle() != null) {
                            damageDetailspadmountsTen.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().padmountsTen.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().padmountsTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspadmountsTen.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().padmountsTen.get(i).getTitle();
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().padmountsTen.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().padmountsTen.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().padmountsTen.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().padmountsTen.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailspadmountsTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspadmountsTen;
    }

    public JSONObject readpullBoxOneData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxOne != null && UnderGroundData.getInstance().pullBoxOne.size() > 0) {
            if (damageDetailspullBoxOne == null)
                damageDetailspullBoxOne = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxOne.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getPicturePath() != null) {
                        pullBoxOnePicturePath = UnderGroundData.getInstance().pullBoxOne.get(i).getPicturePath();
//                        pullBoxOnePicturePath = pullBoxOnePicturePath.substring(pullBoxOnePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().pullBoxOne.get(i).getTestPicturePath() != null) {
                        pullBoxOneTestPicturePath = UnderGroundData.getInstance().pullBoxOne.get(i).getTestPicturePath();
                        pullBoxOneTestPicturePath = pullBoxOneTestPicturePath.substring(pullBoxOneTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxOne.get(i).getTestPicturePath() != null) {
                        pullBoxOneTestPicturePath = UnderGroundData.getInstance().pullBoxOne.get(i).getTestPicturePath();
                        pullBoxOneTestPicturePath = pullBoxOneTestPicturePath.substring(pullBoxOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxOne.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxOne.put(UnderGroundData.getInstance().pullBoxOne.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxOne.put(UnderGroundData.getInstance().pullBoxOne.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxOne.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxOne.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxOne.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxOne.get(i).getSubTitle() != null) {
                            damageDetailspullBoxOne.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxOne.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxOne.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxOne.get(i).getSubTitle() != null) {
                            damageDetailspullBoxOne.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxOne.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxOne.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxOne.get(i).getSubTitle() != null) {
                            damageDetailspullBoxOne.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxOne.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxOne.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getTitle() != null)
                        pullBoxTitle = UnderGroundData.getInstance().pullBoxOne.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxOne.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxOne.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxOne.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxOne.get(i).getName();
                        if (isSelected) {
                            //displayName = displayName.replaceAll("\\s", "");
                            //displayName = "is" + displayName;
                            damageDetailspullBoxOne.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxOne;
    }

    public JSONObject readpullBoxTwoData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxTwo != null && UnderGroundData.getInstance().pullBoxTwo.size() > 0) {
            if (damageDetailspullBoxTwo == null)
                damageDetailspullBoxTwo = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxTwo.size(); i++) {

                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getPicturePath() != null) {
                        pullBoxTwoPicturePath = UnderGroundData.getInstance().pullBoxTwo.get(i).getPicturePath();
//                        pullBoxTwoPicturePath = pullBoxTwoPicturePath.substring(pullBoxTwoPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().pullBoxTwo.get(i).getTestPicturePath() != null) {
                        pullBoxTwoTestPicturePath = UnderGroundData.getInstance().pullBoxTwo.get(i).getTestPicturePath();
                        pullBoxTwoTestPicturePath = pullBoxTwoTestPicturePath.substring(pullBoxTwoTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxTwo.get(i).getTestPicturePath() != null) {
                        pullBoxTwoTestPicturePath = UnderGroundData.getInstance().pullBoxTwo.get(i).getTestPicturePath();
                        pullBoxTwoTestPicturePath = pullBoxTwoTestPicturePath.substring(pullBoxTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxTwo.put(UnderGroundData.getInstance().pullBoxTwo.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxTwo.put(UnderGroundData.getInstance().pullBoxTwo.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxTwo.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTwo.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxTwo.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxTwo.get(i).getSubTitle() != null) {
                            damageDetailspullBoxTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTwo.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxTwo.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxTwo.get(i).getSubTitle() != null) {
                            damageDetailspullBoxTwo.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTwo.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxTwo.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxTwo.get(i).getSubTitle() != null) {
                            damageDetailspullBoxTwo.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTwo.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxTwo.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxTwo.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxTwo.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxTwo.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxTwo.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxTwo.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailspullBoxTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxTwo;
    }

    public JSONObject readpullBoxThreeData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxThree != null && UnderGroundData.getInstance().pullBoxThree.size() > 0) {
            if (damageDetailspullBoxThree == null)
                damageDetailspullBoxThree = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxThree.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getPicturePath() != null) {
                        pullBoxThreePicturePath = UnderGroundData.getInstance().pullBoxThree.get(i).getPicturePath();
//                        pullBoxThreePicturePath = pullBoxThreePicturePath.substring(pullBoxThreePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().pullBoxThree.get(i).getTestPicturePath() != null) {
                        pullBoxThreeTestPicturePath = UnderGroundData.getInstance().pullBoxThree.get(i).getTestPicturePath();
                        pullBoxThreeTestPicturePath = pullBoxThreeTestPicturePath.substring(pullBoxThreeTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxThree.get(i).getTestPicturePath() != null) {
                        pullBoxThreeTestPicturePath = UnderGroundData.getInstance().pullBoxThree.get(i).getTestPicturePath();
                        pullBoxThreeTestPicturePath = pullBoxThreeTestPicturePath.substring(pullBoxThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxThree.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxThree.put(UnderGroundData.getInstance().pullBoxThree.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxThree.put(UnderGroundData.getInstance().pullBoxThree.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxThree.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxThree.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxThree.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxThree.get(i).getSubTitle() != null) {
                            damageDetailspullBoxThree.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxThree.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxThree.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxThree.get(i).getSubTitle() != null) {
                            damageDetailspullBoxThree.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxThree.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxThree.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxThree.get(i).getSubTitle() != null) {
                            damageDetailspullBoxThree.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxThree.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxThree.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxThree.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxThree.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxThree.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxThree.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxThree.get(i).getName();
                        if (isSelected) {
                         //   displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspullBoxThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxThree;
    }

    public JSONObject readpullBoxFourData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxFour != null && UnderGroundData.getInstance().pullBoxFour.size() > 0) {
            if (damageDetailspullBoxFour == null)
                damageDetailspullBoxFour = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxFour.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getPicturePath() != null) {
                        pullBoxFourPicturePath = UnderGroundData.getInstance().pullBoxFour.get(i).getPicturePath();
//                        pullBoxFourPicturePath = pullBoxFourPicturePath.substring(pullBoxFourPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().pullBoxFour.get(i).getTestPicturePath() != null) {
                        pullBoxFourTestPicturePath = UnderGroundData.getInstance().pullBoxFour.get(i).getTestPicturePath();
                        pullBoxFourTestPicturePath = pullBoxFourTestPicturePath.substring(pullBoxFourTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxFour.get(i).getTestPicturePath() != null) {
                        pullBoxFourTestPicturePath = UnderGroundData.getInstance().pullBoxFour.get(i).getTestPicturePath();
                        pullBoxFourTestPicturePath = pullBoxFourTestPicturePath.substring(pullBoxFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxFour.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxFour.put(UnderGroundData.getInstance().pullBoxFour.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxFour.put(UnderGroundData.getInstance().pullBoxFour.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxFour.get(i).getIsTesstingPassResult());
                        }
                    }





                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFour.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxFour.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxFour.get(i).getSubTitle() != null) {
                            damageDetailspullBoxFour.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFour.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxFour.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxFour.get(i).getSubTitle() != null) {
                            damageDetailspullBoxFour.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFour.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxFour.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxFour.get(i).getSubTitle() != null) {
                            damageDetailspullBoxFour.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFour.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxFour.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxFour.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxFour.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxFour.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxFour.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxFour.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspullBoxFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxFour;
    }

    public JSONObject readpullBoxFiveData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxFive != null && UnderGroundData.getInstance().pullBoxFive.size() > 0) {
            if (damageDetailspullBoxFive == null)
                damageDetailspullBoxFive = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxFive.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getPicturePath() != null) {
                        pullBoxFivePicturePath = UnderGroundData.getInstance().pullBoxFive.get(i).getPicturePath();
//                        pullBoxFivePicturePath = pullBoxFivePicturePath.substring(pullBoxFivePicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().pullBoxFive.get(i).getTestPicturePath() != null) {
                        pullBoxFiveTestPicturePath = UnderGroundData.getInstance().pullBoxFive.get(i).getTestPicturePath();
                        pullBoxFiveTestPicturePath = pullBoxFiveTestPicturePath.substring(pullBoxFiveTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxFive.get(i).getTestPicturePath() != null) {
                        pullBoxFiveTestPicturePath = UnderGroundData.getInstance().pullBoxFive.get(i).getTestPicturePath();
                        pullBoxFiveTestPicturePath = pullBoxFiveTestPicturePath.substring(pullBoxFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxFive.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxFive.put(UnderGroundData.getInstance().pullBoxFive.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxFive.put(UnderGroundData.getInstance().pullBoxFive.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxFive.get(i).getIsTesstingPassResult());
                        }
                    }





                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFive.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxFive.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxFive.get(i).getSubTitle() != null) {
                            damageDetailspullBoxFive.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFive.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxFive.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxFive.get(i).getSubTitle() != null) {
                            damageDetailspullBoxFive.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFive.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxFive.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxFive.get(i).getSubTitle() != null) {
                            damageDetailspullBoxFive.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxFive.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxFive.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxFive.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxFive.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxFive.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxFive.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxFive.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspullBoxFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxFive;
    }

    public JSONObject readpullBoxSixData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxSix != null && UnderGroundData.getInstance().pullBoxSix.size() > 0) {

            if (damageDetailspullBoxSix == null)
                damageDetailspullBoxSix = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxSix.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getPicturePath() != null) {
                        pullBoxSixPicturePath = UnderGroundData.getInstance().pullBoxSix.get(i).getPicturePath();
//                        pullBoxSixPicturePath = pullBoxSixPicturePath.substring(pullBoxSixPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().pullBoxSix.get(i).getTestPicturePath() != null) {
                        pullBoxSixTestPicturePath = UnderGroundData.getInstance().pullBoxSix.get(i).getTestPicturePath();
                        pullBoxSixTestPicturePath = pullBoxSixTestPicturePath.substring(pullBoxSixTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxSix.get(i).getTestPicturePath() != null) {
                        pullBoxSixTestPicturePath = UnderGroundData.getInstance().pullBoxSix.get(i).getTestPicturePath();
                        pullBoxSixTestPicturePath = pullBoxSixTestPicturePath.substring(pullBoxSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxSix.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxSix.put(UnderGroundData.getInstance().pullBoxSix.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxSix.put(UnderGroundData.getInstance().pullBoxSix.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxSix.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSix.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxSix.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxSix.get(i).getSubTitle() != null) {
                            damageDetailspullBoxSix.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSix.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxSix.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxSix.get(i).getSubTitle() != null) {
                            damageDetailspullBoxSix.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSix.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxSix.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxSix.get(i).getSubTitle() != null) {
                            damageDetailspullBoxSix.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSix.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxSix.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxSix.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxSix.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxSix.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxSix.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxSix.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspullBoxSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxSix;
    }

    public JSONObject readpullBoxSevenData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxSeven != null && UnderGroundData.getInstance().pullBoxSeven.size() > 0) {
            if (damageDetailspullBoxSeven == null)
                damageDetailspullBoxSeven = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxSeven.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getPicturePath() != null) {
                        pullBoxSevenPicturePath = UnderGroundData.getInstance().pullBoxSeven.get(i).getPicturePath();
//                        pullBoxSevenPicturePath = pullBoxSevenPicturePath.substring(pullBoxSevenPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().pullBoxSeven.get(i).getTestPicturePath() != null) {
                        pullBoxSevenTestPicturePath = UnderGroundData.getInstance().pullBoxSeven.get(i).getTestPicturePath();
                        pullBoxSevenTestPicturePath = pullBoxSevenTestPicturePath.substring(pullBoxSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxSeven.get(i).getTestPicturePath() != null) {
                        pullBoxSevenTestPicturePath = UnderGroundData.getInstance().pullBoxSeven.get(i).getTestPicturePath();
                        pullBoxSevenTestPicturePath = pullBoxSevenTestPicturePath.substring(pullBoxSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxSeven.put(UnderGroundData.getInstance().pullBoxSeven.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxSeven.put(UnderGroundData.getInstance().pullBoxSeven.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxSeven.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSeven.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxSeven.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxSeven.get(i).getSubTitle() != null) {
                            damageDetailspullBoxSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSeven.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxSeven.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxSeven.get(i).getSubTitle() != null) {
                            damageDetailspullBoxSeven.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSeven.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxSeven.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxSeven.get(i).getSubTitle() != null) {
                            damageDetailspullBoxSeven.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxSeven.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxSeven.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxSeven.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxSeven.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxSeven.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxSeven.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxSeven.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspullBoxSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxSeven;
    }

    public JSONObject readpullBoxEightData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxEight != null && UnderGroundData.getInstance().pullBoxEight.size() > 0) {
            if (damageDetailspullBoxEight == null)
                damageDetailspullBoxEight = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxEight.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getPicturePath() != null) {
                        pullBoxEightPicturePath = UnderGroundData.getInstance().pullBoxEight.get(i).getPicturePath();
//                        pullBoxEightPicturePath = pullBoxEightPicturePath.substring(pullBoxEightPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().pullBoxEight.get(i).getTestPicturePath() != null) {
                        pullBoxEightTestPicturePath = UnderGroundData.getInstance().pullBoxEight.get(i).getTestPicturePath();
                        pullBoxEightTestPicturePath = pullBoxEightTestPicturePath.substring(pullBoxEightTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxEight.get(i).getTestPicturePath() != null) {
                        pullBoxEightTestPicturePath = UnderGroundData.getInstance().pullBoxEight.get(i).getTestPicturePath();
                        pullBoxEightTestPicturePath = pullBoxEightTestPicturePath.substring(pullBoxEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxEight.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxEight.put(UnderGroundData.getInstance().pullBoxEight.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxEight.put(UnderGroundData.getInstance().pullBoxEight.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxEight.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxEight.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxEight.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxEight.get(i).getSubTitle() != null) {
                            damageDetailspullBoxEight.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxEight.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxEight.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxEight.get(i).getSubTitle() != null) {
                            damageDetailspullBoxEight.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxEight.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxEight.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxEight.get(i).getSubTitle() != null) {
                            damageDetailspullBoxEight.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxEight.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxEight.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxEight.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxEight.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxEight.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxEight.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxEight.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailspullBoxEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxEight;
    }

    public JSONObject readpullBoxNineData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxNine != null && UnderGroundData.getInstance().pullBoxNine.size() > 0) {
            if (damageDetailspullBoxNine == null)
                damageDetailspullBoxNine = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxNine.size(); i++) {
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getPicturePath() != null) {
                        pullBoxNinePicturePath = UnderGroundData.getInstance().pullBoxNine.get(i).getPicturePath();
//                        pullBoxNinePicturePath = pullBoxNinePicturePath.substring(pullBoxNinePicturePath.lastIndexOf("/") + 1);
                    }
                    /*if (UnderGroundData.getInstance().pullBoxNine.get(i).getTestPicturePath() != null) {
                        pullBoxNineTestPicturePath = UnderGroundData.getInstance().pullBoxNine.get(i).getTestPicturePath();
                        pullBoxNineTestPicturePath = pullBoxNineTestPicturePath.substring(pullBoxNineTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxNine.get(i).getTestPicturePath() != null) {
                        pullBoxNineTestPicturePath = UnderGroundData.getInstance().pullBoxNine.get(i).getTestPicturePath();
                        pullBoxNineTestPicturePath = pullBoxNineTestPicturePath.substring(pullBoxNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxNine.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxNine.put(UnderGroundData.getInstance().pullBoxNine.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxNine.put(UnderGroundData.getInstance().pullBoxNine.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxNine.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxNine.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxNine.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxNine.get(i).getSubTitle() != null) {
                            damageDetailspullBoxNine.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxNine.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxNine.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxNine.get(i).getSubTitle() != null) {
                            damageDetailspullBoxNine.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxNine.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxNine.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxNine.get(i).getSubTitle() != null) {
                            damageDetailspullBoxNine.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxNine.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxNine.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxNine.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxNine.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxNine.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxNine.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxNine.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailspullBoxNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxNine;
    }

    public JSONObject readpullBoxTenData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().pullBoxTen != null && UnderGroundData.getInstance().pullBoxTen.size() > 0) {
            if (damageDetailspullBoxTen == null)
                damageDetailspullBoxTen = null;
            try {
                for (int i = 0; i < UnderGroundData.getInstance().pullBoxTen.size(); i++) {
                    pullBoxTenPicturePath = UnderGroundData.getInstance().pullBoxTen.get(i).getPicturePath();
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getPicturePath() != null) {
//                        pullBoxTenPicturePath = pullBoxTenPicturePath.substring(pullBoxTenPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().pullBoxTen.get(i).getTestPicturePath() != null) {
                        pullBoxTenTestPicturePath = UnderGroundData.getInstance().pullBoxTen.get(i).getTestPicturePath();
                        pullBoxTenTestPicturePath = pullBoxTenTestPicturePath.substring(pullBoxTenPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getTestType() != null && UnderGroundData.getInstance().pullBoxTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().pullBoxTen.get(i).getTestPicturePath() != null) {
                        pullBoxTenTestPicturePath = UnderGroundData.getInstance().pullBoxTen.get(i).getTestPicturePath();
                        pullBoxTenTestPicturePath = pullBoxTenTestPicturePath.substring(pullBoxTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().pullBoxTen.get(i).getIsTesttingResult() != null) {
                            damageDetailspullBoxTen.put(UnderGroundData.getInstance().pullBoxTen.get(i).getTestingType(), UnderGroundData.getInstance().pullBoxTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().pullBoxTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailspullBoxTen.put(UnderGroundData.getInstance().pullBoxTen.get(i).getTestingTypePass(), UnderGroundData.getInstance().pullBoxTen.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTen.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().pullBoxTen.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().pullBoxTen.get(i).getSubTitle() != null) {
                            damageDetailspullBoxTen.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTen.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().pullBoxTen.get(i).getNote();
                        if (UnderGroundData.getInstance().pullBoxTen.get(i).getSubTitle() != null) {
                            damageDetailspullBoxTen.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTen.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().pullBoxTen.get(i).getExtent();
                        if (UnderGroundData.getInstance().pullBoxTen.get(i).getSubTitle() != null) {
                            damageDetailspullBoxTen.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().pullBoxTen.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().pullBoxTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailspullBoxTen.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().pullBoxTen.get(i).getTitle();
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().pullBoxTen.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().pullBoxTen.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().pullBoxTen.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().pullBoxTen.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailspullBoxTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailspullBoxTen;
    }

    public JSONObject readspiceBoxOneData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxOne != null && UnderGroundData.getInstance().spiceBoxOne.size() > 0) {
            if (damageDetailsspiceBoxOne == null)
                damageDetailsspiceBoxOne = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxOne.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getPicturePath() != null) {
                        spiceBoxOnePicturePath = UnderGroundData.getInstance().spiceBoxOne.get(i).getPicturePath();
//                        spiceBoxOnePicturePath = spiceBoxOnePicturePath.substring(spiceBoxOnePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().spiceBoxOne.get(i).getTestPicturePath() != null) {
                        spiceBoxOneTestPicturePath = UnderGroundData.getInstance().spiceBoxOne.get(i).getTestPicturePath();
                        spiceBoxOneTestPicturePath = spiceBoxOneTestPicturePath.substring(spiceBoxOneTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxOne.get(i).getTestPicturePath() != null) {
                        spiceBoxOneTestPicturePath = UnderGroundData.getInstance().spiceBoxOne.get(i).getTestPicturePath();
                        spiceBoxOneTestPicturePath = spiceBoxOneTestPicturePath.substring(spiceBoxOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxOne.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxOne.put(UnderGroundData.getInstance().spiceBoxOne.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxOne.put(UnderGroundData.getInstance().spiceBoxOne.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxOne.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxOne.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxOne.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxOne.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxOne.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxOne.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxOne.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxOne.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxOne.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxOne.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxOne.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxOne.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxOne.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxOne.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxOne.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getTitle() != null)
                        spiceBoxTitle = UnderGroundData.getInstance().spiceBoxOne.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getDisplayName() != null)
                    if (UnderGroundData.getInstance().spiceBoxOne.get(i).getIsSelected() != null) {
                      //  Log.i("VIDISHA_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxOne.get(i).getDisplayName()+"name--"+UnderGroundData.getInstance().spiceBoxOne.get(i).getName());

                        isSelected = UnderGroundData.getInstance().spiceBoxOne.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxOne.get(i).getName();
                        if (isSelected) {
                         //   displayName = displayName.replaceAll("\\s", "");
                         //   displayName = "is" + displayName;
                            damageDetailsspiceBoxOne.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxOne;
    }

    public JSONObject readspiceBoxTwoData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxTwo != null && UnderGroundData.getInstance().spiceBoxTwo.size() > 0) {
            if (damageDetailsspiceBoxTwo == null)
                damageDetailsspiceBoxTwo = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxTwo.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getPicturePath() != null) {
                        spiceBoxTwoPicturePath = UnderGroundData.getInstance().spiceBoxTwo.get(i).getPicturePath();
//                        spiceBoxTwoPicturePath = spiceBoxTwoPicturePath.substring(spiceBoxTwoPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestPicturePath() != null) {
                        spiceBoxTwoTestPicturePath = UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestPicturePath();
                        spiceBoxTwoTestPicturePath = spiceBoxTwoTestPicturePath.substring(spiceBoxTwoTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestPicturePath() != null) {
                        spiceBoxTwoTestPicturePath = UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestPicturePath();
                        spiceBoxTwoTestPicturePath = spiceBoxTwoTestPicturePath.substring(spiceBoxTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxTwo.put(UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxTwo.put(UnderGroundData.getInstance().spiceBoxTwo.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxTwo.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTwo.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxTwo.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTwo.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxTwo.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxTwo.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTwo.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxTwo.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxTwo.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTwo.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxTwo.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxTwo.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxTwo.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxTwo.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxTwo.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxTwo.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailsspiceBoxTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxTwo;
    }

    public JSONObject readspiceBoxThreeData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxThree != null && UnderGroundData.getInstance().spiceBoxThree.size() > 0) {
            if (damageDetailsspiceBoxThree == null)
                damageDetailsspiceBoxThree = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxThree.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getPicturePath() != null) {
                        spiceBoxThreePicturePath = UnderGroundData.getInstance().spiceBoxThree.get(i).getPicturePath();
//                        spiceBoxThreePicturePath = spiceBoxThreePicturePath.substring(spiceBoxThreePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().spiceBoxThree.get(i).getTestPicturePath() != null) {
                        spiceBoxThreeTestPicturePath = UnderGroundData.getInstance().spiceBoxThree.get(i).getTestPicturePath();
                        spiceBoxThreeTestPicturePath = spiceBoxThreeTestPicturePath.substring(spiceBoxThreeTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxThree.get(i).getTestPicturePath() != null) {
                        spiceBoxThreeTestPicturePath = UnderGroundData.getInstance().spiceBoxThree.get(i).getTestPicturePath();
                        spiceBoxThreeTestPicturePath = spiceBoxThreeTestPicturePath.substring(spiceBoxThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxThree.put(UnderGroundData.getInstance().spiceBoxThree.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxThree.put(UnderGroundData.getInstance().spiceBoxThree.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxThree.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxThree.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxThree.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxThree.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxThree.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxThree.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxThree.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxThree.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxThree.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxThree.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxThree.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxThree.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxThree.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxThree.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxThree.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxThree.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxThree.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxThree.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxThree.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxThree.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailsspiceBoxThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxThree;
    }

    public JSONObject readspiceBoxFourData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxFour != null && UnderGroundData.getInstance().spiceBoxFour.size() > 0) {
            if (damageDetailsspiceBoxFour == null)
                damageDetailsspiceBoxFour = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxFour.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getPicturePath() != null) {
                        spiceBoxFourPicturePath = UnderGroundData.getInstance().spiceBoxFour.get(i).getPicturePath();
//                        spiceBoxFourPicturePath = spiceBoxFourPicturePath.substring(spiceBoxFourPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().spiceBoxFour.get(i).getTestPicturePath() != null) {
                        spiceBoxFourTestPicturePath = UnderGroundData.getInstance().spiceBoxFour.get(i).getTestPicturePath();
                        spiceBoxFourTestPicturePath = spiceBoxFourTestPicturePath.substring(spiceBoxFourTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxFour.get(i).getTestPicturePath() != null) {
                        spiceBoxFourTestPicturePath = UnderGroundData.getInstance().spiceBoxFour.get(i).getTestPicturePath();
                        spiceBoxFourTestPicturePath = spiceBoxFourTestPicturePath.substring(spiceBoxFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxFour.put(UnderGroundData.getInstance().spiceBoxFour.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxFour.put(UnderGroundData.getInstance().spiceBoxFour.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxFour.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFour.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxFour.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxFour.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxFour.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFour.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxFour.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxFour.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxFour.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFour.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxFour.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxFour.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxFour.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFour.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxFour.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxFour.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxFour.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxFour.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxFour.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxFour.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailsspiceBoxFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxFour;
    }

    public JSONObject readspiceBoxFiveData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxFive != null && UnderGroundData.getInstance().spiceBoxFive.size() > 0) {
            if (damageDetailsspiceBoxFive == null)
                damageDetailsspiceBoxFive = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxFive.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getPicturePath() != null) {
                        spiceBoxFivePicturePath = UnderGroundData.getInstance().spiceBoxFive.get(i).getPicturePath();
//                        spiceBoxFivePicturePath = spiceBoxFivePicturePath.substring(spiceBoxFivePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().spiceBoxFive.get(i).getTestPicturePath() != null) {
                        spiceBoxFiveTestPicturePath = UnderGroundData.getInstance().spiceBoxFive.get(i).getTestPicturePath();
                        spiceBoxFiveTestPicturePath = spiceBoxFiveTestPicturePath.substring(spiceBoxFiveTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxFive.get(i).getTestPicturePath() != null) {
                        spiceBoxFiveTestPicturePath = UnderGroundData.getInstance().spiceBoxFive.get(i).getTestPicturePath();
                        spiceBoxFiveTestPicturePath = spiceBoxFiveTestPicturePath.substring(spiceBoxFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxFive.put(UnderGroundData.getInstance().spiceBoxFive.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxFive.put(UnderGroundData.getInstance().spiceBoxFive.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxFive.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFive.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxFive.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxFive.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxFive.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFive.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxFive.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxFive.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxFive.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFive.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxFive.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxFive.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxFive.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxFive.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxFive.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxFive.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxFive.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxFive.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxFive.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxFive.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailsspiceBoxFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxFive;
    }

    public JSONObject readspiceBoxSixData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxSix != null && UnderGroundData.getInstance().spiceBoxSix.size() > 0) {
            if (damageDetailsspiceBoxSix == null)
                damageDetailsspiceBoxSix = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxSix.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getPicturePath() != null) {
                        spiceBoxSixPicturePath = UnderGroundData.getInstance().spiceBoxSix.get(i).getPicturePath();
//                        spiceBoxSixPicturePath = spiceBoxSixPicturePath.substring(spiceBoxSixPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().spiceBoxSix.get(i).getTestPicturePath() != null) {
                        spiceBoxSixTestPicturePath = UnderGroundData.getInstance().spiceBoxSix.get(i).getTestPicturePath();
                        spiceBoxSixTestPicturePath = spiceBoxSixTestPicturePath.substring(spiceBoxSixTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxSix.get(i).getTestPicturePath() != null) {
                        spiceBoxSixTestPicturePath = UnderGroundData.getInstance().spiceBoxSix.get(i).getTestPicturePath();
                        spiceBoxSixTestPicturePath = spiceBoxSixTestPicturePath.substring(spiceBoxSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxSix.put(UnderGroundData.getInstance().spiceBoxSix.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxSix.put(UnderGroundData.getInstance().spiceBoxSix.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxSix.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSix.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxSix.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxSix.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxSix.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSix.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxSix.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxSix.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxSix.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSix.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxSix.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxSix.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxSix.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSix.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxSix.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxSix.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxSix.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxSix.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxSix.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxSix.get(i).getName();
                        if (isSelected) {
                         //   displayName = displayName.replaceAll("\\s", "");
                        //    displayName = "is" + displayName;
                            damageDetailsspiceBoxSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxSix;
    }

    public JSONObject readspiceBoxSevenData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxSeven != null && UnderGroundData.getInstance().spiceBoxSeven.size() > 0) {
            if (damageDetailsspiceBoxSeven == null)
                damageDetailsspiceBoxSeven = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxSeven.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getPicturePath() != null) {
                        spiceBoxSevenPicturePath = UnderGroundData.getInstance().spiceBoxSeven.get(i).getPicturePath();
//                        spiceBoxSevenPicturePath = spiceBoxSevenPicturePath.substring(spiceBoxSevenPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestPicturePath() != null) {
                        spiceBoxSevenTestPicturePath = UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestPicturePath();
                        spiceBoxSevenTestPicturePath = spiceBoxSevenTestPicturePath.substring(spiceBoxSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestPicturePath() != null) {
                        spiceBoxSevenTestPicturePath = UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestPicturePath();
                        spiceBoxSevenTestPicturePath = spiceBoxSevenTestPicturePath.substring(spiceBoxSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxSeven.put(UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxSeven.put(UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxSeven.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSeven.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxSeven.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSeven.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxSeven.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxSeven.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSeven.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxSeven.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxSeven.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxSeven.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxSeven.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxSeven.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxSeven.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxSeven.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxSeven.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailsspiceBoxSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxSeven;
    }

    public JSONObject readspiceBoxEightData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxEight != null && UnderGroundData.getInstance().spiceBoxEight.size() > 0) {
            if (damageDetailsspiceBoxEight == null)
                damageDetailsspiceBoxEight = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxEight.size(); i++) {
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getPicturePath() != null) {
                        spiceBoxEightPicturePath = UnderGroundData.getInstance().spiceBoxEight.get(i).getPicturePath();
//                        spiceBoxEightPicturePath = spiceBoxEightPicturePath.substring(spiceBoxEightPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestPicturePath() != null) {
                        spiceBoxSevenTestPicturePath = UnderGroundData.getInstance().spiceBoxSeven.get(i).getTestPicturePath();
                        spiceBoxSevenTestPicturePath = spiceBoxSevenTestPicturePath.substring(spiceBoxSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxEight.get(i).getTestPicturePath() != null) {
                        spiceBoxEightTestPicturePath = UnderGroundData.getInstance().spiceBoxEight.get(i).getTestPicturePath();
                        spiceBoxEightTestPicturePath = spiceBoxEightTestPicturePath.substring(spiceBoxEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxEight.put(UnderGroundData.getInstance().spiceBoxEight.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxEight.put(UnderGroundData.getInstance().spiceBoxEight.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxEight.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxEight.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxEight.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxEight.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxEight.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxEight.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxEight.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxEight.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxEight.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxEight.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxEight.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxEight.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxEight.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxEight.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxEight.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxEight.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxEight.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxEight.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxEight.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxEight.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailsspiceBoxEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxEight;
    }

    public JSONObject readspiceBoxNineData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxNine != null && UnderGroundData.getInstance().spiceBoxNine.size() > 0) {
            if (damageDetailsspiceBoxNine == null)
                damageDetailsspiceBoxNine = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxNine.size(); i++) {

                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getPicturePath() != null) {
                        spiceBoxNinePicturePath = UnderGroundData.getInstance().spiceBoxNine.get(i).getPicturePath();
//                        spiceBoxNinePicturePath = spiceBoxNinePicturePath.substring(spiceBoxNinePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().spiceBoxNine.get(i).getTestPicturePath() != null) {
                        spiceBoxNineTestPicturePath = UnderGroundData.getInstance().spiceBoxNine.get(i).getTestPicturePath();
                        spiceBoxNineTestPicturePath = spiceBoxNineTestPicturePath.substring(spiceBoxNineTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxNine.get(i).getTestPicturePath() != null) {
                        spiceBoxNineTestPicturePath = UnderGroundData.getInstance().spiceBoxNine.get(i).getTestPicturePath();
                        spiceBoxNineTestPicturePath = spiceBoxNineTestPicturePath.substring(spiceBoxNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxNine.put(UnderGroundData.getInstance().spiceBoxNine.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxNine.put(UnderGroundData.getInstance().spiceBoxNine.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxNine.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxNine.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxNine.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxNine.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxNine.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxNine.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxNine.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxNine.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxNine.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxNine.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxNine.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxNine.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxNine.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxNine.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxNine.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxNine.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxNine.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxNine.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxNine.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxNine.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailsspiceBoxNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxNine;
    }

    public JSONObject readspiceBoxTenData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().spiceBoxTen != null && UnderGroundData.getInstance().spiceBoxTen.size() > 0) {
            if (damageDetailsspiceBoxTen == null)
                damageDetailsspiceBoxTen = null;

            try {
                for (int i = 0; i < UnderGroundData.getInstance().spiceBoxTen.size(); i++) {
                    spiceBoxTenPicturePath = UnderGroundData.getInstance().spiceBoxTen.get(i).getPicturePath();
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getPicturePath() != null) {
//                        spiceBoxTenPicturePath = spiceBoxTenPicturePath.substring(spiceBoxTenPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().spiceBoxTen.get(i).getTestPicturePath() != null) {
                        spiceBoxTenTestPicturePath = UnderGroundData.getInstance().spiceBoxTen.get(i).getTestPicturePath();
                        spiceBoxTenTestPicturePath = spiceBoxTenTestPicturePath.substring(spiceBoxTenPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getTestType() != null && UnderGroundData.getInstance().spiceBoxTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().spiceBoxTen.get(i).getTestPicturePath() != null) {
                        spiceBoxTenTestPicturePath = UnderGroundData.getInstance().spiceBoxTen.get(i).getTestPicturePath();
                        spiceBoxTenTestPicturePath = spiceBoxTenTestPicturePath.substring(spiceBoxTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().spiceBoxTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsspiceBoxTen.put(UnderGroundData.getInstance().spiceBoxTen.get(i).getTestingType(), UnderGroundData.getInstance().spiceBoxTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().spiceBoxTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsspiceBoxTen.put(UnderGroundData.getInstance().spiceBoxTen.get(i).getTestingTypePass(), UnderGroundData.getInstance().spiceBoxTen.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTen.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().spiceBoxTen.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().spiceBoxTen.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxTen.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTen.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().spiceBoxTen.get(i).getNote();
                        if (UnderGroundData.getInstance().spiceBoxTen.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxTen.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTen.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().spiceBoxTen.get(i).getExtent();
                        if (UnderGroundData.getInstance().spiceBoxTen.get(i).getSubTitle() != null) {
                            damageDetailsspiceBoxTen.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().spiceBoxTen.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().spiceBoxTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsspiceBoxTen.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().spiceBoxTen.get(i).getTitle();
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().spiceBoxTen.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().spiceBoxTen.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().spiceBoxTen.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().spiceBoxTen.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                         //   displayName = "is" + displayName;
                            damageDetailsspiceBoxTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsspiceBoxTen;
    }

    public JSONObject readsectionalizerCabinetOneData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetOne != null && UnderGroundData.getInstance().sectionalizerCabinetOne.size() > 0) {
            if (damageDetailssectionalizerCabinetOne == null)
                damageDetailssectionalizerCabinetOne = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetOne.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getPicturePath() != null) {
                        sectionalizerCabinetOnePicturePath = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getPicturePath();
//                        sectionalizerCabinetOnePicturePath = sectionalizerCabinetOnePicturePath.substring(sectionalizerCabinetOnePicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetOneTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestPicturePath();
                        sectionalizerCabinetOneTestPicturePath = sectionalizerCabinetOneTestPicturePath.substring(sectionalizerCabinetOneTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetOneTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestPicturePath();
                        sectionalizerCabinetOneTestPicturePath = sectionalizerCabinetOneTestPicturePath.substring(sectionalizerCabinetOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetOne.put(UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetOne.put(UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetOne.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetOne.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetOne.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetOne.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTitle() != null)
                        sectionalizerCabinetTitle = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetOne.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetOne.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetOne;
    }

    public JSONObject readsectionalizerCabinetTwoData() {
        addNote = null;
        addExtent =null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetTwo != null && UnderGroundData.getInstance().sectionalizerCabinetTwo.size() > 0) {
            if (damageDetailssectionalizerCabinetTwo == null)
                damageDetailssectionalizerCabinetTwo = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetTwo.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getPicturePath() != null) {
                        sectionalizerCabinetTwoPicturePath = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getPicturePath();
//                        sectionalizerCabinetTwoPicturePath = sectionalizerCabinetTwoPicturePath.substring(sectionalizerCabinetTwoPicturePath.lastIndexOf("/") + 1);
                    }
              /*      if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetTwoTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestPicturePath();
                        sectionalizerCabinetTwoTestPicturePath = sectionalizerCabinetTwoTestPicturePath.substring(sectionalizerCabinetTwoTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetTwoTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestPicturePath();
                        sectionalizerCabinetTwoTestPicturePath = sectionalizerCabinetTwoTestPicturePath.substring(sectionalizerCabinetTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetTwo.put(UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetTwo.put(UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetTwo.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetTwo.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetTwo.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetTwo.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetTwo;
    }

    public JSONObject readsectionalizerCabinetThreeData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetThree != null && UnderGroundData.getInstance().sectionalizerCabinetThree.size() > 0) {
            if (damageDetailssectionalizerCabinetThree == null)
                damageDetailssectionalizerCabinetThree = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetThree.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getPicturePath() != null) {
                        sectionalizerCabinetThreePicturePath = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getPicturePath();
//                        sectionalizerCabinetThreePicturePath = sectionalizerCabinetThreePicturePath.substring(sectionalizerCabinetThreePicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetThreeTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestPicturePath();
                        sectionalizerCabinetThreeTestPicturePath = sectionalizerCabinetThreeTestPicturePath.substring(sectionalizerCabinetThreeTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetThreeTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestPicturePath();
                        sectionalizerCabinetThreeTestPicturePath = sectionalizerCabinetThreeTestPicturePath.substring(sectionalizerCabinetThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetThree.put(UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetThree.put(UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetThree.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetThree.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetThree.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetThree.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetThree.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetThree;
    }

    public JSONObject readsectionalizerCabinetFourData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetFour != null && UnderGroundData.getInstance().sectionalizerCabinetFour.size() > 0) {
            if (damageDetailssectionalizerCabinetFour == null)
                damageDetailssectionalizerCabinetFour = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetFour.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getPicturePath() != null) {
                        sectionalizerCabinetFourPicturePath = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getPicturePath();
//                        sectionalizerCabinetFourPicturePath = sectionalizerCabinetFourPicturePath.substring(sectionalizerCabinetFourPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetFourTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestPicturePath();
                        sectionalizerCabinetFourTestPicturePath = sectionalizerCabinetFourTestPicturePath.substring(sectionalizerCabinetFourTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetFourTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestPicturePath();
                        sectionalizerCabinetFourTestPicturePath = sectionalizerCabinetFourTestPicturePath.substring(sectionalizerCabinetFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetFour.put(UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetFour.put(UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetFour.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetFour.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetFour.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetFour.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetFour.get(i).getName();
                        if (isSelected) {
                         //   displayName = displayName.replaceAll("\\s", "");
                         //   displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetFour;
    }

    public JSONObject readsectionalizerCabinetFiveData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetFive != null && UnderGroundData.getInstance().sectionalizerCabinetFive.size() > 0) {
            if (damageDetailssectionalizerCabinetFive == null)
                damageDetailssectionalizerCabinetFive = new JSONObject();

            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetFive.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getPicturePath() != null) {
                        sectionalizerCabinetFivePicturePath = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getPicturePath();
//                        sectionalizerCabinetFivePicturePath = sectionalizerCabinetFivePicturePath.substring(sectionalizerCabinetFivePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetFiveTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestPicturePath();
                        sectionalizerCabinetFiveTestPicturePath = sectionalizerCabinetFiveTestPicturePath.substring(sectionalizerCabinetFiveTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetFiveTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestPicturePath();
                        sectionalizerCabinetFiveTestPicturePath = sectionalizerCabinetFiveTestPicturePath.substring(sectionalizerCabinetFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetFive.put(UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetFive.put(UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetFive.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetFive.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetFive.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetFive.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetFive.get(i).getName();
                        if (isSelected) {
                            //displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetFive;
    }

    public JSONObject readsectionalizerCabinetSixData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetSix != null && UnderGroundData.getInstance().sectionalizerCabinetSix.size() > 0) {
            if (damageDetailssectionalizerCabinetSix == null)
                damageDetailssectionalizerCabinetSix = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetSix.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getPicturePath() != null) {
                        sectionalizerCabinetSixPicturePath = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getPicturePath();
//                        sectionalizerCabinetSixPicturePath = sectionalizerCabinetSixPicturePath.substring(sectionalizerCabinetSixPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetSixTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestPicturePath();
                        sectionalizerCabinetSixTestPicturePath = sectionalizerCabinetSixTestPicturePath.substring(sectionalizerCabinetSixTestPicturePath.lastIndexOf("/") + 1);
                    }*/
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetSixTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestPicturePath();
                        sectionalizerCabinetSixTestPicturePath = sectionalizerCabinetSixTestPicturePath.substring(sectionalizerCabinetSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetSix.put(UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetSix.put(UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetSix.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetSix.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetSix.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetSix.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetSix.get(i).getName();
                        if (isSelected) {
                         //   displayName = displayName.replaceAll("\\s", "");
                           // displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetSix;
    }

    public JSONObject readsectionalizerCabinetSevenData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetSeven != null && UnderGroundData.getInstance().sectionalizerCabinetSeven.size() > 0) {
            if (damageDetailssectionalizerCabinetSeven == null)
                damageDetailssectionalizerCabinetSeven = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetSeven.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getPicturePath() != null) {
                        sectionalizerCabinetSevenPicturePath = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getPicturePath();
//                        sectionalizerCabinetSevenPicturePath = sectionalizerCabinetSevenPicturePath.substring(sectionalizerCabinetSevenPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetSevenTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestPicturePath();
                        sectionalizerCabinetSevenTestPicturePath = sectionalizerCabinetSevenTestPicturePath.substring(sectionalizerCabinetSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetSevenTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestPicturePath();
                        sectionalizerCabinetSevenTestPicturePath = sectionalizerCabinetSevenTestPicturePath.substring(sectionalizerCabinetSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetSeven.put(UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetSeven.put(UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetSeven.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetSeven.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetSeven.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetSeven.get(i).getName();
                        if (isSelected) {
                           // displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetSeven;
    }

    public JSONObject readsectionalizerCabinetEightData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetEight != null && UnderGroundData.getInstance().sectionalizerCabinetEight.size() > 0) {
            if (damageDetailssectionalizerCabinetEight == null)
                damageDetailssectionalizerCabinetEight = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetEight.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getPicturePath() != null) {
                        sectionalizerCabinetEightPicturePath = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getPicturePath();
//                        sectionalizerCabinetEightPicturePath = sectionalizerCabinetEightPicturePath.substring(sectionalizerCabinetEightPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetEightTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestPicturePath();
                        sectionalizerCabinetEightTestPicturePath = sectionalizerCabinetEightTestPicturePath.substring(sectionalizerCabinetEightTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetEightTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestPicturePath();
                        sectionalizerCabinetEightTestPicturePath = sectionalizerCabinetEightTestPicturePath.substring(sectionalizerCabinetEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetEight.put(UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetEight.put(UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetEight.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetEight.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetEight.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetEight.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetEight.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetEight;
    }

    public JSONObject readsectionalizerCabinetNineData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetNine != null && UnderGroundData.getInstance().sectionalizerCabinetNine.size() > 0) {
            if (damageDetailssectionalizerCabinetNine == null)
                damageDetailssectionalizerCabinetNine = new JSONObject();
            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetNine.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getPicturePath() != null) {
                        sectionalizerCabinetNinePicturePath = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getPicturePath();
//                        sectionalizerCabinetNinePicturePath = sectionalizerCabinetNinePicturePath.substring(sectionalizerCabinetNinePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetNineTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestPicturePath();
                        sectionalizerCabinetNineTestPicturePath = sectionalizerCabinetNineTestPicturePath.substring(sectionalizerCabinetNineTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetNineTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestPicturePath();
                        sectionalizerCabinetNineTestPicturePath = sectionalizerCabinetNineTestPicturePath.substring(sectionalizerCabinetNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetNine.put(UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetNine.put(UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getIsTesstingPassResult());
                        }
                    }





                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetNine.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetNine.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetNine.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetNine.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetNine.get(i).getName();
                        if (isSelected) {
                        //    displayName = displayName.replaceAll("\\s", "");
                         //   displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetNine;
    }

    public JSONObject readsectionalizerCabinetTenData() {
        addNote = null;
        addExtent=null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (UnderGroundData.getInstance().sectionalizerCabinetTen != null && UnderGroundData.getInstance().sectionalizerCabinetTen.size() > 0) {
            if (damageDetailssectionalizerCabinetTen == null)
                damageDetailssectionalizerCabinetTen = null;
            try {
                for (int i = 0; i < UnderGroundData.getInstance().sectionalizerCabinetTen.size(); i++) {
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getPicturePath() != null) {
                        sectionalizerCabinetTenPicturePath = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getPicturePath();
//                        sectionalizerCabinetTenPicturePath = sectionalizerCabinetTenPicturePath.substring(sectionalizerCabinetTenPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetTenTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestPicturePath();
                        sectionalizerCabinetTenTestPicturePath = sectionalizerCabinetTenTestPicturePath.substring(sectionalizerCabinetTenPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestType() != null && UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestPicturePath() != null) {
                        sectionalizerCabinetTenTestPicturePath = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestPicturePath();
                        sectionalizerCabinetTenTestPicturePath = sectionalizerCabinetTenTestPicturePath.substring(sectionalizerCabinetTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestingType() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getIsTesttingResult() != null) {
                            damageDetailssectionalizerCabinetTen.put(UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestingType(), UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestingTypePass() != null) {
                        if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssectionalizerCabinetTen.put(UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTestingTypePass(), UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getKvaSize() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getSubTitle();
                        kvaSize = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getKvaSize();
                        if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetTen.put(subtitle, kvaSize);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getNote() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getSubTitle();
                        addNote = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getNote();
                        if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetTen.put(subtitle, addNote);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getExtent() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getSubTitle();
                        addExtent = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getExtent();
                        if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getSubTitle() != null) {
                            damageDetailssectionalizerCabinetTen.put(subtitle, addExtent);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getCheckedOK() != null) {
                        subtitle = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getSubTitle();
                        isChecked = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssectionalizerCabinetTen.put(subtitle, isChecked);
                        }
                    }
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTitle() != null)
                        poleTitle = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getTitle();
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getDisplayName());
                    if (UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getIsSelected() != null) {
                        isSelected = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getIsSelected();
                        displayName = UnderGroundData.getInstance().sectionalizerCabinetTen.get(i).getName();
                        if (isSelected) {
                          //  displayName = displayName.replaceAll("\\s", "");
                          //  displayName = "is" + displayName;
                            damageDetailssectionalizerCabinetTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssectionalizerCabinetTen;
    }

    public void resetAllReference() {
        try {
            reserPictureName();
            UnderGroundData.getInstance().padmountsOne.clear();
            UnderGroundData.getInstance().padmountsTwo.clear();
            UnderGroundData.getInstance().padmountsThree.clear();
            UnderGroundData.getInstance().padmountsFour.clear();
            UnderGroundData.getInstance().padmountsFive.clear();
            UnderGroundData.getInstance().padmountsSix.clear();
            UnderGroundData.getInstance().padmountsSeven.clear();
            UnderGroundData.getInstance().padmountsEight.clear();
            UnderGroundData.getInstance().padmountsNine.clear();
            UnderGroundData.getInstance().padmountsTen.clear();

            UnderGroundData.getInstance().pullBoxOne.clear();
            UnderGroundData.getInstance().pullBoxTwo.clear();
            UnderGroundData.getInstance().pullBoxThree.clear();
            UnderGroundData.getInstance().pullBoxFour.clear();
            UnderGroundData.getInstance().pullBoxFive.clear();
            UnderGroundData.getInstance().pullBoxSix.clear();
            UnderGroundData.getInstance().pullBoxSeven.clear();
            UnderGroundData.getInstance().pullBoxEight.clear();
            UnderGroundData.getInstance().pullBoxNine.clear();
            UnderGroundData.getInstance().pullBoxTen.clear();

            UnderGroundData.getInstance().spiceBoxOne.clear();
            UnderGroundData.getInstance().spiceBoxTwo.clear();
            UnderGroundData.getInstance().spiceBoxThree.clear();
            UnderGroundData.getInstance().spiceBoxFour.clear();
            UnderGroundData.getInstance().spiceBoxFive.clear();
            UnderGroundData.getInstance().spiceBoxSix.clear();
            UnderGroundData.getInstance().spiceBoxSeven.clear();
            UnderGroundData.getInstance().spiceBoxEight.clear();
            UnderGroundData.getInstance().spiceBoxNine.clear();
            UnderGroundData.getInstance().spiceBoxTen.clear();

            UnderGroundData.getInstance().sectionalizerCabinetOne.clear();
            UnderGroundData.getInstance().sectionalizerCabinetTwo.clear();
            UnderGroundData.getInstance().sectionalizerCabinetThree.clear();
            UnderGroundData.getInstance().sectionalizerCabinetFour.clear();
            UnderGroundData.getInstance().sectionalizerCabinetFive.clear();
            UnderGroundData.getInstance().sectionalizerCabinetSix.clear();
            UnderGroundData.getInstance().sectionalizerCabinetSeven.clear();
            UnderGroundData.getInstance().sectionalizerCabinetEight.clear();
            UnderGroundData.getInstance().sectionalizerCabinetNine.clear();
            UnderGroundData.getInstance().sectionalizerCabinetTen.clear();
        } catch (NullPointerException e) {

        }
    }

    private void reserPictureName() {

        padmountsOnePicturePath = null;
        padmountsTwoPicturePath = null;
        padmountsThreePicturePath = null;
        padmountsFourPicturePath = null;
        padmountsFivePicturePath = null;
        padmountsSixPicturePath = null;
        padmountsSevenPicturePath = null;
        padmountsEightPicturePath = null;
        padmountsNinePicturePath = null;
        padmountsTenPicturePath = null;

        pullBoxOnePicturePath = null;
        pullBoxTwoPicturePath = null;
        pullBoxThreePicturePath = null;
        pullBoxFourPicturePath = null;
        pullBoxFivePicturePath = null;
        pullBoxSixPicturePath = null;
        pullBoxSevenPicturePath = null;
        pullBoxEightPicturePath = null;
        pullBoxNinePicturePath = null;
        pullBoxTenPicturePath = null;

        spiceBoxOnePicturePath = null;
        spiceBoxTwoPicturePath = null;
        spiceBoxThreePicturePath = null;
        spiceBoxFourPicturePath = null;
        spiceBoxFivePicturePath = null;
        spiceBoxSixPicturePath = null;
        spiceBoxSevenPicturePath = null;
        spiceBoxEightPicturePath = null;
        spiceBoxNinePicturePath = null;
        spiceBoxTenPicturePath = null;

        sectionalizerCabinetOnePicturePath = null;
        sectionalizerCabinetTwoPicturePath = null;
        sectionalizerCabinetThreePicturePath = null;
        sectionalizerCabinetFourPicturePath = null;
        sectionalizerCabinetFivePicturePath = null;
        sectionalizerCabinetSixPicturePath = null;
        sectionalizerCabinetSevenPicturePath = null;
        sectionalizerCabinetEightPicturePath = null;
        sectionalizerCabinetNinePicturePath = null;
        sectionalizerCabinetTenPicturePath = null;

        padmountsOneTestPicturePath = null;
        padmountsTwoTestPicturePath = null;
        padmountsThreeTestPicturePath = null;
        padmountsFourTestPicturePath = null;
        padmountsFiveTestPicturePath = null;
        padmountsSixTestPicturePath = null;
        padmountsSevenTestPicturePath = null;
        padmountsEightTestPicturePath = null;
        padmountsNineTestPicturePath = null;
        padmountsTenTestPicturePath = null;
        pullBoxOneTestPicturePath = null;

        pullBoxTwoTestPicturePath = null;
        pullBoxThreeTestPicturePath = null;
        pullBoxFourTestPicturePath = null;
        pullBoxFiveTestPicturePath = null;
        pullBoxSixTestPicturePath = null;
        pullBoxSevenTestPicturePath = null;
        pullBoxEightTestPicturePath = null;
        pullBoxNineTestPicturePath = null;
        pullBoxTenTestPicturePath = null;

        spiceBoxOneTestPicturePath = null;
        spiceBoxTwoTestPicturePath = null;
        spiceBoxThreeTestPicturePath = null;
        spiceBoxFourTestPicturePath = null;
        spiceBoxFiveTestPicturePath = null;
        spiceBoxSixTestPicturePath = null;
        spiceBoxSevenTestPicturePath = null;
        spiceBoxEightTestPicturePath = null;
        spiceBoxNineTestPicturePath = null;
        spiceBoxTenTestPicturePath = null;

        sectionalizerCabinetOneTestPicturePath = null;
        sectionalizerCabinetTwoTestPicturePath = null;
        sectionalizerCabinetThreeTestPicturePath = null;
        sectionalizerCabinetFourTestPicturePath = null;
        sectionalizerCabinetFiveTestPicturePath = null;
        sectionalizerCabinetSixTestPicturePath = null;
        sectionalizerCabinetSevenTestPicturePath = null;
        sectionalizerCabinetEightTestPicturePath = null;
        sectionalizerCabinetNineTestPicturePath = null;
        sectionalizerCabinetTenTestPicturePath = null;
    }

    public void resetAllJSONObject() {
        damageDetailspadmountsOne = null;
        damageDetailspadmountsTwo = null;
        damageDetailspadmountsThree = null;
        damageDetailspadmountsFour = null;
        damageDetailspadmountsFive = null;
        damageDetailspadmountsSix = null;
        damageDetailspadmountsSeven = null;
        damageDetailspadmountsEight = null;
        damageDetailspadmountsNine = null;
        damageDetailspadmountsTen = null;

        damageDetailspullBoxOne = null;
        damageDetailspullBoxTwo = null;
        damageDetailspullBoxThree = null;
        damageDetailspullBoxFour = null;
        damageDetailspullBoxFive = null;
        damageDetailspullBoxSix = null;
        damageDetailspullBoxSeven = null;
        damageDetailspullBoxEight = null;
        damageDetailspullBoxNine = null;
        damageDetailspullBoxTen = null;

        damageDetailsspiceBoxOne = null;
        damageDetailsspiceBoxTwo = null;
        damageDetailsspiceBoxThree = null;
        damageDetailsspiceBoxFour = null;
        damageDetailsspiceBoxFive = null;
        damageDetailsspiceBoxSix = null;
        damageDetailsspiceBoxSeven = null;
        damageDetailsspiceBoxEight = null;
        damageDetailsspiceBoxNine = null;
        damageDetailsspiceBoxTen = null;

        damageDetailssectionalizerCabinetOne = null;
        damageDetailssectionalizerCabinetTwo = null;
        damageDetailssectionalizerCabinetThree = null;
        damageDetailssectionalizerCabinetFour = null;
        damageDetailssectionalizerCabinetFive = null;
        damageDetailssectionalizerCabinetSix = null;
        damageDetailssectionalizerCabinetSeven = null;
        damageDetailssectionalizerCabinetEight = null;
        damageDetailssectionalizerCabinetNine = null;
        damageDetailssectionalizerCabinetTen = null;
    }
}
