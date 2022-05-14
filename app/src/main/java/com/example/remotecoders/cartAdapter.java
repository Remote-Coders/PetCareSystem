package com.example.remotecoders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class cartAdapter extends FirebaseRecyclerAdapter<ModelFood,cartAdapter.cartViewHolder> {


    public cartAdapter(@NonNull FirebaseRecyclerOptions<ModelFood> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull cartViewHolder holder, int position, @NonNull ModelFood model) {
        holder.cart_t1.setText(model.getName());
        holder.cart_t2.setText(String.valueOf(model.getPrice()));
        holder.cart_t3.setText(String.valueOf(model.getQuantity()));

        Glide.with(holder.cart_img1.getContext())
                .load(model.getImgurl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.cart_img1);
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartsinglerow,parent,false);
        return new cartAdapter.cartViewHolder(view);
    }

    public class cartViewHolder extends RecyclerView.ViewHolder{
        CircleImageView cart_img1;
        TextView cart_t1,cart_t2,cart_t3;

        public cartViewHolder(@NonNull View itemView) {
            super(itemView);
            cart_img1=(CircleImageView) itemView.findViewById(R.id.cart_img1);
            cart_t1=(TextView) itemView.findViewById(R.id.cart_t1);
            cart_t2=(TextView) itemView.findViewById(R.id.cart_t2);
            cart_t3=(TextView) itemView.findViewById(R.id.cart_t3);

        }
    }
}
