package com.example.stayactive.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stayactive.model.Data;
import com.example.stayactive.model.Exercise;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ExerciseDao {
    /*
    Completable is an RxJava return type.
    Used when you don't expect a return.
    */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertExercise(Exercise Exercise);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAllExercises(Exercise... exercises);

    @Update
    Completable updateExercise(Exercise exercise);

    @Delete
    Completable deleteExercise(Exercise exercise);

    /*
    Select based on difficulty
     */
    @Query("SELECT * FROM exercise WHERE difficultyLevel = :difficultyLevel")
    Single<Data> getExerciseOnDifficulty(int difficultyLevel);

    /*
    Livedata is an Room return type.
    Livedata is used to update view when data is changed.
    Livedata is Lifecycle aware. Observable from RxJava is not Lifecycle aware.
     */
    @Query("SELECT * FROM exercise")
    LiveData<List<Data>> getAllExercises();
}
