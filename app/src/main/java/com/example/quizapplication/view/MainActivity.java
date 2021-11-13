package com.example.quizapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

        Button btResults = findViewById(R.id.btResults);

        btResults.setOnClickListener(v -> {
            //Intent i = new Intent(MainActivity.this,Results.class);
            //startActivity(i);
/*
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.container,Results.class,"Results");
            transaction.addToBackStack(null);
            transaction.commit();
*/
            //startActivity(new Intent(this, Results.class));
        });
    }
}