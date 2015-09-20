package com.example.xwtang.android_l_demo;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by tang on 2015/9/20.
 */
public class VolleyRequest {

    private static Context mContext;
    private static Request mRequest;

    public static void GetStringRequest(Context context, String url, String tag, VolleyRequestListener listener) {
        MyApplication.getHttpQueue().cancelAll(tag);
        mRequest = new StringRequest(Request.Method.GET, url, listener.Success(), listener.Error());
        mRequest.setTag(tag);
        MyApplication.getHttpQueue().add(mRequest);
        MyApplication.getHttpQueue().start();
    }

    public static void PostStringRequest(Context context, String url, String tag, final Map<String, String> params, VolleyRequestListener listener) {
        MyApplication.getHttpQueue().cancelAll(tag);
        mRequest = new StringRequest(Request.Method.POST, url, listener.Success(), listener.Error()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        mRequest.setTag(tag);
        MyApplication.getHttpQueue().add(mRequest);
        MyApplication.getHttpQueue().start();
    }
}
