package assignment.swd.toannb.swd_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CreateEventActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        initView();
    }

    public void initView(){

        mToolBar = findViewById(R.id.app_bar_create_event);
        setSupportActionBar(mToolBar);
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
                return true;

            case R.id.menu_item_transaction:
                // TODO Something when menu item selected
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void createEvent(View view) {
    }
}
