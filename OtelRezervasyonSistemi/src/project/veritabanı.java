package project;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;
public class veritabaný {

	private static Connection connection;
//	private final String URL;
	private final String URL="jdbc:mysql://localhost:3306/musteri?autoReconnect=true&useSSL=false";;
	private final String KullanýcýAd="root";
	private final String Sýfre="123456";
	
	//Veritabanýna baðlanmak için kullanýlan baglantiAc metodu
	public Connection baglatýAç() 
	{
			try {
					connection = DriverManager.getConnection( URL,KullanýcýAd,Sýfre);
				}
		
			catch(Exception e)
				{
					e.printStackTrace();
				}
		return connection;	
	} //baglantýAc end
	
	
	 //Veritabaný iþlemlerini hallettikten sonra veritabanýný kapatmak için kullanýlan baglantiKapa metodu
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
	
	 
	 
	//Üye bilgilerini veritabanýndan alarak, ArrayList olarak döndüren metod 
	public ArrayList<Uye> uyeBilgisiCek()
	{
		ArrayList<Uye> uyeBilgileri=new ArrayList<Uye>();
		try {
			Connection connection=baglatýAç();
			String sorgu="SELECT * FROM uye";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( sorgu );
			
			while (resultSet.next())
			{
				Uye üye=new Uye();
				üye.setId(resultSet.getInt("id"));
				üye.setAd(resultSet.getString("ad"));
				üye.setSoyad(resultSet.getString("soyad"));
				üye.setPassword(resultSet.getString("sifre"));
				üye.setCinsiyet(resultSet.getString("cinsiyet"));
				üye.setDogum_tarihi(resultSet.getString("dogumtarihi"));
				üye.setTC(resultSet.getInt("TCno"));
				üye.setAdres(resultSet.getString("adres"));
				üye.setMail(resultSet.getString("mail"));
				üye.setTel(resultSet.getInt("telefon"));
				
				uyeBilgileri.add(üye);
			}
			
		} //try end
		
		catch(Exception e)
		{
			e.printStackTrace();
		} //catch end
		
		return uyeBilgileri;			
		
	}//uyebilgisiçek end
	
	

//SIKINTI OLABÝLÝR!!!!	
	//otel bilgilerini veritabanýndan alarak, ArrayList olarak döndüren metod 
		public ArrayList<Otel> otelBilgisiCek()
		{
			ArrayList<Otel> otelBilgileri=new ArrayList<Otel>();
			try {
				Connection connection=baglatýAç();
				String sorgu="SELECT * FROM otel";
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery( sorgu );
				Otel otel=new Otel();
				
				while (resultSet.next())
				{
					
				//	BirKisilik oda1=new BirKisilik();
				//	IkiKisilik oda2=new IkiKisilik();
				//	UcKisilik oda3=new UcKisilik();
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
					
					otelBilgileri.add(otel);
				
				}
	//			baglantiKapa();
				
			} //try end
			
			catch(Exception e)
			{
				e.printStackTrace();
			} //catch end
			
			return otelBilgileri;			
			
		}//otelbilgisiçek end
    
		
		
    
    public ArrayList<RezervasyonGeçmiþi> RezervasyonGeçmiþiBilgiÇek()
	{
		ArrayList<RezervasyonGeçmiþi> rezervayonGeçmiþiBilgi=new ArrayList<RezervasyonGeçmiþi>();
		try {
			Connection connection=baglatýAç();
			String sorgu="SELECT * FROM gecmisrezervasyonn";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( sorgu );
			
			while (resultSet.next())
			{
				RezervasyonGeçmiþi geçmiþ=new RezervasyonGeçmiþi();
				geçmiþ.setId(resultSet.getInt("ýd"));
				geçmiþ.setÞehir(resultSet.getString("sehir"));
				geçmiþ.setOtelAdý(resultSet.getString("otelinAdý"));
				geçmiþ.setOdaTuru(resultSet.getString("odaTürü"));
				geçmiþ.setGiriþTarih(resultSet.getString("girisTarih"));
				geçmiþ.setÇýkýþTarih(resultSet.getString("cýkýsTarih"));
				geçmiþ.setUyeId(resultSet.getInt("uyeId"));
				geçmiþ.setGunSayýsý(resultSet.getInt("gunSayýsý"));
				geçmiþ.setUCret(resultSet.getInt("ücret"));
		        rezervayonGeçmiþiBilgi.add(geçmiþ);

			}//while
			//			baglantiKapa();
		}//try
	 
		catch(Exception e)
		{
			e.printStackTrace();
		} //catch end
		
		return rezervayonGeçmiþiBilgi;	
		
		}//metod end
		
    
    
    
    
    //
    public void yeniRezervasyonGeçmiþi(RezervasyonGeçmiþi istek, Otel otel){
		try
		{
			Connection connection=baglatýAç();
			 String sorgu="insert into musteri.gecmisrezervasyonn(id,sehir, otelinadi,odaTürü,girisTarih,cikisTarih,uyeId,gunSayisi,ücret) values(?,?,?,?,?,?,?,?,?)";
			 PreparedStatement ps=connection.prepareStatement(sorgu);
			 ps.setInt(1, istek.getId());
			 ps.setString(2, istek.getÞehir());
			 ps.setString(3, otel.getOtelAd()); //kullanýcý otel adý isteðinde bulunmuyor
			 ps.setString(4, istek.getOdaTuru());
			 ps.setString(5, istek.getGiriþTarih());
			 ps.setString(6, istek.getÇýkýþTarih());
			 ps.setInt(7, istek.getUyeId());
			 ps.setInt(8, istek.getGunSayýsý());
			 ps.setInt(9, istek.getUcret());
			 ps.executeUpdate();
             ps.close();
             baglantiKapa();
             System.out.println("\n Kayýt Tamamlandý.");
		}//try end
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("\n Hata! Kayýt Tamamlanamadý.");
		} //catch end
		
	}//yeniRezervasyonGeçmiþi metod end
    
    
    
    
}	//class end	
    
  
	
	

