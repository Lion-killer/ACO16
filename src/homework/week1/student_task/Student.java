package homework.week1.student_task;

/**
 * Created by gorobec on 08.10.16.
 */
public class Student {

    private String name;
    private String surname;
    private double averageMark;

//    public Student(){}

    public Student(String name, String surname, double averageMark){
        this.name = name;
        this.surname = surname;
        this.averageMark = averageMark;
    }

    public String getName(){
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int compareTo(Student student){
        return this.name.compareTo(student.name);
    }

    public double getMark() {
        return averageMark;
    }

    public void setMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString(){
        return String.format(" name - %s, surname - %s, average mark - %.2f", name, surname, averageMark);
    }
}
