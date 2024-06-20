package ders17;

public class BankThread extends  Thread{
    Bank bank;
   public BankThread(Bank bank){
        this.bank=bank;
    }

    @Override
    public void run() {
        //bank.drawMoney(1);
    }
}
