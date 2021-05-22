package com.example.sampleroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Music.class}, version = 1)
public abstract class MusicDB extends RoomDatabase {

    private static MusicDB INSTANCE = null;

    public abstract MusicDao musicDao();


    public static MusicDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    MusicDB.class, "music.db").build();

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
