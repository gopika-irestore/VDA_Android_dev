package vda.irestore.com.vda_android.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import vda.irestore.com.vda_android.R;


public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final SharedPreferences sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                //if(!sharedPref.getBoolean("adminApproval",false)) {
                    Intent i = new Intent(SplashScreen.this, Main3Activity.class);
                    startActivity(i);
                /*}else
                {

                    Intent i = new Intent();
                    i.setClass(SplashScreen.this, AdminApprovalScreen.class);
                    startActivity(i);
                }*/

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
