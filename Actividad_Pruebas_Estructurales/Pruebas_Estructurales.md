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

La línea 1 realiza un test para validar que, efectivamente, la cantidad de palabras que terminen en "s" sea igual a 2. En cambio, la línea 2 realiza el test para comprobar que el conteo de palabras que terminen en "r" o "s" sea igual a 0 cuando ninguna palabra cumple con el requisito anterior.

A continuación se genera un informe con JaCoCo para ver la cobertura de código
![jacoco](./img/img1.png)

Se observa una cobertura del 83%. Se muestran las líneas que tuvieron cobertura con las pruebas

![jacoco](./img/img2.png)

Las líneas resaltadas en verde significa que tuvieron una cobertura en las prueba. Las líneas de amarillo implican que fueron ejecutadas parcialmente. 

## Ejercicio 3

Explica la línea 1 y el caso de prueba recién agregado

Se contruye un caso de prueba para comprobar la partición de "palabras que terminan en r"

```
@Test
void wordsThatEndInR() { // 1
int words = new CountWords().count("car bar");
assertThat(words).isEqualTo(2);
}
```

Se ingresa como parámetro 2 palabras que terminan en "r", por lo que el resultado esperado es que la función CountWords retorne 2.

Se analiza nuevamente la cobertura de código con JaCoCo

![jacoco_100%](./img/img3.png)

Se observa una cobertura del 100%, lo cual indica que nuestros test cubren todo el código escrito.

## Ejercicio 4
## Parte A: Análisis de código

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
### Preguntas
- Explica qué hacen las líneas 1, 2 y 3 en el código

Respuesta: La línea 1 se encarga de iterar a través de cada caracter en la cadena. La línea 2 se encarga de aumentar una unidad al contador si es que se está iniciando una nueva palabra y la última letra leida fue "s" o "r". La línea 3 se encarga de setear el valor de la variable "last" con la última letra leida. 
- Qué sucedería si se eliminara la línea 3 del código

Respuesta: En el caso de que la 3ra línea sea eliminada, no se estaría actualizando el valor de la última letra y el programa no funcionaría correctamente.
- Escribe una descripción de alto nivel de lo que hace este método count

Respuesta: Lo que hace el método count es contar la cantidad de palabras que acaben en "s" o en "r", teniendo como fin de una palabra un caracter que sea diferente de una letra.

## Parte B: Pruebas Unitarias

```
    @Test
    void twoWordsEndingWithS() { // 1
        int words = new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void noWordsAtAll(){ // 2
        int words=new CountWords().count("hola mundo");
        assertThat(words).isEqualTo(0);
    }
```
### Preguntas
- Explica qué hacen las líneas 1 y 2 del código de prueba

Respuesta: La línea 1 se encarga de declarar el test para validar que el conteo sea 2 cuando se colocan 2 palabras que terminan con S. De forma similar, la línea 2 se encarga de validar que el conteo sea 0 debido a que no hay palabras que acaben den "s" o en "r".

- ¿Qué tipos de casos de prueba adicionales se deberían agregar para mejorar la cobertura?

Respuestas: Se deberían de agregar los casos de prueba para validar el conteo de palabras cuando estas acaben en "r".


# Criterios de cobertura:

- Cobertura de línea: Mide la cantidad de líneas ejecutables en el código fuente que son ejecutadasal menos una vez durante la ejecución de las pruebas. 
- Cobertura de ramas: Mide si cada rama de las estructuras de control de flujo (if, for, while) ha sido ejecutada al menos una vez durante la ejecución de las pruebas.
- Cobertura condición + cobertura de rama: Mide si todas las condiciones dentro de una declaración de rama han sido evaluadas como verdaderas y falsas al menos una vez. 
- Cobertura de ruta: Mide si todas las posibles rutas de ejecución del programa han sido ejecutadas durante la ejecución de las pruebas. 




