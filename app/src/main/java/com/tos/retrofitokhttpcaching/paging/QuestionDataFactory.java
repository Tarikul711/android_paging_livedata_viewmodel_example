package com.tos.retrofitokhttpcaching.paging;

import com.tos.retrofitokhttpcaching.model.question.Item;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

/**
 * Created by tarikul on 25/7/20
 */
public class QuestionDataFactory extends DataSource.Factory {
    private MutableLiveData<PageKeyedDataSource<Integer, Item>> data = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource create() {
        QuestionDataSource questionDataSource = new QuestionDataSource();
        data.postValue(questionDataSource);
        return questionDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Item>> getItemLiveDataSource() {
        return data;
    }
}
