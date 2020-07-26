package com.techyourchance.mvc.screens.questionslist;

import android.view.View;

import com.techyourchance.mvc.questions.Question;

import java.util.List;

public interface QuestionsListViewMvc {
    interface Listener {
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    View getRootView();

    void bindQuestions(List<Question> questions);
}
