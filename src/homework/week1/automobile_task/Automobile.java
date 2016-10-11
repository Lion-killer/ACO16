package homework.week1.automobile_task;

/**
 * Created by bilousyv on 11.10.2016.
 */
public class Automobile {

    private String model;
    private Wheel[] wheels = new Wheel[4];
    private Motor motor;
    private int amountOfFuel;

    public Automobile(String model, Motor motor) {
        this.model = model;
        this.motor = motor;
    }

    public void drive(){

        if (amountOfFuel == 0){
            System.out.println("No fuel");
        } else if (!allWheelArePresent()){
            System.out.println("Not all wheels are present");
        } else {
            System.out.println("We are driving");
            amountOfFuel--;
        }
    }

    public void refuel(double quantity){
        amountOfFuel += quantity;
    }

    private boolean allWheelArePresent(){
        for (Wheel wheel:wheels) {
            if (wheel == null)
                return false;
        }
        return true;
    }

    public boolean setWheel(Wheel wheel, int position){
        if(position > 0 && position <= 4)
            wheels[position - 1] = wheel;
        else
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "model='" + model + '\'' +
                '}';
    }
}
