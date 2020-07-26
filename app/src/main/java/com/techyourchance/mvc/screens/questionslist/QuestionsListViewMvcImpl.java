package com.techyourchance.mvc.screens.questionslist;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseObservableViewMvc;

import java.util.List;

public class QuestionsListViewMvcImpl extends BaseObservableViewMvc<QuestionsListViewMvc.Listener> implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {
    private RecyclerView mRecyclerQuestion;
    private QuestionsRecyclerAdapter mAdapter;

    public QuestionsListViewMvcImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_questions_list, null, false));
        mRecyclerQuestion = findViewById(R.id.lst_questions);
        mRecyclerQuestion.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionsRecyclerAdapter(layoutInflater, this);
        mRecyclerQuestion.setAdapter(mAdapter);
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : getListener()) {
            listener.onQuestionClicked(question);
        }
    }
}
