package week1.employee_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class Coder extends Employee{
    String programmingLanguage;

    public Coder(String name, String surname, String programmingLanguage) {
        super(name, surname);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println("I'm coder I'm writing code");
    }

    public void code(){
        System.out.println("I'm codding");
    }

    @Override
    public String toString() {
        return super.toString() + " PL - " + programmingLanguage;
    }
}
