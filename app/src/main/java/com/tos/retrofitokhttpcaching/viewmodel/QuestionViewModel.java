package com.tos.retrofitokhttpcaching.viewmodel;

import com.tos.retrofitokhttpcaching.model.question.Item;
import com.tos.retrofitokhttpcaching.model.question.QuestionData;
import com.tos.retrofitokhttpcaching.paging.QuestionDataFactory;
import com.tos.retrofitokhttpcaching.paging.QuestionDataSource;
import com.tos.retrofitokhttpcaching.repository.QuestionRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

/**
 * Created by tarikul on 24/7/20
 */
public class QuestionViewModel extends ViewModel {
    public LiveData<PagedList<Item>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;

    public QuestionViewModel() {
        QuestionDataFactory factory = new QuestionDataFactory();
        liveDataSource = factory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder()).setEnablePlaceholders(false)
                        .build();
        itemPagedList = (new LivePagedListBuilder(factory, config)).build();
    }


}
