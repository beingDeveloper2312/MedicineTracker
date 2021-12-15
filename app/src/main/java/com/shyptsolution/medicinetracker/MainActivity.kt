package com.shyptsolution.medicinetracker

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.shyptsolution.medicinetracker.Login.Login
import com.shyptsolution.medicinetracker.add.AddNew

class MainActivity : AppCompatActivity() {
    private var backPressedTime=0L
    private var searchClicked=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onBackPressed() {
        if (searchClicked){
            super.onBackPressed()
            searchClicked=false
        }
         if(backPressedTime+2000>System.currentTimeMillis()){
            super.onBackPressed()
            finishAffinity()
        }
        else{
            Toast.makeText(this,"Press Back Again To Exit",Toast.LENGTH_SHORT).show()
        }
        backPressedTime=System.currentTimeMillis()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        menuInflater.inflate(R.menu.home_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!=null){
            when(item.itemId){
                R.id.addnew-> {
                    var intent = Intent(this, AddNew::class.java)
                    this.startActivity(intent)
                }
                R.id.app_bar_search->{
                    searchClicked=true
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }




}