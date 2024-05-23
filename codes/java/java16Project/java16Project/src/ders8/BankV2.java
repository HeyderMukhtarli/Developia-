package ders8;


import java.math.BigDecimal;

public class BankV2 {
    public static void main(String[] args) {
       Bank kapital=new  Bank(new BigDecimal("100"));
        kapital.showBalance();

         Product alma=new  Product("quba almasi",new BigDecimal("10"));
         Product armud=new  Product("seki armudu",new BigDecimal("3"));
        Product alca=new  Product("goyce",new BigDecimal("2"));


         Shopping shopping=new  Shopping();

        shopping.shop(kapital,new Basket(alma,new BigDecimal("5")),new Basket(armud,new BigDecimal("2"))
                ,new Basket(alca,new BigDecimal("4")));

        // kapital.showBalance();



    }


}


class Bank{
    BigDecimal balance;
    Bank(BigDecimal balance){
        this.balance=balance;
    }

    void drawMoney(BigDecimal amount){
        // immutable
        BigDecimal  percent=amount.multiply(new BigDecimal("0.02"));
        balance=balance.subtract(amount);

        balance=balance.add(percent);


    }

    void  showBalance(){
        System.out.println("cari balance = "+balance);
    }

    public boolean checkBalance(BigDecimal total) {
        if(this.balance.compareTo(total)>=0){
           return true;
        }else{
            return false;
        }
    }
}

  class Product{
    String name;
    BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}


class  Shopping{


    void shop(  Bank b,Basket ... products ){
        BigDecimal total=new BigDecimal("0");

        for (Basket basket:
        products) {
           total= total.add(basket.product.price.multiply(basket.quantity));
            System.out.println("alinan mehsul = "+basket.product.name+", miqdarida = "+basket.quantity);
        }

        if(!b.checkBalance(total)){
            System.out.println("balansda kifayet qeder mebleg yoxdur");
            return;
        }


        b.drawMoney(total);

        System.out.println("qalan pul = "+b.balance);
    }
}

class Basket{
    Product product;
    BigDecimal quantity;

    public Basket(Product product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}