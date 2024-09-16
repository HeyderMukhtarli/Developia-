package Ders16.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Employee> operators=new ArrayList<>();
        List<Employee> managers=new ArrayList<>();
        List<Employee> topManagers=new ArrayList<>();

        for(int i=0;i<200;i++){
            Random random = new Random();
            int randomNumber = random.nextInt(1001) + 1000;
            Operator o=new Operator( randomNumber);
            operators.add(o);
        }
        for(int i=0;i<50;i++){

            Random random = new Random();
            int randomNumber = random.nextInt(1001) + 2000;
           Manager m=new Manager( randomNumber);
           managers.add(m);
        }
        for(int i=0;i<10;i++){

            Random random = new Random();
            int randomNumber = random.nextInt(1001) + 3000;
            TopManager tM=new TopManager( randomNumber);
            topManagers.add(tM);
        }
        Company company=new Company();
        company.hireAll(operators);
        company.hireAll(managers);
        company.hireAll(topManagers);
        company.fire((int)Math.ceil(company.getEmployees().size()/2));
        System.out.println(company.getTopSalaryStaff(5));
        System.out.println(company.getLowestSalaryStaff(5));




    }
}
