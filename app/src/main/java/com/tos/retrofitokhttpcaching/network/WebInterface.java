package com.tos.retrofitokhttpcaching.network;


import com.tos.retrofitokhttpcaching.model.photo.PhotoData;
import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.model.question.QuestionData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebInterface {

    @GET(WebMethod.POST_DATA)
    Call<List<PostData>> getPostData();

    @GET(WebMethod.PHOTO_DATA)
    Call<List<PhotoData>> getPhotoData();

    @GET(WebMethod.QUESTION_DATA)
    Call<QuestionData> getQuestionData(@Query("page") String page, @Query("site") String sites);


}
