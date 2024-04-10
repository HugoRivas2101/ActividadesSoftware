# EJERCICIO 2

## Haz pasar las pruebas

### Entendiendo las pruebas
Se tienen las pruebas para la clase SimpleAgedCache. Se inicializan 2 objetos con nombre empty y nonempty realizar las pruebas sobre ellos.
Se usa @BeforeEach para especificar que antes de cada prueba se 
```
public class SimpleAgedCacheTest {  
    SimpleAgedCache empty = new SimpleAgedCache();  
    SimpleAgedCache nonempty = new SimpleAgedCache();  
  
    @BeforeEach  
  public void before() {  
        nonempty.put("aKey", "aValue", 2000);  
        nonempty.put("anotherKey", "anotherValue", 4000);  
    }
```

### Test isEmpty
El objetivo de este test es asegurarse de que al inicializarse el objeto se encuentre sin elementos. 
```
@Test  
public void isEmpty() {  
    assertTrue(empty.isEmpty());  
    assertFalse(nonempty.isEmpty());  
}
```

### Test size
El objetivo de este test es asegurarse de que se agregue un elemento y lo comprueba con el tamaño .
```
@Test  
public void size() {  
    assertEquals(0, empty.size());  
    assertEquals(2, nonempty.size());  
}
```

### Test get
El objetivo de este test es asegurarse de que el get retorne el valor de la llave
```
@Test  
public void get() {  
    assertNull(empty.get("aKey"));  
    assertEquals("aValue", nonempty.get("aKey"));  
    assertEquals("anotherValue", nonempty.get("anotherKey"));  
}
```

### Test getExpired 

En este test se crea una instancia de TestClock para poder controlar los tiempos. Luego se crea una instancia de SimpleAgedCache que usa clock como reloj
En la siguiente linea se crea una cache expired y se agregan 2 elementos con sus respectivos tiempos de expiración. 

La línea clock.offset retorna un instante del tiempo especificado con la duración del tiempo
```
@Test  
public void getExpired() {  
    TestClock clock = new TestClock();  
  
    SimpleAgedCache expired = new SimpleAgedCache(clock);  
    expired.put("aKey", "aValue", 2000);  
    expired.put("anotherKey", "anotherValue", 4000);  
  
    clock.offset(Duration.ofMillis(3000));  
  
    assertEquals(1, expired.size());  
    assertEquals("anotherValue", expired.get("anotherKey"));  
}
```

