package com.tos.retrofitokhttpcaching.viewmodel;

import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.repository.PostsRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by tarikul on 24/7/20
 */
public class PostsViewModel extends ViewModel {
    private MutableLiveData<List<PostData>> data;
    private PostsRepository repository;

    public PostsViewModel() {
        repository = new PostsRepository();
    }

    public void init() {
        if (this.data != null) {
            return;
        }
        this.data = repository.getPosts();
    }

    public MutableLiveData<List<PostData>> getPosts() {
        return this.data;
    }
}
