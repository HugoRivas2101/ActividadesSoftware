# Hugo Rivas Galindo


# SPRINT 1

Se inicia creando el proyecto desde 0
![conf](./img/img1.png)



A continuación se realiza el enfoque TDD para la realizaión de pruebas y refactorización.
Se inicia con la primera prueba que comprobará que la letra es diferente.

```
    @Test
    public void oneIncorrectLetter(){
        var word = new Word("A");
        var score = word.guess("Z");

        assertScoreForGuess(score, INCORRECT);
    }
```
El código dado en el examen pasa dicha prueba. 

![test_accept](./img/img2.png)

Se hace una variación en la prueba para comprobar que efectivamente el código está comprobando lo que debe comprobar.
Comprobamos que ahora la prueba falla.

![test_failed](./img/img3.png)

Se actúa de forma similar en la siguiente prueba. El código dado en el enunciado es suficiente para para pasar la segunda prueba.

![test_accept](./img/img4.png)

Se debe de hacer una variación para comprobar que efectivamente el código está probando la funcionalidad que se quiere.
Luego de cambiar los parámetros, se observa que la prueba falla.

![test_failed](./img/img5.png)

Por lo tanto, el código está validando lo que debe validar.

Se realiza el análisis estático con sonarQ. Se realiza la configuración

```
sonar {
    properties {
        property "sonar.projectKey", "WORDZ"
        property "sonar.login", "sqp_83bddeac802c9f8001509ab31e90f0c557065a9a"
        property "sonar.host.url", "http://localhost:9000"
    }
}
```

Se observa que hay solo 7 olores de código

![sonarq](./img/img6.png)

Se realiza la refactorización según lo establecido por SonarQ:

Se debe de quitar la etiqueta de public en la clase de test:

![sonarq](./img/img7.png)

Se cambia

```
public class WordTest {...}
```
por
```
class WordTest {...}
```


Se debe realizar el mismo cambio para todas las clases de prueba realizadas.

![sonarq](./img/img8.png)

```

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


```


¡Listo! Se tiene la primera parte del sprint completada
















