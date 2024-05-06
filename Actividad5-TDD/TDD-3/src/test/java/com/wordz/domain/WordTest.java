package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForLetter(score,0, CORRECT);
    }

    @Test
    public void secondLetterWrong(){
        var word=new Word("AB");
        var score=word.guess("BC");
        assertScoreForLetter(score, 1, PART_CORRECT);

    }

    @Test
    public void allScoreCombinations(){
        var word= new Word("ABC");
        var score= word.guess("CBZ");

        assertScoreForGuess(score, PART_CORRECT, CORRECT, INCORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expectedScores){
        for(int i=0; i<expectedScores.length; i++){
            Letter expected= expectedScores[i];
            assertScoreForLetter(score, i, expected);
        }
    }

    private void assertScoreForLetter(Score score,int position, Letter expected){
        assertThat(score.letter(position)).isEqualTo(expected);
    }



}
