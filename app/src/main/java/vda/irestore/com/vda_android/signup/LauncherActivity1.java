package vda.irestore.com.vda_android.signup;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.Global.GlobalData;
import vda.irestore.com.vda_android.Global.Utils;
import vda.irestore.com.vda_android.MainActivity;
import vda.irestore.com.vda_android.R;
import vda.irestore.com.vda_android.services.GPSTracker;


public class LauncherActivity1 extends Activity {
    GPSTracker gps;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // Fabric.with(this, new Crashlytics());

     //   setContentView(R.layout.activity_launcher);



        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        //editor.putBoolean("isNewUser",true);
        editor.commit();
       // logUser();
        Boolean userloggedIn = sharedPref.getBoolean("userLoggedIn", false);
        gps = new GPSTracker(LauncherActivity1.this);

    /*    Intent i = new Intent();
        i.setClass(LauncherActivity1.this, MainActivity.class);
        startActivity(i);*/

        if (sharedPref.getString("emailAddress", "").isEmpty()) {
            Intent i = new Intent();
            i.setClass(LauncherActivity1.this, SplashScreen.class);
            startActivity(i);
        } else {
            {

                if (!sharedPref.getBoolean("chooseUtility", false)) {
                    if (userloggedIn) {
                       /* if (Utils.isNetworkAvailable(LauncherActivity.this)) {
                            HttpGetRequest async = new HttpGetRequest();
                            String s = Utils.syncAPI + "&email=" +sharedPref.getString("emailAddress","")+
                                    "&phone=" +sharedPref.getString("phoneNumber","");
                            Log.i("vidisha","sync API called=="+s);
                            async.execute(s);
                        } else {
                            Toast.makeText(LauncherActivity.this, getResources().getString(R.string.internet_error),
                                    Toast.LENGTH_SHORT).show();
                        }*/

                        Intent i = new Intent();
                        i.setClass(LauncherActivity1.this, SplashClient.class);
                        startActivity(i);

                    } else {
                        Intent i = new Intent();
                        i.setClass(LauncherActivity1.this, Main3Activity.class);
                        //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                    }
                } else {
                    if (sharedPref.getString("firstName", "").isEmpty()) {
                        Intent intent = new Intent();
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setClass(LauncherActivity1.this, MyProfile.class);
                        startActivity(intent);
                    } else {
                        if (!sharedPref.getBoolean("adminApprovalStatus", false)) {
                            Intent intent = new Intent();
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setClass(LauncherActivity1.this, AdminApprovalScreen.class);
                            startActivity(intent);

                        } else {
                            if (sharedPref.getBoolean("termsAccepted", false)) {
                                Intent i = new Intent();
                                i.setClass(LauncherActivity1.this, SplashClient.class);
                                startActivity(i);
                            } else {
                                Intent i = new Intent();
                                i.setClass(LauncherActivity1.this, TermsConditions.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                            }
                        }
                    }
                }
            }
            }
    }


    protected void onResume() {
        super.onResume();
      //  fetchLocation();

    }

  /*  public void fetchLocation() {
        gps = new GPSTracker(LauncherActivity1.this);
        Global.currentLocation = gps.getLocation();
        if (gps.canGetLocation() == false) {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            Global.showGPSAlert(LauncherActivity1.this);
        }
    }*/


    private void logUser() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
      /*  Crashlytics.setUserIdentifier(sharedPref.getString("phoneNumber",""));
        Crashlytics.setUserEmail(sharedPref.getString("emailAddress",""));*/
       // Crashlytics.setUserName("Test User");
    }

}
