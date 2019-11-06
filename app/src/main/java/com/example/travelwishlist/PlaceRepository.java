package com.example.travelwishlist;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlaceRepository {

    private PlaceDAO mPlaceDAO;

    public PlaceRepository(Application application) {
        PlaceDatabase db = PlaceDatabase.getDatabase(application);
        mPlaceDAO = db.placeDAO();
    }

    public LiveData<List<Place>> getPlaces(int results) {
        return mPlaceDAO.getPlaces(results);
    }

    public void insert(Place place){
        new InsertPlaceAsyncTask(mPlaceDAO).execute(place);
    }

    public void delete(Place place) {
        new DeletePlaceAsyncTask(mPlaceDAO).execute(place);
    }


    private static class InsertPlaceAsyncTask extends AsyncTask<Place, Void, Void> {
        PlaceDAO dao;

        public InsertPlaceAsyncTask(PlaceDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Place... places) {
            dao.insert(places[0]);
            return null;
        }
    }

    private static class DeletePlaceAsyncTask extends AsyncTask<Place, Void, Void> {
        PlaceDAO dao;

        public DeletePlaceAsyncTask(PlaceDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Place... places) {
            dao.delete(places[0]);
            return null;
        }
    }


}
