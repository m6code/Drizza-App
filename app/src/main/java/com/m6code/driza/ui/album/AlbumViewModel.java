package com.m6code.driza.ui.album;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.m6code.driza.model.Album;

import java.util.ArrayList;

public class AlbumViewModel extends ViewModel {
    ArrayList<Album> mAlbumsArray;
    private MutableLiveData<ArrayList<Album>> albumLiveData;

    public AlbumViewModel() {
        albumLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Album>> getAlbumLiveData() {
        return albumLiveData;
    }

    private void init() {
        populateAlbum();
        albumLiveData.setValue(mAlbumsArray);
    }

    private void populateAlbum() {
        Album sample = new Album();
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
