package com.shyptsolution.medicinetracker.RecyclerViewHome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.shyptsolution.medicinetracker.R
import com.shyptsolution.medicinetracker.RoomDataBase.RoomEntity
import org.w3c.dom.Text

class HomeAdapter(var ReminderList: List<RoomEntity>):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var medicineName=itemView.findViewById<TextView>(R.id.MedName)
//        var medName=itemView.findViewById<TextView>(R.id.medicineNameinput)
        var dose=itemView.findViewById<TextView>(R.id.Dose)
        var stock=itemView.findViewById<TextView>(R.id.stockleft)
        var time=itemView.findViewById<TextView>(R.id.TimeAlloted)
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
    }

    override fun getItemCount(): Int {
        return  ReminderList.size
    }
}