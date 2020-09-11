package com.m6code.driza.ui.playlist;

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
import com.m6code.driza.model.Datum;
import com.m6code.driza.model.SearchResponse;

import java.util.Locale;

public class PlaylistFragRecyclerAdapter extends RecyclerView.Adapter<PlaylistFragRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    LayoutInflater mLayoutInflater;
    private SearchResponse repsonseData;

    public PlaylistFragRecyclerAdapter(Context context, SearchResponse repsonseData) {
        mContext = context;
        this.repsonseData = repsonseData;
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
        Datum playlist = repsonseData.getData().get(position);
        holder.mTitle.setText(playlist.getTitle());
        holder.mOwnerName.setText(String.format(Locale.ENGLISH, "by %s", playlist.getUser().getName()));
        holder.mNoTracks.setText(String.format(Locale.ENGLISH, "%d Track(s)", playlist.getNbTracks()));


        // set image with glide
        Glide.with(mContext)
                .load(playlist.getPicture())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_playlist_24)
                .into(holder.mPicture);

        holder.mCurrentPos = position;
    }

    @Override
    public int getItemCount() {
        return repsonseData.getData().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTitle;
        public final TextView mOwnerName;
        public final TextView mNoTracks;
        public final ImageView mPicture;
        public int mCurrentPos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
            mOwnerName = itemView.findViewById(R.id.tv_artist);
            mNoTracks = itemView.findViewById(R.id.tv_details);
            mPicture = itemView.findViewById(R.id.imageView);
        }
    }
}
