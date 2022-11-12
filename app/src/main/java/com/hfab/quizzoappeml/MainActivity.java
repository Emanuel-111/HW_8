package com.hfab.quizzoappeml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * @author Emanuel "Manny" Luna
 *
 * This app allows the user to be quizzed with a couple questions built into the
 * program. As well as being able to add their own questions.
 *
 * If the user gets a 70% or higher, they pass the quiz.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}