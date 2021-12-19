package com.shyptsolution.medicinetracker.RoomDataBase

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Room

class NoteRepoditory(var noteDao:DAO) :BaseFragment(){
    var allNotes:LiveData<List<RoomEntity>> = DataBase(this).getDao().getAllNotes()
    var monday:LiveData<List<RoomEntity>> = DataBase(this).getDao().getmonday()
    var tuesday:LiveData<List<RoomEntity>> = DataBase(this).getDao().gettuesday()
    var wednesday:LiveData<List<RoomEntity>> = DataBase(this).getDao().getwednesday()
    var thursday:LiveData<List<RoomEntity>> = DataBase(this).getDao().getthurs()
    var friday:LiveData<List<RoomEntity>> = DataBase(this).getDao().getfriday()
    var saturday:LiveData<List<RoomEntity>> = DataBase(this).getDao().getsatur()
    var sunday:LiveData<List<RoomEntity>> = DataBase(this).getDao().getsunday()

    suspend fun insert(note:RoomEntity){
        noteDao.addNote(note)
    }
    suspend fun delete(note: RoomEntity){
        noteDao.deleteMed(note)
    }


}