package vda.irestore.com.vda_android;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
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
import vda.irestore.com.vda_android.Adapters.InspectionMetaDataAdapter;
import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.Pojo.GridItem;
import vda.irestore.com.vda_android.Pojo.InspectionMetaData;
import vda.irestore.com.vda_android.customUI.CustomList;

import static java.lang.String.valueOf;
import static vda.irestore.com.vda_android.Global.Global.initializeSharedPrefernceData;

public class SelectedItems extends AppCompatActivity {
    private ImageView m1,m2,m3,m4,m5,m6;
    private TextView Title;
    private View v1;
    String gridTitle;
    ArrayList<InspectionMetaData> pole_inspectionData_list;
    InspectionMetaDataAdapter arrayAdapter;
    JSONArray poleJsonArray,poleMetadataJsonArrayList;

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

    int code = 0;

    static int polePartCompleted = 0;


    AmazonS3 s3;
    HashMap<String, Button> hashMap;
    HashMap<String, Object> hashMapList =  new HashMap<String, Object>();;

    private Button firstButton=null, secondButton=null, thirdButton=null,fourthButton=null,fifthButton=null,sixthButton=null,seventhButton=null,eighthButton=null,ninethButton=null,tenthButton=null;
    int flag1 = 1,flag2 = 0,flag3 = 0,flag4 = 0,flag5 = 0,flag6 = 0,flag7 = 0,flag8 = 0,flag9 = 0,flag10 = 0;
    String com1 = null,com2 = null,com3 = null,com4 = null,com5 = null,com6 = null,com7 = null,com8 = null,com9 = null,com10 = null;
    EditText dialog_comment;
    int clickcount=0;
    String[] web = {"Wire", "Pole", "Pole Top", "Tree"} ;
    Integer[] imageId = {R.drawable.wire_sub, R.drawable.pole_sub, R.drawable.pole_sub1, R.drawable.tree_sub};


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

            String response = Global.metadataPreferences.getString(key, "");
            ArrayList<GridItem> poleGridItems_ArrayList = poleGson.fromJson(response,
                    new TypeToken<List<GridItem>>() {
                    }.getType());

