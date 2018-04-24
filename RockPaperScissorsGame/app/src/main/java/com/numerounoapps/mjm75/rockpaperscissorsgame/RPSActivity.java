package com.numerounoapps.mjm75.rockpaperscissorsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RPSActivity extends AppCompatActivity {
    private ImageButton rockButton;
    private ImageButton paperButton;
    private ImageButton scissorsButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        rockButton = findViewById(R.id.rockButtonID);
        paperButton = findViewById(R.id.paperButtonID);
        scissorsButton = findViewById(R.id.scissorsButtonID);
        resultTextView = findViewById(R.id.resultTextViewID);
        resultTextView.setText("Result....");
    }

    public void  onRockButtonIDClicked(View imageButton){
        GameLogic gameLogic = new GameLogic();
        String words  = gameLogic.getTextForRock();
        resultTextView.setText(words);
    }

    public void  onPaperButtonIDClicked(View imageButton){
        GameLogic gameLogic = new GameLogic();
        String words  = gameLogic.getTextForPaper();
        resultTextView.setText(words);
    }

    public void  onScissorsButtonIDClicked(View imageButton){
        GameLogic gameLogic = new GameLogic();
        String words  = gameLogic.getTextForScissors();
        resultTextView.setText(words);
    }
}
