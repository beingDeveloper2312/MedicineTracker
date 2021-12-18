package com.shyptsolution.medicinetracker.RoomDataBase

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Room

class NoteRepoditory(var noteDao:DAO) :BaseFragment(){
    var allNotes:LiveData<List<RoomEntity>> = DataBase(this).getDao().getAllNotes()

    suspend fun insert(note:RoomEntity){
        noteDao.addNote(note)
    }
    suspend fun delete(note: RoomEntity){
        noteDao.deleteMed(note)
    }
}