package Ders13.home3;

public class Main2 {
    // Custom checked exception class
    public class SuperException extends Exception {
        public SuperException(String message) {
            super(message);
        }
    }

    // Subclass of the checked exception
    public class SubException extends SuperException {
        public SubException(String message) {
            super(message);
        }
    }

    // Superclass with a method that throws a checked exception
    public class SuperClass {
        public void doSomething() throws SuperException {
            System.out.println("SuperClass: Doing something");
        }
    }

    // Subclass that overrides the method
    class SubClass extends SuperClass {
        @Override
        public void doSomething() throws SubException {
            System.out.println("SubClass: Doing something else");
            throw new SubException("Error in SubClass");
        }
    }

    // Another subclass that does not throw any exception
    class AnotherSubClass extends SuperClass {
        @Override
        public void doSomething(){
            System.out.println("AnotherSubClass: Doing another thing");
        }
    }

    // Main class to demonstrate the rules
    public class Main {
        public static void main(String[] args) {
            SuperClass obj1 = new Main2().new SubClass();
            try {
                obj1.doSomething();
            }catch(SuperException e) {
                System.err.println("Caught Exception: " + e.getMessage());


            SuperClass obj2 = new Main2().new AnotherSubClass();
            try {
                obj2.doSomething();
            } catch (SuperException ex) {
                System.err.println("Caught Exception: " + e.getMessage());
            }
        }
    }

}}
