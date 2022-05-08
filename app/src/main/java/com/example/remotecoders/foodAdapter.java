package com.example.remotecoders;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class foodAdapter extends FirebaseRecyclerAdapter<ModelFood,foodAdapter.foodViewHolder> {


    public foodAdapter(@NonNull FirebaseRecyclerOptions<ModelFood> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull foodAdapter.foodViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull ModelFood model) {

        holder.food_t1.setText(model.getName());
        holder.food_t2.setText(model.getDescription());
        holder.food_t3.setText(String.valueOf(model.getPrice()));
        Glide.with(holder.food_img.getContext()).load(model.getImgurl()).into(holder.food_img);

        holder.editbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.food_img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.food_update_popup))

                        .create();

                View myview=dialogPlus.getHolderView();
                final EditText category=myview.findViewById(R.id.up_category);
                final EditText name=myview.findViewById(R.id.up_foodname);
                final EditText price=myview.findViewById(R.id.up_price);
                final EditText description=myview.findViewById(R.id.up_fooddescription);
               final EditText imageurl=myview.findViewById(R.id.up_imgurl);

                Button btn_foodupdate =myview.findViewById(R.id.btn_foodupdate);

                category.setText(model.getName());
                name.setText(model.getName());
                price.setText(String.valueOf(model.getPrice()));
                description.setText(model.getDescription());
                imageurl.setText(model.getImgurl());

                dialogPlus.show();

                btn_foodupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("category",category.getText().toString());
                        map.put("name",name.getText().toString());
                        map.put("description",description.getText().toString());
                        map.put("price",Integer.parseInt(price.getText().toString()));
                        map.put("imageurl",imageurl.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Food")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });

        holder.dltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.food_img.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Food")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodsinglerow,parent,false);

        return new foodAdapter.foodViewHolder(view);
    }

    public class foodViewHolder extends RecyclerView.ViewHolder {
        CircleImageView food_img;
        TextView food_t1,food_t2,food_t3;

        ImageButton editbtn,dltbtn;

        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            food_img=(CircleImageView) itemView.findViewById(R.id.food_img1);
            food_t1=(TextView) itemView.findViewById(R.id.food_t1);
            food_t2=(TextView) itemView.findViewById(R.id.food_t2);
            food_t3=(TextView) itemView.findViewById(R.id.food_t3);

            editbtn=(ImageButton)itemView.findViewById(R.id.editbtn);
            dltbtn=(ImageButton)itemView.findViewById(R.id.dltbtn);
        }
    }
}



