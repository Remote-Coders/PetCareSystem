package com.example.remotecoders;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class foodAdapter2 extends FirebaseRecyclerAdapter<ModelFood,foodAdapter2.foodViewHolder2> {
    DatabaseReference dbRef;
    ModelFood foodobj;

    public foodAdapter2(@NonNull FirebaseRecyclerOptions<ModelFood> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull foodViewHolder2 holder, int position, @NonNull ModelFood model) {
        holder.food_t1.setText(model.getName());
//        Glide.with(holder.food_img.getContext()).load(model.getImgurl()).into(holder.food_img);
        Glide.with(holder.food_img.getContext())
                .load(model.getImgurl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.food_img);

        holder.food_view_rela.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.food_img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_main11))
                        .create();

                View myview=dialogPlus.getHolderView();
                final ImageView imgurl=myview.findViewById(R.id.im_food);
                final TextView name=myview.findViewById(R.id.tv_foodtype);
                final TextView description=myview.findViewById(R.id.tv_food_detail);
                final TextView price=myview.findViewById(R.id.tv_oldprice);
                final EditText quantity=myview.findViewById(R.id.et_quantity);
                final TextView imageurl=myview.findViewById(R.id.tv_imgurl);

                Button buttonCart=myview.findViewById(R.id.buttonCart);


                Glide.with(imgurl.getContext())
                        .load(model.getImgurl())
                        .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                        .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                        .into(imgurl);

                name.setText(model.getName());
                description.setText(model.getDescription());
                price.setText(String.valueOf(model.getPrice()));
                imageurl.setText(model.getImgurl());

                dialogPlus.show();

                buttonCart.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        dbRef = FirebaseDatabase.getInstance().getReference().child("Cart");
                        foodobj=new ModelFood();

                        try{

                            foodobj.setName(name.getText().toString().trim());
                            foodobj.setPrice(Integer.parseInt(price.getText().toString().trim()));
                            foodobj.setQuantity(Integer.parseInt(quantity.getText().toString().trim()));
                            foodobj.setImgurl(imageurl.getText().toString().trim());

                            dbRef.push().setValue(foodobj);

                            System.out.println(quantity);

                        }catch(Exception e){
//                            Toast.makeText(getApplicationContext(),"Invalid price",Toast.LENGTH_SHORT).show();
                            System.out.println(e);
                        }
                    }
                });

            }
        });

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
        RelativeLayout food_view_rela;
//        Button buttonCart;

        public foodViewHolder2(@NonNull View itemView) {
            super(itemView);
            food_img=(CircleImageView) itemView.findViewById(R.id.cus_food_img1);
            food_t1=(TextView) itemView.findViewById(R.id.cus_food_t1);
            food_view_rela=(RelativeLayout) itemView.findViewById(R.id.food_view_rela);
//            buttonCart=(Button) itemView.findViewById(R.id.buttonCart);


        }
    }
}



