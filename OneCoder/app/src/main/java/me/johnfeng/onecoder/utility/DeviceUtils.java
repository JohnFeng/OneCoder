package me.johnfeng.onecoder.utility;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by guangweifeng on 4/10/2014.
 */
public class DeviceUtils {
    private static final String TAG = DeviceUtils.class.getName();
    private static final String XIAOMI_PAD_CHANNEL = "Xiaomi_Market";

    public static int getAndroidSDKVersion() {
        int version = 0;
        try {
            version = Integer.valueOf(android.os.Build.VERSION.SDK_INT);
        } catch (NumberFormatException e) {
        }
        return version;
    }

    public static void hideKeyboard(Context context, EditText editText) {
        if (context == null || editText == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static String getAppVersion(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "unknown";
        }
    }

    public static String getAppPackageName(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            return "unknown";
        }
    }

    public static String getMobileVersion() {
        String mode = Build.MODEL;
        String release = Build.VERSION.RELEASE;
        return mode + "," + release;
    }

    private static String mPackageChannel;

    public static String getPackageChannel(Context context) {
        if (mPackageChannel != null) {
            return mPackageChannel;
        }

        String channel = PreferenceUtils.getDoubanChannel(context);
        if (!TextUtils.isEmpty(channel)) {
            mPackageChannel = channel;
            return mPackageChannel;
        }
        PackageManager manager = context.getPackageManager();
        ApplicationInfo info;
        try {
            info = manager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e(TAG, e);
            return "";
        }
        Bundle bundle = info.metaData;
        mPackageChannel = bundle.getString("Douban_Channel");
        PreferenceUtils.setDoubanChannel(context, mPackageChannel);
        return mPackageChannel;
    }

    public static String getUmengChannel(Context context) {
        String channel = PreferenceUtils.getUmengChannel(context);
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        PackageManager manager = context.getPackageManager();
        ApplicationInfo info;
        try {
            info = manager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e(TAG, e);
            return "";
        }
        Bundle bundle = info.metaData;
        String umengChannel = bundle.getString("UMENG_CHANNEL");
        PreferenceUtils.setUmengChannel(context, umengChannel);
        return umengChannel;
    }

    public static boolean isXiaomiPad(Context context, String channel) {
        return XIAOMI_PAD_CHANNEL.equals(channel) && DeviceUtils.getAppPackageName(context).indexOf("hd")>=0;
    }
}
