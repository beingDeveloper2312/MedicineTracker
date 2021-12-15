package com.shyptsolution.medicinetracker.add

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import com.shyptsolution.medicinetracker.R
import java.nio.channels.SelectableChannel

class AddNew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new)
        var button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            SelectTime()
        }
    }

    fun SelectTime(){
        var clocktime=findViewById<TimePicker>(R.id.timePicker)
        clocktime.visibility= View.VISIBLE
    }

}