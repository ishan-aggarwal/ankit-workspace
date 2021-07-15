package edu.brandleis.MoneyMarket;

import java.util.Random;

public class MoneyMarketMain implements Runnable {

    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    MoneyMarket moneyMarket = new MoneyMarket(NACCOUNTS,INITIAL_BALANCE);

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        double accountNumber = Double.parseDouble(threadName.split("-")[1]);

        transfer(accountNumber);
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MoneyMarketMain marketMain = new MoneyMarketMain();
        for(int i=0;i<NACCOUNTS;i++) {
            Thread thread = new Thread(marketMain, "Thread-"+i);
            thread.start();

        }
        System.out.println(marketMain.moneyMarket.getAccounts());
    }

    public synchronized void transfer(double fromAccountNumber) {
        Random random = new Random();

        double toAccountNumber =  random.nextInt(10);
        double amount =  random.nextInt(1000) + 1;

        moneyMarket.transfer(fromAccountNumber,toAccountNumber,amount);
        System.out.println("Thread["+
                Thread.currentThread().getName()+", "+
                getClass().getName()+"]\t"+
                amount+" from "+ (int) fromAccountNumber+" to "+ (int) toAccountNumber+" "
                + "Total Balance: "+"\t"+moneyMarket.getTotalBalance());
    }

}
