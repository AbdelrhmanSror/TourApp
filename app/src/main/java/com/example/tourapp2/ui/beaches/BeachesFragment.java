package com.example.tourapp2.ui.beaches;

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
import com.example.tourapp2.databinding.BeachesFragmentBinding;
import com.example.tourapp2.ui.ListAdapter;

public class BeachesFragment extends Fragment {

    private BeachesViewModel mViewModel;
    BeachesFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=BeachesFragmentBinding.inflate(inflater);
        mViewModel= ViewModelProviders.of(this).get(BeachesViewModel.class);
        ListAdapter adapter=new ListAdapter(mViewModel.getBeaches(),new ListAdapter.onClickListener() {
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
        binding.beachesList.list.setAdapter(adapter);
        binding.beachesList.list.setHasFixedSize(true);
        return binding.getRoot();
    }

}
