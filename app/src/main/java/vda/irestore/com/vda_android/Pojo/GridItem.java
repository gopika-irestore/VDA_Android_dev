package vda.irestore.com.vda_android.Pojo;

import java.util.HashMap;

public class GridItem {
    private String image;
    private String imageName;
    private String title;
    boolean deleted;
    private String name;
    private Boolean inspectionDone;

    public Boolean getInspectionDone() {
        return inspectionDone;
    }

    public void setInspectionDone(Boolean inspectionDone) {
        this.inspectionDone = inspectionDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS3ImageName() {
        return s3ImageName;
    }

    public void setS3ImageName(String s3ImageName) {
        this.s3ImageName = s3ImageName;
    }

    private String s3ImageName;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL_path() {
        return imageURL_path;
    }

    public void setImageURL_path(String imageURL_path) {
        this.imageURL_path = imageURL_path;
    }

    private String imageURL_path;


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String note;
    HashMap<String,String> data;
    HashMap<String,String> type;
    HashMap<String,String> utilityOwned;

    public HashMap<String, String> getDoublePole() {
        return doublePole;
    }

    public void setDoublePole(HashMap<String, String> doublePole) {
        this.doublePole = doublePole;
    }

    HashMap<String,String> doublePole;

    public HashMap<String, String> getType() {
        return type;
    }

    public void setType(HashMap<String, String> type) {
        this.type = type;
    }

    HashMap<String,String> soundTest;
    HashMap<String,String> visualTest;

    public HashMap<String, String> getSoundTest() {
        return soundTest;
    }

    public void setSoundTest(HashMap<String, String> soundTest) {
        this.soundTest = soundTest;
    }

    public HashMap<String, String> getVisualTest() {
        return visualTest;
    }

    public void setVisualTest(HashMap<String, String> visualTest) {
        this.visualTest = visualTest;
    }

    public HashMap<String, String> getResistographTest() {
        return resistographTest;
    }

    public void setResistographTest(HashMap<String, String> resistographTest) {
        this.resistographTest = resistographTest;
    }

    HashMap<String,String> resistographTest;
    public HashMap<String, String> getVoltageTest() {
        return voltageTest;
    }

    public void setVoltageTest(HashMap<String, String> voltageTest) {
        this.voltageTest = voltageTest;
    }

    HashMap<String,String> voltageTest;


    public HashMap<String, String> getUtilityOwned() {
        return utilityOwned;
    }

    public void setUtilityOwned(HashMap<String, String> utilityOwned) {
        this.utilityOwned = utilityOwned;
    }



    public HashMap<String, String> getSize() {
        return size;
    }

    public void setSize(HashMap<String, String> size) {
        this.size = size;
    }

    HashMap<String,String> size;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }




    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }



    public GridItem() {
        super();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
