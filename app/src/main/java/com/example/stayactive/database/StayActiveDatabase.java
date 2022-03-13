package com.example.stayactive.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.stayactive.database.dao.UserDao;
import com.example.stayactive.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class StayActiveDatabase extends RoomDatabase {

    /*
    Static because the class needs to be a singleton.
    Only one instance of the class is allowed.
     */
    private static StayActiveDatabase instance;

    /*
    Abstract method that returns the 'user' dao.
    Room will provide for the body.
     */
    public abstract UserDao userDao();

    /*
    Synchronized -> one thread at a time can access the instance.
    Used to avoid multiple instances of this class.
     */
    public static synchronized StayActiveDatabase getInstance(Context context) {
        if (instance == null) {
            /*
            Here we create a new instance using Rooms databasebuilder.
            Note: abstract class can't be instantiated.
             */
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    StayActiveDatabase.class,
                    "stayactive_db")
                    .fallbackToDestructiveMigration() // if version number incremented this will delete the db and create a new one
                    .build();
        }

        return instance;
    }
}
