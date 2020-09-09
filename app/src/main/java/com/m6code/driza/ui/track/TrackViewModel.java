package com.m6code.driza.ui.track;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrackViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TrackViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Track View");
    }

    public MutableLiveData<String> getText() {
        return mText;
    }
}
