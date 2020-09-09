package com.m6code.driza.ui.artist;

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

public class ArtistFragment extends Fragment {

    private ArtistViewModel mArtistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mArtistViewModel = ViewModelProviders.of(this).get(ArtistViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_track, container, false);
        final TextView artistText = rootView.findViewById(R.id.text_track);

        mArtistViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                artistText.setText(s);
            }
        });

        return rootView;
    }
}
