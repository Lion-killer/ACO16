package homework.week1.puppy_task;

/**
 * Created by bilousyv on 12.10.2016.
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Предположим что все животные это умеют
    public void giveTheVoice(){
        System.out.printf("Voice of %s\n", name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
