package com.example.ravichandra.serviceusinghandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Ravichandra on 1/8/2018.
 */

public class BroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context,ServiceExample.class));
    }
}
