package homework.week1.puppy_task;

/**
 * Created by bilousyv on 12.10.2016.
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public void run(){
        System.out.printf("%s is runs\n", getName());
    }

    public void bite(){
        System.out.printf("%s is bites\n", getName());
    }
}
