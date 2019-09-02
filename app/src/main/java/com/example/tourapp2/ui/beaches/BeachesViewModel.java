package com.example.tourapp2.ui.beaches;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.tourapp2.ListModel;
import com.example.tourapp2.R;

import java.util.ArrayList;
import java.util.List;

public class BeachesViewModel extends AndroidViewModel {
    private List<ListModel> beaches = new ArrayList<>();
    private Application application;

    public BeachesViewModel(Application application) {
        super(application);
        this.application=application;
        listOfBeaches();
    }

    private void listOfBeaches() {
        beaches.add(new ListModel(application.getString(R.string.Fjord_Bay_uri)
                , application.getString(R.string.Fjord_Bay)
                , application.getString(R.string.Fjord_Bay_description)));
        beaches.add(new ListModel(application.getString(R.string.Ras_Abu_Galoum_uri)
                , application.getString(R.string.Ras_Abu_Galoum)
                , application.getString(R.string.Ras_Abu_Galoum_description)));
        beaches.add(new ListModel(application.getString(R.string.Nuweiba_uri)
                , application.getString(R.string.Nuweiba)
                , application.getString(R.string.Nuweiba_description)));
        beaches.add(new ListModel(application.getString(R.string.Mahmya_Island_uri)
                        ,application.getString(R.string.Mahmya_Island)
                ,application.getString(R.string.Mahmya_Island_description)));
    }


    public List<ListModel> getBeaches() {
        return beaches;
    }
}
