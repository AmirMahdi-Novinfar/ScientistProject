package com.example.ketaboon.adaptor;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {
    List<String> name_countery=new ArrayList<>();
    List<Fragment>fragments =new ArrayList<>();

    public HomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return name_countery.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return name_countery.get(position);
    }


    public void addfragment(Fragment dd,String name){
        name_countery.add(name);
        fragments.add(dd);

    }
}
