package me.johnfeng.onecoder.controller;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import me.johnfeng.onecoder.R;
import me.johnfeng.onecoder.utility.Constants;

/**
 * Created by guangweifeng on 4/10/2014.
 */
public class NotificationController extends AbstractController {
    private final NotificationManager mNotificationManager;
    private int mNotificationId = 0;
    Intent[] notificationIntents = null;
    private static final int LED_ON_MS = 2500;
    private static final int LED_OFF_MS = 3500;

    public NotificationController(Context context) {
        super(context);
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationIntents = new Intent[2];
    }

    public void showNotification(Notification notification) {
        mNotificationManager.notify(++mNotificationId, notification);
    }

    private Notification buildNotification(String title, Intent intent) {

        PendingIntent pendingIntent = null;
        if (null == notificationIntents || notificationIntents.length == 0) {
            pendingIntent = PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        } else {
            pendingIntent = PendingIntent.getActivities(mContext, 0, notificationIntents, PendingIntent.FLAG_UPDATE_CURRENT);
        }
        Bitmap launcherIcon = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ic_launcher);

        Notification notification = new NotificationCompat.Builder(mContext)
                .setContentTitle(mContext.getString(R.string.app_name))
                .setContentText(title)
                .setSmallIcon(R.drawable.logo)
                .setLargeIcon(launcherIcon)
                .setContentIntent(pendingIntent)
                .build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        notification.tickerText = title;
        notification.ledARGB = Constants.COLOR_DONGXI_RED;
        notification.ledOnMS = LED_ON_MS;
        notification.ledOffMS = LED_OFF_MS;

        return notification;
    }
}
