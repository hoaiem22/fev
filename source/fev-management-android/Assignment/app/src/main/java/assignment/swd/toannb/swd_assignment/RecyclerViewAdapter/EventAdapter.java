package assignment.swd.toannb.swd_assignment.RecyclerViewAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import assignment.swd.toannb.swd_assignment.EventDetailActionActivity;
import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.R;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<FEVEvent> listEvent;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView event_id, event_name, event_startday, event_endday, event_time, event_place, event_note;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            event_id = (TextView) itemView.findViewById(R.id. event_id);
            event_name = (TextView) itemView.findViewById(R.id.event_name);
            event_startday = (TextView) itemView.findViewById(R.id.event_startday);
            event_endday = (TextView) itemView.findViewById(R.id.event_endday);
            event_time = (TextView) itemView.findViewById(R.id.event_time);
            event_place = (TextView) itemView.findViewById(R.id.event_place);
            event_note = (TextView) itemView.findViewById(R.id.event_note);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    FEVEvent event = new FEVEvent();
                    event.setId(Integer.parseInt(event_id.getText().toString()));
                    event.setName(event_name.getText().toString());
                    event.setStartTime(event_startday.getText().toString());
                    event.setEndTime(event_endday.getText().toString());
                    event.setTime(event_time.getText().toString());
                    event.setPlace(event_place.getText().toString());
                    event.setNote(event_note.getText().toString());

                    Intent intent = new Intent(context, EventDetailActionActivity.class);
                    intent.putExtra("event_obj", event);
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View eventView = inflater.inflate(R.layout.item_event, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(eventView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FEVEvent event = listEvent.get(i);

        TextView event_id = viewHolder.event_id;
        event_id.setText(Integer.toString(event.getId()));

        TextView event_name = viewHolder.event_name;
        event_name.setText(event.getName());

        TextView event_startday = viewHolder.event_startday;
        event_startday.setText("Start day: " + event.getStartTime());

        TextView event_endday = viewHolder.event_endday;
        event_endday.setText("End time: " + event.getEndTime());

        TextView event_time = viewHolder.event_time;
        event_time.setText("Time: " + event.getTime());

        TextView event_place = viewHolder.event_place;
        event_place.setText("Place: " + event.getPlace());

        TextView event_note = viewHolder.event_note;
        event_note.setText("Note: " +event.getNote());
    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }

    public EventAdapter(List<FEVEvent> listEvent){
        this.listEvent = listEvent;
    }


}
