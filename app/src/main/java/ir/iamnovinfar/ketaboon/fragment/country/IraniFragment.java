package ir.iamnovinfar.ketaboon.fragment.country;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ir.iamnovinfar.ketaboon.Database.Database;
import ir.iamnovinfar.ketaboon.R;
import ir.iamnovinfar.ketaboon.adaptor.AdapterRecyclerview;
import ir.iamnovinfar.ketaboon.model.Person;

import java.util.List;

public class IraniFragment extends Fragment {

    View view;
    TextView textview;
    Button button;
    List<Person> personList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.irani_and_khareji_fragment,container,false);
        Database d=new Database(getActivity());
        personList=d.getalliraniperson();
        recyclerView=view.findViewById(R.id.rec_pr);
        AdapterRecyclerview recyclerviewadepter=new AdapterRecyclerview(getActivity(),personList);
        recyclerView.setAdapter(recyclerviewadepter);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }


}
