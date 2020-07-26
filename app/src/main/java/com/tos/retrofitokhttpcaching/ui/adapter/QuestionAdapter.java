package com.tos.retrofitokhttpcaching.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.model.question.Item;
import com.tos.retrofitokhttpcaching.model.question.QuestionData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter extends PagedListAdapter<Item, QuestionAdapter.ViewHolder> {

    private Context context;
    private List<Item> items;


    public QuestionAdapter(Context context) {
        super(QuestionData.CALLBACK);
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
        Item item = items.get(position);

        holder.tvText.setText(item.getTitle());
        holder.ivImage.setVisibility(View.GONE);
       /* Glide.with(context)
                .load(item.getUrl())
                .into(holder.ivImage);*/
        holder.ivImage.setTag(item);
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
