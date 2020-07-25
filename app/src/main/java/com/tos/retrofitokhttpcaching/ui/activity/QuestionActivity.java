package com.tos.retrofitokhttpcaching.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.model.question.QuestionData;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;
import com.tos.retrofitokhttpcaching.ui.adapter.PostAdapter;
import com.tos.retrofitokhttpcaching.ui.adapter.QuestionAdapter;
import com.tos.retrofitokhttpcaching.viewmodel.QuestionViewModel;

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

public class QuestionActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    Context context;
    private static final String TAG = "MainActivity";
    QuestionViewModel viewModel;
    QuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        viewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        viewModel.init();
        initView();

    }

    public void initView() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        viewModel.getQuestion().observe(this, new Observer<QuestionData>() {
            @Override
            public void onChanged(QuestionData questionData) {
                progressBar.setVisibility(View.GONE);
                adapter = new QuestionAdapter(context, questionData.getItems());
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(adapter);
            }
        });
    }

}
