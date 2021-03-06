package vda.irestore.com.vda_android;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.Global.GlobalData;
import vda.irestore.com.vda_android.Global.Utils;
import vda.irestore.com.vda_android.customUI.NonScrollListView;
import vda.irestore.com.vda_android.readData.PoleData;
import vda.irestore.com.vda_android.readData.PoleTopEquipmentData;
import vda.irestore.com.vda_android.readData.ReadPoleEquipmentData;
import vda.irestore.com.vda_android.readData.ReadPoleTopEquipmentData;
import vda.irestore.com.vda_android.readData.ReadSplEquipmentData;
import vda.irestore.com.vda_android.readData.ReadTreeData;
import vda.irestore.com.vda_android.readData.ReadUnderGroundData;
import vda.irestore.com.vda_android.readData.ReadWireData;
import vda.irestore.com.vda_android.readData.TreeData;

import static vda.irestore.com.vda_android.AndroidCameraApi.imageName1;
import static vda.irestore.com.vda_android.Global.Global.S3_URL;
import static vda.irestore.com.vda_android.Global.GlobalData.pole_images_array;
import static vda.irestore.com.vda_android.Global.GlobalData.pole_top_images_array;
import static vda.irestore.com.vda_android.Global.GlobalData.selectedFeederLine1;
import static vda.irestore.com.vda_android.Global.GlobalData.selectedFeederLine2;
import static vda.irestore.com.vda_android.Global.GlobalData.selectedPoleHeight;
import static vda.irestore.com.vda_android.Global.GlobalData.selectedPoleNumber;
import static vda.irestore.com.vda_android.Global.GlobalData.spl_images_array;
import static vda.irestore.com.vda_android.Global.GlobalData.tree_images_array;
import static vda.irestore.com.vda_android.Global.GlobalData.underground_images_array;
import static vda.irestore.com.vda_android.Global.GlobalData.wire_images_array;
import static vda.irestore.com.vda_android.Global.Utils.images_array;
import static vda.irestore.com.vda_android.MainActivity.panoImageTaken;
import static vda.irestore.com.vda_android.ShooterActivity.panoImageURL1;

public class Submission_screen extends Activity {
    TextView submit,lat_long,spinner;
    private static final int CONNECTION_TIMEOUT = 6000;
    Exception exception;
    AmazonS3 s3;
    TransferUtility transferUtility;
    JSONObject inspectionReport;
    private ImageView m1,m2,m3,m4,m5,m6;
    int firstimage = 0;
    int secondimage = 0;
    int thirdimage = 0;
    int fourthimage = 0;
    int fifthimage = 0;
    int sixthimage = 0;
    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    double latitude ;
    double longitude ;
    Geocoder geocoder;
    LinearLayout detailsLayout;
    SharedPreferences sharedPref, scopesPreferences, metadataPreferences;
    SharedPreferences.Editor scopesPreferencesEditor, metadataPreferencesEditor;
    JSONObject poleScope;// = new JSONObject();
    JSONObject poleTopObj;
    ArrayList v = new ArrayList();
    Typeface typeFace;
    TextView partsLabel,scopesLabel,latLongLabel,lattitude_longitude,roadLabel,policeLabel,wireGuardLabel,poleHeightValue,poleHeightUnit,submitterInfoLabel;
    EditText submitter_email,submitter_contact;
    Switch road_block_switch,police_fireStanding_switch,wire_gurdStanding_switch;

