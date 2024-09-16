package Ders13.home1;

public class OutOfRangeValueException extends RuntimeException{
    public OutOfRangeValueException() {
    }

    public OutOfRangeValueException(String message) {
        super(message);
    }

    public OutOfRangeValueException(Throwable cause) {
        super(cause);
    }
}
