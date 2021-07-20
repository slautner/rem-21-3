package de.neuefische.rem_21_3.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    public void testRandomStudent() {
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");

        // GIVEN
        Student[] students = {studentKlaus, studentMarie, studentJohn};
        StudentDB studentDB = new StudentDB(students);

        // WHEN

        // THEN
        for (int i = 0; i < 100; i++) {
            Student actualRandomStudent = studentDB.getRandomStudent();
            assertNotNull(actualRandomStudent);
        }
    }

    @Test
    public void testAddStudent() {
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");

        // GIVEN
        Student[] students = {studentKlaus, studentMarie, studentJohn};
        StudentDB studentDB = new StudentDB(students);
        assertEquals(3, studentDB.list().length);

        // WHEN
        Student studentKlara = new Student("Klara");
        studentDB.add(studentKlara);

        // THEN
        assertEquals(4, studentDB.list().length);
        assertEquals(studentKlaus, studentDB.list()[0]);
        assertEquals(studentKlara, studentDB.list()[studentDB.list().length - 1]);
    }

    @Test
    public void testRemoveStudent() {
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");
        Student studentKlara = new Student("Klara");

        // GIVEN
        Student[] students = {studentKlaus, studentMarie, studentJohn, studentKlara};
        StudentDB studentDB = new StudentDB(students);
        assertEquals(4, studentDB.list().length);

        // WHEN
        studentDB.remove(studentMarie);

        // THEN
        assertEquals(3, studentDB.list().length);
        assertEquals(studentKlaus, studentDB.list()[0]);
        assertEquals(studentJohn, studentDB.list()[1]);
        assertEquals(studentKlara, studentDB.list()[studentDB.list().length - 1]);
    }

    @Test
    public void testRemoveUnknownStudent() {
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");
        Student studentKlara = new Student("Klara");

        // GIVEN
        Student[] students = {studentKlaus, studentMarie, studentJohn, studentKlara};
        StudentDB studentDB = new StudentDB(students);
        assertEquals(4, studentDB.list().length);

        // WHEN
        Student studentUnknown = new Student("Unknown");
        studentDB.remove(studentUnknown);

        // THEN
        assertEquals(4, studentDB.list().length);
        assertEquals(studentKlaus, studentDB.list()[0]);
        assertEquals(studentKlara, studentDB.list()[studentDB.list().length - 1]);
    }
}
