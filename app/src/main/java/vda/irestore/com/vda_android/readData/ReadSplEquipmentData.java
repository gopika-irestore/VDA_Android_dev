package vda.irestore.com.vda_android.readData;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dell on 21-12-2017.
 */

public class ReadSplEquipmentData {

    public static ReadSplEquipmentData readOthersData = null;
    public String regulatorOnePicturePath = null, regulatorTwoPicturePath = null, regulatorThreePicturePath = null, regulatorFourPicturePath = null, regulatorFivePicturePath = null, regulatorSixPicturePath = null, regulatorSevenPicturePath = null, regulatorEightPicturePath = null, regulatorNinePicturePath = null, regulatorTenPicturePath = null,
            capacitorBankOnePicturePath = null, capacitorBankTwoPicturePath = null, capacitorBankThreePicturePath = null, capacitorBankFourPicturePath = null, capacitorBankFivePicturePath = null, capacitorBankSixPicturePath = null, capacitorBankSevenPicturePath = null, capacitorBankEightPicturePath = null, capacitorBankNinePicturePath = null, capacitorBankTenPicturePath = null,
            recloserOnePicturePath = null, recloserTwoPicturePath = null, recloserThreePicturePath = null, recloserFourPicturePath = null, recloserFivePicturePath = null, recloserSixPicturePath = null, recloserSevenPicturePath = null, recloserEightPicturePath = null, recloserNinePicturePath = null, recloserTenPicturePath = null,
            loadBreakOnePicturePath = null, loadBreakTwoPicturePath = null, loadBreakThreePicturePath = null, loadBreakFourPicturePath = null, loadBreakFivePicturePath = null, loadBreakSixPicturePath = null, loadBreakSevenPicturePath = null, loadBreakEightPicturePath = null, loadBreakNinePicturePath = null, loadBreakTenPicturePath = null;

    String addNote, subtitle, kvaSize, displayName, testType, size;
    boolean isSelected, isChecked, isUtilityOwned;
    public String regulatorTitle, capacitorBankTitle, recloserTitle, loadBreakSwitchTitle;

    JSONObject damageDetailsRegulatorOne = new JSONObject();
    JSONObject damageDetailsRegulatorTwo = new JSONObject();
    JSONObject damageDetailsRegulatorThree = new JSONObject();
    JSONObject damageDetailsRegulatorFour = new JSONObject();
    JSONObject damageDetailsRegulatorFive = new JSONObject();
    JSONObject damageDetailsRegulatorSix = new JSONObject();
    JSONObject damageDetailsRegulatorSeven = new JSONObject();
    JSONObject damageDetailsRegulatorEight = new JSONObject();
    JSONObject damageDetailsRegulatorNine = new JSONObject();
    JSONObject damageDetailsRegulatorTen = new JSONObject();

    JSONObject damageDetailscapacitorBankOne = new JSONObject();
    JSONObject damageDetailscapacitorBankTwo = new JSONObject();
    JSONObject damageDetailscapacitorBankThree = new JSONObject();
    JSONObject damageDetailscapacitorBankFour = new JSONObject();
    JSONObject damageDetailscapacitorBankFive = new JSONObject();
    JSONObject damageDetailscapacitorBankSix = new JSONObject();
    JSONObject damageDetailscapacitorBankSeven = new JSONObject();
    JSONObject damageDetailscapacitorBankEight = new JSONObject();
    JSONObject damageDetailscapacitorBankNine = new JSONObject();
    JSONObject damageDetailscapacitorBankTen = new JSONObject();

    JSONObject damageDetailsrecloserOne = new JSONObject();
    JSONObject damageDetailsrecloserTwo = new JSONObject();
    JSONObject damageDetailsrecloserThree = new JSONObject();
    JSONObject damageDetailsrecloserFour = new JSONObject();
    JSONObject damageDetailsrecloserFive = new JSONObject();
    JSONObject damageDetailsrecloserSix = new JSONObject();
    JSONObject damageDetailsrecloserSeven = new JSONObject();
    JSONObject damageDetailsrecloserEight = new JSONObject();
    JSONObject damageDetailsrecloserNine = new JSONObject();
    JSONObject damageDetailsrecloserTen = new JSONObject();

    JSONObject damageDetailsloadBreakOne = new JSONObject();
    JSONObject damageDetailsloadBreakTwo = new JSONObject();
    JSONObject damageDetailsloadBreakThree = new JSONObject();
    JSONObject damageDetailsloadBreakFour = new JSONObject();
    JSONObject damageDetailsloadBreakFive = new JSONObject();
    JSONObject damageDetailsloadBreakSix = new JSONObject();
    JSONObject damageDetailsloadBreakSeven = new JSONObject();
    JSONObject damageDetailsloadBreakEight = new JSONObject();
    JSONObject damageDetailsloadBreakNine = new JSONObject();
    JSONObject damageDetailsloadBreakTen = new JSONObject();

    public static synchronized ReadSplEquipmentData getInstance() {
        if (readOthersData == null)
            readOthersData = new ReadSplEquipmentData();
        else
            return readOthersData;
        return readOthersData;
    }

