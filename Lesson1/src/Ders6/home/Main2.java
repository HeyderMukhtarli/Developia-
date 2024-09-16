package Ders6.home;

public class Main2 {
    public static void main(String[] args) {
        Circle circle1=new Circle(2);
        Calculator calc=new Calculator();
        calc.calculateCircleLength(circle1);
         System.out.println(circle1.length);
    }
}
