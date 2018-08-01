package vda.irestore.com.vda_android.localDB;

/**
 * Created by MALBEL on 13-12-2017.
 */

public class Department {
    public Department(String name, String type, Boolean isSelected, String displayName) {
        this.name = name;
        this.type = type;
        this.isSelected = isSelected;
        this.displayName = displayName;
    }

    public Department(String id, String name, String type, Boolean isSelected, String displayName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.isSelected = isSelected;
        this.displayName = displayName;
    }

    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Department(String id, Boolean isSelected, String displayName) {
        this.id = id;
        this.isSelected = isSelected;
        this.displayName = displayName;
    }

   /* public Department(int id, Boolean isSelected, String displayName) {
       this.id=id;

        this.isSelected = isSelected;
        this.displayName = displayName;
    }*/

    Boolean isSelected;



    String displayName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


}
