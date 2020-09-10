package com.m6code.driza.ui.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.model.AlbumFromTrackSearch;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private AlbumFragRecyclerAdapter mFragRecyclerAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        AlbumViewModel albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_album, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerViewAlbum);

        albumViewModel.getAlbumLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<AlbumFromTrackSearch>>() {
            @Override
            public void onChanged(ArrayList<AlbumFromTrackSearch> albums) {
                mFragRecyclerAdapter = new AlbumFragRecyclerAdapter(getContext(), albums);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mRecyclerView.setAdapter(mFragRecyclerAdapter);
            }
        });

        return rootView;
    }

}
