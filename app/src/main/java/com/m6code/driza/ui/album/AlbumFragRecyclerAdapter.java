package com.m6code.driza.ui.album;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.m6code.driza.R;
import com.m6code.driza.model.Album;
import com.m6code.driza.model.Datum;
import com.m6code.driza.model.SearchResponse;

import java.util.ArrayList;
import java.util.Locale;

public class AlbumFragRecyclerAdapter extends RecyclerView.Adapter<AlbumFragRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    LayoutInflater mLayoutInflater;
    private SearchResponse repsonseData;

    public AlbumFragRecyclerAdapter(Context context, SearchResponse albumsData) {
        this.repsonseData = albumsData;
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
        Datum album = repsonseData.getData().get(position);
        holder.mTitle.setText(album.getTitle());
        holder.mArtist.setText(album.getArtist().getName());
        holder.mDetails.setText(String.format(Locale.ENGLISH, "%d Track(s)", album.getNbTracks()));

        // set image with glide
        Glide.with(mContext)
                .load(album.getCover())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_album_24)
                .into(holder.mCover);
        holder.mCurrentPos = position;
    }

    @Override
    public int getItemCount() {
        return repsonseData.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
