package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;



class WordTest {

    @Test
    void oneIncorrectLetter(){
        var word = new Word("A");
        var score = word.guess("Z");

        assertScoreForGuess(score, INCORRECT);
    }

    @Test
    void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForLetter(score,0, CORRECT);
    }

    @Test
    void secondLetterWrong(){
        var word=new Word("AR");
        var score=word.guess("ZA");
        assertScoreForLetter(score, 1, PART_CORRECT);
    }

    @Test
    void allScoreCombinations(){
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
