package vda.irestore.com.vda_android.signup;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.UUID;

import cz.msebera.android.httpclient.entity.StringEntity;
import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.MainActivity;
import vda.irestore.com.vda_android.R;
import vda.irestore.com.vda_android.services.GPSTracker;


import static vda.irestore.com.vda_android.Global.Global.appKey;

public class TermsConditions extends BaseActivity implements View.OnClickListener{

    Button agreeBtn,denyBtn;

    Boolean acceptance = false;
    GPSTracker gps;
    SharedPreferences sharedPref;
    String responseJSON , imageName,deviceString;
    Exception exception;
    String httpPostData;
    SharedPreferences.Editor editor;
    private static final char PARAMETER_DELIMITER = '&';
    private static final char PARAMETER_EQUALS_CHAR = '=';
    private static final int CONNECTION_TIMEOUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);

        String termsConditions = sharedPref.getString("termsUtility", "");

        deviceString = UUID.randomUUID().toString();

        editor = sharedPref.edit();


       /* responseJSON = sharedPref.getString("responseData", "");
        imageName = sharedPref.getString("imageName","");*/
      //  selectedUser  = sharedPref.getString("selectedUser", "");


        agreeBtn = (Button) findViewById(R.id.agreeBtn);
        denyBtn = (Button) findViewById(R.id.denyBtn);

        agreeBtn.setOnClickListener(this);
        denyBtn.setOnClickListener(this);


        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_titlebar, null);
        v.setBackgroundColor(Color.WHITE);
        ActionBar actionBar = getActionBar();
        TextView title = (TextView) v.findViewById(R.id.title);
        title.setTextColor(Color.parseColor("#00CC99"));
        Button nextBtn = (Button)v.findViewById(R.id.nextBtn) ;
        nextBtn.setVisibility(View.INVISIBLE);
        title.setText("Terms of Service");
        title.setTypeface(typeFace);

        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled (false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(v);


       TextView tv=(TextView)findViewById(R.id.conditionsText);
       tv.setText(Html.fromHtml(getString(R.string.tc_html)+termsConditions));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.agreeBtn:
                acceptance = true;


               // editor.putBoolean("ACCEPTANCE", acceptance);
                JSONObject userObj =null;
                Intent loginIntent = new Intent();
                JSONObject jsonParam =null;
                JSONObject deviceParam =null;
                TimeZone tz = TimeZone.getTimeZone("UTC");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                df.setTimeZone(tz);
               // loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);


                try
                {
                    jsonParam = new JSONObject();
                    jsonParam.put("isAccepted", acceptance);
                    jsonParam.put("version", this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                    jsonParam.put("time", df.format(new Date()));
                    jsonParam.put("latitude", String.valueOf(
                            Global.currentLocation.getLatitude()));
                    jsonParam.put("longitude", String.valueOf(
                            Global.currentLocation.getLongitude()));


                    Field[] fields = Build.VERSION_CODES.class.getFields();
                    String osName = fields[Build.VERSION.SDK_INT ].getName();
                    Log.i("Android OsName:",osName);

                    deviceParam = new JSONObject();
                    deviceParam.put("type", "ANDROID");
                    deviceParam.put("os", osName);
                    deviceParam.put("make", Build.MANUFACTURER);
                    deviceParam.put("model", Build.MODEL);
                    deviceParam.put("deviceString", deviceString);
                    deviceParam.put("version", this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                    deviceParam.put("pushNotificationToken", sharedPref.getString("pushNotificationToken",""));





                }catch(Exception e)
                {
                    e.printStackTrace();
                }


                HashMap<String, String> params = new HashMap<String, String>();
                params.put("email",sharedPref.getString("emailAddress",""));
                params.put("device",deviceParam.toString());
                params.put("terms",jsonParam.toString());
                try {
                    params.put("version", this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                }catch(Exception e)
                {

                }
                params.put("phone",sharedPref.getString("phoneNumber",""));
                try {
                    StringEntity entity = new StringEntity(params.toString());
                    Log.i("testing","params=="+deviceParam);
                    Log.i("testing","params=="+deviceParam);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


                if (Global.isNetworkAvailable(TermsConditions.this)) {
                    Global.createAndStartProgressBar(TermsConditions.this);
                    httpPostData = createQueryStringForParameters(params);
                    STAsyncHttpConnection async = new STAsyncHttpConnection();
                    async.execute(Global.terms);
                }else
                {
                    Toast.makeText(TermsConditions.this, getResources().getString(R.string.internet_error),
                            Toast.LENGTH_SHORT).show();
                }

                editor.putString("deviceString",deviceString);
                editor.putString("newDeviceString",deviceString);
                editor.commit();


                editor.commit();

                break;
            case R.id.denyBtn:
                finishAffinity();
                //sharedPref.edit().clear().commit();
                sharedPref.edit().clear();
                editor.putString("pushNotificationToken",sharedPref.getString("pushNotificationToken",""));
                editor.commit();
                sharedPref.edit().commit();
                Intent i = new Intent();
                i.setClass(TermsConditions.this, Main3Activity.class);
                startActivity(i);

                break;

        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
       // sharedPref.edit().clear().commit();
        sharedPref.edit().clear();
        editor.putString("pushNotificationToken",sharedPref.getString("pushNotificationToken",""));
        editor.commit();
        sharedPref.edit().commit();
        Intent i = new Intent(TermsConditions.this, Main3Activity.class);
        startActivity(i);
    }
    @Override
    protected void onResume() {
        super.onResume();
       // fetchLocation();
    }

  /*  public void fetchLocation() {
        gps = new GPSTracker(TermsConditions.this);
        Utils.currentLocation = gps.getLocation();
        if (gps.canGetLocation() == false) {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            Utils.showGPSAlert(TermsConditions.this);
        }
    }*/

    public static String createQueryStringForParameters(HashMap<String, String> parameters) {
        StringBuilder parametersAsQueryString = new StringBuilder();
        if (parameters != null) {
            boolean firstParameter = true;

            for (String parameterName : parameters.keySet()) {
                if (!firstParameter) {
                    parametersAsQueryString.append(PARAMETER_DELIMITER);
                }
                parametersAsQueryString.append(parameterName)
                        .append(PARAMETER_EQUALS_CHAR);
                try {
                    parametersAsQueryString.append(URLEncoder.encode(
                            parameters.get(parameterName), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                firstParameter = false;
            }
        }
        return parametersAsQueryString.toString();
    }
    public class STAsyncHttpConnection extends AsyncTask<String, Void, String> {
        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected String doInBackground(String... params) {
            String result = null, urlStr = params[0];
            HttpURLConnection urlConnection = null;
            exception = null;

            try {
                URL url = new URL(urlStr);
                Log.i("STAsyncHttpConnection", "URL: " + urlStr);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
                // handle POST parameters
                if (httpPostData != null) {

                    if (Log.isLoggable("STAsyncHttpConnection", Log.INFO)) {
                        Log.i("STAsyncHttpConnection", "POST parameters: " + httpPostData);
                    }


                    urlConnection.setRequestProperty ("x-account-key", sharedPref.getString("accountKey",""));
                    urlConnection.setRequestProperty ("x-access-token", sharedPref.getString("token",""));
                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    urlConnection.setRequestProperty("x-application", appKey);
                    urlConnection.setRequestProperty("x-user", sharedPref.getString("phoneNumber",""));
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("PUT");
                    // urlConnection.setFixedLengthStreamingMode(
                    // httpPostData.getBytes().length);
                    OutputStream writer =
                            urlConnection.getOutputStream();
                    writer.write(httpPostData.getBytes());
                    writer.flush();
                    writer.close();
                    // PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                    //out.print(httpPostData);
                    //out.flush();
                    //out.close();

                }
                int statusCode = urlConnection.getResponseCode();
                Log.i("iRestore","statusCode"+statusCode);
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    //Get Response
                    InputStream is = urlConnection.getInputStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while ((line = rd.readLine()) != null) {
                        response.append(line);
                    }
                    rd.close();
                    result = response.toString();
                } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    result = "{\"Error\" : true, \"Message\" : \"Unauthorized user\"}";
                }
                else if (statusCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT||statusCode == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
                    result = "{\"Error\" : true, \"Message\" : \"Request Timed out. Please try again later\"}";
                } else if (statusCode == 403) {
                    result = "{\"Error\" : true, \"Message\" : \"Email address has been taken.Please try with a different email address\"}";
                }
                else {
                    result = "{\"Error\" : true, \"Message\" : \"Server Error, please try again later\"}";
                }
            } catch (MalformedURLException ex) {
                exception = ex;
                Log.e("SocketTimeout exception", ex.toString());
            } catch (SocketTimeoutException ex) {
                exception = ex;
                ex.printStackTrace();
                Log.e("SocketTimeout exception", ex.toString());
            }catch(EOFException ef) {
                exception = ef;
                ef.printStackTrace();

                Log.e("EOFException exception", ef.toString());
            }
            catch (IOException ez) {
                exception = ez;
                ez.printStackTrace();

                Log.e("IO exception", ez.toString());
            } catch (Exception ez) {
                exception = ez;
                Log.e("exception", ez.toString());
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                if (exception == null && result != null) {
                    Log.i("iRestore","terms==="+result);
                    JSONObject responseObj = new JSONObject(result);
                    Log.i("iRestore","result==="+result);
                    //Integer userID = responseObj.getInt("UserID");
                    if (responseObj.getBoolean("Error")) {
                        Toast.makeText(TermsConditions.this, responseObj.getString("Message"),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        SharedPreferences.Editor editor = sharedPref.edit();
                        Intent intent = new Intent();
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setClass(TermsConditions.this, MainActivity.
                                class);
                        startActivity(intent);
                        editor.putBoolean("termsAccepted",true);
                        Global.reportSubmitted = true;

                        editor.commit();

                    }

                } else {
                    Toast.makeText(TermsConditions.this, getResources().getString(R.string.error),
                            Toast.LENGTH_SHORT).show();
                }
                if (Global.progress.isShowing()) {
                    Global.stopProgressBar();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
