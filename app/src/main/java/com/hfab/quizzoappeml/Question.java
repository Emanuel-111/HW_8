package com.hfab.quizzoappeml;

import java.util.ArrayList;

/**
 * Question class allows the a question to be made
 */
public class Question {

    private String genre;
    private String question;
    private ArrayList<String> choices = new ArrayList<String>();
    private String answer;
    private String funFact;


    public Question(String g, String q, ArrayList<String> c, String a, String ff)
    {
        genre = g;
        question = q;
        choices = c;
        answer = a;
        funFact = ff;

    }

    public String getQuestion()
    {
        return question;
    }

    public ArrayList<String> getChoices()
    {
        return choices;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getAnswer() {
        return answer;
    }

    public String getFunFact() {
        return funFact;
    }



    public String toString()
    {
        String choices = "";

        for (int i=0; i < getChoices().size(); i++)
        {
            choices += getChoices().get(i);
        }

        String wholeString;

        wholeString = "Genre: " + getGenre() +
                      "\nQuestion: " + getQuestion() +
                      "\nChoices: " + choices +
                      "\nAnswer: " + getAnswer() +
                      "\nFun Fact" + getFunFact();


        return wholeString;
    }

}
