package assignment.swd.toannb.swd_assignment.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import assignment.swd.toannb.swd_assignment.EventAlbumImageActivity;
import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.FEVEventAlbum;
import assignment.swd.toannb.swd_assignment.R;

public class EventImageAdapter extends RecyclerView.Adapter<EventImageAdapter.ViewHolder> {

    private List<FEVEventAlbum> listAlbumImage;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView event_album_image;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            event_album_image = (ImageView) itemView.findViewById(R.id.event_album_image);
        }
    }

    @NonNull
    @Override
    public EventImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View albumImageView = inflater.inflate(R.layout.item_event_album_image, viewGroup, false);

        EventImageAdapter.ViewHolder viewHolder = new EventImageAdapter.ViewHolder(albumImageView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventImageAdapter.ViewHolder viewHolder, int i) {


            FEVEventAlbum albumImage = listAlbumImage.get(i);

            ImageView event_album_image = viewHolder.event_album_image;
            Glide.with(context).load(albumImage.getImg()).into(event_album_image);

    }

    @Override
    public int getItemCount() {
        return listAlbumImage.size();
    }

    public EventImageAdapter(List<FEVEventAlbum> listAlbumImage){
        this.listAlbumImage = listAlbumImage;
    }


}
