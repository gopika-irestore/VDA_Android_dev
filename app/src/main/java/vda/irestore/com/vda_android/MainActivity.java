package vda.irestore.com.vda_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

public class MainActivity extends AppCompatActivity {
    ImageView wire,poleTop,splEquipment,pole,tree,other;
    Button nextButton;
    Toolbar toolBar;
    int changeOf_imageWire = 0;
    int changeOf_imagePole= 0;
    int changeOf_imagePoleTop = 0;
    int changeOf_imageTree = 0;
    int changeOf_imageSplEquipment = 0;
    int ChangeOf_imageOther = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getStatusBarHeight();

        wire = (ImageView)findViewById(R.id.wire);
        poleTop = (ImageView)findViewById(R.id.poleTop);
        splEquipment = (ImageView)findViewById(R.id.splEquipment);
        pole = (ImageView)findViewById(R.id.pole);
        tree = (ImageView)findViewById(R.id.tree);
        other = (ImageView)findViewById(R.id.other);
        nextButton = (Button)findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

                BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.simulator,null);
                Spinner spinner = mView.findViewById(R.id.spinner);
                ArrayList<Integer> heights = new ArrayList<Integer>();
                heights.add(35);
                heights.add(40);
                heights.add(45);
                heights.add(50);
                heights.add(55);
                ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, heights);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
                Button nextButton_inDialog = mView.findViewById(R.id.nextButton_inDialog);
                nextButton_inDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int value=0;
                        Intent intent = new Intent(MainActivity.this,SelectedItems.class);
                        if(changeOf_imageWire == 1)
                            intent.putExtra("wireImage",R.drawable.wire_sub);
                        intent.putExtra("wireId",value);
                        if(changeOf_imagePoleTop == 1)
                            intent.putExtra("poletopImage",R.drawable.pole_sub1);
                        if(changeOf_imageSplEquipment == 1)
                            intent.putExtra("splImage",R.drawable.spl_sub);
                        if(changeOf_imagePole == 1)
                            intent.putExtra("poleImage",R.drawable.pole_sub);
                        if(changeOf_imageTree == 1)
                            intent.putExtra("treeImage",R.drawable.tree_sub);
                        if(ChangeOf_imageOther == 1)
                            intent.putExtra("otherImage",R.drawable.other_sub);
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
                new int[] { android.R.attr.actionBarSize }
        );
        actionBarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        int applicationRunningAreaHeight = height-actionBarHeight;
        int imageviewHeight = (applicationRunningAreaHeight)/7;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,imageviewHeight);

        wire.setLayoutParams(parms);
        poleTop.setLayoutParams(parms);
        splEquipment.setLayoutParams(parms);
        pole.setLayoutParams(parms);
        tree.setLayoutParams(parms);
        other.setLayoutParams(parms);
        nextButton.setLayoutParams(parms);

        wire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imageWire == 0) {
                    wire.setImageResource(R.drawable.wire_complete);
                    changeOf_imageWire = 1;
                } else if (changeOf_imageWire == 1) {
                    wire.setImageResource(R.drawable.wire);
                    changeOf_imageWire = 0;
                }

            }
        });
        poleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imagePoleTop == 0) {
                    poleTop.setImageResource(R.drawable.pole_top_complete);
                    changeOf_imagePoleTop = 1;
                } else if (changeOf_imagePoleTop == 1) {
                    poleTop.setImageResource(R.drawable.pole_top);
                    changeOf_imagePoleTop = 0;
                }
            }
        });
        splEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imageSplEquipment == 0) {
                    splEquipment.setImageResource(R.drawable.pole_equip_complete);
                    changeOf_imageSplEquipment = 1;
                } else if (changeOf_imageSplEquipment == 1) {
                    splEquipment.setImageResource(R.drawable.pole_equip);
                    changeOf_imageSplEquipment = 0;
                }
            }
        });
        pole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imagePole == 0) {
                    pole.setImageResource(R.drawable.pole_complete);
                    changeOf_imagePole = 1;
                } else if (changeOf_imagePole == 1) {
                    pole.setImageResource(R.drawable.pole);
                    changeOf_imagePole = 0;
                }
            }
        });
        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeOf_imageTree == 0) {
                    tree.setImageResource(R.drawable.tree_complete);
                    changeOf_imageTree = 1;
                } else if (changeOf_imageTree == 1) {
                    tree.setImageResource(R.drawable.tree);
                    changeOf_imageTree = 0;
                }
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ChangeOf_imageOther == 0) {
                    other.setImageResource(R.drawable.other_complete);
                    ChangeOf_imageOther = 1;
                } else if (ChangeOf_imageOther == 1) {
                    other.setImageResource(R.drawable.other);
                    ChangeOf_imageOther = 0;
                }
            }
        });
    }

    private int getStatusBarHeight() {
        int height;
        Resources myResources = getResources();
        int idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = getResources().getDimensionPixelSize(idStatusBarHeight);
        }else{
            height = 0;
            Toast.makeText(this,
                    "Resources NOT found",
                    Toast.LENGTH_LONG).show();
        }

        return height;
    }



    public void readDataFromFireBase(Context context) {
        Global.initializeSharedPrefernceData(context);
        final FirebaseDatabase database = FirebaseDatabase.getInstance(Global.FIREBASE_URL);
        DatabaseReference firebaseUserDataReference = database.getReference("Scopes");

        firebaseUserDataReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Gson gson = new Gson();
              //  String othersJSON = gson.toJson(dataSnapshot.child("Others").child("parts").getValue());
               // String poleTopJSON = gson.toJson(dataSnapshot.child("PoleTopEquipment").child("parts").getValue());
                String poleJSON = gson.toJson(dataSnapshot.child("Pole").child("parts").getValue());
              //  String undergroundJSON = gson.toJson(dataSnapshot.child("Underground").child("parts").getValue());

               try {
/*
                    JSONObject otherObject = new JSONObject(othersJSON);
                    Iterator othersX = otherObject.keys();
                    JSONArray jsonArray = new JSONArray();

                    while (othersX.hasNext()){
                        String key = (String) othersX.next();
                        jsonArray.put(otherObject.get(key));
                    }

                    JSONArray sortedOthersJsonArray = new JSONArray();
                    List<JSONObject> otherJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        otherJsonList.add(jsonArray.getJSONObject(i));
                    }

                    Collections.sort( otherJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA =0 ;
                            Integer valB =0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            }
                            catch (JSONException e) {
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

                    JSONObject poleTopObject= new JSONObject(poleTopJSON);
                    Iterator poleTopX = poleTopObject.keys();
                    JSONArray poleTopJsonArray = new JSONArray();

                    while (poleTopX.hasNext()){
                        String key = (String) poleTopX.next();
                        poleTopJsonArray.put(poleTopObject.get(key));
                    }

                    JSONArray sortedPOleTopJsonArray = new JSONArray();
                    List<JSONObject> poleTopJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < poleTopJsonArray.length(); i++) {
                        poleTopJsonList.add(poleTopJsonArray.getJSONObject(i));
                    }

                    Collections.sort( poleTopJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA =0 ;
                            Integer valB =0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            }
                            catch (JSONException e) {
                                //do something
                            }

                            return valA.compareTo(valB);
                        }
                    });

                    for (int i = 0; i < poleTopJsonArray.length(); i++) {
                        sortedPOleTopJsonArray.put(poleTopJsonList.get(i));

                    }


*/
                    /// pole


                    // JSONObject poleObject= null;

                    JSONObject poleObject = new JSONObject(poleJSON);
                    Iterator poleX = poleObject.keys();
                    JSONArray poleJsonArray = new JSONArray();

                    while (poleX.hasNext()){
                        String key = (String) poleX.next();
                        poleJsonArray.put(poleObject.get(key));
                    }

                    JSONArray sortedPOleJsonArray = new JSONArray();
                    List<JSONObject> poleJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < poleJsonArray.length(); i++) {
                        poleJsonList.add(poleJsonArray.getJSONObject(i));
                    }

                    Collections.sort( poleJsonList, new Comparator<JSONObject>() {

                        public int compare(JSONObject a, JSONObject b) {
                            Integer valA =0 ;
                            Integer valB =0;

                            try {
                                valA = (Integer) a.get("displayOrder");
                                valB = (Integer) b.get("displayOrder");
                            }
                            catch (JSONException e) {
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

                /*    JSONObject undergroundObject = new JSONObject(undergroundJSON);
                    Iterator undergroundX = undergroundObject.keys();
                    JSONArray undergroundJsonArray = new JSONArray();

                    while (undergroundX.hasNext()) {
                        String key = (String) undergroundX.next();
                        undergroundJsonArray.put(undergroundObject.get(key));
                    }

                    JSONArray sortedundergroundJsonArray = new JSONArray();
                    List<JSONObject> undergroundJsonList = new ArrayList<JSONObject>();
                    for (int i = 0; i < undergroundJsonArray.length(); i++) {
                        undergroundJsonList.add(undergroundJsonArray.getJSONObject(i));
                    }

                    Collections.sort(undergroundJsonList, new Comparator<JSONObject>() {

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

                    for (int i = 0; i < undergroundJsonArray.length(); i++) {
                        sortedundergroundJsonArray.put(undergroundJsonList.get(i));

                    }
                */
                //GlobalData.scopesPreferencesEditor.putString("othersJSON", sortedOthersJsonArray.toString());
                  //  GlobalData.scopesPreferencesEditor.putString("poleTopJSON", sortedPOleTopJsonArray.toString());
                   Log.i("vidisha","poleJSON==="+sortedPOleJsonArray.toString());
                    Global.scopesPreferencesEditor.putString("poleJSON", sortedPOleJsonArray.toString());
                   // GlobalData.scopesPreferencesEditor.putString("undergroundJSON", sortedundergroundJsonArray.toString());

                    Global.scopesPreferencesEditor.commit();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {

            }
        });

    }


}
