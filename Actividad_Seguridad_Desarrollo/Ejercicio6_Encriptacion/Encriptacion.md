# Ejercicio 6: Encriptación y protección de datos

## Hugo Rivas Galindo

Implementar un sistema que use encriptación para proteger datos sensibles durate su almacenamiento y transmisión. 

Se usa la clase Cipher de javax.crypto para la encriptación y desencriptación.

https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html

----
## Análisis de la clase Encryption Manager

El ejercicio nos ofrece una clase Encryption Manager que posee como único atributo un tipo de dato SecretKey, el cual se puede importar desde javax.crypto.SecretKey.

La clase posee un manejo de excepciones desde se constructor. Esto también se realiza para el resto de métodos.

####  Se observa el método generateKey(). 

```
    private SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }
```
Se observa la clase KeyGenerator. Esta clase ofrece la funcionalidad de generar una llave secreta (cifrado simétrico).
Se genera un KeyGenerator usando el método getInstance de la propia clase. Este método retorna un KeyGenerator que genera llaves secretas para el algoritmo especificado.
En nuestro ejercicio, se usa el cifrado simétrico AES. También podríamos usar otros cifrados simétricos como DES, pero se prefiere AES por ser el más seguro debido a su tamaño de llave. 

![posibles cifrados](./img/img1.png)




