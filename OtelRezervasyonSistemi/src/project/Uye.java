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



public int GirisKontrol(Giriþ bilgi) throws InterruptedException   //throws InterruptedException
{	int dönüþDeðeri=0;
	try {
		int kontrol=0; //girilen id'de üye olup olmadýðý kontrolünü saðlar
		
		ArrayList<Integer> idlist = new ArrayList<Integer>();
		ArrayList<String> sifrelist = new ArrayList<String>();
		veritabaný degisken5=new veritabaný();
		Connection connection=degisken5.baglatýAç();
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
																								System.out.println("\n Giriþ Baþarýlý. Lütfen Bekleyiniz");
																								Menu z=new Menu();
																								z.Menu2(bilgi.getId());
																								dönüþDeðeri=1;
																							
																								}
										
												//hatalý giriþ için burayý sonsuz döngüye al
												//hatalý giriþ olursa yeniden ýd þifre gir
												
												else {	
														System.out.println("Þifre veya kullanýcý adý yanlýþ. Yeniden giriniz.");
														dönüþDeðeri=2;
														
													
														}//else end
												
												}//if end
			//else {
			//		System.out.println("\n Sistemde böyle bir ýd bulunmamaktadýr. Önce üye olunuz.");
			//      }
		
		 } //for end
		 if (kontrol==0) System.out.println("\n Sistemde böyle bir ýd bulunmamaktadýr. Önce üye olunuz.");
	  veritabaný.baglantiKapa();
		 
	}// end try 
	
	catch(SQLException e)
	{
		e.printStackTrace();
		
	}//catch end
	
	return dönüþDeðeri;
	
	
	
		}//metod end


public int KaçKiþi()
{	ArrayList<Integer> id=new ArrayList<Integer>();
	int kiþi_sayýsý=0;
	try {
		veritabaný vt=new veritabaný();
		Connection connection=vt.baglatýAç();
		String sorgu="SELECT * FROM uye";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery( sorgu );
		
		while (resultSet.next())
		{
			id.add(resultSet.getInt("id"));
		}
		kiþi_sayýsý=id.size();

	} //try end
	
	catch(Exception e)
	{
		e.printStackTrace();
	} //catch end
		return kiþi_sayýsý;
}




//Gönderilen üye nesnesini veritabanýna kaydeden yeniUye metodu
public void yeniUye(Uye üye){
	try
	{ veritabaný ara=new veritabaný();
		Connection connection=ara.baglatýAç();
		 String sorgu="insert into musteri.uye(id,ad,soyad,sifre,cinsiyet,dogumtarihi,TCno,adres,mail,telefon) values(?,?,?,?,?,?,?,?,?,?)";
		 PreparedStatement ps=connection.prepareStatement(sorgu);
		 ps.setInt(1, üye.getId());
		 ps.setString(2, üye.getAd());
		 ps.setString(3, üye.getSoyad());
		 ps.setString(4, üye.getPassword());
		 ps.setString(5, üye.getCinsiyet());
		 ps.setString(6, üye.getDogum_tarihi());
		 ps.setInt(7, üye.getTC());
		 ps.setString(8, üye.getAdres());
		 ps.setString(9, üye.getMail());
		 ps.setInt(10,üye.getTel());
		 ps.executeUpdate();
         ps.close();
         veritabaný.baglantiKapa();
		 
	System.out.printf("\n Kayýt Tamamlandý. Üye ýd'niz %d",üye.getId());
	}//try end
	
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("\n Hata! Kayýt Tamamlanamadý.");
	} //catch end
	
}//yeniUye metod end



//Veritabanýndaki üy3 verilerini güncellemeye yarayan üyeGuncelle metodu
public void uyeGuncelle(Uye üye){            
      try {
    	  	veritabaný degisken8=new veritabaný();
             Connection connection=degisken8.baglatýAç();
             String sorgu="update musteri.uye set ad=?,soyad=?,sifre=?,cinsiyet=?,dogumtarihi=?,TCno=?,adres=?,mail=?,telefon=? where id=?";
             //üye tablosundaki verileri güncellemeye yarayan sql sorgusu. id'ye göre güncelleme yapýyor.
             PreparedStatement ps=connection.prepareStatement(sorgu);     
      ps.setString(1, üye.getAd());
      ps.setString(2, üye.getSoyad());
      ps.setString(3, üye.getPassword());
      ps.setString(4, üye.getCinsiyet());
      ps.setString(5, üye.getDogum_tarihi());
      ps.setInt(6, üye.getTC());
      ps.setString(7, üye.getAdres());
      ps.setString(8, üye.getMail());
      ps.setInt(9,üye.getTel());
      ps.setInt(10, üye.getId());
     
      //Parametreleri üyeGuncelle metodumuza gönderilmiþ olan ogrenci nesnesinden alýyoruz.
      ps.executeUpdate();
      ps.close();
      veritabaný.baglantiKapa();
     System.out.println("\n  Güncelleme yapýldý.");
 
      } //try end 
      catch (Exception e) 
      {
             e.printStackTrace();
             System.out.println("\n Hata! Güncelleme yapýlamadý.");
      }//catch end

}  // metod end 



}