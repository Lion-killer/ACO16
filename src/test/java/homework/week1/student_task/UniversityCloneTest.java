package homework.week1.student_task;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by bilousyv on 10.11.2016.
 */
public class UniversityCloneTest {

    University artCode;

    @Before
    public void init() {

        artCode = new University("ArtCode", 5);

        Student student = new ContractStdent("Nick", "Smith", 5, 6);
        Student student2 = new ContractStdent("Jack", "Smith", 4, 3);
        Student student3 = new ContractStdent("John", "Smith", 3, 4);
        Student student4 = new ContractStdent("Kevin", "Smith", 4.5, 2);

        Student student5 = new BudgetStudent("David", "Smith", 5, 600);
        Student student6 = new BudgetStudent("Dan", "Smith", 4.3, 350);
        Student student7 = new BudgetStudent("Brandon", "Smith", 3.8, 400);
        Student student8 = new BudgetStudent("Jeremy", "Smith", 4.9, 250);

        Group group = new Group("ACO16", 4);
        Group group2 = new Group("ACB18", 4);

        group.addStudent(student);
        group.addStudent(student3);
        group.addStudent(student5);
        group.addStudent(student7);

        group2.addStudent(student2);
        group2.addStudent(student4);
        group2.addStudent(student6);
        group2.addStudent(student8);

        artCode.addGroup(group);
        artCode.addGroup(group2);

    }

    @Test
    public void testClone() throws Exception {

        University artCode1 = artCode.clone();

        assertNotSame("Compare university", artCode, artCode1);

        for (int groupIndex = 0; groupIndex < artCode.getGroupCount(); groupIndex++) {
            Group groupArtCode = artCode.getGroups()[groupIndex];
            Group groupArtCode1 = artCode1.getGroups()[groupIndex];
            assertNotSame("Compare group", groupArtCode, groupArtCode1);

            for (int studentIndex = 0; studentIndex < groupArtCode.getStudentsCount(); studentIndex++) {
                Student student = groupArtCode.getStudents()[studentIndex];
                Student student1 = groupArtCode1.getStudents()[studentIndex];
                assertNotSame("Compare student", student, student1);
            }
        }
   }
}
