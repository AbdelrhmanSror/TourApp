package com.example.tourapp2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * model class that represent the place and its information
 */
public class ListModel implements Parcelable {
    private String imageUri, name, description;
    public ListModel(String imageUri, String name, String description)
    {
        this.imageUri=imageUri;
        this.description=description;
        this.name=name;
    }

    protected ListModel(Parcel in) {
        imageUri = in.readString();
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<ListModel> CREATOR = new Creator<ListModel>() {
        @Override
        public ListModel createFromParcel(Parcel in) {
            return new ListModel(in);
        }

        @Override
        public ListModel[] newArray(int size) {
            return new ListModel[size];
        }
    };

    public String getImageUri() {
        return imageUri;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imageUri);
        parcel.writeString(name);
        parcel.writeString(description);
    }
}
