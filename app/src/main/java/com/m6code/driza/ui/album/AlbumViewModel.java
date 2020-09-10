package com.m6code.driza.ui.album;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.m6code.driza.model.AlbumFromTrackSearch;

import java.util.ArrayList;

public class AlbumViewModel extends ViewModel {
    ArrayList<AlbumFromTrackSearch> mAlbumsArray;
    private MutableLiveData<ArrayList<AlbumFromTrackSearch>> albumLiveData;

    public AlbumViewModel() {
        albumLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<AlbumFromTrackSearch>> getAlbumLiveData() {
        return albumLiveData;
    }

    private void init() {
        populateAlbum();
        albumLiveData.setValue(mAlbumsArray);
    }

    private void populateAlbum() {
        AlbumFromTrackSearch sample = new AlbumFromTrackSearch();
        sample.setTitle("Three");
        sample.setType("Album");

        mAlbumsArray = new ArrayList<>();
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
        mAlbumsArray.add(sample);
    }
}
