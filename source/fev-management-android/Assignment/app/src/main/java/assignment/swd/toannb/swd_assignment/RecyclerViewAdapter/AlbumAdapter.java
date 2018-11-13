package assignment.swd.toannb.swd_assignment.RecyclerViewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import assignment.swd.toannb.swd_assignment.Models.FEVEventAlbum;
import assignment.swd.toannb.swd_assignment.Models.FEVMember;
import assignment.swd.toannb.swd_assignment.R;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<FEVEventAlbum> listAlbum;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView album_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            album_image = (ImageView) itemView.findViewById(R.id.album_image);

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
        FEVEventAlbum album = listAlbum.get(i);

        ImageView album_image = viewHolder.album_image;
        Glide.with(context).load(album.getImg())
                .into(album_image);

    }

    @Override
    public int getItemCount() {
        return listAlbum.size();
    }

    public AlbumAdapter(List<FEVEventAlbum> listAlbum){
        this.listAlbum = listAlbum;
    }


}
