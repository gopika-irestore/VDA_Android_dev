package vda.irestore.com.vda_android.signup;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;


import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.R;
import vda.irestore.com.vda_android.services.GPSTracker;

import static vda.irestore.com.vda_android.Global.Global.appKey;

public class Main3Activity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    EditText email,phoneNumber,selectedUtility;
    Button signIn;
    String phoneNo,responseJSON;
    GPSTracker gps;



    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 123;
    Context context;
    private Activity activity;
    SharedPreferences sharedPref;
    JSONObject responseData;
    Boolean termsAccepted,otpValidationRequired,adminApprovalRequired,viewCards,isSupervisor,isTechnician,isAdmin;
    JSONArray tenantsArray,userArray,subscriptionsArray,permissionsArray_RVA;
    String accountKey,logo,token,configuration,safetyMessage,s3Bucket,api;

    public static String[] URLs ;//= {"https://s3.amazonaws.com/all-damage-reportsthumbnail%2Fngrid/reportid%3A23192_ngrid.irestore.info_1.png",
    // "https://s3.amazonaws.com/all-damage-reportsthumbnail%2Fngrid/reportid%3A97379_ngrid.irestore.info_2.png"};
    Spinner spinner;
    ArrayAdapter<String> adapter;
    SharedPreferences.Editor editor;
    private String imageName;
    private boolean utilitySelected,utilitySelectedOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        email = (EditText) findViewById(R.id.userEmail);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        selectedUtility = (EditText) findViewById(R.id.selectedUtility);

        signIn = (Button) findViewById(R.id.signInBtn);
        TextView title1= (TextView) findViewById(R.id.title1);
        TextView title2= (TextView) findViewById(R.id.title2);

        spinner = (Spinner) findViewById(R.id.selectUtility);
        spinner.setOnItemSelectedListener(this);

        context = getApplicationContext();
        activity = this;
        gps = new GPSTracker();
       // checkAndRequestPermissions();
        signInClick();

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        Log.i("vidisha","Global.currentLocation"+ Global.currentLocation);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        email.setTypeface(typeFace);
        phoneNumber.setTypeface(typeFace);
        selectedUtility.setTypeface(typeFace);

        signIn.setTypeface(typeFace);
        title1.setTypeface(typeFace);
        title2.setTypeface(typeFace);

        PhoneNumberFormatter2 addLineNumberFormatter = new PhoneNumberFormatter2(
                new WeakReference<EditText>(phoneNumber));
        phoneNumber.addTextChangedListener(addLineNumberFormatter);



    }

    public void deleteDir(File dir) {
        File[] files = dir.listFiles();
        if(files!=null) {
            for (File myFile : files) {
                if (myFile.isDirectory()) {
                    deleteDir(myFile);
                }
                myFile.delete();

            }
        }
    }
    private boolean checkAndRequestPermissions() {

        Log.i("vidisha","chk permissions");
        int writepermission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readpermission = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        int cameraPermissions = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);

        int locationpermission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        int locationpermission1 = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);
        int readPhoneState = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE);
       // int flashLight = ContextCompat.checkSelfPermission(context, Manifest.permission.FLASHLIGHT);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (locationpermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (locationpermission1 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (writepermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (readpermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (cameraPermissions != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (readPhoneState != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
        }
       /* if (flashLight != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.FLASHLIGHT);
        }*/
        Log.i("vidisha","listPermissionsNeeded33333"+listPermissionsNeeded.size());
        if (!listPermissionsNeeded.isEmpty()) {
            Log.i("vidisha","listPermissionsNeeded"+listPermissionsNeeded.size());
            ActivityCompat.requestPermissions(activity,listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        fetchLocation();
    }
    @Override
    public void onRestart() {
        super.onRestart();
        // When BACK BUTTON is pressed, the activity on the stack is restarted
        // Do what you want on the refresh procedure here
        //email.setText("");
    }



    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPhoneNumber(String str) {
        final Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public void fetchLocation() {
        gps = new GPSTracker(Main3Activity.this);

        Global.currentLocation = gps.getLocation();
        if (gps.canGetLocation() == false) {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
           // Global.showGPSAlert(Main3Activity.this);
        }
    }

    public void signInClick(){
        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/DCIM/VDA/TenantLogo");

                boolean isDirectoryCreated = myDir.mkdir();

                if (isDirectoryCreated) {
                    System.out.println("successfully made");

                } else {
                    deleteDir(myDir);  // Invoke recursive method
                    myDir.mkdir();
                }

                phoneNo = phoneNumber.getText().toString().trim().replaceAll("[\\[\\]\\s(){}-]", "");
                editor.putString("phoneNumber", phoneNo);
                editor.putString("emailAddress", email.getText().toString());
                editor.commit();//to skip otp
                if (!utilitySelectedOne) {



                    Log.i("vidisha", "phonenumger===" + phoneNo);

                    if (email.getText().toString().isEmpty()) {
                        Toast.makeText(Main3Activity.this, getResources().getString(R.string.empty_email),
                                Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        if (!isEmailValid(email.getText().toString())) {
                            Toast.makeText(Main3Activity.this, getResources().getString(R.string.invalid_email),
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (email.getText().toString().length() > 150) {
                            Toast.makeText(Main3Activity.this, "Email "
                                            + getResources().getString(R.string.invalid_field_length1),
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }


                    if (phoneNo.isEmpty()) {
                        Toast.makeText(Main3Activity.this, getResources().getString(R.string.empty_phone_number),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (Global.currentLocation != null) {

                        try {

                            InputMethodManager inputMethodManager = (InputMethodManager) Main3Activity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                            //Find the currently focused view, so we can grab the correct window token from it.
                            View view = Main3Activity.this.getCurrentFocus();
                            //If no view currently has focus, create a new one, just so we can grab a window token from it
                            if (view == null) {
                                view = new View(Main3Activity.this);
                            }
                            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);


                            HashMap<String, String> params = new HashMap<String, String>();

                            if (Global.isNetworkAvailable(Main3Activity.this)) {
                                Global.createAndStartProgressBar(Main3Activity.this);
                                STAsyncHttpConnection async = new STAsyncHttpConnection(Main3Activity.this);
                                async.execute(Global.signUpURL+"/?email="+email.getText().toString().trim()+"&phone="+phoneNo);

                            } else {
                                Toast.makeText(Main3Activity.this, getResources().getString(R.string.internet_error),
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Log.e("log_tag",
                                    "Error in http connection!!" + e.toString());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            Toast.makeText(Main3Activity.this, getResources().getString(R.string.enable_location),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Main3Activity.this, getResources().getString(R.string.no_location),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else
                {

                    if (Global.currentLocation != null) {

                        try {

                            if(utilitySelected) {
                                if(sharedPref.getBoolean("otpValidationRequired",false)) {
                                    if (Global.isNetworkAvailable(Main3Activity.this)) {
                                        Global.createAndStartProgressBar(Main3Activity.this);
                                        Main3Activity.HttpGetRequest async = new Main3Activity.HttpGetRequest();
                                        async.execute(Global.getOTP+sharedPref.getString("phoneNumber",""));
                                    } else {
                                        Toast.makeText(Main3Activity.this, getResources().getString(R.string.internet_error),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }else
                                {
                                    if(sharedPref.getBoolean("adminApprovalRequired",false)) {
                                        if (!sharedPref.getString("subscriptionStatus", "").equals("approved")) {
                                            if (sharedPref.getString("userID", "").equals("0")) {
                                                Intent i = new Intent(Main3Activity.this, MyProfile.class);
                                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                //editor.putBoolean("OTPEntered", true);
                                                editor.putBoolean("userProfileCreated", false);
                                                editor.commit();
                                                startActivity(i);
                                            } else {
                                                if (!sharedPref.getString("subscriptionStatus", "").equals("")) {
                                                    Intent i = new Intent(Main3Activity.this, AdminApprovalScreen.class);
                                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    // editor.putBoolean("OTPEntered", true);
                                                    editor.putBoolean("userProfileCreated", true);
                                                    editor.commit();
                                                    startActivity(i);
                                                } else {
                                                    Intent i = new Intent(Main3Activity.this, MyProfile.class);
                                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                   // editor.putBoolean("OTPEntered", true);
                                                    editor.putBoolean("userProfileCreated", false);
                                                    editor.commit();
                                                    startActivity(i);
                                                }
                                            }

                                        }
                                    }
                                    else
                                    {
                                        if (!sharedPref.getBoolean("termsAccepted", false)) {
                                            Intent loginIntent = new Intent();
                                            loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            loginIntent.setClass(Main3Activity.this, TermsConditions.class);
                                            editor.putBoolean("ACCEPTANCE", sharedPref.getBoolean("termsAccepted", false));
                                            editor.putBoolean("userProfileCreated", true);
                                            editor.commit();
                                            startActivity(loginIntent);

                                        }
                                    }
                                }
                            }else
                            {
                                Toast.makeText(Main3Activity.this, getResources().getString(R.string.select_utility),
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Log.e("log_tag",
                                    "Error in http connection!!" + e.toString());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            Toast.makeText(Main3Activity.this, getResources().getString(R.string.enable_location),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Main3Activity.this, getResources().getString(R.string.no_location),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }


    public void processWebServiceResponse() throws JSONException {
        responseJSON = sharedPref.getString("fullResponseData", "");
        responseData = new JSONObject(responseJSON);
        email.setEnabled(false);
        phoneNumber.setEnabled(false);
        signIn.setText("NEXT");

        if(!responseData.getBoolean("Error")) {
            userArray = responseData.getJSONArray("User");
            tenantsArray = responseData.getJSONObject("Owners").getJSONArray("utilities");
            subscriptionsArray = responseData.getJSONArray("Subscription");


            permissionsArray_RVA = responseData.getJSONArray("Permissions");

            Log.i("vidisha","permissionsArray_RVA 1111"+permissionsArray_RVA.length());
            if(permissionsArray_RVA.length()!=0)
            {
                viewCards = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("view");
                isTechnician = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("isTechnician");
                isSupervisor = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("isSupervisor");
                isAdmin = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("isAdmin");

                Log.i("vidisha","permissionsArray_RVA"+permissionsArray_RVA.getJSONObject(0).getString("permissions"));
                Log.i("vidisha","permissionsArray_RVA"+permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("view"));
            }
            else {
                viewCards = false;
                isTechnician = false;
                isSupervisor =false;
                isAdmin =false;
            }


            URLs = new String[tenantsArray.length()];

            String[] spinnerArray = new String[tenantsArray.length()];
            String emailDomains[] = email.getText().toString().split("@");
            String emailC = emailDomains[1];
            int sel = 0;
            boolean emailDomainFound = false;

            if(subscriptionsArray.length()==0)
            {
                if(userArray.length()!=0)
                {
                    editor.putString("firstName", userArray.getJSONObject(0).getString("firstName"));
                    editor.putString("lastName", userArray.getJSONObject(0).getString("lastName"));
                    editor.putString("jobTitle", userArray.getJSONObject(0).getString("job"));
                    editor.putString("organization", userArray.getJSONObject(0).getString("organization"));
                    editor.putString("city", userArray.getJSONObject(0).getString("city"));
                    editor.putString("state", userArray.getJSONObject(0).getString("state"));
                    editor.putString("county", userArray.getJSONObject(0).getString("county"));
                    if(userArray.getJSONObject(0).has("departmentId"))
                    editor.putInt("departmentId", userArray.getJSONObject(0).getInt("departmentId"));

                    if(userArray.getJSONObject(0).has("primaryPhone"))
                        editor.putString("primaryPhone", userArray.getJSONObject(0).getString("primaryPhone"));
                    else
                        editor.putString("primaryPhone", "");
                    editor.commit();
                }
                for(int i=0;i<tenantsArray.length();i++)
                {
                    Log.i("vidisha","1111111111");
                    if(tenantsArray.getJSONObject(i).getString("emailDomains").contains(emailC))
                    {
                        Log.i("vidisha","222222");
                        sel=i;
                        emailDomainFound = true;

                        break;
                    }

                }

                if(emailDomainFound)
                {
                    Log.i("vidisha","email domain Found");
                    accountKey = tenantsArray.getJSONObject(sel).getString("accountKey");
                    Log.i("vidisha","email domain Found"+accountKey);
                    logo = tenantsArray.getJSONObject(sel).getString("logo");
                    token = tenantsArray.getJSONObject(sel).getString("token");
                    Log.i("vidisha","hello token");
                    configuration =  tenantsArray.getJSONObject(sel).getString("configuration");
                    Log.i("vidisha","hello configuration");
                    JSONObject configuration = new JSONObject(tenantsArray.getJSONObject(sel).getString("configuration"));
                    if(configuration.has("safetyMessage"))
                    safetyMessage = configuration.getString("safetyMessage");
                    s3Bucket = configuration.getString("s3Bucket");
                    if(configuration.has("profilePicBucket"))
                    profilePicBucket = configuration.getString("profilePicBucket");
                    if(configuration.has("profilePicThumbnailsBucket"))

                        profilePicThumbnailsBucket = configuration.getString("profilePicThumbnailsBucket");
                    if(configuration.has("firebaseDb"))

                        firebaseDb = configuration.getString("firebaseDb");
                    api = configuration.getString("api");
                    otpValidationRequired = configuration.getBoolean("otpValidation");
                    adminApprovalRequired = configuration.getBoolean("adminApproval");
                    imageName = tenantsArray.getJSONObject(sel).getString("logo").
                            substring(tenantsArray.getJSONObject(sel).getString("logo").lastIndexOf("/") + 1);

                    JSONObject json = new JSONObject();
                    json.put("serviceEndpoint", accountKey+".irestore.info");
                    json.put("safetyMessage", safetyMessage);
                    json.put("s3BucketName", s3Bucket);
                    json.put("profilePicBucket", profilePicBucket);
                    json.put("profilePicThumbnailsBucket", profilePicThumbnailsBucket);
                    json.put("firebaseDb", firebaseDb);
                    json.put("authToken", token);
                    if(configuration.has("menuOptions"))
                    json.put("menuOptions", configuration.getString("menuOptions"));

                    editor.putString("accountKey",accountKey);
                    editor.putString("serviceEndpoint", accountKey+".irestore.info");
                    editor.putString("safetyMessage",safetyMessage);
                    editor.putString("s3Bucket",s3Bucket);
                    editor.putString("profilePicBucket", profilePicBucket);
                    editor.putString("profilePicThumbnailsBucket", profilePicThumbnailsBucket);
                    editor.putString("firebaseDb", firebaseDb);
                    editor.putString("api",api);
                    editor.putString("owner", accountKey);
                    editor.putBoolean("otpValidationRequired",otpValidationRequired);
                    editor.putBoolean("adminApprovalRequired",adminApprovalRequired);
                    editor.putString("token", token);
                    editor.putString("authToken",token);
                    editor.putString("utilityName", tenantsArray.getJSONObject(sel).getString("name"));
                    editor.putString("responseData", json.toString());
                    editor.putString("userType", "EMPLOYEE");

                    editor.putString("imageName", imageName);
                    editor.putString("imageURL",logo);
                    if(configuration.has("terms"))
                    editor.putString("termsUtility",configuration.getString("terms"));
                    editor.putBoolean("viewCards", viewCards);
                    editor.putBoolean("isTechnician", isTechnician);
                    editor.putBoolean("isSupervisor", isSupervisor);
                    editor.putBoolean("isAdmin", isAdmin);
                    editor.commit();

                    selectedUtility.setVisibility(View.VISIBLE);
                    selectedUtility.setText(tenantsArray.getJSONObject(sel).getString("name"));
                    utilitySelected = true;
                    utilitySelectedOne = true;

                    // }


                }
                else
                {
                    editor.putString("userType", "TOWN_USER");
                    editor.commit();
                    for(int i=0;i<tenantsArray.length();i++) {
                        String positionName = tenantsArray.getJSONObject(i).getString("name");
                        spinnerArray[i] = tenantsArray.getJSONObject(i).getString("name");
                        spinner.setVisibility(View.VISIBLE);
                        utilitySelected = false;
                        utilitySelectedOne = false;
                    }
                }

                ArrayList<String> positionList = new ArrayList<String>(Arrays.asList(spinnerArray));
                positionList.add(0,"--Select Utility--");
                String[] positions = positionList.toArray(new String[positionList.size()]);

                adapter = new ArrayAdapter<String>(Main3Activity.this, R.layout.spinner_item,
                        positions);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);


            }
            else
            {
                String fr_status;
                String termsConditions;
                if(subscriptionsArray.getJSONObject(0).has("subscriptionStatus"))
                {
                    fr_status = subscriptionsArray.getJSONObject(0).getString("subscriptionStatus");
                }
                else {
                    fr_status = "";
                }

               /* if(subscriptionsArray.getJSONObject(0).has("deviceString"))
                {
                    String deviceString = subscriptionsArray.getJSONObject(0).getString("deviceString");
                    editor.putString("deviceString",deviceString);
                    editor.commit();
                }
                *///vidisha commented for device string


                if(subscriptionsArray.getJSONObject(0).has("terms"))
                    termsConditions = subscriptionsArray.getJSONObject(0).getString("terms");
                else
                    termsConditions="";//vidisha did


                if (!termsConditions.isEmpty()) {
                    termsAccepted = true;
                }
                else {
                    termsAccepted = false;
                }

                editor.putBoolean("termsAccepted", termsAccepted);
//added
                editor.putString("firstName", userArray.getJSONObject(0).getString("firstName"));
                editor.putString("lastName", userArray.getJSONObject(0).getString("lastName"));
                editor.putString("emailAddress", userArray.getJSONObject(0).getString("email"));
                if(userArray.getJSONObject(0).has("primaryPhone"))
                    editor.putString("primaryPhone", userArray.getJSONObject(0).getString("primaryPhone"));
                else
                    editor.putString("primaryPhone", "");
                if(userArray.getJSONObject(0).has("departmentId"))
                    editor.putInt("departmentId", userArray.getJSONObject(0).getInt("departmentId"));


                editor.putString("phoneNumber", phoneNo);
                editor.putString("jobTitle", userArray.getJSONObject(0).getString("job"));
                editor.putString("organization", userArray.getJSONObject(0).getString("organization"));
                editor.putString("city", userArray.getJSONObject(0).getString("city"));
                editor.putString("state", userArray.getJSONObject(0).getString("state"));
                editor.putString("county", userArray.getJSONObject(0).getString("county"));
                if(!userArray.getJSONObject(0).getString("userType").equalsIgnoreCase("TOWN_USER"))
                    editor.putString("owner", userArray.getJSONObject(0).getString("owner"));
                else
                    editor.putString("owner", "");

                if(userArray.getJSONObject(0).has("departmentId"))
                    editor.putInt("departmentId", userArray.getJSONObject(0).getInt("departmentId"));


                editor.putString("userType", userArray.getJSONObject(0).getString("userType"));
                if(userArray.getJSONObject(0).has("userId"))
                    editor.putString("userID", String.valueOf(userArray.getJSONObject(0).getString("userId")));
                else
                    editor.putString("userID", "0");


                Log.i("vidisha","userID"+userArray.getJSONObject(0).getString("userId"));



                Log.i("vidisha","email domain Found");
                accountKey = tenantsArray.getJSONObject(0).getString("accountKey");

                logo = tenantsArray.getJSONObject(0).getString("logo");
                token = tenantsArray.getJSONObject(0).getString("token");


                new DownloadImage().execute(logo);

                imageName = tenantsArray.getJSONObject(0).getString("logo").
                        substring(tenantsArray.getJSONObject(0).getString("logo").lastIndexOf("/") + 1);

                Log.i("vidisha","DownloadLogo name "+imageName);

                configuration =  tenantsArray.getJSONObject(0).getString("configuration");

                JSONObject configuration = new JSONObject(tenantsArray.getJSONObject(0).getString("configuration"));
                Log.i("vidisha","hello configuration 1111 ");
                if(configuration.has("safetyMessage"))
                safetyMessage = configuration.getString("safetyMessage");
                s3Bucket = configuration.getString("s3Bucket");
                if(configuration.has("profilePicBucket"))
                profilePicBucket = configuration.getString("profilePicBucket");
                if(configuration.has("profilePicThumbnailsBucket"))

                    profilePicThumbnailsBucket = configuration.getString("profilePicThumbnailsBucket");
                if(configuration.has("firebaseDb"))

                    firebaseDb = configuration.getString("firebaseDb");
                api = configuration.getString("api");

                otpValidationRequired = configuration.getBoolean("otpValidation");
                adminApprovalRequired = configuration.getBoolean("adminApproval");

                editor.putString("accountKey",accountKey);
                editor.putString("safetyMessage",safetyMessage);
                editor.putString("imageName",imageName);

                editor.putString("s3Bucket",s3Bucket);
                editor.putString("profilePicBucket", profilePicBucket);
                editor.putString("profilePicThumbnailsBucket", profilePicThumbnailsBucket);
                editor.putString("firebaseDb", firebaseDb);
                editor.putString("api",api);
                editor.putBoolean("otpValidationRequired",otpValidationRequired);
                editor.putBoolean("adminApprovalRequired",adminApprovalRequired);
                editor.putString("token", token);
                editor.putString("authToken",token);
                if(configuration.has("menuOptions"))
                editor.putString("menuOptions", configuration.getString("menuOptions"));
                editor.putString("subscriptionStatus", fr_status);
                editor.putBoolean("termsAccepted", termsAccepted);
                editor.putString("imageName",imageName);
                editor.putString("serviceEndpoint", accountKey+".irestore.info");

                JSONObject json = new JSONObject();
                json.put("serviceEndpoint", accountKey+".irestore.info");
                json.put("safetyMessage", safetyMessage);
                json.put("s3BucketName", s3Bucket);
                json.put("profilePicBucket", profilePicBucket);
                json.put("profilePicThumbnailsBucket", profilePicThumbnailsBucket);
                json.put("firebaseDb", firebaseDb);
                json.put("authToken", token);
                if(configuration.has("menuOptions"))
                json.put("menuOptions", configuration.getString("menuOptions"));

                editor.putString("responseData", json.toString());
                editor.putString("utilityName", tenantsArray.getJSONObject(0).getString("name"));
                editor.putString("imageURL",logo);
                if(configuration.has("terms"))
                editor.putString("termsUtility",configuration.getString("terms"));
                editor.putBoolean("viewCards", viewCards);
                editor.putBoolean("isTechnician", isTechnician);
                editor.putBoolean("isSupervisor", isSupervisor);
                editor.putBoolean("isAdmin", isAdmin);

                selectedUtility.setVisibility(View.VISIBLE);
                selectedUtility.setText(tenantsArray.getJSONObject(sel).getString("name"));
                utilitySelected = true;
                utilitySelectedOne = true;
                editor.commit();


            }

          /*  if(userArray==null||userArray.length()==0)
            {
                for(int i=0;i<tenantsArray.length();i++)
                {
                    Log.i("vidisha","1111111111");
                    if(tenantsArray.getJSONObject(i).getString("emailDomains").contains(emailC))
                    {
                        Log.i("vidisha","222222");
                        sel=i;
                        emailDomainFound = true;

                        break;
                    }

                }

                if(emailDomainFound)
                {
                    Log.i("vidisha","email domain Found");
                    accountKey = tenantsArray.getJSONObject(sel).getString("accountKey");
                    Log.i("vidisha","email domain Found"+accountKey);
                    logo = tenantsArray.getJSONObject(sel).getString("logo");
                    token = tenantsArray.getJSONObject(sel).getString("token");
                    Log.i("vidisha","hello token");
                    configuration =  tenantsArray.getJSONObject(sel).getString("configuration");
                    Log.i("vidisha","hello configuration");
                    JSONObject configuration = new JSONObject(tenantsArray.getJSONObject(sel).getString("configuration"));
                    safetyMessage = configuration.getString("safetyMessage");
                    s3Bucket = configuration.getString("s3Bucket");
                    api = configuration.getString("api");
                    otpValidationRequired = configuration.getBoolean("otpValidation");
                    adminApprovalRequired = configuration.getBoolean("adminApproval");
                    editor.putString("accountKey",accountKey);
                    editor.putString("safetyMessage",safetyMessage);
                    editor.putString("s3Bucket",s3Bucket);
                    editor.putString("api",api);
                    editor.putString("owner", accountKey);
                    editor.putBoolean("otpValidationRequired",otpValidationRequired);
                    editor.putBoolean("adminApprovalRequired",adminApprovalRequired);
                    editor.putString("token", token);
                    editor.putString("utilityName", tenantsArray.getJSONObject(sel).getString("name"));

                    JSONObject json = new JSONObject();
                    json.put("serviceEndpoint", accountKey);
                    json.put("safetyMessage", safetyMessage);
                    json.put("s3BucketName", s3Bucket);
                    json.put("authToken", token);
                    json.put("menuOptions", configuration.getString("menuOptions"));

                    editor.putString("responseData", json.toString());
                    editor.putString("userType", "EMPLOYEE");


                    imageName = tenantsArray.getJSONObject(sel).getString("logo").
                            substring(tenantsArray.getJSONObject(sel).getString("logo").lastIndexOf("/") + 1);

                    editor.putString("imageName", imageName);
                    editor.putString("imageURL",logo);

                    editor.commit();
                    utilitySelected = true;

                    editor.putString("userType", "EMPLOYEE");
                    editor.commit();


                      selectedUtility.setVisibility(View.VISIBLE);
                      selectedUtility.setText(tenantsArray.getJSONObject(sel).getString("name"));
                    utilitySelected = true;
                    utilitySelectedOne = true;

                   // }


                }
                else
                {
                    editor.putString("userType", "TOWN_USER");
                    editor.commit();
                    for(int i=0;i<tenantsArray.length();i++) {
                        String positionName = tenantsArray.getJSONObject(i).getString("name");
                        spinnerArray[i] = tenantsArray.getJSONObject(i).getString("name");
                        spinner.setVisibility(View.VISIBLE);
                        utilitySelected = false;
                        utilitySelectedOne = false;
                    }
                }

                ArrayList<String> positionList = new ArrayList<String>(Arrays.asList(spinnerArray));
                positionList.add(0,"--Select Utility--");
                String [] positions = positionList.toArray(new String[positionList.size()]);

                adapter = new ArrayAdapter<String>(Main3Activity.this, R.layout.spinner_item,
                        positions);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);


            }
            else
            {
                String fr_status;
                String termsConditions;
                if(userArray.getJSONObject(0).has("subscriptionStatus"))
                {
                    fr_status = userArray.getJSONObject(0).getString("subscriptionStatus");
                }
                else {
                    fr_status = "";
                }


                if(userArray.getJSONObject(0).has("terms"))
                    termsConditions = userArray.getJSONObject(0).getString("terms");
                else
                    termsConditions="";//vidisha did


                if (!termsConditions.isEmpty()) {
                    termsAccepted = true;
                }
                else {
                    termsAccepted = false;
                }

                editor.putBoolean("termsAccepted", termsAccepted);
//added
                editor.putString("firstName", userArray.getJSONObject(0).getString("firstName"));
                editor.putString("lastName", userArray.getJSONObject(0).getString("lastName"));
                editor.putString("emailAddress", userArray.getJSONObject(0).getString("email"));
                if(userArray.getJSONObject(0).has("primaryPhone"))
                    editor.putString("primaryPhone", userArray.getJSONObject(0).getString("primaryPhone"));
                else
                    editor.putString("primaryPhone", "");
                editor.putString("phoneNumber", phoneNo);
                editor.putString("jobTitle", userArray.getJSONObject(0).getString("job"));
                editor.putString("organization", userArray.getJSONObject(0).getString("organization"));
                editor.putString("city", userArray.getJSONObject(0).getString("city"));
                editor.putString("state", userArray.getJSONObject(0).getString("state"));
                editor.putString("county", userArray.getJSONObject(0).getString("county"));
                if(!userArray.getJSONObject(0).getString("userType").equalsIgnoreCase("TOWN_USER"))
                   editor.putString("owner", userArray.getJSONObject(0).getString("owner"));
                else
                    editor.putString("owner", "");

                editor.putString("userType", userArray.getJSONObject(0).getString("userType"));
                if(userArray.getJSONObject(0).has("userId"))
                    editor.putString("userID", String.valueOf(userArray.getJSONObject(0).getString("userId")));
                else
                    editor.putString("userID", "0");



                Log.i("vidisha","email domain Found");
                accountKey = tenantsArray.getJSONObject(0).getString("accountKey");

                logo = tenantsArray.getJSONObject(0).getString("logo");
                token = tenantsArray.getJSONObject(0).getString("token");


                new DownloadImage().execute(logo);

                imageName = tenantsArray.getJSONObject(0).getString("logo").
                        substring(tenantsArray.getJSONObject(0).getString("logo").lastIndexOf("/") + 1);

                Log.i("vidisha","DownloadLogo name "+imageName);

                configuration =  tenantsArray.getJSONObject(0).getString("configuration");

                JSONObject configuration = new JSONObject(tenantsArray.getJSONObject(0).getString("configuration"));
                Log.i("vidisha","hello configuration 1111 ");
                safetyMessage = configuration.getString("safetyMessage");
                s3Bucket = configuration.getString("s3Bucket");
                api = configuration.getString("api");

                otpValidationRequired = configuration.getBoolean("otpValidation");
                adminApprovalRequired = configuration.getBoolean("adminApproval");

                editor.putString("accountKey",accountKey);
                editor.putString("safetyMessage",safetyMessage);
                editor.putString("imageName",imageName);

                editor.putString("s3Bucket",s3Bucket);
                editor.putString("api",api);
                editor.putBoolean("otpValidationRequired",otpValidationRequired);
                editor.putBoolean("adminApprovalRequired",adminApprovalRequired);
                editor.putString("token", token);
                editor.putString("menuOptions", configuration.getString("menuOptions"));
                editor.putString("subscriptionStatus", fr_status);
                editor.putBoolean("termsAccepted", termsAccepted);
                editor.putString("imageName",imageName);

                JSONObject json = new JSONObject();
                json.put("serviceEndpoint", accountKey);
                json.put("safetyMessage", safetyMessage);
                json.put("s3BucketName", s3Bucket);
                json.put("authToken", token);
                json.put("menuOptions", configuration.getString("menuOptions"));

                editor.putString("responseData", json.toString());
                editor.putString("utilityName", tenantsArray.getJSONObject(0).getString("name"));
                editor.putString("imageURL",logo);


                selectedUtility.setVisibility(View.VISIBLE);
                selectedUtility.setText(tenantsArray.getJSONObject(sel).getString("name"));
                utilitySelected = true;
                utilitySelectedOne = true;
                editor.commit();



            }
        }else
        {

        }
*/
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        // Showing selected spinner item
        //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        JSONObject selectedTenant ;
        try {
            if(i!=0) {

                    selectedTenant = tenantsArray.getJSONObject(i-1);
                Log.i("vidisha","hello"+selectedTenant);


                if(item.equalsIgnoreCase(selectedTenant.getString("name")))
                {
                    String logoURL;
                    accountKey = selectedTenant.getString("accountKey");
                    token = selectedTenant.getString("token");
                    configuration =  selectedTenant.getString("configuration");
                    JSONObject configuration = new JSONObject(selectedTenant.getString("configuration"));
                    if(configuration.has("safetyMessage"))
                    safetyMessage = configuration.getString("safetyMessage");
                    s3Bucket = configuration.getString("s3Bucket");
                    profilePicBucket = configuration.getString("profilePicBucket");
                    profilePicThumbnailsBucket = configuration.getString("profilePicThumbnailsBucket");
                    firebaseDb = configuration.getString("firebaseDb");
                    api = configuration.getString("api");
                    otpValidationRequired = configuration.getBoolean("otpValidation");
                    adminApprovalRequired = configuration.getBoolean("adminApproval");
                    logoURL = selectedTenant.getString("logo");


                    imageName = selectedTenant.getString("logo").
                            substring(selectedTenant.getString("logo").lastIndexOf("/") + 1);

                    editor.putString("accountKey",accountKey);
                    editor.putString("safetyMessage",safetyMessage);
                    editor.putString("s3Bucket",s3Bucket);
                    editor.putString("profilePicBucket",profilePicBucket);
                    editor.putString("profilePicThumbnailsBucket",profilePicThumbnailsBucket);
                    editor.putString("firebaseDb",firebaseDb);

                    editor.putString("api",api);
                    editor.putBoolean("otpValidationRequired",otpValidationRequired);
                    editor.putBoolean("adminApprovalRequired",adminApprovalRequired);
                    editor.putString("imageName",imageName);
                    editor.putString("owner", "");//not found
                    editor.putString("token", token);
                    editor.putString("authToken",token);
                    if(configuration.has("menuOptions"))
                    editor.putString("menuOptions", configuration.getString("menuOptions"));
                    editor.putString("userID","0");
                    editor.putString("imageURL",logoURL);

                    Log.i("vidisha","Imageurl1111"+token);

                    JSONObject json = new JSONObject();
                    json.put("serviceEndpoint", accountKey+".irestore.info");
                    json.put("safetyMessage", safetyMessage);
                    json.put("s3BucketName", s3Bucket);
                    json.put("profilePicBucket", profilePicBucket);
                    json.put("profilePicThumbnailsBucket", profilePicThumbnailsBucket);
                    json.put("firebaseDb", firebaseDb);

                    json.put("authToken", token);
                    if(configuration.has("menuOptions"))
                    json.put("menuOptions", configuration.getString("menuOptions"));
                    editor.putString("responseData", json.toString());
                    editor.putString("termsUtility",configuration.getString("terms"));
                    editor.putString("utilityName", selectedTenant.getString("name"));
                    editor.putString("serviceEndpoint", accountKey+".irestore.info");
                    editor.putBoolean("viewCards", viewCards);
                    editor.putBoolean("isTechnician", isTechnician);
                    editor.putBoolean("isSupervisor", isSupervisor);
                    editor.putBoolean("isAdmin", isAdmin);
                    editor.commit();
                    utilitySelected = true;
                    utilitySelectedOne = true;
                   // editor.putString("tenantID",selectedTenant.getString("tenantID"));


                }
            }
            else
            {
                utilitySelected = false;
                utilitySelectedOne =true;

            }
            /*else
            {
                Toast.makeText(LoginScreen.this, getResources().getString(R.string.select_utility),
                        Toast.LENGTH_SHORT).show();
            }*/

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == REQUEST_ID_MULTIPLE_PERMISSIONS) {


            if (grantResults.length > 0) {
                for (int i = 0; i < permissions.length; i++) {


                    if (permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            Log.e("msg", "storage granted");

                        }
                    }
                    else if (permissions[i].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            Log.e("msg", "storage granted");

                        }
                        else if (permissions[i].equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                Log.e("msg", "location granted");

                            }
                        }
                        else if (permissions[i].equals(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                Log.e("msg", "location granted");

                            }
                        } else if (permissions[i].equals(Manifest.permission.CAMERA)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                Log.e("msg", "camerqa granted");

                            }
                        }
                        else if (permissions[i].equals(Manifest.permission.READ_PHONE_STATE)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                Log.e("msg", "read phone granted");

                            }
                        }
                      /*  else if (permissions[i].equals(Manifest.permission.FLASHLIGHT)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                android.util.Log.e("msg", "flashlight granted");

                            }
                        }*/


                    }

                }


            }}}

    // DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
             /*   editor.putString("imageName", imageName);
                editor.commit();*/
                SaveImage(bitmap,sharedPref.getString("imageName",imageName));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {


        }

        private void SaveImage(Bitmap finalBitmap, String imageName) {
            Log.i("vidisha","Saving Image");

            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + "/DCIM/VDA/TenantLogo");
            myDir.mkdirs();

            File file = new File(myDir, imageName);
            if (file.exists ()) file.delete ();
            try {
                FileOutputStream out = new FileOutputStream(file);
                finalBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class HttpGetRequest extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        @Override
        protected String doInBackground(String... params){
            String stringUrl = params[0];
            String result;
            String inputLine;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(stringUrl);
                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.setRequestProperty ("x-account-key", sharedPref.getString("accountKey",""));
                connection.setRequestProperty ("x-access-token", sharedPref.getString("token",""));
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("x-application", appKey);
                connection.setRequestProperty("x-user", sharedPref.getString("phoneNumber",""));
                Log.i("vidisha","hello token ==="+sharedPref.getString("token",""));
                //Connect to our url
                connection.connect();
                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();
                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();
            }
            catch(IOException e){
                e.printStackTrace();
                result = null;
            }
            return result;
        }
        protected void onPostExecute(String result){
            // super.onPostExecute(result);
            Log.i(appKey,"EnterOTP==="+result);
            if(result!=null) {
                JSONObject otpObject;
                try {
                    otpObject = new JSONObject(result);
                    editor.putString("otpValue", otpObject.getString("OTP"));
               /* editor.putString("emailAddress", email.getText().toString().trim());
                editor.putString("phoneNumber", phoneNo);*/
                    editor.commit();
                    Intent intent = new Intent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setClass(Main3Activity.this, EnterOTP.class);
                    startActivity(intent);
                    if (Global.progress.isShowing()) {
                        Global.stopProgressBar();
                    }

                } catch (Exception e) {

                }
            }else
            {
                if (Global.progress.isShowing()) {
                    Global.stopProgressBar();
                }

            }

        }
    }

    private void SaveImage(Bitmap finalBitmap, String imageName) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/DCIM/VDA/TenantLogo");
        myDir.mkdirs();

        File file = new File(myDir, imageName);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


class PhoneNumberFormatter2 implements TextWatcher {
    //This TextWatcher sub-class formats entered numbers as 1 (123) 456-7890
    private boolean mFormatting; // this is a flag which prevents the
    // stack(onTextChanged)
    private boolean clearFlag;
    private int mLastStartLocation;
    private String mLastBeforeText;
    private WeakReference<EditText> mWeakEditText;

    public PhoneNumberFormatter2(WeakReference<EditText> weakEditText) {
        this.mWeakEditText = weakEditText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        if (after == 0 && s.toString().equals("1 ")) {
            clearFlag = true;
        }
        mLastStartLocation = start;
        mLastBeforeText = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
        // TODO: Do nothing
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Make sure to ignore calls to afterTextChanged caused by the work
        // done below
        if (!mFormatting) {
            mFormatting = true;
            int curPos = mLastStartLocation;
            String beforeValue = mLastBeforeText;
            String currentValue = s.toString();
            String formattedValue = formatUsNumber(s);
            if (currentValue.length() > beforeValue.length()) {
                int setCusorPos = formattedValue.length()
                        - (beforeValue.length() - curPos);
                mWeakEditText.get().setSelection(setCusorPos < 0 ? 0 : setCusorPos);
            } else {
                int setCusorPos = formattedValue.length()
                        - (currentValue.length() - curPos);
                if(setCusorPos > 0 && !Character.isDigit(formattedValue.charAt(setCusorPos -1))){
                    setCusorPos--;
                }
                mWeakEditText.get().setSelection(setCusorPos < 0 ? 0 : setCusorPos);
            }
            mFormatting = false;
        }
    }

    private String formatUsNumber(Editable text) {
        StringBuilder formattedString = new StringBuilder();
        // Remove everything except digits
        int p = 0;
        while (p < text.length()) {
            char ch = text.charAt(p);
            if (!Character.isDigit(ch)) {
                text.delete(p, p + 1);
            } else {
                p++;
            }
        }
        // Now only digits are remaining
        String allDigitString = text.toString();

        int totalDigitCount = allDigitString.length();

        if (totalDigitCount == 0
                || (totalDigitCount > 10 && !allDigitString.startsWith("1"))
                || totalDigitCount > 11) {
            // May be the total length of input length is greater than the
            // expected value so we'll remove all formatting
            text.clear();
            text.append(allDigitString);
            return allDigitString;
        }
        int alreadyPlacedDigitCount = 0;
        // Only '1' is remaining and user pressed backspace and so we clear
        // the edit text.
        if (allDigitString.equals("1") && clearFlag) {
            text.clear();
            clearFlag = false;
            return "";
        }
        /*if (allDigitString.startsWith("1")) {
            formattedString.append("1 ");
            alreadyPlacedDigitCount++;
        }*/
        // The first 3 numbers beyond '1' must be enclosed in brackets "()"
        if (totalDigitCount - alreadyPlacedDigitCount > 3) {
            formattedString.append("("
                    + allDigitString.substring(alreadyPlacedDigitCount,
                    alreadyPlacedDigitCount + 3) + ") ");
            alreadyPlacedDigitCount += 3;
        }
        // There must be a '-' inserted after the next 3 numbers
        if (totalDigitCount - alreadyPlacedDigitCount > 3) {
            formattedString.append(allDigitString.substring(
                    alreadyPlacedDigitCount, alreadyPlacedDigitCount + 3)
                    + "-");
            alreadyPlacedDigitCount += 3;
        }
        // All the required formatting is done so we'll just copy the
        // remaining digits.
        if (totalDigitCount > alreadyPlacedDigitCount) {
            formattedString.append(allDigitString
                    .substring(alreadyPlacedDigitCount));
        }

        text.clear();
        text.append(formattedString.toString());
        return formattedString.toString();
    }


}


