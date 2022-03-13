package com.example.stayactive.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stayactive.model.Alert;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface AlertDao {
    /*
   Completable is an RxJava return type.
   Used when you don't expect a return.
    */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAlert(Alert alert);

    @Update
    Completable updateAlert(Alert alert);

    @Delete
    Completable deleteAlert(Alert alert);

    /*
    Single<T> is an RxJava return type.
    Single returns a single object.
     */
    @Query("SELECT * FROM alert WHERE alertId = :alertId")
    Single<Alert> getAlert(int alertId);

    /*
    Livedata is an Room return type.
    Livedata is used to update view when data is changed.
    Livedata is Lifecycle aware. Observable from RxJava is not Lifecycle aware.
     */
    @Query("SELECT * FROM alert")
    LiveData<List<Alert>> getAllAlerts();



}
