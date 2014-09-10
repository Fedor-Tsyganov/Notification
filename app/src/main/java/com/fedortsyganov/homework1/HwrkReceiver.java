package com.fedortsyganov.homework1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HwrkReceiver extends BroadcastReceiver
{
    private String KEY = "HomeworkOne";
    private String ACTION = "xx.yy.zz";
    private static int NOTIFY_ME_ID = 1834; //unique ID
    Notification notification;
    String notifMessage = "New message from Broadcast"; //message

    //************************onReceive()********************************
    @Override
    public void onReceive(Context context, Intent i)
    {
        String action = i.getAction();
        if(action != null && action.equals(ACTION))
        {
            String msg = i.getStringExtra(KEY);
            Log.d("Message in Log file: ", msg);
            sendNotification(context, msg);
        }
    }
    //************************sendNotification()*****************************
    public void sendNotification(Context mContext, String message)
    {
        //when user push on a notification, new activity opens
        Intent intent = new Intent(mContext, ResultActivity.class);
        PendingIntent pi = PendingIntent.getActivity(mContext, 0, intent, 0);

        //building notification
        notification = new Notification.Builder(mContext)
                .setContentTitle("Broadcast received")
                .setContentText(message)
                .setTicker(notifMessage)
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi).build();

        NotificationManager mgr = (NotificationManager)
                mContext.getSystemService (mContext.NOTIFICATION_SERVICE);
        mgr.notify(NOTIFY_ME_ID, notification);
    }
}
