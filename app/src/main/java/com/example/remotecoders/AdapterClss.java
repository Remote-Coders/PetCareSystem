package com.example.remotecoders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ListAdapterClss extends RecyclerView.Adapter<ListAdapterClss.ListViewHolder> {
    Context context;
    List<modelClass> mData;
    private ListViewHolder.RecycleViewClickListener clickListener;

    public ListAdapterClss(Context context, List<modelClass> mData) {
        this.context = context;
        this.mData = mData;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        layout= LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false);
        return new ListViewHolder(layout,context,mData,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        int photo=mData.get(position).getPhoto();

        holder.img_photo.setImageResource(photo);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView img_photo;

        public ListViewHolder(@NonNull View itemView,Context context,List<modelClass> mData,RecycleViewClickListener clickListener) {
            super(itemView);
            img_photo = itemView.findViewById(R.id.photo3);
        }

        @Override
        public void onClick(View view) {

        }
        public interface RecycleViewClickListener{

        }
    }
}
