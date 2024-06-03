package d12.d11;

public class Main12 {
    public static void main(String[] args) {
        YemekYeyeBilen[] yeyeBilenler=new YemekYeyeBilen[3];
        yeyeBilenler[0]=new Dog();
        yeyeBilenler[1]=new Fish();
        yeyeBilenler[2]=new Eagle();
        for(YemekYeyeBilen animal: yeyeBilenler){
            animal.eat();
        }

    }
}
