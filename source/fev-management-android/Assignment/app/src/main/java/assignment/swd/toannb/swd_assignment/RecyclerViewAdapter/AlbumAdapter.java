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
import assignment.swd.toannb.swd_assignment.Models.FEVMember;
import assignment.swd.toannb.swd_assignment.R;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<FEVEvent> listEvent;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView album_event_id, album_event_name;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            album_event_id = (TextView) itemView.findViewById(R.id.event_album_id);
            album_event_name = (TextView) itemView.findViewById(R.id.event_album_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    FEVEvent event = new FEVEvent();
                    event.setId(Integer.parseInt(album_event_id.getText().toString()));
                    event.setName(album_event_name.getText().toString());

                    Intent intent = new Intent(context, EventAlbumImageActivity.class);
                    intent.putExtra("event_album_obj", event);
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View albumView = inflater.inflate(R.layout.item_album, viewGroup, false);

        AlbumAdapter.ViewHolder viewHolder = new AlbumAdapter.ViewHolder(albumView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder viewHolder, int i) {
        FEVEvent event = listEvent.get(i);

        TextView album_event_id = viewHolder.album_event_id;
        album_event_id.setText(Integer.toString(event.getId()));


        TextView album_event_name = viewHolder.album_event_name;
        album_event_name.setText(event.getName());

    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }

    public AlbumAdapter(List<FEVEvent> listEvent){
        this.listEvent = listEvent;
    }


}
