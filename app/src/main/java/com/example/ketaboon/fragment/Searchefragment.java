package com.example.ketaboon.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ketaboon.R;

public class Searchefragment extends Fragment {

    View bl;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        bl = inflater.inflate(R.layout.search_fragment, container, false);
        return bl;
    }
}
