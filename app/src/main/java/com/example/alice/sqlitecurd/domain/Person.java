package com.example.alice.sqlitecurd.domain;

public class Person {
    private int personid;
    private String name;
    private int age;
    public Person(){
    }
    public Person(int personid, String name, int age){
        this.personid = personid;
        this.name = name;
        this.age = age;
    }
    public int getPersonid(){
        return personid;
    }
    public void setPersonid(){
        this.personid = personid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return "Person{" +
                "personid=" + personid +
                ",name='" + name + "\'" +
                ",age=" + age +
                "}";
    }
}
