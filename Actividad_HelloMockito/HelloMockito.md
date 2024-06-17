# Usando Mockito
## Hugo Rivas Galindo

## Parte 1
## Construyendo una base de pruebas

Mockito nos ayuda a aislar componentes particulares de software. Se utiliza mockito para reemplazar las dependencias de los componentes que se está probando, de modo que los métodos en cada dependencia devuelvan salidas conocidas para entradas conocidas. 

## Saludando a Mockito

Inicialmente se saluda a Mockito usando el clásico ejemplo:
```
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
Y se hace un test simple
```
    private HelloMockito helloMockito=new HelloMockito();
    @Test
    void HelloMockitoTest() {
        String greeting = helloMockito.greet("World");
        assertEquals("Hello, World, from Mockito!", greeting);
    }
```
Debido a la simplicidad de la clase (no contiene ninguna dependencia), no se necesita mockito en absoluto. Mockito es realmente útil cuando se trabaja con dependencias, por lo que se agregará un par de dependencias, una para buscar a una persona para saludar y otra para traducir el mensaje resultante a diferentes idiomas.

```
public class HelloMockito {
    private String greeting = "Hello, %s, from Mockito!";
    // Dependencies
    private final PersonRepository personRepository;
    private final TranslationService translationService;

    // Constructor to inject the dependencies
    public HelloMockito(PersonRepository personRepository,
                        TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }

    // Method we want to test
    public String greet(int id, String sourceLang, String targetLang) {
        Optional<Person> person = personRepository.findById(id);
        String name = person.map(Person::getFirst).orElse("World");

        return translationService.translate(
                String.format(greeting, name), sourceLang, targetLang);
    }
}
```
Se observan las dependencias de las clases PersonRepository y de TranslationService.


## Agregar mockito al proyecto

Se muestra la sección de dependencies del archivo build.gradle
```
dependencies {
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    testImplementation 'org.mockito:mockito-core:3.+'

    implementation platform('org.mockito:mockito-bom:5.11.0')
    implementation 'org.mockito:mockito-core'
    implementation 'org.mockito:mockito-junit-jupiter'
}
```
Con dichas dependencias es suficiente para que se ejecuten las pruebas con mockito.

## Una clase de prueba de Mockito con todo

Se mostrarán fracciones de la clase HelloMockitoTest para explicar cada sección
```
@ExtendWith(MockitoExtension.class)
public class HelloMockitoTest {
    @Mock
            private  PersonRepository repository;
    @Mock
            private TranslationService translationService;
    @InjectMocks
            private HelloMockito helloMockito;
    (...)
```
Se observa que se usan las etiquetas ExtendWith, Mock e InjectMock

- ExtendWith(MockitoExtension.class): Configura JUnit para usar la extensión de Mockito, gestionando la inicialización de Mocks.
- Mock: Indica que el campo debe ser un mock simulado por Mockito
- InjectMocks: Inyecta los mocks en el objeto de prueba, configruando sus dependencias automáticamente.

En nuestro caso, se observa que se estarían simulando los mocks PersonRepository y TranslationService, y estos serían inyectados en helloMockito. 


A continuación se muestra el test creado
```
    @Test
    @DisplayName("Greet Admirar Hopper")
    void greetAPersonThatExist(){

        //set the expectectations on the mocks
        when(repository.findById(anyInt())).thenReturn(Optional.of(new Person(1,"Grace","Hopper", LocalDate.of(1906, Month.DECEMBER,9))));
        when(translationService.translate("Hello, Grace, from Mockito!","en","en")).thenReturn("Hello, Grace, from Mockito!");

        //test the greet method
        String greeting = helloMockito.greet(1,"en","en");
        assertEquals("Hello, Grace, from Mockito!", greeting);

        //Verify the methods
        InOrder inOrder=inOrder(repository, translationService);
        inOrder.verify(repository).findById(anyInt());
        inOrder.verify(translationService).translate(anyString(),eq("en"),eq("en"));
    }
```
Se utilizan los métodos when(...).thenReturn(...) para especificar cómo deben comportarse los mocks cuando se llaman métodos específicos.

Se ejecutan las pruebas y se verifica el resultado con assertEquals. Luego se usa Verify para confirmar que los métodos en los mocks fueron llamados con los argumentos esperados. 

De la misma manera, se crea el otro test
```
@Test
    @DisplayName("Greet a person not in the database")
    void greetAPersonThatDoesNotExist(){
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        when(translationService.translate("Hello, World, from Mockito!","en","en")).thenReturn("Hello, World, from Mockito!");
        String greeting=helloMockito.greet(100,"en","en");
        assertEquals("Hello, World, from Mockito!",greeting);

        //Verify the methods are called once, in the right order
        InOrder inOrder=inOrder(repository,translationService);
        inOrder.verify(repository).findById(anyInt());
        inOrder.verify(translationService).translate(anyString(),eq("en"),eq("en"));
    }
```

Finalmente, se resume el patrón que se usará cuando una clase tenga dependencias:
```
class ClassUnderTest {
    private DependencyOne dependency1;
    private DependencyTwo dependency2;
    public Result methodToBeTested(Object... args) {
        // use dependencies and arguments and return Result
        return result;
    }
}
```
Formalmente, el proceso que estamos utilizando consiste en:
- Crear stubs para sustituir las dependencias.
- Establecer expectativas en los talones para hacer lo que quieras.
- Inyectar los stubs en la clase que planeas probar.
- Probar los métodos de la clase bajo prueba invocando sus métodos, que a su vez llaman a
métodos en los stubs.
- Verificar que los métodos funcionen como se esperaba.
- Verificar que los métodos de las dependencias se hayan invocado la cantidad correcta de veces y
en el orden correcto.



