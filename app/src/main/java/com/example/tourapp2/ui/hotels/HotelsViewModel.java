package com.example.tourapp2.ui.hotels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.tourapp2.ListModel;
import com.example.tourapp2.R;

import java.util.ArrayList;
import java.util.List;

public class HotelsViewModel extends AndroidViewModel {
    private List<ListModel> hotels = new ArrayList<>();
    private Application application;

    public HotelsViewModel(Application application) {
        super(application);
        this.application=application;
        listOfHotels();
    }

    private void listOfHotels() {
        hotels.add(new ListModel(application.getString(R.string.La_Villa_Boutique_Hotel_uri)
                , application.getString(R.string.La_Villa_Boutique_Hotel)
                , application.getString(R.string.La_Villa_Boutique_Hotel_description)));
        hotels.add(new ListModel(application.getString(R.string.El_Salamlek_Palace_Hotel_uri)
                , application.getString(R.string.El_Salamlek_Palace_Hotel)
                , application.getString(R.string.El_Salamlek_Palace_Hotel_description)));
        hotels.add(new ListModel(application.getString(R.string.Adrère_Amellal_Desert_Ecolodge_uri)
                , application.getString(R.string.Adrère_Amellal_Desert_Ecolodge)
                , application.getString(R.string.Adrère_Amellal_Desert_Ecolodge_description)));
        hotels.add(new ListModel(application.getString(R.string.Le_Riad_Hôtel_de_Charme_uri)
                , application.getString(R.string.Le_Riad_Hôtel_de_Charme)
                , application.getString(R.string.Le_Riad_Hôtel_de_Charme_description)));

    }

    public List<ListModel> getHotels() {
        return hotels;
    }
}
