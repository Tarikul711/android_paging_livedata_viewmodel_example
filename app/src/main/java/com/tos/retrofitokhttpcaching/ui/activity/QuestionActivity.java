package com.tos.retrofitokhttpcaching.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.model.question.Item;
import com.tos.retrofitokhttpcaching.model.question.QuestionData;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;
import com.tos.retrofitokhttpcaching.ui.adapter.PostAdapter;
import com.tos.retrofitokhttpcaching.ui.adapter.QuestionAdapter;
import com.tos.retrofitokhttpcaching.viewmodel.QuestionViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    Context context;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initView();

    }

    public void initView() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        QuestionViewModel itemViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        final QuestionAdapter adapter = new QuestionAdapter(this);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(@Nullable PagedList<Item> items) {
                progressBar.setVisibility(View.GONE);
                adapter.submitList(items);
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
