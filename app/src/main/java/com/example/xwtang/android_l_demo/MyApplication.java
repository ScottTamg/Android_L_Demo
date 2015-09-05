package com.example.xwtang.android_l_demo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by tang on 2015/8/12.
 */
public class MyApplication extends Application {
    private static RequestQueue queues;

    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpQueue() {
        return queues;
    }
}
