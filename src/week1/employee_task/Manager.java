package week1.employee_task;

import java.util.Arrays;

/**
 * Created by gorobec on 09.10.16.
 */
public class Manager extends Employee{

    int salary;

    Employee[] employees;

    private int employeeCount;

    public Manager(String name, String surname){
        super(name, surname);
    }

    public Manager(String name, String surname, int salary, int employeeSize) {
        super(name, surname);
        this.salary = salary;
        employees = new Employee[employeeSize];
    }

    public boolean addEmployee(Employee employee) {
        if(employeeCount == employees.length) return false;
        employees[employeeCount] = employee;
        employeeCount++;
        return true;
    }

    public void startWorkingDay(){
        for (int i = 0; i < employeeCount; i++) {
//            getInstance(employees[i]);
//            getClassMethod(employees[i]);
            System.out.println(employees[i].getClass().getName());
            employees[i].work();
        }
    }

    private void getClassMethod(Employee employee) {
        if(employee.getClass() == Coder.class){
            System.out.println("Coder");
        } else {
            System.out.println("Not coder");
        }

        if(employee.getClass() == Manager.class){
            System.out.println("Manager");
//            ClassCastException
            /*Coder coder = (Coder)employee;
            coder.code();*/
        } else{
            System.out.println("Not manager");
        }

        if(employee.getClass() == Employee.class){
            System.out.println("Employee");

        } else{
            System.out.println("Not employee");
        }
    }

    private void getInstance(Employee employee) {
        if(employee instanceof Coder){
            System.out.println("Coder");
            Coder coder = (Coder)employee;
            coder.code();
        } else {
            System.out.println("Not coder");
        }

        if(employee instanceof Manager){
            System.out.println("Manager");
//            ClassCastException
            /*Coder coder = (Coder)employee;
            coder.code();*/
        } else{
            System.out.println("Not manager");
        }

        if(employee instanceof Employee){
            System.out.println("Employee");

        } else{
            System.out.println("Not employee");
        }
    }

    @Override
    public void work(){
        System.out.println("I'm manager, and I'm working");

    }

    @Override
    public String toString() {
        return super.toString() +
                "salary=" + salary +
                ", employees=" + Arrays.toString(employees) +
                "} ";
    }
}
