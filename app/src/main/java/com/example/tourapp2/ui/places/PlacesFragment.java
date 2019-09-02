package com.example.tourapp2.ui.places;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tourapp2.InfoActivity;
import com.example.tourapp2.ListModel;
import com.example.tourapp2.databinding.PlacesFragmentBinding;
import com.example.tourapp2.ui.ListAdapter;

public class PlacesFragment extends Fragment {

    private PlacesViewModel mViewModel;
    PlacesFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=PlacesFragmentBinding.inflate(inflater);
        mViewModel= ViewModelProviders.of(this).get(PlacesViewModel.class);
        ListAdapter adapter=new ListAdapter(mViewModel.getPlaces(),new ListAdapter.onClickListener() {
            @Override
            public void onClick(ImageView imageView, ListModel listModel) {
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                intent.putExtra("item",listModel);
                // create the transition animation - the images in the layouts
                // of both activities are defined with android:transitionName="robot"
                ActivityOptions options = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions
                            .makeSceneTransitionAnimation(getActivity(), imageView, imageView.getTransitionName());
                    // start the new activity
                    startActivity(intent, options.toBundle());
                }
                else {
                    startActivity(intent);
                }
            }
        });
        binding.placesList.list.setAdapter(adapter);
        binding.placesList.list.setHasFixedSize(true);
        return binding.getRoot();
    }



}
