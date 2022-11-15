package com.hfab.quizzoappeml;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class AddQuestionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_add_question, container, false);

        // All aspects of things
        TextView txtGenre = view.findViewById(R.id.txt_genre);
        TextView txtQuestion = view.findViewById(R.id.txt_question);
        TextView txtChoice1 = view.findViewById(R.id.txt_choice1);
        TextView txtChoice2 = view.findViewById(R.id.txt_choice2);
        TextView txtChoice3 = view.findViewById(R.id.txt_choice3);
        TextView txtChoice4 = view.findViewById(R.id.txt_choice4);
        TextView txtChoice5 = view.findViewById(R.id.txt_choice5);
        Spinner spAnswer = view.findViewById(R.id.sp_answer);
        TextView txtFunFact = view.findViewById(R.id.txt_fun_fact);
        Button btnAddQuestion = view.findViewById(R.id.btn_add_new_question);

        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer;

                ArrayList<String> choices = new ArrayList<String>();

                String genre = txtGenre.getText().toString();
                String question = txtQuestion.getText().toString();
                String choice1 = txtChoice1.getText().toString();
                String choice2 = txtChoice2.getText().toString();
                String choice3 = txtChoice3.getText().toString();
                String choice4 = txtChoice4.getText().toString();
                String choice5 = txtChoice5.getText().toString();
                String funFact = txtFunFact.getText().toString();

                // Check if all Strings have been filled with anything
                if (!genre.toString().equals("") && question.toString().equals("") &&
                        choice1.toString().equals("") && choice2.toString().equals("") &&
                        funFact.toString().equals(""))
                {
                    if (!choice1.toString().equals(""))
                    {
                        choices.add(choice1);
                    }

                    else if (!choice2.toString().equals(""))
                    {
                        choices.add(choice2);
                    }

                    else if (!choice3.toString().equals(""))
                    {
                        choices.add(choice3);
                    }

                    else if (!choice4.toString().equals(""))
                    {
                        choices.add(choice4);
                    }

                    else if (!choice5.toString().equals(""))
                    {
                        choices.add(choice5);
                    }



                    if (spAnswer.getSelectedItem().toString().equals("Choice 1"))
                    {
                        answer = choice1;
                    }

                    else if (spAnswer.getSelectedItem().toString().equals("Choice 2"))
                    {
                        answer = choice2;
                    }

                    else if (spAnswer.getSelectedItem().toString().equals("Choice 3"))
                    {
                        answer = choice3;
                    }

                    else if (spAnswer.getSelectedItem().toString().equals("Choice 4"))
                    {
                        answer = choice4;
                    }

                    else
                    {
                        answer = choice5;
                    }

                    QuestionDatabase.getDatabase().addQuestion(genre, question, choices, answer, funFact);

                    txtGenre.setText("");
                    txtQuestion.setText("");
                    txtChoice1.setText("");
                    txtChoice2.setText("");
                    txtChoice3.setText("");
                    txtChoice4.setText("");
                    txtChoice5.setText("");
                    txtFunFact.setText("");
                    choices.removeAll(choices);


                }

            else
                {
                    Context context = getContext().getApplicationContext();
                    CharSequence text = "Please type in two choices";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });

        return view;
    }
}