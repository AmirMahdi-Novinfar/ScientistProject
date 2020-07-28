package com.example.ketaboon.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ketaboon.Database.Database;
import com.example.ketaboon.R;
import com.example.ketaboon.adaptor.AdapterRecyclerview;
import com.example.ketaboon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Searchefragment extends Fragment {

    EditText txt_search;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    AdapterRecyclerview adapter;
    List<Person> personList;
    View bl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        bl = inflater.inflate(R.layout.search_fragment, container, false);
        setupviews();
        setdataofrecycelers();
        showbackground();
        txt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().isEmpty()) {
                    showbackground();
                } else {
                    hidebackground();
                    filter(editable.toString());
                }
            }
        });
        return bl;
    }


    private void setupviews() {

        txt_search = bl.findViewById(R.id.txt_search);
        recyclerView = bl.findViewById(R.id.recycler_id_search);
        linearLayout = bl.findViewById(R.id.search_bg);

    }
    private void setdataofrecycelers() {
        Database database = new Database(getActivity());
        personList = database.getallperson();
        adapter = new AdapterRecyclerview(getActivity(), personList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    private void showbackground() {

        linearLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

    }
    private void hidebackground() {

        linearLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);


    }


    private void filter(String text) {
        List<Person> filterlist = new ArrayList<>();

        for (Person person : personList) {
            if (person.getName().toLowerCase().contains(text.toLowerCase())) {
                filterlist.add(person);
            }
        }
        adapter.filterlist(filterlist);
    }

}
