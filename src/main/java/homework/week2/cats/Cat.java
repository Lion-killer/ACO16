package homework.week2.cats;

import java.util.ArrayList;

/**
 * Created by bilousyv on 25.10.2016.
 */
public class Cat {

    private String name;
    private static ArrayList<Cat> cats = new ArrayList<>();

    public Cat(String name) {
        this.name = name;
        cats.add(this);
    }

    public static void printCats(){
        System.out.println(cats.toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