    ImageView damageImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_screen);
        GlobalData.initializeSharedPrefernceData(this);
        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        lat_long = (TextView)findViewById(R.id.lattitude_longitude);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");
        poleScope = new JSONObject();



        setActionBar();
        getLocation();
        amazonS3Setup(this);
        damageImage = findViewById(R.id.damageImage);
        if(Utils.panoBitmap1!=null)
            damageImage.setImageBitmap(Utils.panoBitmap1);
        if(Utils.assetImage!=null)
        {
            damageImage.setImageBitmap(Utils.assetImage);
        }

        Log.i("vidisha","panoImageTaken"+panoImageTaken);
        wireGuardLabel = (TextView)findViewById(R.id.wireGuardLabel) ;
        policeLabel = (TextView)findViewById(R.id.policeLabel);
        roadLabel = (TextView)findViewById(R.id.roadLabel);
        latLongLabel = (TextView)findViewById(R.id.latLongLabel);
        lattitude_longitude = (TextView)findViewById(R.id.lattitude_longitude);

        scopesLabel = (TextView)findViewById(R.id.scopesLabel);
        partsLabel = (TextView)findViewById(R.id.partsLabel);

        road_block_switch = (Switch)findViewById(R.id.road_block_switch);
        police_fireStanding_switch = (Switch)findViewById(R.id.police_fireStanding_switch);
        wire_gurdStanding_switch = (Switch)findViewById(R.id.wire_gurdStanding_switch);
        detailsLayout = (LinearLayout)findViewById(R.id.detailsLayout);
        poleHeightValue = (TextView)findViewById(R.id.poleHeightValue) ;
        poleHeightUnit = (TextView)findViewById(R.id.poleHeightUnit) ;
        submitter_email = (EditText) findViewById(R.id.submitter_email) ;
        submitter_contact = (EditText) findViewById(R.id.submitter_contact) ;
        submitterInfoLabel= (TextView)findViewById(R.id.submitterInfoLabel);
        if(selectedPoleHeight!=null) {
            poleHeightValue.setText(selectedPoleHeight);
        }else
        {
            poleHeightValue.setText("");
        }

        submitter_email.setText(sharedPref.getString("emailAddress", ""));
        submitter_contact.setText(sharedPref.getString("phoneNumber", ""));
        lattitude_longitude.setTypeface(typeFace);
        latLongLabel.setTypeface(typeFace);
        roadLabel.setTypeface(typeFace);
        policeLabel.setTypeface(typeFace);
        wireGuardLabel.setTypeface(typeFace);
        scopesLabel.setTypeface(typeFace);
        partsLabel.setTypeface(typeFace);
        road_block_switch.setTypeface(typeFace);
        police_fireStanding_switch.setTypeface(typeFace);
        wire_gurdStanding_switch.setTypeface(typeFace);
        submitter_contact.setTypeface(typeFace);
        submitter_email.setTypeface(typeFace);
        submitterInfoLabel.setTypeface(typeFace);
        poleHeightUnit.setTypeface(typeFace);
        poleHeightValue.setTypeface(typeFace);

        HashMap<String,String> h = new HashMap();
        h.put("type","Type");
        h.put("phase","Phase");
        h.put("comments","Comment");
        h.put("isAnchorBroken","Anchor/Guy wire - Broken");
        h.put("isAnchorPulled","Anchor/Guy wire - Pulled");
        h.put("extent","Extent");
        h.put("isWireDamaged","Wire Damaged");
        h.put("isWireArcing","Wire Arcing");
        h.put("isLeaking","Leaking");
        h.put("isInAccessible","Inaccessible");
        h.put("isLidMissing","Lid Missing");
        h.put("isDamaged","Damaged");
        h.put("isAnimalGuardMissing","Animal Guard Missing");
        h.put("addnote","Note");
        h.put("isWireHangingLow","Wire Hanging Low");
        h.put("isWireDown","Wire Down");
        h.put("isBroken","Broken");
        h.put("isCracked","Cracked");
        h.put("isRotted","Rotted");
        h.put("isLeaning","Leaning");
        h.put("isBasketballHoop","Basketball Hoop");
        h.put("isAlarm","Alarm");
        h.put("isFloodLight","Flood Light");
        h.put("isOtherIllegal","Other Illegal");
        h.put("utilityowned","Utility Owned");
        h.put("size","Size");
        h.put("isAccessBlocked","Access Blocked (Vegetation)");
        h.put("isRust","Rust");
        h.put("isLockMissing","Lock Missing");
        h.put("isBrokenGlobe","Broken Globe");
        h.put("isCleaningNeeded","Need Cleaning");
        h.put("isMissingBrace","Missing Brace");
        h.put("isInsectDamage","Insect Damage");
        h.put("isVoltageTesting","Voltage Test");

        h.put("isVoltageTestingPass","Voltage Test Pass");
        h.put("isVineGrowth","Vine Growth");
        h.put("isLimbOnWire","Limb On Wire");
        h.put("isTreeOnWire","Tree On Wire");
        h.put("isBrokenLimbAbove","Tree On Wire Burning");
        h.put("isCheckedOK","Checked OK");
        h.put("isBrokenLimbAbovePrimary","Broken Limb above Primary");
        h.put("isBlownLightingArrestor","Blown Lighting Arrestor");
        h.put("isLooseBolts","Loose Bolts");
        h.put("isNotPresent","Not Present");
        h.put("notPresent","Not Present");
        //  h.put("isNotPresent","Missing");
        h.put("Pole Height","Pole Height");
        h.put("Pole Class","Pole Class");
        h.put("jointowned","Joint Owned");
        h.put("doublepole","Double Pole");
        h.put("guyguard","Guy Guard");
        h.put("poleheight","Pole Height");
        h.put("poleclass","Pole Class");
        h.put("jointowned","Joint Owned");
        h.put("doublepole","Double Pole");
        h.put("guyguard","Guy Guard");
        h.put("isLoose","Loose");
        h.put("isPulledOut","Pulled Out");
        h.put("isNeedAnchor","Need Anchor");
        h.put("isCut","Cut/Disconnected");
        h.put("isGroundRodMissing","Ground rod above grade/missing");
        h.put("isVisualTest","Visual Test");
        h.put("isVisualTestPass","Visual Test Pass");
        h.put("isSoundTest","Sound Test");
        h.put("isSoundTestPass","Sound Test Pass");
        h.put("isResistographTest","Resistrograph Test");
        h.put("isResistographTestPass","Resistrograph Test Pass");
        h.put("isPoleRejected","Pole Rejected");
        LoadTreeScopeSelectedData();
        LoadPoleScopeSelectedData();
        LoadSPLScopeSelectedData();
        LoadOthersScopeSelectedData();
        LoadWireScopeSelectedData();
        LoadPoleTopScopeSelectedData();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            firstimage = bundle.getInt("wireImage");
            secondimage = bundle.getInt("poletopImage");
            thirdimage = bundle.getInt("splImage");
            fourthimage = bundle.getInt("poleImage");
            fifthimage = bundle.getInt("treeImage");
            sixthimage = bundle.getInt("otherImage");

            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.imageGallery);
            final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(5, 0, 5, 0);

            m1 = new ImageView(getApplicationContext());
            m1.setLayoutParams(lp);

            m2 = new ImageView(getApplicationContext());
            m2.setLayoutParams(lp);

            m3 = new ImageView(getApplicationContext());
            m3.setLayoutParams(lp);

            m4 = new ImageView(getApplicationContext());
            m4.setLayoutParams(lp);

            m5 = new ImageView(getApplicationContext());
            m5.setLayoutParams(lp);

            m6 = new ImageView(getApplicationContext());
            m6.setLayoutParams(lp);

            if (firstimage != 0) {
                m1.setImageResource(firstimage);
                m1.setAdjustViewBounds(true);
                linearLayout.addView(m1);
                LinearLayout poleTop = new LinearLayout(this);
                poleTop.setOrientation(LinearLayout.VERTICAL);


                try {
                    if (poleScope.has("PoleTopEquipment")) {
                        poleTopObj = poleScope.getJSONObject("PoleTopEquipment").getJSONObject("damagedParts");
                        TextView t = new TextView(this);
                        t.setText("Pole-Top Equipment");
                        poleTop.addView(t);
                        JSONObject otherObject = new JSONObject(poleTopObj.toString());
                        Iterator othersX = otherObject.keys();
                        JSONArray jsonArray = new JSONArray();

                        while (othersX.hasNext()) {
                            String key = (String) othersX.next();
                            jsonArray.put(otherObject.get(key));
                        }


                        List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            otherJsonList.add(jsonArray.getJSONObject(i));

                            TextView t1 = new TextView(Submission_screen.this);
                            t1.setText(otherJsonList.get(i).get("partName").toString());
                            t1.setPadding(30, 20, 0, 0);
                            poleTop.addView(t1);

                            LinearLayout b = new LinearLayout(this);

                            b.setOrientation(LinearLayout.VERTICAL);

                            ;

                            JSONObject otherObject1 = new JSONObject(otherJsonList.get(i).getJSONObject("damageData").toString());
                            Iterator othersX1 = otherObject1.keys();
                            JSONArray jsonArray1 = new JSONArray();

                            while (othersX1.hasNext()) {
                                String key1 = (String) othersX1.next();
                                jsonArray1.put(otherObject1.get(key1));
                            }

                            List<JSONObject> otherJsonList1 = new ArrayList<JSONObject>();
                            for (int i1 = 0; i1 < jsonArray1.length(); i1++) {

                                LinearLayout b1 = new LinearLayout(this);
                                b1.setOrientation(LinearLayout.HORIZONTAL);
                                otherJsonList1.add(jsonArray1.getJSONObject(i1));
                                LinearLayout b2 = new LinearLayout(this);
                                b2.setOrientation(LinearLayout.VERTICAL);
                                v = new ArrayList();

                                v.add(t1.getText().toString() + "_" + (i1 + 1));

                                java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
                                }.getType();
                                Gson gson = new Gson();
                                Map<String, Object> categoryicons = gson.fromJson(otherJsonList1.get(i1).getJSONObject("damageDetails").toString(), mapType);


                                for (Map.Entry<String, Object> entry : categoryicons.entrySet()) {

                                    if (entry.getValue().toString().equalsIgnoreCase("true")) {
                                        v.add(h.get(entry.getKey()) + ": " + "Yes");
                                    } else if (entry.getValue().toString().equalsIgnoreCase("false")) {
                                        v.add(h.get(entry.getKey()) + ": " + "No");
                                    } else {
                                        v.add(h.get(entry.getKey()) + ": " + entry.getValue());
                                    }

                                }

                                NonScrollListView lv = new NonScrollListView(this);
                                lv.setDivider(null);
                                lv.setPadding(0, 50, 0, 0);
                                b2.addView(lv);

                                Simple<String> adapter = new Simple<>(this,
                                        android.R.layout.simple_spinner_item, v);
                                lv.setAdapter(adapter);

                                if (otherJsonList1.get(i1).has("images")) {
                                    File internalStorage = new File(Environment
                                            .getExternalStorageDirectory()
                                            + File.separator + "VDA" + File.separator);
                                    if (internalStorage.exists()) {
                                        Bitmap bmp = BitmapFactory.decodeFile(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1));
                                        // clientLogo.setImageBitmap(bmp);
                                        ImageView img = new ImageView(this);
                                        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                                        Bitmap icon = Utils.decodeSampledBitmapFromResource(getResources(), R.mipmap.icn_camera, 100, 100);
                                        img.setImageBitmap(Utils.getBitmap(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1)));
                                        img.setPadding(30, 50, 0, 0);

                                        // img.setImageResource(R.mipmap.camera);
                                        b1.addView(img);
                                        // }
                                    }

                                } else {
                                    ImageView img = new ImageView(this);
                                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.icn_camera);
                                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                    img.setImageBitmap(icon);
                                    img.setPadding(30, 50, 0, 0);
                                    // img.setImageResource(R.mipmap.camera);
                                    img.setVisibility(View.INVISIBLE);
                                    b1.addView(img);
                                }
                                b1.addView(b2);
                                b.addView(b1);
                            }
                            poleTop.addView(b);

                        }
                        detailsLayout.addView(poleTop);
                    }} catch(JSONException e){
                        e.printStackTrace();
                    }

            }
            if (secondimage != 0) {
                m2.setImageResource(secondimage);
                linearLayout.addView(m2);
                LinearLayout poleTop = new LinearLayout(this);
                poleTop.setOrientation(LinearLayout.VERTICAL);


                try {
                    if (poleScope.has("Wire")) {
                        poleTopObj = poleScope.getJSONObject("Wire").getJSONObject("damagedParts");
                        TextView t = new TextView(this);
                        t.setText("Wire");
                        poleTop.addView(t);
                        JSONObject otherObject = new JSONObject(poleTopObj.toString());
                        Iterator othersX = otherObject.keys();
                        JSONArray jsonArray = new JSONArray();

                        while (othersX.hasNext()) {
                            String key = (String) othersX.next();
                            jsonArray.put(otherObject.get(key));
                        }


                        List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            otherJsonList.add(jsonArray.getJSONObject(i));

                            TextView t1 = new TextView(Submission_screen.this);
                            t1.setText(otherJsonList.get(i).get("partName").toString());
                            t1.setPadding(30, 20, 0, 0);
                            poleTop.addView(t1);

                            LinearLayout b = new LinearLayout(this);

                            b.setOrientation(LinearLayout.VERTICAL);

                            ;

                            JSONObject otherObject1 = new JSONObject(otherJsonList.get(i).getJSONObject("damageData").toString());
                            Iterator othersX1 = otherObject1.keys();
                            JSONArray jsonArray1 = new JSONArray();

                            while (othersX1.hasNext()) {
                                String key1 = (String) othersX1.next();
                                jsonArray1.put(otherObject1.get(key1));
                            }

                            List<JSONObject> otherJsonList1 = new ArrayList<JSONObject>();
                            for (int i1 = 0; i1 < jsonArray1.length(); i1++) {

                                LinearLayout b1 = new LinearLayout(this);
                                b1.setOrientation(LinearLayout.HORIZONTAL);
                                otherJsonList1.add(jsonArray1.getJSONObject(i1));
                                LinearLayout b2 = new LinearLayout(this);
                                b2.setOrientation(LinearLayout.VERTICAL);
                                v = new ArrayList();

                                v.add(t1.getText().toString() + "_" + (i1 + 1));

                                java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
                                }.getType();
                                Gson gson = new Gson();
                                Map<String, Object> categoryicons = gson.fromJson(otherJsonList1.get(i1).getJSONObject("damageDetails").toString(), mapType);


                                for (Map.Entry<String, Object> entry : categoryicons.entrySet()) {

                                    if (entry.getValue().toString().equalsIgnoreCase("true")) {
                                        v.add(h.get(entry.getKey()) + ": " + "Yes");
                                    } else if (entry.getValue().toString().equalsIgnoreCase("false")) {
                                        v.add(h.get(entry.getKey()) + ": " + "No");
                                    } else {
                                        v.add(h.get(entry.getKey()) + ": " + entry.getValue());
                                    }

                                }

                                NonScrollListView lv = new NonScrollListView(this);
                                lv.setDivider(null);
                                lv.setPadding(0, 50, 0, 0);
                                b2.addView(lv);

                                Simple<String> adapter = new Simple<>(this,
                                        android.R.layout.simple_spinner_item, v);
                                lv.setAdapter(adapter);


                                if (otherJsonList1.get(i1).has("images")) {
                                    File internalStorage = new File(Environment
                                            .getExternalStorageDirectory()
                                            + File.separator + "VDA" + File.separator);
                                    if (internalStorage.exists()) {
                                        Bitmap bmp = BitmapFactory.decodeFile(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1));
                                        // clientLogo.setImageBitmap(bmp);
                                        ImageView img = new ImageView(this);
                                        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                                        Bitmap icon = Utils.decodeSampledBitmapFromResource(getResources(), R.mipmap.icn_camera, 100, 100);
                                        img.setImageBitmap(Utils.getBitmap(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1)));
                                        img.setPadding(30, 50, 0, 0);

                                        b1.addView(img);
                                        // }
                                    }

                                } else {
                                    ImageView img = new ImageView(this);
                                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.icn_camera);
                                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                    img.setImageBitmap(icon);
                                    img.setPadding(30, 50, 0, 0);
                                    // img.setImageResource(R.mipmap.camera);
                                    img.setVisibility(View.INVISIBLE);
                                    b1.addView(img);
                                }
                                b1.addView(b2);
                                b.addView(b1);
                            }
                            poleTop.addView(b);

                        }
                        detailsLayout.addView(poleTop);
                    } }catch(JSONException e){
                        e.printStackTrace();
                    }

            }
            if (thirdimage != 0) {
                m3.setImageResource(thirdimage);
                linearLayout.addView(m3);
                LinearLayout poleTop = new LinearLayout(this);
                poleTop.setOrientation(LinearLayout.VERTICAL);


                try {
                    if (poleScope.has("SPLEquipment")) {
                        poleTopObj = poleScope.getJSONObject("SPLEquipment").getJSONObject("damagedParts");
                        TextView t = new TextView(this);
                        t.setText("SPL Equipment");
                        poleTop.addView(t);
                        JSONObject otherObject = new JSONObject(poleTopObj.toString());
                        Iterator othersX = otherObject.keys();
                        JSONArray jsonArray = new JSONArray();

                        while (othersX.hasNext()) {
                            String key = (String) othersX.next();
                            jsonArray.put(otherObject.get(key));
                        }


                        List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            otherJsonList.add(jsonArray.getJSONObject(i));

                            TextView t1 = new TextView(Submission_screen.this);
                            t1.setText(otherJsonList.get(i).get("partName").toString());
                            t1.setPadding(30, 20, 0, 0);
                            poleTop.addView(t1);

                            LinearLayout b = new LinearLayout(this);

                            b.setOrientation(LinearLayout.VERTICAL);

                            ;

                            JSONObject otherObject1 = new JSONObject(otherJsonList.get(i).getJSONObject("damageData").toString());
                            Iterator othersX1 = otherObject1.keys();
                            JSONArray jsonArray1 = new JSONArray();

                            while (othersX1.hasNext()) {
                                String key1 = (String) othersX1.next();
                                jsonArray1.put(otherObject1.get(key1));
                            }

                            List<JSONObject> otherJsonList1 = new ArrayList<JSONObject>();
                            for (int i1 = 0; i1 < jsonArray1.length(); i1++) {

                                LinearLayout b1 = new LinearLayout(this);
                                b1.setOrientation(LinearLayout.HORIZONTAL);
                                otherJsonList1.add(jsonArray1.getJSONObject(i1));
                                LinearLayout b2 = new LinearLayout(this);
                                b2.setOrientation(LinearLayout.VERTICAL);
                                v = new ArrayList();

                                v.add(t1.getText().toString() + "_" + (i1 + 1));

                                java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
                                }.getType();
                                Gson gson = new Gson();
                                Map<String, Object> categoryicons = gson.fromJson(otherJsonList1.get(i1).getJSONObject("damageDetails").toString(), mapType);


                                for (Map.Entry<String, Object> entry : categoryicons.entrySet()) {

                                    if (entry.getValue().toString().equalsIgnoreCase("true")) {
                                        v.add(h.get(entry.getKey()) + ": " + "Yes");
                                    } else if (entry.getValue().toString().equalsIgnoreCase("false")) {
                                        v.add(h.get(entry.getKey()) + ": " + "No");
                                    } else {
                                        v.add(h.get(entry.getKey()) + ": " + entry.getValue());
                                    }

                                }

                                NonScrollListView lv = new NonScrollListView(this);
                                lv.setDivider(null);
                                lv.setPadding(0, 50, 0, 0);
                                b2.addView(lv);

                                Simple<String> adapter = new Simple<>(this,
                                        android.R.layout.simple_spinner_item, v);
                                lv.setAdapter(adapter);


                                if (otherJsonList1.get(i1).has("images")) {
                                    File internalStorage = new File(Environment
                                            .getExternalStorageDirectory()
                                            + File.separator + "VDA" + File.separator);
                                    if (internalStorage.exists()) {
                                        Bitmap bmp = BitmapFactory.decodeFile(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1));
                                        // clientLogo.setImageBitmap(bmp);
                                        ImageView img = new ImageView(this);
                                        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                                        Bitmap icon = Utils.decodeSampledBitmapFromResource(getResources(), R.mipmap.icn_camera, 100, 100);
                                        img.setImageBitmap(Utils.getBitmap(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1)));
                                        img.setPadding(30, 50, 0, 0);

                                        // img.setImageResource(R.mipmap.camera);
                                        b1.addView(img);
                                        // }
                                    }

                                } else {
                                    ImageView img = new ImageView(this);
                                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.icn_camera);
                                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                    img.setImageBitmap(icon);
                                    img.setPadding(30, 50, 0, 0);
                                    // img.setImageResource(R.mipmap.camera);
                                    img.setVisibility(View.INVISIBLE);
                                    b1.addView(img);
                                }

                                b1.addView(b2);

                                b.addView(b1);

                            }
                            poleTop.addView(b);

                        }
                        detailsLayout.addView(poleTop);
                    }  }catch(JSONException e){
                        e.printStackTrace();
                    }

            }
            if (fourthimage != 0) {
                m4.setImageResource(fourthimage);
                linearLayout.addView(m4);

                LinearLayout poleTop = new LinearLayout(this);
                poleTop.setOrientation(LinearLayout.VERTICAL);


                try {
                    if (poleScope.has("Pole")) {
                        poleTopObj = poleScope.getJSONObject("Pole").getJSONObject("damagedParts");
                        TextView t = new TextView(this);
                        t.setText("Pole");
                        poleTop.addView(t);
                        JSONObject otherObject = new JSONObject(poleTopObj.toString());
                        Iterator othersX = otherObject.keys();
                        JSONArray jsonArray = new JSONArray();

                        while (othersX.hasNext()) {
                            String key = (String) othersX.next();
                            jsonArray.put(otherObject.get(key));
                        }


                        List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            otherJsonList.add(jsonArray.getJSONObject(i));

                            TextView t1 = new TextView(Submission_screen.this);
                            t1.setText(otherJsonList.get(i).get("partName").toString());
                            t1.setPadding(30, 20, 0, 0);
                            poleTop.addView(t1);

                            LinearLayout b = new LinearLayout(this);

                            b.setOrientation(LinearLayout.VERTICAL);

                            ;

                            JSONObject otherObject1 = new JSONObject(otherJsonList.get(i).getJSONObject("damageData").toString());
                            Iterator othersX1 = otherObject1.keys();
                            JSONArray jsonArray1 = new JSONArray();

                            while (othersX1.hasNext()) {
                                String key1 = (String) othersX1.next();
                                jsonArray1.put(otherObject1.get(key1));
                            }

                            List<JSONObject> otherJsonList1 = new ArrayList<JSONObject>();
                            for (int i1 = 0; i1 < jsonArray1.length(); i1++) {

                                LinearLayout b1 = new LinearLayout(this);
                                b1.setOrientation(LinearLayout.HORIZONTAL);
                                otherJsonList1.add(jsonArray1.getJSONObject(i1));
                                LinearLayout b2 = new LinearLayout(this);
                                b2.setOrientation(LinearLayout.VERTICAL);
                                v = new ArrayList();

                                v.add(t1.getText().toString() + "_" + (i1 + 1));

                                java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
                                }.getType();
                                Gson gson = new Gson();
                                Map<String, Object> categoryicons = gson.fromJson(otherJsonList1.get(i1).getJSONObject("damageDetails").toString(), mapType);


                                for (Map.Entry<String, Object> entry : categoryicons.entrySet()) {


                                    if (entry.getValue().toString().equalsIgnoreCase("true")) {
                                        v.add(h.get(entry.getKey()) + ": " + "Yes");
                                    } else if (entry.getValue().toString().equalsIgnoreCase("false")) {
                                        v.add(h.get(entry.getKey()) + ": " + "No");
                                    } else {
                                        v.add(h.get(entry.getKey()) + ": " + entry.getValue());
                                    }

                                }

                                NonScrollListView lv = new NonScrollListView(this);
                                lv.setDivider(null);
                                lv.setPadding(0, 50, 0, 0);
                                b2.addView(lv);

                                Simple<String> adapter = new Simple<String>(this,
                                        android.R.layout.simple_spinner_item, v);

                                lv.setAdapter(adapter);


                                if (otherJsonList1.get(i1).has("images")) {
                                    File internalStorage = new File(Environment
                                            .getExternalStorageDirectory()
                                            + File.separator + "VDA" + File.separator);
                                    if (internalStorage.exists()) {
                                        Bitmap bmp = BitmapFactory.decodeFile(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1));
                                        // clientLogo.setImageBitmap(bmp);
                                        ImageView img = new ImageView(this);
                                        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                                        Bitmap icon = Utils.decodeSampledBitmapFromResource(getResources(), R.mipmap.icn_camera, 100, 100);
                                        img.setImageBitmap(Utils.getBitmap(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1)));
                                        img.setPadding(30, 50, 0, 0);

                                        // img.setImageResource(R.mipmap.camera);
                                        b1.addView(img);
                                        // }
                                    }

                                } else {
                                    ImageView img = new ImageView(this);
                                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.icn_camera);
                                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                    img.setImageBitmap(icon);
                                    img.setPadding(30, 50, 0, 0);
                                    // img.setImageResource(R.mipmap.camera);
                                    img.setVisibility(View.INVISIBLE);
                                    b1.addView(img);
                                }

                                b1.addView(b2);
                                b.addView(b1);
                            }
                            poleTop.addView(b);

                        }
                        detailsLayout.addView(poleTop);
                    }  }catch(JSONException e){
                        e.printStackTrace();
                    }

            }
            if (fifthimage != 0) {
                m5.setImageResource(fifthimage);
                linearLayout.addView(m5);
                LinearLayout poleTop = new LinearLayout(this);
                poleTop.setOrientation(LinearLayout.VERTICAL);
                try {
                    if (poleScope.has("Tree")) {
                        poleTopObj = poleScope.getJSONObject("Tree").getJSONObject("damagedParts");
                        TextView t = new TextView(this);
                        t.setText("Tree");
                        poleTop.addView(t);
                        JSONObject otherObject = new JSONObject(poleTopObj.toString());
                        Iterator othersX = otherObject.keys();
                        JSONArray jsonArray = new JSONArray();
                        while (othersX.hasNext()) {
                            String key = (String) othersX.next();
                            jsonArray.put(otherObject.get(key));
                        }
                        List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            otherJsonList.add(jsonArray.getJSONObject(i));

                            TextView t1 = new TextView(Submission_screen.this);
                            t1.setText(otherJsonList.get(i).get("partName").toString());
                            t1.setPadding(30, 20, 0, 0);
                            poleTop.addView(t1);
                            LinearLayout b = new LinearLayout(this);
                            b.setOrientation(LinearLayout.VERTICAL);
                            JSONObject otherObject1 = new JSONObject(otherJsonList.get(i).getJSONObject("damageData").toString());
                            Iterator othersX1 = otherObject1.keys();
                            JSONArray jsonArray1 = new JSONArray();
                            while (othersX1.hasNext()) {
                                String key1 = (String) othersX1.next();
                                jsonArray1.put(otherObject1.get(key1));
                            }
                            List<JSONObject> otherJsonList1 = new ArrayList<JSONObject>();
                            for (int i1 = 0; i1 < jsonArray1.length(); i1++) {
                                LinearLayout b1 = new LinearLayout(this);
                                b1.setOrientation(LinearLayout.HORIZONTAL);
                                otherJsonList1.add(jsonArray1.getJSONObject(i1));
                                LinearLayout b2 = new LinearLayout(this);
                                b2.setOrientation(LinearLayout.VERTICAL);
                                v = new ArrayList();
                                v.add(t1.getText().toString() + "_" + (i1 + 1));
                                java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
                                }.getType();
                                Gson gson = new Gson();
                                Map<String, Object> categoryicons = gson.fromJson(otherJsonList1.get(i1).getJSONObject("damageDetails").toString(), mapType);
                                for (Map.Entry<String, Object> entry : categoryicons.entrySet()) {
                                    if (entry.getValue().toString().equalsIgnoreCase("true")) {
                                        v.add(h.get(entry.getKey()) + ": " + "Yes");
                                    } else if (entry.getValue().toString().equalsIgnoreCase("false")) {
                                        v.add(h.get(entry.getKey()) + ": " + "No");
                                    } else {
                                        v.add(h.get(entry.getKey()) + ": " + entry.getValue());
                                    }

                                }
                                NonScrollListView lv = new NonScrollListView(this);
                                lv.setDivider(null);
                                lv.setPadding(0, 50, 0, 0);
                                b2.addView(lv);

                                Simple<String> adapter = new Simple<String>(this,
                                        android.R.layout.simple_spinner_item, v);
                                lv.setAdapter(adapter);
                                if (otherJsonList1.get(i1).has("images")) {
                                   /* File internalStorage = new File(Environment.getExternalStoragePublicDirectory(
                                            Environment.DIRECTORY_DCIM), "VDA");
                                    if (!internalStorage.exists()) {
                                        internalStorage.mkdir();
                                    }*/
                                    File internalStorage = new File(Environment
                                            .getExternalStorageDirectory()
                                            + File.separator + "VDA" + File.separator);

                                    if (internalStorage.exists()) {
                                        Bitmap bmp = BitmapFactory.decodeFile(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1));
                                        // clientLogo.setImageBitmap(bmp);
                                        ImageView img = new ImageView(this);
                                        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                                        Bitmap icon = Utils.decodeSampledBitmapFromResource(getResources(), R.mipmap.icn_camera, 100, 100);
                                        img.setImageBitmap(Utils.getBitmap(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1)));
                                        img.setPadding(30, 50, 0, 0);
                                        // img.setImageResource(R.mipmap.camera);
                                        b1.addView(img);
                                        // }
                                    }

                                } else {
                                    ImageView img = new ImageView(this);
                                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.icn_camera);
                                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                    img.setImageBitmap(icon);
                                    img.setPadding(30, 50, 0, 0);
                                    // img.setImageResource(R.mipmap.camera);
                                    img.setVisibility(View.INVISIBLE);
                                    b1.addView(img);
                                }

                                b1.addView(b2);
                                b.addView(b1);
                            }
                            poleTop.addView(b);

                        }
                        detailsLayout.addView(poleTop);

                    } } catch(JSONException e){
                        e.printStackTrace();
                    }

            }
            if (sixthimage != 0) {
                m6.setImageResource(sixthimage);
                linearLayout.addView(m6);
                LinearLayout poleTop = new LinearLayout(this);
                poleTop.setOrientation(LinearLayout.VERTICAL);
                try {
                    if (poleScope.has("Other")) {
                        poleTopObj = poleScope.getJSONObject("Other").getJSONObject("damagedParts");
                        TextView t = new TextView(this);
                        t.setText("Other");
                        poleTop.addView(t);
                        JSONObject otherObject = new JSONObject(poleTopObj.toString());
                        Iterator othersX = otherObject.keys();
                        JSONArray jsonArray = new JSONArray();
                        while (othersX.hasNext()) {
                            String key = (String) othersX.next();
                            jsonArray.put(otherObject.get(key));
                        }
                        List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            otherJsonList.add(jsonArray.getJSONObject(i));

                            TextView t1 = new TextView(Submission_screen.this);
                            t1.setText(otherJsonList.get(i).get("partName").toString());
                            t1.setPadding(30, 20, 0, 0);
                            poleTop.addView(t1);
                            LinearLayout b = new LinearLayout(this);
                            b.setOrientation(LinearLayout.VERTICAL);
                            JSONObject otherObject1 = new JSONObject(otherJsonList.get(i).getJSONObject("damageData").toString());
                            Iterator othersX1 = otherObject1.keys();
                            JSONArray jsonArray1 = new JSONArray();
                            while (othersX1.hasNext()) {
                                String key1 = (String) othersX1.next();
                                jsonArray1.put(otherObject1.get(key1));
                            }
                            List<JSONObject> otherJsonList1 = new ArrayList<JSONObject>();
                            for (int i1 = 0; i1 < jsonArray1.length(); i1++) {
                                LinearLayout b1 = new LinearLayout(this);
                                b1.setOrientation(LinearLayout.HORIZONTAL);
                                otherJsonList1.add(jsonArray1.getJSONObject(i1));
                                LinearLayout b2 = new LinearLayout(this);
                                b2.setOrientation(LinearLayout.VERTICAL);
                                v = new ArrayList();
                                v.add(t1.getText().toString() + "_" + (i1 + 1));
                                java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
                                }.getType();
                                Gson gson = new Gson();
                                Map<String, Object> categoryicons = gson.fromJson(otherJsonList1.get(i1).getJSONObject("damageDetails").toString(), mapType);
                                for (Map.Entry<String, Object> entry : categoryicons.entrySet()) {
                                    if (entry.getValue().toString().equalsIgnoreCase("true")) {
                                        v.add(h.get(entry.getKey()) + ": " + "Yes");
                                    } else if (entry.getValue().toString().equalsIgnoreCase("false")) {
                                        v.add(h.get(entry.getKey()) + ": " + "No");
                                    } else {
                                        v.add(h.get(entry.getKey()) + ": " + entry.getValue());
                                    }

                                }
                                NonScrollListView lv = new NonScrollListView(this);
                                lv.setDivider(null);
                                lv.setPadding(0, 50, 0, 0);
                                b2.addView(lv);

                                Simple<String> adapter = new Simple<String>(this,
                                        android.R.layout.simple_spinner_item, v);
                                lv.setAdapter(adapter);
                                if (otherJsonList1.get(i1).has("images")) {
                                    File internalStorage = new File(Environment
                                            .getExternalStorageDirectory()
                                            + File.separator + "VDA" + File.separator);
                                    if (internalStorage.exists()) {
                                        Bitmap bmp = BitmapFactory.decodeFile(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1));
                                        // clientLogo.setImageBitmap(bmp);
                                        ImageView img = new ImageView(this);
                                        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                        img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                        img.setScaleType(ImageView.ScaleType.FIT_XY);
                                        Bitmap icon = Utils.decodeSampledBitmapFromResource(getResources(), R.mipmap.icn_camera, 100, 100);
                                        img.setImageBitmap(Utils.getBitmap(internalStorage.getAbsolutePath() + "/" + otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").substring(otherJsonList1.get(i1).getJSONArray("images").getJSONObject(0).getString("original").lastIndexOf("/") + 1)));
                                        img.setPadding(30, 50, 0, 0);

                                        // img.setImageResource(R.mipmap.camera);
                                        b1.addView(img);
                                        // }
                                    }

                                } else {
                                    ImageView img = new ImageView(this);
                                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.icn_camera);
                                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                                    img.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                    img.setImageBitmap(icon);
                                    img.setPadding(30, 50, 0, 0);
                                    // img.setImageResource(R.mipmap.camera);
                                    img.setVisibility(View.INVISIBLE);
                                    b1.addView(img);
                                }

                                b1.addView(b2);
                                b.addView(b1);
                            }
                            poleTop.addView(b);

                        }
                        detailsLayout.addView(poleTop);

                    } }catch(JSONException e){
                        e.printStackTrace();
                    }

            }
        }
     //   spinner = (TextView) findViewById(R.id.spinner);
       /* ArrayList<Integer> heights = new ArrayList<Integer>();
        heights.add(35);
        heights.add(40);
        heights.add(45);
        heights.add(50);
        heights.add(55);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, heights);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
*/
    }
    public void amazonS3Setup(Context mContext) {
        credentialsProvider(mContext);
        setTransferUtility(mContext);
    }

    public void credentialsProvider(Context mContext) {
        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                mContext,
                Utils.COGNITO_POOL_ID, // Identity Pool ID
                Utils.COGNITO_REGION // Region
        );
        setAmazonS3Client(credentialsProvider);
    }

    public void setAmazonS3Client(CognitoCachingCredentialsProvider credentialsProvider) {
        // Create an S3 client
        s3 = new AmazonS3Client(credentialsProvider);
        // Set the region of your S3 bucket
        s3.setRegion(Region.getRegion(Utils.BUCKET_REGION));
    }

    public void setTransferUtility(Context mContect) {
        transferUtility = new TransferUtility(s3, mContect);
    }

    public void setFileToUploadPano() {
        Log.i("greesham","pano Upload"+images_array);
        if(images_array!=null) {
            for (int i = 0; i < images_array.size(); i++) {
                TransferObserver transferObserverPole = transferUtility.upload(
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        //"irestore-ir-dev/dev",     /* The bucket to upload to */
                        images_array.get(i).getName(),      /* The key for the uploaded object */
                        images_array.get(i) , CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
                );
                transferObserverListenerPano(transferObserverPole/*,synProcess*/);

            }
        }
    }
    public void transferObserverListenerPano(final TransferObserver transferObserverPole/*,String progress*/) {
        //  final String syncProgress  = progress;
        transferObserverPole.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {
                Log.i("greesham","pano Upload state"+state);
                if (state == TransferState.COMPLETED) {
                   /* if(images_array!=null) {
                        images_array.clear();
                        images_array = null;

                    }*/
//                    Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
    }

    public void setFileToUploadPole() {
        if(pole_images_array!=null) {
            for (int i = 0; i < pole_images_array.size(); i++) {
                TransferObserver transferObserverPole = transferUtility.upload(
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        //"irestore-ir-dev/dev",     /* The bucket to upload to */
                        pole_images_array.get(i).getName(),      /* The key for the uploaded object */
                        pole_images_array.get(i) , CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
                );
                transferObserverListenerPole(transferObserverPole/*,synProcess*/);

            }
        }
    }
    public void transferObserverListenerPole(final TransferObserver transferObserverPole/*,String progress*/) {
        //  final String syncProgress  = progress;
        transferObserverPole.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                if (state == TransferState.COMPLETED) {
                    if(pole_images_array!=null) {
                        pole_images_array.clear();
                        pole_images_array = null;

                    }
//                    Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
    }

    public void setFileToUploadPoleTop() {
        if(GlobalData.pole_top_images_array!=null) {
            for (int i = 0; i < GlobalData.pole_top_images_array.size(); i++) {
                TransferObserver transferObserver = transferUtility.upload(
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        /* "irestore-ir-dev/dev", */    /* The bucket to upload to */
                        GlobalData.pole_top_images_array.get(i).getName(),      /* The key for the uploaded object */
                        GlobalData.pole_top_images_array.get(i), CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
                );
                transferObserverListener(transferObserver/*,synProcess*/);
            }
        }
    }
    public void transferObserverListener(final TransferObserver transferObserver/*,String progress*/) {
        //  final String syncProgress  = progress;
        transferObserver.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                if (state == TransferState.COMPLETED) {
                    if(GlobalData.pole_top_images_array!=null) {
                        GlobalData.pole_top_images_array.clear();
                        GlobalData.pole_top_images_array = null;

                    }
//                    Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
    }

    public void setFileToUploadTree() {
        if(GlobalData.tree_images_array!=null) {
            for (int i = 0; i < GlobalData.tree_images_array.size(); i++) {
                TransferObserver transferObserverOthers = transferUtility.upload(
                        //  "irestore-ir-dev/dev",     /* The bucket to upload to */
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        GlobalData.tree_images_array.get(i).getName(),      /* The key for the uploaded object */
                        GlobalData.tree_images_array.get(i) ,CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
                );
                transferObserverListenerTree(transferObserverOthers/*,synProcess*/);

            }
        }
    }
    public void transferObserverListenerTree(final TransferObserver transferObserverOthers/*,String progress*/) {
        //  final String syncProgress  = progress;
        transferObserverOthers.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                if (state == TransferState.COMPLETED) {
                    if(GlobalData.tree_images_array!=null) {
                        GlobalData.tree_images_array.clear();
                        GlobalData.tree_images_array = null;

                    }
//                    Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);

            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
    }

    public void setFileToUploadWire() {
        if(GlobalData.wire_images_array!=null) {
            for (int i = 0; i < GlobalData.wire_images_array.size(); i++) {
                TransferObserver transferObserverOthers = transferUtility.upload(
                        //  "irestore-ir-dev/dev",     /* The bucket to upload to */
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        GlobalData.wire_images_array.get(i).getName(),      /* The key for the uploaded object */
                        GlobalData.wire_images_array.get(i) ,CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
                );
                transferObserverListenerWire(transferObserverOthers/*,synProcess*/);

            }
        }
    }
    public void transferObserverListenerWire(final TransferObserver transferObserverOthers/*,String progress*/) {
        //  final String syncProgress  = progress;
        transferObserverOthers.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                if (state == TransferState.COMPLETED) {
                    if(GlobalData.wire_images_array!=null) {
                        GlobalData.wire_images_array.clear();
                        GlobalData.wire_images_array = null;

                    }
//                    Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
    }

    public void setFileToUploadUnderground() {
        if(GlobalData.underground_images_array!=null) {
            for (int i = 0; i < GlobalData.underground_images_array.size(); i++) {
                TransferObserver transferObserverUnderground = transferUtility.upload(
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        // "irestore-ir-dev/dev",     /* The bucket to upload to */
                        GlobalData.underground_images_array.get(i).getName(),      /* The key for the uploaded object */
                        GlobalData.underground_images_array.get(i) ,CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
                );
                transferObserverListenerUnderground(transferObserverUnderground/*,synProcess*/);

            }
        }
    }
    public void transferObserverListenerUnderground(final TransferObserver transferObserverUnderground/*,String progress*/) {
        //  final String syncProgress  = progress;
        transferObserverUnderground.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                if (state == TransferState.COMPLETED) {
                    if(GlobalData.underground_images_array!=null) {
                        GlobalData.underground_images_array.clear();
                        GlobalData.underground_images_array = null;

                    }
//                    Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
    }


    public void setFileToUploadSPL() {
        if(GlobalData.spl_images_array!=null) {
            for (int i = 0; i < GlobalData.spl_images_array.size(); i++) {
                TransferObserver transferObserverPole = transferUtility.upload(
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        //"irestore-ir-dev/dev",     /* The bucket to upload to */
                        GlobalData.spl_images_array.get(i).getName(),      /* The key for the uploaded object */
                        GlobalData.spl_images_array.get(i) , CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
                );
                transferObserverListenerSPL(transferObserverPole/*,synProcess*/);

            }
        }
    }
    public void transferObserverListenerSPL(final TransferObserver transferObserverPole/*,String progress*/) {
        //  final String syncProgress  = progress;
        transferObserverPole.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                if (state == TransferState.COMPLETED) {
                    if(GlobalData.spl_images_array!=null) {
                        GlobalData.spl_images_array.clear();
                        GlobalData.spl_images_array = null;
                    }
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
    }

    public void setActionBar() {
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_titlebar, null);
        v.setBackgroundColor(Color.WHITE);
        ActionBar actionBar = getActionBar();
        TextView title = (TextView) v.findViewById(R.id.title);
        title.setTextColor(Color.parseColor("#333333"));
        title.setText("Damage Assesment");
        title.setTypeface(typeFace);
        Button nextBtn = (Button) v.findViewById(R.id.nextBtn);
        nextBtn.setTextColor(Color.parseColor("#00A699"));
        nextBtn.setText("Submit");
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    inspectionReport = new JSONObject();
                    JSONObject submittedByData = new JSONObject();
                    JSONObject poleDetailsData = new JSONObject();
                    submittedByData.put("email", sharedPref.getString("emailAddress", ""));
                    submittedByData.put("phone", sharedPref.getString("phoneNumber", ""));
                    inspectionReport.put("submittedBy", submittedByData);
                    JSONArray sceneImages = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    if(Utils.panoBitmap1!=null) {
                        imagesObject.put("isPanorama", true);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + panoImageURL1.getName());//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + panoImageURL1.getName()); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        sceneImages.put(imagesObject);
                        inspectionReport.put("sceneImages", sceneImages);
                    }
                    else if(Utils.assetImage!=null) {
                        imagesObject.put("isPanorama", false);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + imageName1);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + imageName1); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        sceneImages.put(imagesObject);
                        inspectionReport.put("sceneImages", sceneImages);
                    }





                    inspectionReport.put("roadBlocked", road_block_switch.isChecked() ? true : false);
                    inspectionReport.put("policeFireStandingBy", police_fireStanding_switch.isChecked() ? true : false);
                    inspectionReport.put("wireGuardStandingBy", wire_gurdStanding_switch.isChecked() ? true : false);
                    JSONArray feederLine = new JSONArray();

                    feederLine.put(0, selectedFeederLine1);
                    feederLine.put(1, selectedFeederLine2);
                    poleDetailsData.put("height", poleHeightValue.getText().toString());
                    poleDetailsData.put("number", selectedPoleNumber);
                    poleDetailsData.put("feederLine",feederLine);
                    inspectionReport.put("poleDetails", poleDetailsData);
                    SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                    inspectionReport.put("displayTimestamp", oldformat.format(new Date()));
                    JSONObject address = new JSONObject();
                    address.put("userAddress", Global.addressString);
                    address.put("resolvedAddress", Global.addressString);
                    inspectionReport.put("address", address);
                    inspectionReport.put("version", 1);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    inspectionReport.put("deviceReportId", sharedPref.getString("phoneNumber", "") + "_" + dateFormat.format(new Date()));
                    JSONObject loc = new JSONObject();
                    loc.put("type", "Point");
                    JSONArray l = new JSONArray();

                    l.put(0, Global.currentLocation.getLongitude());
                    l.put(1, Global.currentLocation.getLatitude());
                    loc.put("coordinates", l);
                    inspectionReport.put("loc", loc);
                    inspectionReport.put("damageScopes", poleScope);
                    Log.i("vidisha", "SDA==" + inspectionReport.toString());
                    if (Utils.isNetworkAvailable(Submission_screen.this)) {
                        Utils.createAndStartProgressBar(Submission_screen.this);
                        STAsyncHttpConnection async = new STAsyncHttpConnection();
                        async.execute(Global.SubmitSDAReportAPI);
                    }
                }catch (JSONException e)
                {

                }
            }
        });
        nextBtn.setTypeface(typeFace);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(v);
    }

        public class STAsyncHttpConnection extends AsyncTask<String, Void, String> {
            /**
             * Override this method to perform a computation on a background thread. The
             * specified parameters are the parameters passed to {@link #execute}
             * by the caller of this task.
             * <p>
             * This method can call {@link #publishProgress} to publish updates
             * on the UI thread.
             *
             * @param params The parameters of the task.
             * @return A result, defined by the subclass of this task.
             * @see #onPreExecute()
             * @see #onPostExecute
             * @see #publishProgress
             */
            @Override
            protected String doInBackground(String... params) {
                String result = null, urlStr = params[0];
                HttpURLConnection urlConnection = null;
                exception = null;
                try {
                    URL url = new URL(urlStr);
                    Log.i("STAsyncHttpConnection", "URL: " + urlStr);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
                    // handle POST parameters
                    // if (p != null) {

                    if (android.util.Log.isLoggable("STAsyncHttpConnection", android.util.Log.INFO)) {
                        Log.i("STAsyncHttpConnection", "POST parameters: ");
                    }
                    urlConnection.setRequestProperty("x-account-key", sharedPref.getString("accountKey", ""));
                    urlConnection.setRequestProperty("x-access-token", sharedPref.getString("token", ""));
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("x-application", Global.appKey);
                    urlConnection.setRequestProperty("x-user", sharedPref.getString("phoneNumber", ""));


                    urlConnection.setRequestMethod("PUT");

                    JSONObject jsonObject = new JSONObject();

                    jsonObject.put("sdaData", inspectionReport);


                    DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());
                    wr.flush();
                    wr.close();

                    int statusCode = urlConnection.getResponseCode();
                    Log.i("iRestore", "statusCode My Profile" + statusCode);
                    if (statusCode == HttpURLConnection.HTTP_OK) {
                        //Get Response
                        InputStream is = urlConnection.getInputStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                        String line;
                        StringBuffer response = new StringBuffer();
                        while ((line = rd.readLine()) != null) {
                            response.append(line);
                        }
                        rd.close();
                        result = response.toString();
                    } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                        result = "{\"Error\" : true, \"Message\" : \"Unauthorized user\"}";
                    } else if (statusCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT || statusCode == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
                        result = "{\"Error\" : true, \"Message\" : \"Request Timed out. Please try again later\"}";
                    } else if (statusCode == 403) {
                        result = "{\"Error\" : true, \"Message\" : \"Email address has been taken.Please try with a different email address\"}";
                    } else {
                        result = "{\"Error\" : true, \"Message\" : \"Server Error, please try again later\"}";
                    }
                } catch (MalformedURLException ex) {
                    exception = ex;
                    Log.e("SocketTimeout exception", ex.toString());
                } catch (SocketTimeoutException ex) {
                    exception = ex;
                    ex.printStackTrace();
                    Log.e("SocketTimeout exception", ex.toString());
                } catch (EOFException ef) {
                    exception = ef;
                    ef.printStackTrace();
                    Log.e("EOFException exception", ef.toString());
                } catch (IOException ez) {
                    exception = ez;
                    ez.printStackTrace();
                    Log.e("IO exception", ez.toString());
                } catch (Exception ez) {
                    exception = ez;
                    Log.e("exception", ez.toString());
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
                return result;
            }

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected void onPostExecute(String result) {
                try {
                    if (exception == null && result != null) {
                        try {
                            JSONObject responseObj = new JSONObject(result);
                            Log.i("iRestore", "result*****" + result);

                            if (responseObj.getBoolean("Error")) {
                                Toast.makeText(Submission_screen.this, responseObj.getString("Message"),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Submission_screen.this);
                                alertDialog.setTitle("Alert");
                                alertDialog.setMessage("The report has been submitted successfully. The images will be uploading in background");
                                // on pressing cancel button
                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        Intent intent = new Intent(Submission_screen.this, MainActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        setFileToUploadPano();
                                        setFileToUploadPole();
                                        setFileToUploadWire();
                                        setFileToUploadUnderground();
                                        setFileToUploadTree();
                                        setFileToUploadSPL();
                                        setFileToUploadPoleTop();

                                        selectedFeederLine1=null;
                                        selectedFeederLine2=null;
                                        selectedPoleHeight=null;
                                        selectedPoleNumber=null;
                                        Utils.panoBitmap1=null;
                                        Utils.assetImage =null;

                                        ReadUnderGroundData.getInstance().resetAllReference();
                                        ReadUnderGroundData.getInstance().resetAllJSONObject();

                                        ReadPoleEquipmentData.getInstance().resetAllReference();
                                        ReadPoleEquipmentData.getInstance().resetAllJSONObject();

                                        ReadPoleTopEquipmentData.getInstance().resetAllReference();
                                        ReadPoleTopEquipmentData.getInstance().resetAllJSONObject();

                                        ReadWireData.getInstance().resetAllReference();
                                        ReadWireData.getInstance().resetAllJSONObject();

                                        ReadSplEquipmentData.getInstance().resetAllReference();
                                        ReadSplEquipmentData.getInstance().resetAllJSONObject();

                                        ReadTreeData.getInstance().resetAllReference();
                                        ReadTreeData.getInstance().resetAllJSONObject();
                                        dialog.cancel();
                                    }
                                });
                                // Showing Alert Message
                                alertDialog.show();
                            }
                        } catch (Exception e) {

                        }
                    } else {
                        Toast.makeText(Submission_screen.this, getResources().getString(R.string.error),
                                Toast.LENGTH_SHORT).show();
                    }
                    if (Utils.progress.isShowing()) {
                        Utils.stopProgressBar();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    public void getLocation() {
        if( ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION )!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }
        else
        {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location != null)
            {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                lat_long.setText(String.valueOf(latitude)+","+ String.valueOf(longitude));
            }
        }
    }

    private void LoadPoleTopScopeSelectedData() {
        JSONObject poleTopEquipment = new JSONObject(); // "PoleTopEquipment": {
        JSONObject damageParts = new JSONObject(); // "damagedParts": {
        JSONObject transformer = new JSONObject(); // TRANSFORMER
        JSONObject partName = new JSONObject(); // "partName": "TRANSFORMER",
        JSONObject transformer_1 = new JSONObject(); // "TRANSFORMER_1"
        JSONObject damageDetails1 = new JSONObject();
        JSONObject damageDetails2 = new JSONObject();
        JSONObject damageDetails3 = new JSONObject();
        JSONObject damageDetails4 = new JSONObject();
        JSONObject damageDetails5 = new JSONObject();
        JSONObject damageDetails6 = new JSONObject();
        JSONObject damageDetails7 = new JSONObject();
        JSONObject damageDetails8 = new JSONObject();
        JSONObject damageDetails9 = new JSONObject();
        JSONObject damageDetails10 = new JSONObject();

        JSONObject crossArm_1 = new JSONObject(); // "CROSS ARM
        JSONObject crossArm = new JSONObject();
        JSONObject crossArmDamagePart = new JSONObject();
        JSONObject crossArmPartName = new JSONObject();
        JSONObject damageDetailsCrossArm1 = new JSONObject();
        JSONObject damageDetailsCrossArm2 = new JSONObject();
        JSONObject damageDetailsCrossArm3 = new JSONObject();
        JSONObject damageDetailsCrossArm4 = new JSONObject();
        JSONObject damageDetailsCrossArm5 = new JSONObject();
        JSONObject damageDetailsCrossArm6 = new JSONObject();
        JSONObject damageDetailsCrossArm7 = new JSONObject();
        JSONObject damageDetailsCrossArm8 = new JSONObject();
        JSONObject damageDetailsCrossArm9 = new JSONObject();
        JSONObject damageDetailsCrossArm10 = new JSONObject();

        JSONObject fusedCut_1 = new JSONObject(); // "CROSS ARM
        JSONObject fusedCut = new JSONObject();
        JSONObject fusedCutDamagePart = new JSONObject();
        JSONObject fusedCutPartName = new JSONObject();
        JSONObject damageDetailsfusedCut1 = new JSONObject();
        JSONObject damageDetailsfusedCut2 = new JSONObject();
        JSONObject damageDetailsfusedCut3 = new JSONObject();
        JSONObject damageDetailsfusedCut4 = new JSONObject();
        JSONObject damageDetailsfusedCut5 = new JSONObject();
        JSONObject damageDetailsfusedCut6 = new JSONObject();
        JSONObject damageDetailsfusedCut7 = new JSONObject();
        JSONObject damageDetailsfusedCut8 = new JSONObject();
        JSONObject damageDetailsfusedCut9 = new JSONObject();
        JSONObject damageDetailsfusedCut10 = new JSONObject();

        JSONObject streetlight_1 = new JSONObject();
        JSONObject streetlightDamagePart = new JSONObject();
        JSONObject streetlightPartName = new JSONObject();
        JSONObject damageDetailsstreetlight1 = new JSONObject();
        JSONObject damageDetailsstreetlight2 = new JSONObject();
        JSONObject damageDetailsstreetlight3 = new JSONObject();
        JSONObject damageDetailsstreetlight4 = new JSONObject();
        JSONObject damageDetailsstreetlight5 = new JSONObject();
        JSONObject damageDetailsstreetlight6 = new JSONObject();
        JSONObject damageDetailsstreetlight7 = new JSONObject();
        JSONObject damageDetailsstreetlight8 = new JSONObject();
        JSONObject damageDetailsstreetlight9 = new JSONObject();
        JSONObject damageDetailsstreetlight10 = new JSONObject();

        JSONObject poleTop_1 = new JSONObject();
        JSONObject poleTopDamagePart = new JSONObject();
        JSONObject poleTopPartName = new JSONObject();
        JSONObject damageDetailspoleTop1 = new JSONObject();
        JSONObject damageDetailspoleTop2 = new JSONObject();
        JSONObject damageDetailspoleTop3 = new JSONObject();
        JSONObject damageDetailspoleTop4 = new JSONObject();
        JSONObject damageDetailspoleTop5 = new JSONObject();
        JSONObject damageDetailspoleTop6 = new JSONObject();
        JSONObject damageDetailspoleTop7 = new JSONObject();
        JSONObject damageDetailspoleTop8 = new JSONObject();
        JSONObject damageDetailspoleTop9 = new JSONObject();
        JSONObject damageDetailspoleTop10 = new JSONObject();

        JSONObject insulator_1 = new JSONObject();
        JSONObject insulatorDamagePart = new JSONObject();
        JSONObject insulatorPartName = new JSONObject();
        JSONObject damageDetailsinsulator1 = new JSONObject();
        JSONObject damageDetailsinsulator2 = new JSONObject();
        JSONObject damageDetailsinsulator3 = new JSONObject();
        JSONObject damageDetailsinsulator4 = new JSONObject();
        JSONObject damageDetailsinsulator5 = new JSONObject();
        JSONObject damageDetailsinsulator6 = new JSONObject();
        JSONObject damageDetailsinsulator7 = new JSONObject();
        JSONObject damageDetailsinsulator8 = new JSONObject();
        JSONObject damageDetailsinsulator9 = new JSONObject();
        JSONObject damageDetailsinsulator10 = new JSONObject();

        JSONObject transOneData = ReadPoleTopEquipmentData.getInstance().readTransformOneData();
        JSONObject transTwoData = ReadPoleTopEquipmentData.getInstance().readTransformTwoData();
        JSONObject transThreeData = ReadPoleTopEquipmentData.getInstance().readTransformThreeData();
        JSONObject transFourData = ReadPoleTopEquipmentData.getInstance().readTransformFourData();
        JSONObject transFiveData = ReadPoleTopEquipmentData.getInstance().readTransformFiveData();
        JSONObject transSixData = ReadPoleTopEquipmentData.getInstance().readTransformSixData();
        JSONObject transEightData = ReadPoleTopEquipmentData.getInstance().readTransformSevenData();
        JSONObject transSevenData = ReadPoleTopEquipmentData.getInstance().readTransformEightData();
        JSONObject transNineData = ReadPoleTopEquipmentData.getInstance().readTransformNineData();
        JSONObject transTenData = ReadPoleTopEquipmentData.getInstance().readTransformTenData();

        JSONObject crossArmOneData = ReadPoleTopEquipmentData.getInstance().readCrossArmOneData();
        JSONObject crossArmTwoData = ReadPoleTopEquipmentData.getInstance().readCrossArmTwoData();
        JSONObject crossArmThreeData = ReadPoleTopEquipmentData.getInstance().readCrossArmThreeData();
        JSONObject crossArmFourData = ReadPoleTopEquipmentData.getInstance().readCrossArmFourData();
        JSONObject crossArmFiveData = ReadPoleTopEquipmentData.getInstance().readCrossArmFiveData();
        JSONObject crossArmSixData = ReadPoleTopEquipmentData.getInstance().readCrossArmSixData();
        JSONObject crossArmSevenData = ReadPoleTopEquipmentData.getInstance().readCrossArmSevenData();
        JSONObject crossArmEightData = ReadPoleTopEquipmentData.getInstance().readCrossArmEightData();
        JSONObject crossArmNineData = ReadPoleTopEquipmentData.getInstance().readCrossArmNineData();
        JSONObject crossArmTenData = ReadPoleTopEquipmentData.getInstance().readCrossArmTenData();

        JSONObject fusedCutOneData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutOneData();
        JSONObject fusedCutTwoData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutTwoData();
        JSONObject fusedCutThreeData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutThreeData();
        JSONObject fusedCutFourData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutFourData();
        JSONObject fusedCutFiveData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutFiveData();
        JSONObject fusedCutSixData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutSixData();
        JSONObject fusedCutSevenData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutSevenData();
        JSONObject fusedCutEightData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutEightData();
        JSONObject fusedCutNineData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutNineData();
        JSONObject fusedCutTenData = ReadPoleTopEquipmentData.getInstance().readFusedCutOutTenData();

        JSONObject streetlightOneData = ReadPoleTopEquipmentData.getInstance().readstreetlightOneData();
        JSONObject streetlightTwoData = ReadPoleTopEquipmentData.getInstance().readstreetlightTwoData();
        JSONObject streetlightThreeData = ReadPoleTopEquipmentData.getInstance().readstreetlightThreeData();
        JSONObject streetlightFourData = ReadPoleTopEquipmentData.getInstance().readstreetlightFourData();
        JSONObject streetlightFiveData = ReadPoleTopEquipmentData.getInstance().readstreetlightFiveData();
        JSONObject streetlightSixData = ReadPoleTopEquipmentData.getInstance().readstreetlightSixData();
        JSONObject streetlightEightData = ReadPoleTopEquipmentData.getInstance().readstreetlightSevenData();
        JSONObject streetlightSevenData = ReadPoleTopEquipmentData.getInstance().readstreetlightEightData();
        JSONObject streetlightNineData = ReadPoleTopEquipmentData.getInstance().readstreetlightNineData();
        JSONObject streetlightTenData = ReadPoleTopEquipmentData.getInstance().readstreetlightTenData();

        JSONObject poleTopOneData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinOneData();
        JSONObject poleTopTwoData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinTwoData();
        JSONObject poleTopThreeData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinThreeData();
        JSONObject poleTopFourData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinFourData();
        JSONObject poleTopFiveData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinFiveData();
        JSONObject poleTopSixData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinSixData();
        JSONObject poleTopEightData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinSevenData();
        JSONObject poleTopSevenData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinEightData();
        JSONObject poleTopNineData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinNineData();
        JSONObject poleTopTenData = ReadPoleTopEquipmentData.getInstance().readpoleTopPinTenData();

        JSONObject insulatorOneData = ReadPoleTopEquipmentData.getInstance().readInsulatorOneData();
        JSONObject insulatorTwoData = ReadPoleTopEquipmentData.getInstance().readinsulatorTwoData();
        JSONObject insulatorThreeData = ReadPoleTopEquipmentData.getInstance().readinsulatorThreeData();
        JSONObject insulatorFourData = ReadPoleTopEquipmentData.getInstance().readinsulatorFourData();
        JSONObject insulatorFiveData = ReadPoleTopEquipmentData.getInstance().readinsulatorFiveData();
        JSONObject insulatorSixData = ReadPoleTopEquipmentData.getInstance().readinsulatorSixData();
        JSONObject insulatorEightData = ReadPoleTopEquipmentData.getInstance().readinsulatorSevenData();
        JSONObject insulatorSevenData = ReadPoleTopEquipmentData.getInstance().readinsulatorEightData();
        JSONObject insulatorNineData = ReadPoleTopEquipmentData.getInstance().readinsulatorNineData();
        JSONObject insulatorTenData = ReadPoleTopEquipmentData.getInstance().readinsulatorTenData();


        int count = 0;
        String pictureName;
        String transTitle = "Transformer";

        try {

            if (transOneData != null) {
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                damageDetails1.put("damageDetails", transOneData);
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetails1.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_1", damageDetails1);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 1);
                damageParts.put("damagedParts", transformer);
                /* poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transTwoData != null) {
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                damageDetails2.put("damageDetails", transTwoData);
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails2.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_2", damageDetails2);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 2);
                damageParts.put("damagedParts", transformer);
                /*poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transThreeData != null) {

                damageDetails3.put("damageDetails", transThreeData);

                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails3.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_3", damageDetails3);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 3);
                damageParts.put("damagedParts", transformer);
                /* poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transFourData != null) {

                damageDetails4.put("damageDetails", transFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails4.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_4", damageDetails4);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 4);
                damageParts.put("damagedParts", transformer);
                /*  poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transFiveData != null) {

                damageDetails5.put("damageDetails", transFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails5.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_5", damageDetails5);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 5);
                damageParts.put("damagedParts", transformer);
                /* poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transSixData != null) {

                damageDetails6.put("damageDetails", transSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails6.put("images", images);
                }
                partName.put("partName", transTitle);
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_6", damageDetails6);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 6);
                damageParts.put("damagedParts", transformer);
                /*  poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transSevenData != null) {

                damageDetails7.put("damageDetails", transSevenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails7.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_7", damageDetails7);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 7);
                damageParts.put("damagedParts", transformer);
                /* poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transEightData != null) {

                damageDetails8.put("damageDetails", transEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails8.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_8", damageDetails8);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 8);
                damageParts.put("damagedParts", transformer);
                /* poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            if (transNineData != null) {

                damageDetails9.put("damageDetails", transNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails9.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_9", damageDetails9);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 9);
                damageParts.put("damagedParts", transformer);
                /*poleTopEquipment.put("PoleTopEquipment", damageParts);*/
                count++;
            }
            if (transTenData != null) {

                damageDetails10.put("damageDetails", transTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().transTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);

                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetails10.put("images", images);
                }
                partName.put("partName", transTitle.toUpperCase());
                partName.put("damageData", transformer_1);
                transformer_1.put("TRANSFORMER_10", damageDetails10);
                transformer.put("TRANSFORMER", partName);
                partName.put("partDisplayName", transTitle);
                partName.put("numberOfParts", 10);
                damageParts.put("damagedParts", transformer);
                count++;
            }
            if (count > 0) {
                damageParts.put("scopename", "PoleTopEquipment");
                damageParts.put("scopeDisplayName", "Pole-Top Equipment");
                poleScope.put("PoleTopEquipment", damageParts);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            count = 0;
            String crossArmTitle_name = "Cross Arm";
            String crossArmTitle = "CROSS_ARM";

            if (crossArmOneData != null) {
                damageDetailsCrossArm1.put("damageDetails", crossArmOneData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm1.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_1", damageDetailsCrossArm1);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 1);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmTwoData != null) {
                damageDetailsCrossArm2.put("damageDetails", crossArmTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm2.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_2", damageDetailsCrossArm2);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 2);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmThreeData != null) {
                damageDetailsCrossArm3.put("damageDetails", crossArmThreeData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm3.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_3", damageDetailsCrossArm3);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 3);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmFourData != null) {
                damageDetailsCrossArm4.put("damageDetails", crossArmFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm4.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_4", damageDetailsCrossArm4);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 4);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmFiveData != null) {
                damageDetailsCrossArm5.put("damageDetails", crossArmFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm5.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_5", damageDetailsCrossArm5);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 5);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmSixData != null) {
                damageDetailsCrossArm6.put("damageDetails", crossArmSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm6.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_6", damageDetailsCrossArm6);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 6);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmSevenData != null) {
                damageDetailsCrossArm7.put("damageDetails", crossArmSevenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm7.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_7", damageDetailsCrossArm7);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 7);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmEightData != null) {
                damageDetailsCrossArm8.put("damageDetails", crossArmEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm8.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_8", damageDetailsCrossArm8);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 8);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmNineData != null) {
                damageDetailsCrossArm9.put("damageDetails", crossArmNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm9.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_9", damageDetailsCrossArm9);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 9);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (crossArmTenData != null) {
                damageDetailsCrossArm10.put("damageDetails", crossArmTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().crossArmTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsCrossArm10.put("images", images);
                }
                crossArmPartName.put("partName", crossArmTitle);
                crossArmPartName.put("damageData", crossArm_1);
                crossArm_1.put("CROSS_ARM_10", damageDetailsCrossArm10);
                transformer.put("CROSS_ARM", crossArmPartName);
                crossArmPartName.put("partDisplayName", crossArmTitle_name);
                crossArmPartName.put("numberOfParts", 10);
                crossArmDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (count > 0) {
                crossArmDamagePart.put("scopename", "PoleTopEquipment");
                crossArmDamagePart.put("scopeDisplayName", "Pole-Top Equipment");
                poleScope.put("PoleTopEquipment", crossArmDamagePart);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            count = 0;
            String fusedCutOutTitle_name = "Fused Cut Out";
            String fusedCutOutTitle = "FUSED_CUTOUT";
            if (fusedCutOneData != null) {
                damageDetailsfusedCut1.put("damageDetails", fusedCutOneData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut1.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_1", damageDetailsfusedCut1);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 1);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutTwoData != null) {
                damageDetailsfusedCut2.put("damageDetails", fusedCutTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut2.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_2", damageDetailsfusedCut2);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 2);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }

            if (fusedCutThreeData != null) {
                damageDetailsfusedCut3.put("damageDetails", fusedCutThreeData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut3.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_3", damageDetailsfusedCut3);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 3);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutFourData != null) {
                damageDetailsfusedCut4.put("damageDetails", fusedCutFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut4.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_4", damageDetailsfusedCut4);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 4);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutFiveData != null) {
                damageDetailsfusedCut5.put("damageDetails", fusedCutFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut5.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_5", damageDetailsfusedCut5);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 5);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutSixData != null) {
                damageDetailsfusedCut6.put("damageDetails", fusedCutSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut6.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_6", damageDetailsfusedCut6);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 6);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutSevenData != null) {
                damageDetailsfusedCut7.put("damageDetails", fusedCutSevenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut7.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_7", damageDetailsfusedCut7);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 7);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutEightData != null) {
                damageDetailsfusedCut8.put("damageDetails", fusedCutEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut8.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_8", damageDetailsfusedCut8);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 8);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutNineData != null) {
                damageDetailsfusedCut9.put("damageDetails", fusedCutNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut9.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_9", damageDetailsfusedCut9);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 9);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (fusedCutTenData != null) {
                damageDetailsfusedCut10.put("damageDetails", fusedCutTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().fusedCutOutTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsfusedCut10.put("images", images);
                }
                fusedCutPartName.put("partName", fusedCutOutTitle);
                fusedCutPartName.put("damageData", fusedCut_1);
                fusedCut_1.put("FUSED_CUTOUT_10", damageDetailsfusedCut10);
                transformer.put("FUSED_CUTOUT", fusedCutPartName);
                fusedCutPartName.put("partDisplayName", fusedCutOutTitle_name);
                fusedCutPartName.put("numberOfParts", 10);
                fusedCutDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (count > 0) {
                fusedCutDamagePart.put("scopename", "PoleTopEquipment");
                fusedCutDamagePart.put("scopeDisplayName", "Pole-Top Equipment");
                poleScope.put("PoleTopEquipment", fusedCutDamagePart);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            count = 0;
            String poleTopTitle_name = "Pole Top Pin";
            String poleTopTitle = "POLE_TOP_PIN";

            if (poleTopOneData != null) {
                damageDetailspoleTop1.put("damageDetails", poleTopOneData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop1.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_1", damageDetailspoleTop1);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 1);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopTwoData != null) {
                damageDetailspoleTop2.put("damageDetails", poleTopTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop2.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_2", damageDetailspoleTop2);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 2);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopThreeData != null) {
                damageDetailspoleTop3.put("damageDetails", poleTopThreeData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop3.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_3", damageDetailspoleTop3);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 3);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopFourData != null) {
                damageDetailspoleTop4.put("damageDetails", poleTopFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop4.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_4", damageDetailspoleTop4);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 4);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopFiveData != null) {
                damageDetailspoleTop5.put("damageDetails", poleTopFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop5.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_5", damageDetailspoleTop5);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 5);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopSixData != null) {
                damageDetailspoleTop6.put("damageDetails", poleTopSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop6.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_6", damageDetailspoleTop6);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 6);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopSevenData != null) {
                damageDetailspoleTop7.put("damageDetails", poleTopTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop7.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_7", damageDetailspoleTop7);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 7);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopEightData != null) {
                damageDetailspoleTop8.put("damageDetails", poleTopEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop8.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_8", damageDetailspoleTop8);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 8);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopNineData != null) {
                damageDetailspoleTop9.put("damageDetails", poleTopNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop9.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_9", damageDetailspoleTop9);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 9);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (poleTopTenData != null) {
                damageDetailspoleTop10.put("damageDetails", poleTopTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().poleTopPinTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailspoleTop10.put("images", images);
                }
                poleTopPartName.put("partName", poleTopTitle);
                poleTopPartName.put("damageData", poleTop_1);
                poleTop_1.put("POLE_TOP_PIN_10", damageDetailspoleTop10);
                transformer.put("POLE_TOP_PIN", poleTopPartName);
                poleTopPartName.put("partDisplayName", poleTopTitle_name);
                poleTopPartName.put("numberOfParts", 10);
                poleTopDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (count > 0) {
                poleTopDamagePart.put("scopename", "PoleTopEquipment");
                poleTopDamagePart.put("scopeDisplayName", "Pole-Top Equipment");
                poleScope.put("PoleTopEquipment", poleTopDamagePart);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            count = 0;
            String insulatorTitle_name = "Insulator";
            String insulatorTitle = "INSULATOR";
            if (insulatorOneData != null) {
                damageDetailsinsulator1.put("damageDetails", insulatorOneData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator1.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_1", damageDetailsinsulator1);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 1);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorTwoData != null) {
                damageDetailsinsulator2.put("damageDetails", insulatorTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator2.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_2", damageDetailsinsulator2);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 2);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorThreeData != null) {
                damageDetailsinsulator3.put("damageDetails", insulatorThreeData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator3.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_3", damageDetailsinsulator3);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 3);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorFourData != null) {
                damageDetailsinsulator4.put("damageDetails", insulatorFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator4.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_4", damageDetailsinsulator4);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 4);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorFiveData != null) {
                damageDetailsinsulator5.put("damageDetails", insulatorFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator5.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_5", damageDetailsinsulator5);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 5);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorSixData != null) {
                damageDetailsinsulator6.put("damageDetails", insulatorSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator6.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_6", damageDetailsinsulator6);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 6);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorSevenData != null) {
                damageDetailsinsulator7.put("damageDetails", insulatorTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator7.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_7", damageDetailsinsulator7);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 7);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorEightData != null) {
                damageDetailsinsulator8.put("damageDetails", insulatorEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator8.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_8", damageDetailsinsulator8);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 8);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorNineData != null) {
                damageDetailsinsulator9.put("damageDetails", insulatorNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator9.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_9", damageDetailsinsulator9);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 9);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (insulatorTenData != null) {
                damageDetailsinsulator10.put("damageDetails", insulatorTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().insulatorTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsinsulator10.put("images", images);
                }
                insulatorPartName.put("partName", insulatorTitle);
                insulatorPartName.put("damageData", insulator_1);
                insulator_1.put("INSULATOR_10", damageDetailsinsulator10);
                transformer.put("INSULATOR", insulatorPartName);
                insulatorPartName.put("partDisplayName", insulatorTitle_name);
                insulatorPartName.put("numberOfParts", 10);
                insulatorDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (count > 0) {
                insulatorDamagePart.put("scopename", "PoleTopEquipment");
                insulatorDamagePart.put("scopeDisplayName", "Pole-Top Equipment");
                poleScope.put("PoleTopEquipment", insulatorDamagePart);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            count = 0;
            String streetlightTitle_name = "Street Light";
            String streetlightTitle = "STREET_LIGHT";
            if (streetlightOneData != null) {
                damageDetailsstreetlight1.put("damageDetails", streetlightOneData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight1.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_1", damageDetailsstreetlight1);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 1);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightTwoData != null) {
                damageDetailsstreetlight2.put("damageDetails", streetlightTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight2.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHTt_2", damageDetailsstreetlight2);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 2);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightThreeData != null) {
                damageDetailsstreetlight3.put("damageDetails", streetlightThreeData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight3.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_3", damageDetailsstreetlight3);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 3);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightFourData != null) {
                damageDetailsstreetlight4.put("damageDetails", streetlightFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight4.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_4", damageDetailsstreetlight4);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 4);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightFiveData != null) {
                damageDetailsstreetlight5.put("damageDetails", streetlightFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight5.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_5", damageDetailsstreetlight5);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 5);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightSixData != null) {
                damageDetailsstreetlight6.put("damageDetails", streetlightSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight6.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_6", damageDetailsstreetlight6);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 6);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightSevenData != null) {
                damageDetailsstreetlight7.put("damageDetails", streetlightTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight7.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_7", damageDetailsstreetlight7);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 7);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightEightData != null) {
                damageDetailsstreetlight8.put("damageDetails", streetlightEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight8.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_8", damageDetailsstreetlight8);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 8);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightNineData != null) {
                damageDetailsstreetlight9.put("damageDetails", streetlightNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight9.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_9", damageDetailsstreetlight9);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 9);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (streetlightTenData != null) {
                damageDetailsstreetlight10.put("damageDetails", streetlightTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();
                pictureName = null;
                pictureName = ReadPoleTopEquipmentData.getInstance().streetlightTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsstreetlight10.put("images", images);
                }
                streetlightPartName.put("partName", streetlightTitle);
                streetlightPartName.put("damageData", streetlight_1);
                streetlight_1.put("STREET_LIGHT_10", damageDetailsstreetlight10);
                transformer.put("STREET_LIGHT", streetlightPartName);
                streetlightPartName.put("partDisplayName", streetlightTitle_name);
                streetlightPartName.put("numberOfParts", 10);
                streetlightDamagePart.put("damagedParts", transformer);
                count++;
            }
            if (count > 0) {
                streetlightDamagePart.put("scopename", "PoleTopEquipment");
                streetlightDamagePart.put("scopeDisplayName", "Pole-Top Equipment");
                poleScope.put("PoleTopEquipment", streetlightDamagePart);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void LoadSPLScopeSelectedData() {
        int count = 0;
        JSONObject regulator = new JSONObject();
        JSONObject regulator_1 = new JSONObject();
        JSONObject regulatorDamagePart = new JSONObject();
        JSONObject regulatorPartName = new JSONObject();
        JSONObject damageDetailsregulator1 = new JSONObject();
        JSONObject damageDetailsregulator2 = new JSONObject();
        JSONObject damageDetailsregulator3 = new JSONObject();
        JSONObject damageDetailsregulator4 = new JSONObject();
        JSONObject damageDetailsregulator5 = new JSONObject();
        JSONObject damageDetailsregulator6 = new JSONObject();
        JSONObject damageDetailsregulator7 = new JSONObject();
        JSONObject damageDetailsregulator8 = new JSONObject();
        JSONObject damageDetailsregulator9 = new JSONObject();
        JSONObject damageDetailsregulator10 = new JSONObject();

        JSONObject capacitorBank_1 = new JSONObject();
        JSONObject capacitorBankDamagePart = new JSONObject();
        JSONObject capacitorBankPartName = new JSONObject();
        JSONObject damageDetailscapacitorBank1 = new JSONObject();
        JSONObject damageDetailscapacitorBank2 = new JSONObject();
        JSONObject damageDetailscapacitorBank3 = new JSONObject();
        JSONObject damageDetailscapacitorBank4 = new JSONObject();
        JSONObject damageDetailscapacitorBank5 = new JSONObject();
        JSONObject damageDetailscapacitorBank6 = new JSONObject();
        JSONObject damageDetailscapacitorBank7 = new JSONObject();
        JSONObject damageDetailscapacitorBank8 = new JSONObject();
        JSONObject damageDetailscapacitorBank9 = new JSONObject();
        JSONObject damageDetailscapacitorBank10 = new JSONObject();

        JSONObject recloser_1 = new JSONObject();
        JSONObject recloserDamagePart = new JSONObject();
        JSONObject recloserPartName = new JSONObject();
        JSONObject damageDetailsrecloser1 = new JSONObject();
        JSONObject damageDetailsrecloser2 = new JSONObject();
        JSONObject damageDetailsrecloser3 = new JSONObject();
        JSONObject damageDetailsrecloser4 = new JSONObject();
        JSONObject damageDetailsrecloser5 = new JSONObject();
        JSONObject damageDetailsrecloser6 = new JSONObject();
        JSONObject damageDetailsrecloser7 = new JSONObject();
        JSONObject damageDetailsrecloser8 = new JSONObject();
        JSONObject damageDetailsrecloser9 = new JSONObject();
        JSONObject damageDetailsrecloser10 = new JSONObject();

        JSONObject loadBreak_1 = new JSONObject();
        JSONObject loadBreakDamagePart = new JSONObject();
        JSONObject loadBreakPartName = new JSONObject();
        JSONObject damageDetailsloadBreak1 = new JSONObject();
        JSONObject damageDetailsloadBreak2 = new JSONObject();
        JSONObject damageDetailsloadBreak3 = new JSONObject();
        JSONObject damageDetailsloadBreak4 = new JSONObject();
        JSONObject damageDetailsloadBreak5 = new JSONObject();
        JSONObject damageDetailsloadBreak6 = new JSONObject();
        JSONObject damageDetailsloadBreak7 = new JSONObject();
        JSONObject damageDetailsloadBreak8 = new JSONObject();
        JSONObject damageDetailsloadBreak9 = new JSONObject();
        JSONObject damageDetailsloadBreak10 = new JSONObject();

        JSONObject regulatorOneData = ReadSplEquipmentData.getInstance().readregulatorOneData();
        JSONObject regulatorTwoData = ReadSplEquipmentData.getInstance().readregulatorTwoData();
        JSONObject regulatorThreeData = ReadSplEquipmentData.getInstance().readregulatorThreeData();
        JSONObject regulatorFourData = ReadSplEquipmentData.getInstance().readregulatorFourData();
        JSONObject regulatorFiveData = ReadSplEquipmentData.getInstance().readregulatorFiveData();
        JSONObject regulatorSixData = ReadSplEquipmentData.getInstance().readregulatorSixData();
        JSONObject regulatorEightData = ReadSplEquipmentData.getInstance().readregulatorSevenData();
        JSONObject regulatorSevenData = ReadSplEquipmentData.getInstance().readregulatorEightData();
        JSONObject regulatorNineData = ReadSplEquipmentData.getInstance().readregulatorNineData();
        JSONObject regulatorTenData = ReadSplEquipmentData.getInstance().readregulatorTenData();

        JSONObject capacitorBankOneData = ReadSplEquipmentData.getInstance().readcapacitorBankOneData();
        JSONObject capacitorBankTwoData = ReadSplEquipmentData.getInstance().readcapacitorBankTwoData();
        JSONObject capacitorBankThreeData = ReadSplEquipmentData.getInstance().readcapacitorBankThreeData();
        JSONObject capacitorBankFourData = ReadSplEquipmentData.getInstance().readcapacitorBankFourData();
        JSONObject capacitorBankFiveData = ReadSplEquipmentData.getInstance().readcapacitorBankFiveData();
        JSONObject capacitorBankSixData = ReadSplEquipmentData.getInstance().readcapacitorBankSixData();
        JSONObject capacitorBankEightData = ReadSplEquipmentData.getInstance().readcapacitorBankSevenData();
        JSONObject capacitorBankSevenData = ReadSplEquipmentData.getInstance().readcapacitorBankEightData();
        JSONObject capacitorBankNineData = ReadSplEquipmentData.getInstance().readcapacitorBankNineData();
        JSONObject capacitorBankTenData = ReadSplEquipmentData.getInstance().readcapacitorBankTenData();

        JSONObject recloserOneData = ReadSplEquipmentData.getInstance().readrecloserOneData();
        JSONObject recloserTwoData = ReadSplEquipmentData.getInstance().readrecloserTwoData();
        JSONObject recloserThreeData = ReadSplEquipmentData.getInstance().readrecloserThreeData();
        JSONObject recloserFourData = ReadSplEquipmentData.getInstance().readrecloserFourData();
        JSONObject recloserFiveData = ReadSplEquipmentData.getInstance().readrecloserFiveData();
        JSONObject recloserSixData = ReadSplEquipmentData.getInstance().readrecloserSixData();
        JSONObject recloserEightData = ReadSplEquipmentData.getInstance().readrecloserSevenData();
        JSONObject recloserSevenData = ReadSplEquipmentData.getInstance().readrecloserEightData();
        JSONObject recloserNineData = ReadSplEquipmentData.getInstance().readrecloserNineData();
        JSONObject recloserTenData = ReadSplEquipmentData.getInstance().readrecloserTenData();

        JSONObject loadBreakOneData = ReadSplEquipmentData.getInstance().readloadBreakSwitchOneData();
        JSONObject loadBreakTwoData = ReadSplEquipmentData.getInstance().readloadBreakSwitchTwoData();
        JSONObject loadBreakThreeData = ReadSplEquipmentData.getInstance().readloadBreakSwitchThreeData();
        JSONObject loadBreakFourData = ReadSplEquipmentData.getInstance().readloadBreakSwitchFourData();
        JSONObject loadBreakFiveData = ReadSplEquipmentData.getInstance().readloadBreakSwitchFiveData();
        JSONObject loadBreakSixData = ReadSplEquipmentData.getInstance().readloadBreakSwitchSixData();
        JSONObject loadBreakEightData = ReadSplEquipmentData.getInstance().readloadBreakSwitchSevenData();
        JSONObject loadBreakSevenData = ReadSplEquipmentData.getInstance().readloadBreakSwitchEightData();
        JSONObject loadBreakNineData = ReadSplEquipmentData.getInstance().readloadBreakSwitchNineData();
        JSONObject loadBreakTenData = ReadSplEquipmentData.getInstance().readloadBreakSwitchTenData();
        {
            try{


                count = 0;
                String regulatorTitle_name = "Regulator";
                String regulatorTitle = "REGULATOR";
                /*if (regulatorTitle != null)
                    regulatorTitle = regulatorTitle.replaceAll("\\s", "_").toUpperCase();*/
                if (regulatorOneData != null) {

                    damageDetailsregulator1.put("damageDetails", regulatorOneData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorOnePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsregulator1.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_1", damageDetailsregulator1);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 1);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorTwoData != null) {

                    damageDetailsregulator2.put("damageDetails", regulatorTwoData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);

                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator2.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_2", damageDetailsregulator2);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 2);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorThreeData != null) {
                    damageDetailsregulator3.put("damageDetails", regulatorThreeData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();
                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorThreePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);

                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator3.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_3", damageDetailsregulator3);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 3);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorFourData != null) {

                    damageDetailsregulator4.put("damageDetails", regulatorFourData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator4.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_4", damageDetailsregulator4);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 4);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorFiveData != null) {

                    damageDetailsregulator5.put("damageDetails", regulatorFiveData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator5.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_5", damageDetailsregulator5);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 5);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorSixData != null) {

                    damageDetailsregulator6.put("damageDetails", regulatorSixData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();
                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator6.put("images", images);
                    }

                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_6", damageDetailsregulator6);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 6);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorSevenData != null) {

                    damageDetailsregulator7.put("damageDetails", regulatorSevenData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator7.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_7", damageDetailsregulator7);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 7);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorEightData != null) {

                    damageDetailsregulator8.put("damageDetails", regulatorEightData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator8.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_8", damageDetailsregulator8);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 8);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorNineData != null) {

                    damageDetailsregulator9.put("damageDetails", regulatorNineData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator9.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_9", damageDetailsregulator9);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 9);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if (regulatorTenData != null) {

                    damageDetailsregulator10.put("damageDetails", regulatorTenData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().regulatorTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsregulator10.put("images", images);
                    }
                    regulatorPartName.put("partName", regulatorTitle);
                    regulatorPartName.put("damageData", regulator_1);
                    regulator_1.put("REGULATOR_10", damageDetailsregulator10);
                    regulator.put("REGULATOR", regulatorPartName);
                    regulatorPartName.put("partDisplayName", regulatorTitle_name);
                    regulatorPartName.put("numberOfParts", 10);
                    regulatorDamagePart.put("damagedParts", regulator);
                    count++;
                }
                if(count > 0){
                    regulatorDamagePart.put("scopename", "SPL Equipment");
                    regulatorDamagePart.put("scopeDisplayName", "SPL Equipment");
                    poleScope.put("SPLEquipment", regulatorDamagePart);

                }} catch (JSONException e) {
                e.printStackTrace();
            }try{
            count = 0;
            String pictureName;
            String capacitorBankTitle_name = "Capacitor Bank";
            String capacitorBankTitle = "CAPACITOR_BANK";
           /* if (capacitorBankTitle != null)
                capacitorBankTitle = capacitorBankTitle.replaceAll("\\s", "_").toUpperCase();*/
            if (capacitorBankOneData != null) {

                damageDetailscapacitorBank1.put("damageDetails", capacitorBankOneData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank1.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_1", damageDetailscapacitorBank1);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 1);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankTwoData != null) {

                damageDetailscapacitorBank2.put("damageDetails", capacitorBankTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailscapacitorBank2.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_2", damageDetailscapacitorBank2);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 2);
                capacitorBankDamagePart.put("damagedParts", regulator);

                count++;
            }
            if (capacitorBankThreeData != null) {

                damageDetailscapacitorBank3.put("damageDetails", capacitorBankThreeData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailscapacitorBank3.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_3", damageDetailscapacitorBank3);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 3);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankFourData != null) {

                damageDetailscapacitorBank4.put("damageDetails", capacitorBankFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank4.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_4", damageDetailscapacitorBank4);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 4);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankFiveData != null) {

                damageDetailscapacitorBank5.put("damageDetails", capacitorBankFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank5.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_5", damageDetailscapacitorBank5);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 5);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankSixData != null) {

                damageDetailscapacitorBank6.put("damageDetails", capacitorBankSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank6.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_6", damageDetailscapacitorBank6);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 6);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankSevenData != null) {

                damageDetailscapacitorBank7.put("damageDetails", capacitorBankSevenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank7.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_7", damageDetailscapacitorBank7);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 7);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankEightData != null) {

                damageDetailscapacitorBank8.put("damageDetails", capacitorBankEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank8.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_8", damageDetailscapacitorBank8);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 8);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankNineData != null) {

                damageDetailscapacitorBank9.put("damageDetails", capacitorBankNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank9.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_9", damageDetailscapacitorBank9);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 9);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (capacitorBankTenData != null) {

                damageDetailscapacitorBank10.put("damageDetails", capacitorBankTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().capacitorBankTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailscapacitorBank10.put("images", images);
                }
                capacitorBankPartName.put("partName", capacitorBankTitle);
                capacitorBankPartName.put("damageData", capacitorBank_1);
                capacitorBank_1.put("CAPACITOR_BANK_10", damageDetailscapacitorBank10);
                regulator.put("CAPACITOR_BANK", capacitorBankPartName);
                capacitorBankPartName.put("partDisplayName", capacitorBankTitle_name);
                capacitorBankPartName.put("numberOfParts", 10);
                capacitorBankDamagePart.put("damagedParts", regulator);
                count++;
            }
            if(count > 0){
                capacitorBankDamagePart.put("scopename", "SPL Equipment");
                capacitorBankDamagePart.put("scopeDisplayName", "SPL Equipment");
                poleScope.put("SPL Equipment", capacitorBankDamagePart);

            }} catch (JSONException e) {
            e.printStackTrace();
        }try{
            count = 0;
            String recloserTitle_name = "Recloser";
            String recloserTitle = "RECLOSER";
            String pictureName;
           /* if (recloserTitle != null)
                recloserTitle = recloserTitle.replaceAll("\\s", "_").toUpperCase();*/
            if (recloserOneData != null) {

                damageDetailsrecloser1.put("damageDetails", recloserOneData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser1.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_1", damageDetailsrecloser1);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 1);
                recloserDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (recloserTwoData != null) {

                damageDetailsrecloser2.put("damageDetails", recloserTwoData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser2.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_2", damageDetailsrecloser2);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 2);
                recloserDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (recloserThreeData != null) {

                damageDetailsrecloser3.put("damageDetails", recloserThreeData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser3.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_3", damageDetailsrecloser3);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 3);
                recloserDamagePart.put("damagedParts", regulator);
                count++;
            }
            if (recloserFourData != null) {

                damageDetailsrecloser4.put("damageDetails", recloserFourData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser4.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_4", damageDetailsrecloser4);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 4);
                recloserDamagePart.put("damagedParts", regulator);
                // poleTopEquipment.put("Other", recloserDamagePart);
                count++;
            }
            if (recloserFiveData != null) {

                damageDetailsrecloser5.put("damageDetails", recloserFiveData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser5.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_5", damageDetailsrecloser5);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 5);
                recloserDamagePart.put("damagedParts", regulator);
                //  poleTopEquipment.put("Other", recloserDamagePart);
                count++;
            }
            if (recloserSixData != null) {

                damageDetailsrecloser6.put("damageDetails", recloserSixData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserSixPicturePath;

                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser6.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_6", damageDetailsrecloser6);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 6);
                recloserDamagePart.put("damagedParts", regulator);
                //   poleTopEquipment.put("Other", recloserDamagePart);
                count++;
            }
            if (recloserSevenData != null) {

                damageDetailsrecloser7.put("damageDetails", recloserSevenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser7.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_7", damageDetailsrecloser7);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 7);
                recloserDamagePart.put("damagedParts", regulator);
                //  poleTopEquipment.put("Other", recloserDamagePart);
                count++;
            }
            if (recloserEightData != null) {

                damageDetailsrecloser8.put("damageDetails", recloserEightData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser8.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_8", damageDetailsrecloser8);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 8);
                recloserDamagePart.put("damagedParts", regulator);
                //  poleTopEquipment.put("Other", recloserDamagePart);
                count++;
            }
            if (recloserNineData != null) {

                damageDetailsrecloser9.put("damageDetails", recloserNineData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser9.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_9", damageDetailsrecloser9);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 9);
                recloserDamagePart.put("damagedParts", regulator);
                //  poleTopEquipment.put("Other", recloserDamagePart);
                count++;
            }
            if (recloserTenData != null) {

                damageDetailsrecloser10.put("damageDetails", recloserTenData);
                JSONArray images = new JSONArray();
                JSONObject imagesObject = new JSONObject();

                pictureName = null;
                pictureName = ReadSplEquipmentData.getInstance().recloserTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsrecloser10.put("images", images);
                }
                recloserPartName.put("partName", recloserTitle);
                recloserPartName.put("damageData", recloser_1);
                recloser_1.put("RECLOSER_10", damageDetailsrecloser10);
                regulator.put("RECLOSER", recloserPartName);
                recloserPartName.put("partDisplayName", recloserTitle_name);
                recloserPartName.put("numberOfParts", 10);
                recloserDamagePart.put("damagedParts", regulator);
                // poleTopEquipment.put("Other", recloserDamagePart);
                count++;
            }
            if(count > 0){
                recloserDamagePart.put("scopename", "SPL Equipment");
                recloserDamagePart.put("scopeDisplayName", "SPL Equipment");
                poleScope.put("SPLEquipment", recloserDamagePart);

            }  } catch (JSONException e) {
            e.printStackTrace();
        }

            try{
                count = 0;
                String loadBreakTitle_name = "Loadbreak Switch";
                String loadBreakTitle = "LOADBREAK_SWITCH";
                String pictureName;
   /*             if (loadBreakTitle != null)
                    loadBreakTitle = loadBreakTitle.replaceAll("\\s", "_").toUpperCase();*/
                if (loadBreakOneData != null) {

                    damageDetailsloadBreak1.put("damageDetails", loadBreakOneData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakOnePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak1.put("images", images);
                    }
                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_1", damageDetailsloadBreak1);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 1);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    // poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakTwoData != null) {

                    damageDetailsloadBreak2.put("damageDetails", loadBreakTwoData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak2.put("images", images);
                    }
                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_2", damageDetailsloadBreak2);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 2);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    //  poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakThreeData != null) {

                    damageDetailsloadBreak3.put("damageDetails", loadBreakThreeData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakThreePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak3.put("images", images);
                    }
                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_3", damageDetailsloadBreak3);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 3);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    //   poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakFourData != null) {

                    damageDetailsloadBreak4.put("damageDetails", loadBreakFourData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak4.put("images", images);
                    }

                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_4", damageDetailsloadBreak4);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 4);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    // poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakFiveData != null) {

                    damageDetailsloadBreak5.put("damageDetails", loadBreakFiveData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak5.put("images", images);
                    }

                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_5", damageDetailsloadBreak5);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 5);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    //  poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakSixData != null) {

                    damageDetailsloadBreak6.put("damageDetails", loadBreakSixData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakSixPicturePath;

                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak6.put("images", images);
                    }

                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_6", damageDetailsloadBreak6);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 6);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    //  poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakSevenData != null) {

                    damageDetailsloadBreak7.put("damageDetails", loadBreakSevenData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak7.put("images", images);
                    }
                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_7", damageDetailsloadBreak7);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 7);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    //  poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakEightData != null) {

                    damageDetailsloadBreak8.put("damageDetails", loadBreakEightData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak8.put("images", images);
                    }
                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_8", damageDetailsloadBreak8);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 8);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    //  poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakNineData != null) {

                    damageDetailsloadBreak9.put("damageDetails", loadBreakNineData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak9.put("images", images);
                    }
                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_9", damageDetailsloadBreak9);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 9);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    //  poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if (loadBreakTenData != null) {

                    damageDetailsloadBreak10.put("damageDetails", loadBreakTenData);
                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    pictureName = null;
                    pictureName = ReadSplEquipmentData.getInstance().loadBreakTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsloadBreak10.put("images", images);
                    }
                    loadBreakPartName.put("partName", loadBreakTitle);
                    loadBreakPartName.put("damageData", loadBreak_1);
                    loadBreak_1.put("LOADBREAK_SWITCH_10", damageDetailsloadBreak10);
                    regulator.put("LOADBREAK_SWITCH", loadBreakPartName);
                    loadBreakPartName.put("partDisplayName", loadBreakTitle_name);
                    loadBreakPartName.put("numberOfParts", 10);
                    loadBreakDamagePart.put("damagedParts", regulator);
                    // poleTopEquipment.put("Other", loadBreakDamagePart);
                    count++;
                }
                if(count > 0){
                    loadBreakDamagePart.put("scopename", "SPL Equipment");
                    loadBreakDamagePart.put("scopeDisplayName", "SPL Equipment");
                    poleScope.put("SPLEquipment", loadBreakDamagePart);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            // junk();


        }
    }

    private void LoadTreeScopeSelectedData() {
        int count = 0;
        JSONObject treeOneData = ReadTreeData.getInstance().readtreeOneData();
        JSONObject treeTwoData = ReadTreeData.getInstance().readtreeTwoData();
        JSONObject treeThreeData = ReadTreeData.getInstance().readtreeThreeData();
        JSONObject treeFourData = ReadTreeData.getInstance().readtreeFourData();
        JSONObject treeFiveoData = ReadTreeData.getInstance().readtreeFiveData();
        JSONObject treeSixData = ReadTreeData.getInstance().readtreeSixData();
        JSONObject treeSevenData = ReadTreeData.getInstance().readtreeSevenData();
        JSONObject treeEightData = ReadTreeData.getInstance().readtreeEightData();
        JSONObject treeNineData = ReadTreeData.getInstance().readtreeNineData();
        JSONObject treeTenData = ReadTreeData.getInstance().readtreeTenData();


        JSONObject damageDetailstree1 = new JSONObject();
        JSONObject damageDetailstree2 = new JSONObject();
        JSONObject damageDetailstree3 = new JSONObject();
        JSONObject damageDetailstree4 = new JSONObject();
        JSONObject damageDetailstree5 = new JSONObject();
        JSONObject damageDetailstree6 = new JSONObject();
        JSONObject damageDetailstree7 = new JSONObject();
        JSONObject damageDetailstree8 = new JSONObject();
        JSONObject damageDetailstree9 = new JSONObject();
        JSONObject damageDetailstree10 = new JSONObject();
        JSONObject tree = new JSONObject();
        JSONObject tree_1 = new JSONObject();
        JSONObject treeDamagePart = new JSONObject();
        JSONObject treePartName = new JSONObject();

        try{
            String treeTitle_name = "Tree";
            String treeTitle = "TREE";
          /*  if (poleTitle != null)
                poleTitle = poleTitle.replaceAll("\\s", "_").toUpperCase();*/
            if (treeOneData != null) {
                for (int i = 0; i < TreeData.getInstance().treeOne.size(); i++) {
                    damageDetailstree1.put("damageDetails", treeOneData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeOnePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailstree1.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_1", damageDetailstree1);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 1);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }
            if (treeTwoData != null) {
                for (int i = 0; i < TreeData.getInstance().treeTwo.size(); i++) {
                    damageDetailstree2.put("damageDetails", treeTwoData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailstree2.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_2", damageDetailstree2);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 2);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            } if (treeThreeData != null) {
                for (int i = 0; i < TreeData.getInstance().treeThree.size(); i++) {
                    damageDetailstree3.put("damageDetails", treeThreeData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeThreePicturePath;

                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailstree3.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_3", damageDetailstree3);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 3);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }
            if (treeFourData != null) {
                for (int i = 0; i < TreeData.getInstance().treeFour.size(); i++) {
                    damageDetailstree4.put("damageDetails", treeFourData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailstree4.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_4", damageDetailstree4);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 4);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }
            if (treeFiveoData != null) {

                for (int i = 0; i < TreeData.getInstance().treeFive.size(); i++) {
                    damageDetailstree5.put("damageDetails", treeFiveoData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailstree5.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_5", damageDetailstree5);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 5);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }
            if (treeSixData != null) {

                for (int i = 0; i < TreeData.getInstance().treeSix.size(); i++) {
                    damageDetailstree6.put("damageDetails", treeSixData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailstree6.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_6", damageDetailstree6);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 6);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }
            if (treeSevenData != null) {

                for (int i = 0; i < TreeData.getInstance().treeSeven.size(); i++) {

                    damageDetailstree7.put("damageDetails", treeSevenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailstree7.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_7", damageDetailstree7);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 7);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }  if (treeEightData != null) {

                for (int i = 0; i < TreeData.getInstance().treeEight.size(); i++) {

                    damageDetailstree8.put("damageDetails", treeEightData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailstree8.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_8", damageDetailstree8);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 8);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }  if (treeNineData != null) {

                for (int i = 0; i < TreeData.getInstance().treeNine.size(); i++) {

                    damageDetailstree9.put("damageDetails", treeNineData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailstree9.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_9", damageDetailstree9);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 9);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }  if (treeTenData != null) {

                for (int i = 0; i < TreeData.getInstance().treeTen.size(); i++) {

                    damageDetailstree10.put("damageDetails", treeTenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadTreeData.getInstance().treeTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailstree10.put("images", images);
                    }
                    treePartName.put("partName", treeTitle);
                    treePartName.put("damageData", tree_1);
                    tree_1.put("TREE_10", damageDetailstree10);
                    tree.put("TREE", treePartName);
                    treePartName.put("partDisplayName", treeTitle_name);
                    treePartName.put("numberOfParts", 10);
                    treeDamagePart.put("damagedParts", tree);
                    count++;
                }
            }
            if(count > 0) {
                treeDamagePart.put("scopename", treeTitle_name);
                treeDamagePart.put("scopeDisplayName", treeTitle_name);
                poleScope.put("Tree", treeDamagePart);
            }
        }catch (JSONException e)
        {

        }
    }

    private void LoadPoleScopeSelectedData() {
        int count = 0;
        String poleTitle = ReadPoleEquipmentData.getInstance().poleTitle;
        JSONObject poleOneData = ReadPoleEquipmentData.getInstance().readpoleOneData();
        JSONObject poleTwoData = ReadPoleEquipmentData.getInstance().readpoleTwoData();
        JSONObject poleThreeData = ReadPoleEquipmentData.getInstance().readpoleThreeData();
        JSONObject poleFourData = ReadPoleEquipmentData.getInstance().readpoleFourData();
        JSONObject poleFiveoData = ReadPoleEquipmentData.getInstance().readpoleFiveData();
        JSONObject poleSixData = ReadPoleEquipmentData.getInstance().readpoleSixData();
        JSONObject poleSevenData = ReadPoleEquipmentData.getInstance().readpoleSevenData();
        JSONObject poleEightData = ReadPoleEquipmentData.getInstance().readpoleEightData();
        JSONObject poleNineData = ReadPoleEquipmentData.getInstance().readpoleNineData();
        JSONObject poleTenData = ReadPoleEquipmentData.getInstance().readpoleTenData();


        JSONObject damageDetailspole1 = new JSONObject();
        JSONObject damageDetailspole2 = new JSONObject();
        JSONObject damageDetailspole3 = new JSONObject();
        JSONObject damageDetailspole4 = new JSONObject();
        JSONObject damageDetailspole5 = new JSONObject();
        JSONObject damageDetailspole6 = new JSONObject();
        JSONObject damageDetailspole7 = new JSONObject();
        JSONObject damageDetailspole8 = new JSONObject();
        JSONObject damageDetailspole9 = new JSONObject();
        JSONObject damageDetailspole10 = new JSONObject();
        JSONObject pole = new JSONObject();
        JSONObject pole_1 = new JSONObject();
        JSONObject poleDamagePart = new JSONObject();
        JSONObject polePartName = new JSONObject();

        try{
            String poleTitle_name = "Pole";
            poleTitle = "POLE";
          /*  if (poleTitle != null)
                poleTitle = poleTitle.replaceAll("\\s", "_").toUpperCase();*/
            if (poleOneData != null) {
                for (int i = 0; i < PoleData.getInstance().poleOne.size(); i++) {
                    damageDetailspole1.put("damageDetails", poleOneData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleOnePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspole1.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_1", damageDetailspole1);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 1);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }
            if (poleTwoData != null) {
                for (int i = 0; i < PoleData.getInstance().poleTwo.size(); i++) {
                    damageDetailspole2.put("damageDetails", poleTwoData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspole2.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_2", damageDetailspole2);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 2);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            } if (poleThreeData != null) {
                for (int i = 0; i < PoleData.getInstance().poleThree.size(); i++) {
                    damageDetailspole3.put("damageDetails", poleThreeData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleThreePicturePath;

                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspole3.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_3", damageDetailspole3);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 3);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }
            if (poleFourData != null) {
                for (int i = 0; i < PoleData.getInstance().poleFour.size(); i++) {
                    damageDetailspole4.put("damageDetails", poleFourData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspole4.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_4", damageDetailspole4);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 4);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }
            if (poleFiveoData != null) {

                for (int i = 0; i < PoleData.getInstance().poleFive.size(); i++) {
                    damageDetailspole5.put("damageDetails", poleFiveoData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspole5.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_5", damageDetailspole5);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 5);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }
            if (poleSixData != null) {

                for (int i = 0; i < PoleData.getInstance().poleSix.size(); i++) {
                    damageDetailspole6.put("damageDetails", poleSixData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspole6.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_6", damageDetailspole6);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 6);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }
            if (poleSevenData != null) {

                for (int i = 0; i < PoleData.getInstance().poleSeven.size(); i++) {

                    damageDetailspole7.put("damageDetails", poleSevenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspole7.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_7", damageDetailspole7);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 7);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }  if (poleEightData != null) {

                for (int i = 0; i < PoleData.getInstance().poleEight.size(); i++) {

                    damageDetailspole8.put("damageDetails", poleEightData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspole8.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_8", damageDetailspole8);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 8);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }  if (poleNineData != null) {

                for (int i = 0; i < PoleData.getInstance().poleNine.size(); i++) {

                    damageDetailspole9.put("damageDetails", poleNineData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspole9.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_9", damageDetailspole9);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 9);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }  if (poleTenData != null) {

                for (int i = 0; i < PoleData.getInstance().poleTen.size(); i++) {

                    damageDetailspole10.put("damageDetails", poleTenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    String pictureName = null;
                    pictureName = ReadPoleEquipmentData.getInstance().poleTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspole10.put("images", images);
                    }
                    polePartName.put("partName", poleTitle);
                    polePartName.put("damageData", pole_1);
                    pole_1.put("POLE_10", damageDetailspole10);
                    pole.put("POLE", polePartName);
                    polePartName.put("partDisplayName", poleTitle_name);
                    polePartName.put("numberOfParts", 10);
                    poleDamagePart.put("damagedParts", pole);
                    count++;
                }
            }
            if(count > 0) {
                poleDamagePart.put("scopename", poleTitle_name);
                poleDamagePart.put("scopeDisplayName", poleTitle_name);
                poleScope.put("Pole", poleDamagePart);
            }
            }catch (JSONException e)
        {

        }
    }
    private void LoadOthersScopeSelectedData() {
        int count = 0;
        JSONObject padmounts = new JSONObject();
        JSONObject padmounts_1 = new JSONObject();
        JSONObject padmountsDamagePart = new JSONObject();
        JSONObject padmountsPartName = new JSONObject();
        JSONObject damageDetailspadmounts1 = new JSONObject();
        JSONObject damageDetailspadmounts2 = new JSONObject();
        JSONObject damageDetailspadmounts3 = new JSONObject();
        JSONObject damageDetailspadmounts4 = new JSONObject();
        JSONObject damageDetailspadmounts5 = new JSONObject();
        JSONObject damageDetailspadmounts6 = new JSONObject();
        JSONObject damageDetailspadmounts7 = new JSONObject();
        JSONObject damageDetailspadmounts8 = new JSONObject();
        JSONObject damageDetailspadmounts9 = new JSONObject();
        JSONObject damageDetailspadmounts10 = new JSONObject();

        JSONObject pullBox_1 = new JSONObject();
        JSONObject pullBoxDamagePart = new JSONObject();
        JSONObject pullBoxPartName = new JSONObject();
        JSONObject damageDetailspullBox1 = new JSONObject();
        JSONObject damageDetailspullBox2 = new JSONObject();
        JSONObject damageDetailspullBox3 = new JSONObject();
        JSONObject damageDetailspullBox4 = new JSONObject();
        JSONObject damageDetailspullBox5 = new JSONObject();
        JSONObject damageDetailspullBox6 = new JSONObject();
        JSONObject damageDetailspullBox7 = new JSONObject();
        JSONObject damageDetailspullBox8 = new JSONObject();
        JSONObject damageDetailspullBox9 = new JSONObject();
        JSONObject damageDetailspullBox10 = new JSONObject();

        JSONObject spiceBox_1 = new JSONObject();
        JSONObject spiceBoxDamagePart = new JSONObject();
        JSONObject spiceBoxPartName = new JSONObject();
        JSONObject damageDetailsspiceBox1 = new JSONObject();
        JSONObject damageDetailsspiceBox2 = new JSONObject();
        JSONObject damageDetailsspiceBox3 = new JSONObject();
        JSONObject damageDetailsspiceBox4 = new JSONObject();
        JSONObject damageDetailsspiceBox5 = new JSONObject();
        JSONObject damageDetailsspiceBox6 = new JSONObject();
        JSONObject damageDetailsspiceBox7 = new JSONObject();
        JSONObject damageDetailsspiceBox8 = new JSONObject();
        JSONObject damageDetailsspiceBox9 = new JSONObject();
        JSONObject damageDetailsspiceBox10 = new JSONObject();

        JSONObject sectionalizerCabinet_1 = new JSONObject();
        JSONObject sectionalizerCabinetDamagePart = new JSONObject();
        JSONObject sectionalizerCabinetPartName = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet1 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet2 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet3 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet4 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet5 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet6 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet7 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet8 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet9 = new JSONObject();
        JSONObject damageDetailssectionalizerCabinet10 = new JSONObject();

        JSONObject padmountsOneData = ReadUnderGroundData.getInstance().readpadmountsOneData();
        JSONObject padmountsTwoData = ReadUnderGroundData.getInstance().readpadmountsTwoData();
        JSONObject padmountsThreeData = ReadUnderGroundData.getInstance().readpadmountsThreeData();
        JSONObject padmountsFourData = ReadUnderGroundData.getInstance().readpadmountsFourData();
        JSONObject padmountsFiveData = ReadUnderGroundData.getInstance().readpadmountsFiveData();
        JSONObject padmountsSixData = ReadUnderGroundData.getInstance().readpadmountsSixData();
        JSONObject padmountsEightData = ReadUnderGroundData.getInstance().readpadmountsSevenData();
        JSONObject padmountsSevenData = ReadUnderGroundData.getInstance().readpadmountsEightData();
        JSONObject padmountsNineData = ReadUnderGroundData.getInstance().readpadmountsNineData();
        JSONObject padmountsTenData = ReadUnderGroundData.getInstance().readpadmountsTenData();

        JSONObject pullBoxOneData = ReadUnderGroundData.getInstance().readpullBoxOneData();
        JSONObject pullBoxTwoData = ReadUnderGroundData.getInstance().readpullBoxTwoData();
        JSONObject pullBoxThreeData = ReadUnderGroundData.getInstance().readpullBoxThreeData();
        JSONObject pullBoxFourData = ReadUnderGroundData.getInstance().readpullBoxFourData();
        JSONObject pullBoxFiveData = ReadUnderGroundData.getInstance().readpullBoxFiveData();
        JSONObject pullBoxSixData = ReadUnderGroundData.getInstance().readpullBoxSixData();
        JSONObject pullBoxEightData = ReadUnderGroundData.getInstance().readpullBoxSevenData();
        JSONObject pullBoxSevenData = ReadUnderGroundData.getInstance().readpullBoxEightData();
        JSONObject pullBoxNineData = ReadUnderGroundData.getInstance().readpullBoxNineData();
        JSONObject pullBoxTenData = ReadUnderGroundData.getInstance().readpullBoxTenData();

        JSONObject spiceBoxOneData = ReadUnderGroundData.getInstance().readspiceBoxOneData();
        JSONObject spiceBoxTwoData = ReadUnderGroundData.getInstance().readspiceBoxTwoData();
        JSONObject spiceBoxThreeData = ReadUnderGroundData.getInstance().readspiceBoxThreeData();
        JSONObject spiceBoxFourData = ReadUnderGroundData.getInstance().readspiceBoxFourData();
        JSONObject spiceBoxFiveData = ReadUnderGroundData.getInstance().readspiceBoxFiveData();
        JSONObject spiceBoxSixData = ReadUnderGroundData.getInstance().readspiceBoxSixData();
        JSONObject spiceBoxEightData = ReadUnderGroundData.getInstance().readspiceBoxSevenData();
        JSONObject spiceBoxSevenData = ReadUnderGroundData.getInstance().readspiceBoxEightData();
        JSONObject spiceBoxNineData = ReadUnderGroundData.getInstance().readspiceBoxNineData();
        JSONObject spiceBoxTenData = ReadUnderGroundData.getInstance().readspiceBoxTenData();

        JSONObject sectionalizerCabinetOneData = ReadUnderGroundData.getInstance().readsectionalizerCabinetOneData();
        JSONObject sectionalizerCabinetTwoData = ReadUnderGroundData.getInstance().readsectionalizerCabinetTwoData();
        JSONObject sectionalizerCabinetThreeData = ReadUnderGroundData.getInstance().readsectionalizerCabinetThreeData();
        JSONObject sectionalizerCabinetFourData = ReadUnderGroundData.getInstance().readsectionalizerCabinetFourData();
        JSONObject sectionalizerCabinetFiveData = ReadUnderGroundData.getInstance().readsectionalizerCabinetFiveData();
        JSONObject sectionalizerCabinetSixData = ReadUnderGroundData.getInstance().readsectionalizerCabinetSixData();
        JSONObject sectionalizerCabinetEightData = ReadUnderGroundData.getInstance().readsectionalizerCabinetSevenData();
        JSONObject sectionalizerCabinetSevenData = ReadUnderGroundData.getInstance().readsectionalizerCabinetEightData();
        JSONObject sectionalizerCabinetNineData = ReadUnderGroundData.getInstance().readsectionalizerCabinetNineData();
        JSONObject sectionalizerCabinetTenData = ReadUnderGroundData.getInstance().readsectionalizerCabinetTenData();

        {
            try {


                count = 0;
                String padmountTitle_name = "Padmounts";
                String padmountTitle = "PADMOUNTS";
                /*if (regulatorTitle != null)
                    regulatorTitle = regulatorTitle.replaceAll("\\s", "_").toUpperCase();*/
                if (padmountsOneData != null) {

                    damageDetailspadmounts1.put("damageDetails", padmountsOneData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsOnePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts1.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_1", damageDetailspadmounts1);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 1);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsTwoData != null) {

                    damageDetailspadmounts2.put("damageDetails", padmountsTwoData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts2.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_2", damageDetailspadmounts2);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 2);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsThreeData != null) {

                    damageDetailspadmounts3.put("damageDetails", padmountsThreeData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsThreePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts3.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_3", damageDetailspadmounts3);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 3);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsFourData != null) {

                    damageDetailspadmounts4.put("damageDetails", padmountsFourData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts4.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_4", damageDetailspadmounts4);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 4);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsFiveData != null) {

                    damageDetailspadmounts5.put("damageDetails", padmountsFiveData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts5.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_5", damageDetailspadmounts5);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 5);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsSixData != null) {

                    damageDetailspadmounts6.put("damageDetails", padmountsSixData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts6.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_6", damageDetailspadmounts6);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 6);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsSevenData != null) {

                    damageDetailspadmounts7.put("damageDetails", padmountsSevenData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts7.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_7", damageDetailspadmounts7);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 7);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsEightData != null) {

                    damageDetailspadmounts8.put("damageDetails", padmountsEightData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts8.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_8", damageDetailspadmounts8);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 8);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsNineData != null) {

                    damageDetailspadmounts9.put("damageDetails", padmountsNineData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts9.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_9", damageDetailspadmounts9);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 9);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (padmountsTenData != null) {

                    damageDetailspadmounts10.put("damageDetails", padmountsTenData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().padmountsTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailspadmounts10.put("images", images);
                    }
                    padmountsPartName.put("partName", padmountTitle);
                    padmountsPartName.put("damageData", padmounts_1);
                    padmounts_1.put("PADMOUNTS_10", damageDetailspadmounts10);
                    padmounts.put("PADMOUNTS", padmountsPartName);
                    padmountsPartName.put("partDisplayName", padmountTitle_name);
                    padmountsPartName.put("numberOfParts", 10);
                    padmountsDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (count > 0) {
                    padmountsDamagePart.put("scopename", "Other");
                    padmountsDamagePart.put("scopeDisplayName", "Other");
                    poleScope.put("Other", padmountsDamagePart);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                count = 0;
                String pullBoxTitle_name = "Pull Box";
                String pullBoxTitle = "PULL_BOX";
                String pictureName;
            /*if (pullBoxTitle != null)
                pullBoxTitle = pullBoxTitle.replaceAll("\\s", "_").toUpperCase();*/
                if (pullBoxOneData != null) {

                    damageDetailspullBox1.put("damageDetails", pullBoxOneData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;

                    pictureName = ReadUnderGroundData.getInstance().pullBoxOnePicturePath;

                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox1.put("images", images);
                    }


                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_1", damageDetailspullBox1);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 1);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    //  poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxTwoData != null) {

                    damageDetailspullBox2.put("damageDetails", pullBoxTwoData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        testImages.put(testImagesObject);
                        damageDetailspullBox2.put("images", images);
                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_2", damageDetailspullBox2);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 2);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxThreeData != null) {

                    damageDetailspullBox3.put("damageDetails", pullBoxThreeData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxThreePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox3.put("images", images);
                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_3", damageDetailspullBox3);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 3);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxFourData != null) {

                    damageDetailspullBox4.put("damageDetails", pullBoxFourData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox4.put("images", images);
                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_4", damageDetailspullBox4);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 4);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxFiveData != null) {

                    damageDetailspullBox5.put("damageDetails", pullBoxFiveData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox5.put("images", images);

                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_5", damageDetailspullBox5);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 5);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxSixData != null) {

                    damageDetailspullBox6.put("damageDetails", pullBoxSixData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox6.put("images", images);

                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_6", damageDetailspullBox6);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 6);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxSevenData != null) {

                    damageDetailspullBox7.put("damageDetails", pullBoxSevenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox7.put("images", images);

                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_7", damageDetailspullBox7);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 7);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxEightData != null) {

                    damageDetailspullBox8.put("damageDetails", pullBoxEightData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox8.put("images", images);

                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_8", damageDetailspullBox8);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 8);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    //poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxNineData != null) {

                    damageDetailspullBox9.put("damageDetails", pullBoxNineData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox9.put("images", images);
                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_9", damageDetailspullBox9);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 9);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (pullBoxTenData != null) {

                    damageDetailspullBox10.put("damageDetails", pullBoxTenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadUnderGroundData.getInstance().pullBoxTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailspullBox10.put("images", images);

                    }

                    pullBoxPartName.put("partName", pullBoxTitle);
                    pullBoxPartName.put("damageData", pullBox_1);
                    pullBox_1.put("PULL_BOX_10", damageDetailspullBox10);
                    padmounts.put("PULL_BOX", pullBoxPartName);
                    pullBoxPartName.put("partDisplayName", pullBoxTitle_name);
                    pullBoxPartName.put("numberOfParts", 10);
                    pullBoxDamagePart.put("damagedParts", padmounts);
                    // poleTopEquipment.put("Underground", pullBoxDamagePart);
                    count++;
                }
                if (count > 0) {
                    pullBoxDamagePart.put("scopename", "Underground");
                    pullBoxDamagePart.put("scopeDisplayName", "Underground");
                    poleScope.put("Underground", pullBoxDamagePart);

                }
            } catch (Exception e) {

            }
            try{
                count = 0;

            String spiceBoxTitle_name = "Splice Box";
             String   spiceBoxTitle = "SPLICE_BOX";
             String pictureName;
          /*  if (spiceBoxTitle != null)
                spiceBoxTitle = spiceBoxTitle.replaceAll("\\s", "_").toUpperCase();*/
            if (spiceBoxOneData != null) {
                damageDetailsspiceBox1.put("damageDetails", spiceBoxOneData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox1.put("images", images);
                }

                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_1", damageDetailsspiceBox1);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 1);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxTwoData != null) {
                damageDetailsspiceBox2.put("damageDetails", spiceBoxTwoData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxTwoPicturePath;

                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsspiceBox2.put("images", images);
                }

                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_2", damageDetailsspiceBox2);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 2);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxThreeData != null) {
                damageDetailsspiceBox3.put("damageDetails", spiceBoxThreeData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();

                pictureName = null;

                pictureName = ReadUnderGroundData.getInstance().spiceBoxThreePicturePath;

                if (pictureName != null && !pictureName.isEmpty()) {

                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                    images.put(imagesObject);
                    damageDetailsspiceBox3.put("images", images);

                }

                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_3", damageDetailsspiceBox3);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 3);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxFourData != null) {
                damageDetailsspiceBox4.put("damageDetails", spiceBoxFourData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox4.put("images", images);
                }
                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_4", damageDetailsspiceBox4);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 4);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxFiveData != null) {
                damageDetailsspiceBox5.put("damageDetails", spiceBoxFiveData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox5.put("images", images);
                }
                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_5", damageDetailsspiceBox5);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 5);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                //    poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxSixData != null) {
                damageDetailsspiceBox6.put("damageDetails", spiceBoxSixData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox6.put("images", images);
                }
                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_6", damageDetailsspiceBox6);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 6);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxSevenData != null) {
                damageDetailsspiceBox7.put("damageDetails", spiceBoxSevenData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox7.put("images", images);
                }
                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_7", damageDetailsspiceBox7);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 7);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxEightData != null) {
                damageDetailsspiceBox8.put("damageDetails", spiceBoxEightData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox8.put("images", images);
                }
                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_8", damageDetailsspiceBox8);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 8);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                count++;
            }
            if (spiceBoxNineData != null) {
                damageDetailsspiceBox9.put("damageDetails", spiceBoxNineData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox9.put("images", images);
                }
                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_9", damageDetailsspiceBox9);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 9);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if (spiceBoxTenData != null) {
                damageDetailsspiceBox10.put("damageDetails", spiceBoxTenData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().spiceBoxTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailsspiceBox10.put("images", images);
                }
                spiceBoxPartName.put("partName", spiceBoxTitle);
                spiceBoxPartName.put("damageData", spiceBox_1);
                spiceBox_1.put("SPLICE_BOX_10", damageDetailsspiceBox10);
                padmounts.put("SPLICE_BOX", spiceBoxPartName);
                spiceBoxPartName.put("partDisplayName", spiceBoxTitle_name);
                spiceBoxPartName.put("numberOfParts", 10);
                spiceBoxDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", spiceBoxDamagePart);
                count++;
            }
            if(count > 0){
                spiceBoxDamagePart.put("scopename", "Underground");
                spiceBoxDamagePart.put("scopeDisplayName", "Underground");
                poleScope.put("Underground", spiceBoxDamagePart);

            }} catch (Exception e) {
            }
            try{
            count = 0;
            String sectionalizerCabinetTitle_name = "Sectionalizer Cabinet";
            String sectionalizerCabinetTitle = "SECTIONALIZER_CABINET";
            String pictureName;
           /* if (sectionalizerCabinetTitle != null)
                sectionalizerCabinetTitle = sectionalizerCabinetTitle.replaceAll("\\s", "_").toUpperCase();*/
            if (sectionalizerCabinetOneData != null) {
                damageDetailssectionalizerCabinet1.put("damageDetails", sectionalizerCabinetOneData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetOnePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet1.put("images", images);

                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_1", damageDetailssectionalizerCabinet1);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 1);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetTwoData != null) {
                damageDetailssectionalizerCabinet2.put("damageDetails", sectionalizerCabinetTwoData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetTwoPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet2.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_2", damageDetailssectionalizerCabinet2);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 2);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                //poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetThreeData != null) {
                damageDetailssectionalizerCabinet3.put("damageDetails", sectionalizerCabinetThreeData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetThreePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet3.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_3", damageDetailssectionalizerCabinet3);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 3);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetFourData != null) {
                damageDetailssectionalizerCabinet4.put("damageDetails", sectionalizerCabinetFourData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetFourPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet4.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_4", damageDetailssectionalizerCabinet4);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 4);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetFiveData != null) {
                damageDetailssectionalizerCabinet5.put("damageDetails", sectionalizerCabinetFiveData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetFivePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet5.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_5", damageDetailssectionalizerCabinet5);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 5);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetSixData != null) {
                damageDetailssectionalizerCabinet6.put("damageDetails", sectionalizerCabinetSixData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetSixPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet6.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_6", damageDetailssectionalizerCabinet6);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 6);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetSevenData != null) {
                damageDetailssectionalizerCabinet7.put("damageDetails", sectionalizerCabinetSevenData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetSevenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet7.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_7", damageDetailssectionalizerCabinet7);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 7);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                // poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetEightData != null) {
                damageDetailssectionalizerCabinet8.put("damageDetails", sectionalizerCabinetEightData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetEightPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet8.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_8", damageDetailssectionalizerCabinet8);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 8);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetNineData != null) {
                damageDetailssectionalizerCabinet9.put("damageDetails", sectionalizerCabinetNineData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetNinePicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet9.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_9", damageDetailssectionalizerCabinet9);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 9);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                //   poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if (sectionalizerCabinetTenData != null) {
                damageDetailssectionalizerCabinet10.put("damageDetails", sectionalizerCabinetTenData);
                JSONObject imagesObject = new JSONObject();
                JSONArray images = new JSONArray();
                JSONObject testImagesObject = new JSONObject();
                JSONArray testImages = new JSONArray();
                pictureName = null;
                pictureName = ReadUnderGroundData.getInstance().sectionalizerCabinetTenPicturePath;
                if (pictureName != null && !pictureName.isEmpty()) {
                    pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                    String thumbnail = truncateAndAddThumbnailString(pictureName);
                    imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                    imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                    images.put(imagesObject);
                    damageDetailssectionalizerCabinet10.put("images", images);
                }
                sectionalizerCabinetPartName.put("partName", sectionalizerCabinetTitle);
                sectionalizerCabinetPartName.put("damageData", sectionalizerCabinet_1);
                sectionalizerCabinet_1.put("SECTIONALIZER_CABINET_10", damageDetailssectionalizerCabinet10);
                padmounts.put("SECTIONALIZER_CABINET", sectionalizerCabinetPartName);
                sectionalizerCabinetPartName.put("partDisplayName", sectionalizerCabinetTitle_name);
                sectionalizerCabinetPartName.put("numberOfParts", 10);
                sectionalizerCabinetDamagePart.put("damagedParts", padmounts);
                //  poleTopEquipment.put("Underground", sectionalizerCabinetDamagePart);
                count++;
            }
            if(count > 0){
                sectionalizerCabinetDamagePart.put("scopename", "Underground");
                sectionalizerCabinetDamagePart.put("scopeDisplayName", "Underground");
                poleScope.put("Underground", sectionalizerCabinetDamagePart);

            }} catch (Exception e) {

            }

        }
    }
    private void LoadWireScopeSelectedData() {
        int count = 0;
        JSONObject primaryWire = new JSONObject();
        JSONObject primaryWire_1 = new JSONObject();
        JSONObject primaryWireDamagePart = new JSONObject();
        JSONObject primaryWirePartName = new JSONObject();
        JSONObject damageDetailsprimaryWire1 = new JSONObject();
        JSONObject damageDetailsprimaryWire2 = new JSONObject();
        JSONObject damageDetailsprimaryWire3 = new JSONObject();
        JSONObject damageDetailsprimaryWire4 = new JSONObject();
        JSONObject damageDetailsprimaryWire5 = new JSONObject();
        JSONObject damageDetailsprimaryWire6 = new JSONObject();
        JSONObject damageDetailsprimaryWire7 = new JSONObject();
        JSONObject damageDetailsprimaryWire8 = new JSONObject();
        JSONObject damageDetailsprimaryWire9 = new JSONObject();
        JSONObject damageDetailsprimaryWire10 = new JSONObject();

        JSONObject secondaryWire_1 = new JSONObject();
        JSONObject secondaryWireDamagePart = new JSONObject();
        JSONObject secondaryWirePartName = new JSONObject();
        JSONObject damageDetailssecondaryWire1 = new JSONObject();
        JSONObject damageDetailssecondaryWire2 = new JSONObject();
        JSONObject damageDetailssecondaryWire3 = new JSONObject();
        JSONObject damageDetailssecondaryWire4 = new JSONObject();
        JSONObject damageDetailssecondaryWire5 = new JSONObject();
        JSONObject damageDetailssecondaryWire6 = new JSONObject();
        JSONObject damageDetailssecondaryWire7 = new JSONObject();
        JSONObject damageDetailssecondaryWire8 = new JSONObject();
        JSONObject damageDetailssecondaryWire9 = new JSONObject();
        JSONObject damageDetailssecondaryWire10 = new JSONObject();

        JSONObject serviceWire_1 = new JSONObject();
        JSONObject serviceWireDamagePart = new JSONObject();
        JSONObject serviceWirePartName = new JSONObject();
        JSONObject damageDetailsserviceWire1 = new JSONObject();
        JSONObject damageDetailsserviceWire2 = new JSONObject();
        JSONObject damageDetailsserviceWire3 = new JSONObject();
        JSONObject damageDetailsserviceWire4 = new JSONObject();
        JSONObject damageDetailsserviceWire5 = new JSONObject();
        JSONObject damageDetailsserviceWire6 = new JSONObject();
        JSONObject damageDetailsserviceWire7 = new JSONObject();
        JSONObject damageDetailsserviceWire8 = new JSONObject();
        JSONObject damageDetailsserviceWire9 = new JSONObject();
        JSONObject damageDetailsserviceWire10 = new JSONObject();


        JSONObject primaryWireOneData = ReadWireData.getInstance().readprimary_wireOneData();
        JSONObject primaryWireTwoData = ReadWireData.getInstance().readprimary_wireTwoData();
        JSONObject primaryWireThreeData = ReadWireData.getInstance().readprimary_wireThreeData();
        JSONObject primaryWireFourData = ReadWireData.getInstance().readprimary_wireFourData();
        JSONObject primaryWireFiveData = ReadWireData.getInstance().readprimary_wireFiveData();
        JSONObject primaryWireSixData = ReadWireData.getInstance().readprimary_wireSixData();
        JSONObject primaryWireEightData = ReadWireData.getInstance().readprimary_wireSevenData();
        JSONObject primaryWireSevenData = ReadWireData.getInstance().readprimary_wireEightData();
        JSONObject primaryWireNineData = ReadWireData.getInstance().readprimary_wireNineData();
        JSONObject primaryWireTenData = ReadWireData.getInstance().readprimary_wireTenData();

        JSONObject secondaryWireOneData = ReadWireData.getInstance().readsecondary_wireOneData();
        JSONObject secondaryWireTwoData = ReadWireData.getInstance().readsecondary_wireTwoData();
        JSONObject secondaryWireThreeData = ReadWireData.getInstance().readsecondary_wireThreeData();
        JSONObject secondaryWireFourData = ReadWireData.getInstance().readsecondary_wireFourData();
        JSONObject secondaryWireFiveData = ReadWireData.getInstance().readsecondary_wireFiveData();
        JSONObject secondaryWireSixData = ReadWireData.getInstance().readsecondary_wireSixData();
        JSONObject secondaryWireEightData = ReadWireData.getInstance().readsecondary_wireSevenData();
        JSONObject secondaryWireSevenData = ReadWireData.getInstance().readsecondary_wireEightData();
        JSONObject secondaryWireNineData = ReadWireData.getInstance().readsecondary_wireNineData();
        JSONObject secondaryWireTenData = ReadWireData.getInstance().readsecondary_wireTenData();

        JSONObject serviceWireOneData = ReadWireData.getInstance().readservice_wireOneData();
        JSONObject serviceWireTwoData = ReadWireData.getInstance().readservice_wireTwoData();
        JSONObject serviceWireThreeData = ReadWireData.getInstance().readservice_wireThreeData();
        JSONObject serviceWireFourData = ReadWireData.getInstance().readservice_wireFourData();
        JSONObject serviceWireFiveData = ReadWireData.getInstance().readservice_wireFiveData();
        JSONObject serviceWireSixData = ReadWireData.getInstance().readservice_wireSixData();
        JSONObject serviceWireEightData = ReadWireData.getInstance().readservice_wireSevenData();
        JSONObject serviceWireSevenData = ReadWireData.getInstance().readservice_wireEightData();
        JSONObject serviceWireNineData = ReadWireData.getInstance().readservice_wireNineData();
        JSONObject serviceWireTenData = ReadWireData.getInstance().readservice_wireTenData();

        {
            try {


                count = 0;
                String primaryWireTitle_name = "Primary";
                String primaryWireTitle = "PRIMARY";
                /*if (regulatorTitle != null)
                    regulatorTitle = regulatorTitle.replaceAll("\\s", "_").toUpperCase();*/
                if (primaryWireOneData != null) {

                    damageDetailsprimaryWire1.put("damageDetails", primaryWireOneData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireOnePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire1.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_1", damageDetailsprimaryWire1);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 1);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireTwoData != null) {

                    damageDetailsprimaryWire2.put("damageDetails", primaryWireTwoData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire2.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_2", damageDetailsprimaryWire2);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 2);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireThreeData != null) {

                    damageDetailsprimaryWire3.put("damageDetails", primaryWireThreeData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireThreePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire3.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_3", damageDetailsprimaryWire3);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 3);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireFourData != null) {

                    damageDetailsprimaryWire4.put("damageDetails", primaryWireFourData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire4.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_4", damageDetailsprimaryWire4);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 4);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireFiveData != null) {

                    damageDetailsprimaryWire5.put("damageDetails", primaryWireFiveData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire5.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_5", damageDetailsprimaryWire5);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 5);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireSixData != null) {

                    damageDetailsprimaryWire6.put("damageDetails", primaryWireSixData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire6.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_6", damageDetailsprimaryWire6);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 6);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireSevenData != null) {

                    damageDetailsprimaryWire7.put("damageDetails", primaryWireSevenData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire7.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_7", damageDetailsprimaryWire7);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 7);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireEightData != null) {

                    damageDetailsprimaryWire8.put("damageDetails", primaryWireEightData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire8.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_8", damageDetailsprimaryWire8);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 8);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireNineData != null) {

                    damageDetailsprimaryWire9.put("damageDetails", primaryWireNineData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire9.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_9", damageDetailsprimaryWire9);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 9);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (primaryWireTenData != null) {

                    damageDetailsprimaryWire10.put("damageDetails", primaryWireTenData);

                    JSONArray images = new JSONArray();
                    JSONObject imagesObject = new JSONObject();

                    String pictureName = null;
                    pictureName = ReadWireData.getInstance().primary_wireTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsprimaryWire10.put("images", images);
                    }
                    primaryWirePartName.put("partName", primaryWireTitle);
                    primaryWirePartName.put("damageData", primaryWire_1);
                    primaryWire_1.put("PRIMARY_10", damageDetailsprimaryWire10);
                    primaryWire.put("PRIMARY", primaryWirePartName);
                    primaryWirePartName.put("partDisplayName", primaryWireTitle_name);
                    primaryWirePartName.put("numberOfParts", 10);
                    primaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if (count > 0) {
                    primaryWireDamagePart.put("scopename", "Wire");
                    primaryWireDamagePart.put("scopeDisplayName", "Wire");
                    poleScope.put("Wire", primaryWireDamagePart);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                count = 0;
                String secondaryWireTitle_name = "Secondary";
                String secondaryWireTitle = "SECONDARY";
                String pictureName;
            /*if (secondaryWireTitle != null)
                secondaryWireTitle = secondaryWireTitle.replaceAll("\\s", "_").toUpperCase();*/
                if (secondaryWireOneData != null) {

                    damageDetailssecondaryWire1.put("damageDetails", secondaryWireOneData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;

                    pictureName = ReadWireData.getInstance().secondary_wireOnePicturePath;

                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire1.put("images", images);
                    }


                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_1", damageDetailssecondaryWire1);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 1);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireTwoData != null) {

                    damageDetailssecondaryWire2.put("damageDetails", secondaryWireTwoData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        testImages.put(testImagesObject);
                        damageDetailssecondaryWire2.put("images", images);
                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_2", damageDetailssecondaryWire2);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 2);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireThreeData != null) {

                    damageDetailssecondaryWire3.put("damageDetails", secondaryWireThreeData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireThreePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire3.put("images", images);
                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_3", damageDetailssecondaryWire3);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 3);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireFourData != null) {

                    damageDetailssecondaryWire4.put("damageDetails", secondaryWireFourData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireTwoPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire4.put("images", images);
                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_4", damageDetailssecondaryWire4);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 4);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireFiveData != null) {

                    damageDetailssecondaryWire5.put("damageDetails", secondaryWireFiveData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire5.put("images", images);

                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_5", damageDetailssecondaryWire5);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 5);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireSixData != null) {

                    damageDetailssecondaryWire6.put("damageDetails", secondaryWireSixData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire6.put("images", images);

                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_6", damageDetailssecondaryWire6);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 6);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireSevenData != null) {

                    damageDetailssecondaryWire7.put("damageDetails", secondaryWireSevenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire7.put("images", images);

                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_7", damageDetailssecondaryWire7);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 7);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireEightData != null) {

                    damageDetailssecondaryWire8.put("damageDetails", secondaryWireEightData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire8.put("images", images);

                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_8", damageDetailssecondaryWire8);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 8);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    //poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireNineData != null) {

                    damageDetailssecondaryWire9.put("damageDetails", secondaryWireNineData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire9.put("images", images);
                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_9", damageDetailssecondaryWire9);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 9);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (secondaryWireTenData != null) {

                    damageDetailssecondaryWire10.put("damageDetails", secondaryWireTenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;
                    pictureName = ReadWireData.getInstance().secondary_wireTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);

                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://" + sharedPref.getString("s3Bucket", "") + "-thumbnails" + S3_URL + sharedPref.getString("accountKey", "") + "/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://" + sharedPref.getString("s3Bucket", "") + S3_URL + sharedPref.getString("accountKey", "") + "/" + pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailssecondaryWire10.put("images", images);

                    }

                    secondaryWirePartName.put("partName", secondaryWireTitle);
                    secondaryWirePartName.put("damageData", secondaryWire_1);
                    secondaryWire_1.put("SECONDARY_10", damageDetailssecondaryWire10);
                    primaryWire.put("SECONDARY", secondaryWirePartName);
                    secondaryWirePartName.put("partDisplayName", secondaryWireTitle_name);
                    secondaryWirePartName.put("numberOfParts", 10);
                    secondaryWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", secondaryWireDamagePart);
                    count++;
                }
                if (count > 0) {
                    secondaryWireDamagePart.put("scopename", "Wire");
                    secondaryWireDamagePart.put("scopeDisplayName", "Wire");
                    poleScope.put("Wire", secondaryWireDamagePart);

                }
            } catch (Exception e) {

            }
            try{
                count = 0;

                String serviceWireTitle_name = "Service Wire";
                String   serviceWireTitle = "SERVICE";
                String pictureName;
          /*  if (serviceWireTitle != null)
                serviceWireTitle = serviceWireTitle.replaceAll("\\s", "_").toUpperCase();*/
                if (serviceWireOneData != null) {
                    damageDetailsserviceWire1.put("damageDetails", serviceWireOneData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireOnePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire1.put("images", images);
                    }

                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_1", damageDetailsserviceWire1);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 1);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireTwoData != null) {
                    damageDetailsserviceWire2.put("damageDetails", serviceWireTwoData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireTwoPicturePath;

                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsserviceWire2.put("images", images);
                    }

                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_2", damageDetailsserviceWire2);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 2);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireThreeData != null) {
                    damageDetailsserviceWire3.put("damageDetails", serviceWireThreeData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();

                    pictureName = null;

                    pictureName = ReadWireData.getInstance().service_wireThreePicturePath;

                    if (pictureName != null && !pictureName.isEmpty()) {

                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png

                        images.put(imagesObject);
                        damageDetailsserviceWire3.put("images", images);

                    }

                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_3", damageDetailsserviceWire3);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 3);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireFourData != null) {
                    damageDetailsserviceWire4.put("damageDetails", serviceWireFourData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireFourPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire4.put("images", images);
                    }
                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_4", damageDetailsserviceWire4);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 4);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireFiveData != null) {
                    damageDetailsserviceWire5.put("damageDetails", serviceWireFiveData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireFivePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire5.put("images", images);
                    }
                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_5", damageDetailsserviceWire5);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 5);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    //    poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireSixData != null) {
                    damageDetailsserviceWire6.put("damageDetails", serviceWireSixData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireSixPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire6.put("images", images);
                    }
                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_6", damageDetailsserviceWire6);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 6);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireSevenData != null) {
                    damageDetailsserviceWire7.put("damageDetails", serviceWireSevenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireSevenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire7.put("images", images);
                    }
                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_7", damageDetailsserviceWire7);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 7);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    //  poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireEightData != null) {
                    damageDetailsserviceWire8.put("damageDetails", serviceWireEightData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireEightPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire8.put("images", images);
                    }
                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_8", damageDetailsserviceWire8);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 8);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    count++;
                }
                if (serviceWireNineData != null) {
                    damageDetailsserviceWire9.put("damageDetails", serviceWireNineData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireNinePicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire9.put("images", images);
                    }
                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_9", damageDetailsserviceWire9);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 9);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if (serviceWireTenData != null) {
                    damageDetailsserviceWire10.put("damageDetails", serviceWireTenData);
                    JSONObject imagesObject = new JSONObject();
                    JSONArray images = new JSONArray();
                    JSONObject testImagesObject = new JSONObject();
                    JSONArray testImages = new JSONArray();
                    pictureName = null;
                    pictureName = ReadWireData.getInstance().service_wireTenPicturePath;
                    if (pictureName != null && !pictureName.isEmpty()) {
                        pictureName = pictureName.substring(pictureName.lastIndexOf("/") + 1);
                        String thumbnail = truncateAndAddThumbnailString(pictureName);
                        imagesObject.put("thumbnail", "https://"+sharedPref.getString("s3Bucket","")+"-thumbnails"+S3_URL+sharedPref.getString("accountKey","")+"/" + thumbnail);//9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1-thumbnail.png"
                        imagesObject.put("original", "https://"+sharedPref.getString("s3Bucket","")+S3_URL+sharedPref.getString("accountKey","")+"/"+ pictureName); //9900075770_20171120121232-PoleTopEquipment-DETAIL-TRANSFORMER-1.png
                        images.put(imagesObject);
                        damageDetailsserviceWire10.put("images", images);
                    }
                    serviceWirePartName.put("partName", serviceWireTitle);
                    serviceWirePartName.put("damageData", serviceWire_1);
                    serviceWire_1.put("SERVICE_10", damageDetailsserviceWire10);
                    primaryWire.put("SERVICE", serviceWirePartName);
                    serviceWirePartName.put("partDisplayName", serviceWireTitle_name);
                    serviceWirePartName.put("numberOfParts", 10);
                    serviceWireDamagePart.put("damagedParts", primaryWire);
                    // poleTopEquipment.put("Underground", serviceWireDamagePart);
                    count++;
                }
                if(count > 0){
                    serviceWireDamagePart.put("scopename", "Wire");
                    serviceWireDamagePart.put("scopeDisplayName", "Wire");
                    poleScope.put("Wire", serviceWireDamagePart);

                }} catch (Exception e) {
            }


        }
    }



    private String truncateAndAddThumbnailString(String thumbnail) {
        if (thumbnail != null) {
            thumbnail = thumbnail.substring(0, thumbnail.length() - 4);
            thumbnail = thumbnail + "-thumbnail.png";
            return thumbnail;
        } else {
            return "";
        }
    }
    class Simple<T> extends ArrayAdapter{
        Typeface mTypeface;
        public Simple(@NonNull Context context, @LayoutRes int resource) {
            super(context, resource);
        }

        public Simple(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
            super(context, resource, objects);
            mTypeface = Typeface.createFromAsset(context.getAssets(), "AvenirLTStd-Book.otf");

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            TextView textview = (TextView) view;
            textview.setTextSize(14);
            textview.setTypeface(mTypeface);
            return textview;
        }
    }
}
