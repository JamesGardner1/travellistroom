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

    @Query("SELECT * FROM Place ORDER BY name")
    LiveData<List<Place>> getAllPlaces();

    @Insert
    void insert(Place place);

    @Delete
    void delete(Place place);

    // Insert in array of Places
    @Insert
    void insert(Place... places);

    //Delete in array of Places
    @Delete
    void delete(Place... places);




}
