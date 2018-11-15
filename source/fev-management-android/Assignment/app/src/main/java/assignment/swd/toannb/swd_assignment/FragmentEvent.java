package assignment.swd.toannb.swd_assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ExecutionException;

import assignment.swd.toannb.swd_assignment.APIManagement.APIConnector;

import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.FEVEventMember;

import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.EventAdapter;

public class FragmentEvent extends Fragment {
    List<FEVEvent> listEvent;
    private static final String EVENT_GET_ALL_API = "http://192.168.1.132:8080/api/events";  //Moda host

    private View mRootView;
    private RecyclerView recyclerView;
    private Context context;
    private Button btnCreateEvent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        mRootView = inflater.inflate(R.layout.fragment_event, container, false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        listEvent =  eventAPIFetcher();

        EventAdapter eventAdapter = new EventAdapter(listEvent);

        recyclerView.setAdapter(eventAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));


//        btnCreateEvent = mRootView.findViewById(R.id.btn_create_event_fragment);
//        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, CreateEventActivity.class);
//                startActivity(intent);
//            }
//        });


        return mRootView;

    }



    public List<FEVEvent> eventAPIFetcher() {
        StringBuilder stringBuilder = new StringBuilder(EVENT_GET_ALL_API);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;
        ArrayList<FEVEvent> listEvent = new ArrayList<FEVEvent>();
        APIConnector getAllEventAPI = new APIConnector(this.context);
        try {
            String s = getAllEventAPI.execute(dataTransfer).get();
            if (!s.equals("Could not connect to server")) {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    List<FEVEventMember> listEventMember;
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    int id = Integer.parseInt(jsonObject.getString("id"));
                    final String name = jsonObject.getString("name");
                    final String startDate =jsonObject.getString("start");
                    final String endDate = jsonObject.getString("end");
                    final String time =jsonObject.getString("time");
                    final String place = jsonObject.getString("place");
                    final String note = jsonObject.getString("note");





                    // get data from "fevEventMemberCollection"
//                    listEventMember = new ArrayList<FEVEventMember>();
//                    JSONArray eventMemberArray = new JSONArray(jsonObject.getString("fevEventMemberCollection"));
//                    for (int j = 0; j < eventMemberArray.length(); j++) {
//                        FEVEventMember eventMember = new FEVEventMember();
//                        JSONObject jsonObjectCollectionMember = jsonArray.optJSONObject(i);
//                        int idCollection = Integer.parseInt(jsonObjectCollectionMember.getString("id"));
//                        String noteCollection = jsonObjectCollectionMember.getString("note");
//                        eventMember.setId(idCollection);
//                        eventMember.setNote(noteCollection);
//                        listEventMember.add(eventMember);
//                    }

                    FEVEvent event = new FEVEvent(id, name, place, note, startDate, endDate, time);
                    listEvent.add(event);

                }

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listEvent;
    }



}
