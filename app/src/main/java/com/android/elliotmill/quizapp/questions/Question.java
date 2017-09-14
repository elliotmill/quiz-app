package com.android.elliotmill.quizapp.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azeezolaniran on 14/09/2017.
 */

public class Question {
    private String question;
    private String[] allOptions;
    private int[] rightOptions;
    private boolean combineRightOptions;

    public Question(String q, String[] opts, int[] rOpt) {
        super();
        this.question = q;
        this.allOptions = opts;
        this.rightOptions = rOpt;
        this.combineRightOptions = false;
    }

    public Question(String q, String[] opts, int[] rOpt, boolean cRO) {
        this(q, opts, rOpt);
        this.combineRightOptions = cRO;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getOptions() {
        return this.allOptions;
    }

    public int[] getRightOptions() {
        return this.rightOptions;
    }

    // helper method to generate all questions
    public static List generateAllQuestions() {
        List questions = new ArrayList<Question>();
        Question q;
        // Q1
        q = new Question("What is the first element on the periodic table ?", new String[]{"Helium", "Hydrogen", "Copper", "Oxygen"}, new int[]{1});
        questions.add(q);

        // Q2
        q = new Question("What is the super continent called in the Paleozoic and Mesozoic era ?", new String[]{"Lautentia", "Rheic", "Pangea", "Devonian"}, new int[]{2});
        questions.add(q);

        // Q3
        q = new Question("Who discovered America ?", new String[]{"Francisco de Bobadilla", "Leif Erikson", "Christpher Columbus", "Giovanni Pallegrino"}, new int[]{1, 2});
        questions.add(q);

        // Q4
        q = new Question("Which of the following are Presidents of the United States ?", new String[]{"Alexander Hamilton", "Thomas Jefferson", "Benjamin Franklin", "James Buchanan"}, new int[]{1, 3});
        questions.add(q);

        // Q5
        q = new Question("Which is the largest planet in the solar system ?", new String[]{"Neptune", "Mars", "Saturn", "Jupiter"}, new int[]{3});
        questions.add(q);

        // Q6
        q = new Question("What is the smallest bone in the human body ?", new String[]{"Femur", "Stapes", "Ulna", "Radius"}, new int[]{1});
        questions.add(q);

        // Q7
        q = new Question("What did the \"D\" in \"D-Day\" stand for ?", new String[]{"Day", "Dunkirk", "Dawn", "Depart"}, new int[]{0});
        questions.add(q);

        // Q8
        q = new Question("Which of the following are not fruit ?", new String[]{"Carrots", "Apples", "Aubergine", "Celery"}, new int[]{0, 2, 3}, true);
        questions.add(q);

        // Q9
        q = new Question("What is the Formula of Dihydrogen Monoxide ?", new String[]{"H₂O", "NaCl", "H₂SO₄", "Na₂CO₃"}, new int[]{1});
        questions.add(q);

        // Q10
        q = new Question("What is the Formula of Dihydrogen Monoxide ?", new String[]{"3", "1", "4", "2"}, new int[]{3});
        questions.add(q);

        return questions;
    }
}
