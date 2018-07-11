package vda.irestore.com.vda_android.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

import vda.irestore.com.vda_android.R;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

  /*  private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    private NotificationUtils notificationUtils;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage == null)
            return;

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Notification Body: " + remoteMessage.getNotification().getBody());
            handleNotification(remoteMessage.getNotification().getBody());
        }
    }
    private void handleNotification(String message) {
        if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
            // app is in foreground, broadcast the push message
            Intent pushNotification = new Intent(Config.PUSH_NOTIFICATION);
            pushNotification.putExtra("message", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

            // play notification sound
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
        }else{
            // If the app is in background, firebase itself handles the notification
        }
    }
    *//**//**
     * Showing notification with text only
     *//**//*
    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }

    *//**/
    /**
     * Showing notification with text and image
     *//**//*
    private void showNotificationMessageWithBigImage(Context context, String title, String message, String timeStamp, Intent intent, String imageUrl) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent, imageUrl);
    }*/
    private static final String TAG = "MyFMService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Handle data payload of FCM messages.
        // ey4X_qVyAlY:APA91bEiGdkM98q6ErV5EfA1-84jGZtA5cfwOrXNsTQZDPgQAVNJP4H5KxmWrbRf2N46ibslQC4-X8wphMEbzM9DjLkxC14b2iQLtzUBriQf3sLCOvW6fiWi-3k3YFdtq5dW1VfSUqyK

        int notificationId = new Random().nextInt();


        //  {"_id":"59666fb9bc86d6c953de65e3","deviceReportId":"reportid:6037938363-20170712145245","loc":{"type":"Point","coordinates":[-70.86406706,42.9495716]},"geohash":1793544951526368,"timestamp":"2017-07-12T18:52:52.000Z","displayTimestamp":"2017-07-12T14:52:52-04:00","damageType":"POLE","damageSubType":"Pole MVA","submittedBy":{"email":"ulbanj@unitil.com","phone":"6037938363","name":"Jacklyn Ulban","jobTitle":"Emergency Planning Coordinator"},"address":{"userAddress":"6 Liberty Ln E, Hampton, NH 03842, USA","resolvedAddress":"6 Liberty Ln E, Hampton, NH 03842, USA","city":"Hampton","subLocality":"","state":"New Hampshire","stateShortName":"NH","country":"United States","countryShortName":"US","zipcode":"03842","division":"","region":"Seacoast","platform":"","county":"Rockingham County"},"status":"Acknowledged","priority":"normal","damageDetails":{"isSafe":true,"roadBlocked":false,"imageDetails":[{"imageUrl":"https://irestore.s3.amazonaws.com/unitil/reportid:6037938363-20170712145245_unitil.irestore.info_1.png","thumbnailUrl":"https://s3.amazonaws.com/irestore-thumbnail%2Funitil/reportid%3A6037938363-20170712145245_unitil.irestore.info_1.png"},{"imageUrl":"","thumbnailUrl":""}],"comments":"testing refresh"},"assetDetails":{"assetId":""},"isActive":true,"nonServiceable":false,"serviceType":null,"serviceTypeServiceable":true,"dateCreated":"2017-07-12T18:51:37.265Z","dateModified":"2017-07-12T18:51:37.265Z","isNotificationSent":true,"trimmedCity":"hampton","reportLink":"http://tinyurl.com/y9xtyu6k","statusUpdatedBy":{"ACKNOWLEDGED":null}}

        sharedPref = getSharedPreferences(getString(
                R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        Log.d(TAG, "FCM Message Id: " + remoteMessage.getMessageId());
        Log.d(TAG, "FCM Notification Message: " +
                remoteMessage.getNotification());
        Log.d(TAG, "FCM Data Message: " + remoteMessage.getData());
        Log.d("msg", "onMessageReceived: " + remoteMessage.getData().get("data"));

   /*     NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_stat_dsf)
                        //.setContentTitle("Yellow Card")
                        .setContentText(remoteMessage.getData().get("message").toString());

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, notificationId, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());*/


    }

}