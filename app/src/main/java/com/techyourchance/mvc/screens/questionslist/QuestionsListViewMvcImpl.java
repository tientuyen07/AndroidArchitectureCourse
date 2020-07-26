package com.techyourchance.mvc.screens.questionslist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListViewMvcImpl implements QuestionsListViewMvc, QuestionsListAdapter.OnQuestionClickListener {
    private ListView mLstQuestion;
    private QuestionsListAdapter mQuestionsListAdapter;
    private final View mRootView;
    private final List<Listener> listeners = new ArrayList<>(1);

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : listeners) {
            listener.onQuestionClicked(question);
        }
    }


    public QuestionsListViewMvcImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        mRootView = layoutInflater.inflate(R.layout.layout_questions_list, null, false);
        mLstQuestion = findViewById(R.id.lst_questions);
        mQuestionsListAdapter = new QuestionsListAdapter(getContext(), this);
        mLstQuestion.setAdapter(mQuestionsListAdapter);
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
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
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mQuestionsListAdapter.clear();
        mQuestionsListAdapter.addAll(questions);
        mQuestionsListAdapter.notifyDataSetChanged();
    }
}
