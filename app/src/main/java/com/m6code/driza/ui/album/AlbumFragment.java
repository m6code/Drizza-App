package com.m6code.driza.ui.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.datasource.UserSearch;
import com.m6code.driza.services.NetworkUtil;

public class AlbumFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private AlbumFragRecyclerAdapter mFragRecyclerAdapter;
    private ProgressBar mProgressBar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        AlbumViewModel albumViewModel = new ViewModelProvider.AndroidViewModelFactory(
                getActivity().getApplication()).create(AlbumViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mProgressBar = rootView.findViewById(R.id.progressBar);

        // Check for internet first
        if (NetworkUtil.getConnectionStatus(getContext())) {
            if (!UserSearch.getSearchText().trim().isEmpty()) {
                albumViewModel.getAlbumsLiveData().observe(getViewLifecycleOwner(), searchResponse -> {
                    mFragRecyclerAdapter = new AlbumFragRecyclerAdapter(getContext(), searchResponse);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mRecyclerView.setAdapter(mFragRecyclerAdapter);
                    mProgressBar.setVisibility(View.GONE); // Find and set visibility of progressBar
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
