package vda.irestore.com.vda_android.localDB;

/**
 * Created by dell on 08-01-2018.
 */

public class MyReportData {
    String REPORT;
    String ADDRESS;
    String POLE_ID;
    String POLE_HEIGHT;
    String DATE;
    String POLETOP;
    String POLE;
    String UNDERGROUND;
    String JSON;

    public String getJsonObject() {
        return JSON;
    }

    public void setJsonObject(String jsonObject) {
        this.JSON = jsonObject;
    }



    public String getREPORT() {
        return REPORT;
    }

    public void setREPORT(String REPORT) {
        this.REPORT = REPORT;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getPOLE_ID() {
        return POLE_ID;
    }

    public void setPOLE_ID(String POLE_ID) {
        this.POLE_ID = POLE_ID;
    }

    public String getPOLE_HEIGHT() {
        return POLE_HEIGHT;
    }

    public void setPOLE_HEIGHT(String POLE_HEIGHT) {
        this.POLE_HEIGHT = POLE_HEIGHT;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getPOLETOP() {
        return POLETOP;
    }

    public void setPOLETOP(String POLETOP) {
        this.POLETOP = POLETOP;
    }

    public String getPOLE() {
        return POLE;
    }

    public void setPOLE(String POLE) {
        this.POLE = POLE;
    }

    public String getUNDERGROUND() {
        return UNDERGROUND;
    }

    public void setUNDERGROUND(String UNDERGROUND) {
        this.UNDERGROUND = UNDERGROUND;
    }

    public String getOTHER() {
        return OTHER;
    }

    public void setOTHER(String OTHER) {
        this.OTHER = OTHER;
    }

    String OTHER;

    public MyReportData(String report, String address, String pole_id,
                        String poleHeight, String date, String isPoleTOp,
                        String isPole, String isUndeground, String isOther/*,String jsonObject*/) {
        REPORT = report;
        ADDRESS = address;
        POLE_ID = pole_id;
        POLE_HEIGHT = poleHeight;
        DATE = date;
        POLETOP = isPoleTOp;
        POLE = isPole;
        UNDERGROUND = isUndeground;
        OTHER = isOther;
      /*  JSON = jsonObject;*/
    }

    public MyReportData(String string, String string1) {
    }
}
