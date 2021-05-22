package com.example.sampleroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Music {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="title")
    public String title;

    @ColumnInfo(name="Singer")
    public String singer;

    @ColumnInfo(name="play_time")
    public long playTime;

    @ColumnInfo(name="lyrics")
    public String lyrics;
}
