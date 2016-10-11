package week1.employee_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class Middle extends Coder {


    public Middle(String name, String surname, String programmingLanguage) {
        super(name, surname, programmingLanguage);
    }

    @Override
    public void work() {
        System.out.println("I'm Middle dev");
    }

    @Override
    public String toString() {
        return "Middle{} " + super.toString();
    }
}
