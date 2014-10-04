package me.johnfeng.onecoder;

import android.app.Application;
import android.os.Build;

import de.greenrobot.event.EventBus;
import me.johnfeng.onecoder.utility.LogUtils;


public class OneCoderApplication extends Application {

    public static final String TAG = OneCoderApplication.class.getSimpleName();

    private EventBus mBus;

    @Override
    public void onCreate() {
        super.onCreate();

        initLogUtils();
        initEventBus();
    }

    private void initLogUtils() {
        if (BuildConfig.DEBUG) {
            LogUtils.enable();
            LogUtils.d(TAG, "Device Info: model=" + Build.MODEL);
            LogUtils.d(TAG, "Device Info: brand=" + Build.BRAND);
            LogUtils.d(TAG, "Device Info: device=" + Build.DEVICE);
            LogUtils.d(TAG, "Device Info: board=" + Build.BOARD);
            LogUtils.d(TAG, "Device Info: product=" + Build.PRODUCT);
            LogUtils.d(TAG, "Device Info: manufacturer=" + Build.MANUFACTURER);
            LogUtils.d(TAG, "Device Info: fingerprint=" + Build.FINGERPRINT);
        } else {
            LogUtils.disable();
        }
    }

    private void initEventBus() {
        mBus = new EventBus();
        mBus.register(this);
    }
}
