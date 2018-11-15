package assignment.swd.toannb.swd_assignment.Models;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import assignment.swd.toannb.swd_assignment.FragmentAlbum;
import assignment.swd.toannb.swd_assignment.FragmentEvent;
import assignment.swd.toannb.swd_assignment.FragmentMember;
import assignment.swd.toannb.swd_assignment.FragmentTransaction;
import assignment.swd.toannb.swd_assignment.HomeActivity;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private String[] listTab = {"Event", "Member", "Album"};
    private FragmentEvent mFragmentEvent;
    private FragmentMember mFragmentMember;
    private FragmentAlbum mFragmentAlbum;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentEvent = new FragmentEvent();
        mFragmentMember = new FragmentMember();
        mFragmentAlbum = new FragmentAlbum();
    }

    @Override
    public Fragment getItem(int position) {
       if(position == 0){
           return mFragmentEvent;
       }else if(position == 1){
           return mFragmentMember;
       }else if(position == 2){
           return mFragmentAlbum;
       }else{

       }
       return null;
    }

    @Override
    public int getCount() {

        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
