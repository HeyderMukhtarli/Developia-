package ders17;

public class Bank {
    private  Double balance;
    private String lok1=new String();
    private String lok2=new String();

    public Double getBalance() {
        return balance;
    }

    public   void setBalance(Double balance) {
        this.balance = balance;
    }
    public   void drawMoney1(double amount){
        synchronized (lok1){
            this.balance-=amount;

        }


    }

    public   void drawMoney2(double amount){
        synchronized (lok2){
            this.balance-=amount;
        }


    }

}
