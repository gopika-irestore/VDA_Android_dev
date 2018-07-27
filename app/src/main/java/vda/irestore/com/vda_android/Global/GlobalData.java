package vda.irestore.com.vda_android.Global;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import vda.irestore.com.vda_android.Adapters.InspectionMetaDataAdapter;
import vda.irestore.com.vda_android.R;


/**
 * Created by dell on 08-01-2018.
 */

public class GlobalData {
    public static boolean isPoleTopAllOk = false;
    public static String isPoleTopAllOk_JSON;
    public static GlobalData globalData = null;
    public static boolean isPoleTopActivity = true;
    public static boolean isPoleActivity = true;
    public static boolean isUndegroundActivity = true;
    public static boolean isOtherActivity = true;
    public  static List<File> pole_top_images_array  = new ArrayList<File>();
    public  static List<File> pole_images_array  = new ArrayList<File>();
    public  static List<File> tree_images_array  = new ArrayList<File>();
    public  static List<File> underground_images_array  = new ArrayList<File>();
    public  static List<File> other_images_array  = new ArrayList<File>();

    public static SharedPreferences scopesPreferences,metadataPreferences;
    public static SharedPreferences.Editor scopesPreferencesEditor,metadataPreferencesEditor;
    public InspectionMetaDataAdapter arrayAdapter = null;
    public InspectionMetaDataAdapter arrayAdapterPole = null;

    //Pole activity adapter
    public ArrayAdapter sizeAdapter = null;
    public Spinner sizeSpinner = null;
    public ArrayAdapter typeAdapter = null;
    public Spinner typeSpinner = null;

    public ArrayList numberOfTransformerDefects = null,
            numberOfCrossArmDefect = null,
            numberOfFusedCutOutDefect = null,
            numberOfPoleAttachmentDefect = null,
            numberOfStreetLightDefect = null,
            numberOfPoleTopPinDefect = null,
            numberOfInsulatorDefect = null,
            numberOfPrimaryDefect = null,
            numberOfSecondaryDefect = null,
            numberOfServiceWireDefect = null;

    public ArrayList numberOfPoleDefects = null,
            numberOfGuyWireDefects = null,
            numberOfAnchorDefects = null,
            numberOfPrimaryRiserDefect = null,
            numberOfSecondaryRiserDefect = null,
            numberOfPoleGroungDefect = null,
            numberOfVegetationDefect = null;
    public ArrayList numberOfTreeDefects = null;


    public ArrayList numberOfPadmountsDefects = null,
            numberOfPullBoxDefect = null,
            numberOfSpiceBoxDefect = null,
            numberOfSectionalizerCabinetDefect = null;

    public ArrayList numberOfRegulatorDefects = null,
            numberOfCapacitorbankDefect = null,
            numberOfRecloserDefect = null,
            numberOfLoadBreakSwitchDefect = null;

    public static synchronized GlobalData getInstance (){
            if(globalData == null)
                globalData = new GlobalData();
            else
                return globalData;
        return globalData;
    }
    public static void initializeSharedPrefernceData(Context context) {
        scopesPreferences  = context.getSharedPreferences(context.getString(
                R.string.scopes_preferences), Context.MODE_PRIVATE);
        scopesPreferencesEditor = GlobalData.scopesPreferences.edit();
        metadataPreferences = context.getSharedPreferences(context.getString(
                R.string.metadataPreferences), Context.MODE_PRIVATE);
        metadataPreferencesEditor = GlobalData.metadataPreferences.edit();
    }

}
