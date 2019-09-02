package com.example.tourapp2.ui.places;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.tourapp2.ListModel;
import com.example.tourapp2.R;

import java.util.ArrayList;
import java.util.List;

public class PlacesViewModel extends AndroidViewModel {
    private List<ListModel> places = new ArrayList<>();
    private Application application;

    public PlacesViewModel(Application application) {
        super(application);
        this.application=application;
        listOfPlaces();
    }

    private void listOfPlaces() {
        places.add(new ListModel(application.getString(R.string.Giza_Necropolis_uri)
                , application.getString(R.string.Giza_Necropolis)
                , application.getString(R.string.Giza_Necropolis_description)));
        places.add(new ListModel(application.getString(R.string.Karnak_uri)
                , application.getString(R.string.Karnak)
                , application.getString(R.string.Karnak_description)));
        places.add(new ListModel(application.getString(R.string.Red_Sea_Reef_uri)
                , application.getString(R.string.Red_Sea_Reef)
                , application.getString(R.string.Red_Sea_Reef_description)));
        places.add(new ListModel(application.getString(R.string.River_Nile_Cruise_uri)
                , application.getString(R.string.River_Nile_Cruise)
                , application.getString(R.string.River_Nile_Cruise)));

    }

    public List<ListModel> getPlaces() {
        return places;
    }
}
