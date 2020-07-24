package com.tos.retrofitokhttpcaching.viewmodel;

import com.tos.retrofitokhttpcaching.model.question.QuestionData;
import com.tos.retrofitokhttpcaching.repository.QuestionRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by tarikul on 24/7/20
 */
public class QuestionViewModel extends ViewModel {
    MutableLiveData<QuestionData> data;
    QuestionRepository repository;

    public QuestionViewModel() {
        repository = new QuestionRepository();
    }

    public void init() {
        if (this.data != null) {
            return;
        }
        data = repository.getQuestions();
    }

    public MutableLiveData<QuestionData> getQuestion() {
        return this.data;
    }
}