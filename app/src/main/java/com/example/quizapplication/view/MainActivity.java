package com.example.quizapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import com.example.quizapplication.R;
import com.example.quizapplication.view.ContainerActivity;

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