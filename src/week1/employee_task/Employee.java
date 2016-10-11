package week1.employee_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class Employee {
    String name;
    String surname;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public void work(){
        System.out.println("I'm employee, and I'm working");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
