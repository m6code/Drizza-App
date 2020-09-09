package com.m6code.driza.ui.playlist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlaylistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlaylistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Playlist View");
    }

    public MutableLiveData<String> getText() {
        return mText;
    }
}
