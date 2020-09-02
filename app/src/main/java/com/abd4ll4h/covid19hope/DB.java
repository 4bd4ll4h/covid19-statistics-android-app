package com.abd4ll4h.covid19hope;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities ={Status.class, Global.class},version = 1)
public abstract class DB extends RoomDatabase {


    private static DB Instance;
    private static Context contex;

    public static synchronized DB getInstance(Context context) {
        contex=context;
        if (Instance == null) {
            Instance = Room.databaseBuilder(context.getApplicationContext(),
                    DB.class,
                    "Covid19Hope_db").fallbackToDestructiveMigration()
                    .build();

        }
        return Instance;

    }

    public abstract dao dao();
}
