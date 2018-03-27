package project;
/* = Writer = Producer */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Writer implements Runnable {

    private final static Random generator = new Random();
    private  Rezervasyon rezervasyon;
    private ArrayList<Integer> list;

    //constructor
   // public Writer(Rezervasyon rezervasyon) {
    //    this.rezervasyon=rezervasyon;
    //}

  //thread'in run metodu
    @Override
    public void run() {
      
            try {
            	//makeReservation          	
                Thread.sleep(generator.nextInt(500000));
               // this.rezervasyon.makeReservation();
                
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        
    }
       
}
