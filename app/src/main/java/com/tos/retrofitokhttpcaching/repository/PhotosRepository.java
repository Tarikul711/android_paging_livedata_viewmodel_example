package com.tos.retrofitokhttpcaching.repository;

import com.tos.retrofitokhttpcaching.model.photo.PhotoData;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tarikul on 24/7/20
 */
public class PhotosRepository {
    WebInterface webInterface;

    public PhotosRepository() {
    }

    public MutableLiveData<List<PhotoData>> getPhotos() {
        MutableLiveData<List<PhotoData>> listMutableLiveData = new MutableLiveData<>();
        webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL_PHOTO);
        webInterface.getPhotoData()
                .enqueue(new Callback<List<PhotoData>>() {
                    @Override
                    public void onResponse(Call<List<PhotoData>> call, Response<List<PhotoData>> response) {
                        if (response.code() == 200) {
                            listMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PhotoData>> call, Throwable t) {

                    }
                });
        return listMutableLiveData;
    }
}
