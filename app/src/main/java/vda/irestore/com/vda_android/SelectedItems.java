package vda.irestore.com.vda_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.services.s3.AmazonS3;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import vda.irestore.com.vda_android.Adapters.GridViewAdapter;
import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.Pojo.GridItem;
import vda.irestore.com.vda_android.Pojo.InspectionMetaData;

import static java.lang.String.valueOf;
import static vda.irestore.com.vda_android.Global.Global.initializeSharedPrefernceData;

public class SelectedItems extends AppCompatActivity {
    private ImageView m1,m2,m3,m4,m5,m6;
    private TextView Title;
    private View v1;

    SharedPreferences sharedPref, scopesPreferences, metadataPreferences;
    SharedPreferences.Editor scopesPreferencesEditor, metadataPreferencesEditor;
    boolean isListSelected = true, isJointOwnSelected = true, isAddNoteSelected = true, isCheckOkSelected = true, isTestingImageSelected = true,
            isPoleClassSelected = true, isPoleHeightSelected = true, isDoublePoleselected = true, isVoltageTestingSelected = true, isVisualTestingSelected = true,
            isSoundTestingSelected = true, isResistographSelected = true;
    int i = 1;

    private GridView mGridView_pole;
    private GridViewAdapter mGridAdapter;
    private ArrayList<GridItem> mGridData_pole;


    Typeface typeFace;
    JSONArray poleJsonArray;
    int code = 0;

    static int polePartCompleted = 0;


