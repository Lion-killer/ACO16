package homework.week1.student_task;

import java.util.Arrays;

/**
 * Created by gorobec on 09.10.16.
 */
public class Group {

    private String name;
    private Student[] students;
    private int studentsCount;

    public Group(String name, int groupSize) {
        this.name = name;
        students = new Student[groupSize];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public Student[] getStudents() {
        return students;
    }

    public boolean addStudent(Student student){
        if (studentsCount == students.length || student == null) return false;

        students[studentsCount] = student;
        studentsCount++;
        return true;
    }

    public boolean delStudent(String name, String surname){

        int indexOfStudent = getIndexOfStudents(name, surname);
        if (indexOfStudent < 0) return false;

        Student[] studentsCopy = new Student[students.length - indexOfStudent];
        System.arraycopy(students, indexOfStudent + 1, studentsCopy, 0, studentsCopy.length - 1);
        System.arraycopy(studentsCopy, 0, students, indexOfStudent, studentsCopy.length);
        studentsCount--;

        return true;
    }

    private int getIndexOfStudents(String name, String surname){
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(name)&& students[i].getSurname().equals(surname))
                return i;
        }
        return -1;
    }

    private int getIndexOfStudents(String name){
        for (int i = 0; i < studentsCount; i++) {
            if (students[i].getName().equals(name))
                return i;
        }
        return -1;
    }

    public void findStudentByName(String name){
        int indexOfStudent = getIndexOfStudents(name);
        if (indexOfStudent < 0)
            System.out.printf("Student with name %s not found!\n", name);
        else
            System.out.println(students[indexOfStudent]);
    }

    public void studentsSorting(){

        for (int i = 0; i < studentsCount; i++) {
            for (int j = 0; j < studentsCount; j++) {
                if (students[i].compareTo(students[j]) < 1)
                    swap(students, i, j);
            }
        }

    }

    private static void swap(Student[] array, int i, int j){
        Student temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public void showStudents() {
        for (int i = 0; i < studentsCount; i++) {
            System.out.println(students[i]);
        }

    }
}
