package com.shyptsolution.medicinetracker.Alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.util.*
import kotlin.math.min

class SaveData {
    var context:Context?=null
    constructor(context: Context){
        this.context=context
    }
    fun SetAlarm(hour:Int, minute:Int,day:Int, MedName:String){
        val calender=Calendar.getInstance()
//        calender.set(Calendar.DAY_OF_WEEK,day)
        calender.set(Calendar.HOUR_OF_DAY,hour)
        calender.set(Calendar.MINUTE,minute)
        calender.set(Calendar.SECOND,0)
        calender.set(Calendar.MILLISECOND,0)
        var number=(hour+minute).toString()
        var am=context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intent= Intent(context,myBroadcastReceiver::class.java)
        intent.putExtra("Message","${MedName}")
        intent.putExtra("Number",number)

        intent.action=".Alarm"
        var pi=PendingIntent.getBroadcast(context,(0..2147483647).random(),intent,PendingIntent.FLAG_UPDATE_CURRENT)
//        am.setRepeating(AlarmManager.RTC_WAKEUP,calender.timeInMillis,AlarmManager.INTERVAL_DAY,pi)
        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,calender.timeInMillis,pi)
//        Toast.makeText(context,"Alarm Done in Save Data",Toast.LENGTH_LONG).show()
    }

//    fun SetSnooze(hour:Int, minute:Int){
//        val calender=Calendar.getInstance()
//        calender.set(Calendar.HOUR_OF_DAY,hour)
//        calender.set(Calendar.MINUTE,minute)
//        calender.set(Calendar.SECOND,0)
//        var am=context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        var intent= Intent(context,myBroadcastReceiver::class.java)
//        intent.putExtra("Message","alarm Time")
//        intent.action="Snooze"
//        var pi=PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
//        am.setRepeating(AlarmManager.RTC_WAKEUP,calender.timeInMillis,AlarmManager.INTERVAL_DAY,pi)
//        Toast.makeText(context,"Alarm Done in Save Data",Toast.LENGTH_LONG).show()
//    }

}