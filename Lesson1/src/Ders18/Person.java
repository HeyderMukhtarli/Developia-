package Ders18;

public class Person {
    int id;
    String name;
    String surname;
    String age;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Person(int id, String name, String surname, String age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
