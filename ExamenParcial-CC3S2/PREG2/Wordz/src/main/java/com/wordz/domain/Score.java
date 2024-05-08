package com.wordz.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String correct;
    private final List<Letter> results = new ArrayList<>();
    public Score(String correct) {
        this.correct = correct;
    }
    public Letter letter(int position) {
        return results.get(position);
    }
    public void assess(String attempt) {
        for (int i = 0; i < attempt.length(); i++) {
            char current = attempt.charAt(i);
            if (isCorrectLetter(i, current)) {
                results.add(Letter.CORRECT);

            } else if (occursInWord(current)) {
                results.add(Letter.PART_CORRECT);

            } else {
                results.add(Letter.INCORRECT);

            }
        }
    }
    private boolean isCorrectLetter(int position, char currentLetter) {
        return correct.charAt(position) == currentLetter;
    }
    private boolean occursInWord(char current) {
        return correct.contains(String.valueOf(current));
    }
}