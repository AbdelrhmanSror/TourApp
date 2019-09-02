package com.example.tourapp2.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourapp2.ListModel;
import com.example.tourapp2.databinding.ListLayoutBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListModel> places;
    private onClickListener listener;
    public ListAdapter(List<ListModel> places,onClickListener listener)
    {
        this.places=places;
        this.listener=listener;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private  ListLayoutBinding binding;
        public ViewHolder(@NonNull ListLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            binding.listContainer.setOnClickListener(v->
                    listener.onClick(binding.listImage,places.get(getAdapterPosition())));
        }

        public void bind(ListModel listModel)
        {
            binding.setListModel(listModel);
        }
    }
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bind(places.get(position));

    }
    private ViewHolder from(@NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListLayoutBinding binding = ListLayoutBinding.inflate(inflater);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public interface onClickListener{
        void onClick(ImageView imageView, ListModel listModel);
    }
}