    public JSONObject readregulatorOneData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorOne != null && SplEquipmentData.getInstance().regulatorOne.size() > 0) {
            if (damageDetailsRegulatorOne == null)
                damageDetailsRegulatorOne = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorOne.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorOne.get(i).getPicturePath() != null) {
                        regulatorOnePicturePath = SplEquipmentData.getInstance().regulatorOne.get(i).getPicturePath();
//                        regulatorOnePicturePath = regulatorOnePicturePath.substring(regulatorOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorOne.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorOne.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorOne.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorOne.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorOne.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorOne.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorOne.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorOne.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorOne.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorOne.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorOne.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorOne.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorOne.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorOne.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorOne.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorOne.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorOne.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorOne.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorOne.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorOne.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorOne;
    }

    public JSONObject readregulatorTwoData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorTwo != null && SplEquipmentData.getInstance().regulatorTwo.size() > 0) {
            if (damageDetailsRegulatorTwo == null)
                damageDetailsRegulatorTwo = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorTwo.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorTwo.get(i).getPicturePath() != null) {
                        regulatorTwoPicturePath = SplEquipmentData.getInstance().regulatorTwo.get(i).getPicturePath();
//                        regulatorTwoPicturePath = regulatorTwoPicturePath.substring(regulatorTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorTwo.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorTwo.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorTwo.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorTwo.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorTwo.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorTwo.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorTwo.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorTwo.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorTwo.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorTwo.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorTwo.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorTwo.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorTwo.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorTwo.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorTwo.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorTwo.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorTwo.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorTwo.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorTwo.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorTwo;
    }

    public JSONObject readregulatorThreeData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorThree != null && SplEquipmentData.getInstance().regulatorThree.size() > 0) {
            if (damageDetailsRegulatorThree == null)
                damageDetailsRegulatorThree = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorThree.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorThree.get(i).getPicturePath() != null) {
                        regulatorThreePicturePath = SplEquipmentData.getInstance().regulatorThree.get(i).getPicturePath();
//                        regulatorThreePicturePath = regulatorThreePicturePath.substring(regulatorThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorThree.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorThree.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorThree.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorThree.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorThree.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorThree.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorThree.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorThree.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorThree.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorThree.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorThree.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorThree.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorThree.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorThree.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorThree.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorThree.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorThree.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorThree.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorThree.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorThree.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorThree;
    }

    public JSONObject readregulatorFourData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorFour != null && SplEquipmentData.getInstance().regulatorFour.size() > 0) {
            if (damageDetailsRegulatorFour == null)
                damageDetailsRegulatorFour = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorFour.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorFour.get(i).getPicturePath() != null) {
                        regulatorFourPicturePath = SplEquipmentData.getInstance().regulatorFour.get(i).getPicturePath();
//                        regulatorFourPicturePath = regulatorFourPicturePath.substring(regulatorFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorFour.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorFour.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorFour.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorFour.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorFour.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorFour.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorFour.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorFour.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorFour.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorFour.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorFour.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorFour.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorFour.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorFour.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorFour.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorFour.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorFour.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorFour.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorFour.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorFour.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorFour;
    }

    public JSONObject readregulatorFiveData() {
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorFive != null && SplEquipmentData.getInstance().regulatorFive.size() > 0) {
            if (damageDetailsRegulatorFive == null)
                damageDetailsRegulatorFive = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorFive.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorFive.get(i).getPicturePath() != null) {
                        regulatorFivePicturePath = SplEquipmentData.getInstance().regulatorFive.get(i).getPicturePath();
//                        regulatorFivePicturePath = regulatorFivePicturePath.substring(regulatorFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorFive.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorFive.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorFive.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorFive.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorFive.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorFive.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorFive.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorFive.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorFive.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorFive.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorFive.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorFive.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorFive.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorFive.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorFive.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorFive.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorFive.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorFive.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorFive.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorFive.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorFive;
    }

    public JSONObject readregulatorSixData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorSix != null && SplEquipmentData.getInstance().regulatorSix.size() > 0) {
            if (damageDetailsRegulatorSix == null)
                damageDetailsRegulatorSix = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorSix.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorSix.get(i).getPicturePath() != null) {
                        regulatorSixPicturePath = SplEquipmentData.getInstance().regulatorSix.get(i).getPicturePath();
//                        regulatorSixPicturePath = regulatorSixPicturePath.substring(regulatorSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorSix.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorSix.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorSix.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorSix.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorSix.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorSix.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorSix.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorSix.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorSix.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorSix.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorSix.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorSix.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorSix.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorSix.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorSix.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorSix.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorSix.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorSix.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorSix.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorSix.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorSix;
    }

    public JSONObject readregulatorSevenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorSeven != null && SplEquipmentData.getInstance().regulatorSeven.size() > 0) {
            if (damageDetailsRegulatorSeven == null)
                damageDetailsRegulatorSeven = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorSeven.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorSeven.get(i).getPicturePath() != null) {
                        regulatorSevenPicturePath = SplEquipmentData.getInstance().regulatorSeven.get(i).getPicturePath();
//                        regulatorSevenPicturePath = regulatorSevenPicturePath.substring(regulatorSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorSeven.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorSeven.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorSeven.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorSeven.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorSeven.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorSeven.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorSeven.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorSeven.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorSeven.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorSeven.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorSeven.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorSeven.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorSeven.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorSeven.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorSeven.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorSeven.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorSeven.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorSeven.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorSeven.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorSeven;
    }

    public JSONObject readregulatorEightData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorEight != null && SplEquipmentData.getInstance().regulatorEight.size() > 0) {
            if (damageDetailsRegulatorEight == null)
                damageDetailsRegulatorEight = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorEight.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorEight.get(i).getPicturePath() != null) {
                        regulatorEightPicturePath = SplEquipmentData.getInstance().regulatorEight.get(i).getPicturePath();
//                        regulatorEightPicturePath = regulatorEightPicturePath.substring(regulatorEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorEight.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorEight.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorEight.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorEight.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorEight.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorEight.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorEight.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorEight.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorEight.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorEight.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorEight.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorEight.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorEight.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorEight.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorEight.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorEight.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorEight.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorEight.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorEight.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorEight.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorEight;
    }

    public JSONObject readregulatorNineData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorNine != null && SplEquipmentData.getInstance().regulatorNine.size() > 0) {
            if (damageDetailsRegulatorNine == null)
                damageDetailsRegulatorNine = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorNine.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorNine.get(i).getPicturePath() != null) {
                        regulatorNinePicturePath = SplEquipmentData.getInstance().regulatorNine.get(i).getPicturePath();
//                        regulatorNinePicturePath = regulatorNinePicturePath.substring(regulatorNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorNine.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorNine.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorNine.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorNine.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorNine.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorNine.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorNine.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorNine.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorNine.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorNine.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorNine.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorNine.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorNine.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorNine.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorNine.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorNine.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorNine.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorNine.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorNine.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorNine.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorNine;
    }

    public JSONObject readregulatorTenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().regulatorTen != null && SplEquipmentData.getInstance().regulatorTen.size() > 0) {
            if (damageDetailsRegulatorTen == null)
                damageDetailsRegulatorTen = null;
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().regulatorTen.size(); i++) {
                    if (SplEquipmentData.getInstance().regulatorTen.get(i).getPicturePath() != null) {
                        regulatorTenPicturePath = SplEquipmentData.getInstance().regulatorTen.get(i).getPicturePath();
//                        regulatorTenPicturePath = regulatorTenPicturePath.substring(regulatorTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().regulatorTen.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorTen.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().regulatorTen.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().regulatorTen.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorTen.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorTen.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorTen.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().regulatorTen.get(i).getNote();
                        if (SplEquipmentData.getInstance().regulatorTen.get(i).getSubTitle() != null) {
                            damageDetailsRegulatorTen.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorTen.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().regulatorTen.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().regulatorTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsRegulatorTen.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().regulatorTen.get(i).getTitle() != null)
                        regulatorTitle = SplEquipmentData.getInstance().regulatorTen.get(i).getTitle();
                    if (SplEquipmentData.getInstance().regulatorTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().regulatorTen.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().regulatorTen.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().regulatorTen.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().regulatorTen.get(i).getName();
                        if (isSelected) {

                            damageDetailsRegulatorTen.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsRegulatorTen;
    }

    public JSONObject readcapacitorBankOneData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankOne != null && SplEquipmentData.getInstance().capacitorBankOne.size() > 0) {

            if (damageDetailscapacitorBankOne == null)
                damageDetailscapacitorBankOne = new JSONObject();

            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankOne.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getPicturePath() != null) {
                        capacitorBankOnePicturePath = SplEquipmentData.getInstance().capacitorBankOne.get(i).getPicturePath();
//                        capacitorBankOnePicturePath = capacitorBankOnePicturePath.substring(capacitorBankOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankOne.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankOne.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankOne.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankOne.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankOne.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankOne.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankOne.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankOne.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankOne.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankOne.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankOne.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankOne.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankOne.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankOne.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankOne;
    }

    public JSONObject readcapacitorBankTwoData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankTwo != null && SplEquipmentData.getInstance().capacitorBankTwo.size() > 0) {
            if (damageDetailscapacitorBankTwo == null)
                damageDetailscapacitorBankTwo = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankTwo.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getPicturePath() != null) {
                        capacitorBankTwoPicturePath = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getPicturePath();
//                        capacitorBankTwoPicturePath = capacitorBankTwoPicturePath.substring(capacitorBankTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankTwo.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankTwo.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankTwo.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankTwo.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankTwo.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankTwo.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankTwo;
    }

    public JSONObject readcapacitorBankThreeData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankThree != null && SplEquipmentData.getInstance().capacitorBankThree.size() > 0) {
            if (damageDetailscapacitorBankThree == null)
                damageDetailscapacitorBankThree = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankThree.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getPicturePath() != null) {
                        capacitorBankThreePicturePath = SplEquipmentData.getInstance().capacitorBankThree.get(i).getPicturePath();
//                        capacitorBankThreePicturePath = capacitorBankThreePicturePath.substring(capacitorBankThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankThree.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankThree.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankThree.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankThree.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankThree.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankThree.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankThree.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankThree.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankThree.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankThree.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankThree.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankThree.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankThree.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankThree.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankThree;
    }

    public JSONObject readcapacitorBankFourData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankFour != null && SplEquipmentData.getInstance().capacitorBankFour.size() > 0) {
            if (damageDetailscapacitorBankFour == null)
                damageDetailscapacitorBankFour = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankFour.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getPicturePath() != null) {
                        capacitorBankFourPicturePath = SplEquipmentData.getInstance().capacitorBankFour.get(i).getPicturePath();
//                        capacitorBankFourPicturePath = capacitorBankFourPicturePath.substring(capacitorBankFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankFour.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankFour.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankFour.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankFour.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankFour.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankFour.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankFour.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankFour.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankFour.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankFour.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankFour.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankFour.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankFour.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankFour.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankFour;
    }

    public JSONObject readcapacitorBankFiveData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankFive != null && SplEquipmentData.getInstance().capacitorBankFive.size() > 0) {
            if (damageDetailscapacitorBankFive == null)
                damageDetailscapacitorBankFive = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankFive.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getPicturePath() != null) {
                        capacitorBankFivePicturePath = SplEquipmentData.getInstance().capacitorBankFive.get(i).getPicturePath();
//                        capacitorBankFivePicturePath = capacitorBankFivePicturePath.substring(capacitorBankFivePicturePath.lastIndexOf("/") + 1);
                    }

                    if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankFive.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankFive.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankFive.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankFive.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankFive.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankFive.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankFive.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankFive.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankFive.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankFive.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankFive.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankFive.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankFive.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankFive.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankFive;
    }

    public JSONObject readcapacitorBankSixData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankSix != null && SplEquipmentData.getInstance().capacitorBankSix.size() > 0) {
            if (damageDetailscapacitorBankSix == null)
                damageDetailscapacitorBankSix = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankSix.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getPicturePath() != null) {
                        capacitorBankSixPicturePath = SplEquipmentData.getInstance().capacitorBankSix.get(i).getPicturePath();
//                        capacitorBankSixPicturePath = capacitorBankSixPicturePath.substring(capacitorBankSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankSix.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankSix.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankSix.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankSix.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankSix.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankSix.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankSix.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankSix.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankSix.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankSix.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankSix.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankSix.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankSix.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankSix.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankSix;
    }

    public JSONObject readcapacitorBankSevenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankSeven != null && SplEquipmentData.getInstance().capacitorBankSeven.size() > 0) {
            if (damageDetailscapacitorBankSeven == null)
                damageDetailscapacitorBankSeven = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankSeven.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getPicturePath() != null) {
                        capacitorBankSevenPicturePath = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getPicturePath();
//                        capacitorBankSevenPicturePath = capacitorBankSevenPicturePath.substring(capacitorBankSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankSeven.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankSeven.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankSeven.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankSeven.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankSeven.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankSeven.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankSeven;
    }

    public JSONObject readcapacitorBankEightData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankEight != null && SplEquipmentData.getInstance().capacitorBankEight.size() > 0) {
            if (damageDetailscapacitorBankEight == null)
                damageDetailscapacitorBankEight = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankEight.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getPicturePath() != null) {
                        capacitorBankEightPicturePath = SplEquipmentData.getInstance().capacitorBankEight.get(i).getPicturePath();
//                        capacitorBankEightPicturePath = capacitorBankEightPicturePath.substring(capacitorBankEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankEight.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankEight.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankEight.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankEight.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankEight.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankEight.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankEight.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankEight.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankEight.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankEight.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankEight.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankEight.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankEight.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankEight.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankEight;
    }

    public JSONObject readcapacitorBankNineData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankNine != null && SplEquipmentData.getInstance().capacitorBankNine.size() > 0) {
            if (damageDetailscapacitorBankNine == null)
                damageDetailscapacitorBankNine = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankNine.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getPicturePath() != null) {
                        capacitorBankNinePicturePath = SplEquipmentData.getInstance().capacitorBankNine.get(i).getPicturePath();
//                        capacitorBankNinePicturePath = capacitorBankNinePicturePath.substring(capacitorBankNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankNine.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankNine.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankNine.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankNine.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankNine.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankNine.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankNine.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankNine.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankNine.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankNine.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankNine.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankNine.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankNine.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankNine.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankNine;
    }

    public JSONObject readcapacitorBankTenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().capacitorBankTen != null && SplEquipmentData.getInstance().capacitorBankTen.size() > 0) {
            if (damageDetailscapacitorBankTen == null)
                damageDetailscapacitorBankTen = null;
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().capacitorBankTen.size(); i++) {
                    if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getPicturePath() != null) {
                        capacitorBankTenPicturePath = SplEquipmentData.getInstance().capacitorBankTen.get(i).getPicturePath();
//                        capacitorBankTenPicturePath = capacitorBankTenPicturePath.substring(capacitorBankTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankTen.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().capacitorBankTen.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankTen.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankTen.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().capacitorBankTen.get(i).getNote();
                        if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getSubTitle() != null) {
                            damageDetailscapacitorBankTen.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().capacitorBankTen.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().capacitorBankTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailscapacitorBankTen.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getTitle() != null)
                        capacitorBankTitle = SplEquipmentData.getInstance().capacitorBankTen.get(i).getTitle();
                    if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().capacitorBankTen.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().capacitorBankTen.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().capacitorBankTen.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().capacitorBankTen.get(i).getName();
                        if (isSelected) {

                            damageDetailscapacitorBankTen.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailscapacitorBankTen;
    }

    public JSONObject readrecloserOneData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserOne != null && SplEquipmentData.getInstance().recloserOne.size() > 0) {
            if(damageDetailsrecloserOne == null)
                damageDetailsrecloserOne = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserOne.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserOne.get(i).getPicturePath() != null) {
                        recloserOnePicturePath = SplEquipmentData.getInstance().recloserOne.get(i).getPicturePath();
//                        recloserOnePicturePath = recloserOnePicturePath.substring(recloserOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserOne.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserOne.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserOne.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserOne.get(i).getSubTitle() != null) {
                            damageDetailsrecloserOne.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserOne.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserOne.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserOne.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserOne.get(i).getSubTitle() != null) {
                            damageDetailsrecloserOne.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserOne.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserOne.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserOne.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserOne.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserOne.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserOne.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserOne.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserOne.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserOne.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserOne.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserOne;
    }

    public JSONObject readrecloserTwoData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserTwo != null && SplEquipmentData.getInstance().recloserTwo.size() > 0) {
            if(damageDetailsrecloserTwo == null)
                damageDetailsrecloserTwo = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserTwo.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserTwo.get(i).getPicturePath() != null) {
                        recloserTwoPicturePath = SplEquipmentData.getInstance().recloserTwo.get(i).getPicturePath();
//                        recloserTwoPicturePath = recloserTwoPicturePath.substring(recloserTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserTwo.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserTwo.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserTwo.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserTwo.get(i).getSubTitle() != null) {
                            damageDetailsrecloserTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserTwo.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserTwo.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserTwo.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserTwo.get(i).getSubTitle() != null) {
                            damageDetailsrecloserTwo.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserTwo.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserTwo.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserTwo.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserTwo.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserTwo.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserTwo.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserTwo.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserTwo.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserTwo.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserTwo.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserTwo;
    }

    public JSONObject readrecloserThreeData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserThree != null && SplEquipmentData.getInstance().recloserThree.size() > 0) {
            if(damageDetailsrecloserThree == null)
                damageDetailsrecloserThree = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserThree.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserThree.get(i).getPicturePath() != null) {
                        recloserThreePicturePath = SplEquipmentData.getInstance().recloserThree.get(i).getPicturePath();
//                        recloserThreePicturePath = recloserThreePicturePath.substring(recloserThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserThree.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserThree.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserThree.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserThree.get(i).getSubTitle() != null) {
                            damageDetailsrecloserThree.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserThree.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserThree.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserThree.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserThree.get(i).getSubTitle() != null) {
                            damageDetailsrecloserThree.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserThree.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserThree.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserThree.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserThree.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserThree.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserThree.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserThree.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserThree.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserThree.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserThree.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserThree;
    }

    public JSONObject readrecloserFourData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserFour != null && SplEquipmentData.getInstance().recloserFour.size() > 0) {
            if(damageDetailsrecloserFour == null)
                damageDetailsrecloserFour = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserFour.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserFour.get(i).getPicturePath() != null) {
                        recloserFourPicturePath = SplEquipmentData.getInstance().recloserFour.get(i).getPicturePath();
//                        recloserFourPicturePath = recloserFourPicturePath.substring(recloserFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserFour.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserFour.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserFour.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserFour.get(i).getSubTitle() != null) {
                            damageDetailsrecloserFour.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserFour.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserFour.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserFour.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserFour.get(i).getSubTitle() != null) {
                            damageDetailsrecloserFour.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserFour.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserFour.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserFour.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserFour.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserFour.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserFour.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserFour.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserFour.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserFour.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserFour.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserFour;
    }

    public JSONObject readrecloserFiveData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserFive != null && SplEquipmentData.getInstance().recloserFive.size() > 0) {
            if(damageDetailsrecloserFive == null)
                damageDetailsrecloserFive = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserFive.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserFive.get(i).getPicturePath() != null) {
                        recloserFivePicturePath = SplEquipmentData.getInstance().recloserFive.get(i).getPicturePath();
//                        recloserFivePicturePath = recloserFivePicturePath.substring(recloserFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserFive.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserFive.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserFive.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserFive.get(i).getSubTitle() != null) {
                            damageDetailsrecloserFive.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserFive.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserFive.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserFive.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserFive.get(i).getSubTitle() != null) {
                            damageDetailsrecloserFive.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserFive.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserFive.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserFive.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserFive.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserFive.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserFive.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserFive.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserFive.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserFive.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserFive.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserFive;
    }

    public JSONObject readrecloserSixData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserSix != null && SplEquipmentData.getInstance().recloserSix.size() > 0) {
            if(damageDetailsrecloserSix == null)
                damageDetailsrecloserSix = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserSix.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserSix.get(i).getPicturePath() != null) {
                        recloserSixPicturePath = SplEquipmentData.getInstance().recloserSix.get(i).getPicturePath();
//                        recloserSixPicturePath = recloserSixPicturePath.substring(recloserSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserSix.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserSix.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserSix.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserSix.get(i).getSubTitle() != null) {
                            damageDetailsrecloserSix.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserSix.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserSix.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserSix.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserSix.get(i).getSubTitle() != null) {
                            damageDetailsrecloserSix.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserSix.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserSix.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserSix.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserSix.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserSix.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserSix.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserSix.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserSix.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserSix.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserSix.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserSix;
    }

    public JSONObject readrecloserSevenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserSeven != null && SplEquipmentData.getInstance().recloserSeven.size() > 0) {
            if(damageDetailsrecloserSeven == null)
                damageDetailsrecloserSeven = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserSeven.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserSeven.get(i).getPicturePath() != null) {
                        recloserSevenPicturePath = SplEquipmentData.getInstance().recloserSeven.get(i).getPicturePath();
//                        recloserSevenPicturePath = recloserSevenPicturePath.substring(recloserSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserSeven.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserSeven.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserSeven.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserSeven.get(i).getSubTitle() != null) {
                            damageDetailsrecloserSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserSeven.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserSeven.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserSeven.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserSeven.get(i).getSubTitle() != null) {
                            damageDetailsrecloserSeven.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserSeven.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserSeven.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserSeven.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserSeven.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserSeven.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserSeven.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserSeven.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserSeven.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserSeven.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserSeven.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserSeven;
    }

    public JSONObject readrecloserEightData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserEight != null && SplEquipmentData.getInstance().recloserEight.size() > 0) {
            if(damageDetailsrecloserEight == null)
                damageDetailsrecloserEight = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserEight.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserEight.get(i).getPicturePath() != null) {
                        recloserEightPicturePath = SplEquipmentData.getInstance().recloserEight.get(i).getPicturePath();
//                        recloserEightPicturePath = recloserEightPicturePath.substring(recloserEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserEight.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserEight.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserEight.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserEight.get(i).getSubTitle() != null) {
                            damageDetailsrecloserEight.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserEight.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserEight.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserEight.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserEight.get(i).getSubTitle() != null) {
                            damageDetailsrecloserEight.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserEight.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserEight.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserEight.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserEight.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserEight.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserEight.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserEight.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserEight.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserEight.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserEight.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserEight;
    }

    public JSONObject readrecloserNineData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserNine != null && SplEquipmentData.getInstance().recloserNine.size() > 0) {
            if(damageDetailsrecloserNine == null)
                damageDetailsrecloserNine = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserNine.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserNine.get(i).getPicturePath() != null) {
                        recloserNinePicturePath = SplEquipmentData.getInstance().recloserNine.get(i).getPicturePath();
//                        recloserNinePicturePath = recloserNinePicturePath.substring(recloserNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserNine.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserNine.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserNine.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserNine.get(i).getSubTitle() != null) {
                            damageDetailsrecloserNine.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserNine.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserNine.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserNine.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserNine.get(i).getSubTitle() != null) {
                            damageDetailsrecloserNine.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserNine.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserNine.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserNine.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserNine.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserNine.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserNine.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserNine.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserNine.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserNine.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserNine.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserNine;
    }

    public JSONObject readrecloserTenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().recloserTen != null && SplEquipmentData.getInstance().recloserTen.size() > 0) {
            if(damageDetailsrecloserTen == null)
                damageDetailsrecloserTen = null;
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().recloserTen.size(); i++) {
                    if (SplEquipmentData.getInstance().recloserTen.get(i).getPicturePath() != null) {
                        recloserTenPicturePath = SplEquipmentData.getInstance().recloserTen.get(i).getPicturePath();
//                        recloserTenPicturePath = recloserTenPicturePath.substring(recloserTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().recloserTen.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserTen.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().recloserTen.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().recloserTen.get(i).getSubTitle() != null) {
                            damageDetailsrecloserTen.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserTen.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserTen.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().recloserTen.get(i).getNote();
                        if (SplEquipmentData.getInstance().recloserTen.get(i).getSubTitle() != null) {
                            damageDetailsrecloserTen.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserTen.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().recloserTen.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().recloserTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsrecloserTen.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().recloserTen.get(i).getTitle() != null)
                        recloserTitle = SplEquipmentData.getInstance().recloserTen.get(i).getTitle();
                    if (SplEquipmentData.getInstance().recloserTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().recloserTen.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().recloserTen.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().recloserTen.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().recloserTen.get(i).getName();
                        if (isSelected) {

                            damageDetailsrecloserTen.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsrecloserTen;
    }

    public JSONObject readloadBreakSwitchOneData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchOne != null && SplEquipmentData.getInstance().loadBreakSwitchOne.size() > 0) {
            if(damageDetailsloadBreakOne == null)
                damageDetailsloadBreakOne  = new JSONObject();

            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchOne.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getPicturePath() != null) {
                        loadBreakOnePicturePath = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getPicturePath();
//                        loadBreakOnePicturePath = loadBreakOnePicturePath.substring(loadBreakOnePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakOne.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakOne.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakOne.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchOne.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakOne.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakOne;
    }

    public JSONObject readloadBreakSwitchTwoData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchTwo != null && SplEquipmentData.getInstance().loadBreakSwitchTwo.size() > 0) {
            if(damageDetailsloadBreakTwo == null)
                damageDetailsloadBreakTwo  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchTwo.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getPicturePath() != null) {
                        loadBreakTwoPicturePath = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getPicturePath();
//                        loadBreakTwoPicturePath = loadBreakTwoPicturePath.substring(loadBreakTwoPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakTwo.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakTwo.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchTwo.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakTwo.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakTwo;
    }

    public JSONObject readloadBreakSwitchThreeData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchThree != null && SplEquipmentData.getInstance().loadBreakSwitchThree.size() > 0) {
            if(damageDetailsloadBreakThree == null)
                damageDetailsloadBreakThree  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchThree.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getPicturePath() != null) {
                        loadBreakThreePicturePath = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getPicturePath();
//                        loadBreakThreePicturePath = loadBreakThreePicturePath.substring(loadBreakThreePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakThree.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakThree.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakThree.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchThree.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakThree.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakThree;
    }

    public JSONObject readloadBreakSwitchFourData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchFour != null && SplEquipmentData.getInstance().loadBreakSwitchFour.size() > 0) {
            if(damageDetailsloadBreakFour == null)
                damageDetailsloadBreakFour  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchFour.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getPicturePath() != null) {
                        loadBreakFourPicturePath = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getPicturePath();
//                        loadBreakFourPicturePath = loadBreakFourPicturePath.substring(loadBreakFourPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakFour.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakFour.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakFour.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchFour.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakFour.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakFour;
    }

    public JSONObject readloadBreakSwitchFiveData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchFive != null && SplEquipmentData.getInstance().loadBreakSwitchFive.size() > 0) {
            if(damageDetailsloadBreakFive == null)
                damageDetailsloadBreakFive  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchFive.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getPicturePath() != null) {
                        loadBreakFivePicturePath = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getPicturePath();
//                        loadBreakFivePicturePath = loadBreakFivePicturePath.substring(loadBreakFivePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakFive.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakFive.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakFive.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchFive.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakFive.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakFive;
    }

    public JSONObject readloadBreakSwitchSixData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchSix != null && SplEquipmentData.getInstance().loadBreakSwitchSix.size() > 0) {
            if(damageDetailsloadBreakSix == null)
                damageDetailsloadBreakSix  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchSix.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getPicturePath() != null) {
                        loadBreakSixPicturePath = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getPicturePath();
//                        loadBreakSixPicturePath = loadBreakSixPicturePath.substring(loadBreakSixPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakSix.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakSix.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakSix.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchSix.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakSix.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakSix;
    }

    public JSONObject readloadBreakSwitchSevenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchSeven != null && SplEquipmentData.getInstance().loadBreakSwitchSeven.size() > 0) {
            if(damageDetailsloadBreakSeven == null)
                damageDetailsloadBreakSeven  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchSeven.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getPicturePath() != null) {
                        loadBreakSevenPicturePath = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getPicturePath();
//                        loadBreakSevenPicturePath = loadBreakSevenPicturePath.substring(loadBreakSevenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakSeven.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakSeven.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchSeven.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakSeven.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakSeven;
    }

    public JSONObject readloadBreakSwitchEightData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchEight != null && SplEquipmentData.getInstance().loadBreakSwitchEight.size() > 0) {
            if(damageDetailsloadBreakEight == null)
                damageDetailsloadBreakEight  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchEight.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getPicturePath() != null) {
                        loadBreakEightPicturePath = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getPicturePath();
//                        loadBreakEightPicturePath = loadBreakEightPicturePath.substring(loadBreakEightPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakEight.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakEight.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakEight.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchEight.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakEight.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakEight;
    }

    public JSONObject readloadBreakSwitchNineData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchNine != null && SplEquipmentData.getInstance().loadBreakSwitchNine.size() > 0) {
            if(damageDetailsloadBreakNine == null)
                damageDetailsloadBreakNine  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchNine.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getPicturePath() != null) {
                        loadBreakNinePicturePath = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getPicturePath();
//                        loadBreakNinePicturePath = loadBreakNinePicturePath.substring(loadBreakNinePicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakNine.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakNine.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakNine.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchNine.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakNine.put(displayName, isSelected);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakNine;
    }

    public JSONObject readloadBreakSwitchTenData() {
        // Transformer defect One
        addNote = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (SplEquipmentData.getInstance().loadBreakSwitchTen != null && SplEquipmentData.getInstance().loadBreakSwitchTen.size() > 0) {
            if(damageDetailsloadBreakTen == null)
                damageDetailsloadBreakTen  = new JSONObject();
            try {
                for (int i = 0; i < SplEquipmentData.getInstance().loadBreakSwitchTen.size(); i++) {
                    if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getPicturePath() != null) {
                        loadBreakTenPicturePath = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getPicturePath();
//                        loadBreakTenPicturePath = loadBreakTenPicturePath.substring(loadBreakTenPicturePath.lastIndexOf("/") + 1);
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getKvaSize() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getSubTitle();
                        kvaSize = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getKvaSize();
                        if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakTen.put(subtitle, kvaSize);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getNote() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getSubTitle();
                        addNote = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getNote();
                        if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getSubTitle() != null) {
                            damageDetailsloadBreakTen.put(subtitle, addNote);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getCheckedOK() != null) {
                        subtitle = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getSubTitle();
                        isChecked = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getCheckedOK();
                        if (isChecked) {
                            damageDetailsloadBreakTen.put(subtitle, isChecked);
                        }
                    }
                    if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getTitle() != null)
                        loadBreakSwitchTitle = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getTitle();
                    if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getDisplayName());

                    if (SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getIsSelected() != null) {
                        isSelected = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getIsSelected();
                        displayName = SplEquipmentData.getInstance().loadBreakSwitchTen.get(i).getName();
                        if (isSelected) {

                            damageDetailsloadBreakTen.put(displayName, isSelected);
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailsloadBreakTen;
    }

    public void resetAllReference() {
        try {
            reserPictureName();
            SplEquipmentData.getInstance().regulatorOne.clear();
            SplEquipmentData.getInstance().regulatorTwo.clear();
            SplEquipmentData.getInstance().regulatorThree.clear();
            SplEquipmentData.getInstance().regulatorFour.clear();
            SplEquipmentData.getInstance().regulatorFive.clear();
            SplEquipmentData.getInstance().regulatorSix.clear();
            SplEquipmentData.getInstance().regulatorSeven.clear();
            SplEquipmentData.getInstance().regulatorEight.clear();
            SplEquipmentData.getInstance().regulatorNine.clear();
            SplEquipmentData.getInstance().regulatorTen.clear();

            SplEquipmentData.getInstance().capacitorBankOne.clear();
            SplEquipmentData.getInstance().capacitorBankTwo.clear();
            SplEquipmentData.getInstance().capacitorBankThree.clear();
            SplEquipmentData.getInstance().capacitorBankFour.clear();
            SplEquipmentData.getInstance().capacitorBankFive.clear();
            SplEquipmentData.getInstance().capacitorBankSix.clear();
            SplEquipmentData.getInstance().capacitorBankSeven.clear();
            SplEquipmentData.getInstance().capacitorBankEight.clear();
            SplEquipmentData.getInstance().capacitorBankNine.clear();
            SplEquipmentData.getInstance().capacitorBankTen.clear();

            SplEquipmentData.getInstance().recloserOne.clear();
            SplEquipmentData.getInstance().recloserTwo.clear();
            SplEquipmentData.getInstance().recloserThree.clear();
            SplEquipmentData.getInstance().recloserFour.clear();
            SplEquipmentData.getInstance().recloserFive.clear();
            SplEquipmentData.getInstance().recloserSix.clear();
            SplEquipmentData.getInstance().recloserSeven.clear();
            SplEquipmentData.getInstance().recloserEight.clear();
            SplEquipmentData.getInstance().recloserNine.clear();
            SplEquipmentData.getInstance().recloserTen.clear();

            SplEquipmentData.getInstance().loadBreakSwitchOne.clear();
            SplEquipmentData.getInstance().loadBreakSwitchTwo.clear();
            SplEquipmentData.getInstance().loadBreakSwitchThree.clear();
            SplEquipmentData.getInstance().loadBreakSwitchFour.clear();
            SplEquipmentData.getInstance().loadBreakSwitchFive.clear();
            SplEquipmentData.getInstance().loadBreakSwitchSix.clear();
            SplEquipmentData.getInstance().loadBreakSwitchSeven.clear();
            SplEquipmentData.getInstance().loadBreakSwitchEight.clear();
            SplEquipmentData.getInstance().loadBreakSwitchNine.clear();
            SplEquipmentData.getInstance().loadBreakSwitchTen.clear();

        } catch (NullPointerException e) {

        }
    }

    private void reserPictureName() {
        regulatorOnePicturePath = null;
        regulatorTwoPicturePath = null;
        regulatorThreePicturePath = null;
        regulatorFourPicturePath = null;
        regulatorFivePicturePath = null;
        regulatorSixPicturePath = null;
        regulatorSevenPicturePath = null;
        regulatorEightPicturePath = null;
        regulatorNinePicturePath = null;
        regulatorTenPicturePath = null;
        capacitorBankOnePicturePath = null;
        capacitorBankTwoPicturePath = null;
        capacitorBankThreePicturePath = null;
        capacitorBankFourPicturePath = null;
        capacitorBankFivePicturePath = null;
        capacitorBankSixPicturePath = null;
        capacitorBankSevenPicturePath = null;
        capacitorBankEightPicturePath = null;
        capacitorBankNinePicturePath = null;
        capacitorBankTenPicturePath = null;
        recloserOnePicturePath = null;
        recloserTwoPicturePath = null;
        recloserThreePicturePath = null;
        recloserFourPicturePath = null;
        recloserFivePicturePath = null;
        recloserSixPicturePath = null;
        recloserSevenPicturePath = null;
        recloserEightPicturePath = null;
        recloserNinePicturePath = null;
        recloserTenPicturePath = null;
        loadBreakOnePicturePath = null;
        loadBreakTwoPicturePath = null;
        loadBreakThreePicturePath = null;
        loadBreakFourPicturePath = null;
        loadBreakFivePicturePath = null;
        loadBreakSixPicturePath = null;
        loadBreakSevenPicturePath = null;
        loadBreakEightPicturePath = null;
        loadBreakNinePicturePath = null;
        loadBreakTenPicturePath = null;
    }

    public void resetAllJSONObject() {
        damageDetailsRegulatorOne = null;
        damageDetailsRegulatorTwo = null;
        damageDetailsRegulatorThree = null;
        damageDetailsRegulatorFour = null;
        damageDetailsRegulatorFive = null;
        damageDetailsRegulatorSix = null;
        damageDetailsRegulatorSeven = null;
        damageDetailsRegulatorEight = null;
        damageDetailsRegulatorNine = null;
        damageDetailsRegulatorTen = null;

        damageDetailscapacitorBankOne = null;
        damageDetailscapacitorBankTwo = null;
        damageDetailscapacitorBankThree = null;
        damageDetailscapacitorBankFour = null;
        damageDetailscapacitorBankFive = null;
        damageDetailscapacitorBankSix = null;
        damageDetailscapacitorBankSeven = null;
        damageDetailscapacitorBankEight = null;
        damageDetailscapacitorBankNine = null;
        damageDetailscapacitorBankTen = null;

        damageDetailsrecloserOne = null;
        damageDetailsrecloserTwo = null;
        damageDetailsrecloserThree = null;
        damageDetailsrecloserFour = null;
        damageDetailsrecloserFive = null;
        damageDetailsrecloserSix = null;
        damageDetailsrecloserSeven = null;
        damageDetailsrecloserEight = null;
        damageDetailsrecloserNine = null;
        damageDetailsrecloserTen = null;

        damageDetailsloadBreakOne = null;
        damageDetailsloadBreakTwo = null;
        damageDetailsloadBreakThree = null;
        damageDetailsloadBreakFour = null;
        damageDetailsloadBreakFive = null;
        damageDetailsloadBreakSix = null;
        damageDetailsloadBreakSeven = null;
        damageDetailsloadBreakEight = null;
        damageDetailsloadBreakNine = null;
        damageDetailsloadBreakTen = null;
    }
}
