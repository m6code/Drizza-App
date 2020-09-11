package com.m6code.driza.ui.artist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.datasource.UserSearch;
import com.m6code.driza.model.SearchResponse;
import com.m6code.driza.services.NetworkUtil;
import com.m6code.driza.ui.album.AlbumFragRecyclerAdapter;

public class ArtistFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArtistFragRecyclerAdapter mFragRecyclerAdapter;
    private ProgressBar mProgressBar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArtistViewModel artistViewModel = ViewModelProviders.of(this).get(ArtistViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mProgressBar = rootView.findViewById(R.id.progressBar);

        if (NetworkUtil.getConnectionStatus(getActivity())) {
            if (!UserSearch.getSearchText().trim().isEmpty()) {
                artistViewModel.getResponseData().observe(getViewLifecycleOwner(), new Observer<SearchResponse>() {
                    @Override
                    public void onChanged(SearchResponse searchResponse) {
                        mFragRecyclerAdapter = new ArtistFragRecyclerAdapter(getContext(), searchResponse);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        mRecyclerView.setAdapter(mFragRecyclerAdapter);
                        mProgressBar.setVisibility(View.GONE); // Find and set visibility of progressBar
                    }
                });
            } else {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Provide search text", Toast.LENGTH_LONG).show();
            }
        } else {
            mProgressBar.setVisibility(View.GONE);
            Toast.makeText(getContext(), "No Internet, check your connection!", Toast.LENGTH_LONG).show();
        }

        return rootView;
    }
}
