package assignment.swd.toannb.swd_assignment;


import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import assignment.swd.toannb.swd_assignment.Models.MyPagerAdapter;

public class HomeActivity extends AppCompatActivity {


    private android.support.v7.widget.Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    public void initView(){

        mToolBar = findViewById(R.id.app_bar);
        setSupportActionBar(mToolBar);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.pager);

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
////        int id = item.getItemId();
////        if(id == R.id.action_setting){
////            return true;
////        }
//        return super.onOptionsItemSelected(item);
//    }




}



