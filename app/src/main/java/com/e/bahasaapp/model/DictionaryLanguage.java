package com.e.bahasaapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DictionaryLanguage implements Parcelable {

    // create implementation Parcelable to this class
    private String name;
    private int photo;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }


    public DictionaryLanguage() {
    }

    protected DictionaryLanguage(Parcel in) {
        name = in.readString();
        photo = in.readInt();
    }

    public static final Creator<DictionaryLanguage> CREATOR = new Creator<DictionaryLanguage>() {
        @Override
        public DictionaryLanguage createFromParcel(Parcel in) {
            return new DictionaryLanguage(in);
        }

        @Override
        public DictionaryLanguage[] newArray(int size) {
            return new DictionaryLanguage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(photo);
    }
}
