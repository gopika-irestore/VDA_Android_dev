package vda.irestore.com.vda_android;

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
import android.os.AsyncTask;
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
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
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
import vda.irestore.com.vda_android.readData.PoleData;
import vda.irestore.com.vda_android.readData.PoleTopEquipmentData;
import vda.irestore.com.vda_android.readData.ReadPoleEquipmentData;
import vda.irestore.com.vda_android.readData.ReadSplEquipmentData;
import vda.irestore.com.vda_android.readData.ReadTreeData;
import vda.irestore.com.vda_android.readData.ReadUnderGroundData;
import vda.irestore.com.vda_android.readData.ReadWireData;
import vda.irestore.com.vda_android.readData.SplEquipmentData;
import vda.irestore.com.vda_android.readData.TreeData;
import vda.irestore.com.vda_android.readData.UnderGroundData;
import vda.irestore.com.vda_android.readData.WireData;
import vda.irestore.com.vda_android.signup.PermissionsActivity;
import vda.irestore.com.vda_android.signup.STAsyncHttpConnection;

import static java.lang.String.valueOf;
import static vda.irestore.com.vda_android.Global.Global.S3_URL;


public class SelectedItems extends PermissionsActivity implements View.OnClickListener{

    JSONObject inspectionReport;
    private static final int CONNECTION_TIMEOUT = 6000;
    Exception exception;
    HashMap<String,JSONObject> undergroundParts_Images  = new HashMap<>();
    HashMap<String,JSONObject> poleParts_Images  = new HashMap<>();
    HashMap<String,JSONObject> treeParts_Images  = new HashMap<>();
    JSONObject damageDetailspadmountsOne = new JSONObject();
    Button closeBtn, closeAddNoteBtn;
    final int REQUEST_CAMERA_ONE = 41;
    final int REQUEST_CAMERA_TWO = 42;
    ImageView  partImage,testingImage;
    String undergroundScopeImage,poleScopeImage,picturePath, testingPicturePath, partTitle,undergroundScopeTestingImage,voltageTestKey;
    boolean isListSelected = true, isAddNoteSelected = true, isRepairSelected = true,isReplaceSelected = true, isTestingImageSelected = true, isVoltageTestingSelected = true;
    private ArrayList<GridItem> mGridDataJSON;
    public int horizontalItemSelectedPosition = -1, verticalItemSelectedPosition = -1, gridPositionNew = 0, localIndexToAddNote = -1 ,localIndexToExtent = -1;
    ArrayList<InspectionMetaData> localInspectionMetaData;
    RelativeLayout pendingInspectionLayout;
    ListView listView;
    String gridTitle = null;
    private ImageView m1,m2,m3,m4,m5,m6;
    private TextView Title;
    private View v1;
    ArrayList<InspectionMetaData> underground_inspectionData_list ,pole_inspectionData_list;
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
    TransferUtility transferUtility;

