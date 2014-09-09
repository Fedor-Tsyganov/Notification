package com.fedortsyganov.homework1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMainPage extends Activity
{
    private String KEY = "HomeworkOne";
    private String VALUE = " Message from Homework 1 - it should be in Logcat ";
    private String ACTION = "xx.yy.zz";
    private Button button_sendNotification;

//*******************************************************
    private void sendNotification()
    {
        Intent intent = new Intent(this, ResultActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new Notification.Builder(this)
                .setContentTitle("Title")
                .setContentText("text of notification")
                .setSmallIcon(R.drawable.abc_ic_search)
                .setContentIntent(pi).build();

        intent.putExtra(KEY, VALUE);
        intent.setAction(ACTION);
        sendBroadcast(intent);

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, notification);
    }
//******************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        button_sendNotification = (Button) findViewById(R.id.b_2send_broadcast);
        button_sendNotification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendNotification();
            }
        });

    }
}
