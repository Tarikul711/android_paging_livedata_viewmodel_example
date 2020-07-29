package com.tos.retrofitokhttpcaching.paging;

import com.tos.retrofitokhttpcaching.model.question.Item;
import com.tos.retrofitokhttpcaching.model.question.QuestionData;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tarikul on 25/7/20
 */
public class QuestionDataSource extends PageKeyedDataSource<Integer, Item> {

    public static final int PAGE_SIZE = 50;
    private static final int FIRST_PAGE = 1;
    private static final String SITE_NAME = "stackoverflow";
    WebInterface webInterface;

    public QuestionDataSource() {
        webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL_STACK_OVERFLOW);
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Item> callback) {
        webInterface.getQuestionData(String.valueOf(FIRST_PAGE), SITE_NAME)
                .enqueue(new Callback<QuestionData>() {
                    @Override
                    public void onResponse(@NotNull Call<QuestionData> call, @NotNull Response<QuestionData> response) {
                        if (response.code() == 200) {
                            assert response.body() != null;
                            callback.onResult(response.body().getItems(), null, FIRST_PAGE + 1);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<QuestionData> call, @NotNull Throwable t) {

                    }

                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Item> callback) {
        webInterface.getQuestionData(String.valueOf(params.key), SITE_NAME)
                .enqueue(new Callback<QuestionData>() {
                    @Override
                    public void onResponse(@NotNull Call<QuestionData> call, @NotNull Response<QuestionData> response) {
                        if (response.code() == 200) {
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            assert response.body() != null;
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<QuestionData> call, @NotNull Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Item> callback) {
        webInterface.getQuestionData(String.valueOf(params.key), SITE_NAME)
                .enqueue(new Callback<QuestionData>() {
                    @Override
                    public void onResponse(@NotNull Call<QuestionData> call, @NotNull Response<QuestionData> response) {
                        if (response.code() == 200) {
                            Integer key = (params.key > 1) ? params.key + 1 : null;
                            assert response.body() != null;
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<QuestionData> call, @NotNull Throwable t) {

                    }
                });
    }
}
