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

import project.Rezervasyon�ste�i;
import project.Otel;
import project.RezervasyonGe�mi�i;
import project.veritaban�;
import java.sql.*;
public class SynchronizedRezervasyon implements Rezervasyon {


  private ReadWriteLock accessLock = new ReentrantReadWriteLock();
  private final Lock readLock = accessLock.readLock();
  private final Lock writeLock = accessLock.writeLock();
	
  
  
  
  
  public void  queryReservation(int id, Rezervasyon�ste�i istek, Kart kart) throws InterruptedException 
  {

  	
  	try {
  		ArrayList<Otel> otelBilgisi=new ArrayList<Otel>();
      	veritaban� oku=new veritaban�();
  		Connection connection=oku.baglat�A�();
  		String sorgu="SELECT * FROM otel";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( sorgu );
			Otel otel=new Otel();
			int i=0, ucret;
			while (resultSet.next())
			{
				    otel.setOtelId(resultSet.getInt("otel�d"));
					otel.setOtelAd(resultSet.getString("otelad"));
					otel.set�ehir(resultSet.getString("sehir"));
					otel.setY�ld�zSAy�s�(resultSet.getInt("y�ld�zsay�s�"));
				
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
			
					
					if (otelBilgisi.get(i).get�ehir().equals(istek.getOtel�ehri()))
                  {	//System.out.println("\n ilk if okey");
                      // System.out.printf("\n otel �ehri=%s	y�ld�z=%d",otelBilgisi.get(i).get�ehir(),otelBilgisi.get(i).getY�ld�zSay�s�());
						if (otelBilgisi.get(i).getY�ld�zSay�s�()==istek.getY�ld�zSay�s�())
								{System.out.println("\n ikinci if okey");
									if ((istek.getOda().equals("Standart")))
											//|| (istek.getOda().equals("standart")));
										{//System.out.println("\n 3. if okey");
										 if ((otelBilgisi.get(i).getStandartUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getStandartUcret()<=istek.get�stFiyat()))   
											 						{//System.out.println("\n 4 if okey");
											 							ucret=otelBilgisi.get(i).getStandartUcret()*istek.getKa�G�n();
											 							makeReservation(id, otelBilgisi.get(i), istek,kart, ucret);
											 							
											 						}
										}
								
									if ((istek.getOda().equals("Deluxe"))) 
									  {if	 ((otelBilgisi.get(i).getDeluxeUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getDeluxeUcret()<=istek.get�stFiyat())) 
										  						
										  					{	ucret=otelBilgisi.get(i).getDeluxeUcret()*istek.getKa�G�n();
										  						makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);
										  						}
									  		
									  }
								   
								if ((istek.getOda().equals("Senior")))
									{if	 ((otelBilgisi.get(i).getSeniorUCret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getSeniorUCret()<=istek.get�stFiyat())) 
																		{	ucret=otelBilgisi.get(i).getSeniorUCret()*istek.getKa�G�n();
																			makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);
																			}
									
									}
								
								
								if ((istek.getOda().equals("Superior")))
									{if	 ((otelBilgisi.get(i).getSuperiorUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getSuperiorUcret()<=istek.get�stFiyat())) 
															{	ucret=otelBilgisi.get(i).getSuperiorUcret()*istek.getKa�G�n();
																makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);
															}

									}
								
								if ((istek.getOda().equals("King")))
										{if	 ((otelBilgisi.get(i).getKingUcret()>=istek.getAltFiyat()) && (otelBilgisi.get(i).getKingUcret()<=istek.get�stFiyat())) 
															{	ucret=otelBilgisi.get(i).getKingUcret()*istek.getKa�G�n();
																makeReservation(id, otelBilgisi.get(i), istek, kart, ucret);}

											}
								
								   
								   
								}//end if y�ld�z say�s�			
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
  public void makeReservation(int id, Otel otelBilgisi, Rezervasyon�ste�i istek, Kart kart, int ucret) throws InterruptedException 
	{	System.out.println("\n istek al�nd�");
    	
		writeLock.lock();
		
	try {	
		
		
        RezervasyonGe�mi�i x=new RezervasyonGe�mi�i();
        veritaban� yeni_kay�t=new veritaban�();
        int yeni_id=x.Ki�iSay�s�()+1;
		x.setId(yeni_id);
		x.set�ehir(otelBilgisi.get�ehir());
		x.setOtelAd�(otelBilgisi.getOtelAd());
		x.setOdaTuru(istek.getOda());
		x.setGiri�Tarih(istek.getBa�lang��Tarih());
		x.set��k��Tarih(istek.getBiti�Tarih());
		x.setUyeId(id);
		x.setGunSay�s�(istek.getKa�G�n());
	    x.setUCret(ucret);
	    yeni_kay�t.yeniRezervasyonGe�mi�i(x,otelBilgisi);
	    kart.onay();
	    
	    System.out.printf("\n Otel ad�:%s \t Otel �ehri:%s \t Otel Y�ld�z Say�s�:%d \t Giri� Tarih:%s \t ��k�� Tarih:%s \t Oda T�r�:%s \t �cret:%d",otelBilgisi.getOtelAd(),otelBilgisi.get�ehir(),otelBilgisi.getY�ld�zSay�s�(), x.getGiri�Tarih(),x.get��k��Tarih(),x.getOdaTuru(),ucret);
		
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
