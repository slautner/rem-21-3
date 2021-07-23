package de.neuefische.rem_21_3.collections;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class StudentDB {

    private Map<Integer, Student> students;

    public StudentDB(List<Student> students) throws StudentDBMustBeInitiatedWithStudentsException {
        if (students == null || students.isEmpty()) {
            throw new StudentDBMustBeInitiatedWithStudentsException();
        }

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
        if (studentList.isEmpty()) {
            throw new RandomStudentNotAvailableForEmptyDBRuntimeException();
        }

        int maxStudentArrayIndex = studentList.size();
        if (maxStudentArrayIndex > 0) {
            int randomIndex = new Random().nextInt(maxStudentArrayIndex);
            return studentList.get(randomIndex);
        }
        return null;
    }

    public Optional<Student> getStudentByName(String studentName) {
        List<Student> studentList = list();
        for (Student student : studentList) {
            if (student.getName().equals(studentName)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public void add(Student student) {
        this.students.put(student.getId(), student);
    }

    public void remove(Student studentToRemove) {
        this.students.remove(studentToRemove.getId());
    }
}
