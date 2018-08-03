package vda.irestore.com.vda_android;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.Global.GlobalData;
import vda.irestore.com.vda_android.Global.Utils;
import vda.irestore.com.vda_android.readData.ReadPoleEquipmentData;
import vda.irestore.com.vda_android.readData.ReadPoleTopEquipmentData;
import vda.irestore.com.vda_android.readData.ReadSplEquipmentData;
import vda.irestore.com.vda_android.readData.ReadTreeData;
import vda.irestore.com.vda_android.readData.ReadUnderGroundData;
import vda.irestore.com.vda_android.readData.ReadWireData;

import static vda.irestore.com.vda_android.Global.GlobalData.selectedFeederLine1;
import static vda.irestore.com.vda_android.Global.GlobalData.selectedFeederLine2;
import static vda.irestore.com.vda_android.Global.GlobalData.selectedPoleHeight;
import static vda.irestore.com.vda_android.Global.GlobalData.selectedPoleNumber;

public class MainActivity extends Activity {
    ImageView wire, poleTop, splEquipment, pole, tree, other;
    Button nextButton;
    Toolbar toolBar;
    int changeOf_imageWire = 0;
    int changeOf_imagePole = 0;
    int changeOf_imagePoleTop = 0;
    int changeOf_imageTree = 0;
    int changeOf_imageSplEquipment = 0;
    int ChangeOf_imageOther = 0;
    Typeface typeface;
    BottomSheetDialog dialog;
    ImageView photo;
    View mView;
    public static boolean panoImageTaken =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeface = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");
        //   getStatusBarHeight();
        setActionBar();
        selectedFeederLine1 = null;
        selectedFeederLine2 = null;
        selectedPoleHeight = null;
        selectedPoleNumber = null;
        panoImageTaken =false;
        Utils.assetImage =null;
        Utils.panoBitmap1 =null;
        GlobalData.initializeSharedPrefernceData(this);
        GlobalData.scopesPreferencesEditor.clear().apply();
        GlobalData.metadataPreferencesEditor.clear().apply();
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

        wire = (ImageView) findViewById(R.id.wire);
        poleTop = (ImageView) findViewById(R.id.poleTop);
        splEquipment = (ImageView) findViewById(R.id.splEquipment);
        pole = (ImageView) findViewById(R.id.pole);
        tree = (ImageView) findViewById(R.id.tree);
        other = (ImageView) findViewById(R.id.other);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setTypeface(typeface);
        nextButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
        nextButton.setClickable(false);
        nextButton.setEnabled(false);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

                dialog = new BottomSheetDialog(MainActivity.this);
                mView = getLayoutInflater().inflate(R.layout.simulator, null);
                Spinner spinner = mView.findViewById(R.id.spinner);
                photo = mView.findViewById(R.id.camera);
                final EditText pole_number = mView.findViewById(R.id.pole_number);
                final EditText feeder_line1 = mView.findViewById(R.id.feeder_line1);
                final EditText feeder_line2 = mView.findViewById(R.id.feeder_line2);

                feeder_line1.setTypeface(typeface);
                feeder_line2.setTypeface(typeface);
                pole_number.setTypeface(typeface);


                final Switch panorama_switch = mView.findViewById(R.id.panorama_switch);

                photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (panorama_switch.isChecked()) {
                            panoImageTaken = true;
                            Intent intent = new Intent(MainActivity.this, ShooterActivity.class);
                            startActivityForResult(intent,3455);
                            //startActivity(intent);

                        } else {
                            panoImageTaken = false;
                            Intent intent = new Intent(MainActivity.this, AndroidCameraApi.class);
                            startActivityForResult(intent,3455);
                            //  Toast.makeText(MainActivity.this,"normal image",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                ArrayList<String> heights = new ArrayList<String>();
                heights.add("30");
                heights.add("35");
                heights.add("40");
                heights.add("45");
                heights.add("50");
                heights.add("55");
                final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, heights);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String selectedItem = dataAdapter.getItem(position);
                        selectedPoleHeight = selectedItem;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                Button nextButton_inDialog = mView.findViewById(R.id.nextButton_inDialog);
                nextButton_inDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int value = 0;