    AmazonS3 s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecteditems);
        Title = (TextView)findViewById(R.id.topToolbar_TextView_Title) ;
        Bundle bundle = getIntent().getExtras();
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


        mGridView_pole = (GridView) findViewById(R.id.grid);




        if(bundle != null) {
            int firstimage = bundle.getInt("wireImage");
            int secondimage = bundle.getInt("poletopImage");
            int thirdimage = bundle.getInt("splImage");
            int fourthimage = bundle.getInt("poleImage");
            int fifthimage = bundle.getInt("treeImage");
            int sixthimage = bundle.getInt("otherImage");

            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.imageGallery);
            final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(5, 10, 5, 10);
            final LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp1.setMargins(5, 10, 5,  30);

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

            if(firstimage != 0) {
                m1.setImageResource(firstimage);
                m1.setAdjustViewBounds(true);
                linearLayout.addView(m1);
                String default_title="Wire";
                String default_title_color = "#736AFF";
                int drawable = R.drawable.logo_box;
                ++code;
                if(code == 1)
                    setdefault(default_title,default_title_color,m1,drawable);
                m1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       // m1.setLayoutParams(lp1);
                        m1.setBackgroundResource(R.drawable.logo_box);
                        m2.setBackgroundResource(0);
                        m3.setBackgroundResource(0);
                        m4.setBackgroundResource(0);
                        m5.setBackgroundResource(0);
                        m6.setBackgroundResource(0);
                        Title.setText("Wire");
                        Title.setTextColor(Color.parseColor("#736AFF"));
                        Gson poleGson = new Gson();
                        try {

                            String response = Global.metadataPreferences.getString("wireeKey", "");
                            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                                    new TypeToken<List<GridItem>>() {
                                    }.getType());

                            if (poleGridItems_ArrayList != null) {
                                mGridData_pole = poleGridItems_ArrayList;
                                poleJsonArray = new JSONArray(Global.metadataPreferences.getString("wireeKey", "").trim());
                            } else {
                                mGridData_pole = new ArrayList<>();
                                poleJsonArray = new JSONArray(Global.scopesPreferences.getString("wireeJSON", "").trim());
                            }
                            mGridAdapter = new GridViewAdapter(SelectedItems.this, R.layout.grid_single, mGridData_pole);
                            mGridView_pole.setAdapter(mGridAdapter);

                            GridItem item;


                            for (int i = 0; i < poleJsonArray.length(); i++) {
                                JSONObject poleObj = poleJsonArray.optJSONObject(i);

                                String title = poleObj.optString("displayName");
                                String name = poleObj.optString("name");
                                final String imageUrl = poleObj.optString("imageURL");

                                item = new GridItem();
                                item.setTitle(title);
                                item.setName(name);
                                item.setImage(imageUrl);

                                mGridData_pole.add(item);
                            }
                            mGridAdapter.setGridData(mGridData_pole);
                            mGridAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            if (secondimage != 0) {

                m2.setImageResource(secondimage);
                linearLayout.addView(m2);
                String default_title="Pole Top";
                String default_title_color = "#3EA99F";
                int drawable = R.drawable.logo_box2;
                ++code;
                if(code == 1)
                    setdefault(default_title,default_title_color,m2,drawable);
                m2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m2.setBackgroundResource(R.drawable.logo_box2);
                        m1.setBackgroundResource(0);
                        m3.setBackgroundResource(0);
                        m4.setBackgroundResource(0);
                        m5.setBackgroundResource(0);
                        m6.setBackgroundResource(0);
                        Title.setText("Pole Top");
                        Title.setTextColor(Color.parseColor("#3EA99F"));
                        Gson poleGson = new Gson();
                        try {

                            String response = Global.metadataPreferences.getString("poleTopKey", "");
                            // String response = metadataPreferences.getString("PoleKey", "");
                            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                                    new TypeToken<List<GridItem>>() {
                                    }.getType());

                            if (poleGridItems_ArrayList != null) {
                                mGridData_pole = poleGridItems_ArrayList;
                                poleJsonArray = new JSONArray(Global.metadataPreferences.getString("poleTopKey", "").trim());
                            } else {
                                mGridData_pole = new ArrayList<>();
                                poleJsonArray = new JSONArray(Global.scopesPreferences.getString("poleTopJSON", "").trim());
                            }
                            mGridAdapter = new GridViewAdapter(SelectedItems.this, R.layout.grid_single, mGridData_pole);
                            mGridView_pole.setAdapter(mGridAdapter);

                            GridItem item;
                                  for (int i = 0; i < poleJsonArray.length(); i++) {
                                JSONObject poleObj = poleJsonArray.optJSONObject(i);

                                String title = poleObj.optString("displayName");
                                String name = poleObj.optString("name");
                                final String imageUrl = poleObj.optString("imageURL");

                                item = new GridItem();
                                item.setTitle(title);
                                item.setName(name);
                                item.setImage(imageUrl);

                                mGridData_pole.add(item);
                            }
                            mGridAdapter.setGridData(mGridData_pole);
                            mGridAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }

            if(thirdimage != 0)
            {
                m3.setImageResource(thirdimage);
                linearLayout.addView(m3);
                String default_title="SPL Equipment";
                String default_title_color = "#800080";
                int drawable = R.drawable.logo_box3;
                ++code;
                if(code == 1)
                    setdefault(default_title,default_title_color,m3,drawable);
                m3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m3.setBackgroundResource(R.drawable.logo_box3);
                        m2.setBackgroundResource(0);
                        m1.setBackgroundResource(0);
                        m4.setBackgroundResource(0);
                        m5.setBackgroundResource(0);
                        m6.setBackgroundResource(0);
                        Title.setText("SPL Equipment");
                        Title.setTextColor(Color.parseColor("#800080"));
                        Gson poleGson = new Gson();
                        try {

                            String response = Global.metadataPreferences.getString("splKey", "");
                            // String response = metadataPreferences.getString("PoleKey", "");
                            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                                    new TypeToken<List<GridItem>>() {
                                    }.getType());

                            if (poleGridItems_ArrayList != null) {
                                mGridData_pole = poleGridItems_ArrayList;
                                poleJsonArray = new JSONArray(Global.metadataPreferences.getString("splKey", "").trim());
                            } else {
                                mGridData_pole = new ArrayList<>();
                                poleJsonArray = new JSONArray(Global.scopesPreferences.getString("splJSON", "").trim());
                            }
                            mGridAdapter = new GridViewAdapter(SelectedItems.this, R.layout.grid_single, mGridData_pole);
                            mGridView_pole.setAdapter(mGridAdapter);

                            GridItem item;
                            for (int i = 0; i < poleJsonArray.length(); i++) {
                                JSONObject poleObj = poleJsonArray.optJSONObject(i);

                                String title = poleObj.optString("displayName");
                                String name = poleObj.optString("name");
                                final String imageUrl = poleObj.optString("imageURL");

                                item = new GridItem();
                                item.setTitle(title);
                                item.setName(name);
                                item.setImage(imageUrl);

                                mGridData_pole.add(item);
                            }
                            mGridAdapter.setGridData(mGridData_pole);
                            mGridAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }

            if(fourthimage != 0)
            {
                m4.setImageResource(fourthimage);
                linearLayout.addView(m4);
                String default_title="Pole";
                String default_title_color = "#FDD017";
                int drawable = R.drawable.logo_box4;
                ++code;
                if(code == 1)
                    setdefault(default_title,default_title_color,m4,drawable);
                m4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m4.setBackgroundResource(R.drawable.logo_box4);
                        m2.setBackgroundResource(0);
                        m3.setBackgroundResource(0);
                        m1.setBackgroundResource(0);
                        m5.setBackgroundResource(0);
                        m6.setBackgroundResource(0);
                        Title.setText("Pole");
                        Title.setTextColor(Color.parseColor("#FDD017"));
                        Gson poleGson = new Gson();
                        try {

                            String response = Global.metadataPreferences.getString("poleKey", "");
                            // String response = metadataPreferences.getString("PoleKey", "");
                            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                                    new TypeToken<List<GridItem>>() {
                                    }.getType());

                            if (poleGridItems_ArrayList != null) {
                                mGridData_pole = poleGridItems_ArrayList;
                                poleJsonArray = new JSONArray(Global.metadataPreferences.getString("poleKey", "").trim());
                            } else {
                                mGridData_pole = new ArrayList<>();
                                poleJsonArray = new JSONArray(Global.scopesPreferences.getString("poleJSON", "").trim());
                            }
                            mGridAdapter = new GridViewAdapter(SelectedItems.this, R.layout.grid_single, mGridData_pole);
                            mGridView_pole.setAdapter(mGridAdapter);

                            GridItem item;
                            for (int i = 0; i < poleJsonArray.length(); i++) {
                                JSONObject poleObj = poleJsonArray.optJSONObject(i);

                                String title = poleObj.optString("displayName");
                                String name = poleObj.optString("name");
                                final String imageUrl = poleObj.optString("imageURL");

                                item = new GridItem();
                                item.setTitle(title);
                                item.setName(name);
                                item.setImage(imageUrl);

                                mGridData_pole.add(item);
                            }
                            mGridAdapter.setGridData(mGridData_pole);
                            mGridAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }

            if(fifthimage != 0)
            {
                m5.setImageResource(fifthimage);
                linearLayout.addView(m5);
                String default_title="Tree";
                String default_title_color = "#43BFC7";
                int drawable = R.drawable.logo_box5;
                ++code;
                if(code == 1)
                    setdefault(default_title,default_title_color,m5,drawable);
                m5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m5.setBackgroundResource(R.drawable.logo_box5);
                        m2.setBackgroundResource(0);
                        m3.setBackgroundResource(0);
                        m4.setBackgroundResource(0);
                        m1.setBackgroundResource(0);
                        m6.setBackgroundResource(0);
                        Title.setText("Tree");
                        Title.setTextColor(Color.parseColor("#43BFC7"));
                        Gson poleGson = new Gson();
                        try {

                            String response = Global.metadataPreferences.getString("treeKey", "");
                            // String response = metadataPreferences.getString("PoleKey", "");
                            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                                    new TypeToken<List<GridItem>>() {
                                    }.getType());

                            if (poleGridItems_ArrayList != null) {
                                mGridData_pole = poleGridItems_ArrayList;
                                poleJsonArray = new JSONArray(Global.metadataPreferences.getString("treeKey", "").trim());
                            } else {
                                mGridData_pole = new ArrayList<>();
                                poleJsonArray = new JSONArray(Global.scopesPreferences.getString("treeJSON", "").trim());
                            }
                            mGridAdapter = new GridViewAdapter(SelectedItems.this, R.layout.grid_single, mGridData_pole);
                            mGridView_pole.setAdapter(mGridAdapter);

                            GridItem item;
                            for (int i = 0; i < poleJsonArray.length(); i++) {
                                JSONObject poleObj = poleJsonArray.optJSONObject(i);

                                String title = poleObj.optString("displayName");
                                String name = poleObj.optString("name");
                                final String imageUrl = poleObj.optString("imageURL");

                                item = new GridItem();
                                item.setTitle(title);
                                item.setName(name);
                                item.setImage(imageUrl);

                                mGridData_pole.add(item);
                            }
                            mGridAdapter.setGridData(mGridData_pole);
                            mGridAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }

            if(sixthimage != 0)
            {
                m6.setImageResource(sixthimage);
                linearLayout.addView(m6);
                String default_title="Other";
                String default_title_color = "#0000A0";
                int drawable = R.drawable.logo_box6;
                ++code;
                if(code == 1)
                    setdefault(default_title,default_title_color,m6,drawable );
                    m6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        m6.setBackgroundResource(R.drawable.logo_box6);
                        m2.setBackgroundResource(0);
                        m3.setBackgroundResource(0);
                        m4.setBackgroundResource(0);
                        m5.setBackgroundResource(0);
                        m1.setBackgroundResource(0);
                        Title.setText("Other");
                        Title.setTextColor(Color.parseColor("#0000A0"));
                        Gson poleGson = new Gson();
                        try {

                            String response = Global.metadataPreferences.getString("othersKey", "");
                            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                                    new TypeToken<List<GridItem>>() {
                                    }.getType());

                            if (poleGridItems_ArrayList != null) {
                                mGridData_pole = poleGridItems_ArrayList;
                                poleJsonArray = new JSONArray(Global.metadataPreferences.getString("othersKey", "").trim());
                            } else {
                                mGridData_pole = new ArrayList<>();
                                poleJsonArray = new JSONArray(Global.scopesPreferences.getString("othersJSON", "").trim());
                            }
                            mGridAdapter = new GridViewAdapter(SelectedItems.this, R.layout.grid_single, mGridData_pole);
                            mGridView_pole.setAdapter(mGridAdapter);

                            GridItem item;
                            for (int i = 0; i < poleJsonArray.length(); i++) {
                                JSONObject poleObj = poleJsonArray.optJSONObject(i);

                                String title = poleObj.optString("displayName");
                                String name = poleObj.optString("name");
                                final String imageUrl = poleObj.optString("imageURL");

                                item = new GridItem();
                                item.setTitle(title);
                                item.setName(name);
                                item.setImage(imageUrl);

                                mGridData_pole.add(item);
                            }
                            mGridAdapter.setGridData(mGridData_pole);
                            mGridAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }
        }
    }
    private void setdefault(String default_title,String default_title_color,ImageView m,int drawable) {
        Title.setText(default_title);
        Title.setTextColor(Color.parseColor(default_title_color));
        m.setBackgroundResource(drawable);
    }
}
