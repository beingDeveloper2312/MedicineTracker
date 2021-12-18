package com.shyptsolution.medicinetracker.RoomDataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAO {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun addNote(note:RoomEntity)

    @Query("SELECT * FROM medicine_table ")
      fun getAllNotes(): LiveData<List<RoomEntity>>

    @Insert
    suspend  fun addMultipleNotes(vararg note:RoomEntity)

    @Update
    suspend fun updateMed(note:RoomEntity)

    @Delete
     fun deleteMed(note:RoomEntity)
}