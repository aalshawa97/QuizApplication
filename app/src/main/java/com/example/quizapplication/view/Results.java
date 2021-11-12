package com.example.quizapplication.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.quizapplication.R;
import com.example.quizapplication.model.Question;
import com.example.quizapplication.model.QuestionService;

import java.util.ArrayList;
import java.util.List;

public class Results extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> answers = getArguments().getStringArrayList("01");

        List<Question> questionList = QuestionService.getQuestions();

        int score = 0;

        for(int i = 0; i < questionList.size(); i++){
            Question currentQuestion = questionList.get(i);
            String ans = answers.get(i);
            if(ans.equals(currentQuestion.getAnswer())){
                score++;
                Toast.makeText(this.getContext(), "Correct answer!", Toast.LENGTH_LONG);
            }
        }
    }
}
