package project;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;

import com.mysql.jdbc.ResultSetMetaData;

public class RezervasyonGe�mi�i {
private int �d;
private String �ehir;
private String otelAd�;
private String odaT�r�;
private String girisTarih;
private String ��k��Tarih;
private int uyeId;
private int gunSay�s�;
private int �cret;

public void setId(int id)
{
	this.�d=id;
	}

public int getId()
{
	return �d;
	}

public void set�ehir(String �ehir)
{
	this.�ehir=�ehir;
	}

public String get�ehir()
{
	return �ehir;
	}

public void setOtelAd�(String OtelAd�)
{
	this.otelAd�=otelAd�;
	}

public String getOtelAd�()
{
	return otelAd�;
	}
	
public void setOdaTuru(String odaTuru) 
{
	this.odaT�r�=odaTuru;
	}

public String getOdaTuru()
{
	return odaT�r�;
	}

public void setGiri�Tarih(String giri�Tarih)
{
	this.girisTarih=giri�Tarih;
	}

public String getGiri�Tarih()
{
	return girisTarih;
	}

public void set��k��Tarih(String ��k��Tarih)
{
	this.��k��Tarih=��k��Tarih;
	}

public String get��k��Tarih()
{
	return ��k��Tarih;
	}

public void setUyeId(int uyeId)
{
	this.uyeId=uyeId;
	}

public int getUyeId()
{
	return uyeId;
	}

public void setUCret(int �cret)
{
	this.�cret=�cret;
	}

public int getUcret()
{
	return �cret;
	}


public void setGunSay�s�(int gunSay�s�)
{
	this.gunSay�s�=gunSay�s�;
	}

public int getGunSay�s�()
{
	return gunSay�s�;
	}

//s�k�nt� var
public void RezervasyonGe�mi�iG�r�nt�le(int id)
{
		veritaban� x=new veritaban�();
    	try {
    		int kontrol=0;
    		int i =0;
			ArrayList<Integer> uyeidlist = new ArrayList<Integer>();
			Connection connection=x.baglat�A�();
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
			 
			 if (kontrol==0) System.out.println("\n Rezervasyon ge�mi�inizde hi� rezervasyon yoktur.");
			 
		  veritaban�.baglantiKapa();
		
		}// end try 
    	
		catch(SQLException e)
		{
			e.printStackTrace();
		}//end catch
			
		}//end metot
    	
    	
    	
    	
    	public int Ki�iSay�s�(){
    	{	ArrayList<Integer> ka�kay�t=new ArrayList<Integer>();
    		int ki�i_say�s�=0;
    		try {
    			veritaban� vt=new veritaban�();
    			Connection connection=vt.baglat�A�();
    			String sorgu="SELECT * FROM gecmisrezervasyonn";
    			Statement statement = connection.createStatement();
    			ResultSet resultSet = statement.executeQuery( sorgu );
    			
    			while (resultSet.next())
    			{
    				ka�kay�t.add(resultSet.getInt("id"));
    			}
    			ki�i_say�s�=ka�kay�t.size();

    		} //try end
    		
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		} //catch end
    			return ki�i_say�s�;
    	}

    	
    	
    	
    
	}

}
