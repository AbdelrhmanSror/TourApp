package com.example.tourapp2;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class BindingUtil {
    //using binding adapter to load and image into image view using glide library
    @BindingAdapter("imageUri")
    public static void setImageUri(ImageView imageView, String imageUri)
    {
        Glide.with(imageView.getContext()).load(imageUri).apply(new RequestOptions().override(imageView.getWidth(), 300))
                .transform(new RoundedCorners(20)).into(imageView);

    }
}
