package vda.irestore.com.vda_android;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.amazonaws.services.s3.AmazonS3;
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
import vda.irestore.com.vda_android.Adapters.InspectionMetaDataAdapter;
import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.Global.GlobalData;
import vda.irestore.com.vda_android.Global.Utils;
import vda.irestore.com.vda_android.Pojo.GridItem;
import vda.irestore.com.vda_android.Pojo.InspectionMetaData;
import vda.irestore.com.vda_android.readData.ReadUnderGroundData;
import vda.irestore.com.vda_android.readData.UnderGroundData;

import static java.lang.String.valueOf;


public class SelectedItems extends AppCompatActivity implements View.OnClickListener{
    HashMap<String,JSONObject> undergroundParts_Images  = new HashMap<>();
    JSONObject damageDetailspadmountsOne = new JSONObject();
    Button closeBtn, closeAddNoteBtn;
    final int REQUEST_CAMERA_ONE = 41;
    final int REQUEST_CAMERA_TWO = 42;
    ImageView  partImage,testingImage;
    String undergroundScopeImage,picturePath, testingPicturePath, partTitle,undergroundScopeTestingImage,voltageTestKey;
    boolean isListSelected = true, isAddNoteSelected = true, isRepairSelected = true, isTestingImageSelected = true, isVoltageTestingSelected = true;
    private ArrayList<GridItem> mGridDataJSON;
    public int horizontalItemSelectedPosition = -1, verticalItemSelectedPosition = -1, gridPositionNew = 0, localIndexToAddNote = -1;
    ArrayList<InspectionMetaData> localInspectionMetaData;
    RelativeLayout pendingInspectionLayout;
    ListView listView;
    String gridTitle = null;
    private ImageView m1,m2,m3,m4,m5,m6;
    private TextView Title;
    private View v1;
    ArrayList<InspectionMetaData> underground_inspectionData_list ,inspectionData_listNew;
    ArrayList<InspectionMetaData> pole_inspectionData_list;
    InspectionMetaDataAdapter arrayAdapter;
    JSONArray poleJsonArray,poleMetadataJsonArrayList;
    JSONArray undergroundJsonArray,undergroundMetadataJsonArrayList;
    SharedPreferences sharedPref, scopesPreferences, metadataPreferences;
    SharedPreferences.Editor scopesPreferencesEditor, metadataPreferencesEditor;
    boolean
            isPoleClassSelected = true, isPoleHeightSelected = true, isDoublePoleselected = true,  isVisualTestingSelected = true,
            isSoundTestingSelected = true, isResistographSelected = true;
    int i = 1;

    private GridView mGridView_pole;
    private GridViewAdapter mGridAdapter;
    private ArrayList<GridItem> mGridData_pole;

    Boolean isSelected = false;
    Typeface typeFace;

    int code = 0;

    static int polePartCompleted = 0;


