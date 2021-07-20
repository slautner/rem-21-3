package de.neuefische.rem_21_3.objects;


import java.util.Random;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students) {
        this.students = students;
    }

    public Student[] list() {
        return this.students;
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < this.students.length; i++) {
            if (i > 0) {
                toString += ",";
            }

            Student student = this.students[i];
            toString += student.toString();
        }
        return toString;
    }

    public Student getRandomStudent() {
        int maxStudentArrayIndex = this.students.length;
        if (maxStudentArrayIndex > 0) {
            int randomIndex = new Random().nextInt(maxStudentArrayIndex);
            return this.students[randomIndex];
        }
        return null;
    }

    public void add(Student student) {
        int currentStudentsAmount = this.students.length;

        // create new array with a additional place for the student to be added
        int newStudentAmount = currentStudentsAmount + 1;
        Student[] newStudents = new Student[newStudentAmount];

        for (int i = 0; i < currentStudentsAmount; i++) {
            // student[0] = "Klaus"
            // student[1] = "Marie"
            // student[2] = "John"
            // copy all current students into the new array
            newStudents[i] = this.students[i];
        }

        // add the new student to the new array
        // student[3] = ""
        newStudents[newStudentAmount - 1] = student;

        // new students array is filled with old and with the additional student
        // assign new array as the new "state" of the StudentDB
        this.students = newStudents;
    }

    public void remove(Student studentToRemove) {

        int amountOfStudentsToBeRemoved = countStudents(studentToRemove);

        if (amountOfStudentsToBeRemoved == 0) {
            // the student to be removed is currently not in the student db - nothing to do
            return;
        }

        int currentStudentsAmount = this.students.length;
        // new students array size is the old size reduced by the amount of students found to be removed
        Student[] newStudents = new Student[currentStudentsAmount - amountOfStudentsToBeRemoved];

        int indexNewStudents = 0;
        for (int i = 0; i < currentStudentsAmount; i++) {
            // iterate over current student list and copy only
            // those students that are not equal to the student to be removed
            Student student = this.students[i];
            if (!student.equals(studentToRemove)) {
                newStudents[indexNewStudents] = student;
                indexNewStudents++;
            }
        }

        // new students array is filled with old students reduced by the one should ne removed
        // assign new array as the new "state" of the StudentDB
        this.students = newStudents;
    }

    private int countStudents(Student studentToCount) {
        int count = 0;
        for (int i = 0; i < this.students.length; i++) {
            Student student = this.students[i];
            if (student.equals(studentToCount)) {
                count++;
            }
        }
        return count;
    }
}
