package vda.irestore.com.vda_android.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import vda.irestore.com.vda_android.MainActivity;
import vda.irestore.com.vda_android.R;


public class SplashClient extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    FileCache fileCache;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_client);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        fileCache=new FileCache(this);

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        TextView dummyTextView = (TextView)findViewById(R.id.dummyTextView) ;

        //String clientLogoURl = sharedPref.getString("clientLogoUrl", "");


        ImageView clientLogo= (ImageView) findViewById(R.id.client_logo);

       // if(sharedPref.getBoolean("isNewUser",false))
        {
            ImageLoader imgLoader = new ImageLoader(this);
            imgLoader.DisplayImage(sharedPref.getString("imageURL",""),"", clientLogo,dummyTextView);
        }
       // else {

            File path = new File(Environment.getExternalStorageDirectory(), "/DCIM/VDA/TenantLogo");
            if (path.exists()) {
                Bitmap bmp = BitmapFactory.decodeFile(path.getAbsolutePath() + "/" + sharedPref.getString("imageName", ""));
                clientLogo.setImageBitmap(bmp);
           // }
        }




        Typeface typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
             /*   Global.reportSubmitted = true;
                if (sharedPref.getBoolean("dontAskAgain", false)) {
                    editor.putInt("counter",0);
                    editor.commit();

                    Intent i = new Intent();
                    i.setClass(SplashClient.this, DashboardScreen.class);
                    startActivity(i);
                }else {
                    Intent i = new Intent(SplashClient.this, WelcomeActivity.class);
                    startActivity(i);
                }
*/

                Intent i = new Intent();
                i.setClass(SplashClient.this, MainActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }



}