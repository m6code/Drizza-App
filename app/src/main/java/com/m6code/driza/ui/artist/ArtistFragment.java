package com.m6code.driza.ui.artist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.datasource.UserSearch;
import com.m6code.driza.services.NetworkUtil;

public class ArtistFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArtistFragRecyclerAdapter mFragRecyclerAdapter;
    private ProgressBar mProgressBar;
    private LinearLayout mErrorLayout;
    private ImageView mErrorImage;
    private TextView mErrorText;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mProgressBar = rootView.findViewById(R.id.progressBar);
        mErrorLayout = rootView.findViewById(R.id.errorLayout);
        mErrorImage = rootView.findViewById(R.id.imageView_error);
        mErrorText = rootView.findViewById(R.id.textView_error);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArtistViewModel artistViewModel = new ViewModelProvider(requireActivity()).get(ArtistViewModel.class);

        if (NetworkUtil.getConnectionStatus(getActivity())) {
            if (!UserSearch.getSearchText().trim().isEmpty()) {
                artistViewModel.getResponseData().observe(getViewLifecycleOwner(), searchResponse -> {
                    mFragRecyclerAdapter = new ArtistFragRecyclerAdapter(getContext(), searchResponse);
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
    }

    public void setErrorMessage(int drawable, int text){
        mProgressBar.setVisibility(View.GONE);
        mErrorImage.setImageResource(drawable);
        mErrorText.setText(text);
        mErrorLayout.setVisibility(View.VISIBLE);
//        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }
}
