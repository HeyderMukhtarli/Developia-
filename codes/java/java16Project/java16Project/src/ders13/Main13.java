package ders13;

public class Main13 {
    public static void main(String[] args) {
        Ust u=new Alt2 ();
        testIt(u);
    }

    public static void testIt(Ust ust){
        if(ust instanceof Alt){
            Alt real=(Alt)ust;
            real.doItAlt();
        }else if (ust instanceof Alt2){
            Alt2 real=(Alt2)ust;
            real.doItAlt2();
        }else{
            System.out.println("bu nov hetvan uygun gelir");
        }


    }
}
