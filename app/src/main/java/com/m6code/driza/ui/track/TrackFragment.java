package com.m6code.driza.ui.track;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.model.TrackSearchResponse;

public class TrackFragment extends Fragment{

    RecyclerView mRecyclerView;
    TrackFragRecyclerAdapter mFragRecyclerAdapter;

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstanceState){
        TrackViewModel trackViewModel = ViewModelProviders.of(this).get(TrackViewModel.class);

        View rootView = layoutInflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        trackViewModel.getTracksLiveData().observe(getViewLifecycleOwner(), new Observer<TrackSearchResponse>() {
            @Override
            public void onChanged(TrackSearchResponse trackSearchResponse) {
                mFragRecyclerAdapter = new TrackFragRecyclerAdapter(getContext(), trackSearchResponse);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mRecyclerView.setAdapter(mFragRecyclerAdapter);
            }
        });

        return rootView;

    }
}
