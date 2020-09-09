package com.m6code.driza.ui.track;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.m6code.driza.model.Track;

import java.util.ArrayList;

public class TrackViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Track>> tracksLiveData;
    ArrayList<Track> mTracksArrayList;

    public TrackViewModel() {
        tracksLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Track>> getTracksLiveData() {
        return tracksLiveData;
    }

    public void init(){
        populateTrackList();
        tracksLiveData.setValue(mTracksArrayList);
    }

    private void populateTrackList() {
        Track sample = new Track("Bullet Proof", "456", "7", "2020-09-09", "David Gueta", "Titanuim", "Track");

        mTracksArrayList = new ArrayList<>();
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);
        mTracksArrayList.add(sample);


    }
}
