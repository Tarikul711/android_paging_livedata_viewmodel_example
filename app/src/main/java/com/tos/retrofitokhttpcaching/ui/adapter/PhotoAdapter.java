package com.tos.retrofitokhttpcaching.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.model.photo.PhotoData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private Context context;
    private List<PhotoData> items;


    public PhotoAdapter(Context context, List<PhotoData> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhotoData item = items.get(position);

        holder.tvText.setText(String.format("Author: %s", item.getAuthor()));
        Glide.with(context)
                .load(item.getDownloadUrl())
                .into(holder.ivImage);
        holder.tvText.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvText;
        AppCompatImageView ivImage;

        ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvText = itemView.findViewById(R.id.tvText);

        }

    }
}
