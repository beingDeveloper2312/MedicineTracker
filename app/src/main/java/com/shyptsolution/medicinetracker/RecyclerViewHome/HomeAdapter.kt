package com.shyptsolution.medicinetracker.RecyclerViewHome

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.shyptsolution.medicinetracker.MainActivity
import com.shyptsolution.medicinetracker.R
import com.shyptsolution.medicinetracker.RoomDataBase.*
import com.shyptsolution.medicinetracker.add.AddNew
import org.w3c.dom.Text
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class HomeAdapter(cont: Context, var listener:NotesAdapter):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
        var context=cont
    val ReminderList=ArrayList<RoomEntity>()
    class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var medicineName=itemView.findViewById<TextView>(R.id.MedName)
//        var medName=itemView.findViewById<TextView>(R.id.medicineNameinput)
        var dose=itemView.findViewById<TextView>(R.id.Dose)
        var stock=itemView.findViewById<TextView>(R.id.stockleft)
        var time=itemView.findViewById<TextView>(R.id.TimeAlloted)
        var deletebutton=itemView.findViewById<ImageView>(R.id.deletebutton)
        var editbutton=itemView.findViewById<ImageView>(R.id.editbutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewhome,parent,false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        var medname=ReminderList[position].medicineName


        holder.medicineName.setText(ReminderList[position].medicineName)
        holder.dose.setText(ReminderList[position].dose)
        holder.stock.setText(ReminderList[position].stock)

        holder.time.setText(ReminderList[position].time)

        holder.deletebutton.setOnClickListener {
//            Toast.makeText(context,"Deleted",Toast.LENGTH_SHORT).show()
            listener.onItemClicked(ReminderList[position])
            AlertDialog.Builder(context).apply {
                setTitle("Are You Sure?")
                setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->

                }
                setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->

                }
            }
        }

        holder.editbutton.setOnClickListener {
//            AddNew().updateData(ReminderList[position])
//            Toast.makeText(context,"Edited in View",Toast.LENGTH_LONG).show()

//            listener.onItemEdited(ReminderList[position])
        }
    }

    override fun getItemCount(): Int {
//        Toast.makeText(context,"Size in getItemCount "+ReminderList.size.toString(),Toast.LENGTH_LONG).show()
        return  ReminderList.size
    }

    fun updateList(newList:List<RoomEntity>){
        ReminderList.clear()
        ReminderList.addAll(newList)
        notifyDataSetChanged()
    }

    fun getDayName(day: Int): String? {
        when (day) {
            7 -> return "Sunday"
            1 -> return "Monday"
            2 -> return "Tuesday"
            3 -> return "Wednesday"
            4 -> return "Thursday"
            5 -> return "Friday"
            6 -> return "Saturday"
        }
        return "Worng Day"
    }





    interface NotesAdapter{
        fun onItemClicked(note:RoomEntity){

        }

        fun onItemEdited(note:RoomEntity){

        }
    }

}