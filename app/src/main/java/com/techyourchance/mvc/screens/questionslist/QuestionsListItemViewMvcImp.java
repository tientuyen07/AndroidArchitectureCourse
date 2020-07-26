package com.techyourchance.mvc.screens.questionslist;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseObservableViewMvc;

public class QuestionsListItemViewMvcImp extends BaseObservableViewMvc<QuestionsListItemViewMvc.Listener> implements QuestionsListItemViewMvc {
    private final TextView mTxtView;
    private Question mQuestion;

    public QuestionsListItemViewMvcImp(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTxtView = findViewById(R.id.txt_title);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : getListener()) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    @Override
    public void bindQuestion(Question question) {
        mQuestion = question;
        mTxtView.setText(question.getTitle());
    }
}
