package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent intent = new Intent(this, DisplayMessageActivity.class);

        Button btStartQuiz = findViewById(R.id.btStartQuiz);

        btStartQuiz.setOnClickListener(v -> {
            //startActivity(new Intent(this, ContainerActivity.class));
        });
    }
}