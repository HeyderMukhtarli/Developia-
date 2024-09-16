package Ders16.hw;

public class Operator implements  Employee{
    private int salary;


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Operator(int salary) {
        this.salary=salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void onFire() {

    }

    @Override
    public void onHire() {

    }

    @Override
    public String toString() {
        return "Operator{" +
                "salary=" + salary +
                '}';
    }
    @Override
    public int compareTo(Employee o) {

        return this.getMonthSalary()-o.getMonthSalary();
    }

}

