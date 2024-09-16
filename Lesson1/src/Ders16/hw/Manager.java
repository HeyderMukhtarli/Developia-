package Ders16.hw;

public class Manager implements  Employee{
    private int salary;


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Manager(int salary) {
        this.salary=salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void onFire() {
        System.out.println("Manager was fired");
    }

    @Override
    public void onHire() {
        System.out.println("Manager was hired");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "salary=" + salary +
                '}';
    }
    @Override
    public int compareTo(Employee o) {

        return this.getMonthSalary()-o.getMonthSalary();
    }

}
