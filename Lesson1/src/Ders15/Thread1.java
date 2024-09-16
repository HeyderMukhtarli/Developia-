package Ders15;

public class Thread1 extends Thread{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Thread1(String message) {
        this.message=message;
    }

    public void run() {
        System.out.println(message);

        }

}
