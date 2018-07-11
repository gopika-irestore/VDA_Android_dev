package vda.irestore.com.vda_android.signup;

import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Pattern;


import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.R;
import vda.irestore.com.vda_android.services.GPSTracker;

import static vda.irestore.com.vda_android.Global.Global.appKey;

public class MyProfile extends BaseActivity {
    File file;
    TransferUtility transferUtility;
    Uri uri;
    Intent CamIntent, GalIntent, CropIntent ;
    EditText email,phone,firstName,lastName,jobTitle,organization,city,state,county;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    TextView uploadPhotoLabel;
    Boolean acceptance;
    Boolean updateProfile = false;
    Boolean isdataEntered = false , userCreated;
    Button nextBtn;
    ImageView profileImg;
    public static String profileImageUrl;
    private static final int PICK_IMAGE_ID = 234; // the number doesn't matter
    String saftyMessage,registeredEmail,registeredPhone,registeredfName,registeredlName,
            registeredJobTitle,registeredOrg,terms,userID,tenantName,registeredCity,rigisteredCounty,registeredState;
    GPSTracker gps;
    Exception exception;
    String httpPostData,serviceEndPoint,authToken;
    private static final char PARAMETER_DELIMITER = '&';
    private static final char PARAMETER_EQUALS_CHAR = '=';
    private static final int CONNECTION_TIMEOUT = 3000;
    String responseJSON , selectedUser;
    JSONObject responseData = null;
    JSONArray tenantsArray,userArray;
    Boolean isTestTenant ;
    FileCache fileCache;
    File mypath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        fileCache=new FileCache(this);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        profileImg = (ImageView)findViewById(R.id.profileImg);
        Global.credentialsProvider(this);
        setTransferUtility();
        registeredEmail = sharedPref.getString("emailAddress", "");
        registeredPhone = sharedPref.getString("phoneNumber", "");
        registeredfName = sharedPref.getString("firstName", "");
        registeredlName = sharedPref.getString("lastName", "");

        registeredJobTitle = sharedPref.getString("jobTitle", "");
        registeredOrg = sharedPref.getString("organization", "");
        registeredCity=  sharedPref.getString("city", "");
        registeredState=  sharedPref.getString("state", "");
        rigisteredCounty=  sharedPref.getString("county", "");

        authToken = sharedPref.getString("token","");
        tenantName = sharedPref.getString("accountKey","");

        uploadPhotoLabel = (TextView)findViewById(R.id.uploadPhotoLabel);

        email = (EditText)findViewById(R.id.registeredEmail) ;
         phone = (EditText)findViewById(R.id.registeredNumber) ;
         firstName = (EditText)findViewById(R.id.firstName) ;
         lastName = (EditText)findViewById(R.id.lastName) ;
         jobTitle = (EditText)findViewById(R.id.title) ;
         organization = (EditText)findViewById(R.id.organization) ;
         city = (EditText)findViewById(R.id.city) ;
         county = (EditText)findViewById(R.id.county) ;
         state = (EditText)findViewById(R.id.state) ;


         nextBtn = (Button) findViewById(R.id.signOutBtn) ;

        email.setText(registeredEmail);
        phone.setText(registeredPhone);

        firstName.setText(registeredfName);
        lastName.setText(registeredlName);
        jobTitle.setText(registeredJobTitle);
        organization.setText(registeredOrg);
        city.setText(registeredCity);
        county.setText(rigisteredCounty);
        state.setText(registeredState);
        Log.i("vidisha","chittor"+sharedPref.getBoolean("userProfileCreated", false));




        email.setTypeface(typeFace);
        phone.setTypeface(typeFace);
        firstName.setTypeface(typeFace);
        lastName.setTypeface(typeFace);
        jobTitle.setTypeface(typeFace);
        organization.setTypeface(typeFace);
        city.setTypeface(typeFace);
        county.setTypeface(typeFace);
        state.setTypeface(typeFace);
        nextBtn.setTypeface(typeFace);
        File myDir = new File(Environment.getExternalStorageDirectory().toString() + "/DCIM/VDA/" +  sharedPref.getString("userID","")+".png");

