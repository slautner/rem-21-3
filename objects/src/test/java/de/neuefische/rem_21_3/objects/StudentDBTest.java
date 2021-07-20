package de.neuefische.rem_21_3.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentDBTest {

    @Test
    public void testSetupDBWithoutAnyStudents() {
        // GIVEN
        // init db with empty array
        Student[] students = {  /* students .... */};
        StudentDB studentDB = new StudentDB(students);

        // WHEN
        int actualAmountOfStudents = studentDB.list().length;

        // THEN
        int expectedAMountOfStudentsInDB = 0;
        assertEquals(expectedAMountOfStudentsInDB, actualAmountOfStudents);
    }

    @Test
    public void testSetupDBWithStudentsLength() {
        // GIVEN
        // init db with non empty array
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student[] students = {studentKlaus, studentMarie};
        StudentDB studentDB = new StudentDB(students);

        // WHEN
        int actualAmountOfStudents = studentDB.list().length;

        // THEN
        int expectedAMountOfStudentsInDB = 2;
        assertEquals(expectedAMountOfStudentsInDB, actualAmountOfStudents);
    }

    @Test
    public void testSetupDBWithStudentsEquals() {
        // GIVEN
        Student[] dbStudents = {new Student("Klaus"), new Student("Marie")};
        StudentDB studentDB = new StudentDB(dbStudents);

        // WHEN
        Student[] actualStudents = studentDB.list();

        // THEN
        Student[] expectedStudents = {new Student("Klaus"), new Student("Marie")};
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testStudentDBWithStudentsToString() {
        // GIVEN
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student[] students = {studentKlaus, studentMarie};
        StudentDB studentDB = new StudentDB(students);

        // WHEN
        String actualStudentDBString = studentDB.toString();

        // THEN
        String expectedStudentString = "[id=-1, name=Klaus],[id=-1, name=Marie]";
        assertEquals(expectedStudentString, actualStudentDBString);
    }

    @Test
    public void testRandomStudent() {
        // GIVEN
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");
        Student[] students = {studentKlaus, studentMarie, studentJohn};
        StudentDB studentDB = new StudentDB(students);

        for (int i = 0; i < 100; i++) {

            // WHEN
            Student actualRandomStudent = studentDB.getRandomStudent();

            // THEN
            assertNotNull(actualRandomStudent);

        }
    }

    @Test
    public void testAddStudent() {
        // GIVEN
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");
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
        // GIVEN
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");
        Student studentKlara = new Student("Klara");
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
        // GIVEN
        Student studentKlaus = new Student("Klaus");
        Student studentMarie = new Student("Marie");
        Student studentJohn = new Student("John");
        Student studentKlara = new Student("Klara");
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
