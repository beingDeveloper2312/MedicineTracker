package com.shyptsolution.medicinetracker.Alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

class myBroadcastReceiver:BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onReceive(context: Context, intent: Intent?) {
        Toast.makeText(context,"Alarm Recived",Toast.LENGTH_LONG).show()

        if(intent!!.action.equals(".Alarm")){
            var bundle=intent.extras
            Toast.makeText(context,bundle?.getString("Message"),Toast.LENGTH_LONG).show()
            Toast.makeText(context,bundle?.getString("Message"),Toast.LENGTH_LONG).show()
            val notifyme=Notification()
            notifyme.Notify(context,"Hello",3)
        }
        else if(intent.action.equals("Snooze")){
            val notifyme=Notification()
            notifyme.Notify(context,"Snooze",3)
        }
        else{
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        }
    }
}