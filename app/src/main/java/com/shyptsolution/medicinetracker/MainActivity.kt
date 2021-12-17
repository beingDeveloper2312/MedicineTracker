package com.shyptsolution.medicinetracker

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.transition.Slide
import android.transition.TransitionManager
import android.view.*
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.shyptsolution.medicinetracker.Login.Login
import com.shyptsolution.medicinetracker.RecyclerViewHome.DashBoardData
import com.shyptsolution.medicinetracker.RecyclerViewHome.HomeAdapter
import com.shyptsolution.medicinetracker.add.AddNew
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {
    private var backPressedTime=0L
    private var searchClicked=false
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var homeRecyclerView: RecyclerView
    lateinit var MedList:ArrayList<DashBoardData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var driver: DrawerLayout =findViewById(R.id.mainactivity)
        toggle= ActionBarDrawerToggle(this,driver,R.string.open,R.string.close)
        driver.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var floatingActionButton=findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            startActivity(Intent(this,AddNew::class.java))
        }
        MedList=ArrayList<DashBoardData>()
        MedList.add(DashBoardData("Helllo",34343))
        //Recycler View Implemantation
        homeRecyclerView=findViewById(R.id.recyclerview)
        homeRecyclerView.layoutManager=LinearLayoutManager(this)
        homeRecyclerView.setHasFixedSize(true)
        homeRecyclerView.adapter=HomeAdapter(MedList)
    }

    //BAck button close function
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
    //Adding option in menu
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater =menuInflater
//        menuInflater.inflate(R.menu.home_menu,menu)
//        return super.onCreateOptionsMenu(menu)
//    }
    //adding click function on navigation bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        if(item!=null){
            when(item.itemId){
                R.id.dashboard-> {
                    var intent = Intent(this, AddNew::class.java)
                    this.startActivity(intent)
                }
                R.id.medication->{
                    searchClicked=true
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }




}