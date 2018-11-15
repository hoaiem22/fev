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
import assignment.swd.toannb.swd_assignment.Models.FEVInventoryItem;
import assignment.swd.toannb.swd_assignment.Models.FEVTransaction;
import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.TransactionAdapter;

public class TransactionActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar mToolBar;
    private RecyclerView recyclerView;
    List<FEVTransaction> listTransaction;

    public static final String TRANSACTION_GET_ALL_API = "http://192.168.1.132:8080/api/transactions";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        mToolBar = findViewById(R.id.app_bar_transaction);
        setSupportActionBar(mToolBar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewTransaction);
        listTransaction =  transactionAPIFetcher();

        TransactionAdapter transactionAdapter = new TransactionAdapter(listTransaction);

        recyclerView.setAdapter(transactionAdapter);

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
                Intent intent = new Intent(TransactionActivity.this, InventoryActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_item_transaction:
                // TODO Something when menu item selected
                Intent intent1 = new Intent(TransactionActivity.this, TransactionActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public List<FEVTransaction> transactionAPIFetcher() {
        StringBuilder stringBuilder = new StringBuilder(TRANSACTION_GET_ALL_API);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;
        ArrayList<FEVTransaction> listTransaction = new ArrayList<FEVTransaction>();
        APIConnector getTrnsactionAPI = new APIConnector(this);
        try {
            String s = getTrnsactionAPI.execute(dataTransfer).get();
            if (!s.equals("Could not connect to server")) {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    int id = Integer.parseInt(jsonObject.getString("id"));
                    final String content = jsonObject.getString("content");
                    final int money = Integer.parseInt(jsonObject.getString("money"));
                    final String note = jsonObject.getString("note");

                    FEVTransaction transaction = new FEVTransaction(id,money,content, note );
                    listTransaction.add(transaction);

                }

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listTransaction;
    }

}
