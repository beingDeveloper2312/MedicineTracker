package com.shyptsolution.medicinetracker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.shyptsolution.medicinetracker.Alarm.Notification
import com.shyptsolution.medicinetracker.Alarm.SaveData
import com.shyptsolution.medicinetracker.Login.Login
import com.shyptsolution.medicinetracker.RecyclerViewHome.DashBoardData
import com.shyptsolution.medicinetracker.RecyclerViewHome.HomeAdapter
import com.shyptsolution.medicinetracker.RoomDataBase.BaseFragment
import com.shyptsolution.medicinetracker.RoomDataBase.DataBase
import com.shyptsolution.medicinetracker.RoomDataBase.NoteViewModel
import com.shyptsolution.medicinetracker.RoomDataBase.RoomEntity
import com.shyptsolution.medicinetracker.add.AddNew
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalStateException

class MainActivity : BaseFragment(), HomeAdapter.NotesAdapter {
    private lateinit var auth: FirebaseAuth
    private lateinit var googleAuth: GoogleSignInClient
    private var backPressedTime=0L
    private var searchClicked=false
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var homeRecyclerView: RecyclerView
    lateinit var MedList:ArrayList<DashBoardData>
    lateinit var viewModel: NoteViewModel
    @RequiresApi(Build.VERSION_CODES.P)
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
        //Recycler View Implemantation
        homeRecyclerView=findViewById(R.id.recyclerview)

//        launch {
//            val newnote=DataBase(this@MainActivity).getDao().getAllNotes()
////            Toast.makeText(this@MainActivity, "note list size "+newnote.size.toString(),Toast.LENGTH_SHORT).show()
//
//
//        }
        homeRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
        homeRecyclerView.setHasFixedSize(true)
        var adapter=HomeAdapter(this,this)
        homeRecyclerView.adapter=adapter
       viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.todayNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
//                Toast.makeText(this,"Size in Home "+it.size.toString(),Toast.LENGTH_LONG).show()
                for (notes in it){
                    SaveData(this).SetAlarm(notes.hour,notes.minute,0,notes.medicineName)
                }


            }

        })

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(getString(R.string.clientid))
            .requestProfile()
            .build()

        googleAuth=GoogleSignIn.getClient(this,gso)
        auth= FirebaseAuth.getInstance()
        var navigationView=findViewById<NavigationView>(R.id.navmenu)
        var navheader=navigationView.getHeaderView(0)
        var email=navheader.findViewById<TextView>(R.id.emailid)
        var username=navheader.findViewById<TextView>(R.id.name)
        var userPhoto=navheader.findViewById<ImageView>(R.id.userimage)
        email.setText(auth.currentUser!!.email)
        username.setText(auth.currentUser!!.displayName)
        Picasso.get().load(auth.currentUser!!.photoUrl).into(userPhoto)
        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.logout->{
                    Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show()
                    googleAuth.signOut()
                    googleAuth.revokeAccess()
                    auth.signOut()
                    startActivity(Intent(this,Login::class.java))
                }

                R.id.exitapp->{
                    finishAffinity()
                }

                R.id.medication->{

                }
                R.id.dashboard->{

                }
                R.id.buymedicine->{

                }
                R.id.sync->{

                }


                else -> throw IllegalStateException("Unexpected value: " + item.itemId)
            }
            true
        })
        createNotificationChannel()



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

//        if(item!=null){
//            when(item.itemId){
//                R.id.dashboard-> {
//                    var intent = Intent(this, AddNew::class.java)
//                    this.startActivity(intent)
//                }
//                R.id.medication->{
//                    searchClicked=true
//                }
//                R.id.logout->{
//
//                }
//            }
//        }

        return super.onOptionsItemSelected(item)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("RaunitVerma", name, importance).apply {
                description = descriptionText
            }
            channel.enableLights(true)
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }



    override fun onItemClicked(note:RoomEntity){
        viewModel.deleteNote(note)
    }

    override fun onItemEdited(note: RoomEntity) {
        AddNew().onItemEdit(note)
//        viewModel.deleteNote(note)
        super.onItemEdited(note)
    }

    fun getAllNotes():LiveData<List<RoomEntity>>{
        return viewModel.allNotes
    }


}