package com.example.ketaboon.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ketaboon.R;

import static android.content.Context.MODE_PRIVATE;

public class Profilefragment extends Fragment {

    TextView t1,t2;

    View bl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        bl = inflater.inflate(R.layout.profile_fragment, container, false);

        t1 = (TextView) bl.findViewById(R.id.txt_name);
        t2 = (TextView) bl.findViewById(R.id.txt_shoghl);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        String ali = sharedPreferences.getString("usr_name", null);
        String shoghl = sharedPreferences.getString("shoghl", null);
        if (ali != null) {
            t1.setText(ali);
            t2.setText(shoghl);

        }
        return bl;
    }

}
