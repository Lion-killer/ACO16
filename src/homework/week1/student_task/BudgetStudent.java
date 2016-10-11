package homework.week1.student_task;

/**
 * Created by gorobec on 09.10.16.
 */
public class BudgetStudent extends Student{

    private long scholarship;


    public BudgetStudent(String name, String surname, double averageMark, long scholarship) {
        super(name, surname, averageMark);
        this.scholarship = scholarship;
    }

    public long getScholarship() {
        return scholarship;
    }

    public void setScholarship(long scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "BudgetStudent " +
                "scholarship - " + scholarship + super.toString();
    }
}
