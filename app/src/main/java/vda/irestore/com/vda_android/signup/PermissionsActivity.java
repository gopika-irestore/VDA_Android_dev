package vda.irestore.com.vda_android.signup;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import vda.irestore.com.vda_android.Global.Global;


public class PermissionsActivity extends Activity implements
    GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener
    {
        public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 5000;
        protected static final int REQUEST_CHECK_SETTINGS = 555;
        /**
         * The fastest rate for active location updates. Exact. Updates will never be more frequent
         * than this value.
         */
        public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS =
                UPDATE_INTERVAL_IN_MILLISECONDS / 2;

        // Keys for storing activity state in the Bundle.
        protected final static String REQUESTING_LOCATION_UPDATES_KEY = "requesting-location-updates-key";
        protected final static String LOCATION_KEY = "location-key";
        protected final static String LAST_UPDATED_TIME_STRING_KEY = "last-updated-time-string-key";

        protected static final String TAG = "vidisha1111";

        /**
         * Provides the entry point to Google Play services.
         */
        protected GoogleApiClient mGoogleApiClient;

        /**
         * Stores parameters for requests to the FusedLocationProviderApi.
         */
        protected LocationRequest mLocationRequest;

        /**
         * Represents a geographical location.
         */
        protected Location mCurrentLocation;

        /**
         * Tracks the status of the location updates request. Value changes when the user presses the
         * Start Updates and Stop Updates buttons.
         */
        protected Boolean mRequestingLocationUpdates;

        /**
         * Time when the location was updated represented as a String.
         */
        protected String mLastUpdateTime;
        public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 123;
        Context context;
        private Activity activity;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        activity = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkAndRequestPermissions();
        }

        mRequestingLocationUpdates = false;
        buildGoogleApiClient();

    }

    private boolean checkAndRequestPermissions() {


        int writeStorage_permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readStorage_permission = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);

        int cameraPermissions = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);

        int fineLocation_permission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        int coarseLocation_permission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);

        int calenderRead_permission = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALENDAR);
        int calenderWrite_permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR);


        List<String> listPermissionsNeeded = new ArrayList<>();

        if (fineLocation_permission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (coarseLocation_permission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (writeStorage_permission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (readStorage_permission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (calenderRead_permission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_CALENDAR);
        }
        if (calenderWrite_permission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_CALENDAR);
        }
        if (cameraPermissions != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }



        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(activity,listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == REQUEST_ID_MULTIPLE_PERMISSIONS) {

            if (grantResults.length > 0) {
                for (int i = 0; i < permissions.length; i++) {

                    if (permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            Log.e("msg", "storage granted");

                        }
                    }
                    else if (permissions[i].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            Log.e("msg", "storage granted");

                        }
                        else if (permissions[i].equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                if (mGoogleApiClient == null) {
                                    buildGoogleApiClient();
                                }
                                Log.e("msg", "location granted");

                            }
                        }
                        else if (permissions[i].equals(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                if (mGoogleApiClient == null) {
                                    buildGoogleApiClient();
                                }
                                Log.e("msg", "location granted");

                            }
                        }else if (permissions[i].equals(Manifest.permission.READ_CALENDAR)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                Log.e("msg", "calender read granted");

                            }
                        }
                        else if (permissions[i].equals(Manifest.permission.WRITE_CALENDAR)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                Log.e("msg", "calender write granted");

                            }
                        } else if (permissions[i].equals(Manifest.permission.CAMERA)) {
                            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                Log.e("msg", "camerqa granted");

                            }
                        }

                    }
                }

            }}}

    /**
     * Builds a GoogleApiClient. Uses the {@code #addApi} method to request the
     * LocationServices API.
     */
    protected synchronized void buildGoogleApiClient() {
        Log.i(TAG, "Building GoogleApiClient");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        createLocationRequest();


    }

    protected void createLocationRequest() {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        Log.i(TAG, "Building GoogleApiClient111111");
    }

    /**
     * Requests location updates from the FusedLocationApi.
     */
    protected void startLocationUpdates() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient,
                mLocationRequest,
                this
        ).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
                mRequestingLocationUpdates = true;
            }
        });
    }

    /**
     * Removes location updates from the FusedLocationApi.
     */
    protected void stopLocationUpdates() {

        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient,
                this
        ).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
                mRequestingLocationUpdates = false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();

    }

    @Override
    protected void onResume() {
        super.onResume();
        settingsrequest();
        if (mGoogleApiClient.isConnected() && mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);
        if ( hasFocus ) {

            LocationManager locationManager = (LocationManager) this
                    .getSystemService(LOCATION_SERVICE);

            if(!locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER))
                settingsrequest();

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop location updates to save battery, but don't disconnect the GoogleApiClient object.
        if (mGoogleApiClient.isConnected()) {
            stopLocationUpdates();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();

    }

    /**
     * Runs when a GoogleApiClient object successfully connects.
     */
    @Override
    public void onConnected(Bundle connectionHint) {
        // Log.i(TAG, "Connected to GoogleApiClient");

        if (mCurrentLocation == null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            Log.i("vidisha1111","cumCurrentLocation"+mCurrentLocation);
            Global.currentLocation = mCurrentLocation;
            startLocationUpdates();
        }

        if (mRequestingLocationUpdates) {
            Log.i(TAG, "mRequestingLocationUpdates");
            startLocationUpdates();
        }
    }

    /**
     * Callback that fires when the location changes.
     */
    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        Global.currentLocation = mCurrentLocation;
        String url;

        url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="
                +  Global.currentLocation.getLatitude() + "," +  Global.currentLocation.getLongitude() + "&sensor=false";
        //Log.i("vidisha111","2222222url"+url);


        DownloadTask downloadTask = new DownloadTask();

        // Start downloading the geocoding places
        downloadTask.execute(url);

        //Global.currentLocation = location;


    }
        private String downloadUrl(String strUrl) throws IOException {
            String data = "";
            InputStream iStream = null;
            HttpURLConnection urlConnection = null;
            try{
                URL url = new URL(strUrl);
                // Creating an http connection to communicate with url
                urlConnection = (HttpURLConnection) url.openConnection();

                // Connecting to url
                urlConnection.connect();

                // Reading data from url
                iStream = urlConnection.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

                StringBuffer sb = new StringBuffer();

                String line = "";
                while( ( line = br.readLine()) != null){
                    sb.append(line);
                }

                data = sb.toString();
                br.close();

            }catch(Exception e){
                Log.i("Exception url", e.toString());
            }finally{
                iStream.close();
                urlConnection.disconnect();
            }

            return data;
        }

        private class DownloadTask extends AsyncTask<String, Integer, String> {

            String data = null;


            // Invoked by execute() method of this object
            @Override
            protected String doInBackground(String... url) {
                try {
                    data = downloadUrl(url[0]);
                } catch (Exception e) {
                    Log.d("Background Task", e.toString());
                }
                return data;
            }

            // Executed after the complete execution of doInBackground() method
            @Override
            protected void onPostExecute(String result) {

                  Log.i("vidisha","onpost"+result);

                try {
                    JSONObject responseObject = new JSONObject(result);
                    String address = responseObject.getJSONArray("results").getJSONObject(0).getString("formatted_address");
                    if(address!=null)
                      Global.addressString = address;
                    else
                        Global.addressString ="";

                    int l = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").length();

                    if(l!=0) {

                        for (int k = 0; k < l; k++) {

                            if (responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getJSONArray("types").get(0).toString().equalsIgnoreCase("route")) {

                                String streetNumber = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("short_name");
                                Global.streetNumber = streetNumber;


                            }/* else {
                                Global.streetNumber = "";
                            }*/
                            if (responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getJSONArray("types").get(0).toString().equalsIgnoreCase("route")) {

                                String street = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("short_name");
                                Global.street = street;


                            } /*else {
                                Global.street = "";
                            }*/
                            if (responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getJSONArray("types").get(0).toString().equalsIgnoreCase("locality")) {

                                String city = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("long_name");
                                Global.city = city;
                               // Log.i("vidisha","city==="+city);


                            }/*else {
                                Global.city = "";
                            }*/


                            if (responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getJSONArray("types").get(0).toString().equalsIgnoreCase("administrative_area_level_1")) {

                                String state = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("long_name");
                                String stateAbbr = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("short_name");

                                Global.state = state;
                                Global.stateAbbr = stateAbbr;

                            }/* else {
                                Global.state = "";
                                Global.stateAbbr = "";
                            }*/
                            if (responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getJSONArray("types").get(0).toString().equalsIgnoreCase("country")) {

                                String country = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("long_name");
                                String countryAbbr = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("short_name");

                                Global.country = country;
                                Global.countryAbbr = countryAbbr;

                            } /*else {
                                Global.country = "";
                                Global.countryAbbr = "";
                            }*/
                            if (responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getJSONArray("types").get(0).toString().equalsIgnoreCase("postal_code")) {

                                String zipcode = responseObject.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(k).getString("long_name");
                                Global.zipCode = zipcode;

                            } /*else {
                                Global.zipCode = "";
                            }
*/

                        }
                    }else
                    {
                        Global.addressString ="";
                        Global.streetNumber = "";
                        Global.street = "";
                        Global.city = "";
                        Global.state = "";
                        Global.stateAbbr = "";
                        Global.country = "";
                        Global.countryAbbr = "";
                        Global.zipCode = "";


                    }

                } catch (Exception e) {
                    Log.i("iRestore", "onPostExecute" + e);
                }

            }
        }
    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        // Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }

    /**
     * Stores activity data in the Bundle.
     */
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(REQUESTING_LOCATION_UPDATES_KEY, mRequestingLocationUpdates);
        savedInstanceState.putParcelable(LOCATION_KEY, mCurrentLocation);
        savedInstanceState.putString(LAST_UPDATED_TIME_STRING_KEY, mLastUpdateTime);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void settingsrequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(30 * 1000);
        locationRequest.setFastestInterval(5 * 1000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true); //this is the key ingredient

        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final LocationSettingsStates state = result.getLocationSettingsStates();
                if (!state.isGpsPresent() || !state.isGpsUsable()) {
                    final Status status = result.getStatus();


                    switch (status.getStatusCode()) {
                        case LocationSettingsStatusCodes.SUCCESS:
                            startLocationUpdates();
                            // All location settings are satisfied. The client can initialize location
                            // requests here.
                            break;
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Location settings are not satisfied. But could be fixed by showing the user
                            // a dialog.
                            try {
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                status.startResolutionForResult(PermissionsActivity.this, REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // Location settings are not satisfied. However, we have no way to fix the
                            // settings so we won't show the dialog.
                            break;
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        //  Log.i("Securtime", "requestCode"+requestCode+"----resultCode"+resultCode);

        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        finishAffinity();
                        break;
                }
                break;
        }
    }


}
