package com.wordz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordTest {

    @Test
    public void oneIncorrectLetter(){

        //Se inicializa (sin definir) Word con "A".
        var word= new Word("A");

        /*Se llama al método guess con el parámetro z, para validar si "z"
        pertenece a la palabra word. Este método retorna un objeto de
        tipo score, el que nos servirá para saber
        si la letra pasada como argumento pertenece a la palabra
        a adivinar.
         */
        var score=word.guess("Z");

        /*La clase score tiene un método letter que sirve para saber el
        valor de la letra en determinadad posicion. Dichos valores pueden
        ser INCORRECT, CORRECT o PARTIAL_CORRECT
         */

        var result=score.letter(0);
        assertThat(result).isEqualTo(Letter.INCORRECT);
    }
}

