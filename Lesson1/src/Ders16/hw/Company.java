package Ders16.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Company {
    private List<Employee> employees=new ArrayList<>();


    public List<Employee> getEmployees() {
        return employees;
    }



    public void hire(Employee e){
        e.onHire();
        employees.add(e);

    }
    public void hireAll(List<Employee> emp){
        employees =Stream.concat(employees.stream(), emp.stream())
                .collect(Collectors.toList());
    }
    public void fire(int count){
        for(int i=0;i<count;i++){
            employees.get(0).onFire();
            employees.remove(0);
        }

    }
    public List<Employee> getTopSalaryStaff(int count){
     Collections.sort(employees,Comparator.reverseOrder());

        // Get the top 5 employees
        List<Employee> topFiveEmployees = employees.subList(0, Math.min(count, employees.size()));
        return topFiveEmployees;
    }
    public List<Employee> getLowestSalaryStaff(int count){
       Collections.sort(employees);

        // Get the top 5 employees
        List<Employee> lowestFiveEmployees = employees.subList(0, Math.min(count, employees.size()));
        return lowestFiveEmployees;

    }
}