        if(myDir.exists()) {
            Log.i("vidisha","exists!!!");
            File f = new File(Environment.getExternalStorageDirectory().toString()+ "/DCIM/VDA/" + sharedPref.getString("userID", "") + ".png");
            Bitmap b = null;
            try {
                b = BitmapFactory.decodeStream(new FileInputStream(f));
                Log.i("vidisha","exists!!!"+b);
                profileImg.setImageBitmap(b);
                profileImg.setEnabled(true);
                uploadPhotoLabel.setText("Edit Photo");
            } catch (FileNotFoundException e) {
                Log.i("vidisha","exists!!!"+b);
                e.printStackTrace();
            }

        }
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   selectImage();
              /*  Intent chooseImageIntent = ImagePicker.getPickImageIntent(MyProfile.this);
                startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);*/
                CropImage.activity().setAllowRotation(false).setAllowFlipping(false)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(MyProfile.this);

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.empty_fname),
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (!isValidName(firstName.getText().toString().trim())) {
                        Toast.makeText(MyProfile.this, getResources().getString(R.string.invalid_fname),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (firstName.getText().toString().trim().length() > 150) {
                        Toast.makeText(MyProfile.this, "First Name "
                                        + getResources().getString(R.string.invalid_field_length1),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                if (lastName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.empty_lname),
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (!isValidName(lastName.getText().toString().trim())) {
                        Toast.makeText(MyProfile.this, getResources().getString(R.string.invalid_lname),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (lastName.getText().toString().trim().length() > 150) {
                        Toast.makeText(MyProfile.this, "Last Name "
                                        + getResources().getString(R.string.invalid_field_length1),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                if (jobTitle.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.empty_title),
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (!isValidTitle(jobTitle.getText().toString().trim())) {
                        Toast.makeText(MyProfile.this, getResources().getString(R.string.invalid_title),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (jobTitle.getText().toString().trim().length() > 150) {
                        Toast.makeText(MyProfile.this, "Job title "
                                        + getResources().getString(R.string.invalid_field_length1),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                if (organization.getText().toString().isEmpty()) {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.empty_Organization),
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (!isValidTitle(organization.getText().toString().trim())) {
                        Toast.makeText(MyProfile.this, getResources().getString(R.string.invalid_org),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (organization.getText().toString().trim().length() > 150) {
                        Toast.makeText(MyProfile.this, "Organization name "
                                        + getResources().getString(R.string.invalid_field_length1),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if (Global.currentLocation != null)
                {
                    if(!sharedPref.getBoolean("userProfileCreated", false))
                    {
                        HashMap<String, String> params = new HashMap<String, String>();
                        params.put("email", email.getText().toString());
                        params.put("phone", phone.getText().toString());

                        if (!sharedPref.getString("primaryPhone", "").isEmpty())
                            params.put("primaryPhone", sharedPref.getString("primaryPhone", ""));
                        else
                            params.put("primaryPhone", phone.getText().toString());
                        params.put("firstName", firstName.getText().toString().trim());
                        params.put("lastName", lastName.getText().toString().trim());
                        if (sharedPref.getString("userType", "").equalsIgnoreCase("TOWN_USER"))
                            params.put("owner", "");
                        else
                            params.put("owner", sharedPref.getString("accountKey", ""));
                        params.put("organization", organization.getText().toString().trim());
                        params.put("job", jobTitle.getText().toString().trim());
                        params.put("city", city.getText().toString().trim());
                        params.put("state", state.getText().toString().trim());//vidisha changed
                        params.put("county", county.getText().toString().trim());
                        params.put("userType", sharedPref.getString("userType", ""));

                        if (Global.isNetworkAvailable(MyProfile.this)) {
                            Global.createAndStartProgressBar(MyProfile.this);
                            httpPostData = createQueryStringForParameters(params);
                            STAsyncHttpConnection async = new STAsyncHttpConnection();
                            async.execute(Global.createProfile);
                        } else {
                            Toast.makeText(MyProfile.this, getResources().getString(R.string.internet_error),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {

                        if (!jobTitle.getText().toString().trim().equalsIgnoreCase(registeredJobTitle)
                                || !organization.getText().toString().trim().equalsIgnoreCase(registeredOrg)
                                || !city.getText().toString().trim().equalsIgnoreCase(registeredCity)
                                || !state.getText().toString().trim().equalsIgnoreCase(registeredCity)
                                || !county.getText().toString().trim().equalsIgnoreCase(rigisteredCounty)
                                || !firstName.getText().toString().trim().equalsIgnoreCase(registeredfName)
                                || !lastName.getText().toString().trim().equalsIgnoreCase(registeredlName)
                                ) {
                            HashMap<String, String> params = new HashMap<String, String>();
                            params.put("email", email.getText().toString());
                            params.put("phone", phone.getText().toString());


                            if (!sharedPref.getString("primaryPhone", "").isEmpty())
                                params.put("primaryPhone", sharedPref.getString("primaryPhone", ""));
                            else
                                params.put("primaryPhone", phone.getText().toString());
                            params.put("firstName", firstName.getText().toString().trim());
                            params.put("lastName", lastName.getText().toString().trim());
                            if (sharedPref.getString("userType", "").equalsIgnoreCase("TOWN_USER"))
                                params.put("owner", "");
                            else
                                params.put("owner", sharedPref.getString("accountKey", ""));
                            params.put("organization", organization.getText().toString().trim());
                            params.put("job", jobTitle.getText().toString().trim());
                            params.put("city", city.getText().toString());
                            params.put("state", state.getText().toString());//vidisha changed
                            params.put("county", county.getText().toString().trim());
                            params.put("userType", sharedPref.getString("userType", ""));

                            if (Global.isNetworkAvailable(MyProfile.this)) {
                                Global.createAndStartProgressBar(MyProfile.this);
                                httpPostData = createQueryStringForParameters(params);
                                STAsyncHttpConnection async = new STAsyncHttpConnection();
                                async.execute(Global.updateProfile);
                            } else {
                                Toast.makeText(MyProfile.this, getResources().getString(R.string.internet_error),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            finish();;
                            if(profileImageUrl!=null)
                            updateImageToUpload(sharedPref.getString("userID",""));

                        }
                    }

                }else {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.no_location),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_titlebar, null);

        ActionBar actionBar = getActionBar();
        TextView title = (TextView) v.findViewById(R.id.title);
        Button nextBtn1 = (Button)v.findViewById(R.id.nextBtn) ;
        nextBtn1.setVisibility(View.INVISIBLE);
        title.setText("My Profile");
        title.setTypeface(typeFace);

        if(!sharedPref.getString("phoneNumber","").isEmpty()) {
            v.setBackgroundColor(Color.WHITE);
            title.setTextColor(Color.parseColor("#00CC99"));

        }
        else {
            nextBtn.setBackground(getResources().getDrawable(R.drawable.button_blue));
            v.setBackgroundColor(Color.parseColor("#018FD9"));
            title.setTextColor(Color.WHITE);
        }

        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled (false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(v);


    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                //  cropImageView.setImageUriAsync(resultUri);
                Bitmap bitmap = BitmapFactory.decodeFile(resultUri.getPath());
                profileImg.setImageBitmap(bitmap);

                saveProfilePic(bitmap);


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case PICK_IMAGE_ID:
                Bitmap bitmap = ImagePicker.getImageFromResult(this, resultCode, data);
                //  imageView.setImageBitmap(bitmap);
                if(bitmap!=null) {
                    uri = getImageUri(MyProfile.this, bitmap);
                    ImageCropFunction();
                }
                // TODO use bitmap
                break;
            case 1:

                Log.i("vidisha","11111111");
                if (data != null) {
                    Log.i("vidisha","222222222");

                    Bitmap bitmap1 = ImagePicker.getImageFromResult(this, resultCode, data);

                    profileImg.setImageBitmap(bitmap1);
                    saveProfilePic(bitmap1);

                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }*/
    public void ImageCropFunction() {

        // Image Crop Code
        try {
            CropIntent = new Intent("com.android.camera.action.CROP");

            CropIntent.setDataAndType(uri, "image/*");

           /* CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 180);
            CropIntent.putExtra("outputY", 180);
            CropIntent.putExtra("aspectX", 3);
            CropIntent.putExtra("aspectY", 4);
            CropIntent.putExtra("scaleUpIfNeeded", true);
            CropIntent.putExtra("return-data", true);*/

            CropIntent.putExtra("outputX", 180);
            CropIntent.putExtra("outputY", 180);
            CropIntent.putExtra("aspectX", 1);
            CropIntent.putExtra("aspectY", 1);
            CropIntent.putExtra("scale", true);
            CropIntent.putExtra("circleCrop", new String(""));
            String deviceMan = android.os.Build.MANUFACTURER;
            Log.i("vidisha","deviceMan"+deviceMan);
            if(deviceMan.equalsIgnoreCase("LGE")||deviceMan.equalsIgnoreCase("Xiaomi")||deviceMan.equalsIgnoreCase("motorola")||deviceMan.contains("Xiaomi")||deviceMan.contains("Redmi")||deviceMan.contains("Mi")) {

                CropIntent.putExtra("return-data", true);

            }else
            {

                CropIntent.putExtra("return-data", false);
                // CropIntent.putExtra("return-data", true);
         /*   File cropImageFile = new File(CROP_IMAGE_PATH); // Path to save the cropped image
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(cropImageFile));*/
                // startActivityForResult(intent, CROP);

                CropIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

            }
            startActivityForResult(CropIntent, 1);

        } catch (ActivityNotFoundException e) {

        }
    }
    private void saveProfilePic(Bitmap bitmapImage){
        try {
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            // path to /data/data/yourapp/app_data/imageDir
            File directory = cw.getDir("profilePicDirectory", Context.MODE_PRIVATE);
            // Create imageDir
            mypath=new File(directory,sharedPref.getString("phoneNumber","") + ".png");

            if (mypath.exists())
                mypath.delete();
            FileOutputStream fos = null;
            fos = new FileOutputStream(mypath);

            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
            profileImageUrl = mypath.toString();
            Log.i("vidisha","profile=="+profileImageUrl);
            editor.putString("profileImage",profileImageUrl);
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTransferUtility(){
        transferUtility = new TransferUtility(Global.s3, getApplicationContext());
    }


    public void updateImageToUpload(String userId){
        // for(int i=0;i< images_array.size();i++) {

        TransferObserver transferObserverUser = transferUtility.upload(
                sharedPref.getString("profilePicBucket",""),     /* The bucket to upload to */
                (sharedPref.getString("phoneNumber","") + ".png").replace(sharedPref.getString("phoneNumber",""),userId), new File(profileImageUrl)      /* The key for the uploaded object */
                    , CannedAccessControlList.PublicRead    /* The file where the data to upload exists */
        );


        transferObserverListenerUser(transferObserverUser/*,synProcess*/);
        // }
    }

    public void transferObserverListenerUser(final TransferObserver transferObserverUser/*,String progress*/) {
        // final String syncProgress  = progress;

        transferObserverUser.setTransferListener(new TransferListener() {

            @Override
            public void onStateChanged(int id, TransferState state) {


                if (state == TransferState.COMPLETED) {
                    File myDir = new File(Environment.getExternalStorageDirectory().toString() + "/DCIM/VDA/" +  sharedPref.getString("userID","")+".png");
                    if (myDir.exists()) {
                        myDir.delete();
                      //  new DashboardScreen.DownloadImage().execute("https://s3.amazonaws.com/irestore-profile-pics-dev/163.png");
                    }
                    //  editor.putString(transferObserver.getKey(), "success");
                    // editor.commit();
                    // Toast.makeText(PoleTopActivity_Hardcoded.this, "transfer Succeded! for ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
                Log.e("percentage", percentage + "");
                if(percentage==100)
                {
                    File myDir = new File(Environment.getExternalStorageDirectory().toString() + "/DCIM/VDA/" +  sharedPref.getString("userID","")+".png");
                    if (myDir.exists()) {
                        myDir.delete();
                        //  new DashboardScreen.DownloadImage().execute("https://s3.amazonaws.com/irestore-profile-pics-dev/163.png");
                    }
                }


            }

            @Override
            public void onError(int id, Exception ex) {

                Log.e("error", "error");

            }

        });
    }
    private void loadProfilePic()
    {

        try {
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            // path to /data/data/yourapp/app_data/profilePicDirectory
            File directory = cw.getDir("profilePicDirectory", Context.MODE_PRIVATE);
            // Create imageDir
            File profilePicPath=new File(directory,sharedPref.getString("phoneNumber","") + ".png");

            Log.i("vidisha","hello"+profilePicPath.getName());

            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(profilePicPath));
            if (b != null) {
                profileImg.setImageBitmap(b);
                uploadPhotoLabel.setText("Edit Photo");
                //  profileIcon.setImageBitmap(b);
            }
            else {
                profileImg.setImageResource(R.mipmap.camera);

            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        //fetchLocation();
    }
    private boolean isValidName(String str) {
       // final Pattern pattern = Pattern.compile("[a-zA-z ]+[ '.]?([a-zA-Z ]+)*$");
        final Pattern pattern = Pattern.compile("[a-zA-z .']+[a-zA-Z .]*");

        return pattern.matcher(str).matches();
    }

    private boolean isValidTitle(String str) {
        final Pattern pattern = Pattern.compile("[a-zA-z .]+[a-zA-Z .]*");
        return pattern.matcher(str).matches();
    }

 /*   public void fetchLocation() {
        gps = new GPSTracker(MyProfile.this);
        Utils.currentLocation = gps.getLocation();
        if (gps.canGetLocation() == false) {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            Utils.showGPSAlert(MyProfile.this);
        }
    }*/

    public static String createQueryStringForParameters(HashMap<String, String> parameters) {
        StringBuilder parametersAsQueryString = new StringBuilder();
        if (parameters != null) {
            boolean firstParameter = true;

            for (String parameterName : parameters.keySet()) {
                if (!firstParameter) {
                    parametersAsQueryString.append(PARAMETER_DELIMITER);
                }
                parametersAsQueryString.append(parameterName)
                        .append(PARAMETER_EQUALS_CHAR);
                try {
                    parametersAsQueryString.append(URLEncoder.encode(
                            parameters.get(parameterName), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                firstParameter = false;
            }
        }
        return parametersAsQueryString.toString();
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
                if (httpPostData != null) {

                    if (Log.isLoggable("STAsyncHttpConnection", Log.INFO)) {
                        Log.i("STAsyncHttpConnection", "POST parameters: " + httpPostData);
                    }

                    Log.i("iRestore","authToken=="+authToken);
                    Log.i("iRestore","tenantName=="+tenantName);
                    Log.i("vidisha","hello token  myprofile==="+sharedPref.getString("token",""));
                    Log.i("vidisha","hello token  myprofile==="+sharedPref.getString("accountKey",""));

                   /* urlConnection.setRequestProperty ("x-account-key", tenantName);
                    urlConnection.setRequestProperty ("x-access-token", authToken);*/
                    urlConnection.setRequestProperty ("x-account-key", tenantName);
                    urlConnection.setRequestProperty ("x-access-token", authToken);
                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    urlConnection.setRequestProperty("x-application", appKey);
                    urlConnection.setRequestProperty("x-user",  sharedPref.getString("phoneNumber",""));
                    urlConnection.setDoOutput(true);
                    if(!sharedPref.getBoolean("userProfileCreated",false))
                        urlConnection.setRequestMethod("POST");
                    else
                        urlConnection.setRequestMethod("PUT");
                   // urlConnection.setFixedLengthStreamingMode(
                           // httpPostData.getBytes().length);
                    OutputStream writer =
                            urlConnection.getOutputStream();
                    writer.write(httpPostData.getBytes());
                    writer.flush();
                    writer.close();
                   // PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                    //out.print(httpPostData);
                    //out.flush();
                    //out.close();

                }
                int statusCode = urlConnection.getResponseCode();
                Log.i("iRestore","statusCode My Profile"+statusCode);
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
                }
                else if (statusCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT||statusCode == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
                    result = "{\"Error\" : true, \"Message\" : \"Request Timed out. Please try again later\"}";
                } else if (statusCode == 403) {
                    result = "{\"Error\" : true, \"Message\" : \"Email address has been taken.Please try with a different email address\"}";
                }
                else {
                    result = "{\"Error\" : true, \"Message\" : \"Server Error, please try again later\"}";
                }
            } catch (MalformedURLException ex) {
                exception = ex;
                Log.e("SocketTimeout exception", ex.toString());
            } catch (SocketTimeoutException ex) {
                exception = ex;
                ex.printStackTrace();
                Log.e("SocketTimeout exception", ex.toString());
            }catch(EOFException ef) {
                exception = ef;
                ef.printStackTrace();

                Log.e("EOFException exception", ef.toString());
            }
            catch (IOException ez) {
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
                        Toast.makeText(MyProfile.this, responseObj.getString("Message"),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean viewCards,isTechnician,isSupervisor,isAdmin;
                        if (!sharedPref.getBoolean("userProfileCreated", false)) {
                            Integer userID = responseObj.getJSONArray("User").getJSONObject(0).getInt("userId");

                            if(profileImageUrl!=null)
                            updateImageToUpload(String.valueOf(userID));

                            JSONArray permissionsArray_RVA = responseObj.getJSONArray("Permissions");

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
                                isAdmin = false;
                            }


                            Log.i("userID", "userID===" + userID);
                            editor.putString("userID", String.valueOf(userID));
                            editor.putBoolean("userProfileCreated", true);
                            editor.putBoolean("viewCards", viewCards);
                            editor.putBoolean("isTechnician", isTechnician);
                            editor.putBoolean("isSupervisor", isSupervisor);
                            editor.putBoolean("isAdmin", isAdmin);

                            editor.putString("firstName", firstName.getText().toString().trim());
                            editor.putString("lastName", lastName.getText().toString().trim());
                            editor.putString("jobTitle", jobTitle.getText().toString().trim());
                            editor.putString("organization", organization.getText().toString().trim());
                            editor.putString("city", city.getText().toString().trim());
                            editor.putString("state", state.getText().toString().trim());
                            editor.putString("county", county.getText().toString().trim());
                            editor.commit();

                            if (sharedPref.getBoolean("adminApprovalRequired", false)) {
                                if (!sharedPref.getString("subscriptionStatus", "").equals("approved")) {
                                    Intent intent = new Intent();
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.setClass(MyProfile.this, AdminApprovalScreen.
                                            class);
                                    startActivity(intent);
                                } else {
                                    editor.putBoolean("adminApprovalStatus", true);
                                    Intent loginIntent = new Intent();
                                    loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    loginIntent.setClass(MyProfile.this, TermsConditions.class);
                                    editor.putBoolean("ACCEPTANCE", sharedPref.getBoolean("termsAccepted", false));
                                    editor.commit();
                                    startActivity(loginIntent);
                                    Global.reportSubmitted = true;
                                }
                            } else {
                                editor.putBoolean("adminApprovalStatus", true);
                                Intent loginIntent = new Intent();
                                loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                loginIntent.setClass(MyProfile.this, TermsConditions.class);
                                editor.putBoolean("ACCEPTANCE", sharedPref.getBoolean("termsAccepted", false));
                                editor.commit();
                                startActivity(loginIntent);
                                Global.reportSubmitted = true;
                            }

                        }
                        else
                        {

                            Toast.makeText(MyProfile.this, responseObj.getString("Message"),
                                    Toast.LENGTH_SHORT).show();

                            editor.putString("firstName", firstName.getText().toString().trim());
                            editor.putString("lastName", lastName.getText().toString().trim());
                            editor.putString("jobTitle", jobTitle.getText().toString().trim());
                            editor.putString("organization", organization.getText().toString().trim());
                            editor.putString("city", city.getText().toString().trim());
                            editor.putString("state", state.getText().toString().trim());
                            editor.putString("county", county.getText().toString().trim());
                            editor.commit();
                            finish();
                            if(profileImageUrl!=null)
                            updateImageToUpload(sharedPref.getString("userID",""));

                           /* Intent i = new Intent();
                            i.setClass(MyProfile.this, Main3Activity.class);
                            //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);*/
                        }
                    }
                }catch(Exception e)
                    {

                    }

                } else {
                    Toast.makeText(MyProfile.this, getResources().getString(R.string.error),
                            Toast.LENGTH_SHORT).show();
                }
                if (Global.progress.isShowing()) {
                    Global.stopProgressBar();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}