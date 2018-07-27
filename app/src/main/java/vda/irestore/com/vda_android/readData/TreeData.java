package vda.irestore.com.vda_android.readData;

import java.util.ArrayList;

import vda.irestore.com.vda_android.Pojo.InspectionMetaData;

public class TreeData {
    private static TreeData treeData = null;

    public ArrayList<InspectionMetaData> treeOne;
    public ArrayList<InspectionMetaData> treeTwo;
    public ArrayList<InspectionMetaData> treeThree;
    public ArrayList<InspectionMetaData> treeFour;
    public ArrayList<InspectionMetaData> treeFive;
    public ArrayList<InspectionMetaData> treeSix;
    public ArrayList<InspectionMetaData> treeSeven;
    public ArrayList<InspectionMetaData> treeEight;
    public ArrayList<InspectionMetaData> treeNine;
    public ArrayList<InspectionMetaData> treeTen;

    private TreeData() {
        initializeTree();    }
    private void initializeTree() {
        treeOne = new ArrayList<>();
        treeTwo = new ArrayList<>();
        treeThree = new ArrayList<>();
        treeFour = new ArrayList<>();
        treeFive = new ArrayList<>();
        treeSix = new ArrayList<>();
        treeSeven = new ArrayList<>();
        treeEight = new ArrayList<>();
        treeNine = new ArrayList<>();
        treeTen = new ArrayList<>();
    }

    public static synchronized TreeData getInstance(){
        if(treeData == null)
            treeData = new TreeData();
        else
            return treeData;
        return treeData;
    }
}
