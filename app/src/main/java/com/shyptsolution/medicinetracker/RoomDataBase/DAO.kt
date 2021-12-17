package com.shyptsolution.medicinetracker.RoomDataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAO {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun addNote(note:RoomEntity)

    @Query("SELECT * FROM medicine_table ")
    suspend  fun getAllNotes(): List<RoomEntity>

    @Insert
    suspend  fun addMultipleNotes(vararg note:RoomEntity)
}