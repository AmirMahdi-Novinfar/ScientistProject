package com.example.ketaboon.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.example.ketaboon.activity.MainActivity;
import com.example.ketaboon.adaptor.HomeAdapter;
import com.example.ketaboon.R;
import com.example.ketaboon.fragment.country.IraniFragment;
import com.example.ketaboon.fragment.country.KhareJiFragment;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class Homefragment extends Fragment {
    View view;
    TabLayout tab1;
    RtlViewPager rtl1;
    HomeAdapter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        tab1 = (TabLayout) view.findViewById(R.id.tabMod22e);
        rtl1 = (RtlViewPager) view.findViewById(R.id.rtlviewpager);
        adpter = new HomeAdapter(getChildFragmentManager());
        adpter.addfragment(new IraniFragment(), "ایرانی");
        adpter.addfragment(new KhareJiFragment(), "خارجی");
        rtl1.setAdapter(adpter);
        tab1.setupWithViewPager(rtl1);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
