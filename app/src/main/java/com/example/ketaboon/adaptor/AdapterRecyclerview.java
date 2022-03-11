package com.example.ketaboon.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ketaboon.R;
import com.example.ketaboon.activity.ContentActivity;
import com.example.ketaboon.model.Person;
import com.squareup.picasso.Picasso;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterRecyclerview extends RecyclerView.Adapter {
    Context context;
    List<Person> personList;

    public AdapterRecyclerview(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlayout,parent,false);
        return new Itemviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        final Itemviewholder itemviewholder= (Itemviewholder) holder;
        itemviewholder.linearLayout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.animforrec));
        itemviewholder.name.setText(personList.get(position).getName());
        itemviewholder.field.setText(personList.get(position).getField());
        Picasso.get().load(personList.get(position).getImage())
                .resize(128,128)
                .into(itemviewholder.imageView);
        itemviewholder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), ContentActivity.class);
                intent.putExtra("image",personList.get(position).getImage());
                intent.putExtra("name",personList.get(position).getName());
                intent.putExtra("field",personList.get(position).getField());
                intent.putExtra("disk",personList.get(position).getDisc());
                intent.putExtra("id",personList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void filterlist(List<Person> filterlist) {
        personList=filterlist;
        notifyDataSetChanged();
    }


    public class Itemviewholder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView name,field;
        LinearLayout linearLayout;

        public Itemviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_personamir);
            name=itemView.findViewById(R.id.txt_name_title);
            field=itemView.findViewById(R.id.txt_shoghl);
             linearLayout=itemView.findViewById(R.id.itemrecv);

        }



    }


}
