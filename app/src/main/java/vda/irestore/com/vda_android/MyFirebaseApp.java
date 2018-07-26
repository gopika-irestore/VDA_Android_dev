package vda.irestore.com.vda_android;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.danlew.android.joda.JodaTimeAndroid;

import io.fabric.sdk.android.Fabric;


/**
 * Created by MALBEL on 07-08-2017.
 */

public class MyFirebaseApp extends Application {
    public String MainAct;
    FirebaseDatabase database;
    DatabaseReference firebaseUserDataReference;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    public void onCreate() {
        super.onCreate();
       // Fabric.with(this, new Crashlytics());

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();



        Log.i("vidisha","MyFirebaseApp");

       // FirebaseDatabase.getInstance().getApp().setAutomaticResourceManagementEnabled(true);
        FirebaseDatabase.getInstance("https://vda-ios.firebaseio.com/").setPersistenceEnabled(true);
      //  FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("vda-ios");


       // database = FirebaseDatabase.getInstance();
      //  firebaseUserDataReference = database.getReference(FIREBASE_NAME);

      //  LoadPriorityTypeFireBase();
        dbRef.keepSynced(true);


        JodaTimeAndroid.init(this);

    }


    public String getMainAct() {
        return MainAct;
    }

    public void setMainAct(String mainAct) {
        MainAct = mainAct;
    }
}