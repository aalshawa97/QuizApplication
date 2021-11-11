package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btStartQuiz = findViewById(R.id.btStartQuiz);

        btStartQuiz.setOnClickListener(v -> {
            startActivity(new Intent(this, ContainerActivity.class));
        });
    }
}