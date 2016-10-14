package homework.week1.student_task;

/**
 * Created by gorobec on 08.10.16.
 */
public class Student implements Comparable{

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

    @Override
    public int compareTo(Object o){

        if (this == o) return 0;

        if (o != null && getClass() != o.getClass()){
            Student tmp = (Student) o;
            return this.name.compareTo(tmp.name);
        }
        return - 1;
    }

    public double getMark() {
        return averageMark;
    }

    public void setMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return surname != null ? surname.equals(student.surname) : student.surname == null;

    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString(){
        return String.format(" name - %s, surname - %s, average mark - %.2f", name, surname, averageMark);
    }

//    @Override
//    public int compareTo(Object o) {
//        return this.co;
//    }
}
