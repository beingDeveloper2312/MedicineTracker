package com.shyptsolution.medicinetracker.RoomDataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {
    lateinit var allNotes:LiveData<List<RoomEntity>>
   lateinit var repository:NoteRepoditory
   var context=application.applicationContext
    init {
        val dao=DataBase(application.applicationContext).getDao()
        repository=NoteRepoditory(dao)
        allNotes=repository.allNotes

    }

    fun deleteNote(note:RoomEntity)=viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    fun insertNote(note:RoomEntity)=viewModelScope.launch (Dispatchers.IO){
        repository.insert(note)
    }
    fun updateNote(note:RoomEntity)=viewModelScope.launch {
        DataBase(context).getDao().updateMed(note)
    }

}