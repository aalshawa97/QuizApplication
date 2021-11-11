package com.example.quizapplication.model;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionService extends Service {
    public static int COUNTER = 0;

    public QuestionService() {
    }

    public static List<Question> getQuestions(){
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("What's your name?", "A", new ArrayList<>(Arrays.asList("A", "B", "C", "D"))));
        questionList.add(new Question("Question2?", "A", new ArrayList<>(Arrays.asList("A", "B", "C", "D"))));
        questionList.add(new Question("Question3?", "A", new ArrayList<>(Arrays.asList("A", "B", "C", "D"))));

        return questionList;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}