                        selectedPoleNumber = pole_number.getText().toString();
                        selectedFeederLine1 = feeder_line1.getText().toString();
                        selectedFeederLine2 = feeder_line2.getText().toString();
                        Intent intent = new Intent(MainActivity.this, SelectedItems.class);
                        if (changeOf_imageWire == 1)
                            intent.putExtra("wireImage", R.drawable.wire_sub);
                        intent.putExtra("wireId", value);
                        if (changeOf_imagePoleTop == 1)
                            intent.putExtra("poletopImage", R.drawable.pole_sub1);
                        if (changeOf_imageSplEquipment == 1)
                            intent.putExtra("splImage", R.drawable.spl_sub);
                        if (changeOf_imagePole == 1)
                            intent.putExtra("poleImage", R.drawable.pole_sub);
                        if (changeOf_imageTree == 1)
                            intent.putExtra("treeImage", R.drawable.tree_sub);
                        if (ChangeOf_imageOther == 1)
                            intent.putExtra("otherImage", R.drawable.other_sub);
                        startActivity(intent);
                    }
                });
                dialog.setContentView(mView);

                dialog.show();

            }
        });
        readDataFromFireBase(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }

        // action bar height
        int actionBarHeight = 0;
        final TypedArray styledAttributes = getApplicationContext().getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize}
        );
        actionBarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        int applicationRunningAreaHeight = height - actionBarHeight;
        int imageviewHeight = (applicationRunningAreaHeight) / 7;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, imageviewHeight);

        wire.setLayoutParams(parms);
        poleTop.setLayoutParams(parms);
        splEquipment.setLayoutParams(parms);
        pole.setLayoutParams(parms);
        tree.setLayoutParams(parms);
        other.setLayoutParams(parms);
        // nextButton.setLayoutParams(parms);

        wire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imageWire == 0) {
                    wire.setImageResource(R.drawable.wire_complete);
                    changeOf_imageWire = 1;
                    EnableNextButton();
                } else if (changeOf_imageWire == 1) {
                    wire.setImageResource(R.drawable.wire);
                    changeOf_imageWire = 0;
                    EnableNextButton();
                }

            }
        });

        poleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imagePoleTop == 0) {
                    poleTop.setImageResource(R.drawable.pole_top_complete_1);
                    changeOf_imagePoleTop = 1;
                    EnableNextButton();
                } else if (changeOf_imagePoleTop == 1) {
                    poleTop.setImageResource(R.drawable.pole_top);
                    changeOf_imagePoleTop = 0;
                    EnableNextButton();
                }
            }
        });
        splEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imageSplEquipment == 0) {
                    splEquipment.setImageResource(R.drawable.pole_equip_complete);
                    changeOf_imageSplEquipment = 1;
                    EnableNextButton();
                } else if (changeOf_imageSplEquipment == 1) {
                    splEquipment.setImageResource(R.drawable.pole_equip);
                    changeOf_imageSplEquipment = 0;
                    EnableNextButton();
                }
            }
        });
        pole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imagePole == 0) {
                    pole.setImageResource(R.drawable.pole_complete);
                    changeOf_imagePole = 1;
                    EnableNextButton();
                } else if (changeOf_imagePole == 1) {
                    pole.setImageResource(R.drawable.pole);
                    changeOf_imagePole = 0;
                    EnableNextButton();
                }
            }
        });
        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imageTree == 0) {
                    tree.setImageResource(R.drawable.tree_complete);
                    changeOf_imageTree = 1;
                    EnableNextButton();
                } else if (changeOf_imageTree == 1) {
                    tree.setImageResource(R.drawable.tree);
                    changeOf_imageTree = 0;
                    EnableNextButton();
                }
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ChangeOf_imageOther == 0) {
                    other.setImageResource(R.drawable.other_complete);
                    ChangeOf_imageOther = 1;
                    EnableNextButton();
                } else if (ChangeOf_imageOther == 1) {
                    other.setImageResource(R.drawable.other);
                    ChangeOf_imageOther = 0;
                    EnableNextButton();

                }
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
        title.setText("VDA");
        title.setTypeface(typeface);
        Button nextBtn = (Button) v.findViewById(R.id.nextBtn);
        nextBtn.setTextColor(Color.parseColor("#00A699"));
        nextBtn.setText("Submit");
        nextBtn.setVisibility(View.INVISIBLE);
        nextBtn.setTypeface(typeface);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(v);
    }

    private void EnableNextButton() {
        if (ChangeOf_imageOther == 1 || changeOf_imageWire == 1 || changeOf_imagePole == 1 || changeOf_imagePoleTop == 1
                || changeOf_imageSplEquipment == 1 || changeOf_imageTree == 1) {
            nextButton.setBackgroundColor(Color.parseColor("#00A699"));
            nextButton.setClickable(true);
            nextButton.setEnabled(true);
        } else {
            nextButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
            nextButton.setClickable(false);
            nextButton.setEnabled(false);
        }
    }

    private int getStatusBarHeight() {
        int height;
        Resources myResources = getResources();
        int idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = getResources().getDimensionPixelSize(idStatusBarHeight);
        } else {
            height = 0;
            Toast.makeText(this,
                    "Resources NOT found",
                    Toast.LENGTH_LONG).show();
        }

        return height;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onRestart() {
        super.onRestart();
        GlobalData.metadataPreferencesEditor.clear().apply();
        GlobalData.metadataPreferencesEditor.clear().apply();
        selectedFeederLine1 = null;
        selectedFeederLine2 = null;
        selectedPoleHeight = null;
        selectedPoleNumber = null;

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

        nextButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
        nextButton.setClickable(false);
        nextButton.setEnabled(false);
        wire.setImageResource(R.drawable.wire);
        poleTop.setImageResource(R.drawable.pole_top);
        splEquipment.setImageResource(R.drawable.pole_equip);
        pole.setImageResource(R.drawable.pole);
        tree.setImageResource(R.drawable.tree);
        other.setImageResource(R.drawable.other);
        readDataFromFireBase(this);
    }

    public void readDataFromFireBase(Context context) {
        // GlobalData.initializeSharedPrefernceData(context);
        FirebaseDatabase database = FirebaseDatabase.getInstance(Global.FIREBASE_URL);
        DatabaseReference firebaseUserDataReference = database.getReference("Scopes");

        firebaseUserDataReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Gson gson = new Gson();
                String othersJSON = gson.toJson(dataSnapshot.child("Others").child("parts").getValue());
                String poleTopJSON = gson.toJson(dataSnapshot.child("PoleTopEquipment").child("parts").getValue());
                String poleJSON = gson.toJson(dataSnapshot.child("Pole").child("parts").getValue());
                String wireeJSON = gson.toJson(dataSnapshot.child("Wire").child("parts").getValue());
                String treeJSON = gson.toJson(dataSnapshot.child("Tree").child("parts").getValue());
                String splJSON = gson.toJson(dataSnapshot.child("SPLEquipment").child("parts").getValue());

                try {

                    JSONObject otherObject = new JSONObject(othersJSON);
                    Iterator othersX = otherObject.keys();
                    JSONArray jsonArray = new JSONArray();

                    while (othersX.hasNext()) {
                        String key = (String) othersX.next();
                        jsonArray.put(otherObject.get(key));
                    }

                    JSONArray sortedOthersJsonArray = new JSONArray();
                    List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        otherJsonList.add(jsonArray.getJSONObject(i));
                    }

                    Collections.sort(otherJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA = 0;
                            Integer valB = 0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            } catch (JSONException e) {
                                //do something
                            }

                            return valA.compareTo(valB);
                        }
                    });

                    for (int i = 0; i < jsonArray.length(); i++) {
                        sortedOthersJsonArray.put(otherJsonList.get(i));

                    }

                    /// poletop

                    //JSONObject poleTopObject= null;

                    JSONObject poleTopObject = new JSONObject(poleTopJSON);
                    Iterator poleTopX = poleTopObject.keys();
                    JSONArray poleTopJsonArray = new JSONArray();

                    while (poleTopX.hasNext()) {
                        String key = (String) poleTopX.next();
                        poleTopJsonArray.put(poleTopObject.get(key));
                    }

                    JSONArray sortedPOleTopJsonArray = new JSONArray();
                    List<JSONObject> poleTopJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < poleTopJsonArray.length(); i++) {
                        poleTopJsonList.add(poleTopJsonArray.getJSONObject(i));
                    }

                    Collections.sort(poleTopJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA = 0;
                            Integer valB = 0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            } catch (JSONException e) {
                                //do something
                            }

                            return valA.compareTo(valB);
                        }
                    });

                    for (int i = 0; i < poleTopJsonArray.length(); i++) {
                        sortedPOleTopJsonArray.put(poleTopJsonList.get(i));

                    }


                    /// pole


                    // JSONObject poleObject= null;

                    JSONObject poleObject = new JSONObject(poleJSON);
                    Iterator poleX = poleObject.keys();
                    JSONArray poleJsonArray = new JSONArray();

                    while (poleX.hasNext()) {
                        String key = (String) poleX.next();
                        poleJsonArray.put(poleObject.get(key));
                    }

                    JSONArray sortedPOleJsonArray = new JSONArray();
                    List<JSONObject> poleJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < poleJsonArray.length(); i++) {
                        poleJsonList.add(poleJsonArray.getJSONObject(i));
                    }

                    Collections.sort(poleJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA = 0;
                            Integer valB = 0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            } catch (JSONException e) {
                                //do something
                            }

                            return valA.compareTo(valB);
                        }
                    });

                    for (int i = 0; i < poleJsonArray.length(); i++) {
                        sortedPOleJsonArray.put(poleJsonList.get(i));

                    }


                    /// poletop

                    // JSONObject undergroundObject= null;

                    JSONObject wireeObject = new JSONObject(wireeJSON);
                    Iterator wireeX = wireeObject.keys();
                    JSONArray wireeJsonArray = new JSONArray();

                    while (wireeX.hasNext()) {
                        String key = (String) wireeX.next();
                        wireeJsonArray.put(wireeObject.get(key));
                    }

                    JSONArray sortedwireeJsonArray = new JSONArray();
                    List<JSONObject> wireeJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < wireeJsonArray.length(); i++) {
                        wireeJsonList.add(wireeJsonArray.getJSONObject(i));
                    }

                    Collections.sort(wireeJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA = 0;
                            Integer valB = 0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            } catch (JSONException e) {
                                //do something
                            }

                            return valA.compareTo(valB);
                        }
                    });

                    for (int i = 0; i < wireeJsonArray.length(); i++) {
                        sortedwireeJsonArray.put(wireeJsonList.get(i));

                    }


                    JSONObject splObject = new JSONObject(splJSON);
                    Iterator splX = splObject.keys();
                    JSONArray splJsonArray = new JSONArray();

                    while (splX.hasNext()) {
                        String key = (String) splX.next();
                        splJsonArray.put(splObject.get(key));
                    }

                    JSONArray sortedsplJsonArray = new JSONArray();
                    List<JSONObject> splJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < splJsonArray.length(); i++) {
                        splJsonList.add(splJsonArray.getJSONObject(i));
                    }

                    Collections.sort(splJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA = 0;
                            Integer valB = 0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            } catch (JSONException e) {
                                //do something
                            }

                            return valA.compareTo(valB);
                        }
                    });

                    for (int i = 0; i < splJsonArray.length(); i++) {
                        sortedsplJsonArray.put(splJsonList.get(i));

                    }


                    JSONObject treeObject = new JSONObject(treeJSON);
                    Iterator treeX = treeObject.keys();
                    JSONArray treeJsonArray = new JSONArray();

                    while (treeX.hasNext()) {
                        String key = (String) treeX.next();
                        treeJsonArray.put(treeObject.get(key));
                    }

                    JSONArray sortedtreeJsonArray = new JSONArray();
                    List<JSONObject> treeJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < treeJsonArray.length(); i++) {
                        treeJsonList.add(treeJsonArray.getJSONObject(i));
                    }

                    Collections.sort(treeJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA = 0;
                            Integer valB = 0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            } catch (JSONException e) {
                                //do something
                            }

                            return valA.compareTo(valB);
                        }
                    });

                    for (int i = 0; i < treeJsonArray.length(); i++) {
                        sortedtreeJsonArray.put(treeJsonList.get(i));

                    }

                    GlobalData.scopesPreferencesEditor.putString("othersJSON", sortedOthersJsonArray.toString());
                    GlobalData.scopesPreferencesEditor.putString("poleTopJSON", sortedPOleTopJsonArray.toString());
                    GlobalData.scopesPreferencesEditor.putString("poleJSON", sortedPOleJsonArray.toString());
                    GlobalData.scopesPreferencesEditor.putString("wireeJSON", sortedwireeJsonArray.toString());
                    GlobalData.scopesPreferencesEditor.putString("splJSON", sortedsplJsonArray.toString());
                    GlobalData.scopesPreferencesEditor.putString("treeJSON", sortedtreeJsonArray.toString());

                    GlobalData.scopesPreferencesEditor.commit();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       // if (resultCode == RESULT_OK) {

        if (Utils.assetImage != null) {
            photo.setImageBitmap(Utils.assetImage);
        }
        if (Utils.panoBitmap1 != null) {
            photo.setImageBitmap(Utils.panoBitmap1);
        }

    }
}