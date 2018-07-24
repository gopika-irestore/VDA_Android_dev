package vda.irestore.com.vda_android;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import vda.irestore.com.vda_android.Adapters.GridViewAdapter;
import vda.irestore.com.vda_android.Global.Global;

import vda.irestore.com.vda_android.Pojo.GridItem;
import vda.irestore.com.vda_android.Pojo.InspectionMetaData;
import vda.irestore.com.vda_android.signup.PermissionsActivity;

import static vda.irestore.com.vda_android.Global.Global.credentialsProvider;
import static vda.irestore.com.vda_android.Global.Global.initializeSharedPrefernceData;


public class PoleActivity extends PermissionsActivity {
    SharedPreferences sharedPref,userPreferences, scopesPreferences, metadataPreferences;
    SharedPreferences.Editor scopesPreferencesEditor, metadataPreferencesEditor;
    String addSizeKey, addTypeKey, utilityKey, doublePoleKey, voltageTestKey, soundTestKey, visualTestKey, resistrographTestKey;
    boolean isListSelected = true, isJointOwnSelected = true, isAddNoteSelected = true, isCheckOkSelected = true, isTestingImageSelected = true,
        isPoleClassSelected = true, isPoleHeightSelected = true, isDoublePoleselected = true, isVoltageTestingSelected = true, isVisualTestingSelected = true,
        isSoundTestingSelected = true, isResistographSelected = true;
    int i = 1;
    final public int REQUEST_CAMERA_ONE = 21;
    final public int REQUEST_CAMERA_TWO = 22;
    final public int REQUEST_CAMERA_THREE = 23;
    final public int REQUEST_CAMERA_FOUR = 24;
    final public int REQUEST_CAMERA_FIVE = 25;
    final String joint_own = "jointowned";
    final String double_pole = "doublepole";
    final String pole_class = "poleclass";
    final String pole_height = "poleheight";
    final String guy_guard = "guyguard";
    ImageView partImage, testingImage, soundTestingImage, visualTestingImage, resistrographTestingImage;
    String poleScopeImage, poleScopeTestingImage, poleScopeSoundTestingImages, picturePath, partTitle, poleScopeResistrographTestingImages, poleScopeVisualTestingImages;
    static String poleObject, poleObjectPreview;
    static boolean poleAllOk = false;
    static boolean isPoleAllOk = true;
    private GridView mGridView_pole;
    private GridViewAdapter mGridAdapter;
    private ArrayList<GridItem> mGridData_pole;

    private ArrayList<GridItem> mGridDataJSON;

    Object selectedSize, selectedType;
    Typeface typeFace;
    TextView partsCompleted, selectPartHeader;
    JSONArray poleJsonArray, poleMetadataJsonArrayList;

    ArrayList<InspectionMetaData> pole_inspectionData_list;
//    InspectionMetaDataAdapter arrayAdapter = null;
    Switch utilityOwnedSwitch, doublePoleSwitch;
    ListView listView = null;
    RecyclerView horizontalListView;


    Button closeBtn, closeAddNoteBtn;
    ImageView addNoteBtn;
    static int polePartCompleted = 0;
    int horizontalItemSelectedPosition = -1, verticalItemSelectedPosition = -1, gridPositionNew = 0, localIndexToAddNote = -1;
    String gridTitle = null;
    ArrayList<InspectionMetaData> localInspectionMetaData;

    HashMap<String, JSONObject> poleParts_damageMetaDataPreview = new HashMap<>();

    HashMap<String, JSONObject> poleParts_Images = new HashMap<>();
    HashMap<String, JSONObject> poleTesting_Images = new HashMap<>();
    HashMap<String, JSONObject> poleSoundTesting_Images = new HashMap<>();
    HashMap<String, JSONObject> poleVisualTesting_Images = new HashMap<>();
    HashMap<String, JSONObject> poleResistrographTesting_Images = new HashMap<>();

    HashMap<String, Boolean> polechecked = new HashMap<>();
    JSONObject poleAllOkObject = new JSONObject();
    ImageView testOkImage, testOkYesImage, testOkNoImage,
            soundTestOkImage, soundTestYesImage, soundTestNoImage,
            visualTestOkImage, visualTestYesImage, visualTestNoImage,
            resistrographTestOkImage, resistrographTestYesImage, resistrographTestNoImage;

