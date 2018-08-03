package vda.irestore.com.vda_android.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
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


import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.MainActivity;
import vda.irestore.com.vda_android.R;
import vda.irestore.com.vda_android.services.GPSTracker;

import static vda.irestore.com.vda_android.Global.Global.appKey;


public class EnterOTP extends Activity {
    Button next;
    EditText enterOTP;
    String otpvalue,email,phoneNo;
    private Toast showToastMessage;
    boolean isOtpExpired;

    TextView timer ,resendOtp;
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private final long startTime = 300 * 1000;
    private final long interval = 1 * 1000;
    private GPSTracker gps;
    private ImageView clientLogo;



    Boolean isTestTenant , termsAccepted;
    JSONArray tenantsArray,userArray;

    int adminApprovalFlag ;


    String responseJSON;
    File file;
    SharedPreferences sharedPref;
    JSONObject responseData = null;
    SharedPreferences.Editor editor;
    LinearLayout logoHolder;
    FileCache fileCache;
    String imageName= null;
    boolean otpRequired = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_enterotp);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        fileCache=new FileCache(this);

        enterOTP = (EditText)findViewById(R.id.enterOTP);
        next = (Button)findViewById(R.id.nextBtn);
        resendOtp = (TextView) findViewById(R.id.resendBtn);

        ImageView clientLogo= (ImageView) findViewById(R.id.client_logo);

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        Log.i("vidisha","OTP Screen=="+sharedPref.getString("token",""));


        Typeface typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        enterOTP.setTypeface(typeFace);
        next.setTypeface(typeFace);
        resendOtp.setTypeface(typeFace);

        nextOnClick();
        resendOTPClick();



        timer = (TextView) findViewById(R.id.otptimer);
        timer.setTypeface(typeFace);
        TextView notification = (TextView) findViewById(R.id.OtpText);
        TextView dummyTextView = (TextView) findViewById(R.id.dummyTextView);

        notification.setText(sharedPref.getString("phoneNumber",""));

        ImageLoader imgLoader = new ImageLoader(this);

        imgLoader.DisplayImage(sharedPref.getString("imageURL",""),"", clientLogo,dummyTextView);
        //notification.setText(phoneNo+"OTP=="+sharedPref.getString("otpCode", ""));

        notification.setTypeface(typeFace);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        if (!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
     //   fetchLocation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //editor.putBoolean("otpEntered", true);
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
       // editor.putBoolean("otpEntered", true);
        editor.commit();

    }



   /* public void fetchLocation() {
        gps = new GPSTracker(EnterOTP.this);
        Utils.currentLocation = gps.getLocation();
        if (gps.canGetLocation() == false) {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
    }*/
    public void nextOnClick(){
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String s1 = enterOTP.getText().toString();
                otpvalue = sharedPref.getString("otpValue", "");
                editor.putBoolean("chooseUtility",true);
                editor.commit();

                    if (s1.length() == 0 ) {
                        showToast(getString(
                                R.string.empty_otp));
                    }else if (!s1.equals(otpvalue)||isOtpExpired) {
                        showToast(getString(
                                R.string.empty_correct_otp));
                    }
                    else
                        {
                               /* Intent i = new Intent(EnterOTP.this, MyProfile.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                editor.putBoolean("OTPEntered", true);
                                editor.putBoolean("userProfileCreated", false);
                                editor.commit();
                                startActivity(i);*/
                             if(sharedPref.getBoolean("adminApprovalRequired",false)) {
                                 if (!sharedPref.getString("subscriptionStatus", "").equals("approved")) {


                                     if (sharedPref.getString("userID", "").equals("0")) {
                                         Intent i = new Intent(EnterOTP.this, MyProfile.class);
                                         i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                         //editor.putBoolean("OTPEntered", true);
                                         editor.putBoolean("userProfileCreated", false);
                                         editor.commit();
                                         startActivity(i);
                                     } else {
                                         if (!sharedPref.getString("subscriptionStatus", "").equals("")) {
                                             Intent i = new Intent(EnterOTP.this, AdminApprovalScreen.class);
                                             i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                             // editor.putBoolean("OTPEntered", true);
                                             editor.putBoolean("userProfileCreated", true);
                                             editor.commit();
                                             startActivity(i);
                                         } else {
                                             Intent i = new Intent(EnterOTP.this, MyProfile.class);
                                             i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                             //editor.putBoolean("OTPEntered", true);
                                             editor.putBoolean("userProfileCreated", false);
                                             editor.commit();
                                             startActivity(i);
                                         }
                                     }
                                 } else {

                                     if (!sharedPref.getBoolean("termsAccepted", false)) {
                                         Intent loginIntent = new Intent();
                                         loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                         loginIntent.setClass(EnterOTP.this, TermsConditions.class);
                                         editor.putBoolean("ACCEPTANCE", sharedPref.getBoolean("termsAccepted", false));
                                         editor.putBoolean("userProfileCreated", true);
                                         editor.commit();
                                         startActivity(loginIntent);
                                         Global.reportSubmitted = true;

                                     } else {
                                         String deviceString = UUID.randomUUID().toString();
                                         SharedPreferences.Editor editor = sharedPref.edit();
                                         // editor.putBoolean("ACCEPTANCE", acceptance);
                                         JSONObject userObj = null;
                                         Intent loginIntent = new Intent();
                                         JSONObject jsonParam = null;
                                         JSONObject deviceParam = null;
                                         TimeZone tz = TimeZone.getTimeZone("UTC");
                                         DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                                         df.setTimeZone(tz);
                                         // loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);


                                         try {
                                             jsonParam = new JSONObject();
                                             jsonParam.put("isAccepted", true);
                                             jsonParam.put("version", EnterOTP.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                             jsonParam.put("time", df.format(new Date()));
                                             jsonParam.put("latitude", String.valueOf(
                                                     Global.currentLocation.getLatitude()));
                                             jsonParam.put("longitude", String.valueOf(
                                                     Global.currentLocation.getLongitude()));


                                             Field[] fields = Build.VERSION_CODES.class.getFields();
                                             String osName = fields[Build.VERSION.SDK_INT].getName();

                                             deviceParam = new JSONObject();
                                             deviceParam.put("type", "ANDROID");
                                             deviceParam.put("os", osName);
                                             deviceParam.put("make", Build.MANUFACTURER);
                                             deviceParam.put("model", Build.MODEL);
                                             deviceParam.put("deviceString", deviceString);
                                             deviceParam.put("version", EnterOTP.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                             deviceParam.put("pushNotificationToken", sharedPref.getString("pushNotificationToken",""));

                                         } catch (Exception e) {
                                             e.printStackTrace();
                                         }


                                         HashMap<String, String> params = new HashMap<String, String>();

                                         params.put("device", deviceParam.toString());
                                         params.put("terms", jsonParam.toString());
                                         try {
                                             params.put("version", EnterOTP.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                         } catch (Exception e) {

                                         }
                                         params.put("phone", sharedPref.getString("phoneNumber", ""));
                                         params.put("email", sharedPref.getString("emailAddress", ""));


                                         if (Global.isNetworkAvailable(EnterOTP.this)) {
                                             // Utils.createAndStartProgressBar(TermsConditions.this);
                                             String httpPostData = STAsyncHttpConnectionUpadteDevice.createQueryStringForParameters(params);
                                             STAsyncHttpConnectionUpadteDevice async = new STAsyncHttpConnectionUpadteDevice(EnterOTP.this, params);
                                             async.execute(Global.terms);
                                         } else {
                                             Toast.makeText(EnterOTP.this, getResources().getString(R.string.internet_error),
                                                     Toast.LENGTH_SHORT).show();
                                         }



                                         Intent i = new Intent();
                                         i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                         i.setClass(EnterOTP.this, MainActivity.class);
                                         editor.putBoolean("ACCEPTANCE", sharedPref.getBoolean("termsAccepted", false));
                                         editor.putBoolean("userProfileCreated", true);
                                         editor.putBoolean("adminApprovalStatus", true);
                                         editor.putString("deviceString",deviceString);
                                         editor.putString("newDeviceString",deviceString);
                                         editor.commit();
                                         startActivity(i);
                                         Global.reportSubmitted = true;
                                     }
                                 }
                             }else
                             {
                                 if (!sharedPref.getString("subscriptionStatus", "").equals("approved")) {


                                     if (sharedPref.getString("userID", "").equals("0")) {
                                         Intent i = new Intent(EnterOTP.this, MyProfile.class);
                                         i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                         //editor.putBoolean("OTPEntered", true);
                                         editor.putBoolean("userProfileCreated", false);
                                         editor.commit();
                                         startActivity(i);
                                     } else {
                                         if (!sharedPref.getString("subscriptionStatus", "").equals("")) {
                                             Intent i = new Intent(EnterOTP.this, AdminApprovalScreen.class);
                                             i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                             // editor.putBoolean("OTPEntered", true);
                                             editor.putBoolean("userProfileCreated", true);
                                             editor.commit();
                                             startActivity(i);
                                         } else {
                                             Intent i = new Intent(EnterOTP.this, MyProfile.class);
                                             i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                             //editor.putBoolean("OTPEntered", true);
                                             editor.putBoolean("userProfileCreated", false);
                                             editor.commit();
                                             startActivity(i);
                                         }
                                     }
                                 }else {
                                     Intent loginIntent = new Intent();
                                     loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                     loginIntent.setClass(EnterOTP.this, TermsConditions.class);
                                     editor.putBoolean("ACCEPTANCE", sharedPref.getBoolean("termsAccepted", false));
                                     editor.putBoolean("userProfileCreated", true);
                                     editor.commit();
                                     startActivity(loginIntent);
                                     Global.reportSubmitted = true;
                                 }
                             }
                        }



                }

        });
    }

    private void resendOTPClick() {
        resendOtp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                enterOTP.setText("");
                otpvalue = sharedPref.getString("otpValue", "");
                // check if GPS enabled
                if(timerHasStarted) {
                    countDownTimer.cancel();
                    timerHasStarted = false;
                    isOtpExpired = false;
                    timer.setText("00:00");

                }

                /*    if (email.length() == 0) {
                        showToast(getString(
                                R.string.empty_user_email));
                    }  else {*/
                        try {

                          /*  InputMethodManager inputMethodManager = (InputMethodManager) EnterOTP.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                            //Find the currently focused view, so we can grab the correct window token from it.
                            View view = EnterOTP.this.getCurrentFocus();
                            //If no view currently has focus, create a new one, just so we can grab a window token from it
                            if (view == null) {
                                view = new View(EnterOTP.this);
                            }
                            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);


                            JSONObject jsonParam =null;
                            jsonParam = new JSONObject();
                            jsonParam.put("emailAddress", email);
                            jsonParam.put("phoneNumber",  phoneNo);

                            HashMap<String, String> params = new HashMap<String, String>();
                            params.put("progress", "2");
                            params.put("appString", "fr");
                            params.put("user",jsonParam.toString());
                            params.put("tenant", sharedPref.getString("tenantID",""));
                            if (Utils.isNetworkAvailable(EnterOTP.this)) {
                            Utils.createAndStartProgressBar(EnterOTP.this);
                            STAsyncHttpConnection async = new STAsyncHttpConnection(EnterOTP.this,params);
                            async.execute(Utils.signUpURL);
                            }
                            else
                            {
                                Toast.makeText(EnterOTP.this, getResources().getString(R.string.internet_error),
                                        Toast.LENGTH_SHORT).show();
                            }*/
                            if (Global.isNetworkAvailable(EnterOTP.this)) {
                                Global.createAndStartProgressBar(EnterOTP.this);
                                HttpGetRequest async = new HttpGetRequest();
                                async.execute(Global.getOTP+sharedPref.getString("phoneNumber",""));
                            } else {
                                Toast.makeText(EnterOTP.this, getResources().getString(R.string.internet_error),
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Log.e("log_tag",
                                    "Error in http connection!!" + e.toString());
                        }
                   // }
                } /*else {
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }*/

            //}
        });
    }

    public void showToast(final String toast) {
        runOnUiThread(new Runnable() {
            public void run() {
                showToastMessage = Toast.makeText(EnterOTP.this, toast, Toast.LENGTH_SHORT);
                showToastMessage.show();
            }
        });
    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            isOtpExpired = true;
            timer.setText("00:00");
            if(!EnterOTP.this.isFinishing())
                showToast(getString(
                        R.string.otp_expire));
        }
        @Override
        public void onTick(long millisUntilFinished) {
            int seconds = (int) (millisUntilFinished / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            timer.setText("" + String.format("%02d", minutes)
                    + ":" + String.format("%02d", seconds));
        }

    }

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
                connection.setRequestProperty("x-application", appKey);
                connection.setRequestProperty("x-user", sharedPref.getString("phoneNumber",""));

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
            JSONObject responseObject,responseData= null;
            String otpValue,message;
            boolean error ;
            Log.i("iRestore","response==="+result);

            try {
                if (result != null) {

                    responseObject = new JSONObject(result);
                    error = responseObject.getBoolean("Error");


                    if(!error)
                    {
                       // otpObject = new JSONObject(result);
                            editor.putString("otpValue", responseObject.getString("OTP"));
                            editor.putString("otpValue", responseObject.getString("OTP"));
                            editor.putString("emailAddress", sharedPref.getString("emailAddress",""));
                            editor.commit();
                            if (!timerHasStarted) {
                                countDownTimer.start();
                                timerHasStarted = true;
                            }


                    }else
                    {
                        message = responseObject.get("Message").toString();
                        Toast.makeText(EnterOTP.this, message,
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(EnterOTP.this, EnterOTP.this.getResources().getString(R.string.error),
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
        private static final char PARAMETER_DELIMITER = '&';
        private static final char PARAMETER_EQUALS_CHAR = '=';
        private static final int CONNECTION_TIMEOUT = 3000;
        Context appContext;
        String requestType,safetyMessage,authToken;
        ImageView progressView;
        View bgView;
        String httpPostData,directURL="";
        Exception exception;

        public STAsyncHttpConnection(Context currentAppContext, HashMap<String, String> postData) {
            this.appContext = currentAppContext;

            this.httpPostData = createQueryStringForParameters(postData);
        }

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

                    urlConnection.setRequestProperty ("x-account-key", sharedPref.getString("tenantName",""));
                    urlConnection.setRequestProperty ("x-access-token", sharedPref.getString("authToken",""));
                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("POST");

                    OutputStream writer =
                            urlConnection.getOutputStream();
                    writer.write(httpPostData.getBytes());
                    writer.flush();
                    writer.close();

                }
                int statusCode = urlConnection.getResponseCode();
                Log.i("iRestore","statusCode==="+statusCode);

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
                }else {
                    result = "{\"Error\" : true, \"Message\" : \"Server Error, please try again later\"}";
                }
            } catch (MalformedURLException ex) {
                exception = ex;
                Log.e("SocketTimeout exception", ex.toString());
            } catch (SocketTimeoutException ex) {
                exception = ex;
                Log.e("SocketTimeout exception", ex.toString());
            } catch (IOException ez) {
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
            JSONObject responseObject,responseData= null;
            String otpValue,message;
            boolean error ;
             Log.i("iRestore","response==="+result);

            try {
                if (result != null) {

                    responseObject = new JSONObject(result);
                    error = responseObject.getBoolean("Error");
                    message = responseObject.get("Message").toString();

                    if(!error)
                    {
                        otpValue = responseObject.getJSONObject("Data").getJSONObject("otp").getString("value");
                        if(otpValue!=null ) {

                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("otpValue", otpValue);
                            editor.putString("emailAddress", email);
                            editor.commit();
                            if (!timerHasStarted) {
                                countDownTimer.start();
                                timerHasStarted = true;
                            }

                        }


                    }else
                    {
                        Toast.makeText(appContext, message,
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(appContext, appContext.getResources().getString(R.string.error),
                            Toast.LENGTH_SHORT).show();
                }
                if (Global.progress.isShowing()) {
                    Global.stopProgressBar();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        public String createQueryStringForParameters(HashMap<String, String> parameters) {
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
    }

}
