package ir.iamnovinfar.ketaboon.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import ir.iamnovinfar.ketaboon.R;
import ir.iamnovinfar.ketaboon.activity.ContentActivity;
import ir.iamnovinfar.ketaboon.model.Person;
import com.squareup.picasso.Picasso;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerviewProfileFragment extends RecyclerView.Adapter {
    Context context;
    List<Person> personList;

    public RecyclerviewProfileFragment(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlayoutpofile, parent, false);
        return new Itemviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        final Itemviewholder itemviewholder = (Itemviewholder) holder;

        itemviewholder.name.setText(personList.get(position).getName());
        Picasso.get().load(personList.get(position).getImage())
                .error(R.drawable.user_error)
                .resize(128, 128)
                .into(itemviewholder.imageView);
        itemviewholder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ContentActivity.class);
                intent.putExtra("image", personList.get(position).getImage());
                intent.putExtra("name", personList.get(position).getName());
                intent.putExtra("field", personList.get(position).getField());
                intent.putExtra("disk", personList.get(position).getDisc());
                intent.putExtra("id", personList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    public class Itemviewholder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView name;
        CardView cardView;

        public Itemviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_personamir22);
            name = itemView.findViewById(R.id.txt_name_title22);
            cardView = itemView.findViewById(R.id.profile_id_rec);

        }


    }


}
