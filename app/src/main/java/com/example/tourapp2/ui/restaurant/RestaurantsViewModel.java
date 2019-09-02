package com.example.tourapp2.ui.restaurant;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.tourapp2.ListModel;
import com.example.tourapp2.R;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsViewModel extends AndroidViewModel {
    private List<ListModel> restaurants = new ArrayList<>();
    private Application application;
    public RestaurantsViewModel(Application application) {
        super(application);
        this.application=application;
        listOfRestaurants();
    }

    private void listOfRestaurants() {
        restaurants.add(new ListModel(application.getString(R.string.Lai_Thai_uri)
                , application.getString(R.string.Lai_Thai)
                , application.getString(R.string.lai_Thai_description)));
        restaurants.add(new ListModel(application.getString(R.string.Aqua_uri)
                , application.getString(R.string.Aqua)
                , application.getString(R.string.Aqua_description)));
        restaurants.add(new ListModel(application.getString(R.string.About_el_Sid_uri)
                , application.getString(R.string.About_el_Sid)
                , application.getString(R.string.About_el_Sid_description)));
        restaurants.add(new ListModel(application.getString(R.string.po_signature_uri)
                , application.getString(R.string.po_signature)
                , application.getString(R.string.po_signature_description)));
    }



    public List<ListModel> getRestaurants() {
        return restaurants;
    }
}
