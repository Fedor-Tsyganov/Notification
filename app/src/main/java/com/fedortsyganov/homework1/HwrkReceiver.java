package com.fedortsyganov.homework1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by fedortsyganov on 9/3/14.
 */
public class HwrkReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if (action != null && action.equals("xx.yy.zz"))
        {
            String msg = intent.getStringExtra("HomeworkOne");
            Log.d("Received Message", msg);
        }
    }
}
