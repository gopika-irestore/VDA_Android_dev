package vda.irestore.com.vda_android.readData;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ReadTreeData {
    public static ReadTreeData readTreeData = null;
    public String treeOnePicturePath = null, treeTwoPicturePath = null, treeThreePicturePath = null, treeFourPicturePath = null,
            treeFivePicturePath = null, treeSixPicturePath = null, treeSevenPicturePath = null, treeEightPicturePath = null, treeNinePicturePath = null, treeTenPicturePath = null;

    String addNote, addExtent,subtitle, kvaSize, displayName, testType, size;
    boolean isSelected, isChecked, isUtilityOwned;
    public String treeTitle;

    JSONObject damageDetailstreeOne = new JSONObject();
    JSONObject damageDetailstreeTwo = new JSONObject();
    JSONObject damageDetailstreeThree = new JSONObject();
    JSONObject damageDetailstreeFour = new JSONObject();
    JSONObject damageDetailstreeFive = new JSONObject();
    JSONObject damageDetailstreeSix = new JSONObject();
    JSONObject damageDetailstreeSeven = new JSONObject();
    JSONObject damageDetailstreeEight = new JSONObject();
    JSONObject damageDetailstreeNine = new JSONObject();
    JSONObject damageDetailstreeTen = new JSONObject();

    public static synchronized ReadTreeData getInstance() {
        if (readTreeData == null) {
            readTreeData = new ReadTreeData();
        } else {
            return readTreeData;
        }
        return readTreeData;
    }

    public JSONObject readtreeOneData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeOne != null && TreeData.getInstance().treeOne.size() > 0) {
            if (damageDetailstreeOne == null)
                damageDetailstreeOne = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeOne.size(); i++) {
                    if (TreeData.getInstance().treeOne.get(i).getPicturePath() != null) {
                        treeOnePicturePath = TreeData.getInstance().treeOne.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeOne.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeOne.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeOne.get(i).getKvaSize();
                        if (TreeData.getInstance().treeOne.get(i).getSubTitle() != null) {
                            damageDetailstreeOne.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeOne.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeOne.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeOne.get(i).getNote();
                        if (TreeData.getInstance().treeOne.get(i).getSubTitle() != null) {
                            damageDetailstreeOne.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeOne.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeOne.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeOne.get(i).getExtent();
                        if (TreeData.getInstance().treeOne.get(i).getSubTitle() != null) {
                            damageDetailstreeOne.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeOne.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeOne.get(i).getTitle();
                    if (TreeData.getInstance().treeOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeOne.get(i).getDisplayName());
                    if (TreeData.getInstance().treeOne.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeOne.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeOne.get(i).getName();

                        if (isSelected) {
                            //  displayName = displayName.replaceAll("\\s", "");
                            // displayName = "is" + displayName;
                            damageDetailstreeOne.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeOne.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeOne;
    }
    public JSONObject readtreeTwoData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeTwo != null && TreeData.getInstance().treeTwo.size() > 0) {
                damageDetailstreeTwo = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeTwo.size(); i++) {
                    if (TreeData.getInstance().treeTwo.get(i).getPicturePath() != null) {
                        treeTwoPicturePath = TreeData.getInstance().treeTwo.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeTwo.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeTwo.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeTwo.get(i).getKvaSize();
                        if (TreeData.getInstance().treeTwo.get(i).getSubTitle() != null) {
                            damageDetailstreeTwo.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeTwo.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeTwo.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeTwo.get(i).getNote();
                        if (TreeData.getInstance().treeTwo.get(i).getSubTitle() != null) {
                            damageDetailstreeTwo.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeTwo.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeTwo.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeTwo.get(i).getExtent();
                        if (TreeData.getInstance().treeTwo.get(i).getSubTitle() != null) {
                            damageDetailstreeTwo.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeTwo.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeTwo.get(i).getTitle();
                    if (TreeData.getInstance().treeTwo.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeTwo.get(i).getDisplayName());
                    if (TreeData.getInstance().treeTwo.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeTwo.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeTwo.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeTwo.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeTwo.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeTwo;
    }
    public JSONObject readtreeThreeData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeThree != null && TreeData.getInstance().treeThree.size() > 0) {
            damageDetailstreeThree = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeThree.size(); i++) {
                    if (TreeData.getInstance().treeThree.get(i).getPicturePath() != null) {
                        treeThreePicturePath = TreeData.getInstance().treeThree.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeThree.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeThree.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeThree.get(i).getKvaSize();
                        if (TreeData.getInstance().treeThree.get(i).getSubTitle() != null) {
                            damageDetailstreeThree.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeThree.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeThree.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeThree.get(i).getNote();
                        if (TreeData.getInstance().treeThree.get(i).getSubTitle() != null) {
                            damageDetailstreeThree.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeThree.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeThree.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeThree.get(i).getExtent();
                        if (TreeData.getInstance().treeThree.get(i).getSubTitle() != null) {
                            damageDetailstreeThree.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeThree.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeThree.get(i).getTitle();
                    if (TreeData.getInstance().treeThree.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeThree.get(i).getDisplayName());
                    if (TreeData.getInstance().treeThree.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeThree.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeThree.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeThree.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeThree.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeThree;
    }
    public JSONObject readtreeFourData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeFour != null && TreeData.getInstance().treeFour.size() > 0) {
            damageDetailstreeFour = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeFour.size(); i++) {
                    if (TreeData.getInstance().treeFour.get(i).getPicturePath() != null) {
                        treeFourPicturePath = TreeData.getInstance().treeFour.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeFour.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeFour.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeFour.get(i).getKvaSize();
                        if (TreeData.getInstance().treeFour.get(i).getSubTitle() != null) {
                            damageDetailstreeFour.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeFour.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeFour.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeFour.get(i).getNote();
                        if (TreeData.getInstance().treeFour.get(i).getSubTitle() != null) {
                            damageDetailstreeFour.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeFour.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeFour.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeFour.get(i).getExtent();
                        if (TreeData.getInstance().treeFour.get(i).getSubTitle() != null) {
                            damageDetailstreeFour.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeFour.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeFour.get(i).getTitle();
                    if (TreeData.getInstance().treeFour.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeFour.get(i).getDisplayName());
                    if (TreeData.getInstance().treeFour.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeFour.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeFour.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeFour.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeFour.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeFour;
    }
    public JSONObject readtreeFiveData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeFive != null && TreeData.getInstance().treeFive.size() > 0) {
            damageDetailstreeFive = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeFive.size(); i++) {
                    if (TreeData.getInstance().treeFive.get(i).getPicturePath() != null) {
                        treeFivePicturePath = TreeData.getInstance().treeFive.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeFive.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeFive.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeFive.get(i).getKvaSize();
                        if (TreeData.getInstance().treeFive.get(i).getSubTitle() != null) {
                            damageDetailstreeFive.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeFive.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeFive.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeFive.get(i).getNote();
                        if (TreeData.getInstance().treeFive.get(i).getSubTitle() != null) {
                            damageDetailstreeFive.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeFive.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeFive.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeFive.get(i).getExtent();
                        if (TreeData.getInstance().treeFive.get(i).getSubTitle() != null) {
                            damageDetailstreeFive.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeFive.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeFive.get(i).getTitle();
                    if (TreeData.getInstance().treeFive.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeFive.get(i).getDisplayName());
                    if (TreeData.getInstance().treeFive.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeFive.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeFive.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeFive.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeFive.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeFive;
    }

    public JSONObject readtreeSixData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeSix != null && TreeData.getInstance().treeSix.size() > 0) {
            damageDetailstreeSix = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeSix.size(); i++) {
                    if (TreeData.getInstance().treeSix.get(i).getPicturePath() != null) {
                        treeSixPicturePath = TreeData.getInstance().treeSix.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeSix.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeSix.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeSix.get(i).getKvaSize();
                        if (TreeData.getInstance().treeSix.get(i).getSubTitle() != null) {
                            damageDetailstreeSix.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeSix.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeSix.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeSix.get(i).getNote();
                        if (TreeData.getInstance().treeSix.get(i).getSubTitle() != null) {
                            damageDetailstreeSix.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeSix.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeSix.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeSix.get(i).getExtent();
                        if (TreeData.getInstance().treeSix.get(i).getSubTitle() != null) {
                            damageDetailstreeSix.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeSix.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeSix.get(i).getTitle();
                    if (TreeData.getInstance().treeSix.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeSix.get(i).getDisplayName());
                    if (TreeData.getInstance().treeSix.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeSix.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeSix.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeSix.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeSix.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeSix;
    }

    public JSONObject readtreeSevenData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeSeven != null && TreeData.getInstance().treeSeven.size() > 0) {
            damageDetailstreeSeven = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeSeven.size(); i++) {
                    if (TreeData.getInstance().treeSeven.get(i).getPicturePath() != null) {
                        treeSevenPicturePath = TreeData.getInstance().treeSeven.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeSeven.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeSeven.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeSeven.get(i).getKvaSize();
                        if (TreeData.getInstance().treeSeven.get(i).getSubTitle() != null) {
                            damageDetailstreeSeven.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeSeven.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeSeven.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeSeven.get(i).getNote();
                        if (TreeData.getInstance().treeSeven.get(i).getSubTitle() != null) {
                            damageDetailstreeSeven.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeSeven.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeSeven.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeSeven.get(i).getExtent();
                        if (TreeData.getInstance().treeSeven.get(i).getSubTitle() != null) {
                            damageDetailstreeSeven.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeSeven.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeSeven.get(i).getTitle();
                    if (TreeData.getInstance().treeSeven.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeSeven.get(i).getDisplayName());
                    if (TreeData.getInstance().treeSeven.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeSeven.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeSeven.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeSeven.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeSeven.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeSeven;
    }

    public JSONObject readtreeEightData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeEight != null && TreeData.getInstance().treeEight.size() > 0) {
            if (damageDetailstreeEight == null)
                damageDetailstreeEight = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeEight.size(); i++) {
                    if (TreeData.getInstance().treeEight.get(i).getPicturePath() != null) {
                        treeEightPicturePath = TreeData.getInstance().treeEight.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeEight.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeEight.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeEight.get(i).getKvaSize();
                        if (TreeData.getInstance().treeEight.get(i).getSubTitle() != null) {
                            damageDetailstreeEight.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeEight.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeEight.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeEight.get(i).getNote();
                        if (TreeData.getInstance().treeEight.get(i).getSubTitle() != null) {
                            damageDetailstreeEight.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeEight.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeEight.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeEight.get(i).getExtent();
                        if (TreeData.getInstance().treeEight.get(i).getSubTitle() != null) {
                            damageDetailstreeEight.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeEight.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeEight.get(i).getTitle();
                    if (TreeData.getInstance().treeEight.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeEight.get(i).getDisplayName());
                    if (TreeData.getInstance().treeEight.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeEight.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeEight.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeEight.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeEight.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeEight;
    }

    public JSONObject readtreeNineData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeNine != null && TreeData.getInstance().treeNine.size() > 0) {
            if (damageDetailstreeNine == null)
                damageDetailstreeNine = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeNine.size(); i++) {
                    if (TreeData.getInstance().treeNine.get(i).getPicturePath() != null) {
                        treeNinePicturePath = TreeData.getInstance().treeNine.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeNine.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeNine.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeNine.get(i).getKvaSize();
                        if (TreeData.getInstance().treeNine.get(i).getSubTitle() != null) {
                            damageDetailstreeNine.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeNine.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeNine.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeNine.get(i).getNote();
                        if (TreeData.getInstance().treeNine.get(i).getSubTitle() != null) {
                            damageDetailstreeNine.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeNine.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeNine.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeNine.get(i).getExtent();
                        if (TreeData.getInstance().treeNine.get(i).getSubTitle() != null) {
                            damageDetailstreeNine.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeNine.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeNine.get(i).getTitle();
                    if (TreeData.getInstance().treeNine.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeNine.get(i).getDisplayName());
                    if (TreeData.getInstance().treeNine.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeNine.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeNine.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeNine.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeNine.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeNine;
    }

    public JSONObject readtreeTenData() {
        addNote = null;
        addExtent = null;
        subtitle = null;
        kvaSize = null;
        displayName = null;
        isSelected = false;
        isChecked = false;

        if (TreeData.getInstance().treeTen != null && TreeData.getInstance().treeTen.size() > 0) {
            if (damageDetailstreeTen == null)
                damageDetailstreeTen = new JSONObject();
            try {
                for (int i = 0; i < TreeData.getInstance().treeTen.size(); i++) {
                    if (TreeData.getInstance().treeTen.get(i).getPicturePath() != null) {
                        treeTenPicturePath = TreeData.getInstance().treeTen.get(i).getPicturePath();
//                        padmountsOnePicturePath = padmountsOnePicturePath.substring(padmountsOnePicturePath.lastIndexOf("/") + 1);
                    }


                    if (TreeData.getInstance().treeTen.get(i).getKvaSize() != null) {
                        subtitle = TreeData.getInstance().treeTen.get(i).getSubTitle();
                        kvaSize = TreeData.getInstance().treeTen.get(i).getKvaSize();
                        if (TreeData.getInstance().treeTen.get(i).getSubTitle() != null) {
                            damageDetailstreeTen.put(subtitle, kvaSize);
                        }
                    }
                    if (TreeData.getInstance().treeTen.get(i).getNote() != null) {
                        subtitle = TreeData.getInstance().treeTen.get(i).getSubTitle();
                        addNote = TreeData.getInstance().treeTen.get(i).getNote();
                        if (TreeData.getInstance().treeTen.get(i).getSubTitle() != null) {
                            damageDetailstreeTen.put(subtitle, addNote);
                        }
                    }
                    if (TreeData.getInstance().treeTen.get(i).getExtent() != null) {
                        subtitle = TreeData.getInstance().treeTen.get(i).getSubTitle();
                        addExtent = TreeData.getInstance().treeTen.get(i).getExtent();
                        if (TreeData.getInstance().treeTen.get(i).getSubTitle() != null) {
                            damageDetailstreeTen.put(subtitle, addExtent);
                        }
                    }


                    if (TreeData.getInstance().treeTen.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeTen.get(i).getTitle();
                    if (TreeData.getInstance().treeTen.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeTen.get(i).getDisplayName());
                    if (TreeData.getInstance().treeTen.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeTen.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeTen.get(i).getName();

                        if (isSelected) {

                            damageDetailstreeTen.put(displayName, isSelected);
                        }
                        else
                        {
                            damageDetailstreeTen.remove(displayName);
                        }

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return damageDetailstreeTen;
    }

    public void resetAllReference() {
        try {
            reserPictureName();
            TreeData.getInstance().treeOne.clear();
            TreeData.getInstance().treeTwo.clear();
            TreeData.getInstance().treeThree.clear();
            TreeData.getInstance().treeFour.clear();
            TreeData.getInstance().treeFive.clear();
            TreeData.getInstance().treeSix.clear();
            TreeData.getInstance().treeSeven.clear();
            TreeData.getInstance().treeEight.clear();
            TreeData.getInstance().treeNine.clear();
            TreeData.getInstance().treeTen.clear();


        } catch (NullPointerException e) {

        }
    }

    private void reserPictureName() {
        treeOnePicturePath = null;
        treeTwoPicturePath = null;
        treeThreePicturePath = null;
        treeFourPicturePath = null;
        treeFivePicturePath = null;
        treeSixPicturePath = null;
        treeSevenPicturePath = null;
        treeEightPicturePath = null;
        treeNinePicturePath = null;
        treeTenPicturePath = null;

    }

    public void resetAllJSONObject() {
        damageDetailstreeOne = null;
        damageDetailstreeTwo = null;
        damageDetailstreeThree = null;
        damageDetailstreeFour = null;
        damageDetailstreeFive = null;
        damageDetailstreeSix = null;
        damageDetailstreeSeven = null;
        damageDetailstreeEight = null;
        damageDetailstreeNine = null;
        damageDetailstreeTen = null;

    }
}
