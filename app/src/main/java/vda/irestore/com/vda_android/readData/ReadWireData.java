package vda.irestore.com.vda_android.readData;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ReadWireData {
    public static ReadWireData readWireData = null;
    public String primary_wireOnePicturePath = null, primary_wireTwoPicturePath = null, primary_wireThreePicturePath = null, primary_wireFourPicturePath = null, primary_wireFivePicturePath = null, primary_wireSixPicturePath = null, primary_wireSevenPicturePath = null, primary_wireEightPicturePath = null, primary_wireNinePicturePath = null, primary_wireTenPicturePath = null,
            secondary_wireOnePicturePath = null, secondary_wireTwoPicturePath = null, secondary_wireThreePicturePath = null, secondary_wireFourPicturePath = null, secondary_wireFivePicturePath = null, secondary_wireSixPicturePath = null, secondary_wireSevenPicturePath = null, secondary_wireEightPicturePath = null, secondary_wireNinePicturePath = null, secondary_wireTenPicturePath = null,
            service_wireOnePicturePath = null, service_wireTwoPicturePath = null, service_wireThreePicturePath = null, service_wireFourPicturePath = null, service_wireFivePicturePath = null, service_wireSixPicturePath = null, service_wireSevenPicturePath = null, service_wireEightPicturePath = null, service_wireNinePicturePath = null, service_wireTenPicturePath = null,

    primary_wireOneTestPicturePath = null, primary_wireTwoTestPicturePath = null, primary_wireThreeTestPicturePath = null, primary_wireFourTestPicturePath = null, primary_wireFiveTestPicturePath = null, primary_wireSixTestPicturePath = null, primary_wireSevenTestPicturePath = null, primary_wireEightTestPicturePath = null, primary_wireNineTestPicturePath = null, primary_wireTenTestPicturePath = null,
            secondary_wireOneTestPicturePath = null, secondary_wireTwoTestPicturePath = null, secondary_wireThreeTestPicturePath = null, secondary_wireFourTestPicturePath = null, secondary_wireFiveTestPicturePath = null, secondary_wireSixTestPicturePath = null, secondary_wireSevenTestPicturePath = null, secondary_wireEightTestPicturePath = null, secondary_wireNineTestPicturePath = null, secondary_wireTenTestPicturePath = null,
            service_wireOneTestPicturePath = null, service_wireTwoTestPicturePath = null, service_wireThreeTestPicturePath = null, service_wireFourTestPicturePath = null, service_wireFiveTestPicturePath = null, service_wireSixTestPicturePath = null, service_wireSevenTestPicturePath = null, service_wireEightTestPicturePath = null, service_wireNineTestPicturePath = null, service_wireTenTestPicturePath = null;
    ;

    String addNote, subtitle, kvaSize, displayName, testType, size;
    boolean isSelected, isChecked, isUtilityOwned;
    public String poleTitle, primary_wireTitle, secondary_wireTitle, service_wireTitle;

    JSONObject damageDetailsprimary_wireOne = new JSONObject();
    JSONObject damageDetailsprimary_wireTwo = new JSONObject();
    JSONObject damageDetailsprimary_wireThree = new JSONObject();
    JSONObject damageDetailsprimary_wireFour = new JSONObject();
    JSONObject damageDetailsprimary_wireFive = new JSONObject();
    JSONObject damageDetailsprimary_wireSix = new JSONObject();
    JSONObject damageDetailsprimary_wireSeven = new JSONObject();
    JSONObject damageDetailsprimary_wireEight = new JSONObject();
    JSONObject damageDetailsprimary_wireNine = new JSONObject();
    JSONObject damageDetailsprimary_wireTen = new JSONObject();

    JSONObject damageDetailssecondary_wireOne = new JSONObject();
    JSONObject damageDetailssecondary_wireTwo = new JSONObject();
    JSONObject damageDetailssecondary_wireThree = new JSONObject();
    JSONObject damageDetailssecondary_wireFour = new JSONObject();
    JSONObject damageDetailssecondary_wireFive = new JSONObject();
    JSONObject damageDetailssecondary_wireSix = new JSONObject();
    JSONObject damageDetailssecondary_wireSeven = new JSONObject();
    JSONObject damageDetailssecondary_wireEight = new JSONObject();
    JSONObject damageDetailssecondary_wireNine = new JSONObject();
    JSONObject damageDetailssecondary_wireTen = new JSONObject();

    JSONObject damageDetailsservice_wireOne = new JSONObject();
    JSONObject damageDetailsservice_wireTwo = new JSONObject();
    JSONObject damageDetailsservice_wireThree = new JSONObject();
    JSONObject damageDetailsservice_wireFour = new JSONObject();
    JSONObject damageDetailsservice_wireFive = new JSONObject();
    JSONObject damageDetailsservice_wireSix = new JSONObject();
    JSONObject damageDetailsservice_wireSeven = new JSONObject();
    JSONObject damageDetailsservice_wireEight = new JSONObject();
    JSONObject damageDetailsservice_wireNine = new JSONObject();
    JSONObject damageDetailsservice_wireTen = new JSONObject();

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

    public static synchronized ReadWireData getInstance() {
        if (readWireData == null) {
            readWireData = new ReadWireData();
        } else {
            return readWireData;
        }
        return readWireData;
    }

    public JSONObject readprimary_wireOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireOne != null && WireData.getInstance().primary_wireOne.size() > 0) {
            if (damageDetailsprimary_wireOne == null)
                damageDetailsprimary_wireOne = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireOne.size(); i++) {
                    if (WireData.getInstance().primary_wireOne.get(i).getPicturePath() != null) {
                        primary_wireOnePicturePath = WireData.getInstance().primary_wireOne.get(i).getPicturePath();
//                        primary_wireOnePicturePath = primary_wireOnePicturePath.substring(primary_wireOnePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().primary_wireOne.get(i).getTestPicturePath() != null) {
                        primary_wireOneTestPicturePath = WireData.getInstance().primary_wireOne.get(i).getTestPicturePath();
                        primary_wireOneTestPicturePath = primary_wireOneTestPicturePath.substring(primary_wireOneTestPicturePath.lastIndexOf("/") + 1);
                    }*/
                    if (WireData.getInstance().primary_wireOne.get(i).getTestType() != null && WireData.getInstance().primary_wireOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireOne.get(i).getTestPicturePath() != null) {
                        primary_wireOneTestPicturePath = WireData.getInstance().primary_wireOne.get(i).getTestPicturePath();
                        primary_wireOneTestPicturePath = primary_wireOneTestPicturePath.substring(primary_wireOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireOne.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireOne.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireOne.put(WireData.getInstance().primary_wireOne.get(i).getTestingType(), WireData.getInstance().primary_wireOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireOne.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireOne.put(WireData.getInstance().primary_wireOne.get(i).getTestingTypePass(), WireData.getInstance().primary_wireOne.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireOne.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireOne.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireOne.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireOne.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireOne.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireOne.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireOne.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireOne.get(i).getNote();
                        if (WireData.getInstance().primary_wireOne.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireOne.put(subtitle, addNote);
                        }
                    }

                    if (WireData.getInstance().primary_wireOne.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireOne.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireOne.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireOne.get(i).getTitle() != null)
                        primary_wireTitle = WireData.getInstance().primary_wireOne.get(i).getTitle();
                    if (WireData.getInstance().primary_wireOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireOne.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireOne.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireOne.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireOne.get(i).getName();
                        Log.i("Shri_LOG", "Display Name = " + WireData.getInstance().primary_wireOne.get(i).getDisplayName()+" ");
                        Log.i("Shri_LOG", "Name = " + WireData.getInstance().primary_wireOne.get(i).getName()+" ");

                        if (isSelected) {
                            Log.i("Shri_LOG111", "Name = " + WireData.getInstance().primary_wireOne.get(i).getName()+" ");
                            //  displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailsprimary_wireOne.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailsprimary_wireOne.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireOne;
    }

    public JSONObject readprimary_wireTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireTwo != null && WireData.getInstance().primary_wireTwo.size() > 0) {
            if (damageDetailsprimary_wireTwo == null)
                damageDetailsprimary_wireTwo = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireTwo.size(); i++) {
                    if (WireData.getInstance().primary_wireTwo.get(i).getPicturePath() != null) {
                        primary_wireTwoPicturePath = WireData.getInstance().primary_wireTwo.get(i).getPicturePath();
//                        primary_wireTwoPicturePath = primary_wireTwoPicturePath.substring(primary_wireTwoPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().primary_wireTwo.get(i).getTestPicturePath() != null) {
                        primary_wireTwoTestPicturePath = WireData.getInstance().primary_wireTwo.get(i).getTestPicturePath();
                        primary_wireTwoTestPicturePath = primary_wireTwoTestPicturePath.substring(primary_wireTwoTestPicturePath.lastIndexOf("/") + 1);
                    }*/
                    if (WireData.getInstance().primary_wireTwo.get(i).getTestType() != null && WireData.getInstance().primary_wireTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireTwo.get(i).getTestPicturePath() != null) {
                        primary_wireTwoTestPicturePath = WireData.getInstance().primary_wireTwo.get(i).getTestPicturePath();
                        primary_wireTwoTestPicturePath = primary_wireTwoTestPicturePath.substring(primary_wireTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireTwo.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireTwo.put(WireData.getInstance().primary_wireTwo.get(i).getTestingType(), WireData.getInstance().primary_wireTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireTwo.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireTwo.put(WireData.getInstance().primary_wireTwo.get(i).getTestingTypePass(), WireData.getInstance().primary_wireTwo.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireTwo.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireTwo.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireTwo.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireTwo.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireTwo.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireTwo.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireTwo.get(i).getNote();
                        if (WireData.getInstance().primary_wireTwo.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireTwo.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireTwo.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireTwo.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireTwo.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireTwo.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireTwo.get(i).getTitle();
                    if (WireData.getInstance().primary_wireTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireTwo.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireTwo.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireTwo.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireTwo.get(i).getName();
                        if (isSelected) {
                            //displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailsprimary_wireTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireTwo;
    }

    public JSONObject readprimary_wireThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireThree != null && WireData.getInstance().primary_wireThree.size() > 0) {
            if (damageDetailsprimary_wireThree == null)
                damageDetailsprimary_wireThree = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireThree.size(); i++) {
                    if (WireData.getInstance().primary_wireThree.get(i).getPicturePath() != null) {
                        primary_wireThreePicturePath = WireData.getInstance().primary_wireThree.get(i).getPicturePath();
//                        primary_wireThreePicturePath = primary_wireThreePicturePath.substring(primary_wireThreePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().primary_wireThree.get(i).getTestPicturePath() != null) {
                        primary_wireThreeTestPicturePath = WireData.getInstance().primary_wireThree.get(i).getTestPicturePath();
                        primary_wireThreeTestPicturePath = primary_wireThreeTestPicturePath.substring(primary_wireThreeTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().primary_wireThree.get(i).getTestType() != null && WireData.getInstance().primary_wireThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireThree.get(i).getTestPicturePath() != null) {
                        primary_wireThreeTestPicturePath = WireData.getInstance().primary_wireThree.get(i).getTestPicturePath();
                        primary_wireThreeTestPicturePath = primary_wireThreeTestPicturePath.substring(primary_wireThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireThree.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireThree.put(WireData.getInstance().primary_wireThree.get(i).getTestingType(), WireData.getInstance().primary_wireThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireThree.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireThree.put(WireData.getInstance().primary_wireThree.get(i).getTestingTypePass(), WireData.getInstance().primary_wireThree.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireThree.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireThree.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireThree.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireThree.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireThree.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireThree.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireThree.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireThree.get(i).getNote();
                        if (WireData.getInstance().primary_wireThree.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireThree.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireThree.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireThree.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireThree.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireThree.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireThree.get(i).getTitle();
                    if (WireData.getInstance().primary_wireThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireThree.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireThree.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireThree.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireThree.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsprimary_wireThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireThree;
    }

    public JSONObject readprimary_wireFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireFour != null && WireData.getInstance().primary_wireFour.size() > 0) {
            if (damageDetailsprimary_wireFour == null)
                damageDetailsprimary_wireFour = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireFour.size(); i++) {
                    if (WireData.getInstance().primary_wireFour.get(i).getPicturePath() != null) {
                        primary_wireFourPicturePath = WireData.getInstance().primary_wireFour.get(i).getPicturePath();
//                        primary_wireFourPicturePath = primary_wireFourPicturePath.substring(primary_wireFourPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().primary_wireFour.get(i).getTestPicturePath() != null) {
                        primary_wireFourTestPicturePath = WireData.getInstance().primary_wireFour.get(i).getTestPicturePath();
                        primary_wireFourTestPicturePath = primary_wireFourTestPicturePath.substring(primary_wireFourTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().primary_wireFour.get(i).getTestType() != null && WireData.getInstance().primary_wireFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireFour.get(i).getTestPicturePath() != null) {
                        primary_wireFourTestPicturePath = WireData.getInstance().primary_wireFour.get(i).getTestPicturePath();
                        primary_wireFourTestPicturePath = primary_wireFourTestPicturePath.substring(primary_wireFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireFour.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireFour.put(WireData.getInstance().primary_wireFour.get(i).getTestingType(), WireData.getInstance().primary_wireFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireFour.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireFour.put(WireData.getInstance().primary_wireFour.get(i).getTestingTypePass(), WireData.getInstance().primary_wireFour.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (WireData.getInstance().primary_wireFour.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireFour.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireFour.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireFour.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireFour.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireFour.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireFour.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireFour.get(i).getNote();
                        if (WireData.getInstance().primary_wireFour.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireFour.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireFour.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireFour.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireFour.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireFour.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireFour.get(i).getTitle();
                    if (WireData.getInstance().primary_wireFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireFour.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireFour.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireFour.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireFour.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsprimary_wireFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireFour;
    }

    public JSONObject readprimary_wireFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireFive != null && WireData.getInstance().primary_wireFive.size() > 0) {
            if (damageDetailsprimary_wireFive == null)
                damageDetailsprimary_wireFive = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireFive.size(); i++) {
                    if (WireData.getInstance().primary_wireFive.get(i).getPicturePath() != null) {
                        primary_wireFivePicturePath = WireData.getInstance().primary_wireFive.get(i).getPicturePath();
//                        primary_wireFivePicturePath = primary_wireFivePicturePath.substring(primary_wireFivePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().primary_wireFive.get(i).getTestPicturePath() != null) {
                        primary_wireFiveTestPicturePath = WireData.getInstance().primary_wireFive.get(i).getTestPicturePath();
                        primary_wireFiveTestPicturePath = primary_wireFiveTestPicturePath.substring(primary_wireFiveTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().primary_wireFive.get(i).getTestType() != null && WireData.getInstance().primary_wireFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireFive.get(i).getTestPicturePath() != null) {
                        primary_wireFiveTestPicturePath = WireData.getInstance().primary_wireFive.get(i).getTestPicturePath();
                        primary_wireFiveTestPicturePath = primary_wireFiveTestPicturePath.substring(primary_wireFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireFive.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireFive.put(WireData.getInstance().primary_wireFive.get(i).getTestingType(), WireData.getInstance().primary_wireFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireFive.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireFive.put(WireData.getInstance().primary_wireFive.get(i).getTestingTypePass(), WireData.getInstance().primary_wireFive.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (WireData.getInstance().primary_wireFive.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireFive.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireFive.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireFive.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireFive.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireFive.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireFive.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireFive.get(i).getNote();
                        if (WireData.getInstance().primary_wireFive.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireFive.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireFive.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireFive.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireFive.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireFive.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireFive.get(i).getTitle();
                    if (WireData.getInstance().primary_wireFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireFive.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireFive.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireFive.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireFive.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailsprimary_wireFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireFive;
    }

    public JSONObject readprimary_wireSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireSix != null && WireData.getInstance().primary_wireSix.size() > 0) {
            if (damageDetailsprimary_wireSix == null)
                damageDetailsprimary_wireSix = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireSix.size(); i++) {
                    if (WireData.getInstance().primary_wireSix.get(i).getPicturePath() != null) {
                        primary_wireSixPicturePath = WireData.getInstance().primary_wireSix.get(i).getPicturePath();
//                        primary_wireSixPicturePath = primary_wireSixPicturePath.substring(primary_wireSixPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().primary_wireSix.get(i).getTestPicturePath() != null) {
                        primary_wireSixTestPicturePath = WireData.getInstance().primary_wireSix.get(i).getTestPicturePath();
                        primary_wireSixTestPicturePath = primary_wireSixTestPicturePath.substring(primary_wireSixTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().primary_wireSix.get(i).getTestType() != null && WireData.getInstance().primary_wireSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireSix.get(i).getTestPicturePath() != null) {
                        primary_wireSixTestPicturePath = WireData.getInstance().primary_wireSix.get(i).getTestPicturePath();
                        primary_wireSixTestPicturePath = primary_wireSixTestPicturePath.substring(primary_wireSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireSix.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireSix.put(WireData.getInstance().primary_wireSix.get(i).getTestingType(), WireData.getInstance().primary_wireSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireSix.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireSix.put(WireData.getInstance().primary_wireSix.get(i).getTestingTypePass(), WireData.getInstance().primary_wireSix.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().primary_wireSix.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireSix.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireSix.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireSix.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireSix.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireSix.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireSix.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireSix.get(i).getNote();
                        if (WireData.getInstance().primary_wireSix.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireSix.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireSix.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireSix.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireSix.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireSix.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireSix.get(i).getTitle();
                    if (WireData.getInstance().primary_wireSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireSix.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireSix.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireSix.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireSix.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsprimary_wireSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireSix;
    }

    public JSONObject readprimary_wireSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireSeven != null && WireData.getInstance().primary_wireSeven.size() > 0) {
            if (damageDetailsprimary_wireSeven == null)
                damageDetailsprimary_wireSeven = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireSeven.size(); i++) {
                    if (WireData.getInstance().primary_wireSeven.get(i).getPicturePath() != null) {
                        primary_wireSevenPicturePath = WireData.getInstance().primary_wireSeven.get(i).getPicturePath();
//                        primary_wireSevenPicturePath = primary_wireSevenPicturePath.substring(primary_wireSevenPicturePath.lastIndexOf("/") + 1);
                    }

                   /* if (WireData.getInstance().primary_wireSeven.get(i).getTestPicturePath() != null) {
                        primary_wireSevenTestPicturePath = WireData.getInstance().primary_wireSeven.get(i).getTestPicturePath();
                        primary_wireSevenTestPicturePath = primary_wireSevenTestPicturePath.substring(primary_wireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().primary_wireSeven.get(i).getTestType() != null && WireData.getInstance().primary_wireSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireSeven.get(i).getTestPicturePath() != null) {
                        primary_wireSevenTestPicturePath = WireData.getInstance().primary_wireSeven.get(i).getTestPicturePath();
                        primary_wireSevenTestPicturePath = primary_wireSevenTestPicturePath.substring(primary_wireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireSeven.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireSeven.put(WireData.getInstance().primary_wireSeven.get(i).getTestingType(), WireData.getInstance().primary_wireSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireSeven.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireSeven.put(WireData.getInstance().primary_wireSeven.get(i).getTestingTypePass(), WireData.getInstance().primary_wireSeven.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (WireData.getInstance().primary_wireSeven.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireSeven.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireSeven.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireSeven.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireSeven.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireSeven.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireSeven.get(i).getNote();
                        if (WireData.getInstance().primary_wireSeven.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireSeven.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireSeven.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireSeven.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireSeven.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireSeven.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireSeven.get(i).getTitle();
                    if (WireData.getInstance().primary_wireSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireSeven.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireSeven.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireSeven.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireSeven.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsprimary_wireSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireSeven;
    }

    public JSONObject readprimary_wireEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireEight != null && WireData.getInstance().primary_wireEight.size() > 0) {
            if (damageDetailsprimary_wireEight == null)
                damageDetailsprimary_wireEight = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireEight.size(); i++) {
                    if (WireData.getInstance().primary_wireEight.get(i).getPicturePath() != null) {
                        primary_wireEightPicturePath = WireData.getInstance().primary_wireEight.get(i).getPicturePath();
//                        primary_wireEightPicturePath = primary_wireEightPicturePath.substring(primary_wireEightPicturePath.lastIndexOf("/") + 1);
                    }

                   /* if (WireData.getInstance().primary_wireEight.get(i).getTestPicturePath() != null) {
                        primary_wireEightTestPicturePath = WireData.getInstance().primary_wireEight.get(i).getTestPicturePath();
                        primary_wireEightTestPicturePath = primary_wireEightTestPicturePath.substring(primary_wireEightTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().primary_wireEight.get(i).getTestType() != null && WireData.getInstance().primary_wireEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireEight.get(i).getTestPicturePath() != null) {
                        primary_wireEightTestPicturePath = WireData.getInstance().primary_wireEight.get(i).getTestPicturePath();
                        primary_wireEightTestPicturePath = primary_wireEightTestPicturePath.substring(primary_wireEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireEight.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireEight.put(WireData.getInstance().primary_wireEight.get(i).getTestingType(), WireData.getInstance().primary_wireEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireEight.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireEight.put(WireData.getInstance().primary_wireEight.get(i).getTestingTypePass(), WireData.getInstance().primary_wireEight.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (WireData.getInstance().primary_wireEight.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireEight.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireEight.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireEight.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireEight.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireEight.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireEight.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireEight.get(i).getNote();
                        if (WireData.getInstance().primary_wireEight.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireEight.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireEight.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireEight.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireEight.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireEight.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireEight.get(i).getTitle();
                    if (WireData.getInstance().primary_wireEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireEight.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireEight.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireEight.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireEight.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsprimary_wireEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireEight;
    }

    public JSONObject readprimary_wireNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireNine != null && WireData.getInstance().primary_wireNine.size() > 0) {
            if (damageDetailsprimary_wireNine == null)
                damageDetailsprimary_wireNine = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireNine.size(); i++) {
                    if (WireData.getInstance().primary_wireNine.get(i).getPicturePath() != null) {
                        primary_wireNinePicturePath = WireData.getInstance().primary_wireNine.get(i).getPicturePath();
//                        primary_wireNinePicturePath = primary_wireNinePicturePath.substring(primary_wireNinePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().primary_wireNine.get(i).getTestPicturePath() != null) {
                        primary_wireNineTestPicturePath = WireData.getInstance().primary_wireNine.get(i).getTestPicturePath();
                        primary_wireNineTestPicturePath = primary_wireNineTestPicturePath.substring(primary_wireNineTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().primary_wireNine.get(i).getTestType() != null && WireData.getInstance().primary_wireNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireNine.get(i).getTestPicturePath() != null) {
                        primary_wireNineTestPicturePath = WireData.getInstance().primary_wireNine.get(i).getTestPicturePath();
                        primary_wireNineTestPicturePath = primary_wireNineTestPicturePath.substring(primary_wireNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireNine.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireNine.put(WireData.getInstance().primary_wireNine.get(i).getTestingType(), WireData.getInstance().primary_wireNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireNine.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireNine.put(WireData.getInstance().primary_wireNine.get(i).getTestingTypePass(), WireData.getInstance().primary_wireNine.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (WireData.getInstance().primary_wireNine.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireNine.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireNine.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireNine.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireNine.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireNine.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireNine.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireNine.get(i).getNote();
                        if (WireData.getInstance().primary_wireNine.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireNine.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireNine.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireNine.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireNine.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireNine.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireNine.get(i).getTitle();
                    if (WireData.getInstance().primary_wireNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireNine.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireNine.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireNine.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireNine.get(i).getName();
                        if (isSelected) {
                            //   displayName = displayName.replaceAll("\\s", "");
                            //   displayName = "is" + displayName;
                            damageDetailsprimary_wireNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireNine;
    }

    public JSONObject readprimary_wireTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().primary_wireTen != null && WireData.getInstance().primary_wireTen.size() > 0) {
            if (damageDetailsprimary_wireTen == null)
                damageDetailsprimary_wireTen = null;
            try {
                for (int i = 0; i < WireData.getInstance().primary_wireTen.size(); i++) {
                    if (WireData.getInstance().primary_wireTen.get(i).getPicturePath() != null) {
                        primary_wireTenPicturePath = WireData.getInstance().primary_wireTen.get(i).getPicturePath();
//                        primary_wireTenPicturePath = primary_wireTenPicturePath.substring(primary_wireTenPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (WireData.getInstance().primary_wireTen.get(i).getTestPicturePath() != null) {
                        primary_wireTenTestPicturePath = WireData.getInstance().primary_wireTen.get(i).getTestPicturePath();
                        primary_wireTenTestPicturePath = primary_wireTenTestPicturePath.substring(primary_wireTenPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().primary_wireTen.get(i).getTestType() != null && WireData.getInstance().primary_wireTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().primary_wireTen.get(i).getTestPicturePath() != null) {
                        primary_wireTenTestPicturePath = WireData.getInstance().primary_wireTen.get(i).getTestPicturePath();
                        primary_wireTenTestPicturePath = primary_wireTenTestPicturePath.substring(primary_wireTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().primary_wireTen.get(i).getTestingType() != null) {
                        if (WireData.getInstance().primary_wireTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsprimary_wireTen.put(WireData.getInstance().primary_wireTen.get(i).getTestingType(), WireData.getInstance().primary_wireTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().primary_wireTen.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().primary_wireTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsprimary_wireTen.put(WireData.getInstance().primary_wireTen.get(i).getTestingTypePass(), WireData.getInstance().primary_wireTen.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().primary_wireTen.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().primary_wireTen.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().primary_wireTen.get(i).getKvaSize();
                        if (WireData.getInstance().primary_wireTen.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireTen.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().primary_wireTen.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().primary_wireTen.get(i).getSubTitle();
                        addNote = WireData.getInstance().primary_wireTen.get(i).getNote();
                        if (WireData.getInstance().primary_wireTen.get(i).getSubTitle() != null) {
                            damageDetailsprimary_wireTen.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().primary_wireTen.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().primary_wireTen.get(i).getSubTitle();
                        isChecked = WireData.getInstance().primary_wireTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsprimary_wireTen.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().primary_wireTen.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().primary_wireTen.get(i).getTitle();
                    if (WireData.getInstance().primary_wireTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().primary_wireTen.get(i).getDisplayName());
                    if (WireData.getInstance().primary_wireTen.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().primary_wireTen.get(i).getIsSelected();
                        displayName = WireData.getInstance().primary_wireTen.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailsprimary_wireTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsprimary_wireTen;
    }

    public JSONObject readsecondary_wireOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireOne != null && WireData.getInstance().secondary_wireOne.size() > 0) {
            if (damageDetailssecondary_wireOne == null)
                damageDetailssecondary_wireOne = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireOne.size(); i++) {
                    if (WireData.getInstance().secondary_wireOne.get(i).getPicturePath() != null) {
                        secondary_wireOnePicturePath = WireData.getInstance().secondary_wireOne.get(i).getPicturePath();
//                        secondary_wireOnePicturePath = secondary_wireOnePicturePath.substring(secondary_wireOnePicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().secondary_wireOne.get(i).getTestPicturePath() != null) {
                        secondary_wireOneTestPicturePath = WireData.getInstance().secondary_wireOne.get(i).getTestPicturePath();
                        secondary_wireOneTestPicturePath = secondary_wireOneTestPicturePath.substring(secondary_wireOneTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().secondary_wireOne.get(i).getTestType() != null && WireData.getInstance().secondary_wireOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireOne.get(i).getTestPicturePath() != null) {
                        secondary_wireOneTestPicturePath = WireData.getInstance().secondary_wireOne.get(i).getTestPicturePath();
                        secondary_wireOneTestPicturePath = secondary_wireOneTestPicturePath.substring(secondary_wireOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireOne.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireOne.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireOne.put(WireData.getInstance().secondary_wireOne.get(i).getTestingType(), WireData.getInstance().secondary_wireOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireOne.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireOne.put(WireData.getInstance().secondary_wireOne.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireOne.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (WireData.getInstance().secondary_wireOne.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireOne.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireOne.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireOne.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireOne.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireOne.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireOne.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireOne.get(i).getNote();
                        if (WireData.getInstance().secondary_wireOne.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireOne.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireOne.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireOne.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireOne.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireOne.get(i).getTitle() != null)
                        secondary_wireTitle = WireData.getInstance().secondary_wireOne.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireOne.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireOne.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireOne.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireOne.get(i).getName();
                        if (isSelected) {
                            //displayName = displayName.replaceAll("\\s", "");
                            //displayName = "is" + displayName;
                            damageDetailssecondary_wireOne.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireOne;
    }

    public JSONObject readsecondary_wireTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireTwo != null && WireData.getInstance().secondary_wireTwo.size() > 0) {
            if (damageDetailssecondary_wireTwo == null)
                damageDetailssecondary_wireTwo = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireTwo.size(); i++) {

                    if (WireData.getInstance().secondary_wireTwo.get(i).getPicturePath() != null) {
                        secondary_wireTwoPicturePath = WireData.getInstance().secondary_wireTwo.get(i).getPicturePath();
//                        secondary_wireTwoPicturePath = secondary_wireTwoPicturePath.substring(secondary_wireTwoPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().secondary_wireTwo.get(i).getTestPicturePath() != null) {
                        secondary_wireTwoTestPicturePath = WireData.getInstance().secondary_wireTwo.get(i).getTestPicturePath();
                        secondary_wireTwoTestPicturePath = secondary_wireTwoTestPicturePath.substring(secondary_wireTwoTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().secondary_wireTwo.get(i).getTestType() != null && WireData.getInstance().secondary_wireTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireTwo.get(i).getTestPicturePath() != null) {
                        secondary_wireTwoTestPicturePath = WireData.getInstance().secondary_wireTwo.get(i).getTestPicturePath();
                        secondary_wireTwoTestPicturePath = secondary_wireTwoTestPicturePath.substring(secondary_wireTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireTwo.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireTwo.put(WireData.getInstance().secondary_wireTwo.get(i).getTestingType(), WireData.getInstance().secondary_wireTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireTwo.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireTwo.put(WireData.getInstance().secondary_wireTwo.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireTwo.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (WireData.getInstance().secondary_wireTwo.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireTwo.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireTwo.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireTwo.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireTwo.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireTwo.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireTwo.get(i).getNote();
                        if (WireData.getInstance().secondary_wireTwo.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireTwo.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireTwo.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireTwo.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireTwo.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireTwo.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireTwo.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireTwo.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireTwo.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireTwo.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireTwo.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailssecondary_wireTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireTwo;
    }

    public JSONObject readsecondary_wireThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireThree != null && WireData.getInstance().secondary_wireThree.size() > 0) {
            if (damageDetailssecondary_wireThree == null)
                damageDetailssecondary_wireThree = new JSONObject();

            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireThree.size(); i++) {
                    if (WireData.getInstance().secondary_wireThree.get(i).getPicturePath() != null) {
                        secondary_wireThreePicturePath = WireData.getInstance().secondary_wireThree.get(i).getPicturePath();
//                        secondary_wireThreePicturePath = secondary_wireThreePicturePath.substring(secondary_wireThreePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().secondary_wireThree.get(i).getTestPicturePath() != null) {
                        secondary_wireThreeTestPicturePath = WireData.getInstance().secondary_wireThree.get(i).getTestPicturePath();
                        secondary_wireThreeTestPicturePath = secondary_wireThreeTestPicturePath.substring(secondary_wireThreeTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().secondary_wireThree.get(i).getTestType() != null && WireData.getInstance().secondary_wireThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireThree.get(i).getTestPicturePath() != null) {
                        secondary_wireThreeTestPicturePath = WireData.getInstance().secondary_wireThree.get(i).getTestPicturePath();
                        secondary_wireThreeTestPicturePath = secondary_wireThreeTestPicturePath.substring(secondary_wireThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireThree.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireThree.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireThree.put(WireData.getInstance().secondary_wireThree.get(i).getTestingType(), WireData.getInstance().secondary_wireThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireThree.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireThree.put(WireData.getInstance().secondary_wireThree.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireThree.get(i).getIsTesstingPassResult());
                        }
                    }




                    if (WireData.getInstance().secondary_wireThree.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireThree.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireThree.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireThree.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireThree.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireThree.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireThree.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireThree.get(i).getNote();
                        if (WireData.getInstance().secondary_wireThree.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireThree.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireThree.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireThree.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireThree.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireThree.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireThree.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireThree.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireThree.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireThree.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireThree.get(i).getName();
                        if (isSelected) {
                            //   displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailssecondary_wireThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireThree;
    }

    public JSONObject readsecondary_wireFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireFour != null && WireData.getInstance().secondary_wireFour.size() > 0) {
            if (damageDetailssecondary_wireFour == null)
                damageDetailssecondary_wireFour = new JSONObject();

            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireFour.size(); i++) {
                    if (WireData.getInstance().secondary_wireFour.get(i).getPicturePath() != null) {
                        secondary_wireFourPicturePath = WireData.getInstance().secondary_wireFour.get(i).getPicturePath();
//                        secondary_wireFourPicturePath = secondary_wireFourPicturePath.substring(secondary_wireFourPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (WireData.getInstance().secondary_wireFour.get(i).getTestPicturePath() != null) {
                        secondary_wireFourTestPicturePath = WireData.getInstance().secondary_wireFour.get(i).getTestPicturePath();
                        secondary_wireFourTestPicturePath = secondary_wireFourTestPicturePath.substring(secondary_wireFourTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().secondary_wireFour.get(i).getTestType() != null && WireData.getInstance().secondary_wireFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireFour.get(i).getTestPicturePath() != null) {
                        secondary_wireFourTestPicturePath = WireData.getInstance().secondary_wireFour.get(i).getTestPicturePath();
                        secondary_wireFourTestPicturePath = secondary_wireFourTestPicturePath.substring(secondary_wireFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireFour.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireFour.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireFour.put(WireData.getInstance().secondary_wireFour.get(i).getTestingType(), WireData.getInstance().secondary_wireFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireFour.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireFour.put(WireData.getInstance().secondary_wireFour.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireFour.get(i).getIsTesstingPassResult());
                        }
                    }





                    if (WireData.getInstance().secondary_wireFour.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireFour.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireFour.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireFour.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireFour.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireFour.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireFour.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireFour.get(i).getNote();
                        if (WireData.getInstance().secondary_wireFour.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireFour.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireFour.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireFour.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireFour.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireFour.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireFour.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireFour.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireFour.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireFour.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireFour.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailssecondary_wireFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireFour;
    }

    public JSONObject readsecondary_wireFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireFive != null && WireData.getInstance().secondary_wireFive.size() > 0) {
            if (damageDetailssecondary_wireFive == null)
                damageDetailssecondary_wireFive = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireFive.size(); i++) {
                    if (WireData.getInstance().secondary_wireFive.get(i).getPicturePath() != null) {
                        secondary_wireFivePicturePath = WireData.getInstance().secondary_wireFive.get(i).getPicturePath();
//                        secondary_wireFivePicturePath = secondary_wireFivePicturePath.substring(secondary_wireFivePicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (WireData.getInstance().secondary_wireFive.get(i).getTestPicturePath() != null) {
                        secondary_wireFiveTestPicturePath = WireData.getInstance().secondary_wireFive.get(i).getTestPicturePath();
                        secondary_wireFiveTestPicturePath = secondary_wireFiveTestPicturePath.substring(secondary_wireFiveTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().secondary_wireFive.get(i).getTestType() != null && WireData.getInstance().secondary_wireFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireFive.get(i).getTestPicturePath() != null) {
                        secondary_wireFiveTestPicturePath = WireData.getInstance().secondary_wireFive.get(i).getTestPicturePath();
                        secondary_wireFiveTestPicturePath = secondary_wireFiveTestPicturePath.substring(secondary_wireFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireFive.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireFive.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireFive.put(WireData.getInstance().secondary_wireFive.get(i).getTestingType(), WireData.getInstance().secondary_wireFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireFive.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireFive.put(WireData.getInstance().secondary_wireFive.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireFive.get(i).getIsTesstingPassResult());
                        }
                    }





                    if (WireData.getInstance().secondary_wireFive.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireFive.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireFive.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireFive.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireFive.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireFive.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireFive.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireFive.get(i).getNote();
                        if (WireData.getInstance().secondary_wireFive.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireFive.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireFive.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireFive.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireFive.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireFive.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireFive.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireFive.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireFive.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireFive.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireFive.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailssecondary_wireFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireFive;
    }

    public JSONObject readsecondary_wireSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireSix != null && WireData.getInstance().secondary_wireSix.size() > 0) {

            if (damageDetailssecondary_wireSix == null)
                damageDetailssecondary_wireSix = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireSix.size(); i++) {
                    if (WireData.getInstance().secondary_wireSix.get(i).getPicturePath() != null) {
                        secondary_wireSixPicturePath = WireData.getInstance().secondary_wireSix.get(i).getPicturePath();
//                        secondary_wireSixPicturePath = secondary_wireSixPicturePath.substring(secondary_wireSixPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().secondary_wireSix.get(i).getTestPicturePath() != null) {
                        secondary_wireSixTestPicturePath = WireData.getInstance().secondary_wireSix.get(i).getTestPicturePath();
                        secondary_wireSixTestPicturePath = secondary_wireSixTestPicturePath.substring(secondary_wireSixTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().secondary_wireSix.get(i).getTestType() != null && WireData.getInstance().secondary_wireSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireSix.get(i).getTestPicturePath() != null) {
                        secondary_wireSixTestPicturePath = WireData.getInstance().secondary_wireSix.get(i).getTestPicturePath();
                        secondary_wireSixTestPicturePath = secondary_wireSixTestPicturePath.substring(secondary_wireSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireSix.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireSix.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireSix.put(WireData.getInstance().secondary_wireSix.get(i).getTestingType(), WireData.getInstance().secondary_wireSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireSix.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireSix.put(WireData.getInstance().secondary_wireSix.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireSix.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (WireData.getInstance().secondary_wireSix.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireSix.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireSix.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireSix.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireSix.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireSix.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireSix.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireSix.get(i).getNote();
                        if (WireData.getInstance().secondary_wireSix.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireSix.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireSix.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireSix.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireSix.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireSix.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireSix.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireSix.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireSix.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireSix.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireSix.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailssecondary_wireSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireSix;
    }

    public JSONObject readsecondary_wireSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireSeven != null && WireData.getInstance().secondary_wireSeven.size() > 0) {
            if (damageDetailssecondary_wireSeven == null)
                damageDetailssecondary_wireSeven = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireSeven.size(); i++) {
                    if (WireData.getInstance().secondary_wireSeven.get(i).getPicturePath() != null) {
                        secondary_wireSevenPicturePath = WireData.getInstance().secondary_wireSeven.get(i).getPicturePath();
//                        secondary_wireSevenPicturePath = secondary_wireSevenPicturePath.substring(secondary_wireSevenPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (WireData.getInstance().secondary_wireSeven.get(i).getTestPicturePath() != null) {
                        secondary_wireSevenTestPicturePath = WireData.getInstance().secondary_wireSeven.get(i).getTestPicturePath();
                        secondary_wireSevenTestPicturePath = secondary_wireSevenTestPicturePath.substring(secondary_wireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/
                    if (WireData.getInstance().secondary_wireSeven.get(i).getTestType() != null && WireData.getInstance().secondary_wireSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireSeven.get(i).getTestPicturePath() != null) {
                        secondary_wireSevenTestPicturePath = WireData.getInstance().secondary_wireSeven.get(i).getTestPicturePath();
                        secondary_wireSevenTestPicturePath = secondary_wireSevenTestPicturePath.substring(secondary_wireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireSeven.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireSeven.put(WireData.getInstance().secondary_wireSeven.get(i).getTestingType(), WireData.getInstance().secondary_wireSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireSeven.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireSeven.put(WireData.getInstance().secondary_wireSeven.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireSeven.get(i).getIsTesstingPassResult());
                        }
                    }



                    if (WireData.getInstance().secondary_wireSeven.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireSeven.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireSeven.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireSeven.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireSeven.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireSeven.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireSeven.get(i).getNote();
                        if (WireData.getInstance().secondary_wireSeven.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireSeven.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireSeven.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireSeven.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireSeven.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireSeven.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireSeven.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireSeven.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireSeven.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireSeven.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireSeven.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailssecondary_wireSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireSeven;
    }

    public JSONObject readsecondary_wireEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireEight != null && WireData.getInstance().secondary_wireEight.size() > 0) {
            if (damageDetailssecondary_wireEight == null)
                damageDetailssecondary_wireEight = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireEight.size(); i++) {
                    if (WireData.getInstance().secondary_wireEight.get(i).getPicturePath() != null) {
                        secondary_wireEightPicturePath = WireData.getInstance().secondary_wireEight.get(i).getPicturePath();
//                        secondary_wireEightPicturePath = secondary_wireEightPicturePath.substring(secondary_wireEightPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (WireData.getInstance().secondary_wireEight.get(i).getTestPicturePath() != null) {
                        secondary_wireEightTestPicturePath = WireData.getInstance().secondary_wireEight.get(i).getTestPicturePath();
                        secondary_wireEightTestPicturePath = secondary_wireEightTestPicturePath.substring(secondary_wireEightTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().secondary_wireEight.get(i).getTestType() != null && WireData.getInstance().secondary_wireEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireEight.get(i).getTestPicturePath() != null) {
                        secondary_wireEightTestPicturePath = WireData.getInstance().secondary_wireEight.get(i).getTestPicturePath();
                        secondary_wireEightTestPicturePath = secondary_wireEightTestPicturePath.substring(secondary_wireEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireEight.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireEight.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireEight.put(WireData.getInstance().secondary_wireEight.get(i).getTestingType(), WireData.getInstance().secondary_wireEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireEight.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireEight.put(WireData.getInstance().secondary_wireEight.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireEight.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().secondary_wireEight.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireEight.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireEight.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireEight.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireEight.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireEight.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireEight.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireEight.get(i).getNote();
                        if (WireData.getInstance().secondary_wireEight.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireEight.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireEight.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireEight.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireEight.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireEight.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireEight.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireEight.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireEight.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireEight.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireEight.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailssecondary_wireEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireEight;
    }

    public JSONObject readsecondary_wireNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireNine != null && WireData.getInstance().secondary_wireNine.size() > 0) {
            if (damageDetailssecondary_wireNine == null)
                damageDetailssecondary_wireNine = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireNine.size(); i++) {
                    if (WireData.getInstance().secondary_wireNine.get(i).getPicturePath() != null) {
                        secondary_wireNinePicturePath = WireData.getInstance().secondary_wireNine.get(i).getPicturePath();
//                        secondary_wireNinePicturePath = secondary_wireNinePicturePath.substring(secondary_wireNinePicturePath.lastIndexOf("/") + 1);
                    }
                    /*if (WireData.getInstance().secondary_wireNine.get(i).getTestPicturePath() != null) {
                        secondary_wireNineTestPicturePath = WireData.getInstance().secondary_wireNine.get(i).getTestPicturePath();
                        secondary_wireNineTestPicturePath = secondary_wireNineTestPicturePath.substring(secondary_wireNineTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().secondary_wireNine.get(i).getTestType() != null && WireData.getInstance().secondary_wireNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireNine.get(i).getTestPicturePath() != null) {
                        secondary_wireNineTestPicturePath = WireData.getInstance().secondary_wireNine.get(i).getTestPicturePath();
                        secondary_wireNineTestPicturePath = secondary_wireNineTestPicturePath.substring(secondary_wireNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireNine.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireNine.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireNine.put(WireData.getInstance().secondary_wireNine.get(i).getTestingType(), WireData.getInstance().secondary_wireNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireNine.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireNine.put(WireData.getInstance().secondary_wireNine.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireNine.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().secondary_wireNine.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireNine.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireNine.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireNine.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireNine.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireNine.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireNine.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireNine.get(i).getNote();
                        if (WireData.getInstance().secondary_wireNine.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireNine.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireNine.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireNine.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireNine.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireNine.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireNine.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireNine.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireNine.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireNine.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireNine.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailssecondary_wireNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireNine;
    }

    public JSONObject readsecondary_wireTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().secondary_wireTen != null && WireData.getInstance().secondary_wireTen.size() > 0) {
            if (damageDetailssecondary_wireTen == null)
                damageDetailssecondary_wireTen = null;
            try {
                for (int i = 0; i < WireData.getInstance().secondary_wireTen.size(); i++) {
                    secondary_wireTenPicturePath = WireData.getInstance().secondary_wireTen.get(i).getPicturePath();
                    if (WireData.getInstance().secondary_wireTen.get(i).getPicturePath() != null) {
//                        secondary_wireTenPicturePath = secondary_wireTenPicturePath.substring(secondary_wireTenPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().secondary_wireTen.get(i).getTestPicturePath() != null) {
                        secondary_wireTenTestPicturePath = WireData.getInstance().secondary_wireTen.get(i).getTestPicturePath();
                        secondary_wireTenTestPicturePath = secondary_wireTenTestPicturePath.substring(secondary_wireTenPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().secondary_wireTen.get(i).getTestType() != null && WireData.getInstance().secondary_wireTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().secondary_wireTen.get(i).getTestPicturePath() != null) {
                        secondary_wireTenTestPicturePath = WireData.getInstance().secondary_wireTen.get(i).getTestPicturePath();
                        secondary_wireTenTestPicturePath = secondary_wireTenTestPicturePath.substring(secondary_wireTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().secondary_wireTen.get(i).getTestingType() != null) {
                        if (WireData.getInstance().secondary_wireTen.get(i).getIsTesttingResult() != null) {
                            damageDetailssecondary_wireTen.put(WireData.getInstance().secondary_wireTen.get(i).getTestingType(), WireData.getInstance().secondary_wireTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().secondary_wireTen.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().secondary_wireTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailssecondary_wireTen.put(WireData.getInstance().secondary_wireTen.get(i).getTestingTypePass(), WireData.getInstance().secondary_wireTen.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().secondary_wireTen.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().secondary_wireTen.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().secondary_wireTen.get(i).getKvaSize();
                        if (WireData.getInstance().secondary_wireTen.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireTen.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().secondary_wireTen.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().secondary_wireTen.get(i).getSubTitle();
                        addNote = WireData.getInstance().secondary_wireTen.get(i).getNote();
                        if (WireData.getInstance().secondary_wireTen.get(i).getSubTitle() != null) {
                            damageDetailssecondary_wireTen.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().secondary_wireTen.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().secondary_wireTen.get(i).getSubTitle();
                        isChecked = WireData.getInstance().secondary_wireTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailssecondary_wireTen.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().secondary_wireTen.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().secondary_wireTen.get(i).getTitle();
                    if (WireData.getInstance().secondary_wireTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().secondary_wireTen.get(i).getDisplayName());
                    if (WireData.getInstance().secondary_wireTen.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().secondary_wireTen.get(i).getIsSelected();
                        displayName = WireData.getInstance().secondary_wireTen.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailssecondary_wireTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailssecondary_wireTen;
    }

    public JSONObject readservice_wireOneData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireOne != null && WireData.getInstance().service_wireOne.size() > 0) {
            if (damageDetailsservice_wireOne == null)
                damageDetailsservice_wireOne = new JSONObject();

            try {
                for (int i = 0; i < WireData.getInstance().service_wireOne.size(); i++) {
                    if (WireData.getInstance().service_wireOne.get(i).getPicturePath() != null) {
                        service_wireOnePicturePath = WireData.getInstance().service_wireOne.get(i).getPicturePath();
//                        service_wireOnePicturePath = service_wireOnePicturePath.substring(service_wireOnePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().service_wireOne.get(i).getTestPicturePath() != null) {
                        service_wireOneTestPicturePath = WireData.getInstance().service_wireOne.get(i).getTestPicturePath();
                        service_wireOneTestPicturePath = service_wireOneTestPicturePath.substring(service_wireOneTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().service_wireOne.get(i).getTestType() != null && WireData.getInstance().service_wireOne.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireOne.get(i).getTestPicturePath() != null) {
                        service_wireOneTestPicturePath = WireData.getInstance().service_wireOne.get(i).getTestPicturePath();
                        service_wireOneTestPicturePath = service_wireOneTestPicturePath.substring(service_wireOneTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireOne.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireOne.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireOne.put(WireData.getInstance().service_wireOne.get(i).getTestingType(), WireData.getInstance().service_wireOne.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireOne.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireOne.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireOne.put(WireData.getInstance().service_wireOne.get(i).getTestingTypePass(), WireData.getInstance().service_wireOne.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().service_wireOne.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireOne.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireOne.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireOne.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireOne.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireOne.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireOne.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireOne.get(i).getNote();
                        if (WireData.getInstance().service_wireOne.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireOne.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireOne.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireOne.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireOne.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireOne.get(i).getTitle() != null)
                        service_wireTitle = WireData.getInstance().service_wireOne.get(i).getTitle();
                    if (WireData.getInstance().service_wireOne.get(i).getDisplayName() != null)
                        if (WireData.getInstance().service_wireOne.get(i).getIsSelected() != null) {
                            //  Log.i("VIDISHA_LOG", "Display Name = " + WireData.getInstance().service_wireOne.get(i).getDisplayName()+"name--"+WireData.getInstance().service_wireOne.get(i).getName());

                            isSelected = WireData.getInstance().service_wireOne.get(i).getIsSelected();
                            displayName = WireData.getInstance().service_wireOne.get(i).getName();
                            if (isSelected) {
                                //   displayName = displayName.replaceAll("\\s", "");
                                //   displayName = "is" + displayName;
                                damageDetailsservice_wireOne.put(displayName, isSelected);
                            }
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireOne;
    }

    public JSONObject readservice_wireTwoData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireTwo != null && WireData.getInstance().service_wireTwo.size() > 0) {
            if (damageDetailsservice_wireTwo == null)
                damageDetailsservice_wireTwo = new JSONObject();

            try {
                for (int i = 0; i < WireData.getInstance().service_wireTwo.size(); i++) {
                    if (WireData.getInstance().service_wireTwo.get(i).getPicturePath() != null) {
                        service_wireTwoPicturePath = WireData.getInstance().service_wireTwo.get(i).getPicturePath();
//                        service_wireTwoPicturePath = service_wireTwoPicturePath.substring(service_wireTwoPicturePath.lastIndexOf("/") + 1);
                    }
                 /*   if (WireData.getInstance().service_wireTwo.get(i).getTestPicturePath() != null) {
                        service_wireTwoTestPicturePath = WireData.getInstance().service_wireTwo.get(i).getTestPicturePath();
                        service_wireTwoTestPicturePath = service_wireTwoTestPicturePath.substring(service_wireTwoTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().service_wireTwo.get(i).getTestType() != null && WireData.getInstance().service_wireTwo.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireTwo.get(i).getTestPicturePath() != null) {
                        service_wireTwoTestPicturePath = WireData.getInstance().service_wireTwo.get(i).getTestPicturePath();
                        service_wireTwoTestPicturePath = service_wireTwoTestPicturePath.substring(service_wireTwoTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireTwo.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireTwo.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireTwo.put(WireData.getInstance().service_wireTwo.get(i).getTestingType(), WireData.getInstance().service_wireTwo.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireTwo.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireTwo.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireTwo.put(WireData.getInstance().service_wireTwo.get(i).getTestingTypePass(), WireData.getInstance().service_wireTwo.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (WireData.getInstance().service_wireTwo.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireTwo.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireTwo.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireTwo.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireTwo.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireTwo.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireTwo.get(i).getNote();
                        if (WireData.getInstance().service_wireTwo.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireTwo.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireTwo.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireTwo.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireTwo.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireTwo.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireTwo.get(i).getTitle();
                    if (WireData.getInstance().service_wireTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireTwo.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireTwo.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireTwo.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireTwo.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsservice_wireTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireTwo;
    }

    public JSONObject readservice_wireThreeData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireThree != null && WireData.getInstance().service_wireThree.size() > 0) {
            if (damageDetailsservice_wireThree == null)
                damageDetailsservice_wireThree = new JSONObject();

            try {
                for (int i = 0; i < WireData.getInstance().service_wireThree.size(); i++) {
                    if (WireData.getInstance().service_wireThree.get(i).getPicturePath() != null) {
                        service_wireThreePicturePath = WireData.getInstance().service_wireThree.get(i).getPicturePath();
//                        service_wireThreePicturePath = service_wireThreePicturePath.substring(service_wireThreePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().service_wireThree.get(i).getTestPicturePath() != null) {
                        service_wireThreeTestPicturePath = WireData.getInstance().service_wireThree.get(i).getTestPicturePath();
                        service_wireThreeTestPicturePath = service_wireThreeTestPicturePath.substring(service_wireThreeTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().service_wireThree.get(i).getTestType() != null && WireData.getInstance().service_wireThree.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireThree.get(i).getTestPicturePath() != null) {
                        service_wireThreeTestPicturePath = WireData.getInstance().service_wireThree.get(i).getTestPicturePath();
                        service_wireThreeTestPicturePath = service_wireThreeTestPicturePath.substring(service_wireThreeTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireThree.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireThree.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireThree.put(WireData.getInstance().service_wireThree.get(i).getTestingType(), WireData.getInstance().service_wireThree.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireThree.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireThree.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireThree.put(WireData.getInstance().service_wireThree.get(i).getTestingTypePass(), WireData.getInstance().service_wireThree.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().service_wireThree.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireThree.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireThree.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireThree.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireThree.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireThree.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireThree.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireThree.get(i).getNote();
                        if (WireData.getInstance().service_wireThree.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireThree.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireThree.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireThree.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireThree.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireThree.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireThree.get(i).getTitle();
                    if (WireData.getInstance().service_wireThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireThree.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireThree.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireThree.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireThree.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsservice_wireThree.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireThree;
    }

    public JSONObject readservice_wireFourData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireFour != null && WireData.getInstance().service_wireFour.size() > 0) {
            if (damageDetailsservice_wireFour == null)
                damageDetailsservice_wireFour = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().service_wireFour.size(); i++) {
                    if (WireData.getInstance().service_wireFour.get(i).getPicturePath() != null) {
                        service_wireFourPicturePath = WireData.getInstance().service_wireFour.get(i).getPicturePath();
//                        service_wireFourPicturePath = service_wireFourPicturePath.substring(service_wireFourPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().service_wireFour.get(i).getTestPicturePath() != null) {
                        service_wireFourTestPicturePath = WireData.getInstance().service_wireFour.get(i).getTestPicturePath();
                        service_wireFourTestPicturePath = service_wireFourTestPicturePath.substring(service_wireFourTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().service_wireFour.get(i).getTestType() != null && WireData.getInstance().service_wireFour.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireFour.get(i).getTestPicturePath() != null) {
                        service_wireFourTestPicturePath = WireData.getInstance().service_wireFour.get(i).getTestPicturePath();
                        service_wireFourTestPicturePath = service_wireFourTestPicturePath.substring(service_wireFourTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireFour.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireFour.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireFour.put(WireData.getInstance().service_wireFour.get(i).getTestingType(), WireData.getInstance().service_wireFour.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireFour.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireFour.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireFour.put(WireData.getInstance().service_wireFour.get(i).getTestingTypePass(), WireData.getInstance().service_wireFour.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (WireData.getInstance().service_wireFour.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireFour.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireFour.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireFour.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireFour.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireFour.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireFour.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireFour.get(i).getNote();
                        if (WireData.getInstance().service_wireFour.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireFour.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireFour.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireFour.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireFour.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireFour.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireFour.get(i).getTitle();
                    if (WireData.getInstance().service_wireFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireFour.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireFour.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireFour.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireFour.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsservice_wireFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireFour;
    }

    public JSONObject readservice_wireFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireFive != null && WireData.getInstance().service_wireFive.size() > 0) {
            if (damageDetailsservice_wireFive == null)
                damageDetailsservice_wireFive = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().service_wireFive.size(); i++) {
                    if (WireData.getInstance().service_wireFive.get(i).getPicturePath() != null) {
                        service_wireFivePicturePath = WireData.getInstance().service_wireFive.get(i).getPicturePath();
//                        service_wireFivePicturePath = service_wireFivePicturePath.substring(service_wireFivePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().service_wireFive.get(i).getTestPicturePath() != null) {
                        service_wireFiveTestPicturePath = WireData.getInstance().service_wireFive.get(i).getTestPicturePath();
                        service_wireFiveTestPicturePath = service_wireFiveTestPicturePath.substring(service_wireFiveTestPicturePath.lastIndexOf("/") + 1);
                    }*/


                    if (WireData.getInstance().service_wireFive.get(i).getTestType() != null && WireData.getInstance().service_wireFive.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireFive.get(i).getTestPicturePath() != null) {
                        service_wireFiveTestPicturePath = WireData.getInstance().service_wireFive.get(i).getTestPicturePath();
                        service_wireFiveTestPicturePath = service_wireFiveTestPicturePath.substring(service_wireFiveTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireFive.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireFive.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireFive.put(WireData.getInstance().service_wireFive.get(i).getTestingType(), WireData.getInstance().service_wireFive.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireFive.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireFive.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireFive.put(WireData.getInstance().service_wireFive.get(i).getTestingTypePass(), WireData.getInstance().service_wireFive.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (WireData.getInstance().service_wireFive.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireFive.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireFive.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireFive.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireFive.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireFive.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireFive.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireFive.get(i).getNote();
                        if (WireData.getInstance().service_wireFive.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireFive.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireFive.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireFive.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireFive.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireFive.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireFive.get(i).getTitle();
                    if (WireData.getInstance().service_wireFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireFive.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireFive.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireFive.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireFive.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsservice_wireFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireFive;
    }

    public JSONObject readservice_wireSixData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireSix != null && WireData.getInstance().service_wireSix.size() > 0) {
            if (damageDetailsservice_wireSix == null)
                damageDetailsservice_wireSix = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().service_wireSix.size(); i++) {
                    if (WireData.getInstance().service_wireSix.get(i).getPicturePath() != null) {
                        service_wireSixPicturePath = WireData.getInstance().service_wireSix.get(i).getPicturePath();
//                        service_wireSixPicturePath = service_wireSixPicturePath.substring(service_wireSixPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().service_wireSix.get(i).getTestPicturePath() != null) {
                        service_wireSixTestPicturePath = WireData.getInstance().service_wireSix.get(i).getTestPicturePath();
                        service_wireSixTestPicturePath = service_wireSixTestPicturePath.substring(service_wireSixTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().service_wireSix.get(i).getTestType() != null && WireData.getInstance().service_wireSix.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireSix.get(i).getTestPicturePath() != null) {
                        service_wireSixTestPicturePath = WireData.getInstance().service_wireSix.get(i).getTestPicturePath();
                        service_wireSixTestPicturePath = service_wireSixTestPicturePath.substring(service_wireSixTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireSix.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireSix.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireSix.put(WireData.getInstance().service_wireSix.get(i).getTestingType(), WireData.getInstance().service_wireSix.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireSix.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireSix.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireSix.put(WireData.getInstance().service_wireSix.get(i).getTestingTypePass(), WireData.getInstance().service_wireSix.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().service_wireSix.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireSix.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireSix.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireSix.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireSix.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireSix.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireSix.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireSix.get(i).getNote();
                        if (WireData.getInstance().service_wireSix.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireSix.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireSix.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireSix.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireSix.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireSix.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireSix.get(i).getTitle();
                    if (WireData.getInstance().service_wireSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireSix.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireSix.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireSix.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireSix.get(i).getName();
                        if (isSelected) {
                            //   displayName = displayName.replaceAll("\\s", "");
                            //    displayName = "is" + displayName;
                            damageDetailsservice_wireSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireSix;
    }

    public JSONObject readservice_wireSevenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireSeven != null && WireData.getInstance().service_wireSeven.size() > 0) {
            if (damageDetailsservice_wireSeven == null)
                damageDetailsservice_wireSeven = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().service_wireSeven.size(); i++) {
                    if (WireData.getInstance().service_wireSeven.get(i).getPicturePath() != null) {
                        service_wireSevenPicturePath = WireData.getInstance().service_wireSeven.get(i).getPicturePath();
//                        service_wireSevenPicturePath = service_wireSevenPicturePath.substring(service_wireSevenPicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().service_wireSeven.get(i).getTestPicturePath() != null) {
                        service_wireSevenTestPicturePath = WireData.getInstance().service_wireSeven.get(i).getTestPicturePath();
                        service_wireSevenTestPicturePath = service_wireSevenTestPicturePath.substring(service_wireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().service_wireSeven.get(i).getTestType() != null && WireData.getInstance().service_wireSeven.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireSeven.get(i).getTestPicturePath() != null) {
                        service_wireSevenTestPicturePath = WireData.getInstance().service_wireSeven.get(i).getTestPicturePath();
                        service_wireSevenTestPicturePath = service_wireSevenTestPicturePath.substring(service_wireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireSeven.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireSeven.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireSeven.put(WireData.getInstance().service_wireSeven.get(i).getTestingType(), WireData.getInstance().service_wireSeven.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireSeven.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireSeven.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireSeven.put(WireData.getInstance().service_wireSeven.get(i).getTestingTypePass(), WireData.getInstance().service_wireSeven.get(i).getIsTesstingPassResult());
                        }
                    }


                    if (WireData.getInstance().service_wireSeven.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireSeven.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireSeven.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireSeven.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireSeven.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireSeven.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireSeven.get(i).getNote();
                        if (WireData.getInstance().service_wireSeven.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireSeven.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireSeven.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireSeven.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireSeven.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireSeven.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireSeven.get(i).getTitle();
                    if (WireData.getInstance().service_wireSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireSeven.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireSeven.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireSeven.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireSeven.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailsservice_wireSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireSeven;
    }

    public JSONObject readservice_wireEightData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireEight != null && WireData.getInstance().service_wireEight.size() > 0) {
            if (damageDetailsservice_wireEight == null)
                damageDetailsservice_wireEight = new JSONObject();
            try {
                for (int i = 0; i < WireData.getInstance().service_wireEight.size(); i++) {
                    if (WireData.getInstance().service_wireEight.get(i).getPicturePath() != null) {
                        service_wireEightPicturePath = WireData.getInstance().service_wireEight.get(i).getPicturePath();
//                        service_wireEightPicturePath = service_wireEightPicturePath.substring(service_wireEightPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().service_wireSeven.get(i).getTestPicturePath() != null) {
                        service_wireSevenTestPicturePath = WireData.getInstance().service_wireSeven.get(i).getTestPicturePath();
                        service_wireSevenTestPicturePath = service_wireSevenTestPicturePath.substring(service_wireSevenTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().service_wireEight.get(i).getTestType() != null && WireData.getInstance().service_wireEight.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireEight.get(i).getTestPicturePath() != null) {
                        service_wireEightTestPicturePath = WireData.getInstance().service_wireEight.get(i).getTestPicturePath();
                        service_wireEightTestPicturePath = service_wireEightTestPicturePath.substring(service_wireEightTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireEight.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireEight.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireEight.put(WireData.getInstance().service_wireEight.get(i).getTestingType(), WireData.getInstance().service_wireEight.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireEight.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireEight.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireEight.put(WireData.getInstance().service_wireEight.get(i).getTestingTypePass(), WireData.getInstance().service_wireEight.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (WireData.getInstance().service_wireEight.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireEight.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireEight.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireEight.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireEight.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireEight.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireEight.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireEight.get(i).getNote();
                        if (WireData.getInstance().service_wireEight.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireEight.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireEight.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireEight.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireEight.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireEight.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireEight.get(i).getTitle();
                    if (WireData.getInstance().service_wireEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireEight.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireEight.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireEight.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireEight.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailsservice_wireEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireEight;
    }

    public JSONObject readservice_wireNineData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireNine != null && WireData.getInstance().service_wireNine.size() > 0) {
            if (damageDetailsservice_wireNine == null)
                damageDetailsservice_wireNine = new JSONObject();

            try {
                for (int i = 0; i < WireData.getInstance().service_wireNine.size(); i++) {

                    if (WireData.getInstance().service_wireNine.get(i).getPicturePath() != null) {
                        service_wireNinePicturePath = WireData.getInstance().service_wireNine.get(i).getPicturePath();
//                        service_wireNinePicturePath = service_wireNinePicturePath.substring(service_wireNinePicturePath.lastIndexOf("/") + 1);
                    }
                  /*  if (WireData.getInstance().service_wireNine.get(i).getTestPicturePath() != null) {
                        service_wireNineTestPicturePath = WireData.getInstance().service_wireNine.get(i).getTestPicturePath();
                        service_wireNineTestPicturePath = service_wireNineTestPicturePath.substring(service_wireNineTestPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().service_wireNine.get(i).getTestType() != null && WireData.getInstance().service_wireNine.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireNine.get(i).getTestPicturePath() != null) {
                        service_wireNineTestPicturePath = WireData.getInstance().service_wireNine.get(i).getTestPicturePath();
                        service_wireNineTestPicturePath = service_wireNineTestPicturePath.substring(service_wireNineTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireNine.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireNine.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireNine.put(WireData.getInstance().service_wireNine.get(i).getTestingType(), WireData.getInstance().service_wireNine.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireNine.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireNine.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireNine.put(WireData.getInstance().service_wireNine.get(i).getTestingTypePass(), WireData.getInstance().service_wireNine.get(i).getIsTesstingPassResult());
                        }
                    }
                    if (WireData.getInstance().service_wireNine.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireNine.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireNine.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireNine.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireNine.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireNine.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireNine.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireNine.get(i).getNote();
                        if (WireData.getInstance().service_wireNine.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireNine.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireNine.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireNine.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireNine.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireNine.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireNine.get(i).getTitle();
                    if (WireData.getInstance().service_wireNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireNine.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireNine.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireNine.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireNine.get(i).getName();
                        if (isSelected) {
                            // displayName = displayName.replaceAll("\\s", "");
                            //  displayName = "is" + displayName;
                            damageDetailsservice_wireNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireNine;
    }

    public JSONObject readservice_wireTenData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (WireData.getInstance().service_wireTen != null && WireData.getInstance().service_wireTen.size() > 0) {
            if (damageDetailsservice_wireTen == null)
                damageDetailsservice_wireTen = null;

            try {
                for (int i = 0; i < WireData.getInstance().service_wireTen.size(); i++) {
                    service_wireTenPicturePath = WireData.getInstance().service_wireTen.get(i).getPicturePath();
                    if (WireData.getInstance().service_wireTen.get(i).getPicturePath() != null) {
//                        service_wireTenPicturePath = service_wireTenPicturePath.substring(service_wireTenPicturePath.lastIndexOf("/") + 1);
                    }
                   /* if (WireData.getInstance().service_wireTen.get(i).getTestPicturePath() != null) {
                        service_wireTenTestPicturePath = WireData.getInstance().service_wireTen.get(i).getTestPicturePath();
                        service_wireTenTestPicturePath = service_wireTenTestPicturePath.substring(service_wireTenPicturePath.lastIndexOf("/") + 1);
                    }*/

                    if (WireData.getInstance().service_wireTen.get(i).getTestType() != null && WireData.getInstance().service_wireTen.get(i).getTestType().equalsIgnoreCase("Voltage Test")
                            && WireData.getInstance().service_wireTen.get(i).getTestPicturePath() != null) {
                        service_wireTenTestPicturePath = WireData.getInstance().service_wireTen.get(i).getTestPicturePath();
                        service_wireTenTestPicturePath = service_wireTenTestPicturePath.substring(service_wireTenTestPicturePath.lastIndexOf("/") + 1);
                    }
                    if (WireData.getInstance().service_wireTen.get(i).getTestingType() != null) {
                        if (WireData.getInstance().service_wireTen.get(i).getIsTesttingResult() != null) {
                            damageDetailsservice_wireTen.put(WireData.getInstance().service_wireTen.get(i).getTestingType(), WireData.getInstance().service_wireTen.get(i).getIsTesttingResult());
                        }
                    }
                    if (WireData.getInstance().service_wireTen.get(i).getTestingTypePass() != null) {
                        if (WireData.getInstance().service_wireTen.get(i).getIsTesstingPassResult() != null) {
                            damageDetailsservice_wireTen.put(WireData.getInstance().service_wireTen.get(i).getTestingTypePass(), WireData.getInstance().service_wireTen.get(i).getIsTesstingPassResult());
                        }
                    }

                    if (WireData.getInstance().service_wireTen.get(i).getKvaSize() != null) {
                        subtitle = WireData.getInstance().service_wireTen.get(i).getSubTitle();
                        kvaSize = WireData.getInstance().service_wireTen.get(i).getKvaSize();
                        if (WireData.getInstance().service_wireTen.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireTen.put(subtitle, kvaSize);
                        }
                    }
                    if (WireData.getInstance().service_wireTen.get(i).getNote() != null) {
                        subtitle = WireData.getInstance().service_wireTen.get(i).getSubTitle();
                        addNote = WireData.getInstance().service_wireTen.get(i).getNote();
                        if (WireData.getInstance().service_wireTen.get(i).getSubTitle() != null) {
                            damageDetailsservice_wireTen.put(subtitle, addNote);
                        }
                    }
                    if (WireData.getInstance().service_wireTen.get(i).getCheckedOK() != null) {
                        subtitle = WireData.getInstance().service_wireTen.get(i).getSubTitle();
                        isChecked = WireData.getInstance().service_wireTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsservice_wireTen.put(subtitle, isChecked);
                        }
                    }
                    if (WireData.getInstance().service_wireTen.get(i).getTitle() != null)
                        poleTitle = WireData.getInstance().service_wireTen.get(i).getTitle();
                    if (WireData.getInstance().service_wireTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + WireData.getInstance().service_wireTen.get(i).getDisplayName());
                    if (WireData.getInstance().service_wireTen.get(i).getIsSelected() != null) {
                        isSelected = WireData.getInstance().service_wireTen.get(i).getIsSelected();
                        displayName = WireData.getInstance().service_wireTen.get(i).getName();
                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            //   displayName = "is" + displayName;
                            damageDetailsservice_wireTen.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsservice_wireTen;
    }



    public void resetAllReference() {
        try {
            reserPictureName();
            WireData.getInstance().primary_wireOne.clear();
            WireData.getInstance().primary_wireTwo.clear();
            WireData.getInstance().primary_wireThree.clear();
            WireData.getInstance().primary_wireFour.clear();
            WireData.getInstance().primary_wireFive.clear();
            WireData.getInstance().primary_wireSix.clear();
            WireData.getInstance().primary_wireSeven.clear();
            WireData.getInstance().primary_wireEight.clear();
            WireData.getInstance().primary_wireNine.clear();
            WireData.getInstance().primary_wireTen.clear();

            WireData.getInstance().secondary_wireOne.clear();
            WireData.getInstance().secondary_wireTwo.clear();
            WireData.getInstance().secondary_wireThree.clear();
            WireData.getInstance().secondary_wireFour.clear();
            WireData.getInstance().secondary_wireFive.clear();
            WireData.getInstance().secondary_wireSix.clear();
            WireData.getInstance().secondary_wireSeven.clear();
            WireData.getInstance().secondary_wireEight.clear();
            WireData.getInstance().secondary_wireNine.clear();
            WireData.getInstance().secondary_wireTen.clear();

            WireData.getInstance().service_wireOne.clear();
            WireData.getInstance().service_wireTwo.clear();
            WireData.getInstance().service_wireThree.clear();
            WireData.getInstance().service_wireFour.clear();
            WireData.getInstance().service_wireFive.clear();
            WireData.getInstance().service_wireSix.clear();
            WireData.getInstance().service_wireSeven.clear();
            WireData.getInstance().service_wireEight.clear();
            WireData.getInstance().service_wireNine.clear();
            WireData.getInstance().service_wireTen.clear();


        } catch (NullPointerException e) {

        }
    }

    private void reserPictureName() {

        primary_wireOnePicturePath = null;
        primary_wireTwoPicturePath = null;
        primary_wireThreePicturePath = null;
        primary_wireFourPicturePath = null;
        primary_wireFivePicturePath = null;
        primary_wireSixPicturePath = null;
        primary_wireSevenPicturePath = null;
        primary_wireEightPicturePath = null;
        primary_wireNinePicturePath = null;
        primary_wireTenPicturePath = null;

        secondary_wireOnePicturePath = null;
        secondary_wireTwoPicturePath = null;
        secondary_wireThreePicturePath = null;
        secondary_wireFourPicturePath = null;
        secondary_wireFivePicturePath = null;
        secondary_wireSixPicturePath = null;
        secondary_wireSevenPicturePath = null;
        secondary_wireEightPicturePath = null;
        secondary_wireNinePicturePath = null;
        secondary_wireTenPicturePath = null;

        service_wireOnePicturePath = null;
        service_wireTwoPicturePath = null;
        service_wireThreePicturePath = null;
        service_wireFourPicturePath = null;
        service_wireFivePicturePath = null;
        service_wireSixPicturePath = null;
        service_wireSevenPicturePath = null;
        service_wireEightPicturePath = null;
        service_wireNinePicturePath = null;
        service_wireTenPicturePath = null;

        primary_wireOneTestPicturePath = null;
        primary_wireTwoTestPicturePath = null;
        primary_wireThreeTestPicturePath = null;
        primary_wireFourTestPicturePath = null;
        primary_wireFiveTestPicturePath = null;
        primary_wireSixTestPicturePath = null;
        primary_wireSevenTestPicturePath = null;
        primary_wireEightTestPicturePath = null;
        primary_wireNineTestPicturePath = null;
        primary_wireTenTestPicturePath = null;
        secondary_wireOneTestPicturePath = null;

        secondary_wireTwoTestPicturePath = null;
        secondary_wireThreeTestPicturePath = null;
        secondary_wireFourTestPicturePath = null;
        secondary_wireFiveTestPicturePath = null;
        secondary_wireSixTestPicturePath = null;
        secondary_wireSevenTestPicturePath = null;
        secondary_wireEightTestPicturePath = null;
        secondary_wireNineTestPicturePath = null;
        secondary_wireTenTestPicturePath = null;

        service_wireOneTestPicturePath = null;
        service_wireTwoTestPicturePath = null;
        service_wireThreeTestPicturePath = null;
        service_wireFourTestPicturePath = null;
        service_wireFiveTestPicturePath = null;
        service_wireSixTestPicturePath = null;
        service_wireSevenTestPicturePath = null;
        service_wireEightTestPicturePath = null;
        service_wireNineTestPicturePath = null;
        service_wireTenTestPicturePath = null;


    }

    public void resetAllJSONObject() {
        damageDetailsprimary_wireOne = null;
        damageDetailsprimary_wireTwo = null;
        damageDetailsprimary_wireThree = null;
        damageDetailsprimary_wireFour = null;
        damageDetailsprimary_wireFive = null;
        damageDetailsprimary_wireSix = null;
        damageDetailsprimary_wireSeven = null;
        damageDetailsprimary_wireEight = null;
        damageDetailsprimary_wireNine = null;
        damageDetailsprimary_wireTen = null;

        damageDetailssecondary_wireOne = null;
        damageDetailssecondary_wireTwo = null;
        damageDetailssecondary_wireThree = null;
        damageDetailssecondary_wireFour = null;
        damageDetailssecondary_wireFive = null;
        damageDetailssecondary_wireSix = null;
        damageDetailssecondary_wireSeven = null;
        damageDetailssecondary_wireEight = null;
        damageDetailssecondary_wireNine = null;
        damageDetailssecondary_wireTen = null;

        damageDetailsservice_wireOne = null;
        damageDetailsservice_wireTwo = null;
        damageDetailsservice_wireThree = null;
        damageDetailsservice_wireFour = null;
        damageDetailsservice_wireFive = null;
        damageDetailsservice_wireSix = null;
        damageDetailsservice_wireSeven = null;
        damageDetailsservice_wireEight = null;
        damageDetailsservice_wireNine = null;
        damageDetailsservice_wireTen = null;

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
