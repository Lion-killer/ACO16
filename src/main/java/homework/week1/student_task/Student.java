package homework.week1.student_task;

/**
 * Created by gorobec on 08.10.16.
 */
public class Student implements Comparable<Student>, Cloneable{

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
    public int compareTo(Student student){

        if (this == student) return 0;
        if (student == null) return - 1;

        int answer = this.name.compareTo(student.name);
        if (answer == 0){
            return this.surname.compareTo(student.surname);
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
    public String toString(){
        return String.format(" name - %s, surname - %s, average mark - %.2f", name, surname, averageMark);
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

}
