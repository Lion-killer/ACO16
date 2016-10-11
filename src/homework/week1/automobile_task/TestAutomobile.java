package homework.week1.automobile_task;


/*
1. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку ав-
томобиля.
*/

public class TestAutomobile {
    public static void main(String[] args) {

        Motor motor = new Motor(4, "diesel");

        Automobile automobile = new Automobile("Ferrari", motor);

        Wheel wheel1 = new Wheel("Winter", "Michelin");
        Wheel wheel2 = new Wheel("Winter", "Michelin");
        Wheel wheel3 = new Wheel("Winter", "Michelin");
        Wheel wheel4 = new Wheel("Winter", "Michelin");

        automobile.setWheel(wheel1, 1);
        automobile.setWheel(wheel2, 2);
        automobile.setWheel(wheel3, 3);
        automobile.setWheel(wheel4, 4);

        automobile.refuel(10);

        System.out.println(automobile);

        automobile.drive();

    }
}
