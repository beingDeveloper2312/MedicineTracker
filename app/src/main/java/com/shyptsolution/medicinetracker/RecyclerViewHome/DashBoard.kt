package com.shyptsolution.medicinetracker.RecyclerViewHome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shyptsolution.medicinetracker.MainActivity
import com.shyptsolution.medicinetracker.R
import com.shyptsolution.medicinetracker.RoomDataBase.NoteViewModel
import com.shyptsolution.medicinetracker.RoomDataBase.RoomEntity

class DashBoard : AppCompatActivity(), HomeAdapter.NotesAdapter, DashBoardAdapter.dashboard {
   lateinit var recyclerView:RecyclerView
    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        recyclerView=findViewById(R.id.dashboardrecyclerview)
        var adapter=DashBoardAdapter(this,this)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=adapter
//        Toast.makeText(this,"Inside Dashboard",Toast.LENGTH_LONG).show()
        viewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
                var hashMap=HashMap<Int,Boolean>()
//                Toast.makeText(this,"Inside viewmoder",Toast.LENGTH_LONG).show()
//                Toast.makeText(this,"${it.size}",Toast.LENGTH_LONG).show()


//                Toast.makeText(this,"Size in Home "+it.size.toString(),Toast.LENGTH_LONG).show()
//                for (notes in it){
//                    if(!hashMap.containsKey(notes.id)){
//                        SaveData(this).SetAlarm(notes.hour,notes.minute,0,notes.medicineName)
//                        hashMap.set(notes.id,true)
//                    }
//
//                }


            }

        })

        val actionbar = supportActionBar
        actionbar!!.title = "DashBoard"
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater =menuInflater
        menuInflater.inflate(R.menu.dashboardmeny,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                Toast.makeText(this,"Back button clicked",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,MainActivity::class.java))
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onItemClicked(note: RoomEntity){
        viewModel.deleteNote(note)
    }

    override fun onItemEdited(note: RoomEntity) {
        TODO("Not yet implemented")
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}

