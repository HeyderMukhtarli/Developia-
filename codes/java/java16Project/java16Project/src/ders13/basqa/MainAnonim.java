package ders13.basqa;

public class MainAnonim {
    public static void main(String[] args) {
        Eatable tom=new Eatable(){

            @Override
            public void eat() {
                System.out.println("sud icir");
            }
        };
        tom.eat();
    }
}
