package ir.iamnovinfar.ketaboon.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ir.iamnovinfar.ketaboon.Database.Database;
import ir.iamnovinfar.ketaboon.R;
import ir.iamnovinfar.ketaboon.adaptor.RecyclerviewProfileFragment;
import ir.iamnovinfar.ketaboon.model.Person;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Profilefragment extends Fragment {

    TextView t1,t2;
    View view;
    RecyclerviewProfileFragment fragment;
    RecyclerView recyclerView;
    List<Person> personList;
    RelativeLayout relativeLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_fragment, container, false);
        setnameonrofile();
        setrecyclerviewonprofile();
        if (personList.isEmpty()){
            removebackgroundrec();
        }else {
            showbackgroundrec();
        }

        return view;
    }


    private void setnameonrofile(){

        t1 = (TextView) view.findViewById(R.id.txt_name);
        t2 = (TextView) view.findViewById(R.id.txt_shoghl);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        String ali = sharedPreferences.getString("usr_name", null);
        String shoghl = sharedPreferences.getString("shoghl", null);
        if (ali != null) {
            t1.setText(ali);
            t2.setText(shoghl);

        }

    }



    private void setrecyclerviewonprofile(){
        recyclerView = (RecyclerView) view.findViewById(R.id.rec_2_id);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        Database d=new Database(getActivity());
        personList=d.getallfavperson();
        fragment=new RecyclerviewProfileFragment(getActivity(),personList);
        recyclerView.setAdapter(fragment);

    }

    public void showbackgroundrec(){
        relativeLayout=view.findViewById(R.id.amirnovin);
        recyclerView.setVisibility(View.VISIBLE);
        relativeLayout.setVisibility(View.GONE);

    }

    public void removebackgroundrec(){
        relativeLayout=view.findViewById(R.id.amirnovin);
        recyclerView.setVisibility(View.GONE);
        relativeLayout.setVisibility(View.VISIBLE);



    }

}
