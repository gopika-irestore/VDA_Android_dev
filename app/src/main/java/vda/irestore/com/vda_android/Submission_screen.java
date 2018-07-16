package vda.irestore.com.vda_android;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Submission_screen extends AppCompatActivity {
    TextView submit,lat_long;
    Spinner spinner;
    private ImageView m1,m2,m3,m4,m5,m6;
    int firstimage = 0;
    int secondimage = 0;
    int thirdimage = 0;
    int fourthimage = 0;
    int fifthimage = 0;
    int sixthimage = 0;
    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    double latitude ;
    double longitude ;
    Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_screen);
        lat_long = (TextView)findViewById(R.id.lattitude_longitude);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            firstimage = bundle.getInt("wireImage");
            secondimage = bundle.getInt("poletopImage");
            thirdimage = bundle.getInt("splImage");
            fourthimage = bundle.getInt("poleImage");
            fifthimage = bundle.getInt("treeImage");
            sixthimage = bundle.getInt("otherImage");
            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.imageGallery);
            final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(5, 0, 5, 0);

            m1 = new ImageView(getApplicationContext());
            m1.setLayoutParams(lp);

            m2 = new ImageView(getApplicationContext());
            m2.setLayoutParams(lp);

            m3 = new ImageView(getApplicationContext());
            m3.setLayoutParams(lp);

            m4 = new ImageView(getApplicationContext());
            m4.setLayoutParams(lp);

            m5 = new ImageView(getApplicationContext());
            m5.setLayoutParams(lp);

            m6 = new ImageView(getApplicationContext());
            m6.setLayoutParams(lp);

            if (firstimage != 0) {
                m1.setImageResource(firstimage);
                m1.setAdjustViewBounds(true);
                linearLayout.addView(m1);
            }
            if (secondimage != 0) {
                m2.setImageResource(secondimage);
                linearLayout.addView(m2);
            }
            if (thirdimage != 0) {
                m3.setImageResource(thirdimage);
                linearLayout.addView(m3);
            }
            if (fourthimage != 0) {
                m4.setImageResource(fourthimage);
                linearLayout.addView(m4);
            }
            if (fifthimage != 0) {
                m5.setImageResource(fifthimage);
                linearLayout.addView(m5);
            }
            if (sixthimage != 0) {
                m6.setImageResource(sixthimage);
                linearLayout.addView(m6);
            }
        }
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayList<Integer> heights = new ArrayList<Integer>();
        heights.add(35);
        heights.add(40);
        heights.add(45);
        heights.add(50);
        heights.add(55);
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, heights);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    public void getLocation() {
        if( ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION )!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }
        else
        {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location != null)
            {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                lat_long.setText(String.valueOf(latitude)+","+ String.valueOf(longitude));
            }
        }
    }
}
