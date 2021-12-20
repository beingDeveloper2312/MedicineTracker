package com.shyptsolution.medicinetracker.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.shyptsolution.medicinetracker.R

class SyncNow:DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var myView=inflater.inflate(R.layout.syncnow,container,false)
        var fetchnow=myView.findViewById<Button>(R.id.fetch)
        var savetocloud=myView.findViewById<Button>(R.id.savetocloud)



        return myView
    }
}