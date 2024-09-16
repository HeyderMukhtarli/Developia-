package Ders8;

public class Main {
    public static void main(String[] args) {
        Bank b=new Bank(3000);
        Product p1=new Product("alma",2,3);
        Product p2=new Product("banan",3,2);

        Product[] pr=new Product[]{p1,p2};
        Basket bs=new Basket(pr);
        double money=b.drowMoney(bs);
//        System.out.println(money);

//        String one="one";
//        String t="one";
//        System.out.println(one.equals(t));
//        System.out.println(one==t);
//        String one1=new String("one");
//        String t1="one";
//        System.out.println(one1.equals(t1));
//        System.out.println(one1==t1);
//        String one2=new String("one");
//        String t2=new String("one");
//        System.out.println(one2.equals(t2));
//        System.out.println(one2==t2);
//        t1="d";
//        one1="dds";
//        System.out.println(one1);
//        System.out.println(t1);

        String mes="bearaberdirag";
        int i=0;
        int count=0;
        while (i!=-1){
            i=mes.indexOf("ra",i);
            if(i==-1)break;

            count++;
            i+=1;

        }
        System.out.println(count);

        String s=new String("text");
        String s1=new String("text");
        System.out.println(s==s1);



    }
}
