package com.tos.retrofitokhttpcaching.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.ui.adapter.PhotoAdapter;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;
import com.tos.retrofitokhttpcaching.model.photo.PhotoData;
import com.tos.retrofitokhttpcaching.viewmodel.PhotoListViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    private WebInterface webInterface;
    Context context;
    private static final String TAG = "PhotoActivity";
    PhotoListViewModel viewModel;
    PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        viewModel = new ViewModelProvider(this).get(PhotoListViewModel.class);
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
