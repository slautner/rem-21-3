package de.neuefische.rem_21_3.collections;

/**
 * Unchecked Exception!
 */
public class RandomStudentNotAvailableForEmptyDBRuntimeException extends RuntimeException {

    public RandomStudentNotAvailableForEmptyDBRuntimeException() {
    }

    public RandomStudentNotAvailableForEmptyDBRuntimeException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "You cannot call random Student for an empty DB";
    }
}
