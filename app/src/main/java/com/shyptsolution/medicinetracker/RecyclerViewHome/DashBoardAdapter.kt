package com.shyptsolution.medicinetracker.RecyclerViewHome

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.shyptsolution.medicinetracker.R
import com.shyptsolution.medicinetracker.RoomDataBase.RoomEntity

class DashBoardAdapter (cont: Context, var listener: DashBoardAdapter.dashboard): RecyclerView.Adapter<DashBoardAdapter.HomeViewHolder>() {
    var context=cont
    val ReminderList=ArrayList<RoomEntity>()
    class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var medicineName=itemView.findViewById<TextView>(R.id.MedName)
        //        var medName=itemView.findViewById<TextView>(R.id.medicineNameinput)
        var dose=itemView.findViewById<TextView>(R.id.Dose)
        var stock=itemView.findViewById<TextView>(R.id.stockleft)
        var time=itemView.findViewById<TextView>(R.id.TimeAlloted)
        var deletebutton=itemView.findViewById<ImageView>(R.id.deletebutton)
        var editbutton=itemView.findViewById<ImageView>(R.id.editbutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewhome,parent,false)
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

            val builder = AlertDialog.Builder(context)
            //set title for alert dialog
            builder.setTitle("Are You Sure?")
            //set message for alert dialog
            builder.setMessage("Tap Yes To Delete This Reminder.")
            builder.setIcon(android.R.drawable.ic_delete)

            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->
//                Toast.makeText(context,"clicked yes",Toast.LENGTH_LONG).show()
                listener.onItemClicked(ReminderList[position])
            }
            //performing cancel action
//            builder.setNeutralButton("Cancel"){dialogInterface , which ->
//                Toast.makeText(context,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
//            }
            //performing negative action
            builder.setNegativeButton("No"){dialogInterface, which ->
//                Toast.makeText(context,"clicked No",Toast.LENGTH_LONG).show()
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
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
    interface dashboard{
        fun onItemClicked(note:RoomEntity){

        }

        fun onItemEdited(note:RoomEntity){

        }
    }

}


