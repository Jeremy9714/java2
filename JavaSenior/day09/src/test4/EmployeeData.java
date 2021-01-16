package test4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-01-16-20:46
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Tom",18));
        list.add(new Employee("Jason",10));
        list.add(new Employee("Sean",8));
        list.add(new Employee("Daniel",24));
        list.add(new Employee("Michael",34));
        list.add(new Employee("Franklin",28));
        list.add(new Employee("Mike",25));
        list.add(new Employee("Jimmy",16));
        list.add(new Employee("David",12));
        list.add(new Employee("David",12));
        return list;
    }
}
