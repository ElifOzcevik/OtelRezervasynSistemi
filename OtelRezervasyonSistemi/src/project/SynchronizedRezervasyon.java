package project;


import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import project.RezervasyonÝsteði;
import project.Otel;
import project.RezervasyonGeçmiþi;
import project.veritabaný;
import java.sql.*;
public class SynchronizedRezervasyon implements Rezervasyon {


  private ReadWriteLock accessLock = new ReentrantReadWriteLock();
  private final Lock readLock = accessLock.readLock();
  private final Lock writeLock = accessLock.writeLock();
	
  
  
  
  
  public void  queryReservation(int id, RezervasyonÝsteði istek, Kart kart) throws InterruptedException 
  {

  	
  	try {
  		ArrayList<Otel> otelBilgisi=new ArrayList<Otel>();
      	veritabaný oku=new veritabaný();
  		Connection connection=oku.baglatýAç();
  		String sorgu="SELECT * FROM otel";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( sorgu );
			Otel otel=new Otel();
			int i=0, ucret;
			while (resultSet.next())
			{
				    otel.setOtelId(resultSet.getInt("otelýd"));
					otel.setOtelAd(resultSet.getString("otelad"));
					otel.setÞehir(resultSet.getString("sehir"));
					otel.setYýldýzSAyýsý(resultSet.getInt("yýldýzsayýsý"));
				
					otel.setStandart(resultSet.getInt("standart"));
					otel.setDeluxe(resultSet.getInt("deluxe"));
					otel.setSenior(resultSet.getInt("senior"));
					otel.setSuperior(resultSet.getInt("superior"));
					otel.setKing(resultSet.getInt("king"));
					otel.setStandartUcret(resultSet.getInt("standartfiyat"));
					otel.setDeluxeUcret(resultSet.getInt("deluxefiyat"));
					otel.setSeniorUcret(resultSet.getInt("seniorfiyat"));
					otel.setSuperiorUcret(resultSet.getInt("superiorfiyat"));
					otel.setKingUcret(resultSet.getInt("kingfiyat"));
					otelBilgisi.add(otel);
			
					
					if (otelBilgisi.get(i).getÞehir().equals(istek.getOtelÞehri()))
                  {	//System.out.println("\n ilk if okey");
                      // System.out.printf("\n otel þehri=%s	yýldýz=%d",otelBilgisi.get(i).getÞehir(),otelBilgisi.get(i).getYýldýzSayýsý());
						if (otelBilgisi.get(i).getYýldýzSayýsý()==istek.getYýldýzSayýsý())
								{System.out.println("\n ikinci if okey");
									if ((istek.getOda().equals("Standart")))
											//|| (istek.getOda().equals("standart")));
										{//System.out.println("\n 3. if okey");
										 if ((otelBilgisi.get(i).getStandartUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getStandartUcret()<=istek.getÜstFiyat()))   
											 						{//System.out.println("\n 4 if okey");
											 							ucret=otelBilgisi.get(i).getStandartUcret()*istek.getKaçGün();
											 							makeReservation(id, otelBilgisi.get(i), istek,kart, ucret);
											 							
											 						}
										}
								
									if ((istek.getOda().equals("Deluxe"))) 
									  {if	 ((otelBilgisi.get(i).getDeluxeUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getDeluxeUcret()<=istek.getÜstFiyat())) 
										  						
										  					{	ucret=otelBilgisi.get(i).getDeluxeUcret()*istek.getKaçGün();
										  						makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);
										  						}
									  		
									  }
								   
								if ((istek.getOda().equals("Senior")))
									{if	 ((otelBilgisi.get(i).getSeniorUCret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getSeniorUCret()<=istek.getÜstFiyat())) 
																		{	ucret=otelBilgisi.get(i).getSeniorUCret()*istek.getKaçGün();
																			makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);
																			}
									
									}
								
								
								if ((istek.getOda().equals("Superior")))
									{if	 ((otelBilgisi.get(i).getSuperiorUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getSuperiorUcret()<=istek.getÜstFiyat())) 
															{	ucret=otelBilgisi.get(i).getSuperiorUcret()*istek.getKaçGün();
																makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);
															}

									}
								
								if ((istek.getOda().equals("King")))
										{if	 ((otelBilgisi.get(i).getKingUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getKingUcret()<=istek.getÜstFiyat())) 
															{	ucret=otelBilgisi.get(i).getKingUcret()*istek.getKaçGün();
																makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);}

											}
								
								   
								   
								}//end if yýldýz sayýsý			
					}
					i++;
			}//end while
			oku.baglantiKapa();
		}//end try
  	
  	
  	catch(Exception e)
	{
  		e.printStackTrace();
  }
  }

  
  	
  	
	
  @Override
  public void makeReservation(int id, Otel otelBilgisi, RezervasyonÝsteði istek, Kart kart, int ucret) throws InterruptedException 
	{	System.out.println("\n istek alýndý");
    	
		writeLock.lock();
		
	try {	
		
		
        RezervasyonGeçmiþi x=new RezervasyonGeçmiþi();
        veritabaný yeni_kayýt=new veritabaný();
        int yeni_id=x.KiþiSayýsý()+1;
		x.setId(yeni_id);
		x.setÞehir(otelBilgisi.getÞehir());
		x.setOtelAdý(otelBilgisi.getOtelAd());
		x.setOdaTuru(istek.getOda());
		x.setGiriþTarih(istek.getBaþlangýçTarih());
		x.setÇýkýþTarih(istek.getBitiþTarih());
		x.setUyeId(id);
		x.setGunSayýsý(istek.getKaçGün());
	    x.setUCret(ucret);
	    yeni_kayýt.yeniRezervasyonGeçmiþi(x,otelBilgisi);
	    kart.onay();
	    
	    System.out.printf("\n Otel adý:%s \t Otel Þehri:%s \t Otel Yýldýz Sayýsý:%d \t Giriþ Tarih:%s \t Çýkýþ Tarih:%s \t Oda Türü:%s \t Ücret:%d",otelBilgisi.getOtelAd(),otelBilgisi.getÞehir(),otelBilgisi.getYýldýzSayýsý(), x.getGiriþTarih(),x.getÇýkýþTarih(),x.getOdaTuru(),ucret);
		
    	   	} //end try

	
    	finally {
    		writeLock.unlock();
        }
		
	}

	@Override
	public void cancelReservation() // throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
	}


}
