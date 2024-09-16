package Ders10;

public class Person {
    int id;
    String  name;
    String surname;
    int age;
    String phone;
    String address;

    public void printInfo(){
        System.out.println(String.format("id %d name %s surname %s age %d phone %s address %s",id,name,surname,age,phone,address ));
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
