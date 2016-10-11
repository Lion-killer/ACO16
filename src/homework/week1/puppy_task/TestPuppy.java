package homework.week1.puppy_task;

/**
 * Created by bilousyv on 12.10.2016.
 */
public class TestPuppy {
    public static void main(String[] args) {

        Puppy puppy = new Puppy("Tuzik");

        System.out.printf("Puppies name is %s\n", puppy.getName());
        puppy.giveTheVoice();
        puppy.jump();
        puppy.run();
        puppy.bite();

    }
}
