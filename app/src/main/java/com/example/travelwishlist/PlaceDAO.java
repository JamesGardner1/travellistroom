package com.example.travelwishlist;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlaceDAO {

    @Query("SELECT * FROM Place ORDER BY name DESC LIMIT: results")
    LiveData<List<Place>> getPlaces(int results);

    @Insert
    void insert(Place place);

    @Delete
    void delete(Place place);




}
