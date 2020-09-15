package com.m6code.driza.ui.playlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.datasource.UserSearch;
import com.m6code.driza.services.NetworkUtil;

public class PlaylistFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PlaylistFragRecyclerAdapter mFragRecyclerAdapter;
    private ProgressBar mProgressBar;
    private LinearLayout mErrorLayout;
    private ImageView mErrorImage;
    private TextView mErrorText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        PlaylistViewModel playlistViewModel = new ViewModelProvider.AndroidViewModelFactory(
                getActivity().getApplication()).create(PlaylistViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mProgressBar = rootView.findViewById(R.id.progressBar);
        mErrorLayout = rootView.findViewById(R.id.errorLayout);
        mErrorImage = rootView.findViewById(R.id.imageView_error);
        mErrorText = rootView.findViewById(R.id.textView_error);

        if (NetworkUtil.getConnectionStatus(getContext())) {
            if (!UserSearch.getSearchText().trim().isEmpty()) {
                playlistViewModel.getPlaylistLiveData().observe(getViewLifecycleOwner(), searchResponse -> {
                    mFragRecyclerAdapter = new PlaylistFragRecyclerAdapter(getContext(), searchResponse);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mRecyclerView.setAdapter(mFragRecyclerAdapter);
                    mProgressBar.setVisibility(View.GONE); // Find and set visibility of progressBar
                    mErrorLayout.setVisibility(View.GONE);
                });
            } else {
                setErrorMessage(R.drawable.ic_search,R.string.provide_search_text);
            }
        } else {
            setErrorMessage(R.drawable.ic_network_off, R.string.no_internet);
        }

        return rootView;
    }

    public void setErrorMessage(int drawable, int text){
        mProgressBar.setVisibility(View.GONE);
        mErrorImage.setImageResource(drawable);
        mErrorText.setText(text);
        mErrorLayout.setVisibility(View.VISIBLE);
//        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }
}
