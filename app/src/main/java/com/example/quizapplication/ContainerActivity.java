package com.example.quizapplication;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
//import android.content.Intent;

import android.os.Bundle;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        QuestionsFragment nextFragment = new QuestionsFragment();
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, nextFragment)
                .addToBackStack(null)
                .commit();
    }

    /*
    public void launchFragment(Fragment fragment){
        NextFragment nextFragment = new NextFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.Layout_container, nextFragment, "find this fragment");
                .addToBackStack(null)
                .commit();

    }
    */
}
