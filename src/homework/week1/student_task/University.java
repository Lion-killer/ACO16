package homework.week1.student_task;

import java.util.Arrays;

/**
 * Created by gorobec on 09.10.16.
 */
public class University {
    private String name;
    private Group[] groups;
    private int groupCount;

    public University(String name, int groupSize) {
        this.name = name;
        this.groups = new Group[groupSize];
    }


    public boolean addGroup(Group group){
        if(groupCount == groups.length || group == null) return false;
        groups[groupCount] = group;
        groupCount++;
        return true;
    }

    public boolean delGroup(String name){

        int indexOfGroup = getIndexOfGroup(name);
        if (indexOfGroup < 0) return false;

        Student[] groupsCopy = new Student[groups.length - indexOfGroup];
        System.arraycopy(groups, indexOfGroup + 1, groupsCopy, 0, groupsCopy.length - 1);
        System.arraycopy(groupsCopy, 0, groups, indexOfGroup, groupsCopy.length);
        groupCount--;

        return true;
    }

    private int getIndexOfGroup(String name){
        for (int i = 0; i < groupCount; i++) {
            if (groups[i].getName().equals(name))
                return i;
        }
        return -1;
    }

    public void showGroups(){
        for (int i = 0; i < groupCount; i++) {
            System.out.printf("%d. - %s\n", i + 1, groups[i].getName());
        }
    }

    public void showStudents(){
        for (int i = 0; i < groupCount; i++) {
            groups[i].showStudents();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public int getGroupCount() {
        return groupCount;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
