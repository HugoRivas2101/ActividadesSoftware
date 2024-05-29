# Actividad: Pruebas Estructurales

## Hugo Rivas Galindo

En la actividad se analizará la cobertura de nuestro conjunto de pruebas para que el programa funcione como se espera

## Ejercicio 1

Explique qué hacen las líneas 1, 2 y 3 en el código. 
```
public class CountWords {
    public int count(String str) {
        int words = 0;
        char last = ' ';
        for (int i = 0; i < str.length(); i++) { // 1
            if (!isLetter(str.charAt(i)) && (last == 's' || last == 'r')) { // 2
                words++;
            }
            last = str.charAt(i); // 3
        }
        if (last == 'r' || last == 's') {
            words++;
        }
        return words;
    }
    private boolean isLetter(char c) {
        return Character.isLetter(c);
    }
}
```
El programa a realizar cuenta las palabras que terminen en "r" o "s". Se especifica que una palabra termina cuando aparece una no letra.

Entonces, para realizar dicha función, es necesario iterar sobre cada caracter del string (función de la línea 1) para analizar si es o no una no letra.
La línea 2 se encarga de comprobar que caracter actual sea una no letra y que además la última letra iterada sea s o r, para comprobar así el fin de una palabra y que esta termine en "s" o "r". 
La línea 3 se encarga de almacenar el último caracter iterado. Esto con el fin de que, cuando se alcance una no letra e indique el fin de una palabra, se evalúe si la palabra cumple con el requisito de que termina en "s" o "r" para que el valor del contador aumente en uno. 

## Ejercicio 2

Explique qué hacen las líneas 1 y 2 en el código

```
    @Test
    void twoWordsEndingWithS() { // 1
        int words = new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void noWordsAtAll(){
        int words=new CountWords().count("hola mundo");
        assertThat(words).isEqualTo(0);
    }
```

La línea 1 realiza un test para validar que, efectivamente, la cantidad de palabras que terminen en "r" o "s" sea igual a 2. En cambio, la línea 2 realiza el test para comprobar que el conteo de palabras que terminen en "r" o "s" sea igual a 0 cuando ninguna palabra cumple con el requisito anterior.








