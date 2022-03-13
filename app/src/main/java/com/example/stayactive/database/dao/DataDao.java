package com.example.stayactive.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stayactive.model.Data;

import java.util.Date;
import java.util.List;

import io.reactivex.Completable;

@Dao
public interface DataDao {
    /*
    Completable is an RxJava return type.
    Used when you don't expect a return.
    */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertData(Data data);

    @Update
    Completable updateData(Data data);

    @Delete
    Completable deleteData(Data data);

    /*
    Select based on date
     */
    @Query("SELECT * FROM data WHERE exerciseDate = :exerciseDate")
    LiveData<List<Data>> getData(Date exerciseDate);

    /*
    Livedata is an Room return type.
    Livedata is used to update view when data is changed.
    Livedata is Lifecycle aware. Observable from RxJava is not Lifecycle aware.
     */
    @Query("SELECT * FROM data")
    LiveData<List<Data>> getAllData();
}
