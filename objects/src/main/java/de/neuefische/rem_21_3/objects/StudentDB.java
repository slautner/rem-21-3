package de.neuefische.rem_21_3.objects;


public class StudentDB {

    private final Student[] students;

    public StudentDB(Student[] students) {
        this.students = students;
    }

    public Student[] list() {
        return students;
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            toString += student.toString() + ",";
        }

        return toString;
    }
}
