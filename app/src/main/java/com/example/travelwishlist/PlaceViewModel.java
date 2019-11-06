package com.example.travelwishlist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PlaceViewModel extends AndroidViewModel {

    private PlaceRepository mPlaceRepository;
    private LiveData<List<Place>> mPlaces;

    public PlaceViewModel(@NonNull Application application) {
        super(application);
        mPlaceRepository = new PlaceRepository(application);
        mPlaces = mPlaceRepository.getPlaces();
    }

    public LiveData<List<Place>> getPlaces() {
        return mPlaces;
    }

    public void insert(Place place) {
        mPlaceRepository.insert(place);
    }

    public void delete(Place place) {
        mPlaceRepository.delete(place);
    }



}
