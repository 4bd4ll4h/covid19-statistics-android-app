package com.abd4ll4h.covid19hope;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface dao {

    @Query("SELECT * FROM status WHERE id IN (:ids)")
    LiveData<List<Status>>getSummary(String[] ids);

    @Insert(entity = Status.class,onConflict = OnConflictStrategy.REPLACE)
    void setSummary(List<Status> countries);

    @Query("DELETE  FROM status ")
    void deleteSummary();

    @Query("SELECT * FROM status WHERE id LIKE :id")
    Status getDashbord(String id);


}
