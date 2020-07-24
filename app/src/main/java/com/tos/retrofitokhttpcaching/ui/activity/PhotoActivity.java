package com.tos.retrofitokhttpcaching.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.ui.adapter.PhotoAdapter;
import com.tos.retrofitokhttpcaching.network.WebInterface;
import com.tos.retrofitokhttpcaching.viewmodel.PhotosViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    private WebInterface webInterface;
    Context context;
    private static final String TAG = "PhotoActivity";
    PhotosViewModel viewModel;
    PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        viewModel = new ViewModelProvider(this).get(PhotosViewModel.class);
        viewModel.init();
        initView();

    }

    public void initView() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        viewModel.getPhotos().observe(this, photoData -> {
            progressBar.setVisibility(View.GONE);
            photoAdapter = new PhotoAdapter(context, photoData);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(photoAdapter);
        });
    }

}
