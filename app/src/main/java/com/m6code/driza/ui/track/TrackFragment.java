package com.m6code.driza.ui.track;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.m6code.driza.R;
import com.m6code.driza.ui.artist.ArtistViewModel;

public class TrackFragment extends Fragment {

    private TrackViewModel mTrackViewModel;

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstanceState){

        mTrackViewModel = ViewModelProviders.of(this).get(TrackViewModel.class);

        View rootView = layoutInflater.inflate(R.layout.fragment_track, container, false);
        final TextView trackTextView = rootView.findViewById(R.id.text_track);

        mTrackViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                trackTextView.setText(s);
            }
        });

        return rootView;

    }
}
