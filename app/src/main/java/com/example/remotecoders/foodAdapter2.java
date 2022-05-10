package com.example.remotecoders;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class foodAdapter2 extends FirebaseRecyclerAdapter<ModelFood,foodAdapter2.foodViewHolder2> {


    public foodAdapter2(@NonNull FirebaseRecyclerOptions<ModelFood> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull foodViewHolder2 holder, int position, @NonNull ModelFood model) {
        holder.food_t1.setText(model.getName());
        Glide.with(holder.food_img.getContext()).load(model.getImgurl()).into(holder.food_img);

    }

    @NonNull
    @Override
    public foodAdapter2.foodViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodsinglebox,parent,false);

        return new foodAdapter2.foodViewHolder2(view);
    }


    public class foodViewHolder2 extends RecyclerView.ViewHolder {
        CircleImageView food_img;
        TextView food_t1;
//        ImageButton editbtn,dltbtn;

        public foodViewHolder2(@NonNull View itemView) {
            super(itemView);
            food_img=(CircleImageView) itemView.findViewById(R.id.cus_food_img1);
            food_t1=(TextView) itemView.findViewById(R.id.cus_food_t1);


        }
    }
}



