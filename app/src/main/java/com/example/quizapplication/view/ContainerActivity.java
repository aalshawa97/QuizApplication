package com.example.quizapplication.view;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
//import android.content.Intent;

import com.example.quizapplication.R;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        QuestionsFragment nextFragment = new QuestionsFragment();
        launchFragment(nextFragment);
    }

    public void launchFragment(Fragment fragment){
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }

}
