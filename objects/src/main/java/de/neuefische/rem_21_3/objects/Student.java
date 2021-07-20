package de.neuefische.rem_21_3.objects;


public class Student {

    public static final int UNDEFINED = -1;

    private final String name;
    private int id = UNDEFINED;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + "]";
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
