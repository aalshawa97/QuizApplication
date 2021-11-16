package com.example.quizapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.example.quizapplication.R;
import com.example.quizapplication.view.ContainerActivity;

public class MainActivity extends AppCompatActivity {

    public static void addFragmentToActivity(FragmentManager manager, Fragment fragment, int frameId) {

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(frameId, fragment, " ");
        transaction.commit();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getApplicationContext(), "Hello and welcome to the quiz application!", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btStartQuiz = findViewById(R.id.btStartQuiz);

        btStartQuiz.setOnClickListener(v -> {
            startActivity(new Intent(this, ContainerActivity.class));
        });

        Button btResults = findViewById(R.id.btResults);

        try{
            btResults.setOnClickListener(v -> {
                //Intent i = new Intent(MainActivity.this,Results.class);
                //startActivity(i);

                Fragment mSelectedFragment = null;
                mSelectedFragment = new Fragment();
                mSelectedFragment = new Results();

                FragmentManager manager = getFragmentManager();
                addFragmentToActivity(manager,mSelectedFragment, R.id.container);
            /*
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.container,Results,"Results");
            transaction.addToBackStack(null);
            transaction.commit();
            */

                //startActivity(new Intent(this, Results.class));
            });
        }
        catch (Exception e){

        }

    }
}