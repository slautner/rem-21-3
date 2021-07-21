package de.neuefische.rem_21_3.collections;


public class Student {

    /**
     * A constant integer value that means that no id has been set so far for a student.
     */
    public static final int UNDEFINED = -1;

    /**
     * Declare "final" to ensure the name is mandatory and must be set during creation of the object in the constructor.
     * <p>
     * Please note: if a property is declared as final, no setter will be declared.
     * Once an object is initialized, a final property can not be modified.
     */
    private final String name;

    /**
     * The unique id of the student, will be used later, initial set to an "undefined" value.
     */
    private int id = UNDEFINED;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[id=" + getId() + ", name=" + getName() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;
        return this.getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
