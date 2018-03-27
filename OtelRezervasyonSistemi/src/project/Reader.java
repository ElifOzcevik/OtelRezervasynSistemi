package project;

/* = Reader = Consumer */

import java.util.Random;

public class Reader implements Runnable {

    private final static Random generator = new Random();
    private  Rezervasyon rezervasyon; //thread'ler tanýmlanýr ve çalýþtýrýlýr


    
   
  //thread'in genel run metodu
    @Override
    public void run() {
    
            try {
                Thread.sleep(generator.nextInt(11000));
               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
     
        System.out.println("\n\n\t\t Rezervasyon bakýlýyor.!\n");
    }

    
}

