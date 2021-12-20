package com.shyptsolution.medicinetracker.add

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.shyptsolution.medicinetracker.MainActivity
import com.shyptsolution.medicinetracker.R

class PopUpTime:DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.popuptime,container,false)
        var setTime=view.findViewById(R.id.setTime) as Button
        var timepicker=view.findViewById(R.id.timePicker) as TimePicker
        setTime.setOnClickListener {

            val MainAct=activity as AddNew
            if(Build.VERSION.SDK_INT>=23) {
//                MainAct.setTime(timepicker.hour, timepicker.minute)
            }
            this.dismiss()
            }
        return view
    }



}