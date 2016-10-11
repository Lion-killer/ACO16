package week1.employee_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class Senior extends Coder{


    public Senior(String name, String surname, String programmingLanguage) {
        super(name, surname, programmingLanguage);
    }

    @Override
    public void work() {
        System.out.println("I'm Senior dev");
    }

    @Override
    public String toString() {
        return "Senior{} " + super.toString();
    }
}
