package me.johnfeng.onecoder.controller;

import android.content.Context;

/**
 * Created by guangweifeng on 4/10/2014.
 */
public class AbstractController {
    protected Context mContext;

    public AbstractController(Context context) {
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }
}
