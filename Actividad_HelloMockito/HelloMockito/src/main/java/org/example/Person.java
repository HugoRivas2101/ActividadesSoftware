package org.example;


import java.time.LocalDate;

public class Person{

    Integer id;
    String first;
    String surname;
    LocalDate born;

    public Person(Integer id, String first, String surname,LocalDate born){
        this.id=id;
        this.first=first;
        this.surname=surname;
        this.born=born;
    }
    public String getFirst(){ return first;}
}
