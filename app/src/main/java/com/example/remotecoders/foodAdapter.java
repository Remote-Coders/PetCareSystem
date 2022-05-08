package com.example.remotecoders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class foodAdapter extends FirebaseRecyclerAdapter<ModelFood,foodAdapter.foodViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public foodAdapter(@NonNull FirebaseRecyclerOptions<ModelFood> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull foodViewHolder holder, int position, @NonNull ModelFood model) {
        holder.food_t1.setText(model.getName());
        holder.food_t2.setText(model.getDescription());
        holder.food_t3.setText(String.valueOf(model.getPrice()));
        Glide.with(holder.food_img.getContext()).load(model.getImgurl()).into(holder.food_img);
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.foodsinglerow,parent,false);
        return new foodViewHolder(view);
    }


    class foodViewHolder extends RecyclerView.ViewHolder{

        CircleImageView food_img;
        TextView food_t1,food_t2,food_t3;

        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            food_img=(CircleImageView) itemView.findViewById(R.id.food_img1);
            food_t1=(TextView) itemView.findViewById(R.id.food_t1);
            food_t2=(TextView) itemView.findViewById(R.id.food_t2);
            food_t3=(TextView) itemView.findViewById(R.id.food_t3);
        }
    }
}
