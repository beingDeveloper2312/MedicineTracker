package com.shyptsolution.medicinetracker.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.FragmentManager
import com.shyptsolution.medicinetracker.R

class AddNew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new)
        var button=findViewById<Button>(R.id.settime)
        button.setOnClickListener {
            selectTime()
        }
    }

    private fun selectTime() {
        val popTime=PopUpTime()
        var fgm=supportFragmentManager
        popTime.show(fgm,"fdsf")
    }

    fun setTime(Hours:Int,Minutes:Int){
        var time=findViewById<TextView>(R.id.time)
        if(Minutes==0 && Hours==0){
            time.setText("00:00")

        }
       else if (Hours==0){
            time.setText("00"+":"+Minutes.toString())

        }
        else if(Minutes==0){
            time.setText(Hours.toString()+":00")

        }

        else{
            time.setText(Hours.toString()+":"+Minutes.toString())

        }
    }

}