package vda.irestore.com.vda_android.readData;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ReadTreeData {
    public static ReadTreeData readTreeData = null;
    public String treeOnePicturePath = null, treeTwoPicturePath = null, treeThreePicturePath = null, treeFourPicturePath = null,
            treeFivePicturePath = null, treeSixPicturePath = null, treeSevenPicturePath = null, treeEightPicturePath = null, treeNinePicturePath = null, treeTenPicturePath = null;

    String addNote, subtitle, kvaSize, displayName, testType, size;
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


                    if (TreeData.getInstance().treeOne.get(i).getTitle() != null)
                        treeTitle = TreeData.getInstance().treeOne.get(i).getTitle();
                    if (TreeData.getInstance().treeOne.get(i).getDisplayName() != null)
                        Log.i("DINESH_LOG", "Display Name = " + TreeData.getInstance().treeOne.get(i).getDisplayName());
                    if (TreeData.getInstance().treeOne.get(i).getIsSelected() != null) {
                        isSelected = TreeData.getInstance().treeOne.get(i).getIsSelected();
                        displayName = TreeData.getInstance().treeOne.get(i).getName();
                        Log.i("Shri_LOG", "Display Name = " + TreeData.getInstance().treeOne.get(i).getDisplayName()+" ");
                        Log.i("Shri_LOG", "Name = " + TreeData.getInstance().treeOne.get(i).getName()+" ");

                        if (isSelected) {
                            Log.i("Shri_LOG111", "Name = " + TreeData.getInstance().treeOne.get(i).getName()+" ");
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

}
