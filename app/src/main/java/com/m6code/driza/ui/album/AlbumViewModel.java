package com.m6code.driza.ui.album;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlbumViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AlbumViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Album View");
    }

    public MutableLiveData<String> getText() {
        return mText;
    }
}
