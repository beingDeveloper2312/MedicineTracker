package com.shyptsolution.medicinetracker.add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.fragment.app.FragmentManager
import com.shyptsolution.medicinetracker.MainActivity
import com.shyptsolution.medicinetracker.R
import com.shyptsolution.medicinetracker.RecyclerViewHome.HomeAdapter
import com.shyptsolution.medicinetracker.RoomDataBase.BaseFragment
import com.shyptsolution.medicinetracker.RoomDataBase.DataBase
import com.shyptsolution.medicinetracker.RoomDataBase.RoomEntity
import kotlinx.coroutines.launch

class AddNew : BaseFragment() {
    lateinit var adapter:HomeAdapter
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



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater =menuInflater
        menuInflater.inflate(R.menu.addnewmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!=null){
            when(item.itemId){
                R.id.addtask-> {
                    var medName=findViewById<EditText>(R.id.medicineNameinput)
                    var dose=findViewById<EditText>(R.id.doseinput)
                    var stock=findViewById<EditText>(R.id.stockinput)
                    var time=findViewById<TextView>(R.id.time)
                    var mon=findViewById<CheckBox>(R.id.mon)
                    var tue=findViewById<CheckBox>(R.id.tus)
                    var wed=findViewById<CheckBox>(R.id.wed)
                    var thu=findViewById<CheckBox>(R.id.thu)
                    var fri=findViewById<CheckBox>(R.id.fri)
                    var sat=findViewById<CheckBox>(R.id.sat)
                    var sun=findViewById<CheckBox>(R.id.sun)
                    if(medName.text.toString().isEmpty()){
                        medName.error="Medicine Name Required"
                        medName.requestFocus()
                    }
                    else{
                        var medicine=RoomEntity(medName.text.toString(),time.text.toString(),dose.text.toString(),stock.text.toString(),mon.isChecked,tue.isChecked,wed.isChecked,thu.isChecked,
                            fri.isChecked,sat.isChecked,sun.isChecked)



                        launch {
                            this@AddNew.let {
                                DataBase(this@AddNew).getDao().addNote(medicine)
//                Toast.makeText(it,"Saved to database",Toast.LENGTH_LONG).show()
                            }
                        }
                        startActivity(Intent(this,MainActivity::class.java))
                    }


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