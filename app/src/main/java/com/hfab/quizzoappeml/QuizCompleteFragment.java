package com.hfab.quizzoappeml;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class QuizCompleteFragment extends Fragment {


    private static final double PASSABLE_SCORE = .70; // The score the user has to pass
    private TextView tvResults; // Textview that will change

    private float score; // Score the user had when they completed the quiz

    // KEYS
    private static final String SCORE_KEY = "score";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_complete, container, false);

        tvResults = view.findViewById(R.id.tv_results);

        score = QuizCompleteFragmentArgs.fromBundle(requireArguments()).getUserScore();

        if(savedInstanceState != null)
        {
            score = savedInstanceState.getFloat(SCORE_KEY);
        }


        if (score > PASSABLE_SCORE)
        {
            tvResults.setText(R.string.txt_success);
        }

        else
        {
            tvResults.setText(R.string.txt_failure);
        }

        return view;
    }
}