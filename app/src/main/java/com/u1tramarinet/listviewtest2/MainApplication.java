package com.u1tramarinet.listviewtest2;

import android.app.Application;

import com.u1tramarinet.listviewtest2.util.Logger;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.initialize();
    }
}
