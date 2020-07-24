package com.tos.retrofitokhttpcaching.viewmodel;

import com.tos.retrofitokhttpcaching.model.photo.PhotoData;
import com.tos.retrofitokhttpcaching.repository.PhotoListRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by tarikul on 24/7/20
 */
public class PhotoListViewModel extends ViewModel {
    private MutableLiveData<List<PhotoData>> data;
    private PhotoListRepository repository;

    public PhotoListViewModel() {
        repository = new PhotoListRepository();
    }

    public void init() {
        if (this.data != null) {
            return;
        }
        this.data = repository.getPhotos();
    }

    public MutableLiveData<List<PhotoData>> getPhotos() {
        return this.data;
    }
}
