package vda.irestore.com.vda_android.signup;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;

import vda.irestore.com.vda_android.Global.Global;
import vda.irestore.com.vda_android.MainActivity;
import vda.irestore.com.vda_android.R;

import static vda.irestore.com.vda_android.Global.Global.appKey;



/*Admin approval Screen*/

public class AdminApprovalScreen extends Activity {
    SharedPreferences sharedPref;
    String email,phoneNo;
    Boolean termsAccepted = false;
    String responseJSON;
    JSONArray userArray;
    SharedPreferences.Editor editor;
    Button chkStatusBtn,startAgain ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_approval_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");
        TextView adminApproval = (TextView)findViewById(R.id.admin_approval);
         chkStatusBtn = (Button)findViewById(R.id.chkStatusBtn);
         startAgain = (Button)findViewById(R.id.startAgainBtn);
        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);

        adminApproval.setText(getResources().getString(R.string.admin_approval)+"\n"+sharedPref.getString("utilityName","")+" "+getResources().getString(R.string.admin_approval_utility));

        chkStatusBtn.setTypeface(typeFace);
        adminApproval.setTypeface(typeFace);

        editor = sharedPref.edit();


        email = sharedPref.getString("emailAddress", "");
        phoneNo = sharedPref.getString("phoneNumber", "");

        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_titlebar, null);
        ActionBar actionBar = getActionBar();

        v.setBackgroundColor(Color.WHITE);
        TextView title = (TextView) v.findViewById(R.id.title);
        title.setTextColor(Color.parseColor("#00CC99"));
        Button nextBtn = (Button)v.findViewById(R.id.nextBtn) ;
        nextBtn.setVisibility(View.INVISIBLE);
        title.setText("Admin Approval");
        title.setTypeface(typeFace);

        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled (false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(v);

        if(sharedPref.getString("userType","").equalsIgnoreCase("EMPLOYEE"))
        {
            startAgain.setVisibility(View.GONE);
        }

        chkStatusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Global.currentLocation != null) {

                    try {

                        if (Global.isNetworkAvailable(AdminApprovalScreen.this)) {

                            Global.createAndStartProgressBar(AdminApprovalScreen.this);
                            HttpGetRequest async = new HttpGetRequest();
                            async.execute(Global.checkAdminApprovalStatus+"?appIdentifier="
                                    +sharedPref.getString("phoneNumber","")+"&application="+appKey);
                        } else
                        {
                            Toast.makeText(AdminApprovalScreen.this, getResources().getString(R.string.internet_error),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }catch(Exception e)
                    {

                    }


                }else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        Toast.makeText(AdminApprovalScreen.this, getResources().getString(R.string.enable_location),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AdminApprovalScreen.this, getResources().getString(R.string.no_location),
                                Toast.LENGTH_SHORT).show();
                    }
                }}

        });

         startAgain.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AlertDialog.Builder alertDialog = new AlertDialog.Builder(AdminApprovalScreen.this);
                 // Setting Dialog Title
                 alertDialog.setTitle("Alert");
                 // Setting Dialog Message
                 alertDialog.setMessage("Do you wish to signup again ");
                 alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     /*    sharedPref.edit().clear().commit();
                         finishAffinity();
                         Intent intent = new Intent(AdminApprovalScreen.this, Main3Activity.class);
                         startActivity(intent);*/
                         HashMap<String, String> params = new HashMap<String, String>();
                         params.put("email",sharedPref.getString("emailAddress",""));
                         params.put("phone",sharedPref.getString("phoneNumber",""));
                         params.put("application",appKey);

                         if (Global.isNetworkAvailable(AdminApprovalScreen.this)) {
                             Global.createAndStartProgressBar(AdminApprovalScreen.this);
                             DeleteSubscriptionsAsyncHttpConnection async = new DeleteSubscriptionsAsyncHttpConnection(AdminApprovalScreen.this,params);
                             async.execute(Global.deleteSubscriptions);

                         } else {
                             Toast.makeText(AdminApprovalScreen.this, getResources().getString(R.string.internet_error),
                                     Toast.LENGTH_SHORT).show();
                         }

                     }
                 });
                 alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 });
                 alertDialog.show();
             }

         });


    }
    @Override
    protected void onDestroy() {
         super.onDestroy();
         editor.commit();
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
                Log.i("vidisha","AdminApproval=="+sharedPref.getString("accountKey","")+sharedPref.getString("token","")+"\n"+sharedPref.getString("userID",""));
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
                Log.i("vidisha","hello token  admin==="+sharedPref.getString("token",""));
                Log.i("vidisha","hello token  admin==="+sharedPref.getString("accountKey",""));
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
            // super.onPostExecute(result);
            Log.i(appKey,"AdminApprovalScreen==="+result);
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(result);
                if(jsonObject.getBoolean("Error"))
                {
                    Toast.makeText(AdminApprovalScreen.this, jsonObject.getString("Message"),
                            Toast.LENGTH_SHORT).show();

                }else
                {
                    String status;
                    status = jsonObject.getJSONArray("Subscription").getJSONObject(0).getString("subscriptionStatus");
                    if(status.equalsIgnoreCase("approved")) {
                        editor.putBoolean("adminApprovalStatus", true);
                        editor.putString("subscriptionStatus",status);//vidisha added
                        if (sharedPref.getBoolean("termsAccepted",false)) {
                            Intent i = new Intent(AdminApprovalScreen.this, MainActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                            startActivity(i);
                            editor.putBoolean("ACCEPTANCE", termsAccepted);
                           // editor.putBoolean("adminApproval", ResponseObject.getJSONObject("Data").getBoolean("isApproved"));
                            editor.commit();
                            Global.reportSubmitted = true;

                        } else {
                            Intent i = new Intent(AdminApprovalScreen.this, TermsConditions.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            editor.commit();
                            startActivity(i);
                           // editor.putBoolean("adminApproval", ResponseObject.getJSONObject("Data").getBoolean("isApproved"));
                            editor.commit();
                        }
                        editor.commit();
                    }else if(status.equalsIgnoreCase("rejected")||status.equalsIgnoreCase("revoked"))
                    {
                        Toast.makeText(AdminApprovalScreen.this, "Your request for CP Manager Subscription has been declined. Please contact the Utility Admin for details.",
                                Toast.LENGTH_SHORT).show();
                        if (Global.progress.isShowing()) {
                            Global.stopProgressBar();
                        }

                    }
                    else
                    {
                        Toast.makeText(AdminApprovalScreen.this, "Your request for CP Manager Subscription is waiting for Admin Approval.",
                                Toast.LENGTH_SHORT).show();
                        if (Global.progress.isShowing()) {
                            Global.stopProgressBar();
                        }

                    }


                }


            }catch(Exception e)
            {

            }


        }
    }

    public class DeleteSubscriptionsAsyncHttpConnection extends AsyncTask<String, Void, String> {


        private static final char PARAMETER_DELIMITER = '&';
        private static final char PARAMETER_EQUALS_CHAR = '=';
        private static final int CONNECTION_TIMEOUT = 3000;
        Context appContext;

        String httpPostData;
        Exception exception;


        public DeleteSubscriptionsAsyncHttpConnection(Context currentAppContext, HashMap<String, String> postData) {
            this.appContext = currentAppContext;

            this.httpPostData = STAsyncHttpConnection.createQueryStringForParameters(postData);
        }

        @Override
        protected String doInBackground(String... params) {
            String result = null, urlStr = params[0];
            HttpURLConnection urlConnection = null;
            exception = null;

            try {
                URL url = new URL(urlStr);
                Log.i("x-account-key", ""+sharedPref.getString("tenantName","")+"  "+sharedPref.getString("authToken",""));
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
                    urlConnection.setRequestMethod("DELETE");

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
            JSONObject ResponseObject = null;
            String message;
            boolean error , adminApproval = false;
            Log.i("iRestore","c==="+result);
            try {
                if (result != null) {

                    ResponseObject = new JSONObject(result);
                    error = ResponseObject.getBoolean("Error");
                    message = ResponseObject.get("Message").toString();

                    if(!error) {

                         sharedPref.edit().clear();
                         editor.putString("pushNotificationToken",sharedPref.getString("pushNotificationToken",""));
                         editor.commit();
                         sharedPref.edit().commit();
                         finishAffinity();

                         Intent intent = new Intent(AdminApprovalScreen.this, Main3Activity.class);
                         startActivity(intent);

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

    }

}
