package d12.d11;

public class Main {
    public static void main(String[] args) {
        Alt a1=new Alt();
        a1.name="Adil";
        a1.salary=200;
        a1.doIt();
        Computer dell=new Computer();
        dell.brand="Dell";
        dell.price=222;
        dell.ram=new Ram(20,2000);
        Ram r=new Ram(20,2000);

    }
}
