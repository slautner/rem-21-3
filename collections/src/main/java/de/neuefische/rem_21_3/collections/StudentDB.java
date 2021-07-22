package de.neuefische.rem_21_3.collections;


import java.util.*;

public class StudentDB {

    private Map<Integer, Student> students;

    public StudentDB(List<Student> students) {
        this.students = new HashMap<>();
        for (Student student : students) {
            add(student);
        }
    }

    public List<Student> list() {
        return new ArrayList<>(students.values());
    }

    @Override
    public String toString() {
        String toString = "";
        boolean firstEntry = true;
        for (Student student : students.values()) {
            if (firstEntry) {
                firstEntry = false;
            } else {
                toString += ",";
            }
            toString += student.toString();
        }

        return toString;
    }

    public Student getRandomStudent() {
        List<Student> studentList = list();
        int maxStudentArrayIndex = studentList.size();
        if (maxStudentArrayIndex > 0) {
            int randomIndex = new Random().nextInt(maxStudentArrayIndex);
            return studentList.get(randomIndex);
        }
        return null;
    }

    public void add(Student student) {
        this.students.put(student.getId(), student);
    }

    public void remove(Student studentToRemove) {
        this.students.remove(studentToRemove.getId());
    }
}
