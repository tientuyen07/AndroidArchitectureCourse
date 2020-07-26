package com.techyourchance.mvc.screens.questionslist;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseViewMvc;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListViewMvcImpl extends BaseViewMvc implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {
    private RecyclerView mRecyclerQuestion;
    private QuestionsRecyclerAdapter mAdapter;
    private final List<Listener> listeners = new ArrayList<>(1);

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : listeners) {
            listener.onQuestionClicked(question);
        }
    }

    public QuestionsListViewMvcImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_questions_list, null, false));
        mRecyclerQuestion = findViewById(R.id.lst_questions);
        mRecyclerQuestion.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionsRecyclerAdapter(layoutInflater, this);
        mRecyclerQuestion.setAdapter(mAdapter);
    }

    @Override
    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);
    }
}
