package com.techyourchance.mvc.screens.questionslist;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseViewMvc;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListItemViewMvcImp extends BaseViewMvc implements QuestionsListItemViewMvc {
    private final TextView mTxtView;
    private final List<Listener> mListeners = new ArrayList<>(1);
    private Question mQuestion;

    public QuestionsListItemViewMvcImp(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTxtView = findViewById(R.id.txt_title);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : mListeners) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void bindQuestion(Question question) {
        mQuestion = question;
        mTxtView.setText(question.getTitle());
    }
}
