package vda.irestore.com.vda_android.Pojo;

/**
 * Created by MALBEL on 07-08-2017.
 */

public class InspectionMetaData {

    String name = null;
    String displayName = null;
    String imageUrl = null;
    String imageName = null;
    String note = null;
    String title = null;
    String picturePath = null;
    String testPicturePath = null;
    String testType = null;
    String kvaSize = null;
    String subTitle = null;
    String testingType = null;
    String testingTypePass = null;

    Boolean testResult = null;
    Boolean isSelected = false;
    Boolean isCheckOK = false;
    Boolean isUtilityOwned = false;
    Boolean isTesttingResult = false;
    Boolean isTesstingPassResult = false;
    int selectPosition = -1;

    // Damage part detatils constructing
    public InspectionMetaData(String displayName, String name, String imageUrl, String imageName, boolean isSelected, String mainTitle) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.imageName = imageName;
        this.displayName = displayName;
        this.isSelected = isSelected;
        this.title = mainTitle;
        this.isCheckOK = null;
        this.isUtilityOwned = null;
        this.picturePath = null;
        this.testPicturePath = null;
    }

//    public InspectionMetaData(String name, String imageUrl, String imageName) {
//        this.name = name;
//        this.imageUrl = imageUrl;
//        this.imageName = imageName;
//        this.displayName = displayName;
//    }

    // checked ok details
    public InspectionMetaData(boolean isCheckOK, String title, String subTitle) {
        this.isCheckOK = isCheckOK;
        this.title = title;
        this.subTitle = subTitle;
        this.displayName = null;
        this.imageUrl = null;
        this.isSelected = null;
        this.isUtilityOwned = null;
        this.picturePath = null;
        this.testPicturePath = null;
    }

    // Adding note details
    public InspectionMetaData(String note, String title, String subTitle) {
        this.note = note;
        this.title = title;
        this.subTitle = subTitle;
        this.displayName = null;
        this.imageUrl = null;
        this.isSelected = null;
        this.isCheckOK = null;
        this.isUtilityOwned = null;
        this.picturePath = null;
        this.testPicturePath = null;
    }

    // adding kva size details
    public InspectionMetaData(String size, int selectPos, String title, String subTitle) {
        this.kvaSize = size;
        this.selectPosition = selectPos;
        this.title = title;
        this.subTitle = subTitle;
        this.isCheckOK = null;
        this.isUtilityOwned = null;
        this.picturePath = null;
        this.testPicturePath = null;
    }

    // adding picture path
    public InspectionMetaData(String picturePath, String title) {
        this.picturePath = picturePath;
        this.testPicturePath = null;
        this.title = title;
        this.isCheckOK = null;
        this.isUtilityOwned = null;
    }

    // adding picture path based on testing (voltage)
    public InspectionMetaData(String testPicturePath, String title, String testType, boolean testResult) {
        this.testPicturePath = testPicturePath;
        this.picturePath = null;
        this.title = title;
        this.testType = testType;
        this.testResult = testResult;
        this.isCheckOK = null;
        this.isUtilityOwned = null;
    }

    // adding utility
    public InspectionMetaData(Boolean isUtilityOwned, String title, String subTitle, String utilityCheck) {
        this.isUtilityOwned = isUtilityOwned;
        this.subTitle = subTitle;
        this.title = title;
        this.isCheckOK = null;
        this.picturePath = null;
        this.testPicturePath = null;
    }

    public InspectionMetaData(String title, String testType, Boolean testTyperesult, String testTypePass, Boolean testTypePassResult) {
        this.title = title;
        this.testingType = testType;
        this.isTesttingResult = testTyperesult;
        this.testingTypePass = testTypePass;
        this.isTesstingPassResult = testTypePassResult;
    }
//
//    public InspectionMetaData(String name, String imageUrl) {
//        this.name = name;
//        this.imageUrl = imageUrl;
//    }

    public String getTestingType() {
        return this.testingType;
    }

    public String getTestingTypePass() {
        return this.testingTypePass;
    }

    public Boolean getIsTesttingResult() {
        return this.isTesttingResult;
    }

    public Boolean getIsTesstingPassResult() {
        return this.isTesstingPassResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getImageName() {
        return imageName;
    }

    public String getNote() {
        return this.note;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public void setIsCheckedOK(Boolean checkOK) {
        this.isCheckOK = checkOK;
    }

    public Boolean getCheckedOK() {
        return this.isCheckOK;
    }

    public String getKvaSize() {
        return this.kvaSize;
    }

    public int getSelectPosition() {
        return this.selectPosition;
    }

    public String getPicturePath() {
        return this.picturePath;
    }

    public String getTestPicturePath() {
        return this.testPicturePath;
    }

    public String getTestType() {
        return this.testType;
    }

    public Boolean getTestResult() {
        return this.testResult;
    }

    public Boolean getIsUtilityOwned() {
        return this.isUtilityOwned;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
