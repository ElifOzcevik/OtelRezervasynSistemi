package project;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mysql.jdbc.ResultSetMetaData;


public class test {

	public static void main(String[] args) throws InterruptedException
	{
		

		
		
		
		   Menu z=new Menu();
			z.Menu1();
		

		//thread havuzu oluþturulur
			ExecutorService application = Executors.newCachedThreadPool();

			//thread'ler tanýmlanýr ve çalýþtýrýlýr
			Rezervasyon rezervasyon = new SynchronizedRezervasyon();
			// application.execute();
			// application.execute(new Reader());
			application.execute(new Reader());
			application.execute(new Reader());
			application.execute(new Reader());
	
			application.execute(new Writer());

			application.shutdown();
     
	} //main end

}//class end