package vda.irestore.com.vda_android.Global;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vda.irestore.com.vda_android.R;


/**
 * Created by MALBEL on 12-12-2017.
 */

public class Global {

    public static Location currentLocation;
    public static String addressString;
    public static String street;
    public static String streetNumber;
    public static String city;
    public static String state;
    public static String stateAbbr;
    public static String country;
    public static String countryAbbr;
    public static String zipCode;
    public static Bitmap assetImage;
    public static Bitmap assetImageUncompressed;
    public static Bitmap assetImage1;
    public static Bitmap assetImageUncompressed1;


    public static HashMap<String,String > departmentHashMap= new HashMap();
    public static HashMap<String,String > departmentHashMapReverse= new HashMap();
    public static HashMap<String,String > problemTypeHashMap= new HashMap();
    public static HashMap<String,String > priorityHashmap= new HashMap();
    public static HashMap<String,String > statusHashmap= new HashMap();
    public static HashMap<String,String > eventTypeHashmap= new HashMap();

    public static SharedPreferences scopesPreferences,metadataPreferences;
    public static SharedPreferences.Editor scopesPreferencesEditor,metadataPreferencesEditor;



    // AWS Cognito
    public static String COGNITO_POOL_ID = "us-east-1:a66738b2-25c3-4e7b-a46c-73a42a771c45";
    public static Regions COGNITO_REGION = Regions.US_EAST_1;

    // AWS Bucket Regions
    public static Regions BUCKET_REGION = Regions.US_EAST_1;
    public static String BUCKET_NAME = "irestore-cp-manager-dev";
    public static String BUCKET_FOLDER = "dev";


    public static String AWS_URL = "https://irestore-yc-";
    public static String S3_URL = ".s3.amazonaws.com/";
    public  static List<File> images_array = new ArrayList<File>();
    public  static List<File> update_images_array = new ArrayList<File>();
    public static List<String> images_comment = new ArrayList<>();


    public static ArrayList<String> selectedNotificationDivision = new ArrayList<>();;
    public static ArrayList<String> selectedNotificationDepartment =  new ArrayList<>();
    public static ArrayList<String> selectedNotificationMedium= new ArrayList<>();
    public static ArrayList<String> selectedNotificationActions= new ArrayList<>();


    public  static int mSelectedProblem = 20 ;
    public  static int mSelectedDepartment =20;
    public  static int mSelectedPriority =20;
    public  static int mSelectedSorting =20;
    public  static int mSelectedNotificationAction =20;
    public  static int mSelectedAssignTo =20;

    public static boolean clickedOnEdit = false;

    public static Boolean reportSubmitted = false;
    public static Boolean fromYCAction = false;

    public static String problemTypeEdit;
    public static AmazonS3 s3;
    public static ProgressDialog progress;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;


    public static String appKey = "VDA";
    public static String FIREBASE_URL = "https://vda-ios.firebaseio.com/";

    public static String filterURL="https://dev.irestore.info/v1/yellowCards/?order=ASC&page=";
    public static String signUpURL = "https://dev.irestore.info/v1/signup/checkUser";//get//email, phone;
    public static String getOTP = "https://dev.irestore.info/v1/common/otp/?phone=";
    public static String createProfile = "https://dev.irestore.info/v1/common/users";//post
    public static String updateProfile = "https://dev.irestore.info/v1/common/users/profile";//put
    public static String checkAdminApprovalStatus = "https://dev.irestore.info/v1/common/subscriptions";//get
    public static String deleteSubscriptions = "https://dev.irestore.info/v1/common/subscriptions/";
    public static String syncAPI = "https://dev.irestore.info/v1/common/sync/"+appKey+"/?os=ANDROID";//&email=arun.prasad101@gmail.com&phone=9845354151";
    public static String createNotificationRules = "https://dev.irestore.info/v2/common/users/notificationRules/";
    public static String updateNotificationRules = "https://dev.irestore.info/v2/common/users/notificationRule/";
    public static String getDamageReportURL = "https://dev.irestore.info/v1/reports/";
    public static String terms ="https://dev.irestore.info/v1/common/subscriptions/deviceConfiguration/"+appKey;

