package ders17;

public class MainBank {
    public static void main(String[] args) throws InterruptedException {
        Bank abb=new Bank();
        abb.setBalance(100D);

        BankThread[] threads=new BankThread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i]=new BankThread(abb);
        }

        for ( BankThread th: threads) {
            th.start();
        }
        Thread.sleep(1000);
        System.out.println(abb.getBalance());

    }
}
