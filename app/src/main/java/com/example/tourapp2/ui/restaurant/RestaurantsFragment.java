package com.example.tourapp2.ui.restaurant;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tourapp2.InfoActivity;
import com.example.tourapp2.databinding.RestaurantsFragmentBinding;
import com.example.tourapp2.ui.ListAdapter;

public class RestaurantsFragment extends Fragment {

    private RestaurantsViewModel mViewModel;
    RestaurantsFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=RestaurantsFragmentBinding.inflate(inflater);
        mViewModel= ViewModelProviders.of(this).get(RestaurantsViewModel.class);
        ListAdapter adapter=new ListAdapter(mViewModel.getRestaurants(), (imageView, listModel) -> {
            Intent intent = new Intent(getActivity(), InfoActivity.class);
            intent.putExtra("item",listModel);
            // create the transition animation - the images in the layouts
            ActivityOptions options ;
            //if the api is 21 or higher we apply explode transition
            //if not we start activity with default startup
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                options = ActivityOptions
                        .makeSceneTransitionAnimation(getActivity(), imageView, imageView.getTransitionName());
                // start the new activity
                startActivity(intent, options.toBundle());
            }
            else {
                startActivity(intent);
            }

        });
        //using data binding set an adapter for recycler view
        binding.hotelList.list.setAdapter(adapter);
        //declare that recycler view has fixed size for best performance
        binding.hotelList.list.setHasFixedSize(true);
        return binding.getRoot();
    }




}
