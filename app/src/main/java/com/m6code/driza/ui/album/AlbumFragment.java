package com.m6code.driza.ui.album;

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

public class AlbumFragment extends Fragment {

    private AlbumViewModel mAlbumViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        mAlbumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_track, container, false);
        final TextView textView = rootView.findViewById(R.id.text_track);

        mAlbumViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return rootView;
    }

}
