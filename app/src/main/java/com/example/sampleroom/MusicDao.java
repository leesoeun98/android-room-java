package com.example.sampleroom;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface MusicDao {
    @Query("SELECT * FROM music")
    List<Music> getAll();

    @Query("SELECT * FROM music WHERE id IN (:musicIds)")
    List<Music> loadAllByIds(int[] musicIds);

    @Insert
    void insertAll(Music... musics);

    @Delete
    void delete(Music music);
}
