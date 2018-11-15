package assignment.swd.toannb.swd_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.MyPagerAdapter;

public class EventDetailActionActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar mToolBar;
    private TextView event_id, event_name, event_startday, event_endday, event_time, event_place, event_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail_action);

        initView();




    }

    public void initView(){

        mToolBar = findViewById(R.id.app_bar_event_detail);
        setSupportActionBar(mToolBar);

        event_id = findViewById(R.id.event_id_detail);
        event_name = findViewById(R.id.event_name_detail);
        event_startday = findViewById(R.id.event_startday_detail);
        event_endday = findViewById(R.id.event_endday_detail);
        event_time = findViewById(R.id.event_time_detail);
        event_place = findViewById(R.id.event_place_detail);
        event_note = findViewById(R.id.event_note_detail);

        Intent i = getIntent();
        FEVEvent event = (FEVEvent) i.getSerializableExtra("event_obj");


        event_name.setText(event.getName());
        event_startday.setText(event.getStartTime());
        event_endday.setText(event.getEndTime());
        event_time.setText(event.getTime());
        event_place.setText(event.getPlace());
        event_note.setText(event.getNote());



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
                Intent intent = new Intent(EventDetailActionActivity.this, InventoryActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_item_transaction:
                // TODO Something when menu item selected
                Intent intent1 = new Intent(EventDetailActionActivity.this, TransactionActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void updateEvent(View view) {
    }

    public void deleteEvent(View view) {

    }
}
