package homework.week1.student_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class ContractStdent extends Student{
    private int period;

    public ContractStdent(String name, String surname, double averageMark, int period) {
        super(name, surname, averageMark);
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "ContractStdent " +
                "period - " + period + super.toString();
    }
}
