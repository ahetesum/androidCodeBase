package com.connect.rh.utils;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.connect.rh.data.net.base.SessionManager;

public class SessionAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SessionManager.getInstance(context).sessionAlarmReceived(intent);
    }
}
