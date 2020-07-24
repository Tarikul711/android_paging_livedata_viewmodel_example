package com.tos.retrofitokhttpcaching.repository;

import com.tos.retrofitokhttpcaching.model.question.QuestionData;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tarikul on 24/7/20
 */
public class QuestionRepository {
    WebInterface webInterface;

    public MutableLiveData<QuestionData> getQuestions() {
        MutableLiveData<QuestionData> dataMutableLiveData = new MutableLiveData<>();
        webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL_STACK_OVERFLOW);
        webInterface.getQuestionData("1", "stackoverflow")
                .enqueue(new Callback<QuestionData>() {
                    @Override
                    public void onResponse(@NotNull Call<QuestionData> call, @NotNull Response<QuestionData> response) {
                        if (response.code() == 200) {
                            dataMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<QuestionData> call, @NotNull Throwable t) {

                    }
                });
        return dataMutableLiveData;
    }
}
