package com.m6code.driza.ui.track;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.model.Track;
import com.m6code.driza.ui.artist.ArtistViewModel;

import java.util.ArrayList;

public class TrackFragment extends Fragment{

    RecyclerView mRecyclerView;
    TrackFragRecyclerAdapter mFragRecyclerAdapter;
    private TrackViewModel mTrackViewModel;

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstanceState){
        mTrackViewModel = ViewModelProviders.of(this).get(TrackViewModel.class);

        View rootView = layoutInflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        mTrackViewModel.getTracksLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Track>>() {
            @Override
            public void onChanged(ArrayList<Track> tracks) {
                mFragRecyclerAdapter = new TrackFragRecyclerAdapter(getActivity(), tracks);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(mFragRecyclerAdapter);
            }
        });

        return rootView;

    }
}
