# Actividad: El ritmo RGR del TDD

## ESCRIBIENDO LAS PRÓXIMAS PRUEBAS PARA WORDZ

Se agrega una prueba para una sola letra correcta.
1. Se escribe una prueba fallida para una sola letra correcta

```
    @Test
    public void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertThat(score.letter(0)).isEqualTo(CORRECT);
    }
```