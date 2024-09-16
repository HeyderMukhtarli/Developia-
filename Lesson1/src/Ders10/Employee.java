package Ders10;

public class Employee extends Person{
    int salary;
    String department;
    String username;
    String password;
    public void printInfo(){

        super.printInfo();
        System.out.println(String.format("salary %d department %s username %s password %s",salary,department,username,password));
    }
}
