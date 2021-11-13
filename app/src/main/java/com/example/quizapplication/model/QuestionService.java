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

        questionList.add(new Question("What's your name?", "Abdullah Mutaz Alshawa", new ArrayList<>(Arrays.asList("Abdullah Mutaz Alshawa", "Muhammad Ali", "Khabib Nurmagomedov", "Muhammed Saleh"))));
        questionList.add(new Question("Where were you born?", "Portland", new ArrayList<>(Arrays.asList("Boston", "Portland", "Mecca", "Gaza"))));
        questionList.add(new Question("What was your first car?", "Ford", new ArrayList<>(Arrays.asList("Nissan", "Ford", "Toyota", "Kia"))));

        return questionList;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

//Unit testing
// 1. Test for serializing the API data
// 2. Testing for the API itself for every call
// UI success ->
// 400 ->
// 500 -> Internet