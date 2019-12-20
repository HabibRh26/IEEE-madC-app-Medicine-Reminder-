package ieee.app.medRemind_prototype;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "myLoNotifications")
                .setContentTitle("Attention!")
                .setContentText("It's time for your medication,please confirm it")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true);

        NotificationManagerCompat compat = NotificationManagerCompat.from(context);

        compat.notify(200 /* ID of notification */, notificationBuilder.build());

    }


}
