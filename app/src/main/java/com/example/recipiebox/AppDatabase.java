package com.example.recipiebox;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.recipiebox.model.User;
import com.example.recipiebox.model.UserDao;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {


    private static final String DB_NAME = "ourdb";
    public abstract UserDao userDao();
    public static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context){

        if (appDatabase == null) {
            synchronized (AppDatabase.class){
                appDatabase = Room.databaseBuilder(context,AppDatabase.class,DB_NAME).allowMainThreadQueries().build();
            }
        }

        return appDatabase;
    }


}
