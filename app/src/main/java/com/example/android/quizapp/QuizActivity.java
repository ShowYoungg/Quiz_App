package com.example.android.quizapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SHOW on 5/20/2018.
 */

public class QuizActivity extends AppCompatActivity {
    //@global: variable to keep track of the number of correct answers
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        /**
         * Username from MainActivity is thrown down here, so that it can be displayed in this activity class.
         * @param: username from MainActivity
         */
        TextView setUserName = findViewById(R.id.welcome);
        setUserName.setText(getIntent().getStringExtra("EdiTtEXTvALUE"));

    }

    public void submitAnswer(View view) {
        //This assesses the correct answer to question 1.
        RadioButton questionOneAnswer = findViewById(R.id.none);
        boolean answerToQuestion1 = questionOneAnswer.isChecked();
        if (answerToQuestion1) {
            score += 1;
        }
        //This assesses the correct answer to question 2.
        RadioButton questionTwoAnswer = findViewById(R.id.undefined);
        boolean answerToQuestion2 = questionTwoAnswer.isChecked();
        if (answerToQuestion2) {
            score += 1;
        }
        //This assesses the correct answer to question 3.
        RadioButton questionThreeAnswer = findViewById(R.id.entityB);
        boolean answerToQuestion3 = questionThreeAnswer.isChecked();
        if (answerToQuestion3) {
            score += 1;
        }
        //This assesses the correct answer to question 4.
        RadioButton questionFourAnswer = findViewById(R.id.entityA1);
        boolean answerToQuestion4 = questionFourAnswer.isChecked();
        if (answerToQuestion4) {
            score += 1;
        }
        //This assesses the correct answer to question 5.
        CheckBox questionFiveAnswerA = findViewById(R.id.abc);
        boolean answerToQuestion5a = questionFiveAnswerA.isChecked();

        CheckBox questionFiveAnswerB = findViewById(R.id.def);
        boolean answerToQuestion5b = questionFiveAnswerB.isChecked();

        CheckBox questionFiveAnswerC = findViewById(R.id.bcd);
        boolean answerToQuestion5c = questionFiveAnswerC.isChecked();

        CheckBox questionFiveAnswerD = findViewById(R.id.cde);
        boolean answerToQuestion5d = questionFiveAnswerD.isChecked();


        if ((answerToQuestion5a && answerToQuestion5b) && !answerToQuestion5d && !answerToQuestion5c  ) {
            score += 1;
        } else
            score += 0;

        //This assesses the correct answer to question 6.
        EditText questionSixAnswer = findViewById(R.id.edit);
        String answerToQuestion6 = questionSixAnswer.getText().toString();
        if (answerToQuestion6 == "Particle A") {
            score += 1 ;
        }
        /**
         * toast messages to display on submission and the navigation intent to restart the quiz
         */

        Toast.makeText(this, "Thanks for taking this quiz", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "You scored " + score + " out of 6", Toast.LENGTH_LONG).show();
        score = 0;
        //Restart quiz by going back to the home page
        Intent quizIntent = new Intent(QuizActivity.this, MainActivity.class);
        startActivity(quizIntent);
        finish();
    }

}
