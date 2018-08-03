package vda.irestore.com.vda_android.signup;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.UUID;


import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.services.MyFirebaseInstanceIDService;
import vda.irestore.com.vda_android.services.MyFirebaseMessagingService;

import static vda.irestore.com.vda_android.Global.Global.appKey;


public class SyncActivity extends BaseActivity {

    Boolean pageNotFound,viewCards,isSupervisor,isTechnician,isAdmin;;
    String serviceEndPoint ;
    String tenantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        serviceEndPoint = sharedPref.getString("serviceEndpoint", "");
        String[] tenantURL = serviceEndPoint.split("\\."); // String array, each element is text between dots

        tenantName = tenantURL[0];

        //setContentView(R.layout.activity_sync);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Global.isNetworkAvailable(SyncActivity.this)) {
            HttpGetRequest async = new HttpGetRequest();
            String s = Global.syncAPI + "&email=" + sharedPref.getString("emailAddress", "") +
                    "&phone=" + sharedPref.getString("phoneNumber", "");
            Log.i("sync", "sync API called==" + s);
            async.execute(s);
        }
    }

    public class HttpGetRequest extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(String... params) {
            String stringUrl = params[0];
            String result=null;
            String inputLine;
            HttpURLConnection connection=null;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(stringUrl);
                //Create a connection
                connection = (HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                Log.i("sync","x-account-key"+sharedPref.getString("accountKey", ""));
                Log.i("sync","x-account-token"+sharedPref.getString("token", ""));


                connection.setRequestProperty("x-account-key", tenantName);
                connection.setRequestProperty("x-access-token", sharedPref.getString("authToken", ""));
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("x-application", appKey);
                connection.setRequestProperty("x-user", sharedPref.getString("phoneNumber",""));

                //Connect to our url
                connection.connect();
                //Create a new InputStreamReader

                int statusCode = connection.getResponseCode();
                if(statusCode == HttpURLConnection.HTTP_OK) {
                    InputStreamReader streamReader = new
                            InputStreamReader(connection.getInputStream());
                    //Create a new buffered reader and String Builder
                    BufferedReader reader = new BufferedReader(streamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    //Check if the line we are reading is not null
                    while ((inputLine = reader.readLine()) != null) {
                        stringBuilder.append(inputLine);
                    }
                    //Close our InputStream and Buffered reader
                    reader.close();
                    streamReader.close();
                    //Set our result equal to our stringBuilder
                    result = stringBuilder.toString();
                    pageNotFound = false;
                }
                else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    pageNotFound = false;
                    result = "{\"Error\" : true, \"Message\" : \"Unauthorized user\"}";
                }
                else if (statusCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT||statusCode == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
                    pageNotFound = false;
                    result = "{\"Error\" : true, \"Message\" : \"Request Timed out. Please try again later\"}";
                }else if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {

                    InputStreamReader streamReader = new
                            InputStreamReader(connection.getErrorStream());
                    //Create a new buffered reader and String Builder
                    BufferedReader reader = new BufferedReader(streamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    //Check if the line we are reading is not null
                    while ((inputLine = reader.readLine()) != null) {
                        stringBuilder.append(inputLine);
                    }
                    //Close our InputStream and Buffered reader
                    reader.close();
                    streamReader.close();
                    //Set our result equal to our stringBuilder
                    result = stringBuilder.toString();
                    pageNotFound = true;
                    Log.i("sync","HTTP_NOT_FOUND"+result);

                    //  result = "{\"Error\" : true, \"Message\" : \"Request Timed out. Please try again later\"}";
                }
                else {
                    pageNotFound = false;
                    result = "{\"Error\" : true, \"Message\" : \"Server Error, please try again later\"}";
                }
            } catch (MalformedURLException ex) {

                Log.e("SocketTimeout exception", ex.toString());
            } catch (SocketTimeoutException ex) {

                Log.e("SocketTimeout exception", ex.toString());
            } catch (IOException ez) {

                ez.printStackTrace();
                Log.e("IO exception", ez.toString());
            } catch (Exception ez) {

                Log.e("exception", ez.toString());
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return result;
        }

        protected void onPostExecute(String result) {
            JSONObject responseObject;
            String message, appDBVersion=null, subscriptionStatus;
            int forceUpgrade =0;
            boolean error;
            Log.i("iRestore", "response===" + result);

            try {
                if (result != null) {

                    responseObject = new JSONObject(result);
                    error = responseObject.getBoolean("Error");


                    if (!error) {

                        JSONArray userArray = responseObject.getJSONArray("User");
                        JSONArray tenantsArray = responseObject.getJSONArray("Owners");
                        JSONArray appVersionArray = responseObject.getJSONArray("AppVersion");
                        JSONArray subsCriptionArray = responseObject.getJSONArray("Subscription");
                        JSONArray permissionsArray_RVA = responseObject.getJSONArray("Permissions");

                        if(permissionsArray_RVA.length()!=0)
                        {
                            viewCards = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("view");
                            isTechnician = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("isTechnician");
                            isSupervisor = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("isSupervisor");
                            isAdmin = permissionsArray_RVA.getJSONObject(0).getJSONObject("permissions").getJSONObject("yellowCards").getBoolean("isAdmin");
   }
                        else {
                            viewCards = false;
                            isTechnician = false;
                            isSupervisor =false;
                            isAdmin =false;
                        }


                        if(appVersionArray.length()!=0) {
                            appDBVersion = appVersionArray.getJSONObject(0).getString("version");
                            forceUpgrade = appVersionArray.getJSONObject(0).getInt("forceUpgrade");
                        }
                        subscriptionStatus = subsCriptionArray.getJSONObject(0).getString("subscriptionStatus");
                        editor.putString("appDBVersion", appDBVersion);
                        editor.putInt("forceUpgrade", forceUpgrade);
                        editor.putString("subscriptionStatus", subscriptionStatus);

                        Log.i("sync","sync subs "+subsCriptionArray.getJSONObject(0).getString("subscriptionStatus"));


                        editor.putBoolean("viewCards", viewCards);
                        editor.putBoolean("isTechnician", isTechnician);
                        editor.putBoolean("isSupervisor", isSupervisor);
                        editor.putBoolean("isAdmin", isAdmin);


                        accountKey = tenantsArray.getJSONObject(0).getString("accountKey");

                        logo = tenantsArray.getJSONObject(0).getString("logo");
                        token = tenantsArray.getJSONObject(0).getString("token");
                        logoURL = tenantsArray.getJSONObject(0).getString("logo");

                        imageName = tenantsArray.getJSONObject(0).getString("logo").
                                substring(tenantsArray.getJSONObject(0).getString("logo").lastIndexOf("/") + 1);

                        configuration = tenantsArray.getJSONObject(0).getString("configuration");

                        JSONObject configuration = new JSONObject(tenantsArray.getJSONObject(0).getString("configuration"));

                        if(configuration.has("safetyMessage"))
                        safetyMessage = configuration.getString("safetyMessage");
                        s3Bucket = configuration.getString("s3Bucket");
                        profilePicBucket = configuration.getString("profilePicBucket");
                        profilePicThumbnailsBucket = configuration.getString("profilePicThumbnailsBucket");
                        firebaseDb = configuration.getString("firebaseDb");


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


                        if (sharedPref.getString("deviceString", "").isEmpty()) {
                            if (subsCriptionArray.getJSONObject(0).has("deviceString"))
                                editor.putString("deviceString", subsCriptionArray.getJSONObject(0).getString("deviceString"));
                            Log.i("sync","inside empty"+subsCriptionArray.getJSONObject(0).getString("deviceString"));
                            editor.commit();

                        }

                        Log.i("sync","outside empty"+subsCriptionArray.getJSONObject(0).getString("deviceString"));
                        Log.i("sync","deviceString=="+sharedPref.getString("deviceString", ""));
                        editor.putString("newDeviceString", subsCriptionArray.getJSONObject(0).getString("deviceString"));
                        editor.putString("responseData", json.toString());
                        editor.putString("imageName", imageName);
                        editor.putString("logoURL", logoURL);

                        editor.putString("serviceEndpoint", accountKey+".irestore.info");
                        editor.putString("token",token);
                        editor.putString("accountKey",accountKey);
                        editor.putString("authToken",token);

                        editor.putString("firstName", userArray.getJSONObject(0).getString("firstName"));
                        editor.putString("lastName", userArray.getJSONObject(0).getString("lastName"));
                        editor.putString("jobTitle", userArray.getJSONObject(0).getString("job"));
                        editor.putString("organization", userArray.getJSONObject(0).getString("organization"));
                        editor.putString("city", userArray.getJSONObject(0).getString("city"));
                        editor.putString("state", userArray.getJSONObject(0).getString("state"));
                        editor.putString("county", userArray.getJSONObject(0).getString("county"));
                        if(userArray.getJSONObject(0).has("departmentId"))
                            editor.putInt("departmentId", userArray.getJSONObject(0).getInt("departmentId"));

                        editor.commit();
                        if(forceUpgrade==1)
                            getCurrentVersion();
                       // editor.commit();

                        Field[] fields = Build.VERSION_CODES.class.getFields();
                        String osName = fields[Build.VERSION.SDK_INT].getName();

                        if(subsCriptionArray.getJSONObject(0).getString("deviceType").isEmpty())
                        {
                            Log.i("sync","Device empty");
                            JSONObject jsonParam = null;
                            JSONObject deviceParam = null;
                            TimeZone tz = TimeZone.getTimeZone("UTC");
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                            df.setTimeZone(tz);

                            try {
                                jsonParam = new JSONObject();
                                jsonParam.put("isAccepted", true);
                                jsonParam.put("version", SyncActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                jsonParam.put("time", df.format(new Date()));
                                jsonParam.put("latitude", String.valueOf(
                                        Global.currentLocation.getLatitude()));
                                jsonParam.put("longitude", String.valueOf(
                                        Global.currentLocation.getLongitude()));


                                deviceParam = new JSONObject();
                                deviceParam.put("type", "ANDROID");
                                deviceParam.put("os", osName);
                                deviceParam.put("make", Build.MANUFACTURER);
                                deviceParam.put("model", Build.MODEL);
                                if(sharedPref.getString("deviceString", "").isEmpty()) {
                                    String deviceString = UUID.randomUUID().toString();
                                    deviceParam.put("deviceString", deviceString);
                                }
                                else
                                {
                                    deviceParam.put("deviceString", sharedPref.getString("deviceString", ""));
                                }
                                deviceParam.put("version", SyncActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                if(sharedPref.getString("pushNotificationToken", "").isEmpty()) {
                                    Log.i("sync","token empty");
                                    startService(new Intent(SyncActivity.this, MyFirebaseInstanceIDService.class));
                                    startService(new Intent(SyncActivity.this, MyFirebaseMessagingService.class));
                                    deviceParam.put("pushNotificationToken", sharedPref.getString("pushNotificationToken", ""));
                                }else
                                {
                                    deviceParam.put("pushNotificationToken", sharedPref.getString("pushNotificationToken", ""));
                                }

                                Log.i("sync", "outside==" + sharedPref.getString("pushNotificationToken", ""));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            HashMap<String, String> params = new HashMap<String, String>();

                            params.put("device", deviceParam.toString());
                            if(!subsCriptionArray.getJSONObject(0).getString("terms").isEmpty())
                                params.put("terms", jsonParam.toString());
                            try {
                                params.put("version", SyncActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                            } catch (Exception e) {

                            }
                            params.put("phone", sharedPref.getString("phoneNumber", ""));
                            params.put("email", sharedPref.getString("emailAddress", ""));


                            String httpPostData = STAsyncHttpConnectionUpadteDevice.createQueryStringForParameters(params);
                            STAsyncHttpConnectionUpadteDevice async = new STAsyncHttpConnectionUpadteDevice(SyncActivity.this, params);
                            async.execute(Global.terms);
                        }
                        else
                        {
                            if(!sharedPref.getString("newDeviceString","").equalsIgnoreCase(sharedPref.getString("deviceString","")))
                            {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SyncActivity.this);
                                // Setting Dialog Title
                                alertDialog.setTitle("Alert");
                                // Setting Dialog Message
                                alertDialog.setMessage("VDA subscription with the same phone number is active on another device.");
                                alertDialog.setCancelable(false);
                                alertDialog.show();
                            }
                            else {
                                if (sharedPref.getString("subscriptionStatus", "").equalsIgnoreCase("revoked")||sharedPref.getString("subscriptionStatus", "").equalsIgnoreCase("rejected")) {
                                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SyncActivity.this);
                                    // Setting Dialog Title
                                    alertDialog.setTitle("Alert");
                                    // Setting Dialog Message
                                    alertDialog.setMessage("Your subscription to VDA has been revoked.  Please contact the Utility Admin for details.");
                                    alertDialog.setCancelable(false);
                                    alertDialog.show();
                                } else {

                                    if (!subsCriptionArray.getJSONObject(0).getString("deviceOs").equalsIgnoreCase(osName)) {

                                        // editor.putBoolean("ACCEPTANCE", acceptance);
                                        JSONObject jsonParam = null;
                                        JSONObject deviceParam = null;
                                        TimeZone tz = TimeZone.getTimeZone("UTC");
                                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                                        df.setTimeZone(tz);


                                        try {
                                            jsonParam = new JSONObject();
                                            jsonParam.put("isAccepted", true);
                                            jsonParam.put("version", SyncActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                            jsonParam.put("time", df.format(new Date()));
                                            jsonParam.put("latitude", String.valueOf(
                                                    Global.currentLocation.getLatitude()));
                                            jsonParam.put("longitude", String.valueOf(
                                                    Global.currentLocation.getLongitude()));


                                            deviceParam = new JSONObject();
                                            deviceParam.put("type", "ANDROID");
                                            deviceParam.put("os", osName);
                                            deviceParam.put("make", Build.MANUFACTURER);
                                            deviceParam.put("model", Build.MODEL);
                                            deviceParam.put("deviceString", sharedPref.getString("deviceString", ""));
                                            deviceParam.put("version", SyncActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                            deviceParam.put("pushNotificationToken", sharedPref.getString("pushNotificationToken", ""));

                                            Log.i("sync", "token3333==" + sharedPref.getString("pushNotificationToken", ""));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }


                                        HashMap<String, String> params = new HashMap<String, String>();

                                        params.put("device", deviceParam.toString());
                                        params.put("terms", jsonParam.toString());
                                        try {
                                            params.put("version", SyncActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                        } catch (Exception e) {

                                        }
                                        params.put("phone", sharedPref.getString("phoneNumber", ""));
                                        params.put("email", sharedPref.getString("emailAddress", ""));


                                        String httpPostData = STAsyncHttpConnectionUpadteDevice.createQueryStringForParameters(params);
                                        STAsyncHttpConnectionUpadteDevice async = new STAsyncHttpConnectionUpadteDevice(SyncActivity.this, params);
                                        async.execute(Global.terms);

                                    }
                                }
                            }}
                    }else
                    {
                        if(pageNotFound) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(SyncActivity.this);
                            // Setting Dialog Title
                            alertDialog.setTitle("Alert");
                            // Setting Dialog Message
                            alertDialog.setMessage(responseObject.getString("Message"));
                            alertDialog.setCancelable(false);
                            alertDialog.show();
                        }else
                        {
                            Toast.makeText(SyncActivity.this,responseObject.getString("Message"), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void getCurrentVersion(){
        PackageManager pm = this.getPackageManager();
        PackageInfo pInfo = null;

        try {
            pInfo =  pm.getPackageInfo(this.getPackageName(),0);

        } catch (PackageManager.NameNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        currentVersion = pInfo.versionName;

        new GetLatestVersion().execute();

    }

    private class GetLatestVersion extends AsyncTask<String, String, JSONObject> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            try {
//It retrieves the latest version by scraping the content of current version from play store at runtime
                Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=com.securax.irestore_firstresponder&hl=en").get();
                latestVersion = doc.getElementsByAttributeValue
                        ("itemprop","softwareVersion").first().text();

            }catch (Exception e){
                e.printStackTrace();

            }

            return new JSONObject();
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            if(latestVersion!=null) {
                if (!currentVersion.equalsIgnoreCase(latestVersion)){

                    if(!isFinishing()){ //This would help to prevent Error : BinderProxy@45d459c0 is not valid; is your activity running? error
                        showUpdateDialog(latestVersion);
                    }
                }
            }
            /*else
                background.start();*/
            super.onPostExecute(jsonObject);
        }
    }
    private void showUpdateDialog(String latestVersion){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Update Available");
        builder.setMessage("A new version of iRestore VDA is available.Please update to version "+latestVersion+" now");
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("market://details?id=com.securax.irestore_firstresponder")));
                dialog.dismiss();
            }
        });


        builder.setCancelable(false);
        dialog = builder.show();
    }


}
