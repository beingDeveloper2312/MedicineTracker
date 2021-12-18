package com.shyptsolution.medicinetracker.Alarm

import android.app.Notification
import android.app.Notification.DEFAULT_ALL
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.app.NotificationManager.IMPORTANCE_MAX
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.DEFAULT_ALL
import androidx.core.app.NotificationCompat.EXTRA_NOTIFICATION_ID
import androidx.core.app.NotificationManagerCompat
import com.shyptsolution.medicinetracker.MainActivity
import com.shyptsolution.medicinetracker.R
import com.shyptsolution.medicinetracker.add.AddNew
import com.shyptsolution.medicinetracker.add.PopUpTime

class Notification {
    val NOTIFIYTAG="new request"
    @RequiresApi(Build.VERSION_CODES.P)
    fun Notify(context: Context, message:String, number:Int){
        val snoozeIntent = Intent(context, myBroadcastReceiver::class.java).apply {
            action =".Alarm"
            putExtra(EXTRA_NOTIFICATION_ID, 0)
        }
        val snoozePendingIntent: PendingIntent =
            PendingIntent.getBroadcast(context, 0, snoozeIntent, 0)
        val intent = Intent(context, MainActivity::class.java).apply {
            var flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val fullScreenIntent = Intent(context, PopUpTime::class.java)
        val fullScreenPendingIntent = PendingIntent.getActivity(context, 0,
            fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder= NotificationCompat.Builder(context,"RaunitVerma")
//            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContentTitle("New request")
            .setContentText(message).setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
            .setNumber(number)
            .setSmallIcon(R.drawable.notification_icon_background)
//            .setContentIntent(
//                PendingIntent.getActivity(context
//                ,0,intent,PendingIntent.FLAG_UPDATE_CURRENT))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setCategory(NotificationCompat.CATEGORY_CALL)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .addAction(R.drawable.ic_baseline_add_24, "Snooze)",
                snoozePendingIntent)
//            .setFullScreenIntent(fullScreenPendingIntent, true)


//        var builder = NotificationCompat.Builder(context,"RaunitVerma")
//            .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
//            .setContentTitle("textTitle")
//            .setContentText("textContent")
//            .setPriority(NotificationCompat.PRIORITY_MAX)

        val nm=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ECLAIR) {
            nm.notify(NOTIFIYTAG, 0, builder.build())
//            Toast.makeText(context,"In first", Toast.LENGTH_LONG).show()

        }else{
            nm.notify(NOTIFIYTAG.hashCode(), builder.build())
//            Toast.makeText(context,"In second",Toast.LENGTH_LONG).show()

        }


    }

}