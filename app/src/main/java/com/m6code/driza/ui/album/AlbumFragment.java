package com.m6code.driza.ui.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.model.Album;
import com.m6code.driza.model.SearchResponse;
import com.m6code.driza.services.NetworkUtil;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private AlbumFragRecyclerAdapter mFragRecyclerAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        AlbumViewModel albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_album, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerViewAlbum);

        // Check for internet first
        if (NetworkUtil.getConnectionStatus(getContext())) {

            albumViewModel.getAlbumsLiveData().observe(getViewLifecycleOwner(), new Observer<SearchResponse>() {
                @Override
                public void onChanged(SearchResponse searchResponse) {
                    mFragRecyclerAdapter = new AlbumFragRecyclerAdapter(getContext(), searchResponse);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mRecyclerView.setAdapter(mFragRecyclerAdapter);
                }
            });

        } else{
            Toast.makeText(getContext(), "No Internet, Check your connection", Toast.LENGTH_LONG).show();
        }

        return rootView;
    }

}
