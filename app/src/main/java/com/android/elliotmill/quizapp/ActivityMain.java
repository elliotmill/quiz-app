package com.android.elliotmill.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.elliotmill.quizapp.questions.Question;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityMain extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private ProgressBar pbQuestion;
    private TextView tvProgress, tvOptA, tvOptB, tvOptC, tvOptD, tvQuestion, tvScore;
    private CheckBox cbOptA, cbOptB, cbOptC, cbOptD;
    private int currentQuestion;
    private Button btnNext, btnComplete;
    private View layoutQuestions, layoutReport;
    private ArrayList<Question> questionsList;
    private boolean[] scoreTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentQuestion = 1;

        questionsList = Question.generateAllQuestions();
        scoreTracker = new boolean[questionsList.size()];

        setContentView(R.layout.activity_main);
        pbQuestion = (ProgressBar)findViewById(R.id.pbQuestions);
        tvProgress = (TextView)findViewById(R.id.tvProgress);
        updateQuestionProgress();

        tvQuestion = (TextView)findViewById(R.id.tvQuestion);
        tvScore = (TextView)findViewById(R.id.tvScore);

        tvOptA = (TextView)findViewById(R.id.tvOptA);
        tvOptB = (TextView)findViewById(R.id.tvOptB);
        tvOptC = (TextView)findViewById(R.id.tvOptC);
        tvOptD = (TextView)findViewById(R.id.tvOptD);

        cbOptA = (CheckBox)findViewById(R.id.cbOptA);
        cbOptA.setOnCheckedChangeListener(this);
        cbOptB = (CheckBox)findViewById(R.id.cbOptB);
        cbOptB.setOnCheckedChangeListener(this);
        cbOptC = (CheckBox)findViewById(R.id.cbOptC);
        cbOptC.setOnCheckedChangeListener(this);
        cbOptD = (CheckBox)findViewById(R.id.cbOptD);
        cbOptD.setOnCheckedChangeListener(this);

        btnNext = (Button)findViewById(R.id.btnNextQuestion);
        btnComplete = (Button)findViewById(R.id.btn_complete);
        btnNext.setOnClickListener(this);
        btnComplete.setOnClickListener(this);

        layoutQuestions = findViewById(R.id.layout_questions);
        layoutReport = findViewById(R.id.layout_report);

        loadNextQuestion();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.cbOptA: {
                break;
            }
            case R.id.cbOptB: {
                break;
            }
            case R.id.cbOptC: {
                break;
            }
            case R.id.cbOptD: {
                break;
            }
            default:{
                break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNextQuestion: {
                if (btnNext.getText().toString().equalsIgnoreCase("Submit !")) {
                    processQuestionResponse();
                    submit();
                } else {
                    processQuestionResponse();
                    currentQuestion++;
                    loadNextQuestion();
                }
                if (currentQuestion == questionsList.size()) {
                    btnNext.setText("Submit !");
                }
                break;
            }
            case R.id.btn_complete: {
                finish();
                break;
            }
            default: {
                break;
            }
        }
    }

    private void loadNextQuestion() {
        Question nextQ = questionsList.get(currentQuestion - 1);
        updateQuestionsView(nextQ);
    }

    private void updateQuestionsView(Question question) {
        resetCheckBoxes();
        this.tvQuestion.setText(question.getQuestion());
        this.tvOptA.setText(question.getOptions()[0]);
        this.tvOptB.setText(question.getOptions()[1]);
        this.tvOptC.setText(question.getOptions()[2]);
        this.tvOptD.setText(question.getOptions()[3]);
        updateQuestionProgress();
    }

    private void updateQuestionProgress() {
        double size = (double) questionsList.size();
        int progress = (int)((currentQuestion/size) * 100);
        this.pbQuestion.setProgress(progress);
        tvProgress.setText("Question " + currentQuestion + " of " + questionsList.size());
    }

    private void resetCheckBoxes() {
        cbOptA.setChecked(false);
        cbOptB.setChecked(false);
        cbOptC.setChecked(false);
        cbOptD.setChecked(false);
    }

    private void processQuestionResponse() {
        Question question = questionsList.get(currentQuestion - 1);
        boolean correct = false;
        int[] selectedOptions = getSelectedOptions();
        int[] rightOptions = question.getRightOptions();
        Arrays.sort(selectedOptions);
        Arrays.sort(rightOptions);
        if (question.hasMultipleAnswers()) {
            correct = true;
            for (int opt : selectedOptions) {
                if (!arrayContains(rightOptions, opt)) {
                    correct = false;
                }
            }
        } else {
            if (Arrays.equals(selectedOptions, rightOptions)) {
                correct = true;
            }
        }
        scoreTracker[currentQuestion - 1] = correct;
    }

    private boolean arrayContains(int[] list, int searchKey) {
        boolean found = false;
        for (int item : list) {
            if (item == searchKey) {
                found = true;
                break;
            }
        }
        return found;
    }

    private int[] getSelectedOptions() {
        ArrayList<Integer> selections = new ArrayList<>();
        if (cbOptA.isChecked()) {
            selections.add(0);
        }
        if (cbOptB.isChecked()) {
            selections.add(1);
        }if (cbOptC.isChecked()) {
            selections.add(2);
        }if (cbOptD.isChecked()) {
            selections.add(3);
        }
        int[] options = new int[selections.size()];
        for (int i = 0; i < selections.size(); i++) {
            options[i] = selections.get(i);
        }
        return options;
    }

    private void submit() {
        int correct = 0;
        for (boolean c : scoreTracker) {
            if (c) {
                correct++;
            }
        }
        tvScore.setText(correct + " / " + scoreTracker.length);
        layoutQuestions.setVisibility(View.GONE);
        layoutReport.setVisibility(View.VISIBLE);
    }
}
