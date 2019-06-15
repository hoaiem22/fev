package assignment.swd.toannb.swd_assignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import assignment.swd.toannb.swd_assignment.APIManagement.APIConnector;
import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.FEVEventAlbum;
import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.EventImageAdapter;
import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.MemberAdapter;

public class EventAlbumImageActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar mToolBar;
    List<FEVEventAlbum> listAlbumImage;
//    private static final String ALBUM_IMAGE_GET_BY_EVENT_ID_API = "http://192.168.1.25:8080/api/events/albums/album";

    private RecyclerView recyclerView;
    private Context context;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_album_image);
        mToolBar = findViewById(R.id.app_bar_album_image);
        setSupportActionBar(mToolBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewAlbumImage);

        Intent i = getIntent();
        FEVEvent event = (FEVEvent) i.getSerializableExtra("event_album_obj");



            listAlbumImage =  albumImageAPIFetcher(event.getId());
            EventImageAdapter eventImageAdapter = new EventImageAdapter(listAlbumImage);

            recyclerView.setAdapter(eventImageAdapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_inventory:
                // TODO Something when menu item selected
                Intent intent = new Intent(EventAlbumImageActivity.this, InventoryActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_item_transaction:
                // TODO Something when menu item selected
                Intent intent1 = new Intent(EventAlbumImageActivity.this, TransactionActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public List<FEVEventAlbum> albumImageAPIFetcher(int eventId) {
        StringBuilder stringBuilder = new StringBuilder("http://172.20.10.7:8080/api/events/albums/album/" + eventId);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;
        ArrayList<FEVEventAlbum> listAlbumImage = new ArrayList<FEVEventAlbum>();
        APIConnector getAlbumImageAPI = new APIConnector(this.context);
        try {
            String s = getAlbumImageAPI.execute(dataTransfer).get();
            if (!s.equals("Could not connect to server")) {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    int id = Integer.parseInt(jsonObject.getString("id"));
                    final String img = jsonObject.getString("img");

                    FEVEventAlbum albumImage = new FEVEventAlbum(id, img);
                    listAlbumImage.add(albumImage);

                }

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
            return listAlbumImage;
    }

}
