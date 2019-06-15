package assignment.swd.toannb.swd_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import assignment.swd.toannb.swd_assignment.APIManagement.APIConnector;
import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.FEVInventoryItem;
import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.EventAdapter;
import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.InventoryAdapter;

public class InventoryActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar mToolBar;
    private RecyclerView recyclerView;
    List<FEVInventoryItem> listIventoryItem;
    public static final String INVENTORY_ITEMS_GET_ALL_API = "http://172.20.10.7:8080/api/inventory/items";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        mToolBar = findViewById(R.id.app_bar_inventory);
        setSupportActionBar(mToolBar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewInventory);
        listIventoryItem =  inventoryItemsAPIFetcher();

        InventoryAdapter inventoryAdapter = new InventoryAdapter(listIventoryItem);

        recyclerView.setAdapter(inventoryAdapter);

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
                Intent intent = new Intent(InventoryActivity.this, InventoryActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_item_transaction:
                // TODO Something when menu item selected
                Intent intent1 = new Intent(InventoryActivity.this, TransactionActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public List<FEVInventoryItem> inventoryItemsAPIFetcher() {
        StringBuilder stringBuilder = new StringBuilder(INVENTORY_ITEMS_GET_ALL_API);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;
        ArrayList<FEVInventoryItem> listInventoryItem = new ArrayList<FEVInventoryItem>();
        APIConnector getInventoryItemAPI = new APIConnector(this);
        try {
            String s = getInventoryItemAPI.execute(dataTransfer).get();
            if (!s.equals("Could not connect to server")) {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    int id = Integer.parseInt(jsonObject.getString("id"));
                    final String name = jsonObject.getString("name");
                    final String address = jsonObject.getString("address");
                    final String price = jsonObject.getString("price");
                    final String note = jsonObject.getString("note");

                    FEVInventoryItem item = new FEVInventoryItem(id, name,address,price,note );
                    listInventoryItem.add(item);

                }

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listInventoryItem;
    }

}
