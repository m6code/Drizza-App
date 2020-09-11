package com.m6code.driza.ui.track;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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

public class TrackFragment extends Fragment {

    RecyclerView mRecyclerView;
    TrackFragRecyclerAdapter mFragRecyclerAdapter;
    private ProgressBar mProgressBar;

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstanceState) {
        TrackViewModel trackViewModel = ViewModelProviders.of(this).get(TrackViewModel.class);

        View rootView = layoutInflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mProgressBar = rootView.findViewById(R.id.progressBar);

        if (NetworkUtil.getConnectionStatus(getActivity())) {
            if (!UserSearch.getSearchText().trim().isEmpty()) {
                trackViewModel.getTracksLiveData().observe(getViewLifecycleOwner(), new Observer<SearchResponse>() {
                    @Override
                    public void onChanged(SearchResponse searchResponse) {
                        mFragRecyclerAdapter = new TrackFragRecyclerAdapter(getContext(), searchResponse);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        mRecyclerView.setAdapter(mFragRecyclerAdapter);
                        mProgressBar.setVisibility(View.GONE); // Find and set visibility of progressBar
                    }
                });

            } else {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Enter a Text Please", Toast.LENGTH_LONG).show();
            }

        } else {
            // Show No Internet Image and textView
            mProgressBar.setVisibility(View.GONE);
            Toast.makeText(getContext(), "No Internet, Check your connection", Toast.LENGTH_LONG).show();
        }

        return rootView;

    }
}
