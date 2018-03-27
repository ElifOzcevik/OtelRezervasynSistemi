package project;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;

import com.mysql.jdbc.ResultSetMetaData;

public class RezervasyonGeçmişi {
private int ıd;
private String şehir;
private String otelAdı;
private String odaTürü;
private String girisTarih;
private String çıkışTarih;
private int uyeId;
private int gunSayısı;
private int ücret;

public void setId(int id)
{
	this.ıd=id;
	}

public int getId()
{
	return ıd;
	}

public void setŞehir(String şehir)
{
	this.şehir=şehir;
	}

public String getŞehir()
{
	return şehir;
	}

public void setOtelAdı(String OtelAdı)
{
	this.otelAdı=otelAdı;
	}

public String getOtelAdı()
{
	return otelAdı;
	}
	
public void setOdaTuru(String odaTuru) 
{
	this.odaTürü=odaTuru;
	}

public String getOdaTuru()
{
	return odaTürü;
	}

public void setGirişTarih(String girişTarih)
{
	this.girisTarih=girişTarih;
	}

public String getGirişTarih()
{
	return girisTarih;
	}

public void setÇıkışTarih(String çıkışTarih)
{
	this.çıkışTarih=çıkışTarih;
	}

public String getÇıkışTarih()
{
	return çıkışTarih;
	}

public void setUyeId(int uyeId)
{
	this.uyeId=uyeId;
	}

public int getUyeId()
{
	return uyeId;
	}

public void setUCret(int ücret)
{
	this.ücret=ücret;
	}

public int getUcret()
{
	return ücret;
	}


public void setGunSayısı(int gunSayısı)
{
	this.gunSayısı=gunSayısı;
	}

public int getGunSayısı()
{
	return gunSayısı;
	}

//sıkıntı var
public void RezervasyonGeçmişiGörüntüle(int id)
{
		veritabanı x=new veritabanı();
    	try {
    		int kontrol=0;
    		int i =0;
			ArrayList<Integer> uyeidlist = new ArrayList<Integer>();
			Connection connection=x.baglatıAç();
			Statement statement = connection.createStatement();		
			ResultSet resultSet = statement.executeQuery( "SELECT * FROM gecmisrezervasyonn" );
			
			ResultSetMetaData metaData=(ResultSetMetaData) resultSet.getMetaData();
			int numberOfColumns=metaData.getColumnCount();
			
			System.out.println(); 
			

			 
			 while (resultSet.next())
			 {  
			    uyeidlist.add(resultSet.getInt("uyeId"));
			    if (id ==uyeidlist.get(i)) { 
			    							 kontrol++;
											 System.out.println( "\n Authors Table of Books Database:\n" ); 
											 for ( int i1=1; i1 <= numberOfColumns; i1++ ) 
										   	 System.out.printf( "%-8s\t",metaData.getColumnName(i1)); 
											 System.out.println(); 
											 for ( int i2=1; i2 <= numberOfColumns; i2++ ) 
											 System.out.printf( "%-8s\t", resultSet.getObject(i2) );
										     System.out.println();
			 									}
			    i++;
			 } //while end
			 
			 if (kontrol==0) System.out.println("\n Rezervasyon geçmişinizde hiç rezervasyon yoktur.");
			 
		  veritabanı.baglantiKapa();
		
		}// end try 
    	
		catch(SQLException e)
		{
			e.printStackTrace();
		}//end catch
			
		}//end metot
    	
    	
    	
    	
    	public int KişiSayısı(){
    	{	ArrayList<Integer> kaçkayıt=new ArrayList<Integer>();
    		int kişi_sayısı=0;
    		try {
    			veritabanı vt=new veritabanı();
    			Connection connection=vt.baglatıAç();
    			String sorgu="SELECT * FROM gecmisrezervasyonn";
    			Statement statement = connection.createStatement();
    			ResultSet resultSet = statement.executeQuery( sorgu );
    			
    			while (resultSet.next())
    			{
    				kaçkayıt.add(resultSet.getInt("id"));
    			}
    			kişi_sayısı=kaçkayıt.size();

    		} //try end
    		
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		} //catch end
    			return kişi_sayısı;
    	}

    	
    	
    	
    
	}

}
