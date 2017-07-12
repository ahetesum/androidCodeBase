package com.connect.rh.domain.executor.impl;

import android.os.Handler;
import android.os.Looper;

import com.connect.rh.domain.executor.MainThread;


public class MainThreadImpl implements MainThread {

    private static MainThread sMainThread;
    private Handler mHandler;

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }
        return sMainThread;
    }
}
