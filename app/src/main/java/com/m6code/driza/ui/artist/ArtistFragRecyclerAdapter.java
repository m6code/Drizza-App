package com.m6code.driza.ui.artist;

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
import com.m6code.driza.ui.album.AlbumFragRecyclerAdapter;

import java.util.Locale;

public class ArtistFragRecyclerAdapter extends RecyclerView.Adapter<ArtistFragRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    LayoutInflater mLayoutInflater;
    private SearchResponse repsonseData;

    public ArtistFragRecyclerAdapter(Context context, SearchResponse repsonseData) {
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
        Datum artist = repsonseData.getData().get(position);
        holder.mTitle.setText(artist.getName());
        holder.mArtist.setText(String.format(Locale.ENGLISH,"%d Album(s)",artist.getNbAlbum()));
        holder.mDetails.setText(String.format(Locale.ENGLISH, "%d Fan(s)",artist.getNbFan()));


        // set image with glide
        Glide.with(mContext)
                .load(artist.getPicture())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_artist_24)
                .circleCrop()
                .into(holder.mCover);

        holder.mCover.setPadding(16,16,8,16);

        holder.mCurrentPos = position;
    }

    @Override
    public int getItemCount() {
        return repsonseData.getData().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