    public static String SubmitSDAReportAPI ="https://dev.irestore.info/v1/sda/create/";
  /*  public static String FIREBASE_URL = "https://irestore-yellowcards-beta.firebaseio.com/";

    public static String filterURL="https://api-beta.irestore.info/v1/yellowCards/?order=ASC&page=";
    public static String signUpURL = "https://api-beta.irestore.info/v1/signup/checkUser";//get//email, phone;
    public static String getOTP = "https://api-beta.irestore.info/v1/common/otp/?phone=";
    public static String createProfile = "https://api-beta.irestore.info/v1/common/users";//post
    public static String updateProfile = "https://api-beta.irestore.info/v1/common/users/profile";//put
    public static String checkAdminApprovalStatus = "https://api-beta.irestore.info/v1/common/subscriptions";//get
    public static String deleteSubscriptions = "https://api-beta.irestore.info/v1/common/subscriptions/";
    public static String syncAPI = "https://api-beta.irestore.info/v1/common/sync/YC/?os=ANDROID";//&email=arun.prasad101@gmail.com&phone=9845354151";
    public static String createNotificationRules = "https://api-beta.irestore.info/v2/common/users/notificationRules/";
    public static String updateNotificationRules = "https://api-beta.irestore.info/v2/common/users/notificationRule/";
    public static String getDamageReportURL = "https://api-beta.irestore.info/v1/reports/";
    public static String terms ="https://api-beta.irestore.info/v1/common/subscriptions/deviceConfiguration/YC";*/

    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
                int count=is.read(bytes, 0, buffer_size);
                if(count==-1)
                    break;
                os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }

    public static void initializeSharedPrefernceData(Context context) {
        scopesPreferences  = context.getSharedPreferences(context.getString(
                R.string.scopes_preferences), Context.MODE_PRIVATE);
        scopesPreferencesEditor = Global.scopesPreferences.edit();
        metadataPreferences = context.getSharedPreferences(context.getString(
                R.string.metadataPreferences), Context.MODE_PRIVATE);
        metadataPreferencesEditor = Global.metadataPreferences.edit();
    }

    public static void createAndStartProgressBar(final Context context)
    {
        progress = new ProgressDialog(context, R.style.ProgressDialogTheme);
        progress.setCancelable(true);//to stop the progress dialog from being cancelled
        progress.setCanceledOnTouchOutside(false);// when the user touches the screen when running
        progress.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                ((Activity)context).finish();
            }
        });
        startProgressBar();
    }

    public static String capitalize(String capString){
        StringBuffer capBuffer = new StringBuffer();
        Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(capString);
        while (capMatcher.find()){
            capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase());
        }

        return capMatcher.appendTail(capBuffer).toString();
    }

    public static void startProgressBar()
    {
        if (!progress.isShowing())
            progress.show();
    }
    public static void stopProgressBar()
    {
        progress.dismiss();
    }
    public static void ClearData()
    {
        mSelectedProblem = 20 ;
        mSelectedDepartment =20;
        mSelectedPriority =20;
        mSelectedSorting =20;
        mSelectedAssignTo =20;
      //  mSelectedNotificationAction =20;
    }



    public static void credentialsProvider(Context contextV){

        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                contextV,
                Global.COGNITO_POOL_ID, // Identity Pool ID
                Global.COGNITO_REGION // Region
        );

        setAmazonS3Client(credentialsProvider);
    }
    public static void setAmazonS3Client(CognitoCachingCredentialsProvider credentialsProvider){

        ClientConfiguration configuration = new ClientConfiguration();
      //  configuration.setMaxErrorRetry(3);
        configuration.setConnectionTimeout(50*1000);
        configuration.setSocketTimeout(50*1000);
       // configuration.setMaxErrorRetry(3);
      //  configuration.setProtocol(Protocol.HTTPS);
        // Create an S3 client
        s3 = new AmazonS3Client(credentialsProvider,configuration);

        // Set the region of your S3 bucket
        s3.setRegion(Region.getRegion(Global.BUCKET_REGION));


    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String convertDate(String s) {
       // SimpleDateFormat newformat = new SimpleDateFormat("MMMM dd , yyyy, h:mm aa");
        SimpleDateFormat newformat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            String reformattedStr;
            if(s.contains("T")) {
                String datestring = s.replace("T", " ");
                SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                reformattedStr = newformat.format(oldformat.parse(datestring));
            }
            else {
                // SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZZZZZ");
                SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                reformattedStr = newformat.format(oldformat.parse(s));
            }
            return reformattedStr;

        } catch (Exception e) {
            return null;
        }
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean checkPermission(final Context context)
    {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion>= Build.VERSION_CODES.M)
        {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("External storage permission is necessary");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();

                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }


}
