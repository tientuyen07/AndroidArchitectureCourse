package com.techyourchance.mvc.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvcImpl;

public class ViewMvcFactory {
    private final LayoutInflater layoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public QuestionsListViewMvc getQuestionsListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListViewMvcImpl(layoutInflater, parent);
    }
}
