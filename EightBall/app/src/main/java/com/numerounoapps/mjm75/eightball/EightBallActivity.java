package com.numerounoapps.mjm75.eightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class EightBallActivity extends AppCompatActivity {

    private EditText questionEditText;
    private TextView answerTextView;
    private Button shakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);

        questionEditText = findViewById(R.id.questionEditText);
        answerTextView = findViewById(R.id.answerTextView);
        shakeButton  = findViewById(R.id.shakeButton);
        answerTextView.setText("The Answer will be here");
    }

    public void setShakeButtonClicked(View Button){
        AnswerEngine  answers = new AnswerEngine();
        EightBall eightBall = new EightBall(answers);
        String randomAnswer = eightBall.randomAnswer();
        answerTextView.setText(answers.getRandomAnswer());


//        String question = questionEditText.getText().toString();
//        Log.d(getClass().toString(),"onShakeButtonClicked was called"+ question);


    }

}
