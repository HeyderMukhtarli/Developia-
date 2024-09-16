package Ders5.home;

public class Employee {
    Integer id;
    String name;
    String surname;
    String phone;
    String address;
    int salary;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee(String name,  String phone,  int salary) {
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }
}

