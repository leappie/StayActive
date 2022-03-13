package com.example.stayactive.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stayactive.model.User;

import io.reactivex.Completable;
import io.reactivex.Single;

/*
Interface class because room will generate the necessary code for it.
 */
@Dao
public interface UserDao {

    /*
    Completable is an RxJava return type.
    Used when you don't expect a return.
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    Completable insertUser(User user);

    @Update
    Completable updateUser(User user);

    @Delete
    Completable deleteUser(User user);

    /*
    Single<T> is an RxJava return type.
    Single returns a single object.
     */
    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    Single<User> getUser(String username, String password);


}