    JSONObject poleScope = new JSONObject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecteditems);
        Title = (TextView)findViewById(R.id.topToolbar_TextView_Title) ;
        Bundle bundle = getIntent().getExtras();
        typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        polePartCompleted = 0;

       // isListSelected = true;  isAddNoteSelected = true; isRepairSelected = true; isTestingImageSelected = true;
       // isPoleClassSelected = true; isPoleHeightSelected = true; isDoublePoleselected = true; isVoltageTestingSelected = true; isVisualTestingSelected = true;
       // isSoundTestingSelected = true; isResistographSelected = true;
        Log.i("vidisha","Utils"+ Global.currentLocation);
        Log.i("vidisha","Utils11"+ Utils.currentLocation);

        GlobalData.initializeSharedPrefernceData(this);
        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);

        instantiateListWithData();
        instantiateListWithData_Pole();
        instantiateListWithData_Tree();
        instantiateListWithData_Spl();
        instantiateListWithData_Wire();
        instantiateListWithData_PoleTop();
        scopesPreferences = getSharedPreferences(getString(
                R.string.scopes_preferences), Context.MODE_PRIVATE);
        scopesPreferencesEditor = scopesPreferences.edit();
        metadataPreferences = getSharedPreferences(getString(
                R.string.metadataPreferences), Context.MODE_PRIVATE);
        metadataPreferencesEditor = metadataPreferences.edit();
        amazonS3Setup(this);

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
                        Title.setText("Non Pole Equipment");
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
            Log.i("vidisha","existes data"+response);
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
                switch (jsonKey)
                {
                    case "othersJSON":
                        Log.i("vidisha","1111");
                        ShowOthersDialog("Other", SelectedItems.this, item, img, position);
                        break;
                    case "poleJSON":
                        Log.i("vidisha","2222");
                        ShowPoleDialog("Pole", SelectedItems.this, item, img, position);
                        break;
                    case "treeJSON":
                        Log.i("vidisha","2222");
                        ShowTreeDialog("Tree", SelectedItems.this, item, img, position);
                        break;
                    case "wireeJSON":
                        Log.i("vidisha","2222");
                        ShowWireDialog("wire", SelectedItems.this, item, img, position);
                       // ShowSplDialog("wire", SelectedItems.this, item, img, position);
                        break;
                    case "poleTopJSON":
                        Log.i("vidisha","2222");
                        ShowPoleTopDialog("poleTop", SelectedItems.this, item, img, position);
                        break;
                    case "splJSON":
                        Log.i("vidisha","2222");
                        ShowSplDialog("spl", SelectedItems.this, item, img, position);
                        break;
                }

            }
        });
    }

    /**********************************************SCOPE SPL STARTS*****************************************************/

    public void instantiateListWithData_Spl() {
        GlobalData.getInstance().numberOfRecloserDefect = new ArrayList<String>();
        GlobalData.getInstance().numberOfRegulatorDefects = new ArrayList<String>();
        GlobalData.getInstance().numberOfCapacitorbankDefect = new ArrayList<String>();
        GlobalData.getInstance().numberOfLoadBreakSwitchDefect= new ArrayList<String>();

        GlobalData.getInstance().numberOfRecloserDefect.add("1");
        GlobalData.getInstance().numberOfRecloserDefect.add("+");

        GlobalData.getInstance().numberOfRegulatorDefects.add("1");
        GlobalData.getInstance().numberOfRegulatorDefects.add("+");

        GlobalData.getInstance().numberOfCapacitorbankDefect.add("1");
        GlobalData.getInstance().numberOfCapacitorbankDefect.add("+");

        GlobalData.getInstance().numberOfLoadBreakSwitchDefect.add("1");
        GlobalData.getInstance().numberOfLoadBreakSwitchDefect.add("+");
    }
    private ArrayList<InspectionMetaData> findingListRefferenceSpl(String scope,int gridPosition, int horizontalItemSelectedPosition) {

        if (gridPosition == 0) {
            return regulatorReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 1) {
            return capacitorBankReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 2) {
            return recloserReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 3) {
            return loadBreakSwitchReference(horizontalItemSelectedPosition);
        } else {
            return null;
        }

    }
    private void populateListView_Spl(final String scope,Context mContext,GridItem item, int gridPosition, int horizontalItemSelectedPosition/*, ImageView chk, RelativeLayout pendingInspectionLayout*/) {
        Boolean isChoosen = false;
        int localIndex = -1;
        ArrayList<InspectionMetaData> underground_inspectionData_list ;
        underground_inspectionData_list = findingListRefferenceSpl(scope,gridPosition, horizontalItemSelectedPosition);
        try {
            if ( underground_inspectionData_list.size() == 0){
                Gson undergroundMetadataGsonList = new Gson();
                String response = GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","");

                final ArrayList<InspectionMetaData> undergroundListItems_ArrayList = undergroundMetadataGsonList.fromJson(response,
                        new TypeToken<List<InspectionMetaData>>(){}.getType());

                if(undergroundListItems_ArrayList!=null) {
                    underground_inspectionData_list = undergroundListItems_ArrayList;
                    undergroundMetadataJsonArrayList = new JSONArray(GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","").trim());
                } else {
//                underground_inspectionData_list = new ArrayList<>();
                    JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                    undergroundMetadataJsonArrayList = j;

                    underground_inspectionData_list.clear();
                    for(int s =0;s<undergroundMetadataJsonArrayList.length();s++) {
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

    private boolean addRespectiveDefectCountSpl(int position, int itemPosition) {
        boolean isCountAdded = false;
        Log.i("vidisha","hhhhhh"+isCountAdded);
        switch (itemPosition) {
            case 0:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfRegulatorDefects.add(position, GlobalData.getInstance().numberOfRegulatorDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 1:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfCapacitorbankDefect.add(position, GlobalData.getInstance().numberOfCapacitorbankDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 2:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfRecloserDefect.add(position, GlobalData.getInstance().numberOfRecloserDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 3:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfLoadBreakSwitchDefect.add(position, GlobalData.getInstance().numberOfLoadBreakSwitchDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
        }
        return isCountAdded;
    }
    private void manupilateHorizontalListDataSpl(final String scope,Context mContext, int position) {

        horizontalItemSelectedPosition = 0;
        switch (position) {
            case 0:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfRegulatorDefects);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 1:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfCapacitorbankDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 2:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfRecloserDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 3:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfLoadBreakSwitchDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;

        }

    }

    private ArrayList<InspectionMetaData> loadBreakSwitchReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return SplEquipmentData.getInstance().loadBreakSwitchOne;
            case 1:
                return SplEquipmentData.getInstance().loadBreakSwitchTwo;
            case 2:
                return SplEquipmentData.getInstance().loadBreakSwitchThree;
            case 3:
                return SplEquipmentData.getInstance().loadBreakSwitchFour;
            case 4:
                return SplEquipmentData.getInstance().loadBreakSwitchFive;
            case 5:
                return SplEquipmentData.getInstance().loadBreakSwitchSix;
            case 6:
                return SplEquipmentData.getInstance().loadBreakSwitchSeven;
            case 7:
                return SplEquipmentData.getInstance().loadBreakSwitchEight;
            case 8:
                return SplEquipmentData.getInstance().loadBreakSwitchNine;
            case 9:
                return SplEquipmentData.getInstance().loadBreakSwitchTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> recloserReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return SplEquipmentData.getInstance().recloserOne;
            case 1:
                return SplEquipmentData.getInstance().recloserTwo;
            case 2:
                return SplEquipmentData.getInstance().recloserThree;
            case 3:
                return SplEquipmentData.getInstance().recloserFour;
            case 4:
                return SplEquipmentData.getInstance().recloserFive;
            case 5:
                return SplEquipmentData.getInstance().recloserSix;
            case 6:
                return SplEquipmentData.getInstance().recloserSeven;
            case 7:
                return SplEquipmentData.getInstance().recloserEight;
            case 8:
                return SplEquipmentData.getInstance().recloserNine;
            case 9:
                return SplEquipmentData.getInstance().recloserTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> capacitorBankReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return SplEquipmentData.getInstance().capacitorBankOne;
            case 1:
                return SplEquipmentData.getInstance().capacitorBankTwo;
            case 2:
                return SplEquipmentData.getInstance().capacitorBankThree;
            case 3:
                return SplEquipmentData.getInstance().capacitorBankFour;
            case 4:
                return SplEquipmentData.getInstance().capacitorBankFive;
            case 5:
                return SplEquipmentData.getInstance().capacitorBankSix;
            case 6:
                return SplEquipmentData.getInstance().capacitorBankSeven;
            case 7:
                return SplEquipmentData.getInstance().capacitorBankEight;
            case 8:
                return SplEquipmentData.getInstance().capacitorBankNine;
            case 9:
                return SplEquipmentData.getInstance().capacitorBankTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> regulatorReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return SplEquipmentData.getInstance().regulatorOne;
            case 1:
                return SplEquipmentData.getInstance().regulatorTwo;
            case 2:
                return SplEquipmentData.getInstance().regulatorThree;
            case 3:
                return SplEquipmentData.getInstance().regulatorFour;
            case 4:
                return SplEquipmentData.getInstance().regulatorFive;
            case 5:
                return SplEquipmentData.getInstance().regulatorSix;
            case 6:
                return SplEquipmentData.getInstance().regulatorSeven;
            case 7:
                return SplEquipmentData.getInstance().regulatorEight;
            case 8:
                return SplEquipmentData.getInstance().regulatorNine;
            case 9:
                return SplEquipmentData.getInstance().regulatorTen;
            default:
                return null;
        }
    }
    public void ShowSplDialog(final String scope,final Context mContext, final GridItem item,final ImageView imgView, final int gridPosition) {
        gridPositionNew = gridPosition;
        gridTitle = item.getTitle();
      //  isListSelected = true; isAddNoteSelected = true; isRepairSelected = true; isVoltageTestingSelected = true; isTestingImageSelected = true;
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
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = true;
                isReplaceSelected = false;
                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = false;
                isReplaceSelected = true;
                addExtentToRespectiveCountList(scope,gridTitle, "REPLACE");
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

                String noteString = readNoteFromRespectiveCountList(scope,gridPosition);

                if(noteString!=null) {
                    comments.setText(noteString);
                    dialog_comment.setText(noteString.trim());
                }
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        comments.setText(dialog_comment.getText().toString());
                        addNoteToRespectiveCountList(scope,gridTitle, dialog_comment.getText().toString());
                        if(dialog_comment.getText().toString() != null && !dialog_comment.getText().toString().isEmpty())
                            isAddNoteSelected = false;

                        dialog2.dismiss();
                    }
                });
            }
        });

        manupilateHorizontalListDataSpl(scope,mContext, gridPosition);
        closeBtn = (Button)view.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);
        partImage = (ImageView)view.findViewById(R.id.clickPicture) ;
        readImagesForRespectiveDefects(scope,mContext, partImage);
        partImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  picturePath =item.getS3ImageName();
                picturePath =scope+"-DETAIL-"+item.getName()+"-"+horizontalItemSelectedPosition;
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
                if(!isListSelected ||!isAddNoteSelected ||!isTestingImageSelected|| isRepairSelected ||isReplaceSelected){
                    try {
                        Log.i("vidisha","helloooooooooo"+isAddNoteSelected);
                        item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/pole_equipment_done.png");
                        item.setInspectionDone(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Log.i("vidisha","imageName=="+item.getImageName());
                    item.setInspectionDone(false);
                    item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/"+item.getImageName()+".png");

                }
                if(mGridAdapter!=null)
                    mGridAdapter.notifyDataSetChanged();
                Picasso.with(SelectedItems.this).load(item.getImage())
                        .into(imgView);

                String key = item.getTitle()+scope+"ListJSON";
                Gson gson = new Gson();
                String json = gson.toJson(underground_inspectionData_list);

                if(GlobalData.metadataPreferencesEditor!=null) {
                    GlobalData.metadataPreferencesEditor.remove(key).commit();
                    GlobalData.metadataPreferencesEditor.putString(key, json);
                    GlobalData.metadataPreferencesEditor.commit();
                }

                String key1 = "splKey";
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(mGridData_pole);
                GlobalData.metadataPreferencesEditor.putString(key1, json1);
                GlobalData.metadataPreferencesEditor.commit();
                dialog.dismiss();
            }
        });

        TextView itemName = (TextView)view.findViewById(R.id.dataHeading) ;
        itemName.setText(item.getTitle());
        itemName.setTypeface(typeFace);
        listView = (ListView) view.findViewById(R.id.inspectionData_list);



        RelativeLayout layoutType= (RelativeLayout)view.findViewById(R.id.typeAsset) ;





        populateListView_Spl(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
        String extentString = readExtentFromRespectiveCountList(scope,gridPosition);
        String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
        if(extentString!=null) {
            if(extentString.equalsIgnoreCase("REPAIR")) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
            }else
            {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }

        } else {
            repaire.setBackgroundResource(R.drawable.repaire_replace_active);
            repaire.setTextColor(Color.parseColor("#FFFFFF"));
            replace.setBackgroundResource(R.drawable.repair_replace_deactive);
            replace.setTextColor(Color.parseColor("#3EA99F"));
            addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

        }
        Log.i("vidisha","note=="+noteString);
        if(noteString!=null) {
            comments.setText(noteString.trim());
        } else {
            comments.setText("");
        }
        horizontalListView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                horizontalListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean isCountAdd;
                        isCountAdd = addRespectiveDefectCountSpl(position, gridPosition);
                        if (!isCountAdd && recyclerCountAdapter.getItemCount() <= 10) {
                            horizontalItemSelectedPosition = position;
                            recyclerCountAdapter.notifyDataSetChanged();
                            populateListView_Spl(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
                            readImagesForRespectiveDefects(scope,mContext, partImage);
                            String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
                            if(noteString!=null) {
                                comments.setText(noteString.trim());
                            } else {
                                comments.setText("");
                            }
                            String extentString = readExtentFromRespectiveCountList(scope,gridPosition);

                            if(extentString!=null) {
                                if(extentString.equalsIgnoreCase("REPAIR")) {
                                    repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                    repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                    replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    replace.setTextColor(Color.parseColor("#3EA99F"));
                                }else
                                {
                                    replace.setBackgroundResource(R.drawable.repaire_replace_active);
                                    replace.setTextColor(Color.parseColor("#FFFFFF"));
                                    repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    repaire.setTextColor(Color.parseColor("#3EA99F"));
                                }

                            }else
                            {
                                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                replace.setTextColor(Color.parseColor("#3EA99F"));
                                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");
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
                    localInspectionMetaData = findingListRefferenceSpl(scope,gridPosition, horizontalItemSelectedPosition);
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
/**********************************************SCOPE SPL ENDS*****************************************************/

    /**********************************************SCOPE OTHERS STARTS*****************************************************/

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
    private ArrayList<InspectionMetaData> findingListRefference(String scope,int gridPosition, int horizontalItemSelectedPosition) {

        if (gridPosition == 0) {
            return padmountsReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 1) {
            return pullBoxReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 2) {
            return spiceBoxReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 3) {
            return sectionalizerCabinetReference(horizontalItemSelectedPosition);
        } else {
            return null;
        }

    }
    private void populateListView(final String scope,Context mContext,GridItem item, int gridPosition, int horizontalItemSelectedPosition/*, ImageView chk, RelativeLayout pendingInspectionLayout*/) {
        Boolean isChoosen = false;
        int localIndex = -1;
        ArrayList<InspectionMetaData> underground_inspectionData_list ;
        underground_inspectionData_list = findingListRefference(scope,gridPosition, horizontalItemSelectedPosition);
        try {
            if ( underground_inspectionData_list.size() == 0){
                Gson undergroundMetadataGsonList = new Gson();
                String response = GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","");

                final ArrayList<InspectionMetaData> undergroundListItems_ArrayList = undergroundMetadataGsonList.fromJson(response,
                        new TypeToken<List<InspectionMetaData>>(){}.getType());

                if(undergroundListItems_ArrayList!=null) {
                    underground_inspectionData_list = undergroundListItems_ArrayList;
                    undergroundMetadataJsonArrayList = new JSONArray(GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","").trim());
                } else {
//                underground_inspectionData_list = new ArrayList<>();
                    JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                    undergroundMetadataJsonArrayList = j;

                    underground_inspectionData_list.clear();
                    for(int s =0;s<undergroundMetadataJsonArrayList.length();s++) {
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
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
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
    private void manupilateHorizontalListData(final String scope,Context mContext, int position) {

        horizontalItemSelectedPosition = 0;
        switch (position) {
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

    public void ShowOthersDialog(final String scope,final Context mContext, final GridItem item,final ImageView imgView, final int gridPosition) {
        gridPositionNew = gridPosition;
        gridTitle = item.getTitle();
      //isListSelected = true; isAddNoteSelected = true; isRepairSelected = true; isVoltageTestingSelected = true; isTestingImageSelected = true;
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
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = true;
                isReplaceSelected = false;
                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = false;
                isReplaceSelected = true;
                addExtentToRespectiveCountList(scope,gridTitle, "REPLACE");
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

                String noteString = readNoteFromRespectiveCountList(scope,gridPosition);

                if(noteString!=null) {
                    comments.setText(noteString);
                    dialog_comment.setText(noteString.trim());
                }
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        comments.setText(dialog_comment.getText().toString());
                        addNoteToRespectiveCountList(scope,gridTitle, dialog_comment.getText().toString());
                        if(dialog_comment.getText().toString() != null && !dialog_comment.getText().toString().isEmpty())
                            isAddNoteSelected = false;

                        dialog2.dismiss();
                    }
                });
            }
        });

        manupilateHorizontalListData(scope,mContext, gridPosition);
        closeBtn = (Button)view.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);
        partImage = (ImageView)view.findViewById(R.id.clickPicture) ;
        readImagesForRespectiveDefects(scope,mContext, partImage);
        partImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  picturePath =item.getS3ImageName();
                picturePath =scope+"-DETAIL-"+item.getName()+"-"+horizontalItemSelectedPosition;
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
                if(!isListSelected ||!isAddNoteSelected ||!isTestingImageSelected||isRepairSelected ||isReplaceSelected){
                    try {
                        Log.i("vidisha","helloooooooooo"+isAddNoteSelected);
                        item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/other_done.png");
                        item.setInspectionDone(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Log.i("vidisha","imageName=="+item.getImageName());
                    item.setInspectionDone(false);
                    item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/"+item.getImageName()+".png");

                }
                if(mGridAdapter!=null)
                    mGridAdapter.notifyDataSetChanged();
                Picasso.with(SelectedItems.this).load(item.getImage())
                        .into(imgView);

                String key = item.getTitle()+scope+"ListJSON";
                Gson gson = new Gson();
                String json = gson.toJson(underground_inspectionData_list);

                if(GlobalData.metadataPreferencesEditor!=null) {
                    GlobalData.metadataPreferencesEditor.remove(key).commit();
                    GlobalData.metadataPreferencesEditor.putString(key, json);
                    GlobalData.metadataPreferencesEditor.commit();
                }

                String key1 = "othersKey";
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(mGridData_pole);
                GlobalData.metadataPreferencesEditor.putString(key1, json1);
                GlobalData.metadataPreferencesEditor.commit();
                dialog.dismiss();
            }
        });

        TextView itemName = (TextView)view.findViewById(R.id.dataHeading) ;
        itemName.setText(item.getTitle());
        itemName.setTypeface(typeFace);
        listView = (ListView) view.findViewById(R.id.inspectionData_list);



        RelativeLayout layoutType= (RelativeLayout)view.findViewById(R.id.typeAsset) ;





        populateListView(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
        String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
        if(noteString!=null) {
            comments.setText(noteString.trim());
        } else {
            comments.setText("");
        }
        String extentString = readExtentFromRespectiveCountList(scope,gridPosition);
        if(extentString!=null) {
            if(extentString.equalsIgnoreCase("REPAIR")) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
            }else
            {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }

        } else {
            repaire.setBackgroundResource(R.drawable.repaire_replace_active);
            repaire.setTextColor(Color.parseColor("#FFFFFF"));
            replace.setBackgroundResource(R.drawable.repair_replace_deactive);
            replace.setTextColor(Color.parseColor("#3EA99F"));
            addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

        }
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
                            populateListView(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
                            readImagesForRespectiveDefects(scope,mContext, partImage);
                            String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
                            if(noteString!=null) {
                                comments.setText(noteString.trim());
                            } else {
                                comments.setText("");
                            }

                            String extentString = readExtentFromRespectiveCountList(scope,gridPosition);

                            if(extentString!=null) {
                                if(extentString.equalsIgnoreCase("REPAIR")) {
                                    repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                    repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                    replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    replace.setTextColor(Color.parseColor("#3EA99F"));
                                }else
                                {
                                    replace.setBackgroundResource(R.drawable.repaire_replace_active);
                                    replace.setTextColor(Color.parseColor("#FFFFFF"));
                                    repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    repaire.setTextColor(Color.parseColor("#3EA99F"));
                                }

                            }else
                            {
                                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                replace.setTextColor(Color.parseColor("#3EA99F"));
                                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");
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
                    localInspectionMetaData = findingListRefference(scope,gridPosition, horizontalItemSelectedPosition);
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
/**********************************************SCOPE OTHERS ENDS*****************************************************/


    /**********************************************SCOPE POLE TOP STARTS*****************************************************/

    public void instantiateListWithData_PoleTop() {
            GlobalData.getInstance().numberOfTransformerDefects = new ArrayList<String>();
            GlobalData.getInstance().numberOfCrossArmDefect = new ArrayList<String>();
            GlobalData.getInstance().numberOfFusedCutOutDefect = new ArrayList<String>();
            GlobalData.getInstance().numberOfStreetLightDefect = new ArrayList<String>();
            GlobalData.getInstance().numberOfPoleTopPinDefect = new ArrayList<String>();
            GlobalData.getInstance().numberOfInsulatorDefect = new ArrayList<String>();
            GlobalData.getInstance().numberOfServiceWireDefect = new ArrayList<String>();

            GlobalData.getInstance().numberOfTransformerDefects.add("1");
            GlobalData.getInstance().numberOfTransformerDefects.add("+");

            GlobalData.getInstance().numberOfCrossArmDefect.add("1");
            GlobalData.getInstance().numberOfCrossArmDefect.add("+");

            GlobalData.getInstance().numberOfFusedCutOutDefect.add("1");
            GlobalData.getInstance().numberOfFusedCutOutDefect.add("+");



            GlobalData.getInstance().numberOfStreetLightDefect.add("1");
            GlobalData.getInstance().numberOfStreetLightDefect.add("+");

            GlobalData.getInstance().numberOfPoleTopPinDefect.add("1");
            GlobalData.getInstance().numberOfPoleTopPinDefect.add("+");

            GlobalData.getInstance().numberOfInsulatorDefect.add("1");
            GlobalData.getInstance().numberOfInsulatorDefect.add("+");

            GlobalData.getInstance().numberOfServiceWireDefect.add("1");
            GlobalData.getInstance().numberOfServiceWireDefect.add("+");

    }
    private ArrayList<InspectionMetaData> findingListRefferencePoleTop(String scope,int gridPosition, int horizontalItemSelectedPosition) {

            if (gridPosition == 0) {
                return transtormReference(horizontalItemSelectedPosition);
            } else if (gridPosition == 1) {
                return crossArmReference(horizontalItemSelectedPosition);
            } else if (gridPosition == 2) {
                return fusedCutOutReference(horizontalItemSelectedPosition);
            }else if (gridPosition == 3) {
                return streetLightReference(horizontalItemSelectedPosition);
            }else if (gridPosition == 4) {
                return poleTopPinReference(horizontalItemSelectedPosition);
            }else if (gridPosition == 5) {
                return insulatorReference(horizontalItemSelectedPosition);
            }else if (gridPosition == 6) {
                return guyWireWireReference(horizontalItemSelectedPosition);
            }
            else {
                return null;
            }

        }
    private void populateListViewPoleTop(final String scope,Context mContext,GridItem item, int gridPosition, int horizontalItemSelectedPosition/*, ImageView chk, RelativeLayout pendingInspectionLayout*/) {
        Boolean isChoosen = false;
        int localIndex = -1;
        ArrayList<InspectionMetaData> underground_inspectionData_list ;
        underground_inspectionData_list = findingListRefferencePoleTop(scope,gridPosition, horizontalItemSelectedPosition);
        try {
            if ( underground_inspectionData_list.size() == 0){
                Gson undergroundMetadataGsonList = new Gson();
                String response = GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","");

                final ArrayList<InspectionMetaData> undergroundListItems_ArrayList = undergroundMetadataGsonList.fromJson(response,
                        new TypeToken<List<InspectionMetaData>>(){}.getType());

                if(undergroundListItems_ArrayList!=null) {
                    underground_inspectionData_list = undergroundListItems_ArrayList;
                    undergroundMetadataJsonArrayList = new JSONArray(GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","").trim());
                } else {
//                underground_inspectionData_list = new ArrayList<>();
                    JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                    undergroundMetadataJsonArrayList = j;

                    underground_inspectionData_list.clear();
                    for(int s =0;s<undergroundMetadataJsonArrayList.length();s++) {
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
    private ArrayList<InspectionMetaData> guyWireWireReference(int position) {
        switch (position) {
            case 0:
                return PoleTopEquipmentData.getInstance().serviceWireOne;

            case 1:
                return PoleTopEquipmentData.getInstance().serviceWireTwo;

            case 2:
                return PoleTopEquipmentData.getInstance().serviceWireThree;

            case 3:
                return PoleTopEquipmentData.getInstance().serviceWireFour;

            case 4:
                return PoleTopEquipmentData.getInstance().serviceWireFive;

            case 5:
                return PoleTopEquipmentData.getInstance().serviceWireSix;

            case 6:
                return PoleTopEquipmentData.getInstance().serviceWireSeven;

            case 7:
                return PoleTopEquipmentData.getInstance().serviceWireEight;

            case 8:
                return PoleTopEquipmentData.getInstance().serviceWireNine;

            case 9:
                return PoleTopEquipmentData.getInstance().serviceWireTen;

            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> insulatorReference(int position) {
        switch (position) {
            case 0:
                return PoleTopEquipmentData.getInstance().insulatorOne;

            case 1:
                return PoleTopEquipmentData.getInstance().insulatorTwo;

            case 2:
                return PoleTopEquipmentData.getInstance().insulatorThree;

            case 3:
                return PoleTopEquipmentData.getInstance().insulatorFour;

            case 4:
                return PoleTopEquipmentData.getInstance().insulatorFive;

            case 5:
                return PoleTopEquipmentData.getInstance().insulatorSix;

            case 6:
                return PoleTopEquipmentData.getInstance().insulatorSeven;

            case 7:
                return PoleTopEquipmentData.getInstance().insulatorEight;

            case 8:
                return PoleTopEquipmentData.getInstance().insulatorNine;

            case 9:
                return PoleTopEquipmentData.getInstance().insulatorTen;

            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> poleTopPinReference(int position) {
        switch (position) {
            case 0:
                return PoleTopEquipmentData.getInstance().poleTopPinOne;

            case 1:
                return PoleTopEquipmentData.getInstance().poleTopPinTwo;

            case 2:
                return PoleTopEquipmentData.getInstance().poleTopPinThree;

            case 3:
                return PoleTopEquipmentData.getInstance().poleTopPinFour;

            case 4:
                return PoleTopEquipmentData.getInstance().poleTopPinFive;

            case 5:
                return PoleTopEquipmentData.getInstance().poleTopPinSix;

            case 6:
                return PoleTopEquipmentData.getInstance().poleTopPinSeven;

            case 7:
                return PoleTopEquipmentData.getInstance().poleTopPinEight;

            case 8:
                return PoleTopEquipmentData.getInstance().poleTopPinNine;

            case 9:
                return PoleTopEquipmentData.getInstance().poleTopPinTen;

            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> streetLightReference(int position) {
        switch (position) {
            case 0:
                return PoleTopEquipmentData.getInstance().streetlightOne;

            case 1:
                return PoleTopEquipmentData.getInstance().streetlightTwo;

            case 2:
                return PoleTopEquipmentData.getInstance().streetlightThree;

            case 3:
                return PoleTopEquipmentData.getInstance().streetlightFour;

            case 4:
                return PoleTopEquipmentData.getInstance().streetlightFive;

            case 5:
                return PoleTopEquipmentData.getInstance().streetlightSix;

            case 6:
                return PoleTopEquipmentData.getInstance().streetlightSeven;

            case 7:
                return PoleTopEquipmentData.getInstance().streetlightEight;

            case 8:
                return PoleTopEquipmentData.getInstance().streetlightNine;

            case 9:
                return PoleTopEquipmentData.getInstance().streetlightTen;

            default:
                return null;
        }
    }


    private ArrayList<InspectionMetaData> fusedCutOutReference(int position) {
        switch (position) {
            case 0:
                return PoleTopEquipmentData.getInstance().fusedCutOne;

            case 1:
                return PoleTopEquipmentData.getInstance().fusedCutTwo;

            case 2:
                return PoleTopEquipmentData.getInstance().fusedCutThree;

            case 3:
                return PoleTopEquipmentData.getInstance().fusedCutFour;

            case 4:
                return PoleTopEquipmentData.getInstance().fusedCutFive;

            case 5:
                return PoleTopEquipmentData.getInstance().fusedCutSix;

            case 6:
                return PoleTopEquipmentData.getInstance().fusedCutSeven;

            case 7:
                return PoleTopEquipmentData.getInstance().fusedCutEight;

            case 8:
                return PoleTopEquipmentData.getInstance().fusedCutNine;

            case 9:
                return PoleTopEquipmentData.getInstance().fusedCutTen;

            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> crossArmReference(int position) {
        switch (position) {
            case 0:
                return PoleTopEquipmentData.getInstance().crossArmOne;

            case 1:
                return PoleTopEquipmentData.getInstance().crossArmTwo;

            case 2:
                return PoleTopEquipmentData.getInstance().crossArmThree;

            case 3:
                return PoleTopEquipmentData.getInstance().crossArmFour;

            case 4:
                return PoleTopEquipmentData.getInstance().crossArmFive;

            case 5:
                return PoleTopEquipmentData.getInstance().crossArmSix;

            case 6:
                return PoleTopEquipmentData.getInstance().crossArmSeven;

            case 7:
                return PoleTopEquipmentData.getInstance().crossArmEight;

            case 8:
                return PoleTopEquipmentData.getInstance().crossArmNine;

            case 9:
                return PoleTopEquipmentData.getInstance().crossArmTen;

            default:
                return null;
        }

    }

    private ArrayList<InspectionMetaData> transtormReference(int position) {
        switch (position) {
            case 0:
                return PoleTopEquipmentData.getInstance().transformerOne;

            case 1:
                return PoleTopEquipmentData.getInstance().transformerTwo;

            case 2:
                return PoleTopEquipmentData.getInstance().transformerThree;

            case 3:
                return PoleTopEquipmentData.getInstance().transformerFour;

            case 4:
                return PoleTopEquipmentData.getInstance().transformerFive;

            case 5:
                return PoleTopEquipmentData.getInstance().transformerSix;

            case 6:
                return PoleTopEquipmentData.getInstance().transformerSeven;

            case 7:
                return PoleTopEquipmentData.getInstance().transformerEight;

            case 8:
                return PoleTopEquipmentData.getInstance().transformerNine;

            case 9:
                return PoleTopEquipmentData.getInstance().transformerTen;

            default:
                return null;
        }
    }
    private boolean addRespectiveDefectCountPoleTop(int position, int itemPosition) {
        boolean isCountAdded = false;
        switch (itemPosition) {
            case 0:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfTransformerDefects.add(position, GlobalData.getInstance().numberOfTransformerDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 1:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfCrossArmDefect.add(position, GlobalData.getInstance().numberOfCrossArmDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 2:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfFusedCutOutDefect.add(position, GlobalData.getInstance().numberOfFusedCutOutDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;

            case 3:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfStreetLightDefect.add(position, GlobalData.getInstance().numberOfStreetLightDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 4:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfPoleTopPinDefect.add(position, GlobalData.getInstance().numberOfPoleTopPinDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 5:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfInsulatorDefect.add(position, GlobalData.getInstance().numberOfInsulatorDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;

            case 6:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfServiceWireDefect.add(position, GlobalData.getInstance().numberOfServiceWireDefect.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;


        }
        return isCountAdded;
    }
    private void manupilateHorizontalListDataPoleTop(String scope,Context context, int position) {
        horizontalItemSelectedPosition = 0;
        switch (position) {
            case 0:
                recyclerCountAdapter = new CountAdapter(context, GlobalData.getInstance().numberOfTransformerDefects);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 1:
                recyclerCountAdapter = new CountAdapter(context, GlobalData.getInstance().numberOfCrossArmDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 2:
                recyclerCountAdapter = new CountAdapter(context, GlobalData.getInstance().numberOfFusedCutOutDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 3:
                recyclerCountAdapter = new CountAdapter(context, GlobalData.getInstance().numberOfStreetLightDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 4:
                recyclerCountAdapter = new CountAdapter(context, GlobalData.getInstance().numberOfPoleTopPinDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 5:
                recyclerCountAdapter = new CountAdapter(context, GlobalData.getInstance().numberOfInsulatorDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 6:
                recyclerCountAdapter = new CountAdapter(context, GlobalData.getInstance().numberOfServiceWireDefect);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
        }
    }

    public void ShowPoleTopDialog(final String scope,final Context mContext, final GridItem item,final ImageView imgView, final int gridPosition) {
        gridPositionNew = gridPosition;
        gridTitle = item.getTitle();
        //isListSelected = true; isAddNoteSelected = true; isRepairSelected = true; isVoltageTestingSelected = true; isTestingImageSelected = true;
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
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = true;
                isReplaceSelected = false;
                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = false;
                isReplaceSelected = true;
                addExtentToRespectiveCountList(scope,gridTitle, "REPLACE");
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

                String noteString = readNoteFromRespectiveCountList(scope,gridPosition);

                if(noteString!=null) {
                    comments.setText(noteString);
                    dialog_comment.setText(noteString.trim());
                }
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        comments.setText(dialog_comment.getText().toString());
                        addNoteToRespectiveCountList(scope,gridTitle, dialog_comment.getText().toString());
                        if(dialog_comment.getText().toString() != null && !dialog_comment.getText().toString().isEmpty())
                            isAddNoteSelected = false;

                        dialog2.dismiss();
                    }
                });
            }
        });

        manupilateHorizontalListDataPoleTop(scope,mContext, gridPosition);
        closeBtn = (Button)view.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);
        partImage = (ImageView)view.findViewById(R.id.clickPicture) ;
        readImagesForRespectiveDefects(scope,mContext, partImage);
        partImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  picturePath =item.getS3ImageName();
                picturePath =scope+"-DETAIL-"+item.getName()+"-"+horizontalItemSelectedPosition;
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
                if(!isListSelected ||!isAddNoteSelected ||!isTestingImageSelected||isRepairSelected ||isReplaceSelected){
                    try {
                        Log.i("vidisha","helloooooooooo"+isAddNoteSelected);
                        item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/pole_top_done.png");
                        item.setInspectionDone(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Log.i("vidisha","imageName=="+item.getImageName());
                    item.setInspectionDone(false);
                    item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/"+item.getImageName()+".png");

                }
                if(mGridAdapter!=null)
                    mGridAdapter.notifyDataSetChanged();
                Picasso.with(SelectedItems.this).load(item.getImage())
                        .into(imgView);

                String key = item.getTitle()+scope+"ListJSON";
                Gson gson = new Gson();
                String json = gson.toJson(underground_inspectionData_list);

                if(GlobalData.metadataPreferencesEditor!=null) {
                    GlobalData.metadataPreferencesEditor.remove(key).commit();
                    GlobalData.metadataPreferencesEditor.putString(key, json);
                    GlobalData.metadataPreferencesEditor.commit();
                }

                String key1 = "poleTopKey";
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(mGridData_pole);
                GlobalData.metadataPreferencesEditor.putString(key1, json1);
                GlobalData.metadataPreferencesEditor.commit();
                dialog.dismiss();
            }
        });

        TextView itemName = (TextView)view.findViewById(R.id.dataHeading) ;
        itemName.setText(item.getTitle());
        itemName.setTypeface(typeFace);
        listView = (ListView) view.findViewById(R.id.inspectionData_list);



        RelativeLayout layoutType= (RelativeLayout)view.findViewById(R.id.typeAsset) ;





        populateListViewPoleTop(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
        String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
        if(noteString!=null) {
            comments.setText(noteString.trim());
        } else {
            comments.setText("");
        }
        String extentString = readExtentFromRespectiveCountList(scope,gridPosition);
        if(extentString!=null) {
            if(extentString.equalsIgnoreCase("REPAIR")) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
            }else
            {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }

        } else {
            repaire.setBackgroundResource(R.drawable.repaire_replace_active);
            repaire.setTextColor(Color.parseColor("#FFFFFF"));
            replace.setBackgroundResource(R.drawable.repair_replace_deactive);
            replace.setTextColor(Color.parseColor("#3EA99F"));
            addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

        }
        horizontalListView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                horizontalListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean isCountAdd;
                        isCountAdd = addRespectiveDefectCountPoleTop(position, gridPosition);
                        if (!isCountAdd && recyclerCountAdapter.getItemCount() <= 10) {
                            horizontalItemSelectedPosition = position;
                            recyclerCountAdapter.notifyDataSetChanged();
                            populateListViewPoleTop(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
                            readImagesForRespectiveDefects(scope,mContext, partImage);
                            String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
                            if(noteString!=null) {
                                comments.setText(noteString.trim());
                            } else {
                                comments.setText("");
                            }

                            String extentString = readExtentFromRespectiveCountList(scope,gridPosition);

                            if(extentString!=null) {
                                if(extentString.equalsIgnoreCase("REPAIR")) {
                                    repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                    repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                    replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    replace.setTextColor(Color.parseColor("#3EA99F"));
                                }else
                                {
                                    replace.setBackgroundResource(R.drawable.repaire_replace_active);
                                    replace.setTextColor(Color.parseColor("#FFFFFF"));
                                    repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    repaire.setTextColor(Color.parseColor("#3EA99F"));
                                }

                            }else
                            {
                                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                replace.setTextColor(Color.parseColor("#3EA99F"));
                                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");
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
                    localInspectionMetaData = findingListRefferencePoleTop(scope,gridPosition, horizontalItemSelectedPosition);
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
/**********************************************SCOPE POLE TOP  ENDS*****************************************************/


    /**********************************************SCOPE WIRE STARTS*****************************************************/

    public void instantiateListWithData_Wire() {
        GlobalData.getInstance().numberOfPrimaryWireDefects = new ArrayList<String>();
        GlobalData.getInstance().numberOfSecondaryWireDefects = new ArrayList<String>();
        GlobalData.getInstance().numberOfServiceWireDefects = new ArrayList<String>();


        GlobalData.getInstance().numberOfPrimaryWireDefects.add("1");
        GlobalData.getInstance().numberOfPrimaryWireDefects.add("+");

        GlobalData.getInstance().numberOfSecondaryWireDefects.add("1");
        GlobalData.getInstance().numberOfSecondaryWireDefects.add("+");

        GlobalData.getInstance().numberOfServiceWireDefects.add("1");
        GlobalData.getInstance().numberOfServiceWireDefects.add("+");

    }
    private ArrayList<InspectionMetaData> findingListRefferenceWire(String scope,int gridPosition, int horizontalItemSelectedPosition) {

        if (gridPosition == 0) {
            return primaryWireReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 1) {
            return secondaryWireReference(horizontalItemSelectedPosition);
        } else if (gridPosition == 2) {
            return serviceWireReference(horizontalItemSelectedPosition);
        } else {
            return null;
        }

    }
    private void populateListViewWire(final String scope,Context mContext,GridItem item, int gridPosition, int horizontalItemSelectedPosition/*, ImageView chk, RelativeLayout pendingInspectionLayout*/) {
        Boolean isChoosen = false;
        int localIndex = -1;
        ArrayList<InspectionMetaData> underground_inspectionData_list ;
        underground_inspectionData_list = findingListRefferenceWire(scope,gridPosition, horizontalItemSelectedPosition);
        try {
            if ( underground_inspectionData_list.size() == 0){
                Gson undergroundMetadataGsonList = new Gson();
                String response = GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","");

                final ArrayList<InspectionMetaData> undergroundListItems_ArrayList = undergroundMetadataGsonList.fromJson(response,
                        new TypeToken<List<InspectionMetaData>>(){}.getType());

                if(undergroundListItems_ArrayList!=null) {
                    underground_inspectionData_list = undergroundListItems_ArrayList;
                    undergroundMetadataJsonArrayList = new JSONArray(GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","").trim());
                } else {
//                underground_inspectionData_list = new ArrayList<>();
                    JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                    undergroundMetadataJsonArrayList = j;

                    underground_inspectionData_list.clear();
                    for(int s =0;s<undergroundMetadataJsonArrayList.length();s++) {
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
    private ArrayList<InspectionMetaData> primaryWireReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return WireData.getInstance().primary_wireOne;
            case 1:
                return WireData.getInstance().primary_wireTwo;
            case 2:
                return WireData.getInstance().primary_wireThree;
            case 3:
                return WireData.getInstance().primary_wireFour;
            case 4:
                return WireData.getInstance().primary_wireFive;
            case 5:
                return WireData.getInstance().primary_wireSix;
            case 6:
                return WireData.getInstance().primary_wireSeven;
            case 7:
                return WireData.getInstance().primary_wireEight;
            case 8:
                return WireData.getInstance().primary_wireNine;
            case 9:
                return WireData.getInstance().primary_wireTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData>secondaryWireReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return WireData.getInstance().secondary_wireOne;
            case 1:
                return WireData.getInstance().secondary_wireTwo;
            case 2:
                return WireData.getInstance().secondary_wireThree;
            case 3:
                return WireData.getInstance().secondary_wireFour;
            case 4:
                return WireData.getInstance().secondary_wireFive;
            case 5:
                return WireData.getInstance().secondary_wireSix;
            case 6:
                return WireData.getInstance().secondary_wireSeven;
            case 7:
                return WireData.getInstance().secondary_wireEight;
            case 8:
                return WireData.getInstance().secondary_wireNine;
            case 9:
                return WireData.getInstance().secondary_wireTen;
            default:
                return null;
        }
    }

    private ArrayList<InspectionMetaData> serviceWireReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition){
            case 0:
                return WireData.getInstance().service_wireOne;
            case 1:
                return WireData.getInstance().service_wireTwo;
            case 2:
                return WireData.getInstance().service_wireThree;
            case 3:
                return WireData.getInstance().service_wireFour;
            case 4:
                return WireData.getInstance().service_wireFive;
            case 5:
                return WireData.getInstance().service_wireSix;
            case 6:
                return WireData.getInstance().service_wireSeven;
            case 7:
                return WireData.getInstance().service_wireEight;
            case 8:
                return WireData.getInstance().service_wireNine;
            case 9:
                return WireData.getInstance().service_wireTen;
            default:
                return null;
        }
    }

    private boolean addRespectiveDefectCountWire(int position, int itemPosition) {
        boolean isCountAdded = false;
        Log.i("vidisha","hhhhhh"+isCountAdded);
        switch (itemPosition) {
            case 0:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfPrimaryWireDefects.add(position, GlobalData.getInstance().numberOfPrimaryWireDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 1:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfSecondaryWireDefects.add(position, GlobalData.getInstance().numberOfSecondaryWireDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;
            case 2:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfServiceWireDefects.add(position, GlobalData.getInstance().numberOfServiceWireDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;

        }
        return isCountAdded;
    }
    private void manupilateHorizontalListDataWire(final String scope,Context mContext, int position) {

        horizontalItemSelectedPosition = 0;
        switch (position) {
            case 0:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfPrimaryWireDefects);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 1:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfSecondaryWireDefects);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;
            case 2:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfServiceWireDefects);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;

        }

    }

    public void ShowWireDialog(final String scope,final Context mContext, final GridItem item,final ImageView imgView, final int gridPosition) {
        gridPositionNew = gridPosition;
        gridTitle = item.getTitle();
        //isListSelected = true; isAddNoteSelected = true; isRepairSelected = true; isVoltageTestingSelected = true; isTestingImageSelected = true;
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
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = true;
                isReplaceSelected = false;
                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = false;
                isReplaceSelected = true;
                addExtentToRespectiveCountList(scope,gridTitle, "REPLACE");
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

                String noteString = readNoteFromRespectiveCountList(scope,gridPosition);

                if(noteString!=null) {
                    comments.setText(noteString);
                    dialog_comment.setText(noteString.trim());
                }
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        comments.setText(dialog_comment.getText().toString());
                        addNoteToRespectiveCountList(scope,gridTitle, dialog_comment.getText().toString());
                        if(dialog_comment.getText().toString() != null && !dialog_comment.getText().toString().isEmpty())
                            isAddNoteSelected = false;

                        dialog2.dismiss();
                    }
                });
            }
        });

        manupilateHorizontalListDataWire(scope,mContext, gridPosition);
        closeBtn = (Button)view.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);
        partImage = (ImageView)view.findViewById(R.id.clickPicture) ;
        readImagesForRespectiveDefects(scope,mContext, partImage);
        partImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  picturePath =item.getS3ImageName();
                picturePath =scope+"-DETAIL-"+item.getName()+"-"+horizontalItemSelectedPosition;
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
                if(!isListSelected ||!isAddNoteSelected ||!isTestingImageSelected||isRepairSelected ||isReplaceSelected){
                    try {
                        Log.i("vidisha","helloooooooooo"+isAddNoteSelected);
                        item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/wire_done.png");
                        item.setInspectionDone(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Log.i("vidisha","imageName=="+item.getImageName());
                    item.setInspectionDone(false);
                    item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/"+item.getImageName()+".png");

                }
                if(mGridAdapter!=null)
                    mGridAdapter.notifyDataSetChanged();
                Picasso.with(SelectedItems.this).load(item.getImage())
                        .into(imgView);

                String key = item.getTitle()+scope+"ListJSON";
                Gson gson = new Gson();
                String json = gson.toJson(underground_inspectionData_list);

                if(GlobalData.metadataPreferencesEditor!=null) {
                    GlobalData.metadataPreferencesEditor.remove(key).commit();
                    GlobalData.metadataPreferencesEditor.putString(key, json);
                    GlobalData.metadataPreferencesEditor.commit();
                }

                String key1 = "wireeKey";
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(mGridData_pole);
                GlobalData.metadataPreferencesEditor.putString(key1, json1);
                GlobalData.metadataPreferencesEditor.commit();
                dialog.dismiss();
            }
        });

        TextView itemName = (TextView)view.findViewById(R.id.dataHeading) ;
        itemName.setText(item.getTitle());
        itemName.setTypeface(typeFace);
        listView = (ListView) view.findViewById(R.id.inspectionData_list);



        RelativeLayout layoutType= (RelativeLayout)view.findViewById(R.id.typeAsset) ;





        populateListViewWire(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
        String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
        if(noteString!=null) {
            comments.setText(noteString.trim());
        } else {
            comments.setText("");
        }
        String extentString = readExtentFromRespectiveCountList(scope,gridPosition);
        if(extentString!=null) {
            if(extentString.equalsIgnoreCase("REPAIR")) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
            }else
            {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }

        } else {
            repaire.setBackgroundResource(R.drawable.repaire_replace_active);
            repaire.setTextColor(Color.parseColor("#FFFFFF"));
            replace.setBackgroundResource(R.drawable.repair_replace_deactive);
            replace.setTextColor(Color.parseColor("#3EA99F"));
            addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

        }
        horizontalListView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                horizontalListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean isCountAdd;
                        isCountAdd = addRespectiveDefectCountWire(position, gridPosition);
                        if (!isCountAdd && recyclerCountAdapter.getItemCount() <= 10) {
                            horizontalItemSelectedPosition = position;
                            recyclerCountAdapter.notifyDataSetChanged();
                            populateListViewWire(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
                            readImagesForRespectiveDefects(scope,mContext, partImage);
                            String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
                            if(noteString!=null) {
                                comments.setText(noteString.trim());
                            } else {
                                comments.setText("");
                            }

                            String extentString = readExtentFromRespectiveCountList(scope,gridPosition);

                            if(extentString!=null) {
                                if(extentString.equalsIgnoreCase("REPAIR")) {
                                    repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                    repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                    replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    replace.setTextColor(Color.parseColor("#3EA99F"));
                                }else
                                {
                                    replace.setBackgroundResource(R.drawable.repaire_replace_active);
                                    replace.setTextColor(Color.parseColor("#FFFFFF"));
                                    repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    repaire.setTextColor(Color.parseColor("#3EA99F"));
                                }

                            }else
                            {
                                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                replace.setTextColor(Color.parseColor("#3EA99F"));
                                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");
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
                    localInspectionMetaData = findingListRefferenceWire(scope,gridPosition, horizontalItemSelectedPosition);
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
/**********************************************SCOPE WIRE ENDS*****************************************************/



/**********************************************SCOPE POLE STARTS*****************************************************/
    public void instantiateListWithData_Pole() {
        GlobalData.getInstance().numberOfPoleDefects = new ArrayList<String>();

        GlobalData.getInstance().numberOfPoleDefects.add("1");
        GlobalData.getInstance().numberOfPoleDefects.add("+");
    }

    private void populateListViewPole(final String scope,Context mContext,GridItem item, int gridPosition, int horizontalItemSelectedPosition/*, ImageView chk, RelativeLayout pendingInspectionLayout*/) {
        Boolean isChoosen = false;
        int localIndex = -1;
        ArrayList<InspectionMetaData> pole_inspectionData_list ;
        pole_inspectionData_list = findingListRefferencePole(scope,gridPosition, horizontalItemSelectedPosition);
        try {
            if ( pole_inspectionData_list.size() == 0){
                Gson poleMetadataGsonList = new Gson();
                String response = GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","");

                final ArrayList<InspectionMetaData> undergroundListItems_ArrayList = poleMetadataGsonList.fromJson(response,
                        new TypeToken<List<InspectionMetaData>>(){}.getType());

                if(undergroundListItems_ArrayList!=null) {
                    pole_inspectionData_list = undergroundListItems_ArrayList;
                    undergroundMetadataJsonArrayList = new JSONArray(GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","").trim());
                } else {
//                pole_inspectionData_list = new ArrayList<>();
                    JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                    undergroundMetadataJsonArrayList = j;

                    pole_inspectionData_list.clear();
                    for(int s =0;s<undergroundMetadataJsonArrayList.length();s++) {
                        String displayName = undergroundMetadataJsonArrayList.getJSONObject(s).get("displayName").toString();

                        String name = undergroundMetadataJsonArrayList.getJSONObject(s).get("name").toString();
                        String imageUrl = undergroundMetadataJsonArrayList.getJSONObject(s).get("imageURL").toString();
                        String imageName =  undergroundMetadataJsonArrayList.getJSONObject(s).get("imagename").toString();
                        pole_inspectionData_list.add(new InspectionMetaData(displayName, name, imageUrl, imageName, false, item.getTitle()));
                    }
                }
//                final JSONObject chkListObject = new JSONObject();
//                final JSONObject chkListObjectPreview = new JSONObject();
            } else {

            }
            arrayAdapter = new InspectionMetaDataAdapter(pole_inspectionData_list,mContext,listView);
            listView.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        } catch (JSONException e){

        }
    }

    private ArrayList<InspectionMetaData> findingListRefferencePole(String scope,int gridPosition, int horizontalItemSelectedPosition) {

        if (gridPosition == 0) {
            return poleReference(horizontalItemSelectedPosition);
        }  else {
            return null;
        }

    }

    private ArrayList<InspectionMetaData> poleReference(int horizontalItemSelectedPosition) {
        switch (horizontalItemSelectedPosition) {
            case 0:
                return PoleData.getInstance().poleOne;
            case 1:
                return PoleData.getInstance().poleTwo;
            case 2:
                return PoleData.getInstance().poleThree;
            case 3:
                return PoleData.getInstance().poleFour;
            case 4:
                return PoleData.getInstance().poleFive;
            case 5:
                return PoleData.getInstance().poleSix;
            case 6:
                return PoleData.getInstance().poleSeven;
            case 7:
                return PoleData.getInstance().poleEight;
            case 8:
                return PoleData.getInstance().poleNine;
            case 9:
                return PoleData.getInstance().poleTen;
            default:
                return null;
        }
    }
    private boolean addRespectiveDefectCount_Pole(int position, int itemPosition) {
        boolean isCountAdded = false;
        Log.i("vidisha","hhhhhh"+isCountAdded);
        switch (itemPosition) {
            case 0:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfPoleDefects.add(position, GlobalData.getInstance().numberOfPoleDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;

        }
        return isCountAdded;
    }

    public void ShowPoleDialog(final String scope,final Context mContext, final GridItem item,final ImageView imgView, final int gridPosition) {
        gridPositionNew = gridPosition;
        gridTitle = item.getTitle();
      //  isListSelected = true; isAddNoteSelected = true; isRepairSelected = true; isVoltageTestingSelected = true; isTestingImageSelected = true;
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
      /*  repaire.setBackgroundResource(R.drawable.repaire_replace_active);
        repaire.setTextColor(Color.parseColor("#FFFFFF"));
        replace.setBackgroundResource(R.drawable.repair_replace_deactive);
        replace.setTextColor(Color.parseColor("#3EA99F"));
*/
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = true;
                isReplaceSelected = false;
                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = false;
                isReplaceSelected = true;
                addExtentToRespectiveCountList(scope,gridTitle, "REPLACE");
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

                String noteString = readNoteFromRespectiveCountList(scope,gridPosition);

                if(noteString!=null) {
                    comments.setText(noteString);
                    dialog_comment.setText(noteString.trim());
                }
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        comments.setText(dialog_comment.getText().toString());
                        addNoteToRespectiveCountList(scope,gridTitle, dialog_comment.getText().toString());
                        if(dialog_comment.getText().toString() != null && !dialog_comment.getText().toString().isEmpty())
                            isAddNoteSelected = false;

                        dialog2.dismiss();
                    }
                });
            }
        });

        manupilateHorizontalListPoleData(scope,mContext, gridPosition);
        closeBtn = (Button)view.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);
        partImage = (ImageView)view.findViewById(R.id.clickPicture) ;
        readImagesForRespectiveDefects(scope,mContext, partImage);
        partImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  picturePath =item.getS3ImageName();
                picturePath =scope+"-DETAIL-"+item.getName()+"-"+horizontalItemSelectedPosition;
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
                if(!isListSelected ||!isAddNoteSelected ||!isTestingImageSelected|| isRepairSelected ||isReplaceSelected){
                    try {
                        Log.i("vidisha","helloooooooooo"+isAddNoteSelected);
                        item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/pole_done.png");
                        item.setInspectionDone(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    Log.i("vidisha","imageName=="+item.getImageName());
                    item.setInspectionDone(false);
                    item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/"+item.getImageName()+".png");

                }
                if(mGridAdapter!=null)
                    mGridAdapter.notifyDataSetChanged();
                Picasso.with(SelectedItems.this).load(item.getImage())
                        .into(imgView);

                String key = item.getTitle()+scope+"ListJSON";
                Gson gson = new Gson();
                String json = gson.toJson(pole_inspectionData_list);

                if(GlobalData.metadataPreferencesEditor!=null) {
                    GlobalData.metadataPreferencesEditor.remove(key).commit();
                    GlobalData.metadataPreferencesEditor.putString(key, json);
                    GlobalData.metadataPreferencesEditor.commit();
                }

                String key1 = "poleKey";
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(mGridData_pole);
                GlobalData.metadataPreferencesEditor.putString(key1, json1);
                GlobalData.metadataPreferencesEditor.commit();
                dialog.dismiss();
            }
        });

        TextView itemName = (TextView)view.findViewById(R.id.dataHeading) ;
        itemName.setText(item.getTitle());
        itemName.setTypeface(typeFace);
        listView = (ListView) view.findViewById(R.id.inspectionData_list);



        RelativeLayout layoutType= (RelativeLayout)view.findViewById(R.id.typeAsset) ;





        populateListViewPole(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
        String extentString = readExtentFromRespectiveCountList(scope,gridPosition);
        String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
        if(extentString!=null) {
            if(extentString.equalsIgnoreCase("REPAIR")) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
            }else
            {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }

        } else {
            repaire.setBackgroundResource(R.drawable.repaire_replace_active);
            repaire.setTextColor(Color.parseColor("#FFFFFF"));
            replace.setBackgroundResource(R.drawable.repair_replace_deactive);
            replace.setTextColor(Color.parseColor("#3EA99F"));
            addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

        }
        Log.i("vidisha","note=="+noteString);
        if(noteString!=null) {
            comments.setText(noteString.trim());
        } else {
            comments.setText("");
        }
        horizontalListView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                horizontalListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean isCountAdd;
                        isCountAdd = addRespectiveDefectCount_Pole(position, gridPosition);
                        if (!isCountAdd && recyclerCountAdapter.getItemCount() <= 10) {
                            horizontalItemSelectedPosition = position;
                            recyclerCountAdapter.notifyDataSetChanged();
                            populateListViewPole(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
                            readImagesForRespectiveDefects(scope,mContext, partImage);
                            String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
                            if(noteString!=null) {
                                comments.setText(noteString.trim());
                            } else {
                                comments.setText("");
                            }

                            String extentString = readExtentFromRespectiveCountList(scope,gridPosition);

                            if(extentString!=null) {
                                if(extentString.equalsIgnoreCase("REPAIR")) {
                                    repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                    repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                    replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    replace.setTextColor(Color.parseColor("#3EA99F"));
                                }else
                                {
                                    replace.setBackgroundResource(R.drawable.repaire_replace_active);
                                    replace.setTextColor(Color.parseColor("#FFFFFF"));
                                    repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    repaire.setTextColor(Color.parseColor("#3EA99F"));
                                }

                            }else
                            {
                                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                replace.setTextColor(Color.parseColor("#3EA99F"));
                                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");
                            }

                        }
                    }
                });
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        try {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    verticalItemSelectedPosition = position;
                    localInspectionMetaData = findingListRefferencePole(scope,gridPosition, horizontalItemSelectedPosition);
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
                                isListSelected = false;
                            } else {
                                Log.i("vidisha","helloo22222");
                                isListSelected = true;
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
    private void manupilateHorizontalListPoleData(final String scope,Context mContext, int position) {

            horizontalItemSelectedPosition = 0;
            switch (position) {
                case 0:
                    recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfPoleDefects);
                    horizontalListView.setAdapter(recyclerCountAdapter);
                    recyclerCountAdapter.notifyDataSetChanged();
                    break;

        }
    }

    /**********************************************SCOPE POLE ENDS*****************************************************/


    /**********************************************SCOPE TREE STARTS*****************************************************/
    public void instantiateListWithData_Tree() {
        GlobalData.getInstance().numberOfTreeDefects = new ArrayList<String>();


        GlobalData.getInstance().numberOfTreeDefects.add("1");
        GlobalData.getInstance().numberOfTreeDefects.add("+");
    }

    private void populateListViewTree(final String scope,Context mContext,GridItem item, int gridPosition, int horizontalItemSelectedPosition/*, ImageView chk, RelativeLayout pendingInspectionLayout*/) {
        Boolean isChoosen = false;
        int localIndex = -1;
        ArrayList<InspectionMetaData> pole_inspectionData_list ;
        pole_inspectionData_list = findingListRefferenceTree(scope,gridPosition, horizontalItemSelectedPosition);
        try {
            if ( pole_inspectionData_list.size() == 0){
                Gson poleMetadataGsonList = new Gson();
                String response = GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","");


                final ArrayList<InspectionMetaData> undergroundListItems_ArrayList = poleMetadataGsonList.fromJson(response,
                        new TypeToken<List<InspectionMetaData>>(){}.getType());

                if(undergroundListItems_ArrayList!=null) {
                    pole_inspectionData_list = undergroundListItems_ArrayList;
                    undergroundMetadataJsonArrayList = new JSONArray(GlobalData.metadataPreferences.getString(item.getTitle()+scope+"ListJSON","").trim());
                } else {
                    Log.i("vidisha","hellooooin ttt"+response);
//                pole_inspectionData_list = new ArrayList<>();
                    JSONArray j = new JSONArray(item.getData().get(item.getTitle()));
                    undergroundMetadataJsonArrayList = j;

                    pole_inspectionData_list.clear();
                    for(int s =0;s<undergroundMetadataJsonArrayList.length();s++) {
                        String displayName = undergroundMetadataJsonArrayList.getJSONObject(s).get("displayName").toString();

                        String name = undergroundMetadataJsonArrayList.getJSONObject(s).get("name").toString();
                        String imageUrl = undergroundMetadataJsonArrayList.getJSONObject(s).get("imageURL").toString();
                        String imageName =  undergroundMetadataJsonArrayList.getJSONObject(s).get("imagename").toString();
                        pole_inspectionData_list.add(new InspectionMetaData(displayName, name, imageUrl, imageName, false, item.getTitle()));
                    }
                }
//                final JSONObject chkListObject = new JSONObject();
//                final JSONObject chkListObjectPreview = new JSONObject();
            } else {

            }
            arrayAdapter = new InspectionMetaDataAdapter(pole_inspectionData_list,mContext,listView);
            listView.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        } catch (JSONException e){

        }
    }

    private ArrayList<InspectionMetaData> findingListRefferenceTree(String scope,int gridPosition, int horizontalItemSelectedPosition) {
        Log.i("under","in tree"+"position"+gridPosition+" "+horizontalItemSelectedPosition);
        if (gridPosition == 0) {
            Log.i("under","in tree return"+treeReference(horizontalItemSelectedPosition));
            return treeReference(horizontalItemSelectedPosition);

        }  else {
            Log.i("under","in tree return nu"+treeReference(horizontalItemSelectedPosition));
            return null;
        }



    }

    private ArrayList<InspectionMetaData> treeReference(int horizontalItemSelectedPosition) {
        Log.i("under","in tree"+"refer");
        switch (horizontalItemSelectedPosition) {
            case 0:
                return TreeData.getInstance().treeOne;
            case 1:
                return TreeData.getInstance().treeTwo;
            case 2:
                return TreeData.getInstance().treeThree;
            case 3:
                return TreeData.getInstance().treeFour;
            case 4:
                return TreeData.getInstance().treeFive;
            case 5:
                return TreeData.getInstance().treeSix;
            case 6:
                return TreeData.getInstance().treeSeven;
            case 7:
                return TreeData.getInstance().treeEight;
            case 8:
                return TreeData.getInstance().treeNine;
            case 9:
                return TreeData.getInstance().treeTen;
            default:
                return null;
        }
    }
    private boolean addRespectiveDefectCount_Tree(int position, int itemPosition) {
        boolean isCountAdded = false;
        Log.i("vidisha","hhhhhh"+isCountAdded);
        switch (itemPosition) {
            case 0:
                if (recyclerCountAdapter.getItemCount() == (position + 1) && position <= 9) {
                    isCountAdded = true;
                    GlobalData.getInstance().numberOfTreeDefects.add(position, GlobalData.getInstance().numberOfTreeDefects.size());
                    recyclerCountAdapter.notifyItemInserted(position);
                    recyclerCountAdapter.notifyDataSetChanged();
                }
                break;

        }
        return isCountAdded;
    }

    public void ShowTreeDialog(final String scope,final Context mContext, final GridItem item,final ImageView imgView, final int gridPosition) {
        gridPositionNew = gridPosition;
        gridTitle = item.getTitle();
      //  isListSelected = true; isAddNoteSelected = true; isRepairSelected = true; isVoltageTestingSelected = true; isTestingImageSelected = true;
        mGridDataJSON = new ArrayList<>();


        sharedPref = mContext.getSharedPreferences(mContext.getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);


        Log.i("under","in tree"+item.getTitle());
        final Dialog dialog = new Dialog(mContext, R.style.Theme_Dialog);
        View view = LayoutInflater.from(mContext).inflate(R.layout.test_layout, null);

        horizontalListView = (RecyclerView) view.findViewById(R.id.recyler_count_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        horizontalListView.setLayoutManager(linearLayoutManager);

        Log.i("under","in tree"+"11111111");

        final EditText comments = view.findViewById(R.id.comments);

        final TextView repaire = view.findViewById(R.id.repair);
        final TextView replace = view.findViewById(R.id.replace);
        repaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = true;
                isReplaceSelected = false;
                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
                isRepairSelected = false;
                isReplaceSelected = true;
                addExtentToRespectiveCountList(scope,gridTitle, "REPLACE");
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

                String noteString = readNoteFromRespectiveCountList(scope,gridPosition);

                if(noteString!=null) {
                    comments.setText(noteString);
                    dialog_comment.setText(noteString.trim());
                }
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        comments.setText(dialog_comment.getText().toString());
                        addNoteToRespectiveCountList(scope,gridTitle, dialog_comment.getText().toString());
                        if(dialog_comment.getText().toString() != null && !dialog_comment.getText().toString().isEmpty())
                            isAddNoteSelected = false;

                        dialog2.dismiss();
                    }
                });
            }
        });

        manupilateHorizontalListTreeData(scope,mContext, gridPosition);
        Log.i("under","in tree"+"33333333333");
        closeBtn = (Button)view.findViewById(R.id.closeButton) ;
        closeBtn.setTypeface(typeFace);
        partImage = (ImageView)view.findViewById(R.id.clickPicture) ;
        readImagesForRespectiveDefects(scope,mContext, partImage);
        partImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  picturePath =item.getS3ImageName();
                picturePath =scope+"-DETAIL-"+item.getName()+"-"+horizontalItemSelectedPosition;
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
                if(!isListSelected ||!isAddNoteSelected ||!isTestingImageSelected|| isRepairSelected ||isReplaceSelected){
                    try {
                        Log.i("vidisha","helloooooooooo"+isAddNoteSelected);
                        item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/tree_done.png");
                        item.setInspectionDone(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    item.setInspectionDone(false);
                    item.setImage("https://s3.amazonaws.com/restore-build-artefacts/VDAIcons/"+item.getImageName()+".png");

                }
                if(mGridAdapter!=null)
                    mGridAdapter.notifyDataSetChanged();
                Picasso.with(SelectedItems.this).load(item.getImage())
                        .into(imgView);

                String key = item.getTitle()+scope+"ListJSON";
                Gson gson = new Gson();
                String json = gson.toJson(pole_inspectionData_list);
           /*     String key1 = "treeKey";
                Gson gson1 = new Gson();
                String json1 = gson1.toJson(mGridData_pole);
*/
                if(GlobalData.metadataPreferencesEditor!=null) {
                    Log.i("vidisha","hellooooin ");
                    GlobalData.metadataPreferencesEditor.remove(key).commit();
                    GlobalData.metadataPreferencesEditor.putString(key, json);
                    GlobalData.metadataPreferencesEditor.commit();
                  /*  GlobalData.metadataPreferencesEditor.remove(key1).commit();
                    GlobalData.metadataPreferencesEditor.putString(key1, json1);
                    GlobalData.metadataPreferencesEditor.commit();*/
                }




                dialog.dismiss();
            }
        });

        TextView itemName = (TextView)view.findViewById(R.id.dataHeading) ;
        itemName.setText(item.getTitle());
        itemName.setTypeface(typeFace);
        listView = (ListView) view.findViewById(R.id.inspectionData_list);



        RelativeLayout layoutType= (RelativeLayout)view.findViewById(R.id.typeAsset) ;





        populateListViewTree(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);

        String extentString = readExtentFromRespectiveCountList(scope,gridPosition);
        String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
        if(extentString!=null) {
            if(extentString.equalsIgnoreCase("REPAIR")) {
                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                replace.setTextColor(Color.parseColor("#3EA99F"));
            }else
            {
                replace.setBackgroundResource(R.drawable.repaire_replace_active);
                replace.setTextColor(Color.parseColor("#FFFFFF"));
                repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                repaire.setTextColor(Color.parseColor("#3EA99F"));
            }

        } else {
            repaire.setBackgroundResource(R.drawable.repaire_replace_active);
            repaire.setTextColor(Color.parseColor("#FFFFFF"));
            replace.setBackgroundResource(R.drawable.repair_replace_deactive);
            replace.setTextColor(Color.parseColor("#3EA99F"));
            addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");

        }
        Log.i("vidisha","note=="+noteString);
        if(noteString!=null) {
            comments.setText(noteString.trim());
        } else {
            comments.setText("");
        }
        horizontalListView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                horizontalListView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean isCountAdd;
                        isCountAdd = addRespectiveDefectCount_Tree(position, gridPosition);
                        if (!isCountAdd && recyclerCountAdapter.getItemCount() <= 10) {
                            horizontalItemSelectedPosition = position;
                            recyclerCountAdapter.notifyDataSetChanged();
                            populateListViewTree(scope,mContext, item, gridPosition, horizontalItemSelectedPosition/*, chk, pendingInspectionLayout*/);
                            readImagesForRespectiveDefects(scope,mContext, partImage);
                            String noteString = readNoteFromRespectiveCountList(scope,gridPosition);
                            if(noteString!=null) {
                                comments.setText(noteString.trim());
                            } else {
                                comments.setText("");
                            }
                            String extentString = readExtentFromRespectiveCountList(scope,gridPosition);

                            if(extentString!=null) {
                                if(extentString.equalsIgnoreCase("REPAIR")) {
                                    repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                    repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                    replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    replace.setTextColor(Color.parseColor("#3EA99F"));
                                }else
                                {
                                    replace.setBackgroundResource(R.drawable.repaire_replace_active);
                                    replace.setTextColor(Color.parseColor("#FFFFFF"));
                                    repaire.setBackgroundResource(R.drawable.repair_replace_deactive);
                                    repaire.setTextColor(Color.parseColor("#3EA99F"));
                                }

                            }else
                            {
                                repaire.setBackgroundResource(R.drawable.repaire_replace_active);
                                repaire.setTextColor(Color.parseColor("#FFFFFF"));
                                replace.setBackgroundResource(R.drawable.repair_replace_deactive);
                                replace.setTextColor(Color.parseColor("#3EA99F"));
                                addExtentToRespectiveCountList(scope,gridTitle, "REPAIR");
                            }
                        }
                    }
                });
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        try {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    verticalItemSelectedPosition = position;
                    localInspectionMetaData = findingListRefferenceTree(scope,gridPosition, horizontalItemSelectedPosition);
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
                                isListSelected = false;
                            } else {
                                Log.i("vidisha","helloo22222");
                                isListSelected = true;
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
    private void manupilateHorizontalListTreeData(final String scope,Context mContext, int position) {

        horizontalItemSelectedPosition = 0;
        switch (position) {
            case 0:
                recyclerCountAdapter = new CountAdapter(mContext, GlobalData.getInstance().numberOfTreeDefects);
                horizontalListView.setAdapter(recyclerCountAdapter);
                recyclerCountAdapter.notifyDataSetChanged();
                break;

        }
    }

    /**********************************************SCOPE TREE ENDS*****************************************************/

    private String readNoteFromRespectiveCountList(String scope,int position) {
        if(scope.equalsIgnoreCase("other")) {
            String note = null;
            if (position == 0) {
                localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 1) {
                localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 2) {
                localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 3) {
                localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
                return findNoteData();
            }
        }else if (scope.equalsIgnoreCase("Pole"))
        {
            if (position == 0) {
                localInspectionMetaData = poleReference(horizontalItemSelectedPosition);
                return findNoteData();
            }
        }else if (scope.equalsIgnoreCase("Tree"))
        {
            if (position == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                return findNoteData();
            }
        }else if (scope.equalsIgnoreCase("spl"))
        {
            if (position == 0) {
                localInspectionMetaData = regulatorReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 1) {
                localInspectionMetaData = capacitorBankReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 2) {
                localInspectionMetaData = recloserReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 3) {
                localInspectionMetaData = loadBreakSwitchReference(horizontalItemSelectedPosition);
                return findNoteData();
            }
        }else if (scope.equalsIgnoreCase("wire"))
        {
            if (position == 0) {
                localInspectionMetaData = primaryWireReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 1) {
                localInspectionMetaData = secondaryWireReference(horizontalItemSelectedPosition);
                return findNoteData();
            } else if (position == 2) {
                localInspectionMetaData = serviceWireReference(horizontalItemSelectedPosition);
                return findNoteData();
            }
        }
        else if (scope.equalsIgnoreCase("poleTop"))
        {
            if (position == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                return findNoteData();
            }
        }
        return null;
    }
    private String readExtentFromRespectiveCountList(String scope,int position) {
        if(scope.equalsIgnoreCase("other")) {
            String note = null;
            if (position == 0) {
                localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 1) {
                localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 2) {
                localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 3) {
                localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
                return findExtentData();
            }
        }else if (scope.equalsIgnoreCase("Pole"))
        {
            if (position == 0) {
                localInspectionMetaData = poleReference(horizontalItemSelectedPosition);
                return findExtentData();
            }
        }else if (scope.equalsIgnoreCase("Tree"))
        {
            if (position == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                return findExtentData();
            }
        }
        else if (scope.equalsIgnoreCase("spl"))
        {
            if (position == 0) {
                localInspectionMetaData = regulatorReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 1) {
                localInspectionMetaData = capacitorBankReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 2) {
                localInspectionMetaData = recloserReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 3) {
                localInspectionMetaData = loadBreakSwitchReference(horizontalItemSelectedPosition);
                return findExtentData();
            }
        }else if (scope.equalsIgnoreCase("wire"))
        {
            if (position == 0) {
                localInspectionMetaData = primaryWireReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 1) {
                localInspectionMetaData = secondaryWireReference(horizontalItemSelectedPosition);
                return findExtentData();
            } else if (position == 2) {
                localInspectionMetaData = serviceWireReference(horizontalItemSelectedPosition);
                return findExtentData();
            }
        }else if (scope.equalsIgnoreCase("poleTop"))
        {
            if (position == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                return findExtentData();
            }
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

    private String findExtentData() {
        String note = null;
        for (int i=0; i< localInspectionMetaData.size(); i++) {
            // to find out the respective note from inspectionMetaData in a loop
            if(localInspectionMetaData.get(i).getExtent() != null)
                note = localInspectionMetaData.get(i).getExtent();
        }
        return note;
    }

    private void addNoteToRespectiveCountList(String scope,String title, String note) {
        // adding note to respective count (horizontal list item)
        String noteNew = null;
        int localIndex = -1;

        if(scope.equalsIgnoreCase("other")) {
            if (gridPositionNew == 0) {
                localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToAddNote(noteNew, localIndex);
            } else if (gridPositionNew == 1) {
                localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToAddNote(noteNew, localIndex);
            } else if (gridPositionNew == 2) {
                localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToAddNote(noteNew, localIndex);
            } else if (gridPositionNew == 3) {
                localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToAddNote(noteNew, localIndex);
            }
        }else if(scope.equalsIgnoreCase("Pole"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = poleReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToAddNote(noteNew, localIndex);
            }
        }else if(scope.equalsIgnoreCase("Tree"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToAddNote(noteNew, localIndex);
            }
        }
        if(noteNew != null){
            localInspectionMetaData.set(localIndexToAddNote, new InspectionMetaData(note.trim(), title, "comments"));
            arrayAdapter.notifyDataSetChanged();
        } else {
            localInspectionMetaData.add(new InspectionMetaData(note.trim(), title, "comments"));
            arrayAdapter.notifyDataSetChanged();
        }
    }
    private void addExtentToRespectiveCountList(String scope,String title, String note) {
        // adding note to respective count (horizontal list item)
        String noteNew = null;
        int localIndex = -1;

        if(scope.equalsIgnoreCase("other")) {
            if (gridPositionNew == 0) {
                localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 1) {
                localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 2) {
                localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 3) {
                localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            }
        }else if(scope.equalsIgnoreCase("Pole"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = poleReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            }
        }else if(scope.equalsIgnoreCase("Tree"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            }
        }else if(scope.equalsIgnoreCase("spl"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = regulatorReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 1) {
                localInspectionMetaData = capacitorBankReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 2) {
                localInspectionMetaData = recloserReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 3) {
                localInspectionMetaData = loadBreakSwitchReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            }
        }else if(scope.equalsIgnoreCase("wire"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = primaryWireReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 1) {
                localInspectionMetaData = secondaryWireReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            } else if (gridPositionNew == 2) {
                localInspectionMetaData = serviceWireReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            }
        }else if(scope.equalsIgnoreCase("poleTop"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                noteNew = findingIndexToExtent(noteNew, localIndex);
            }
        }
        if(noteNew != null){
            localInspectionMetaData.set(localIndexToExtent, new InspectionMetaData(note.trim(), title, "extent"," "));
            arrayAdapter.notifyDataSetChanged();
        } else {
            localInspectionMetaData.add(new InspectionMetaData(note.trim(), title, "extent"," "));
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
    private String findingIndexToExtent(String titleNew, int localIndex) {
        for(int i=0; i<localInspectionMetaData.size(); i++) {
            if(titleNew == null) {
                titleNew = localInspectionMetaData.get(i).getExtent();
                inspectionMetaData = localInspectionMetaData.get(i);
                localIndexToExtent = i;
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
        if(GlobalData.pole_images_array!=null) {
            GlobalData.pole_images_array.add(reportFilePath);
        } else {
            GlobalData.pole_images_array = new ArrayList<>();
            GlobalData.pole_images_array.add(reportFilePath);
        }

        if(GlobalData.tree_images_array!=null) {
            GlobalData.tree_images_array.add(reportFilePath);
        } else {
            GlobalData.tree_images_array = new ArrayList<>();
            GlobalData.tree_images_array.add(reportFilePath);
        }
        if(GlobalData.wire_images_array!=null) {
            GlobalData.wire_images_array.add(reportFilePath);
        } else {
            GlobalData.wire_images_array = new ArrayList<>();
            GlobalData.wire_images_array.add(reportFilePath);
        }
        if(GlobalData.spl_images_array!=null) {
            GlobalData.spl_images_array.add(reportFilePath);
        } else {
            GlobalData.spl_images_array = new ArrayList<>();
            GlobalData.spl_images_array.add(reportFilePath);
        }
        if(GlobalData.pole_top_images_array!=null) {
            GlobalData.pole_top_images_array.add(reportFilePath);
        } else {
            GlobalData.pole_top_images_array = new ArrayList<>();
            GlobalData.pole_top_images_array.add(reportFilePath);
        }
        addImagesToRespectiveDefects(reportFilePath);

        return reportFilePath;
    }
    private void addImagesToRespectiveDefects(File reportFilePath) {
        int localIndex = -1;
         if(reportFilePath.toString().contains("Other")) {
             if (gridPositionNew == 0) {
                 localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 1) {
                 localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 2) {
                 localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 3) {
                 localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             }
         }else if(reportFilePath.toString().contains("Pole")) {

             if (gridPositionNew == 0) {
                 localInspectionMetaData = poleReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             }
         }else if(reportFilePath.toString().contains("Tree")) {

             if (gridPositionNew == 0) {
                 localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             }
         }else if(reportFilePath.toString().contains("spl")) {

             if (gridPositionNew == 0) {
                 localInspectionMetaData = regulatorReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 1) {
                 localInspectionMetaData = capacitorBankReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 2) {
                 localInspectionMetaData = recloserReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 3) {
                 localInspectionMetaData = loadBreakSwitchReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             }
         }else if(reportFilePath.toString().contains("Wire")) {

             if (gridPositionNew == 0) {
                 localInspectionMetaData = primaryWireReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 1) {
                 localInspectionMetaData = secondaryWireReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             } else if (gridPositionNew == 2) {
                 localInspectionMetaData = serviceWireReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             }
         }else if(reportFilePath.toString().contains("poleTop")) {

             if (gridPositionNew == 0) {
                 localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                 localIndex = findingIndexToAddImagePath();
             }
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

    private void readImagesForRespectiveDefects(final String scope,Context mContext,ImageView partImage) {
        String picturePath = null;
        if(scope.equalsIgnoreCase("Other")) {
            if (gridPositionNew == 0) {
                localInspectionMetaData = padmountsReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 1) {
                localInspectionMetaData = pullBoxReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 2) {
                localInspectionMetaData = spiceBoxReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 3) {
                localInspectionMetaData = sectionalizerCabinetReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            }
        }else if(scope.equalsIgnoreCase("Pole"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = poleReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            }
        }else if(scope.equalsIgnoreCase("Tree"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            }
        }else if(scope.equalsIgnoreCase("spl"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = regulatorReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 1) {
                localInspectionMetaData = capacitorBankReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 2) {
                localInspectionMetaData = recloserReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 3) {
                localInspectionMetaData = loadBreakSwitchReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            }
        }else if(scope.equalsIgnoreCase("wire"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = primaryWireReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 1) {
                localInspectionMetaData = secondaryWireReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            } else if (gridPositionNew == 2) {
                localInspectionMetaData = serviceWireReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            }
        }
        else if(scope.equalsIgnoreCase("poleTop"))
        {
            if (gridPositionNew == 0) {
                localInspectionMetaData = treeReference(horizontalItemSelectedPosition);
                picturePath = findingPath();
            }
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
                    pictureName = ReadPoleEquipmentData.getInstance().poleTwoPicturePath;
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
                    pictureName = ReadPoleEquipmentData.getInstance().poleThreePicturePath;

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
                    tree_1.put("POLE_3", damageDetailstree3);
                    tree.put("POLE", treePartName);
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
                    pictureName = ReadTreeData.getInstance().treeSevenPicturePath;
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
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
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
                    // poleTopEquipment.put("Other", regulatorDamagePart);
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
                    // poleTopEquipment.put("Other", regulatorDamagePart);
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
                    // poleTopEquipment.put("Other", regulatorDamagePart);
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
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
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
                    // poleTopEquipment.put("Other", regulatorDamagePart);
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
                    //  poleTopEquipment.put("Other", regulatorDamagePart);
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
                    // poleTopEquipment.put("Other", regulatorDamagePart);
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
                    // poleTopEquipment.put("Other", regulatorDamagePart);
                    count++;
                }
                if(count > 0){
                    regulatorDamagePart.put("scopename", "Other");
                    regulatorDamagePart.put("scopeDisplayName", "Other");
                    poleScope.put("Other", regulatorDamagePart);

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
                // poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                // poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                //   poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                // poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                //  poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                //  poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                //  poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                //  poleTopEquipment.put("Other", capacitorBankDamagePart);
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
                // poleTopEquipment.put("Other", capacitorBankDamagePart);
                count++;
            }
            if(count > 0){
                capacitorBankDamagePart.put("scopename", "Other");
                capacitorBankDamagePart.put("scopeDisplayName", "Other");
                poleScope.put("Other", capacitorBankDamagePart);

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
                // poleTopEquipment.put("Other", recloserDamagePart);
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
                //  poleTopEquipment.put("Other", recloserDamagePart);
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
                // poleTopEquipment.put("Other", recloserDamagePart);
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
                recloserDamagePart.put("scopename", "Other");
                recloserDamagePart.put("scopeDisplayName", "Other");
                poleScope.put("Other", recloserDamagePart);

            }  } catch (JSONException e) {
            e.printStackTrace();
        }

            try{
                count = 0;
                String loadBreakTitle_name = "Loadbreak Switch;";
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
                    loadBreakDamagePart.put("scopename", "Other");
                    loadBreakDamagePart.put("scopeDisplayName", "Other");
                    poleScope.put("Other", loadBreakDamagePart);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            // junk();


        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.nextButton:
               // LoadPoleScopeSelectedData();
               // LoadTreeScopeSelectedData();
               // LoadSPLScopeSelectedData();
/*
                try {
                    {
                        inspectionReport = new JSONObject();
                        JSONObject submittedByData = new JSONObject();
                        JSONObject poleDetailsData = new JSONObject();

                        submittedByData.put("email", sharedPref.getString("emailAddress", ""));
                        submittedByData.put("phone", sharedPref.getString("phoneNumber", ""));
                        inspectionReport.put("submittedBy", submittedByData);
                        poleDetailsData.put("height", "35");
                        inspectionReport.put("poleDetails", poleDetailsData);
                        SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");

                        inspectionReport.put("displayTimestamp", oldformat.format(new Date()));

                        JSONObject address = new JSONObject();

                        address.put("userAddress", Global.addressString);
                        address.put("resolvedAddress", Global.addressString);

                        inspectionReport.put("address", address);
                        inspectionReport.put("version", 1);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                        inspectionReport.put("deviceReportId", sharedPref.getString("phoneNumber", "")+ "_" + dateFormat.format(new Date()));
                        JSONObject loc = new JSONObject();
                        loc.put("type", "Point");
                        JSONArray l = new JSONArray();

                        l.put(0, Global.currentLocation.getLongitude());
                        l.put(1, Global.currentLocation.getLatitude());
                        loc.put("coordinates", l);
                        inspectionReport.put("loc", loc);
                        inspectionReport.put("damageScopes",poleScope);
                        Log.i("vidisha","SDA=="+inspectionReport.toString());
                       *//* if (Utils.isNetworkAvailable(SelectedItems.this)) {
                            Utils.createAndStartProgressBar(SelectedItems.this);
                            STAsyncHttpConnection async = new STAsyncHttpConnection();
                            async.execute(Global.SubmitSDAReportAPI);
                        }*//*

                    }
                    Log.i("vidisha","poleScope=="+poleScope.toString());

                } catch(JSONException e){
                        e.printStackTrace();
                    }*/

                Intent intent = new Intent(SelectedItems.this, Submission_screen.class);

                    intent.putExtra("wireImage",R.drawable.wire_sub);

                    intent.putExtra("poletopImage",R.drawable.pole_sub1);

                    intent.putExtra("splImage",R.drawable.spl_sub);

                    intent.putExtra("poleImage",R.drawable.pole_sub);

                    intent.putExtra("treeImage",R.drawable.tree_sub);

                    intent.putExtra("otherImage",R.drawable.other_sub);
                startActivity(intent);
                }
    }


    private void callAPI()
    {

          /*          inspectionReport = new JSONObject();
                    JSONObject submittedByData = new JSONObject();
                    JSONObject poleDetailsData = new JSONObject();

                    submittedByData.put("email", sharedPref.getString("emailAddress", ""));
                    submittedByData.put("phone", sharedPref.getString("phoneNumber", ""));
                    inspectionReport.put("submittedBy", submittedByData);
                    poleDetailsData.put("height", "35");
                    inspectionReport.put("poleDetails", poleDetailsData);
                    SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");

                    inspectionReport.put("displayTimestamp", oldformat.format(new Date()));

                    JSONObject address = new JSONObject();

                    address.put("userAddress", Global.addressString);
                    address.put("resolvedAddress", Global.addressString);

                    inspectionReport.put("address", address);
                    inspectionReport.put("version", 1);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    inspectionReport.put("deviceReportId", sharedPref.getString("phoneNumber", "")+ "_" + dateFormat.format(new Date()));
                    JSONObject loc = new JSONObject();
                    loc.put("type", "Point");
                    JSONArray l = new JSONArray();

                    l.put(0, Global.currentLocation.getLongitude());
                    l.put(1, Global.currentLocation.getLatitude());
                    loc.put("coordinates", l);
                    inspectionReport.put("loc", loc);
                    inspectionReport.put("damageScopes",poleScope);
                        Log.i("vidisha","SDA=="+inspectionReport.toString());
                    if (Utils.isNetworkAvailable(SelectedItems.this)) {
                        Utils.createAndStartProgressBar(SelectedItems.this);
                        STAsyncHttpConnection async = new STAsyncHttpConnection();
                        async.execute(Global.SubmitSDAReportAPI);
                    }*/
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
    public void setFileToUploadPole() {
        if(GlobalData.pole_images_array!=null) {
            for (int i = 0; i < GlobalData.pole_images_array.size(); i++) {
                Log.i("amazT_vidisha", "images_array==" + GlobalData.pole_images_array.get(i).getName());
                TransferObserver transferObserverPole = transferUtility.upload(
                        sharedPref.getString("s3Bucket","")+"/"+sharedPref.getString("accountKey",""),
                        //"irestore-ir-dev/dev",     /* The bucket to upload to */
                        GlobalData.pole_images_array.get(i).getName(),      /* The key for the uploaded object */
                        GlobalData.pole_images_array.get(i) , CannedAccessControlList.PublicRead     /* The file where the data to upload exists */
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
                Log.i("amazT_vidisha", "upload" + GlobalData.scopesPreferences.getString(transferObserverPole.getKey(), ""));
                Log.e("state", state + "" + id);
                Log.i("amazT_vidisha", "state==" + state);
                Log.i("amazT_vidisha", "total==" + transferObserverPole.getBytesTotal());
                Log.i("amazT_vidisha", "transfered==" + transferObserverPole.getBytesTransferred());
                if (state == TransferState.COMPLETED) {
                    if(GlobalData.pole_images_array!=null) {
                        GlobalData.pole_images_array.clear();
                        GlobalData.pole_images_array = null;
                        scopesPreferencesEditor.putString(transferObserverPole.getKey(), "success");
                        scopesPreferencesEditor.commit();
                    }
//                    Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
                Log.e("amazT_percent_pole_top", percentage + "");
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.e("error", "error");
            }
        });
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
                            Toast.makeText(SelectedItems.this, responseObj.getString("Message"),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(SelectedItems.this);
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("The report has been submitted successfully. The images will be uploading in background");
                            // on pressing cancel button
                            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent = new Intent(SelectedItems.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    setFileToUploadPole();

                                    dialog.cancel();

                                    ReadUnderGroundData.getInstance().resetAllReference();
                                    ReadUnderGroundData.getInstance().resetAllJSONObject();
                                    ReadPoleEquipmentData.getInstance().resetAllReference();
                                    ReadPoleEquipmentData.getInstance().resetAllJSONObject();
                                    ReadPoleEquipmentData.getInstance().resetAllReference();
                                    ReadPoleEquipmentData.getInstance().resetAllJSONObject();
                                    ReadWireData.getInstance().resetAllReference();
                                    ReadWireData.getInstance().resetAllJSONObject();
                                    ReadSplEquipmentData.getInstance().resetAllReference();
                                    ReadSplEquipmentData.getInstance().resetAllJSONObject();

                                    ReadTreeData.getInstance().resetAllReference();
                                    ReadTreeData.getInstance().resetAllJSONObject();
                                }
                            });
                            // Showing Alert Message
                            alertDialog.show();
                        }
                    } catch (Exception e) {

                    }
                } else {
                    Toast.makeText(SelectedItems.this, getResources().getString(R.string.error),
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

}
