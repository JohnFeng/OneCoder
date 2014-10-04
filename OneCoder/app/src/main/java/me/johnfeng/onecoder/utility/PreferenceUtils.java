package me.johnfeng.onecoder.utility;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by guangweifeng on 4/10/2014.
 */
public class PreferenceUtils {

    private static final String PREF_NAME = "channel_pref";
    private static final String DOUBAN_CHANNEL = "channel_douban";
    private static final String UMENG_CHANNEL = "umeng_channel";
    private static final String LAST_SELECT_DOULIST = "last_select_doulist";

    public static String getUmengChannel(Context context) {
        if (null == context) {
            return "";
        }
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(UMENG_CHANNEL, "");
    }

    public static void setUmengChannel(Context context, String umengChannel) {
        if (TextUtils.isEmpty(umengChannel) || null == context) {
            return;
        }
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putString(UMENG_CHANNEL, umengChannel).commit();
    }

    public static String getDoubanChannel(Context context) {
        if (null == context) {
            return "";
        }
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(DOUBAN_CHANNEL, "");
    }

    public static void setDoubanChannel(Context context, String doubanChannel) {
        if (TextUtils.isEmpty(doubanChannel) || null == context) {
            return;
        }
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putString(DOUBAN_CHANNEL, doubanChannel).commit();
    }

    public static String getLastSelectDoulist(Context context) {
        if (null == context) {
            return "";
        }
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(LAST_SELECT_DOULIST, "");
    }

    public static void setLastSelectDoulist(Context context, String lastSelectedDoulistId) {
        if (TextUtils.isEmpty(lastSelectedDoulistId) || null == context) {
            return;
        }
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putString(LAST_SELECT_DOULIST, lastSelectedDoulistId).commit();
    }
}
