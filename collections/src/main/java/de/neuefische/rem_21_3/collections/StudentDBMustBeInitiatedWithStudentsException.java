package de.neuefische.rem_21_3.collections;


/**
 * Checked Exception!
 */
public class StudentDBMustBeInitiatedWithStudentsException extends Exception {

    @Override
    public String getMessage() {
        return "During init of a StudentDB some Students must be provided";
    }
}
