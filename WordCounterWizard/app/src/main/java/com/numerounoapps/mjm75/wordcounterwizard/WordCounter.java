package com.numerounoapps.mjm75.wordcounterwizard;

public class WordCounter {

    private String words;

    public WordCounter(String words) {
        this.words = words;
    }

    private String[] splitWords() {
        return this.words.split(" ");
    }

    public int getWordCount() {
        return splitWords().length;
    }

}
