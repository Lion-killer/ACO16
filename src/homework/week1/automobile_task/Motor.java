package homework.week1.automobile_task;

/**
 * Created by bilousyv on 11.10.2016.
 */
public class Motor {

    double motorCapacity;
    String type;

    public Motor(double motorCapacity, String type) {
        this.motorCapacity = motorCapacity;
        this.type = type;
    }

    public double getMotorCapacity() {
        return motorCapacity;
    }

    public String getType() {
        return type;
    }
}
