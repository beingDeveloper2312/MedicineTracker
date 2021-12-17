package com.shyptsolution.medicinetracker.RecyclerViewHome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.shyptsolution.medicinetracker.R

class HomeAdapter(var ReminderList:ArrayList<DashBoardData>):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var medicineName=itemView.findViewById<TextView>(R.id.textView5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewhome,parent,false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        var medname=ReminderList[position].medicineName
        holder.medicineName.setText(medname)
    }

    override fun getItemCount(): Int {
        return  ReminderList.size
    }
}