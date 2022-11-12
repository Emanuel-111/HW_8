package com.hfab.quizzoappeml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * QuestionDatabase allows the backend to add all questions needed as well
 * as any other questions the user has as well.
 */
public class QuestionDatabase {

    private static ArrayList<Question> questions = new ArrayList<Question>();

    /**
     * addAllQuestions adds all the questions to an ArrayList to display
     * to the user one at a time.
     *
     * @return questions
     */
    public static ArrayList<Question> addAllQuestions()
    {
        QuestionDatabase.allInitialQuestions(questions);

        return questions;
    }

    /**
     * addQuestion adds a question
     *
     * @param g - genre
     * @param q - question
     * @param c - choices
     * @param a - answer
     * @param ff - fun fact
     */
    public static void addQuestion(String g, String q, ArrayList<String> c, String a, String ff)
    {
        Question newQuestion = new Question(g,q,c,a,ff);
        questions.add(newQuestion);
    }

    public static int getLength()
    {
        return questions.size();
    }

    public static void addAllQuestions(ArrayList<Question> q)
    {
        for (int i = 0; i < questions.size(); i++)
        {
            q.add(questions.get(i));
        }
    }

    /**
     * Makes a genre list (Not complete)
     * @param questions - ArrayList
     * @return areas
     */
    public static Set<String> getGenreNames(final List<Question> questions) {
        Set<String> areas = new HashSet<>();
        for(final Question question: questions)
        {
            areas.add(question.getGenre());
        }
        return areas;
    }

    /**
     * Adds all questions the developers wanted the user
     * to get the correct answers to as well
     * @param q - ArrayList of questions
     * @return q
     */
    public static ArrayList<Question> allInitialQuestions(ArrayList<Question> q)
    {
        // Add all choices
        ArrayList<String> c = new ArrayList<String>();

        // These choices would be added to the choices ArrayList
        c.add("Pacific");
        c.add("Atlantic");
        c.add("Arctic");
        c.add("Indian");

        // Then what is stored in c at this moment should stay there

        // This question should have the aquatic choices
        q.add(new Question("Geography","Which ocean is the largest?", c, "Pacific", "The Pacific Ocean stretches to an astonishing 63.8 million square miles!"));

        // However, when I remove everything on the ArrayList,
        // it automatically updates the other ArrayList to display
        // the ones that have been added to it.
        c = new ArrayList<String>();

        c.add("192");
        c.add("195");
        c.add("193");
        c.add("197");

        // However,
        q.add(new Question("Geography", "How many countries are in the world?", c, "195", "Africa has the most countries of any continent with 54."));

        c = new ArrayList<String>();

        c.add("Mississippi");
        c.add("Nile");
        c.add("Congo");
        c.add("Amazon");

        q.add(new Question("Geography", "What is the name of the longest river in the world?", c, "Nile","Explorer John Hanning Speke discovered the source of the Nile on August 3rd, 1858."));

        c = new ArrayList<String>();

        c.add("United States");
        c.add("China");
        c.add("Japan");
        c.add("India");

        q.add(new Question("Geography","Which country has the largest population?" ,c, "China", "Shanghai is the most populated city in China with a population of 24,870,895."));

        c = new ArrayList<String>();

        c.add("Mars");
        c.add("Mercury");
        c.add("Venus");
        c.add("Jupiter");

        q.add(new Question("Geography","Which planet is closest to Earth?",c,"Venus","Even though Venus is the closest, the planet it still ~38 million miles from Earth!"));

        c = new ArrayList<String>();

        c.add("Sega");
        c.add("Nintendo");
        c.add("Sony");
        c.add("Atari");

        q.add(new Question("Video Games", "Which company created the famous plumber Mario?", c, "Nintendo", "Nintendo created Mario in 1981 for the arcade game Donkey Kong."));

        c = new ArrayList<String>();

        c.add("Sonic");
        c.add("Tales");
        c.add("Knuckles");
        c.add("Amy");

        q.add(new Question("Video Games", "What is the name of the famous video character who is a blue hedgehog?",c,"Sonic", "In some official concept art, Sonic was originally meant to be a rabbit."));

        c = new ArrayList<String>();

        c.add("Wii Sports");
        c.add("Grand Theft Auto V");
        c.add("Tetris");
        c.add("Minecraft");

        q.add(new Question("Video Games","As of 2022, which of the following is the best selling video game of all time?",c,"Minecraft","As of 2022, Minecraft has sold over 238 million units."));

        c = new ArrayList<String>();

        c.add("Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid.");
        c.add("Place 2 milk, 3 sugar, 2 eggs, and 3 wheat in the 3x3 crafting grid.");
        c.add("Place 3 milk, 5 sugar, 6 eggs, and 3 wheat in the 3x6 crafting grid.");
        c.add("Place 1 milk, 1 sugar, 1 egg, and 1 wheat in the 1x1 crafting grid.");

        q.add(new Question("Video Games", "How do you craft a cake in Minecraft?", c , "", ""));


        return q;
    }








}
