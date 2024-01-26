//package ru.kata.spring.boot_security.demo.model;
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//@Entity
//@Table
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    @Column
//    private String name;
//    @Column
//    private String surname;
//    @Column
//    private int age;
//    @Column
//    private int telefon;
//
//    public User() {
//    }
//
//    public User(long id, String name, String surname, int age, int telefon) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.telefon = telefon;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getTelefon() {
//        return telefon;
//    }
//
//    public void setTelefon(int telefon) {
//        this.telefon = telefon;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", age=" + age +
//                ", telefon=" + telefon +
//                '}';
//    }
//}
