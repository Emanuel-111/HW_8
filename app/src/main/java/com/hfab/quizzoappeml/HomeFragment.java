package com.hfab.quizzoappeml;

import static com.hfab.quizzoappeml.R.id.action_homeFragment_to_addQuestionFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    ArrayList<Question> genre = new ArrayList<Question>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Question> allQuestions = new ArrayList<Question>();

        QuestionDatabase.getDatabase().allInitialQuestions(allQuestions);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnPractice = view.findViewById(R.id.btn_practice);
        Button btnAddQuestion = view.findViewById(R.id.btn_add_new_question);

        Spinner genres = view.findViewById(R.id.sp_genres);
        genres.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, genre);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genres.setAdapter(ad);

        btnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_practiceFragment);
            }
        });

        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(action_homeFragment_to_addQuestionFragment);
            }
        });


        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}