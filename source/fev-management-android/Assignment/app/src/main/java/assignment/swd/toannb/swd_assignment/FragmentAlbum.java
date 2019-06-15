package assignment.swd.toannb.swd_assignment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ExecutionException;


import assignment.swd.toannb.swd_assignment.APIManagement.APIConnector;
import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.FEVEventAlbum;

import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.AlbumAdapter;

public class FragmentAlbum extends Fragment {
    List<FEVEvent> listEvent;
    private static final String ALBUM_GET_ALL_API = "http://192.168.1.25:8080/api/events/albums/album";
    private static final String ALBUM_GET_EVENT = "http://172.20.10.7:8080/api/events"; //Moda host
    private View mRootView;
    private RecyclerView recyclerView;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        mRootView = inflater.inflate(R.layout.fragment_album, container, false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerViewAlbum);
        listEvent =  eventAPIFetcher();

        AlbumAdapter albumAdapter = new AlbumAdapter(listEvent);

        recyclerView.setAdapter(albumAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return mRootView;
    }


//    public List<FEVEventAlbum> albumAPIFetcher() {
//        StringBuilder stringBuilder = new StringBuilder(ALBUM_GET_EVENT);
//        String url = stringBuilder.toString();
//        Object dataTransfer[] = new Object[1];
//        dataTransfer[0] = url;
//        ArrayList<FEVEventAlbum> listAlbum = new ArrayList<FEVEventAlbum>();
//        APIConnector getAllAlbumAPI = new APIConnector(this.context);
//        try {
//            String s = getAllAlbumAPI.execute(dataTransfer).get();
//            if (!s.equals("Could not connect to server")) {
//                JSONArray jsonArray = new JSONArray(s);
//                for (int i = 0; i < jsonArray.length(); i++) {
//
//                    JSONObject jsonObject = jsonArray.optJSONObject(i);
//                    int id = Integer.parseInt(jsonObject.getString("id"));
//                    final String img = jsonObject.getString("name");
//
//                    FEVEventAlbum album = new FEVEventAlbum(id, img);
//                    listAlbum.add(album);
//
//                }
//
//            }
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return listAlbum;
//    }


    public List<FEVEvent> eventAPIFetcher() {
        StringBuilder stringBuilder = new StringBuilder(ALBUM_GET_EVENT);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;
        ArrayList<FEVEvent> listEvent = new ArrayList<FEVEvent>();
        APIConnector getEventAPI = new APIConnector(this.context);
        try {
            String s = getEventAPI.execute(dataTransfer).get();
            if (!s.equals("Could not connect to server")) {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    int id = Integer.parseInt(jsonObject.getString("id"));
                    final String name = jsonObject.getString("name");

                    FEVEvent event = new FEVEvent(id, name );
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