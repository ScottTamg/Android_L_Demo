package com.example.xwtang.android_l_demo;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by tang on 2015/9/20.
 */
public abstract class VolleyRequestListener {

    private Context mContext;
    public static Response.Listener mListener;
    public static Response.ErrorListener mErrorListener;

    public VolleyRequestListener(Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        this.mContext = context;
        this.mListener = listener;
        this.mErrorListener = errorListener;
    }

    public abstract void OnSuccess(Object response);
    public abstract void OnError(VolleyError error);

    public Response.Listener Success() {
        mListener = new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                //TODO 添加请求的效果
                OnSuccess(response);
            }
        };
        return mListener;
    }

    public Response.ErrorListener Error() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO 添加请求的效果
                OnError(error);
            }
        };
        return mErrorListener;
    }
}
