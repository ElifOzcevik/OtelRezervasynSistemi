package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

public class Uye {
private int id;
private String ad;
private String soyad;
private String password;
private String cinsiyet;
private String dogum_tarihi;
private int TC;
private String adres;
private String mail;
private int tel;

public void setId(int id)
{
	this.id=id;
	}
public int getId()
{
	return id;
	}

public void setAd(String ad)
{
	this.ad=ad;
	}

public String getAd()
{
	return ad;
	}

public void setSoyad(String  Soyad)
{
	this.soyad=Soyad;
}

public String getSoyad()
{
	return soyad;
}

public void setPassword(String password)
{
	this.password=password;
	}

public String getPassword()
{
	return password;
}

public void setCinsiyet(String cinsiyet)
{
	this.cinsiyet=cinsiyet;
	}

public String getCinsiyet()
{
	return cinsiyet;
	}

public void setDogum_tarihi(String dogum_tarihi)
{
	this.dogum_tarihi=dogum_tarihi;
}

public String getDogum_tarihi()
{
	return dogum_tarihi;
	}

public void setTC(int TC)
{
	this.TC=TC;
	}

public int getTC()
{
	return TC;
	}

public void setAdres(String adres)
{
	this.adres=adres;
	}

public String getAdres()
{
	return adres;
	}

public void setMail(String mail)
{
	this.mail=mail;
	}

public String getMail()
{
	return mail;
	}

public void setTel(int tel)
{
	this.tel=tel;
	}

public int getTel() 
{
	return tel;
	}



public int GirisKontrol(Giri� bilgi) throws InterruptedException   //throws InterruptedException
{	int d�n��De�eri=0;
	try {
		int kontrol=0; //girilen id'de �ye olup olmad��� kontrol�n� sa�lar
		
		ArrayList<Integer> idlist = new ArrayList<Integer>();
		ArrayList<String> sifrelist = new ArrayList<String>();
		veritaban� degisken5=new veritaban�();
		Connection connection=degisken5.baglat�A�();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery( "SELECT * FROM uye" );
		ResultSetMetaData metaData=(ResultSetMetaData) resultSet.getMetaData();
		int numberOfColumns=metaData.getColumnCount();
		System.out.println(); 
		 while (resultSet.next())  { 
			 idlist.add(resultSet.getInt("id"));
			 sifrelist.add(resultSet.getString("sifre"));
		 } // end while 
		 
		 for(int i=0;i<idlist.size();i++){

               //System.out.println(i+1+". Kisi : "+idlist.get(i));
			if (bilgi.getId() ==idlist.get(i))  {kontrol++;
												if (bilgi.getSifre().equals(sifrelist.get(i))) {
																								System.out.println("\n Giri� Ba�ar�l�. L�tfen Bekleyiniz");
																								Menu z=new Menu();
																								z.Menu2(bilgi.getId());
																								d�n��De�eri=1;
																							
																								}
										
												//hatal� giri� i�in buray� sonsuz d�ng�ye al
												//hatal� giri� olursa yeniden �d �ifre gir
												
												else {	
														System.out.println("�ifre veya kullan�c� ad� yanl��. Yeniden giriniz.");
														d�n��De�eri=2;
														
													
														}//else end
												
												}//if end
			//else {
			//		System.out.println("\n Sistemde b�yle bir �d bulunmamaktad�r. �nce �ye olunuz.");
			//      }
		
		 } //for end
		 if (kontrol==0) System.out.println("\n Sistemde b�yle bir �d bulunmamaktad�r. �nce �ye olunuz.");
	  veritaban�.baglantiKapa();
		 
	}// end try 
	
	catch(SQLException e)
	{
		e.printStackTrace();
		
	}//catch end
	
	return d�n��De�eri;
	
	
	
		}//metod end


public int Ka�Ki�i()
{	ArrayList<Integer> id=new ArrayList<Integer>();
	int ki�i_say�s�=0;
	try {
		veritaban� vt=new veritaban�();
		Connection connection=vt.baglat�A�();
		String sorgu="SELECT * FROM uye";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery( sorgu );
		
		while (resultSet.next())
		{
			id.add(resultSet.getInt("id"));
		}
		ki�i_say�s�=id.size();

	} //try end
	
	catch(Exception e)
	{
		e.printStackTrace();
	} //catch end
		return ki�i_say�s�;
}




//G�nderilen �ye nesnesini veritaban�na kaydeden yeniUye metodu
public void yeniUye(Uye �ye){
	try
	{ veritaban� ara=new veritaban�();
		Connection connection=ara.baglat�A�();
		 String sorgu="insert into musteri.uye(id,ad,soyad,sifre,cinsiyet,dogumtarihi,TCno,adres,mail,telefon) values(?,?,?,?,?,?,?,?,?,?)";
		 PreparedStatement ps=connection.prepareStatement(sorgu);
		 ps.setInt(1, �ye.getId());
		 ps.setString(2, �ye.getAd());
		 ps.setString(3, �ye.getSoyad());
		 ps.setString(4, �ye.getPassword());
		 ps.setString(5, �ye.getCinsiyet());
		 ps.setString(6, �ye.getDogum_tarihi());
		 ps.setInt(7, �ye.getTC());
		 ps.setString(8, �ye.getAdres());
		 ps.setString(9, �ye.getMail());
		 ps.setInt(10,�ye.getTel());
		 ps.executeUpdate();
         ps.close();
         veritaban�.baglantiKapa();
		 
	System.out.printf("\n Kay�t Tamamland�. �ye �d'niz %d",�ye.getId());
	}//try end
	
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("\n Hata! Kay�t Tamamlanamad�.");
	} //catch end
	
}//yeniUye metod end



//Veritaban�ndaki �y3 verilerini g�ncellemeye yarayan �yeGuncelle metodu
public void uyeGuncelle(Uye �ye){            
      try {
    	  	veritaban� degisken8=new veritaban�();
             Connection connection=degisken8.baglat�A�();
             String sorgu="update musteri.uye set ad=?,soyad=?,sifre=?,cinsiyet=?,dogumtarihi=?,TCno=?,adres=?,mail=?,telefon=? where id=?";
             //�ye tablosundaki verileri g�ncellemeye yarayan sql sorgusu. id'ye g�re g�ncelleme yap�yor.
             PreparedStatement ps=connection.prepareStatement(sorgu);     
      ps.setString(1, �ye.getAd());
      ps.setString(2, �ye.getSoyad());
      ps.setString(3, �ye.getPassword());
      ps.setString(4, �ye.getCinsiyet());
      ps.setString(5, �ye.getDogum_tarihi());
      ps.setInt(6, �ye.getTC());
      ps.setString(7, �ye.getAdres());
      ps.setString(8, �ye.getMail());
      ps.setInt(9,�ye.getTel());
      ps.setInt(10, �ye.getId());
     
      //Parametreleri �yeGuncelle metodumuza g�nderilmi� olan ogrenci nesnesinden al�yoruz.
      ps.executeUpdate();
      ps.close();
      veritaban�.baglantiKapa();
     System.out.println("\n  G�ncelleme yap�ld�.");
 
      } //try end 
      catch (Exception e) 
      {
             e.printStackTrace();
             System.out.println("\n Hata! G�ncelleme yap�lamad�.");
      }//catch end

}  // metod end 



}