            if (poleGridItems_ArrayList != null) {
                mGridData_pole = poleGridItems_ArrayList;
                poleJsonArray = new JSONArray(Global.metadataPreferences.getString(key, "").trim());
            } else {
                mGridData_pole = new ArrayList<>();
                poleJsonArray = new JSONArray(Global.scopesPreferences.getString(jsonKey, "").trim());
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
                inspectionData_map.put(title,poleObj.getJSONArray("MetaData").toString());

                item = new GridItem();
                item.setTitle(title);
                item.setName(name);
                item.setImage(imageUrl);
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
                ShowMetaDataDialog(SelectedItems.this, item, position,key,jsonKey);

            }
        });
    }

    private void ShowMetaDataDialog(final Context mContext, GridItem item, int position,String key,String JsonKey) {

        gridTitle = item.getTitle();
        sharedPref = mContext.getSharedPreferences(mContext.getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);

        final Dialog dialog = new Dialog(SelectedItems.this,R.style.Theme_Dialog);

     //   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        final View mView = getLayoutInflater().inflate(R.layout.list_items_dialog, null);

        final TextView part_Title = mView.findViewById(R.id.part_Header);

        part_Title.setText(gridTitle);
        part_Title.setTypeface(typeFace);
        final LinearLayout buttonPanel = mView.findViewById(R.id.button_panel);
        final EditText comments = mView.findViewById(R.id.comments);
        final Button addButton = mView.findViewById(R.id.add_button);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(9, 0, 0, 0);


        comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog dialog2 = new BottomSheetDialog(SelectedItems.this);
                final View mView2 = getLayoutInflater().inflate(R.layout.comment_dialog, null);
                dialog2.setContentView(mView2);
                dialog2.show();
                dialog_comment = mView2.findViewById(R.id.comments_editText);
                dialog_comment.setText(comments.getText().toString());
                final Button done = mView2.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (flag1 == 1) {
                            com1 = dialog_comment.getText().toString();
                            comments.setText(com1);
                        }
                        if (flag2 == 1) {
                            com2 = dialog_comment.getText().toString();
                            comments.setText(com2);
                        }
                        if (flag3 == 1) {
                            com3 = dialog_comment.getText().toString();
                            comments.setText(com3);
                        }
                        if (flag4 == 1) {
                            com4 = dialog_comment.getText().toString();
                            comments.setText(com4);
                        }
                        if (flag5 == 1) {
                            com5 = dialog_comment.getText().toString();
                            comments.setText(com5);
                        }
                        if (flag6 == 1) {
                            com6 = dialog_comment.getText().toString();
                            comments.setText(com6);
                        }
                        if (flag7 == 1) {
                            com7 = dialog_comment.getText().toString();
                            comments.setText(com7);
                        }
                        if (flag8 == 1) {
                            com8 = dialog_comment.getText().toString();
                            comments.setText(com8);
                        }
                        if (flag9 == 1) {
                            com9 = dialog_comment.getText().toString();
                            comments.setText(com9);
                        }
                        if (flag10 == 1) {
                            com10 = dialog_comment.getText().toString();
                            comments.setText(com10);
                        }
                        dialog2.dismiss();
                    }
                });
            }
        });
        if (com1 != null) {
            flag1 = 1;
            flag2 = 0;
            flag3 = 0;
            flag4 = 0;
            flag5 = 0;
            flag6 = 0;
            flag7 = 0;
            flag8 = 0;
            flag9 = 0;
            flag10 = 0;
            comments.setText(com1);
        } else
            comments.setText("");
        if (secondButton != null) {
            Log.i("vidisha","hash=="+hashMapList.get(gridTitle).toString());
            Button b2 = hashMap.get("button2");
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.setText(com2);
                    flag1 = 0;
                    flag2 = 1;
                    flag3 = 0;
                    flag4 = 0;
                    flag5 = 0;
                    flag6 = 0;
                    flag7 = 0;
                    flag8 = 0;
                    flag9 = 0;
                    flag10 = 0;
                    secondButton.setBackgroundResource(R.drawable.active_button);
                    secondButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(firstButton);
                    if (thirdButton != null) buttonBackground(thirdButton);
                    if (fourthButton != null) buttonBackground(fourthButton);
                    if (fifthButton != null) buttonBackground(fifthButton);
                    if (sixthButton != null) buttonBackground(sixthButton);
                    if (seventhButton != null) buttonBackground(seventhButton);
                    if (eighthButton != null) buttonBackground(eighthButton);
                    if (ninethButton != null) buttonBackground(ninethButton);
                    if (tenthButton != null) buttonBackground(tenthButton);

                }
            });

            buttonBackground(b2);
            if (secondButton.getParent() != null)
                ((ViewGroup) secondButton.getParent()).removeView(secondButton);
            buttonPanel.addView(b2);
        }
        if (thirdButton != null) {
            Button b3 = hashMap.get("button3");
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.setText(com3);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 1;
                    flag4 = 0;
                    flag5 = 0;
                    flag6 = 0;
                    flag7 = 0;
                    flag8 = 0;
                    flag9 = 0;
                    flag10 = 0;

                    thirdButton.setBackgroundResource(R.drawable.active_button);
                    thirdButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(secondButton);
                    buttonBackground(firstButton);
                    if (fourthButton != null) buttonBackground(fourthButton);
                    if (fifthButton != null) buttonBackground(fifthButton);
                    if (sixthButton != null) buttonBackground(sixthButton);
                    if (seventhButton != null) buttonBackground(seventhButton);
                    if (eighthButton != null) buttonBackground(eighthButton);
                    if (ninethButton != null) buttonBackground(ninethButton);
                    if (tenthButton != null) buttonBackground(tenthButton);

                }
            });

            buttonBackground(b3);
            if (thirdButton.getParent() != null)
                ((ViewGroup) thirdButton.getParent()).removeView(thirdButton);
            buttonPanel.addView(b3);
        }
        if (fourthButton != null) {
            Button b4 = hashMap.get("button4");
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fourthButton.setBackgroundResource(R.drawable.active_button);
                    fourthButton.setTextColor(Color.parseColor("#FFFFFF"));
                    comments.setText(com4);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 0;
                    flag4 = 1;
                    flag5 = 0;
                    flag6 = 0;
                    flag7 = 0;
                    flag8 = 0;
                    flag9 = 0;
                    flag10 = 0;
                    buttonBackground(secondButton);
                    buttonBackground(thirdButton);
                    buttonBackground(firstButton);
                    if (fifthButton != null) buttonBackground(fifthButton);
                    if (sixthButton != null) buttonBackground(sixthButton);
                    if (seventhButton != null) buttonBackground(seventhButton);
                    if (eighthButton != null) buttonBackground(eighthButton);
                    if (ninethButton != null) buttonBackground(ninethButton);
                    if (tenthButton != null) buttonBackground(tenthButton);

                }
            });
            buttonBackground(b4);
            if (fourthButton.getParent() != null)
                ((ViewGroup) fourthButton.getParent()).removeView(fourthButton);
            buttonPanel.addView(b4);
        }
        if (fifthButton != null) {
            Button b5 = hashMap.get("button5");
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.setText(com5);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 0;
                    flag4 = 0;
                    flag5 = 1;
                    flag6 = 0;
                    flag7 = 0;
                    flag8 = 0;
                    flag9 = 0;
                    flag10 = 0;
                    fifthButton.setBackgroundResource(R.drawable.active_button);
                    fifthButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(secondButton);
                    buttonBackground(thirdButton);
                    buttonBackground(fourthButton);
                    buttonBackground(firstButton);
                    if (sixthButton != null) buttonBackground(sixthButton);
                    if (seventhButton != null) buttonBackground(seventhButton);
                    if (eighthButton != null) buttonBackground(eighthButton);
                    if (ninethButton != null) buttonBackground(ninethButton);
                    if (tenthButton != null) buttonBackground(tenthButton);
                }
            });

            buttonBackground(b5);
            if (fifthButton.getParent() != null)
                ((ViewGroup) fifthButton.getParent()).removeView(fifthButton);
            buttonPanel.addView(b5);
        }
        if (sixthButton != null) {
            Button b6 = hashMap.get("button6");
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.setText(com6);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 0;
                    flag4 = 0;
                    flag5 = 0;
                    flag6 = 1;
                    flag7 = 0;
                    flag8 = 0;
                    flag9 = 0;
                    flag10 = 0;
                    sixthButton.setBackgroundResource(R.drawable.active_button);
                    sixthButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(secondButton);
                    buttonBackground(thirdButton);
                    buttonBackground(fourthButton);
                    buttonBackground(fifthButton);
                    buttonBackground(firstButton);
                    if (seventhButton != null) buttonBackground(seventhButton);
                    if (eighthButton != null) buttonBackground(eighthButton);
                    if (ninethButton != null) buttonBackground(ninethButton);
                    if (tenthButton != null) buttonBackground(tenthButton);
                }
            });

            buttonBackground(b6);
            if (sixthButton.getParent() != null)
                ((ViewGroup) sixthButton.getParent()).removeView(sixthButton);
            buttonPanel.addView(b6);
        }
        if (seventhButton != null) {
            Button b7 = hashMap.get("button7");
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.setText(com7);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 0;
                    flag4 = 0;
                    flag5 = 0;
                    flag6 = 0;
                    flag7 = 1;
                    flag8 = 0;
                    flag9 = 0;
                    flag10 = 0;
                    seventhButton.setBackgroundResource(R.drawable.active_button);
                    seventhButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(secondButton);
                    buttonBackground(thirdButton);
                    buttonBackground(fourthButton);
                    buttonBackground(fifthButton);
                    buttonBackground(sixthButton);
                    buttonBackground(firstButton);
                    if (eighthButton != null) buttonBackground(eighthButton);
                    if (ninethButton != null) buttonBackground(ninethButton);
                    if (tenthButton != null) buttonBackground(tenthButton);

                }
            });

            buttonBackground(b7);
            if (seventhButton.getParent() != null)
                ((ViewGroup) seventhButton.getParent()).removeView(seventhButton);
            buttonPanel.addView(b7);
        }
        if (eighthButton != null) {
            Button b8 = hashMap.get("button8");
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.setText(com8);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 0;
                    flag4 = 0;
                    flag5 = 0;
                    flag6 = 0;
                    flag7 = 0;
                    flag8 = 1;
                    flag9 = 0;
                    flag10 = 0;
                    eighthButton.setBackgroundResource(R.drawable.active_button);
                    eighthButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(secondButton);
                    buttonBackground(thirdButton);
                    buttonBackground(fourthButton);
                    buttonBackground(fifthButton);
                    buttonBackground(sixthButton);
                    buttonBackground(seventhButton);
                    buttonBackground(firstButton);
                    if (ninethButton != null) buttonBackground(ninethButton);
                    if (tenthButton != null) buttonBackground(tenthButton);
                }
            });
            buttonBackground(b8);
            if (eighthButton.getParent() != null)
                ((ViewGroup) eighthButton.getParent()).removeView(eighthButton);
            buttonPanel.addView(b8);
        }
        if (ninethButton != null) {
            Button b9 = hashMap.get("button9");
            b9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comments.setText(com9);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 0;
                    flag4 = 0;
                    flag5 = 0;
                    flag6 = 0;
                    flag7 = 0;
                    flag8 = 0;
                    flag9 = 1;
                    flag10 = 0;
                    ninethButton.setBackgroundResource(R.drawable.active_button);
                    ninethButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(secondButton);
                    buttonBackground(thirdButton);
                    buttonBackground(fourthButton);
                    buttonBackground(fifthButton);
                    buttonBackground(sixthButton);
                    buttonBackground(seventhButton);
                    buttonBackground(eighthButton);
                    buttonBackground(firstButton);
                    if (tenthButton != null) buttonBackground(tenthButton);
                }
            });

            buttonBackground(b9);
            if (ninethButton.getParent() != null)
                ((ViewGroup) ninethButton.getParent()).removeView(ninethButton);
            buttonPanel.addView(b9);
        }
        if (tenthButton != null) {
            Button b10 = hashMap.get("button10");
            b10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    comments.setText(com10);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 0;
                    flag4 = 0;
                    flag5 = 0;
                    flag6 = 0;
                    flag7 = 0;
                    flag8 = 0;
                    flag9 = 0;
                    flag10 = 1;
                    tenthButton.setBackgroundResource(R.drawable.active_button);
                    tenthButton.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonBackground(secondButton);
                    buttonBackground(thirdButton);
                    buttonBackground(fourthButton);
                    buttonBackground(fifthButton);
                    buttonBackground(sixthButton);
                    buttonBackground(seventhButton);
                    buttonBackground(eighthButton);
                    buttonBackground(ninethButton);
                    buttonBackground(firstButton);
                }
            });
            buttonBackground(b10);
            if (tenthButton.getParent() != null)
                ((ViewGroup) tenthButton.getParent()).removeView(tenthButton);
            buttonPanel.addView(b10);
            addButton.setEnabled(false);
            addButton.setBackgroundResource(R.drawable.addbutton_disable);
        }

        final Spinner spinner = mView.findViewById(R.id.spinner);
        ArrayList<String> type = new ArrayList<String>();
        type.add("Single Phase");
        type.add("Third Phase");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_style, type);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        final ListView listView = mView.findViewById(R.id.list1);
       /* final CustomList adapter = new CustomList(SelectedItems.this, web, imageId);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(SelectedItems.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });*/

        try {

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
        listView.setAdapter(arrayAdapter);


        firstButton = mView.findViewById(R.id.first_button);
        firstButton.setBackgroundResource(R.drawable.active_button);
        firstButton.setTextColor(Color.parseColor("#FFFFFF"));
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comments.setText(com1);
                flag1 = 1;
                flag2 = 0;
                flag3 = 0;
                flag4 = 0;
                flag5 = 0;
                flag6 = 0;
                flag7 = 0;
                flag8 = 0;
                flag9 = 0;
                flag10 = 0;
                firstButton.setBackgroundResource(R.drawable.active_button);
                firstButton.setTextColor(Color.parseColor("#FFFFFF"));
                if (secondButton != null) buttonBackground(secondButton);
                if (thirdButton != null) buttonBackground(thirdButton);
                if (fourthButton != null) buttonBackground(fourthButton);
                if (fifthButton != null) buttonBackground(fifthButton);
                if (sixthButton != null) buttonBackground(sixthButton);
                if (seventhButton != null) buttonBackground(seventhButton);
                if (eighthButton != null) buttonBackground(eighthButton);
                if (ninethButton != null) buttonBackground(ninethButton);
                if (tenthButton != null) buttonBackground(tenthButton);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickcount = clickcount + 1;
                final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(9, 0, 0, 0);
                if (clickcount == 1) {
                    secondButton = new Button(getApplicationContext());
                    secondButton.setLayoutParams(params);
                    buttonPanel.addView(secondButton);
                    secondButton.setText("2");
                    buttonBackground(secondButton);
                    secondButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com2);
                            flag1 = 0;
                            flag2 = 1;
                            flag3 = 0;
                            flag4 = 0;
                            flag5 = 0;
                            flag6 = 0;
                            flag7 = 0;
                            flag8 = 0;
                            flag9 = 0;
                            flag10 = 0;
                            secondButton.setBackgroundResource(R.drawable.active_button);
                            secondButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            if (thirdButton != null) buttonBackground(thirdButton);
                            if (fourthButton != null) buttonBackground(fourthButton);
                            if (fifthButton != null) buttonBackground(fifthButton);
                            if (sixthButton != null) buttonBackground(sixthButton);
                            if (seventhButton != null) buttonBackground(seventhButton);
                            if (eighthButton != null) buttonBackground(eighthButton);
                            if (ninethButton != null) buttonBackground(ninethButton);
                            if (tenthButton != null) buttonBackground(tenthButton);

                        }
                    });
                }
                if (clickcount == 2) {
                    thirdButton = new Button(getApplicationContext());
                    thirdButton.setLayoutParams(params);
                    buttonPanel.addView(thirdButton);
                    thirdButton.setText("3");
                    buttonBackground(thirdButton);
                    thirdButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com3);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 1;
                            flag4 = 0;
                            flag5 = 0;
                            flag6 = 0;
                            flag7 = 0;
                            flag8 = 0;
                            flag9 = 0;
                            flag10 = 0;
                            thirdButton.setBackgroundResource(R.drawable.active_button);
                            thirdButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(secondButton);
                            buttonBackground(firstButton);
                            if (fourthButton != null) buttonBackground(fourthButton);
                            if (fifthButton != null) buttonBackground(fifthButton);
                            if (sixthButton != null) buttonBackground(sixthButton);
                            if (seventhButton != null) buttonBackground(seventhButton);
                            if (eighthButton != null) buttonBackground(eighthButton);
                            if (ninethButton != null) buttonBackground(ninethButton);
                            if (tenthButton != null) buttonBackground(tenthButton);

                        }
                    });
                }
                if (clickcount == 3) {
                    fourthButton = new Button(getApplicationContext());
                    fourthButton.setLayoutParams(params);
                    buttonPanel.addView(fourthButton);
                    fourthButton.setText("4");
                    buttonBackground(fourthButton);
                    fourthButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com4);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                            flag4 = 1;
                            flag5 = 0;
                            flag6 = 0;
                            flag7 = 0;
                            flag8 = 0;
                            flag9 = 0;
                            flag10 = 0;
                            fourthButton.setBackgroundResource(R.drawable.active_button);
                            fourthButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            buttonBackground(secondButton);
                            buttonBackground(thirdButton);
                            if (fifthButton != null) buttonBackground(fifthButton);
                            if (sixthButton != null) buttonBackground(sixthButton);
                            if (seventhButton != null) buttonBackground(seventhButton);
                            if (eighthButton != null) buttonBackground(eighthButton);
                            if (ninethButton != null) buttonBackground(ninethButton);
                            if (tenthButton != null) buttonBackground(tenthButton);

                        }
                    });
                }
                if (clickcount == 4) {
                    fifthButton = new Button(getApplicationContext());
                    fifthButton.setLayoutParams(params);
                    buttonPanel.addView(fifthButton);
                    fifthButton.setText("5");
                    buttonBackground(fifthButton);
                    fifthButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com5);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                            flag4 = 0;
                            flag5 = 1;
                            flag6 = 0;
                            flag7 = 0;
                            flag8 = 0;
                            flag9 = 0;
                            flag10 = 0;
                            fifthButton.setBackgroundResource(R.drawable.active_button);
                            fifthButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            buttonBackground(secondButton);
                            buttonBackground(thirdButton);
                            buttonBackground(fourthButton);
                            if (sixthButton != null) buttonBackground(sixthButton);
                            if (seventhButton != null) buttonBackground(seventhButton);
                            if (eighthButton != null) buttonBackground(eighthButton);
                            if (ninethButton != null) buttonBackground(ninethButton);
                            if (tenthButton != null) buttonBackground(tenthButton);

                        }
                    });
                }
                if (clickcount == 5) {

                    sixthButton = new Button(getApplicationContext());
                    sixthButton.setLayoutParams(params);
                    buttonPanel.addView(sixthButton);
                    sixthButton.setText("6");
                    buttonBackground(sixthButton);
                    sixthButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com6);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                            flag4 = 0;
                            flag5 = 0;
                            flag6 = 1;
                            flag7 = 0;
                            flag8 = 0;
                            flag9 = 0;
                            flag10 = 0;
                            sixthButton.setBackgroundResource(R.drawable.active_button);
                            sixthButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            buttonBackground(secondButton);
                            buttonBackground(thirdButton);
                            buttonBackground(fourthButton);
                            buttonBackground(fifthButton);
                            if (seventhButton != null) buttonBackground(seventhButton);
                            if (eighthButton != null) buttonBackground(eighthButton);
                            if (ninethButton != null) buttonBackground(ninethButton);
                            if (tenthButton != null) buttonBackground(tenthButton);

                        }
                    });
                }
                if (clickcount == 6) {

                    seventhButton = new Button(getApplicationContext());
                    seventhButton.setLayoutParams(params);
                    buttonPanel.addView(seventhButton);
                    seventhButton.setText("7");
                    buttonBackground(seventhButton);
                    seventhButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com7);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                            flag4 = 0;
                            flag5 = 0;
                            flag6 = 0;
                            flag7 = 1;
                            flag8 = 0;
                            flag9 = 0;
                            flag10 = 0;
                            seventhButton.setBackgroundResource(R.drawable.active_button);
                            seventhButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            buttonBackground(secondButton);
                            buttonBackground(thirdButton);
                            buttonBackground(fourthButton);
                            buttonBackground(fifthButton);
                            buttonBackground(sixthButton);
                            if (eighthButton != null) buttonBackground(eighthButton);
                            if (ninethButton != null) buttonBackground(ninethButton);
                            if (tenthButton != null) buttonBackground(tenthButton);

                        }
                    });
                }
                if (clickcount == 7) {
                    eighthButton = new Button(getApplicationContext());
                    eighthButton.setLayoutParams(params);
                    buttonPanel.addView(eighthButton);
                    eighthButton.setText("8");
                    buttonBackground(eighthButton);
                    eighthButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com8);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                            flag4 = 0;
                            flag5 = 0;
                            flag6 = 0;
                            flag7 = 0;
                            flag8 = 1;
                            flag9 = 0;
                            flag10 = 0;
                            eighthButton.setBackgroundResource(R.drawable.active_button);
                            eighthButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            buttonBackground(secondButton);
                            buttonBackground(thirdButton);
                            buttonBackground(fourthButton);
                            buttonBackground(fifthButton);
                            buttonBackground(sixthButton);
                            buttonBackground(seventhButton);
                            if (ninethButton != null) buttonBackground(ninethButton);
                            if (tenthButton != null) buttonBackground(tenthButton);
                        }
                    });
                }
                if (clickcount == 8) {
                    ninethButton = new Button(getApplicationContext());
                    ninethButton.setLayoutParams(params);
                    buttonPanel.addView(ninethButton);
                    ninethButton.setText("9");
                    buttonBackground(ninethButton);
                    ninethButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com9);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                            flag4 = 0;
                            flag5 = 0;
                            flag6 = 0;
                            flag7 = 0;
                            flag8 = 0;
                            flag9 = 1;
                            flag10 = 0;
                            ninethButton.setBackgroundResource(R.drawable.active_button);
                            ninethButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            buttonBackground(secondButton);
                            buttonBackground(thirdButton);
                            buttonBackground(fourthButton);
                            buttonBackground(fifthButton);
                            buttonBackground(sixthButton);
                            buttonBackground(seventhButton);
                            buttonBackground(eighthButton);
                            if (tenthButton != null) buttonBackground(tenthButton);

                        }
                    });
                }
                if (clickcount == 9) {
                    tenthButton = new Button(getApplicationContext());
                    tenthButton.setLayoutParams(params);
                    buttonPanel.addView(tenthButton);
                    tenthButton.setText("10");
                    tenthButton.setBackgroundResource(R.drawable.fill_rectangle_buttons);
                    tenthButton.setTextColor(Color.parseColor("#3EA99F"));
                    tenthButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            comments.setText(com10);
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                            flag4 = 0;
                            flag5 = 0;
                            flag6 = 0;
                            flag7 = 0;
                            flag8 = 0;
                            flag9 = 0;
                            flag10 = 1;
                            tenthButton.setBackgroundResource(R.drawable.active_button);
                            tenthButton.setTextColor(Color.parseColor("#FFFFFF"));
                            buttonBackground(firstButton);
                            buttonBackground(secondButton);
                            buttonBackground(thirdButton);
                            buttonBackground(fourthButton);
                            buttonBackground(fifthButton);
                            buttonBackground(sixthButton);
                            buttonBackground(seventhButton);
                            buttonBackground(eighthButton);
                            buttonBackground(ninethButton);

                        }
                    });
                    addButton.setEnabled(false);
                    addButton.setBackgroundResource(R.drawable.addbutton_disable);
                }
            }


        });
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

        Button close = mView.findViewById(R.id.close_button);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hashMap = new HashMap<String, Button>();

                if (secondButton != null)
                    hashMap.put("button2", secondButton);
                if (thirdButton != null)
                    hashMap.put("button3", thirdButton);
                if (fourthButton != null)
                    hashMap.put("button4", fourthButton);
                if (fifthButton != null)
                    hashMap.put("button5", fifthButton);
                if (sixthButton != null)
                    hashMap.put("button6", sixthButton);
                if (seventhButton != null)
                    hashMap.put("button7", seventhButton);
                if (eighthButton != null)
                    hashMap.put("button8", eighthButton);
                if (ninethButton != null)
                    hashMap.put("button9", ninethButton);
                if (tenthButton != null)
                    hashMap.put("button10", tenthButton);

                hashMapList.put(gridTitle,hashMap);
                dialog.dismiss();

            }
        });

        WindowManager.LayoutParams params_w = dialog.getWindow().getAttributes();
        params_w.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params_w.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.setContentView(mView);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
    }

            private void buttonBackground(Button fillButton) {
                fillButton.setBackgroundResource(R.drawable.fill_rectangle_buttons);
                fillButton.setTextColor(Color.parseColor("#3EA99F"));
            }


}
