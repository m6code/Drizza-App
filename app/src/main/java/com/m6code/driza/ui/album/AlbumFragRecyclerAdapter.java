package com.m6code.driza.ui.album;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.driza.R;
import com.m6code.driza.model.AlbumFromTrackSearch;

import java.util.ArrayList;

public class AlbumFragRecyclerAdapter extends RecyclerView.Adapter<AlbumFragRecyclerAdapter.ViewHolder> {

    private final ArrayList<AlbumFromTrackSearch> albumsData;
    private final Context mContext;
    LayoutInflater mLayoutInflater;

    public AlbumFragRecyclerAdapter(Context context, ArrayList<AlbumFromTrackSearch> albumsData) {
        this.albumsData = albumsData;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlbumFromTrackSearch album = albumsData.get(position);
        holder.mTitle.setText(album.getTitle());
        holder.mArtist.setText(album.getTitle());
        holder.mDetails.setText(album.getTitle());
        holder.mCover.setImageResource(R.drawable.ic_album_24);
        holder.mCurrentPos = position;
    }

    @Override
    public int getItemCount() {
        return albumsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView mTitle;
        public final TextView mArtist;
        public final TextView mDetails;
        public final ImageView mCover;
        public int mCurrentPos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
            mArtist = itemView.findViewById(R.id.tv_artist);
            mDetails = itemView.findViewById(R.id.tv_details);
            mCover = itemView.findViewById(R.id.imageView);
        }
    }
}
