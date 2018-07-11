package vda.irestore.com.vda_android.signup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;


import vda.irestore.com.vda_android.R;

import static vda.irestore.com.vda_android.Global.Global.appKey;

/**
 * Created by MALBEL on 17-07-2017.
 */

public class STAsyncHttpConnectionUpadteDevice extends AsyncTask<String, Void, String> {
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

    public STAsyncHttpConnectionUpadteDevice(Context currentAppContext) {
        this.appContext = currentAppContext;
    }
    public STAsyncHttpConnectionUpadteDevice(Context currentAppContext, HashMap<String, String> postData) {
        this.appContext = currentAppContext;

        this.httpPostData = STAsyncHttpConnectionUpadteDevice.createQueryStringForParameters(postData);
    }
    @Override
    protected String doInBackground(String... params) {
        String result = null, urlStr = params[0];
        HttpURLConnection urlConnection = null;
        exception = null;
        SharedPreferences sharedPref = appContext.getSharedPreferences(appContext.getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        try {
            URL url = new URL(urlStr);
            Log.i("STAsyncHttpConnection", "URL: " + sharedPref.getString("accountKey", "")
            +sharedPref.getString("token", ""));
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            // handle POST parameters
             if (httpPostData != null) {

              /*  if (android.util.Log.isLoggable("STAsyncHttpConnection", android.util.Log.INFO)) {
                    Log.i("STAsyncHttpConnection", "POST parameters: " + httpPostData);
                }*/

                 urlConnection.setRequestProperty("x-account-key", sharedPref.getString("accountKey", ""));
                 urlConnection.setRequestProperty("x-access-token", sharedPref.getString("token", ""));
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
             }

/*
                OutputStream writer =
                        urlConnection.getOutputStream();
                writer.write(httpPostData.getBytes());
                writer.flush();
                writer.close();*/

            // }
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
        String otp =null,otpValue,otpRequired,message, bucketName= null;
        boolean error ;
        Log.i("iRestore","response===gfdfhfh"+result);

        try {
            if (result != null) {


            }
                // message = responseObject.get("Message").toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
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
}
