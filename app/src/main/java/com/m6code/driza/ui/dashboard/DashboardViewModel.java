package com.m6code.driza.ui.dashboard;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.m6code.driza.R;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private MutableLiveData<Integer> mImageView;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mImageView = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
        mImageView.setValue(R.drawable.ic_dashboard_black_24dp);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<Integer> getImageView() {
        return mImageView;
    }
}