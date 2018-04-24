package com.numerounoapps.mjm75.rockpaperscissorsgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GameLogic {

    private String text;
    ArrayList<String> computerMoves;



    public GameLogic() {
        this.text = text;
    }


    public String getTextForRock() {
        return "I'm a rock!";
    }

    public String getTextForPaper() {
        return "I'm paper!";
    }

    public String getTextForScissors() {
        return "I'm scissors!";
    }

    public void computerMoves() {
        this.computerMoves = new ArrayList<>();
        computerMoves.add("Rock");
        computerMoves.add("Paper");
        computerMoves.add("Scissors");
    }

    public ArrayList<String> getComputerMoves() {
        return new ArrayList<>(this.computerMoves);
    }

    public String getRandomComputerMove() {
        Collections.shuffle(this.computerMoves);
        return this.computerMoves.get(0);
    }
}

