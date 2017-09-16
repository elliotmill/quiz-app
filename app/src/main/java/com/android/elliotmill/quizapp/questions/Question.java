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
    private boolean combinesRightOptions;
    private boolean hasMultipleAnswers;

    public Question(String q, String[] opts, int[] rOpt) {
        super();
        this.question = q;
        this.allOptions = opts;
        this.rightOptions = rOpt;
        this.combinesRightOptions = false;
        this.hasMultipleAnswers = false;
    }

    public Question(String q, String[] opts, int[] rOpt, boolean cRO) {
        this(q, opts, rOpt);
        this.combinesRightOptions = cRO;
        this.hasMultipleAnswers = false;
    }

    public Question(String q, String[] opts, int[] rOpt, boolean cRO, boolean hMA) {
        this(q, opts, rOpt, cRO);
        this.hasMultipleAnswers = hMA;
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

    public boolean hasMultipleAnswers() {
        return this.hasMultipleAnswers;
    }

    public boolean combinesRightOptions() {
        return this.combinesRightOptions;
    }

    // helper method to generate all questions
    public static ArrayList generateAllQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        Question q;
        // Q1
        q = new Question("What is the first element on the periodic table ?", new String[]{"Helium", "Hydrogen", "Copper", "Oxygen"}, new int[]{1});
        questions.add(q);

        // Q2
        q = new Question("What is the super continent called in the Paleozoic and Mesozoic era ?", new String[]{"Lautentia", "Rheic", "Pangea", "Devonian"}, new int[]{2});
        questions.add(q);

        // Q3
        q = new Question("Who discovered America ?", new String[]{"Francisco de Bobadilla", "Leif Erikson", "Christpher Columbus", "Giovanni Pallegrino"}, new int[]{1, 2}, false, true);
        questions.add(q);

        // Q4
        q = new Question("Which of the following are Presidents of the United States ?", new String[]{"Alexander Hamilton", "Thomas Jefferson", "Benjamin Franklin", "James Buchanan"}, new int[]{1, 3}, true, true);
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
        q = new Question("Which of the following are not fruit ?", new String[]{"Carrots", "Apples", "Aubergine", "Celery"}, new int[]{0, 2, 3}, false, true);
        questions.add(q);

        // Q9
        q = new Question("What is the Formula of Dihydrogen Monoxide ?", new String[]{"H₂O", "NaCl", "H₂SO₄", "Na₂CO₃"}, new int[]{0});
        questions.add(q);

        // Q10
        q = new Question("How many electrons are in Helium ?", new String[]{"3", "1", "4", "2"}, new int[]{3});
        questions.add(q);

        return questions;
    }
}