    AmazonS3 s3;
    TransferUtility transferUtility;
    CheckBox allOkBtn;
    JSONObject isVoltageTestingObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_partspole);
        typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        polePartCompleted = 0;

        isListSelected = true; isJointOwnSelected = true; isAddNoteSelected = true; isCheckOkSelected = true; isTestingImageSelected = true;
                isPoleClassSelected = true; isPoleHeightSelected = true; isDoublePoleselected = true; isVoltageTestingSelected = true; isVisualTestingSelected = true;
                isSoundTestingSelected = true; isResistographSelected = true;

        initializeSharedPrefernceData(this);
        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);



        scopesPreferences = getSharedPreferences(getString(
                R.string.scopes_preferences), Context.MODE_PRIVATE);
        scopesPreferencesEditor = scopesPreferences.edit();
        metadataPreferences = getSharedPreferences(getString(
                R.string.metadataPreferences), Context.MODE_PRIVATE);
        metadataPreferencesEditor = metadataPreferences.edit();


        allOkBtn = (CheckBox) findViewById(R.id.allOkBtn);
        allOkBtn.setTypeface(typeFace);

        mGridView_pole = (GridView) findViewById(R.id.grid);

        Gson poleGson = new Gson();

        try {

            String response = Global.metadataPreferences.getString("PoleKey", "");
           // String response = metadataPreferences.getString("PoleKey", "");
            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                    new TypeToken<List<GridItem>>() {
                    }.getType());

            if (poleGridItems_ArrayList != null) {
                mGridData_pole = poleGridItems_ArrayList;
                poleJsonArray = new JSONArray(Global.metadataPreferences.getString("PoleKey", "").trim());
            } else {
                mGridData_pole = new ArrayList<>();
                poleJsonArray = new JSONArray(Global.scopesPreferences.getString("poleJSON", "").trim());
            }
            mGridAdapter = new GridViewAdapter(this, R.layout.grid_single, mGridData_pole);
            mGridView_pole.setAdapter(mGridAdapter);

            GridItem item;
            HashMap<String, String> inspectionData_map = new HashMap<>();
            HashMap<String, String> size = new HashMap<>();
            HashMap<String, String> utilityOwned = new HashMap<>();
            HashMap<String, String> doublePole = new HashMap<>();
            HashMap<String, String> voltageTest = new HashMap<>();
            HashMap<String, String> visualTest = new HashMap<>();
            HashMap<String, String> resistographTest = new HashMap<>();
            HashMap<String, String> soundTest = new HashMap<>();
            HashMap<String, String> type = new HashMap<>();

            for (int i = 0; i < poleJsonArray.length(); i++) {
                JSONObject poleObj = poleJsonArray.optJSONObject(i);

                String title = poleObj.optString("displayName");
                String name = poleObj.optString("name");
                final String imageUrl = poleObj.optString("imageURL");
                //    String s3ImageName = poleTopObj.optString("s3imageName");
               /* final String imageUrl = poleObj.optString("imageURL");
                final String imageName = poleObj.optString("imagename");

                inspectionData_map.put(title, poleObj.getJSONArray("MetaData").toString());

                if (poleObj.has("AssetSize"))
                    size.put(title, poleObj.getJSONObject("AssetSize").toString());
                else
                    size.put(title, "");

                if (poleObj.has("UtilityOwned"))
                    utilityOwned.put(title, poleObj.getJSONObject("UtilityOwned").toString());
                else
                    utilityOwned.put(title, "");


                if (poleObj.has("AssetType"))
                    type.put(title, poleObj.getJSONObject("AssetType").toString());
                else
                    type.put(title, "");

                if (poleObj.has("DoublePole"))
                    doublePole.put(title, poleObj.getJSONObject("DoublePole").toString());
                else
                    doublePole.put(title, "");

                if (poleObj.has("VoltageTest"))
                    voltageTest.put(title, poleObj.getJSONObject("VoltageTest").toString());
                else
                    voltageTest.put(title, "");

                if (poleObj.has("ResistographTest"))
                    resistographTest.put(title, poleObj.getJSONObject("ResistographTest").toString());
                else
                    resistographTest.put(title, "");

                if (poleObj.has("SoundTest"))
                    soundTest.put(title, poleObj.getJSONObject("SoundTest").toString());
                else
                    soundTest.put(title, "");
                if (poleObj.has("VisualTest"))
                    visualTest.put(title, poleObj.getJSONObject("VisualTest").toString());
                else
                    visualTest.put(title, "");

                Log.i("vidisha", "voltageTest" + voltageTest.get("VoltageTest"));
*/
                item = new GridItem();
                item.setTitle(title);
                item.setName(name);
                item.setImage(imageUrl);
             /*   item.setImage(imageUrl);
                item.setImageName(imageName);
                item.setInspectionDone(false);
                item.setDeleted(false);
                item.setVoltageTest(voltageTest);
                item.setResistographTest(resistographTest);
                item.setSoundTest(soundTest);
                item.setVisualTest(visualTest);

                // item.setS3ImageName(s3ImageName);
                item.setData(inspectionData_map);
                item.setSize(size);
                item.setUtilityOwned(utilityOwned);
                item.setDoublePole(doublePole);
                item.setType(type);*/
                mGridData_pole.add(item);
            }
            mGridAdapter.setGridData(mGridData_pole);
            mGridAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


  }