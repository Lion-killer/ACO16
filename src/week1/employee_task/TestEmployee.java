package week1.employee_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class TestEmployee {
    public static void main(String[] args) {

        Employee employee = new Employee("Jack", "Smith");

        Manager manager = new Manager("John", "Smith", 2500, 15);

        Junior junior = new Junior("Ann", "Smith", "Java");

        Middle middle = new Middle("Kate", "Smith", "Java");

        Senior senior = new Senior("Joshua", "Smith", "Java");



        System.out.println(employee);
        System.out.println(manager);
        System.out.println(junior);
        System.out.println(middle);
        System.out.println(senior);


        manager.addEmployee(junior);
        manager.addEmployee(middle);
        manager.addEmployee(senior);
        manager.addEmployee(manager);

        manager.startWorkingDay();


    }
}
