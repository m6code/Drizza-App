package com.m6code.driza.ui.track;

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

public class TrackFragRecyclerAdapter extends RecyclerView.Adapter<TrackFragRecyclerAdapter.ViewHolder> {

    private SearchResponse reponseData;
    private final Context mContext;
    LayoutInflater mLayoutInflater;

    public TrackFragRecyclerAdapter(Context context, SearchResponse searchResponse) {
        mContext = context;
        reponseData = searchResponse;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        View itemView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum track = reponseData.getData().get(position);
        holder.mTitle.setText(track.getTitle());
        holder.mArtist.setText(track.getArtist().getName());
        holder.mDetails.setText(track.getAlbum().getTitle());

        // Use Glide to load images
        Glide.with(mContext)
                .load(track.getAlbum().getCover())
                .placeholder(R.drawable.ic_track_24)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.mCover);

        holder.mCurrentPos = position;

//        if (isImagePosition(position)) {
//            Glide.with(mContext)
//                    .load(track.getAlbum().getCover())
//                    .placeholder(R.drawable.ic_track_24)
//                    .into(holder.mCover);
//        } else {
//            Glide.with(mContext).clear(holder.mCover);
//            holder.mCover.setImageResource(R.drawable.ic_track_24);
//        }


//        Glide.with(fragment)
//                .load(myUrl)
//                .placeholder(placeholder)
//                .fitCenter()
//                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return reponseData.getData().size();
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
