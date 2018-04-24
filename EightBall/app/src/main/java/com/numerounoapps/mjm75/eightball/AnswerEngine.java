package com.numerounoapps.mjm75.eightball;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by allymcgilloway on 12/12/2017.
 */

public class AnswerEngine {
    ArrayList<String> answers;

    public AnswerEngine(){

        setUpAnswers();
    }

    public void setUpAnswers(){
        this.answers = new ArrayList();
        answers.add("Yes!");
        answers.add("No!");
        answers.add("That would be an ecumenical matter!");
    }

    public ArrayList<String> getAnswers(){

        return new ArrayList<>(this.answers);
    }

    public String getRandomAnswer(){
        Collections.shuffle(this.answers);
        return this.answers.get(0);
    }

    public void addAnswer(String answer){
        this.answers.add(answer);
    }
}
