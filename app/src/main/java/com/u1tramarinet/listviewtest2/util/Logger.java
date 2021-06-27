package com.u1tramarinet.listviewtest2.util;

import timber.log.Timber;

public class Logger {
    private Logger() {
    }

    public static void initialize() {
        Timber.plant(new Timber.DebugTree());
    }

    public static void d(String message) {
        Timber.d(message);
    }
}
