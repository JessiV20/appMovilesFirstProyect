package com.example.myfirstapplication.data.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myfirstapplication.data.model.ServiceEntity

@Dao
interface ServiceDao {
    @Query("SELECT * FROM ServiceEntity")
    fun getAll(): List<ServiceEntity>

    @Query("SELECT * FROM ServiceEntity WHERE id=:ServiceId")
    fun show(ServiceId:Int):ServiceEntity


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(service: ServiceEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(Service:List<ServiceEntity>)

    @Delete
    fun delete (service:ServiceEntity)

    @Update
    fun update(service: ServiceEntity)

    @Query("SELECT MAX(id) FROM ServiceEntity")
    fun getMaxId(): Int

}