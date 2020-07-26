package com.techyourchance.mvc.screens.questionslist;

import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.ViewMvc;

public interface QuestionsListItemViewMvc extends ViewMvc {
    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    void bindQuestion(Question question);

    interface Listener {
        void onQuestionClicked(Question question);
    }
}
