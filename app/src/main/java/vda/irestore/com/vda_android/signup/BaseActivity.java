package vda.irestore.com.vda_android.signup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import vda.irestore.com.vda_android.R;


public class BaseActivity extends PermissionsActivity {
    String currentVersion, latestVersion;
    Dialog dialog;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String accountKey,logo,token,configuration,safetyMessage,s3Bucket,api,logoURL,imageName,profilePicBucket,profilePicThumbnailsBucket,firebaseDb;
    Boolean termsAccepted,otpValidationRequired,adminApprovalRequired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();


      /*  if(!sharedPref.getString("userID","").isEmpty()) {
            if (Utils.isNetworkAvailable(BaseActivity.this)) {
                //Utils.createAndStartProgressBar(LauncherActivity.this);
                HttpGetRequest async = new HttpGetRequest();
                String s = Utils.syncURL + sharedPref.getString("userID", "") + "/" + "FR/" + sharedPref.getString("phoneNumber", "") + "?os=ANDROID";
                async.execute(Utils.syncURL + sharedPref.getString("userID", "") + "/" + "FR/" + sharedPref.getString("phoneNumber", "") + "?os=ANDROID");
            } else {
                Toast.makeText(BaseActivity.this, getResources().getString(R.string.internet_error),
                        Toast.LENGTH_SHORT).show();
            }
        }*/

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
        builder.setMessage("A new version of iRestore CP Manager is available.Please update to version "+latestVersion+" now");
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



/*
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
                connection.setRequestProperty("x-application", "FR");
                connection.setRequestProperty("x-user", sharedPref.getString("userID",""));

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
            JSONObject responseObject;
            String message,appDBVersion,subscriptionStatus;
            int forceUpgrade;
            boolean error ;
            Log.i("iRestore","api----==="+result);
            try {
                if (result != null) {

                    responseObject = new JSONObject(result);
                    error = responseObject.getBoolean("Error");

                    if(!error)
                    {
                        JSONArray userArray = responseObject.getJSONArray("User");
                        JSONArray tenantsArray = responseObject.getJSONArray("Owner");
                        ///
                        appDBVersion = responseObject.getJSONArray("AppVersion").getJSONObject(0).getString("version");
                        forceUpgrade = responseObject.getJSONArray("AppVersion").getJSONObject(0).getInt("forceUpgrade");
                        subscriptionStatus = responseObject.getJSONArray("User").getJSONObject(0).getString("subscriptionStatus");
                        editor.putString("appDBVersion",appDBVersion);
                        editor.putInt("forceUpgrade",forceUpgrade);
                        editor.putString("subscriptionStatus",subscriptionStatus);


                        String fr_status;
                        String termsConditions;
                        if(userArray.getJSONObject(0).has("subscriptionStatus"))
                        {
                            subscriptionStatus = userArray.getJSONObject(0).getString("subscriptionStatus");
                        }
                        else {
                            subscriptionStatus = "";
                        }
                        if(userArray.getJSONObject(0).has("terms"))
                            termsConditions = userArray.getJSONObject(0).getString("terms");
                        else
                            termsConditions="";
//added
                        editor.putString("firstName", userArray.getJSONObject(0).getString("firstName"));
                        editor.putString("lastName", userArray.getJSONObject(0).getString("lastName"));
                        editor.putString("emailAddress", userArray.getJSONObject(0).getString("email"));
                        if(userArray.getJSONObject(0).has("primaryPhone"))
                            editor.putString("primaryPhone", userArray.getJSONObject(0).getString("primaryPhone"));
                        else
                            editor.putString("primaryPhone", "");
                        editor.putString("phoneNumber", userArray.getJSONObject(0).getString("primaryPhone"));
                        editor.putString("jobTitle", userArray.getJSONObject(0).getString("job"));
                        editor.putString("organization", userArray.getJSONObject(0).getString("organization"));
                        editor.putString("city", userArray.getJSONObject(0).getString("city"));
                        editor.putString("state", userArray.getJSONObject(0).getString("state"));
                        editor.putString("county", userArray.getJSONObject(0).getString("county"));
                        editor.putString("owner", userArray.getJSONObject(0).getString("owner"));
                        editor.putString("userType", userArray.getJSONObject(0).getString("userType"));
                        if(userArray.getJSONObject(0).has("userId"))
                            editor.putString("userID", String.valueOf(userArray.getJSONObject(0).getInt("userId")));
                        else
                            editor.putString("userID", "0");



                        Log.i("vidisha","email domain Found");
                        accountKey = tenantsArray.getJSONObject(0).getString("accountKey");

                        logo = tenantsArray.getJSONObject(0).getString("logo");
                        token = tenantsArray.getJSONObject(0).getString("token");
                        logoURL = tenantsArray.getJSONObject(0).getString("logo");

                        //getBitmapFromURL(imageName,imageName);

                        new DownloadImage().execute(logoURL);

                        imageName = tenantsArray.getJSONObject(0).getString("logo").
                                substring(tenantsArray.getJSONObject(0).getString("logo").lastIndexOf("/") + 1);

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
                        //editor.putBoolean("otpValidationRequired",adminApprovalRequired);
                       // editor.putBoolean("adminApprovalRequired",adminApprovalRequired);
                       // editor.putString("token", token);
                        editor.putString("subscriptionStatus", subscriptionStatus);
                        editor.putString("menuOptions", configuration.getString("menuOptions"));
                        editor.commit();
                        editor.commit();
                       *//* if(forceUpgrade==1)
                            getCurrentVersion();
*//*
                    }*//*else
                    {
                        message = responseObject.get("Message").toString();
                        Toast.makeText(BaseActivity.this, message,
                                Toast.LENGTH_SHORT).show();
                    }*//*

                } *//*else {
                    Toast.makeText(BaseActivity.this, BaseActivity.this.getResources().getString(R.string.error),
                            Toast.LENGTH_SHORT).show();
                }*//*
                *//*if (Utils.progress.isShowing()) {
                    Utils.stopProgressBar();
                }*//*
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }*/
    // DownloadImage AsyncTask
   /* private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
          *//*  mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Download Image Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();*//*
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
                editor.putString("imageName", imageName);
                editor.commit();
                SaveImage(bitmap,imageName);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            //image.setImageBitmap(result);
            // Close progressdialog
            //      mProgressDialog.dismiss();

        }

        private void SaveImage(Bitmap finalBitmap,String imageName) {

            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + "/DCIM/DamageAssistant/TenantLogo");
            myDir.mkdirs();

            File file = new File (myDir, imageName);
            if (file.exists ()) file.delete ();
            try {
                FileOutputStream out = new FileOutputStream(file);
                finalBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    //}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            switch (requestCode) {
                case 1:
                    break;
            }
        }
    }

}
