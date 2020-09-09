package com.m6code.driza.ui.artist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArtistViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ArtistViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("Artist View");
    }

    public MutableLiveData<String> getText() {
        return mText;
    }
}
