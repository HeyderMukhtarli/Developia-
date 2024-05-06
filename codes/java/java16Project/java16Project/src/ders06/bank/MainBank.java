package ders06.bank;

public class MainBank {
    public static void main(String[] args) {
        Bank kapital=new Bank();
        kapital.balance=300;

        kapital.showBalance();

        Product apple=new Product("quba almasi",30);
        Product armud=new Product("seki armudu",50);

        Shopping shopping=new Shopping();
        shopping.shop(kapital,armud,3);
        kapital.showBalance();



    }


}


class Bank{
    int balance;

    void drawMoney(int amount){
        balance-=amount;
    }

    void  showBalance(){
        System.out.println("cari balance = "+balance);
    }
}

class Product{
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}


class  Shopping{


    void shop(Bank b,Product p,int quantity){
        int total=p.price*quantity;
        b.drawMoney(total);
        System.out.println("alinan mehsul = "+p.name+", miqdarida = "+quantity);
        System.out.println("qalan pl = "+b.balance);
    }
}