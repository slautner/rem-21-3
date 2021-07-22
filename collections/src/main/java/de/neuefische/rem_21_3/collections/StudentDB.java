package de.neuefische.rem_21_3.collections;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentDB {

    private List<Student> students;

    public StudentDB(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<Student> list() {
        return this.students;
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < this.students.size(); i++) {
            if (i > 0) {
                toString += ",";
            }

            Student student = this.students.get(i);
            toString += student.toString();
        }
        return toString;
    }

    public Student getRandomStudent() {
        int maxStudentArrayIndex = this.students.size();
        if (maxStudentArrayIndex > 0) {
            int randomIndex = new Random().nextInt(maxStudentArrayIndex);
            return this.students.get(randomIndex);
        }
        return null;
    }

    public void add(Student student) {
        this.students.add(student);
    }

    public void remove(Student studentToRemove) {
        this.students.remove(studentToRemove);
    }
}
