package homework.week1.puppy_task;

/**
 * Created by bilousyv on 12.10.2016.
 */
public class Puppy extends Dog {

    public Puppy(String name) {
        super(name);
    }

    // предположим что прыгать может только щенок в силу своего возвраста )))
    public void jump(){
        System.out.printf("%s is jumping\n", getName());
    }
}