    AmazonS3 s3;
    RecyclerView horizontalListView;
    CountAdapter recyclerCountAdapter;
    public int selectedItem;
    TextView nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecteditems);
        Title = (TextView)findViewById(R.id.topToolbar_TextView_Title) ;
        Bundle bundle = getIntent().getExtras();
        typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        polePartCompleted = 0;

        isListSelected = true;  isAddNoteSelected = true; isRepairSelected = true; isTestingImageSelected = true;
        isPoleClassSelected = true; isPoleHeightSelected = true; isDoublePoleselected = true; isVoltageTestingSelected = true; isVisualTestingSelected = true;
        isSoundTestingSelected = true; isResistographSelected = true;

        GlobalData.initializeSharedPrefernceData(this);
        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);

        instantiateListWithData();

        scopesPreferences = getSharedPreferences(getString(
                R.string.scopes_preferences), Context.MODE_PRIVATE);
        scopesPreferencesEditor = scopesPreferences.edit();
        metadataPreferences = getSharedPreferences(getString(
                R.string.metadataPreferences), Context.MODE_PRIVATE);
        metadataPreferencesEditor = metadataPreferences.edit();


        mGridView_pole = (GridView) findViewById(R.id.grid);
        nextButton = (TextView)findViewById(R.id.nextButton);
        nextButton.setTypeface(typeFace);

         nextButton.setOnClickListener(this);

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
                if(code == 1) {
                    setdefault(default_title, default_title_color, m1, drawable);
                    loadSelectedScopesData("wireeKey","wireeJSON");
                }
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
                        loadSelectedScopesData("wireeKey","wireeJSON");

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
                if(code == 1) {
                    setdefault(default_title, default_title_color, m2, drawable);
                    loadSelectedScopesData("poleTopKey","poleTopJSON");
                }
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
                        loadSelectedScopesData("poleTopKey","poleTopJSON");

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
                if(code == 1) {
                    setdefault(default_title, default_title_color, m3, drawable);
                    loadSelectedScopesData("splKey","splJSON");
                }
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
                        loadSelectedScopesData("splKey","splJSON");

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
                if(code == 1) {
                    setdefault(default_title, default_title_color, m4, drawable);
                    loadSelectedScopesData("poleKey","poleJSON");
                }
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
                        loadSelectedScopesData("poleKey","poleJSON");

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
                if(code == 1) {
                    setdefault(default_title, default_title_color, m5, drawable);
                    loadSelectedScopesData("treeKey","treeJSON");
                }
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
                        loadSelectedScopesData("treeKey","treeJSON");

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
                if(code == 1) {
                    setdefault(default_title, default_title_color, m6, drawable);
                    loadSelectedScopesData("othersKey","othersJSON");
                }
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
                        loadSelectedScopesData("othersKey","othersJSON");
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

    private void loadSelectedScopesData(final String key, final String jsonKey)
    {
        Gson poleGson = new Gson();
        try {

            String response = GlobalData.metadataPreferences.getString(key, "");
            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                    new TypeToken<List<GridItem>>() {
                    }.getType());

            if (poleGridItems_ArrayList != null) {
                mGridData_pole = poleGridItems_ArrayList;
                poleJsonArray = new JSONArray(GlobalData.metadataPreferences.getString(key, "").trim());
            } else {
                mGridData_pole = new ArrayList<>();
                poleJsonArray = new JSONArray(GlobalData.scopesPreferences.getString(jsonKey, "").trim());
            }
            mGridAdapter = new GridViewAdapter(SelectedItems.this, R.layout.grid_single, mGridData_pole);
            mGridView_pole.setAdapter(mGridAdapter);

            GridItem item;
            HashMap <String,String> inspectionData_map = new HashMap<>();
            for (int i = 0; i < poleJsonArray.length(); i++) {
                JSONObject poleObj = poleJsonArray.optJSONObject(i);



                String title = poleObj.optString("displayName");
                String name = poleObj.optString("name");
                final String imageUrl = poleObj.optString("imageURL");
                final String  imageName;
                imageName = poleObj.optString("imageName");

                inspectionData_map.put(title,poleObj.getJSONArray("MetaData").toString());

                item = new GridItem();
                item.setTitle(title);
                item.setName(name);
                item.setImage(imageUrl);
                item.setImageName(imageName);

                item.setData(inspectionData_map);

                mGridData_pole.add(item);
            }
            mGridAdapter.setGridData(mGridData_pole);
            mGridAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mGridView_pole.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final GridItem item = (GridItem) parent.getItemAtPosition(position);
                ImageView img = (ImageView) view.findViewById(R.id.grid_image);

                //   ShowMetaDataDialog(SelectedItems.this, item, position,key,jsonKey);
                if(jsonKey.equalsIgnoreCase("othersJSON"))
                    ShowOthersDialog(SelectedItems.this, item, img, position);

            }
        });
    }

    public void instantiateListWithData() {
        GlobalData.getInstance().numberOfPadmountsDefects = new ArrayList<String>();
        GlobalData.getInstance().numberOfPullBoxDefect = new ArrayList<String>();
        GlobalData.getInstance().numberOfSpiceBoxDefect = new ArrayList<String>();
        GlobalData.getInstance().numberOfSectionalizerCabinetDefect= new ArrayList<String>();

        GlobalData.getInstance().numberOfPadmountsDefects.add("1");
        GlobalData.getInstance().numberOfPadmountsDefects.add("+");

        GlobalData.getInstance().numberOfPullBoxDefect.add("1");
        GlobalData.getInstance().numberOfPullBoxDefect.add("+");

        GlobalData.getInstance().numberOfSpiceBoxDefect.add("1");
        GlobalData.getInstance().numberOfSpiceBoxDefect.add("+");

        GlobalData.getInstance().numberOfSectionalizerCabinetDefect.add("1");
        GlobalData.getInstance().numberOfSectionalizerCabinetDefect.add("+");
    }

    private void populateListView(Context mContext,GridItem item, int gridPosition, int horizontalItemSelectedPosition/*, ImageView chk, RelativeLayout pendingInspectionLayout*/) {
        Boolean isChoosen = false;
        int localIndex = -1;
        ArrayList<InspectionMetaData> underground_inspectionData_list ;
        underground_inspectionData_list = findingListRefference(gridPosition, horizontalItemSelectedPosition);
        try {
            if ( underground_inspectionData_list.size() == 0){
                Gson undergroundMetadataGsonList = new Gson();
                String response = GlobalData.metadataPreferences.getString(item.getTitle()+"othersListJSON","");

                final ArrayList<InspectionMetaData> undergroundListItems_ArrayList = undergroundMetadataGsonList.fromJson(response,
                        new TypeToken<List<InspectionMetaData>>(){}.getType());

                if(undergroundListItems_ArrayList!=null) {
                    underground_inspectionData_list = undergroundListItems_ArrayList;
                    undergroundMetadataJsonArrayList = new JSONArray(GlobalData.metadataPreferences.getString(item.getTitle()+"othersListJSON","").trim());
                } else {
//                underground_inspectionData_list = new ArrayList<>();
                    JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                    undergroundMetadataJsonArrayList = j;

                    underground_inspectionData_list.clear();
                    for(int s =1;s<undergroundMetadataJsonArrayList.length();s++) {
                        String displayName = undergroundMetadataJsonArrayList.getJSONObject(s).get("displayName").toString();

                        String name = undergroundMetadataJsonArrayList.getJSONObject(s).get("name").toString();
                        String imageUrl = undergroundMetadataJsonArrayList.getJSONObject(s).get("imageURL").toString();
                        String imageName =  undergroundMetadataJsonArrayList.getJSONObject(s).get("imagename").toString();
                        underground_inspectionData_list.add(new InspectionMetaData(displayName, name, imageUrl, imageName, false, item.getTitle()));
                    }
                }
//                final JSONObject chkListObject = new JSONObject();
//                final JSONObject chkListObjectPreview = new JSONObject();
            } else {

            }
            arrayAdapter = new InspectionMetaDataAdapter(underground_inspectionData_list,mContext,listView);
            listView.setAdapter(arrayAdapter);
        } catch (JSONException e){

        }
    }


    private ArrayList<InspectionMetaData> findingListRefference(int gridPosition, int horizontalItemSelectedPosition) {
        if(gridPosition == 0){
            return padmountsReference(horizontalItemSelectedPosition);
        } else if(gridPosition == 1){
            return pullBoxReference(horizontalItemSelectedPosition);
        } else if(gridPosition == 2){
            return spiceBoxReference(horizontalItemSelectedPosition);
        } else if(gridPosition == 3){
            return sectionalizerCabinetReference(horizontalItemSelectedPosition);
        } else {
            return null;
        }
    }

    private ArrayList<InspectionMetaData> sectionalizerCabinetReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return UnderGroundData.getInstance().sectionalizerCabinetOne;
            case 1:
                return UnderGroundData.getInstance().sectionalizerCabinetTwo;
            case 2:
                return UnderGroundData.getInstance().sectionalizerCabinetThree;
            case 3:
                return UnderGroundData.getInstance().sectionalizerCabinetFour;
            case 4:
                return UnderGroundData.getInstance().sectionalizerCabinetFive;
            case 5:
                return UnderGroundData.getInstance().sectionalizerCabinetSix;
            case 6:
                return UnderGroundData.getInstance().sectionalizerCabinetSeven;
            case 7:
                return UnderGroundData.getInstance().sectionalizerCabinetEight;
            case 8:
                return UnderGroundData.getInstance().sectionalizerCabinetNine;
            case 9:
                return UnderGroundData.getInstance().sectionalizerCabinetTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> spiceBoxReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return UnderGroundData.getInstance().spiceBoxOne;
            case 1:
                return UnderGroundData.getInstance().spiceBoxTwo;
            case 2:
                return UnderGroundData.getInstance().spiceBoxThree;
            case 3:
                return UnderGroundData.getInstance().spiceBoxFour;
            case 4:
                return UnderGroundData.getInstance().spiceBoxFive;
            case 5:
                return UnderGroundData.getInstance().spiceBoxSix;
            case 6:
                return UnderGroundData.getInstance().spiceBoxSeven;
            case 7:
                return UnderGroundData.getInstance().spiceBoxEight;
            case 8:
                return UnderGroundData.getInstance().spiceBoxNine;
            case 9:
                return UnderGroundData.getInstance().spiceBoxTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> pullBoxReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return UnderGroundData.getInstance().pullBoxOne;
            case 1:
                return UnderGroundData.getInstance().pullBoxTwo;
            case 2:
                return UnderGroundData.getInstance().pullBoxThree;
            case 3:
                return UnderGroundData.getInstance().pullBoxFour;
            case 4:
                return UnderGroundData.getInstance().pullBoxFive;
            case 5:
                return UnderGroundData.getInstance().pullBoxSix;
            case 6:
                return UnderGroundData.getInstance().pullBoxSeven;
            case 7:
                return UnderGroundData.getInstance().pullBoxEight;
            case 8:
                return UnderGroundData.getInstance().pullBoxNine;
            case 9:
                return UnderGroundData.getInstance().pullBoxTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> padmountsReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return UnderGroundData.getInstance().padmountsOne;
            case 1:
                return UnderGroundData.getInstance().padmountsTwo;
            case 2:
                return UnderGroundData.getInstance().padmountsThree;
            case 3:
                return UnderGroundData.getInstance().padmountsFour;
            case 4:
                return UnderGroundData.getInstance().padmountsFive;
            case 5:
                return UnderGroundData.getInstance().padmountsSix;
            case 6:
                return UnderGroundData.getInstance().padmountsSeven;
            case 7:
                return UnderGroundData.getInstance().padmountsEight;
            case 8:
                return UnderGroundData.getInstance().padmountsNine;
            case 9:
                return UnderGroundData.getInstance().padmountsTen;
            default:
                return null;
        }
    }
    private boolean addRespectiveDefectCount(int position, int itemPosition) {
        boolean isCountAdded = false;
        Log.i("vidisha","hhhhhh"+isCountAdded);
        switch (itemPosition) {
            case 0:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 3) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfPadmountsDefects.add(position, GlobalData.getInstance().numberOfPadmountsDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 1:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfPullBoxDefect.add(position, GlobalData.getInstance().numberOfPullBoxDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 2:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfSpiceBoxDefect.add(position, GlobalData.getInstance().numberOfSpiceBoxDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 3:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfSectionalizerCabinetDefect.add(position, GlobalData.getInstance().numberOfSectionalizerCabinetDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
        }
        return isCountAdded;
    }



    private void ShowMetaDataDialog(final Context mContext, final GridItem item, final int gridPosition,final String key,String JsonKey) {
        horizontalItemSelectedPosition = 0;
        gridTitle = item.getTitle();
        sharedPref = mContext.getSharedPreferences(mContext.getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);

        final Dialog dialog = new Dialog(mContext, R.style.Theme_Dialog);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.test_layout, null);

        horizontalListView = (RecyclerView) mView.findViewById(R.id.recyler_count_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        horizontalListView.setLayoutManager(linearLayoutManager);
        manupilateHorizontalListData(mContext, gridPosition);
        horizontalListView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                horizontalListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean isCountAdd;
                        isCountAdd = addRespectiveDefectCount(position, gridPosition);
                        if (!isCountAdd && recyclerCountAdapter.getItemCount() <= 10) {
                            horizontalItemSelectedPosition = position;
                            recyclerCountAdapter.notifyDataSetChanged();
                          //  populateListView(key,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);


                        }
                    }
                });
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        manupilateHorizontalListData(mContext, gridPosition);
        Button closeBtn = (Button)mView.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);

        EditText comments = (EditText)mView.findViewById(R.id.comments) ;
        comments.setTypeface(typeFace);

        TextView dataHeading = (TextView)mView.findViewById(R.id.dataHeading);
        dataHeading.setText(gridTitle);
        dataHeading.setTypeface(typeFace);
         listView = (ListView) mView.findViewById(R.id.inspectionData_list);
     //   populateListView(key,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
      /*  try {

            Gson poleMetadataGsonList = new Gson();
            String response = metadataPreferences.getString(key, "");
            Log.i("vidisha","Item selected :::"+item.getTitle());

            final ArrayList<InspectionMetaData> poleListItems_ArrayList = poleMetadataGsonList.fromJson(response,
                    new TypeToken<List<InspectionMetaData>>() {
                    }.getType());

            if(poleListItems_ArrayList!=null)
            {
                pole_inspectionData_list = poleListItems_ArrayList;
                poleMetadataJsonArrayList = new JSONArray(metadataPreferences.getString(item.getTitle()+"poleListJSON","").trim());

            }
            else {

                pole_inspectionData_list = new ArrayList<>();
                JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                poleMetadataJsonArrayList = j;
            }

            Log.i("vidisha","metadataPreferences :::"+poleMetadataJsonArrayList);
            for (int s = 0; s < poleMetadataJsonArrayList.length(); s++) {
                String displayName = poleMetadataJsonArrayList.getJSONObject(s).get("displayName").toString();

                String name = poleMetadataJsonArrayList.getJSONObject(s).get("name").toString();
                String imageUrl = poleMetadataJsonArrayList.getJSONObject(s).get("imageURL").toString();
                String imageName = poleMetadataJsonArrayList.getJSONObject(s).get("imagename").toString();
                pole_inspectionData_list.add(new InspectionMetaData(displayName, name, imageUrl, imageName, true, gridTitle));

            }
        }catch (Exception e)
        {

        }
        arrayAdapter = new InspectionMetaDataAdapter(pole_inspectionData_list,SelectedItems.this,listView);
        listView.setAdapter(arrayAdapter);*/
        metadataPreferencesEditor.commit();
     //   readDoublePoleData("extent");
        final TextView repaire = mView.findViewById(R.id.repair);
        final TextView replace = mView.findViewById(R.id.replace);
        repaire.setBackgroundResource(R.drawable.repaire_replace_active);
        repaire.setTextColor(Color.parseColor("#FFFFFF"));
        replace.setBackgroundResource(R.drawable.repair_replace_deactive);
        replace.setTextColor(Color.parseColor("#3EA99F"));
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));


            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }
        });



        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.setContentView(mView);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
    }
    public void ShowOthersDialog(final Context mContext, final GridItem item,final ImageView imgView, final int gridPosition) {
        gridPositionNew = gridPosition;
        gridTitle = item.getTitle();
        isListSelected = true; isAddNoteSelected = true; isRepairSelected = true; isVoltageTestingSelected = true; isTestingImageSelected = true;
        mGridDataJSON = new ArrayList<>();


        sharedPref = mContext.getSharedPreferences(mContext.getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);


        Log.i("under","in dialog"+item.getImageName());
        final Dialog dialog = new Dialog(mContext, R.style.Theme_Dialog);
        View view = LayoutInflater.from(mContext).inflate(R.layout.test_layout, null);

        horizontalListView = (RecyclerView) view.findViewById(R.id.recyler_count_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        horizontalListView.setLayoutManager(linearLayoutManager);



        final EditText comments = view.findViewById(R.id.comments);

        final TextView repaire = view.findViewById(R.id.repair);
        final TextView replace = view.findViewById(R.id.replace);
        repaire.setBackgroundResource(R.drawable.repaire_replace_active);
        repaire.setTextColor(Color.parseColor("#FFFFFF"));
        replace.setBackgroundResource(R.drawable.repair_replace_deactive);
        replace.setTextColor(Color.parseColor("#3EA99F"));
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }
        });


        comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog dialog2 = new BottomSheetDialog(SelectedItems.this);
                View mView2 = LayoutInflater.from(mContext).inflate(R.layout.comment_dialog, null);
               // final View mView2 = getLayoutInflater().inflate(R.layout.comment_dialog, null);
                dialog2.setContentView(mView2);
                dialog2.show();
                final EditText dialog_comment = mView2.findViewById(R.id.comments_editText);

                String noteString = readNoteFromRespectiveCountList(gridPosition);

                if(noteString!=null) {
                    comments.setText(noteString);
                    dialog_comment.setText(noteString.trim());
                }
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        comments.setText(dialog_comment.getText().toString());
                        addNoteToRespectiveCountList(gridTitle, dialog_comment.getText().toString());
                        if(dialog_comment.getText().toString() != null && !dialog_comment.getText().toString().isEmpty())
                            isAddNoteSelected = false;

                        dialog2.dismiss();
                    }
                });
            }
        });

        manupilateHorizontalListData(mContext, gridPosition);
        closeBtn = (Button)view.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);
        partImage = (ImageView)view.findViewById(R.id.clickPicture) ;
        readImagesForRespectiveDefects(mContext, partImage);
        partImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  picturePath =item.getS3ImageName();
                picturePath ="Other"+"-DETAIL-"+item.getName()+"-"+horizontalItemSelectedPosition;
                partTitle = item.getTitle();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(mContext instanceof SelectedItems)
                    ((SelectedItems)mContext).startActivityForResult(intent, REQUEST_CAMERA_ONE);

            }
        });


        TextView typeLabel = (TextView) view.findViewById(R.id.typeLabel) ;

        typeLabel.setTypeface(typeFace);



        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickView) {
                if(!isListSelected ||!isAddNoteSelected ||!isTestingImageSelected| isRepairSelected){
                    try {
                        Log.i("vidisha","helloooooooooo"+isAddNoteSelected);
                        // if(!othersParts_commentsMetaData.get(item.getTitle()).get("comments").toString().isEmpty())
                        item.setImage("https://s3.amazonaws.com/restore-build-artefacts/InspectionIcons/other_tick.png");
                        item.setInspectionDone(true);

                        /* else
                             item.setImage("https://s3.amazonaws.com/restore-build-artefacts/InspectionIcons/icn_"+item.getImageName()+".png");*/
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Log.i("vidisha","imageName=="+item.getImageName());
                    item.setInspectionDone(false);
                    item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/"+item.getImageName()+".png");

                    // item.setImage(item.getImage());
                }
                if(mGridAdapter!=null)
                    mGridAdapter.notifyDataSetChanged();
                Picasso.with(SelectedItems.this).load(item.getImage())
                        .into(imgView);

                String key = item.getTitle()+"othersListJSON";
                // ArrayList<GridItem> ModelArrayList=new ArrayList();
                Gson gson = new Gson();
                String json = gson.toJson(underground_inspectionData_list);

                if(GlobalData.metadataPreferencesEditor!=null) {
                    GlobalData.metadataPreferencesEditor.remove(key).commit();
                    //             editor.putString("othersJSON_Modified",json);
                    GlobalData.metadataPreferencesEditor.putString(key, json);
                    GlobalData.metadataPreferencesEditor.commit();
                }
                dialog.dismiss();
            }
        });

        TextView itemName = (TextView)view.findViewById(R.id.dataHeading) ;
        itemName.setText(item.getTitle());
        itemName.setTypeface(typeFace);
        listView = (ListView) view.findViewById(R.id.inspectionData_list);



        RelativeLayout layoutType= (RelativeLayout)view.findViewById(R.id.typeAsset) ;





        populateListView(mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
        horizontalListView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                horizontalListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean isCountAdd;
                        isCountAdd = addRespectiveDefectCount(position, gridPosition);
                        if (!isCountAdd && recyclerCountAdapter.getItemCount() <= 10) {
                            horizontalItemSelectedPosition = position;
                            recyclerCountAdapter.notifyDataSetChanged();
                            populateListView(mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
                            readImagesForRespectiveDefects(mContext, partImage);
                            String noteString = readNoteFromRespectiveCountList(gridPosition);
                            if(noteString!=null) {
                                comments.setText(noteString.trim());
                            } else {
                                comments.setText("");
                            }

                        }
                    }
                });
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


      /*  inspectionData_list = new ArrayList<InspectionMetaData>();
        arrayAdapter = new InspectionMetaDataAdapter(inspectionData_list,OthersActivity.this,listView);*/

        try {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    verticalItemSelectedPosition = position;
                    localInspectionMetaData = findingListRefference(gridPosition, horizontalItemSelectedPosition);
                    final InspectionMetaData listItemsN = (InspectionMetaData) parent.getItemAtPosition(position);
                    listView.setSelection(position);
                    view.setSelected(true);

                    String disPlayName, imageUrl,name;
                    boolean isSelected;
                    disPlayName = listItemsN.getDisplayName();
                    name = listItemsN.getName();
                    imageUrl = listItemsN.getImageUrl();
                    isSelected = listItemsN.getIsSelected();
                    Log.i("shri_LOG","name=="+listItemsN.getName());

                    if(!isSelected){
//                            imageUrl = "https://s3.amazonaws.com/restore-build-artefacts/InspectionIcons/damage_tick.png";
                        localInspectionMetaData.set(position,new InspectionMetaData(disPlayName, name ,imageUrl, "image Name", true, item.getTitle()));
                    } else {
                        localInspectionMetaData.set(position, new InspectionMetaData(disPlayName, name ,imageUrl, "image Name", false, item.getTitle()));
                    }
                    arrayAdapter.notifyDataSetChanged();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            boolean isSelected = true;
                            for (int i = 0; i < localInspectionMetaData.size(); i++) {
                                if (localInspectionMetaData.get(i).getIsSelected() != null && localInspectionMetaData.get(i).getIsSelected()) {
                                    isSelected = false;
                                }
                            }
                            if (!isSelected) {
                                Log.i("vidisha","helloo11111");
                               // pendingInspectionLayout.setBackgroundColor(Color.TRANSPARENT);
                                isListSelected = false;
                            } else {
                                Log.i("vidisha","helloo22222");
                                isListSelected = true;
                              //  pendingInspectionLayout.setBackgroundColor(Color.parseColor("#00A699"));
                            }
                        }
                    });
                    arrayAdapter.notifyDataSetChanged();

                }
            });
            arrayAdapter.notifyDataSetChanged();

            mGridDataJSON.add(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.setContentView(view);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
    }

    private void manupilateHorizontalListData(Context mContext, int position) {
        horizontalItemSelectedPosition = 0;
        switch (position){
            case 0:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfPadmountsDefects);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 1:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfPullBoxDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 2:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfSpiceBoxDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 3:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfSectionalizerCabinetDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;

        }
    }

    private String readNoteFromRespectiveCountList(int position) {
        String note= null;
        if(position == 0){
            localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
            return findNoteData();
        } else if(position == 1){
            localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
            return findNoteData();
        } else if(position == 2){
            localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
            return findNoteData();
        } else if(position == 3){
            localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
            return findNoteData();
        }
        return null;
    }

    private String findNoteData() {
        String note = null;
        for (int i=0; i< localInspectionMetaData.size(); i++) {
            // to find out the respective note from inspectionMetaData in a loop
            if(localInspectionMetaData.get(i).getNote() != null)
                note = localInspectionMetaData.get(i).getNote();
        }
        return note;
    }

    private void addNoteToRespectiveCountList(String title, String note) {
        // adding note to respective count (horizontal list item)
        String noteNew = null;
        int localIndex = -1;

        if(gridPositionNew == 0){
            localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
            noteNew = findingIndexToAddNote(noteNew, localIndex);
        } else if(gridPositionNew == 1){
            localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
            noteNew = findingIndexToAddNote(noteNew, localIndex);
        } else if(gridPositionNew == 2){
            localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
            noteNew = findingIndexToAddNote(noteNew, localIndex);
        } else if(gridPositionNew == 3){
            localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
            noteNew = findingIndexToAddNote(noteNew, localIndex);
        }

        if(noteNew != null){
            localInspectionMetaData.set(localIndexToAddNote, new InspectionMetaData(note, title, "addnote"));
            arrayAdapter.notifyDataSetChanged();
        } else {
            localInspectionMetaData.add(new InspectionMetaData(note, title, "addnote"));
            arrayAdapter.notifyDataSetChanged();
        }
    }
    InspectionMetaData inspectionMetaData;
    private String findingIndexToAddNote(String titleNew, int localIndex) {
        for(int i=0; i<localInspectionMetaData.size(); i++) {
            if(titleNew == null) {
                titleNew = localInspectionMetaData.get(i).getNote();
                inspectionMetaData = localInspectionMetaData.get(i);
                localIndexToAddNote = i;
            }
        }
        return titleNew;
    }
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAMERA_ONE) {
                isTestingImageSelected = false;
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                Matrix matrix = new Matrix();
                //  matrix.postRotate(90);

                Bitmap b = Bitmap.createScaledBitmap(thumbnail, 200, 200, false);
                Bitmap rotatedBitmap = Bitmap.createBitmap(b , 0, 0, b .getWidth(), b .getHeight(), matrix, true);
                partImage.setImageBitmap(rotatedBitmap);
                storeImage(b,picturePath,partTitle);
            }
        }
    }
    private void storeImage(Bitmap image,String picturePath,String partTitle) {
        File pictureFile = getOutputMediaFile(picturePath,partTitle);
        if (pictureFile == null) {
           /* Log.d(TAG,
                    "Error creating media file, check storage permissions: ");// e.getMessage());*/
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();

            try {
                JSONObject i = new JSONObject();
                i.put("imageUrl",pictureFile);
                undergroundParts_Images.put(partTitle,i);

                Log.i("vidisha","picturePath"+picturePath);
                // othersParts_damageMetaData.get(item.getTitle())
            } catch (JSONException e) {
                e.printStackTrace();
            }
            undergroundScopeImage = pictureFile.toString();
        } catch (FileNotFoundException e) {
            Log.d("SDA", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d("SDA", "Error accessing file: " + e.getMessage());
        }
    }
    private  File getOutputMediaFile(String pictureName,String partTitle){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File internalStorage = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), "InspectionsApp");
        if (!internalStorage.exists()) {
            internalStorage.mkdir();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        File reportFilePath = null;

        String imageName = sharedPref.getString("phoneNumber", "") + "_" + dateFormat.format(new Date()) + "-"+pictureName;
        reportFilePath = new File(internalStorage, imageName + ".png");
        if(GlobalData.underground_images_array!=null) {
            GlobalData.underground_images_array.add(reportFilePath);
        } else {
            GlobalData.underground_images_array = new ArrayList<>();
            GlobalData.underground_images_array.add(reportFilePath);
        }
        addImagesToRespectiveDefects(reportFilePath);
//        metadataPreferencesEditor.putString(partTitle+"partImage",reportFilePath.toString());
//        metadataPreferencesEditor.commit();
        return reportFilePath;
    }
    private void addImagesToRespectiveDefects(File reportFilePath) {
        int localIndex = -1;
        if(gridPositionNew == 0){
            localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
            localIndex = findingIndexToAddImagePath();
        } else if(gridPositionNew == 1){
            localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
            localIndex = findingIndexToAddImagePath();
        } else if(gridPositionNew == 2){
            localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
            localIndex = findingIndexToAddImagePath();
        } else if(gridPositionNew == 3){
            localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
            localIndex = findingIndexToAddImagePath();
        }

        if(localIndex == -1) {
            localInspectionMetaData.add(new InspectionMetaData(reportFilePath.toString(), gridTitle));
            Log.i("image_path", "part set path" + reportFilePath.toString());
        }else {
            localInspectionMetaData.set(localIndex, new InspectionMetaData(reportFilePath.toString(), gridTitle));
            Log.i("image_path", "part set path" + reportFilePath.toString());
        }
        arrayAdapter.notifyDataSetChanged();
    }

    private int findingIndexToAddImagePath() {
        int localIndex = -1;

        for(int i = 0; i< localInspectionMetaData.size(); i++){
            if (localInspectionMetaData.get(i).getPicturePath() != null) {
                localIndex = i;
            }
        }
        return  localIndex;
    }

    private void readImagesForRespectiveDefects(Context mContext,ImageView partImage) {
        String picturePath = null;
        if(gridPositionNew == 0){
            localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
            picturePath = findingPath();
        } else if(gridPositionNew == 1){
            localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
            picturePath = findingPath();
        } else if(gridPositionNew == 2){
            localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
            picturePath = findingPath();
        } else if(gridPositionNew == 3){
            localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
            picturePath = findingPath();
        }

        if(picturePath != null) {
            partImage.setImageBitmap(Utils.getBitmap(picturePath));
        }else {
            Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.icn_camera);
            partImage.setImageBitmap(icon);
        }
    }
    private String findingPath() {
        for(int i = 0; i< localInspectionMetaData.size(); i++){
            if (localInspectionMetaData.get(i).getPicturePath() != null) {
                Log.i("image_path", "part index = " + i +"\n" +localInspectionMetaData.get(i).getPicturePath());
                return  picturePath = localInspectionMetaData.get(i).getPicturePath();
            }
        }
        return null;
    }
    private void readDoublePoleData(String utility) {
        boolean isCheck = false;
        int localIndex = -1;
        localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
        if (localInspectionMetaData != null) {
            for (int i = 0; i < localInspectionMetaData.size(); i++) {
                if (localInspectionMetaData.get(i).getIsUtilityOwned() != null && localInspectionMetaData.get(i).getSubTitle()!=null &&
                        localInspectionMetaData.get(i).getSubTitle().equalsIgnoreCase(utility)) {
                    isCheck = localInspectionMetaData.get(i).getIsUtilityOwned();
                    localIndex = i;
                }
            }
            if (localIndex != -1) {
                if (localInspectionMetaData.get(localIndex).getSubTitle() != null && localInspectionMetaData.get(localIndex).getSubTitle().equalsIgnoreCase("extent"))
                    isRepairSelected = true;
            } else
                isRepairSelected = false;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.nextButton:
                JSONObject padmountsOneData = ReadUnderGroundData.getInstance().readpadmountsOneData();
                try {
                    padmountsOneData.put("extent","REPAIR");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject damageDetailspadmounts1 = new JSONObject();
                Log.i("greeshma==","padmountsOneData"+padmountsOneData.toString());

        }
    }
}
