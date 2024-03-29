package com.example.travelwishlist;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = { Place.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class PlaceDatabase extends RoomDatabase {

    private static volatile PlaceDatabase INSTANCE;

    public abstract PlaceDAO placeDAO();

    static PlaceDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PlaceDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PlaceDatabase.class,
                             "Place").fallbackToDestructiveMigration().build();

                }
            }
        }
        return INSTANCE;

    }
}
