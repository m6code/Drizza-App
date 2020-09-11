package com.m6code.driza.ui.playlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.model.SearchResponse;
import com.m6code.driza.services.NetworkUtil;
import com.m6code.driza.ui.artist.ArtistFragRecyclerAdapter;

public class PlaylistFragment extends Fragment {

    private PlaylistViewModel mPlaylistViewModel;
    private RecyclerView mRecyclerView;
    private PlaylistFragRecyclerAdapter mFragRecyclerAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        mPlaylistViewModel = ViewModelProviders.of(this).get(PlaylistViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        if(NetworkUtil.getConnectionStatus(getContext())) {
            mPlaylistViewModel.getPlaylistLiveData().observe(getViewLifecycleOwner(), new Observer<SearchResponse>() {
                @Override
                public void onChanged(SearchResponse searchResponse) {
                    mFragRecyclerAdapter = new PlaylistFragRecyclerAdapter(getContext(), searchResponse);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mRecyclerView.setAdapter(mFragRecyclerAdapter);
                }
            });
        }else{
            Toast.makeText(getContext(), "No Internet, Check your connection", Toast.LENGTH_LONG).show();
        }

        return rootView;
    }
}
