package com.example.stayactive.repository;

import android.app.Application;

import com.example.stayactive.database.StayActiveDatabase;

public class UserRepository {
    private StayActiveDatabase stayActiveDatabase;

    public UserRepository(Application application) {
        this.stayActiveDatabase = StayActiveDatabase.getInstance(application);
    }

}
