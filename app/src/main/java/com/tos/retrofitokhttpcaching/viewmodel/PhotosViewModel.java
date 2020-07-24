package com.tos.retrofitokhttpcaching.viewmodel;

import com.tos.retrofitokhttpcaching.model.photo.PhotoData;
import com.tos.retrofitokhttpcaching.repository.PhotosRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by tarikul on 24/7/20
 */
public class PhotosViewModel extends ViewModel {
    private MutableLiveData<List<PhotoData>> data;
    private PhotosRepository repository;

    public PhotosViewModel() {
        repository = new PhotosRepository();
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
