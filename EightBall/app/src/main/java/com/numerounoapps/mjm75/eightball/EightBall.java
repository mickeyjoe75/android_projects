package com.numerounoapps.mjm75.eightball;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by allymcgilloway on 12/12/2017.
 */

public class EightBall {
    AnswerEngine answers;

    public EightBall(AnswerEngine answers){
        this.answers = answers;
    }

    public String randomAnswer(){
        return answers.getRandomAnswer();

    }

}
