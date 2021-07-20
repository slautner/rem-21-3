package de.neuefische.rem_21_3.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDBTest {

    @Test
    public void testSetupDBWithoutAnyStudents() {
//        String[] longArrayAssignment = new String[]{"foo", "bar"};
//        String[] shortArrayAssignment = {"foo", "bar"};
//        String[] singleAssignmentArrayInit = new String[2];
//        singleAssignmentArrayInit[0] = "foo";
//        singleAssignmentArrayInit[1] = "bar";

        // GIVEN
        // init db with empty array
        int expectedAMountOfStudentsInDB = 0;

        // WHEN
        Student[] students = {  /* students .... */};
        StudentDB studentDB = new StudentDB(students);

        // THEN
        int actualAmountOfStudents = studentDB.list().length;
        assertEquals(expectedAMountOfStudentsInDB, actualAmountOfStudents);
    }

    @Test
    public void testSetupDBWithStudentsLength() {
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");

        // GIVEN
        // init db with empty array
        int expectedAMountOfStudentsInDB = 2;

        // WHEN
        Student[] students = {studentKlaus, studentMarie};
        StudentDB studentDB = new StudentDB(students);

        // THEN
        int actualAmountOfStudents = studentDB.list().length;
        assertEquals(expectedAMountOfStudentsInDB, actualAmountOfStudents);
    }

    @Test
    public void testSetupDBWithStudentsEquals() {
        // GIVEN
        Student[] expectedStudents = {new Student("Klaus"), new Student("Marie")};

        // WHEN
        Student[] dbStudents = {new Student("Klaus"), new Student("Marie")};
        StudentDB studentDB = new StudentDB(dbStudents);

        // THEN
        Student[] actualStudents = studentDB.list();
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testStudentDBWithStudentsToString() {
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");

        // GIVEN
        String expectedStudentString = "[id=-1, name=Klaus],[id=-1, name=Marie]";

        // WHEN
        Student[] students = {studentKlaus, studentMarie};
        StudentDB studentDB = new StudentDB(students);

        // THEN
        String actualStudentDBString = studentDB.toString();

        assertEquals(expectedStudentString, actualStudentDBString);
    }

}
