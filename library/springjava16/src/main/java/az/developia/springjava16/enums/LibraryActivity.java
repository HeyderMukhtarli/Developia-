package az.developia.springjava16.enums;

public enum LibraryActivity {
    BORROW("Borrowed a book"),
    RETURN("Returned a book");

    private final String activityDescription;

    // Constructor
    LibraryActivity(String activityDescription) {
        this.activityDescription = activityDescription;
    }
    }