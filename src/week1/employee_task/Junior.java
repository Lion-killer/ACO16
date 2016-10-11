package week1.employee_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class Junior extends Coder {


    public Junior(String name, String surname, String programmingLanguage) {
        super(name, surname, programmingLanguage);
    }


    @Override
    public void work() {
        System.out.println("I'm Junior");
    }

    @Override
    public String toString() {
        return "Junior{} " + super.toString();
    }
}
