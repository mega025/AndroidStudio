package com.mega025.palabraroom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PalabraDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Palabra palabra);

    @Query("DELETE FROM tabla_palabra")
    void deleteAll();

    @Query("SELECT * FROM  tabla_palabra ORDER BY palabra ASC")
    LiveData<List<Palabra>> getPalabrasOrdenadas();

}
