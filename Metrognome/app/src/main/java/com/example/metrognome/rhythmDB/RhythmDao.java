package com.example.metrognome.rhythmDB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.metrognome.time.Rhythm;

import java.util.List;

@Dao
public interface RhythmDao {

    @Insert
    void insert(RhythmEntity rhythmEntity);

    @Query("DELETE FROM rhythm_table")
    void deleteAll();

    @Query("SELECT * from rhythm_table ORDER BY opened DESC")
    LiveData<List<RhythmEntity>> getAllRhythms();

    @Query("SELECT * from rhythm_table ORDER BY opened DESC LIMIT 3")
    LiveData<List<RhythmEntity>> getRecentRhythms();

    @Query("SELECT rhythm from rhythm_table WHERE ID = :id")
    Rhythm getRhythmById(int id);
}
