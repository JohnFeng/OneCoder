package me.johnfeng.onecoder.utility;

import android.util.Log;

/**
 * Created by guangweifeng on 4/10/2014.
 */
public class LogUtils {
    private static boolean isEnable = false;

    public static void enable() {
        isEnable = true;
    }

    public static void disable() {
        isEnable = false;
    }

    public static int v(String tag, String msg) {
        return isEnable ? Log.v(tag, msg) : 0;
    }

    public static int w(String tag, String msg) {
        return isEnable ? Log.w(tag, msg) : 0;
    }

    public static int d(String tag, String msg) {
        return isEnable ? Log.d(tag, msg) : 0;
    }

    public static int e(String tag, String msg) {
        return isEnable ? Log.e(tag, msg) : 0;
    }

    public static int e(String tag, Throwable e) {
        return isEnable ? Log.e(tag, Log.getStackTraceString(e)) : 0;
    }
}
