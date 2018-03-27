package project;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;
public class veritaban� {

	private static Connection connection;
//	private final String URL;
	private final String URL="jdbc:mysql://localhost:3306/musteri?autoReconnect=true&useSSL=false";;
	private final String Kullan�c�Ad="root";
	private final String S�fre="123456";
	
	//Veritaban�na ba�lanmak i�in kullan�lan baglantiAc metodu
	public Connection baglat�A�() 
	{
			try {
					connection = DriverManager.getConnection( URL,Kullan�c�Ad,S�fre);
				}
		
			catch(Exception e)
				{
					e.printStackTrace();
				}
		return connection;	
	} //baglant�Ac end
	
	
	 //Veritaban� i�lemlerini hallettikten sonra veritaban�n� kapatmak i�in kullan�lan baglantiKapa metodu
	 public static void baglantiKapa()
	 {           
         try { 
        	 	connection.close();
         	}
         
         catch (SQLException e) 
         	{
                e.printStackTrace();
         	}                         
	 }
	
	 
	 
	//�ye bilgilerini veritaban�ndan alarak, ArrayList olarak d�nd�ren metod 
	public ArrayList<Uye> uyeBilgisiCek()
	{
		ArrayList<Uye> uyeBilgileri=new ArrayList<Uye>();
		try {
			Connection connection=baglat�A�();
			String sorgu="SELECT * FROM uye";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( sorgu );
			
			while (resultSet.next())
			{
				Uye �ye=new Uye();
				�ye.setId(resultSet.getInt("id"));
				�ye.setAd(resultSet.getString("ad"));
				�ye.setSoyad(resultSet.getString("soyad"));
				�ye.setPassword(resultSet.getString("sifre"));
				�ye.setCinsiyet(resultSet.getString("cinsiyet"));
				�ye.setDogum_tarihi(resultSet.getString("dogumtarihi"));
				�ye.setTC(resultSet.getInt("TCno"));
				�ye.setAdres(resultSet.getString("adres"));
				�ye.setMail(resultSet.getString("mail"));
				�ye.setTel(resultSet.getInt("telefon"));
				
				uyeBilgileri.add(�ye);
			}
			
		} //try end
		
		catch(Exception e)
		{
			e.printStackTrace();
		} //catch end
		
		return uyeBilgileri;			
		
	}//uyebilgisi�ek end
	
	

//SIKINTI OLAB�L�R!!!!	
	//otel bilgilerini veritaban�ndan alarak, ArrayList olarak d�nd�ren metod 
		public ArrayList<Otel> otelBilgisiCek()
		{
			ArrayList<Otel> otelBilgileri=new ArrayList<Otel>();
			try {
				Connection connection=baglat�A�();
				String sorgu="SELECT * FROM otel";
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery( sorgu );
				Otel otel=new Otel();
				
				while (resultSet.next())
				{
					
				//	BirKisilik oda1=new BirKisilik();
				//	IkiKisilik oda2=new IkiKisilik();
				//	UcKisilik oda3=new UcKisilik();
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
					
					otelBilgileri.add(otel);
				
				}
	//			baglantiKapa();
				
			} //try end
			
			catch(Exception e)
			{
				e.printStackTrace();
			} //catch end
			
			return otelBilgileri;			
			
		}//otelbilgisi�ek end
    
		
		
    
    public ArrayList<RezervasyonGe�mi�i> RezervasyonGe�mi�iBilgi�ek()
	{
		ArrayList<RezervasyonGe�mi�i> rezervayonGe�mi�iBilgi=new ArrayList<RezervasyonGe�mi�i>();
		try {
			Connection connection=baglat�A�();
			String sorgu="SELECT * FROM gecmisrezervasyonn";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( sorgu );
			
			while (resultSet.next())
			{
				RezervasyonGe�mi�i ge�mi�=new RezervasyonGe�mi�i();
				ge�mi�.setId(resultSet.getInt("�d"));
				ge�mi�.set�ehir(resultSet.getString("sehir"));
				ge�mi�.setOtelAd�(resultSet.getString("otelinAd�"));
				ge�mi�.setOdaTuru(resultSet.getString("odaT�r�"));
				ge�mi�.setGiri�Tarih(resultSet.getString("girisTarih"));
				ge�mi�.set��k��Tarih(resultSet.getString("c�k�sTarih"));
				ge�mi�.setUyeId(resultSet.getInt("uyeId"));
				ge�mi�.setGunSay�s�(resultSet.getInt("gunSay�s�"));
				ge�mi�.setUCret(resultSet.getInt("�cret"));
		        rezervayonGe�mi�iBilgi.add(ge�mi�);

			}//while
			//			baglantiKapa();
		}//try
	 
		catch(Exception e)
		{
			e.printStackTrace();
		} //catch end
		
		return rezervayonGe�mi�iBilgi;	
		
		}//metod end
		
    
    
    
    
    //
    public void yeniRezervasyonGe�mi�i(RezervasyonGe�mi�i istek, Otel otel){
		try
		{
			Connection connection=baglat�A�();
			 String sorgu="insert into musteri.gecmisrezervasyonn(id,sehir, otelinadi,odaT�r�,girisTarih,cikisTarih,uyeId,gunSayisi,�cret) values(?,?,?,?,?,?,?,?,?)";
			 PreparedStatement ps=connection.prepareStatement(sorgu);
			 ps.setInt(1, istek.getId());
			 ps.setString(2, istek.get�ehir());
			 ps.setString(3, otel.getOtelAd()); //kullan�c� otel ad� iste�inde bulunmuyor
			 ps.setString(4, istek.getOdaTuru());
			 ps.setString(5, istek.getGiri�Tarih());
			 ps.setString(6, istek.get��k��Tarih());
			 ps.setInt(7, istek.getUyeId());
			 ps.setInt(8, istek.getGunSay�s�());
			 ps.setInt(9, istek.getUcret());
			 ps.executeUpdate();
             ps.close();
             baglantiKapa();
             System.out.println("\n Kay�t Tamamland�.");
		}//try end
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("\n Hata! Kay�t Tamamlanamad�.");
		} //catch end
		
	}//yeniRezervasyonGe�mi�i metod end
    
    
    
    
}	//class end	
    
  
	
	

