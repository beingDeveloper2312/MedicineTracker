package com.shyptsolution.medicinetracker.Alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.shyptsolution.medicinetracker.MainActivity
import com.shyptsolution.medicinetracker.RoomDataBase.DataBase
import com.shyptsolution.medicinetracker.RoomDataBase.NoteViewModel
import com.shyptsolution.medicinetracker.RoomDataBase.RoomEntity
import com.shyptsolution.medicinetracker.add.AddNew
import java.util.*

class myBroadcastReceiver:BroadcastReceiver() {
    var appDatabase: LiveData<List<RoomEntity>>? = null
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onReceive(context: Context, intent: Intent?) {
//        Toast.makeText(context,"Alarm Recived",Toast.LENGTH_LONG).show()

        if(intent!!.action.equals(".Alarm")){
            var bundle=intent.extras
            var number=intent.getStringExtra("Number")!!.toInt()
            val notifyme=Notification()
           var message= intent.getStringExtra("Message").toString()
            if(message==null){
                message=""
            }
                notifyme.Notify(context, message,getNumber())


//            Toast.makeText(context,"${number}",Toast.LENGTH_LONG).show()
        }
        else if(intent.action.equals("Snooze")){
            Toast.makeText(context," in snooze",Toast.LENGTH_LONG).show()
            val MainAct=SaveData(context)
            var message=intent.getStringExtra("MedName")
            if(Build.VERSION.SDK_INT>=23) {
                MainAct.SetAlarm(Calendar.HOUR_OF_DAY, Calendar.MINUTE+2,Calendar.DAY_OF_WEEK,"${message}")
            }
            var number=intent.getIntExtra("Number",0)
//            if(number==null){
//                number=0
//            }
            Notification().dismiss(context,number )
            Toast.makeText(context,"in snooze ${number}",Toast.LENGTH_LONG).show()
        }
//        else if(intent.action.equals("Snooze1")){
//            val MainAct=SaveData(context)
//            if(Build.VERSION.SDK_INT>=23) {
//                MainAct.SetAlarm(Calendar.HOUR_OF_DAY, Calendar.MINUTE+5,"")
//            }
//            Toast.makeText(context,"Snoozed for Five Minutes",Toast.LENGTH_LONG).show()
//        }
        else{
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        }
    }

    fun getNumber(): Int = (Date().time / 1000L % Integer.MAX_VALUE).toInt()

    private fun initiateDatabase(context: Context) {
        if (appDatabase== null)
            appDatabase =MainActivity().getAllNotes()


    }
}