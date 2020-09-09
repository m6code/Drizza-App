package com.m6code.driza.ui.playlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.m6code.driza.R;

public class PlaylistFragment extends Fragment {

    private PlaylistViewModel mPlaylistViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        mPlaylistViewModel = ViewModelProviders.of(this).get(PlaylistViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_track, container, false);
        final TextView textView = rootView.findViewById(R.id.text_track);

        mPlaylistViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        return rootView;
    }
}
