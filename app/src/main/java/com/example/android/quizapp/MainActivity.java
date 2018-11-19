package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //@global: a variable to get the user name to be thrown to QuizActivity class

//    public void focus(View view){
//        EditText takeName2 = findViewById(R.id.name_field);
//        takeName2.setFocusable(true);
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //input to EditText is caught so as to be passed to the other activity class
        final EditText takeName = findViewById(R.id.name_field);
        takeName.getText();
        Button takeQuiz = (Button) findViewById(R.id.take_quiz);

        /**
         * this sets onClickListener on the button element; this is another way of setting onClick listener in java...
         * on a button instead of declaring it in xml file
         */
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //two intents are passed at a time i.e to get to the next activity and to throw the user name from EditText with putExtra()
                Intent quizIntent = new Intent (MainActivity.this, QuizActivity.class);
                quizIntent.putExtra("EdiTtEXTvALUE", "Welcome " + takeName.getText().toString()) ;
                startActivity(quizIntent);
                finish();
            }

        }) ;


    }


}
