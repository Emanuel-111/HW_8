package com.hfab.quizzoappeml;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * @author Emanuel Luna
 *
 * PraticeFragment will quiz the user with questions that are added
 * to the quiz by default as well as the user created questions.
 */
public class PracticeFragment extends Fragment {

    private ArrayList<Question> allQuestionsRemaining = new ArrayList<Question>();

    private int currentScore = 0;
    private int userScore = 0;

    private int totalLengthOfScore = 0;
    private int totalScore = 0;

    private RadioButton choiceMade;

    private RadioButton radioChoice1;
    private RadioButton radioChoice2;
    private RadioButton radioChoice3;
    private RadioButton radioChoice4;
    private RadioButton radioChoice5;

    private TextView question;
    private TextView numOfQuestionsRemaining;

    private int radioButtonCheckedId;

    private int randomNum;

    private static final String USER_SCORE_KEY = "userScore";
    private static final String TOTAL_SCORE_KEY = "totalScore";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        // Only used if the orientation is flipped
        if(savedInstanceState != null)
        {
            userScore = savedInstanceState.getInt(USER_SCORE_KEY);
            totalScore = savedInstanceState.getInt(TOTAL_SCORE_KEY);

        }

        QuestionDatabase.getDatabase().allInitialQuestions(allQuestionsRemaining);

        View view = inflater.inflate(R.layout.fragment_practice, container, false);

        // Total score of the Question Database length
        totalScore = QuestionDatabase.getDatabase().getLength();
        totalLengthOfScore = allQuestionsRemaining.size();

        // Random Number in the list
        randomNum = (int)(Math.random() * allQuestionsRemaining.size() + 1);

        // Finds the ID for all
        question = view.findViewById(R.id.tv_current_question);

        radioChoice1 = view.findViewById(R.id.rbtn_current_choice1);
        radioChoice2 = view.findViewById(R.id.rbtn_current_choice2);
        radioChoice3 = view.findViewById(R.id.rbtn_current_choice3);
        radioChoice4 = view.findViewById(R.id.rbtn_current_choice4);
        radioChoice5 = view.findViewById(R.id.rbtn_current_choice5);

        numOfQuestionsRemaining = view.findViewById(R.id.tv_remaining_questions);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);

        Button confirm = view.findViewById(R.id.btn_confirm);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // Checks which choice was made by the user
                choiceMade = view.findViewById(checkedId);

                // Changes the id based on the which radio button the user clicked
                radioButtonCheckedId = checkedId;

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // The id that the user pressed
                RadioButton rd = view.findViewById(radioButtonCheckedId);

                if (rd.getText().toString().equals(allQuestionsRemaining.get(randomNum-1).getAnswer()))
                {
                    checkAndAnswer("Correct");
                    changeAndDeleteQuestion(randomNum);

                    System.out.println("This is after the check and Answer Correct");
                    System.out.println(randomNum);
                }

                else
                {
                    checkAndAnswer("Incorrect");
                    changeAndDeleteQuestion(randomNum);


                    System.out.println("This is after the check and Answer Incorrect");
                    System.out.println(randomNum);
                }

                numOfQuestionsRemaining.setText((totalScore + 1) + "/" + totalLengthOfScore);

            }

            public void changeAndDeleteQuestion(int randNum)
            {
                allQuestionsRemaining.remove(randNum-1);

                randomNum = new Integer((int)(Math.random() * allQuestionsRemaining.size() + 1));

                randNum = randomNum;

                setDataToViews(randNum);
            }

            public void checkAndAnswer(String answer)
            {
                currentScore++;
                Toast.makeText(getContext(), answer, Toast.LENGTH_SHORT).show();

                // Add the userScore and the total amount of scores.
                if (answer.equals("Correct"))
                {
                    userScore++;
                    totalScore++;

                }

                // Do the same if the answer is incorrect
                else
                {
                    totalScore++;
                }
            }

            public void setDataToViews(int randomNum)
            {

                try {

                    int choicesFilled = allQuestionsRemaining.get(randomNum-1).getChoices().size();
                    //
                    question.setText(allQuestionsRemaining.get(randomNum-1).getQuestion());

                    if (1 <= choicesFilled)
                    {
                        radioChoice1.setText(allQuestionsRemaining.get(randomNum-1).getChoices().get(0));
                    }

                    else
                    {
                        radioChoice1.setText("");
                        radioChoice1.setEnabled(false);
                        radioChoice1.setVisibility(View.INVISIBLE);
                    }


                    if (2 <= choicesFilled)
                    {
                        radioChoice2.setText(allQuestionsRemaining.get(randomNum-1).getChoices().get(1));
                    }

                    else
                    {
                        radioChoice2.setText("");
                        radioChoice2.setEnabled(false);
                        radioChoice2.setVisibility(View.INVISIBLE);
                    }


                    if (3 <= choicesFilled)
                    {
                        radioChoice3.setText(allQuestionsRemaining.get(randomNum-1).getChoices().get(2));
                    }

                    else
                    {
                        radioChoice3.setText("");
                        radioChoice3.setEnabled(false);
                        radioChoice3.setVisibility(View.INVISIBLE);
                    }

                    if (4 <= choicesFilled)
                    {
                        radioChoice4.setText(allQuestionsRemaining.get(randomNum-1).getChoices().get(3));
                    }

                    else
                    {
                        radioChoice4.setText("");
                        radioChoice4.setEnabled(false);
                        radioChoice4.setVisibility(View.INVISIBLE);
                    }

                    if(5 < choicesFilled)
                    {
                        radioChoice5.setText(allQuestionsRemaining.get(randomNum-1).getChoices().get(4));
                    }

                    else
                    {
                        radioChoice5.setText("");
                        radioChoice5.setEnabled(false);
                        radioChoice5.setVisibility(View.INVISIBLE);
                    }
                }

                // Once there are no more question for the user to answer, head to the quiz
                // complete fragment.
                catch(Exception e)
                {
                    float score = (float) userScore/totalScore;

                    PracticeFragmentDirections.ActionPracticeFragmentToQuizCompleteFragment action =
                            PracticeFragmentDirections.actionPracticeFragmentToQuizCompleteFragment(score);

                    Navigation.findNavController(view).navigate(action);
                }
            }

        });

        return view;
    }

}