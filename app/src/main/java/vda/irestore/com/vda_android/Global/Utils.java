package vda.irestore.com.vda_android.Global;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

import com.amazonaws.regions.Regions;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vda.irestore.com.vda_android.R;

/**
 * Created by MALBEL on 01-09-2017.
 */

public class Utils {




    public static String values = "\n"+
            "{\n"+
            "  \"values\" : [ {\n"+
            "    \"activeImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion_active.png\",\n"+
            "    \"defaultImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion.png\",\n"+
            "    \"displayName\" : \"Pole\",\n"+
            "    \"name\" : \"P\"\n"+
            "  }, {\n"+
            "      \"activeImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion_active.png\",\n"+
            "    \"defaultImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion.png\",\n"+
            "    \"displayName\" : \"Pull Box\",\n"+
            "    \"name\" : \"B\"\n"+
            "  }, {\n"+
            "      \"activeImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion_active.png\",\n"+
            "    \"defaultImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion.png\",\n"+
            "    \"displayName\" : \"Sectionalizer Cabinet\",\n"+
            "    \"name\" : \"C\"\n"+
            "  }, {\n"+
            "      \"activeImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion_active.png\",\n"+
            "    \"defaultImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion.png\",\n"+
            "    \"displayName\" : \"Splice Box\",\n"+
            "    \"name\" : \"S\"\n"+
            "  }, {\n"+
            "      \"activeImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion_active.png\",\n"+
            "    \"defaultImageURL\" : \"https://s3.amazonaws.com/restore-build-artefacts/YellowCardsIcons/corrosion.png\",\n"+
            "    \"displayName\" : \"Padmounts\",\n"+
            "    \"name\" : \"T\"\n"+
            "  } ]\n"+
            "}\n";






    public static Double selectedPoleLatitude;
    public static Double selectedPoleLongitude;
    public static String selectedPoleId;

    public static Location currentLocation;
    public static String addressString;
    public static String street;
    public static String city;
    public static String state;
    public static String stateAbbr;
    public static String zipCode;
    public static String country;
    public static String countryAbbr;
    public static ProgressDialog progress;
    public static Boolean reportSubmitted = false;
    public  static HashMap<String,List<String>> metadataMap = new HashMap<String,List<String>>();
    public  static ArrayList<String> metadataList = new ArrayList<String>();
    public  static int mSelectedDepartment =20;




    public static String FIREBASE_URL = "https://irestore-inspections-app-prod.firebaseio.com/";


    public static String S3_URL = ".s3.amazonaws.com/";


    public static String signUpURL = "https://api.irestore.info/v1/signup/checkUser";//get//email, phone;
    public static String getOTP = "https://api.irestore.info/v1/common/otp/?phone=";
    public static String createProfile = "https://api.irestore.info/v1/common/users";//post
    public static String updateProfile = "https://api.irestore.info/v1/common/users/profile";//put
    public static String checkAdminApprovalStatus = "https://api.irestore.info/v1/common/subscriptions";//get
    public static String deleteSubscriptions = "https://api.irestore.info/v1/common/subscriptions/";
    public static String syncAPI = "https://api.irestore.info/v1/common/sync/IR/?os=ANDROID";//&email=arun.prasad101@gmail.com&phone=9845354151";
    public static String saveDamageReportURL = "https://api.irestore.info/v1/reports/save/";
    public static String getDamageReportURL = "https://api.irestore.info/v1/inspectionReports/?page=";
    public static String terms ="https://api.irestore.info/v1/common/subscriptions/deviceConfiguration/IR";
    public  static List<File> images_array = new ArrayList<File>();

    public static String SubmitInspectionReportAPI ="https://api.irestore.info/v1/inspectionReports/";

    // AWS Cognito
    public static String COGNITO_POOL_ID = "us-east-1:119fd168-263e-41e6-8fff-a966cf0f9b33";
    public static Regions COGNITO_REGION = Regions.US_EAST_1;

    // AWS Bucket Regions
    public static Regions BUCKET_REGION = Regions.US_EAST_1;

    public static String BUCKET_NAME = "irestore-ir-prod";
    public static String BUCKET_NAME_FOLDER = "prod";

/*    // AWS Cognito
    public static String COGNITO_POOL_ID = "us-east-1:119fd168-263e-41e6-8fff-a966cf0f9b33";
   // public static String COGNITO_POOL_ID = "us-east-1:a66738b2-25c3-4e7b-a46c-73a42a771c45";
    public static Regions COGNITO_REGION = Regions.US_EAST_1;

    // AWS Bucket Regions
    public static Regions BUCKET_REGION = Regions.US_EAST_1;*/


    static HashMap<String ,String> damageNameMapping = new HashMap<>();

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

    public static Bitmap getBitmap(String path)
    {
        File imgFile = new File(path);
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        Matrix matrix = new Matrix();

        matrix.postRotate(90);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(myBitmap,myBitmap.getWidth(),myBitmap.getHeight(),true);

        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);

        return  scaledBitmap;
    }

    public static void applyDim(@NonNull ViewGroup parent, float dimAmount){
        Drawable dim = new ColorDrawable(Color.parseColor("#F5F5F5"));
        //Drawable dim = new ColorDrawable(Color.BLACK);
        dim.setBounds(0, 0, parent.getWidth(), parent.getHeight());
        dim.setAlpha((int) (255 * dimAmount));

        ViewGroupOverlay overlay = parent.getOverlay();
        overlay.add(dim);
    }

    public static void clearDim(@NonNull ViewGroup parent) {
        ViewGroupOverlay overlay = parent.getOverlay();
        overlay.clear();
    }
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

    public static void showGPSAlert(final Context context)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        // Setting Dialog Title
        alertDialog.setTitle("Alert");

        // Setting Dialog Message
        alertDialog.setMessage("Please enable location services on your phone");

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                ((Activity)context).startActivityForResult(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 1);

            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
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


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
    public static String getFormattedLocationInDegree(double latitude, double longitude) {
        try {
            int latSeconds = (int) Math.round(latitude * 3600);
            int latDegrees = latSeconds / 3600;
            latSeconds = Math.abs(latSeconds % 3600);
            int latMinutes = latSeconds / 60;
            latSeconds %= 60;

            int longSeconds = (int) Math.round(longitude * 3600);
            int longDegrees = longSeconds / 3600;
            longSeconds = Math.abs(longSeconds % 3600);
            int longMinutes = longSeconds / 60;
            longSeconds %= 60;
            String latDegree = latDegrees >= 0 ? "N" : "S";
            String lonDegrees = longDegrees >= 0 ? "E" : "W";

            return  Math.abs(latDegrees) + "°" + latMinutes + "'" + latSeconds
                    + "\"" + latDegree +" , "+ Math.abs(longDegrees) + "°" + longMinutes
                    + "'" + longSeconds + "\"" + lonDegrees;
        } catch (Exception e) {
            return ""+ String.format("%8.5f", latitude) + " , "
                    + String.format("%8.5f", longitude) ;
        }
    }


}
