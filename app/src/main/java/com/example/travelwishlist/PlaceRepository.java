package com.example.travelwishlist;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;


// Manages the place data source

public class PlaceRepository {

    private PlaceDAO placeDAO;
    private LiveData<List<Place>> allPlaces;

    public PlaceRepository(Application application) {
        PlaceDatabase db = PlaceDatabase.getDatabase(application);
        placeDAO = db.placeDAO();
        allPlaces = placeDAO.getAllPlaces();
    }

    public LiveData<List<Place>> getAllPlaces() {
        return allPlaces;
    }

    public void insert(Place place){
        new InsertPlaceAsyncTask(placeDAO).execute(place);
    }

    public void delete(Place place) {
        new DeletePlaceAsyncTask(placeDAO).execute(place);
    }

    public void insert(Place... places) { new InsertPlaceAsyncTask(placeDAO).execute(places);
    }

    public void delete(Place... places) { new DeletePlaceAsyncTask(placeDAO).execute(places);
    }



    private static class InsertPlaceAsyncTask extends AsyncTask<Place, Void, Void> {
        private PlaceDAO asyncTaskDAO;

        InsertPlaceAsyncTask(PlaceDAO placeDAO) {
            this.asyncTaskDAO = placeDAO;
        }

        @Override
        protected Void doInBackground(Place... places) {
            asyncTaskDAO.insert(places);
            return null;
        }
    }

    private static class DeletePlaceAsyncTask extends AsyncTask<Place, Void, Void> {
        private PlaceDAO asyncTaskDAO;

        public DeletePlaceAsyncTask(PlaceDAO placeDAO) {
            this.asyncTaskDAO = placeDAO;
        }

        @Override
        protected Void doInBackground(Place... places) {
            asyncTaskDAO.delete(places);
            return null;
        }
    }


}
