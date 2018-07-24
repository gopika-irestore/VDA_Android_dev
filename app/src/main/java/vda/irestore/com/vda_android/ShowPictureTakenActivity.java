package vda.irestore.com.vda_android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import vda.irestore.com.vda_android.Global.Utils;
import vda.irestore.com.vda_android.services.GPSTracker;
import vda.irestore.com.vda_android.signup.BaseActivity;

public class ShowPictureTakenActivity extends BaseActivity {

    ImageView photoView;
    private TextView latValLabel, longValLabel, dateValLabel;
    GPSTracker gps;
    static int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_picture_taken);


        photoView = (ImageView) findViewById(R.id.photoView);
        if(AndroidCameraApi.imageNumber==2)
            photoView.setImageBitmap(Utils.assetImage1);
        else
            photoView.setImageBitmap(Utils.assetImage);

        gps = new GPSTracker(ShowPictureTakenActivity.this);


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
        gps = new GPSTracker(ShowPictureTakenActivity.this);
        Utils.currentLocation = gps.getLocation();
        if (gps.canGetLocation() == false) {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            Utils.showGPSAlert(ShowPictureTakenActivity.this);
        }
    }
    public void buttonOnClick(View v) {
        switch (v.getId()) {
            case R.id.keepPhoto:
                if(count<2) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(ShowPictureTakenActivity.this);
                    builder.setTitle("Alert");
                    builder.setMessage("Do you want to take another picture");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            count++;
                            AndroidCameraApi.imageNumber =2;
                            Intent intent = new Intent();
                            intent.setClass(ShowPictureTakenActivity.this, AndroidCameraApi.class);
                            startActivity(intent);
                            finish();

                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Utils.currentLocation = gps.getLocation();
                            Intent intent = new Intent();
                            intent.setClass(ShowPictureTakenActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else
                {
                    Intent intent = new Intent();
                    Utils.currentLocation = gps.getLocation();
                    intent.setClass(ShowPictureTakenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                break;
            case R.id.discardPhoto:
                finish();
                break;
        }

    }

}
