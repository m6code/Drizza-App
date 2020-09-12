package com.m6code.driza.ui.track;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.m6code.driza.R;
import com.m6code.driza.model.Datum;
import com.m6code.driza.model.SearchResponse;

public class TrackFragRecyclerAdapter extends RecyclerView.Adapter<TrackFragRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final SearchResponse reponseData;

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

//        holder.mCover.setOnClickListener(view ->
//                Toast.makeText(mContext, "Clicked Cover of track: " + track.getId(), Toast.LENGTH_LONG).show());
//        holder.mTitle.setOnClickListener(view ->
//                Toast.makeText(mContext, "Clicked Title: " + track.getTitle(), Toast.LENGTH_LONG).show());
//        holder.mArtist.setOnClickListener(view ->
//                Toast.makeText(mContext, "Clicked Artist: " + track.getArtist().getName(), Toast.LENGTH_LONG).show());
//        holder.mDetails.setOnClickListener(view ->
//                Toast.makeText(mContext, "Clicked on Details: " + track.getAlbum().getTitle(), Toast.LENGTH_LONG).show());


        // TODO: Use ID to query api for tracks & Launch Dialog
        holder.mCard.setOnClickListener(view -> {
            //Toast.makeText(mContext, "Clicked card id: " + track.getId(), Toast.LENGTH_LONG).show();

            // Show Dialog
            Dialog dialog = new Dialog(mContext);
            dialog.setContentView(R.layout.track_detail_dailog);

            // find views
            TextView title = dialog.findViewById(R.id.textView_title);
            TextView album = dialog.findViewById(R.id.textView_album);
            TextView artist = dialog.findViewById(R.id.textView_artist_name);
            ImageView cover = dialog.findViewById(R.id.imageView);

            title.setText(track.getTitle());
            artist.setText(track.getArtist().getName());
            album.setText(track.getAlbum().getTitle());

            Glide.with(dialog.getContext())
                    .load(track.getAlbum().getCoverMedium())
                    .placeholder(R.drawable.ic_track_24)
                    .into(cover);
            // Query Api and set dat on Dialog box

            dialog.show();

        });


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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitle;
        public final TextView mArtist;
        public final TextView mDetails;
        public final ImageView mCover;
        public final CardView mCard;
        public int mCurrentPos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            mDetails = (TextView) itemView.findViewById(R.id.tv_details);
            mCover = (ImageView) itemView.findViewById(R.id.imageView);
            mCard = (CardView) itemView.findViewById(R.id.cardView);

            //itemView.setOnClickListener(view -> Toast.makeText(itemView.getContext(), "Clicked ItemView", Toast.LENGTH_LONG).show());
        }
    }


}
