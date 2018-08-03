package vda.irestore.com.vda_android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import vda.irestore.com.vda_android.Global.Utils;
import vda.irestore.com.vda_android.services.GPSTracker;
import vda.irestore.com.vda_android.signup.BaseActivity;

public class ShowPanoPictureTaken extends BaseActivity {

    ImageView photoView;
    private TextView latValLabel, longValLabel, dateValLabel;
    GPSTracker gps;
    static int count = 1;
    String imagePathOne,imagePathTwo;
    EditText caption;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pano_picture_taken);

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);


        photoView = (ImageView) findViewById(R.id.photoView);
        caption = (EditText)findViewById(R.id.photoCaption);

        photoView.setImageBitmap(Utils.panoBitmap1);

        gps = new GPSTracker(ShowPanoPictureTaken.this);


        latValLabel = (TextView) findViewById(R.id.latituteVal);
        longValLabel = (TextView) findViewById(R.id.longituteVal);
        dateValLabel = (TextView) findViewById(R.id.dateVal);


        if (gps.canGetLocation) {
            Utils.currentLocation = gps.getLocation();//added to refresh location
            latValLabel.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.#####").format(Utils.currentLocation.getLatitude()))));
            longValLabel.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.#####").format(Utils.currentLocation.getLongitude()))));
        }
        DateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        dateValLabel.setText(dateFormatter.format(new Date()));

    }
    @Override
    protected void onResume() {
        super.onResume();
        fetchLocation();
    }

    public void fetchLocation() {
        gps = new GPSTracker(ShowPanoPictureTaken.this);
        Utils.currentLocation = gps.getLocation();
        if (gps.canGetLocation() == false) {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            Utils.showGPSAlert(ShowPanoPictureTaken.this);
        }
    }
    public void buttonOnClick(View v) {
        switch (v.getId()) {
            case R.id.keepPhoto:

                            Utils.currentLocation = gps.getLocation();
                           // Intent intent = new Intent();
                         //   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                           // intent.setClass(ShowPanoPictureTaken.this, MainActivity.class);
                            editor = sharedPref.edit();
                            editor.putString("captionOne",caption.getText().toString().trim());
                            editor.commit();
                           // startActivity(intent);
                           // finish();
                setResult(3455);
                finish();

                break;
            case R.id.discardPhoto:
                finish();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 456) {

            }
        }
    }

}
