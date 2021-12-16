package com.shyptsolution.medicinetracker.add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.FragmentManager
import com.shyptsolution.medicinetracker.MainActivity
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        menuInflater.inflate(R.menu.addnewmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!=null){
            when(item.itemId){
                R.id.addtask-> {

                }
                R.id.cancel->{
                    var intent = Intent(this, MainActivity::class.java)
                    this.startActivity(intent)

                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

}