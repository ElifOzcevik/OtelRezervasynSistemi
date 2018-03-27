package project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.print.DocFlavor.INPUT_STREAM;
import project.RezervasyonÝsteði;

public class Menu {
Scanner input=new Scanner(System.in);
Scanner input1=new Scanner(System.in);
Scanner input2=new Scanner(System.in);
Scanner input3=new Scanner(System.in);
Scanner input4=new Scanner(System.in);
Scanner input5=new Scanner(System.in);
Scanner input6=new Scanner(System.in);
Scanner input7=new Scanner(System.in);
Scanner input8=new Scanner(System.in);
Scanner input9=new Scanner(System.in);
Scanner input10=new Scanner(System.in);
Scanner input11=new Scanner(System.in);
Scanner input12=new Scanner(System.in);
Scanner input13=new Scanner(System.in);
Scanner input14=new Scanner(System.in);
Scanner input15=new Scanner(System.in);
	public void Menu1() throws InterruptedException //throws InterruptedException
	{ 
		System.out.println(" \n 1-Giriþ Yap. \n 2-Üye Ol. ");
		int cvp=input.nextInt();
		switch(cvp)
		{
			case 1: boolean continueLoop = true; 
					//int continueLoop=1;
					int dönüþ=0;
					do {
					int girilen_id;
					String girilen_þifre;
					try {	
					System.out.println("\n id giriniz:");
					girilen_id=input1.nextInt();
				
					//doðru girilene kadar giriþ yaptýrsýn
					System.out.println("\n þifre giriniz");
					girilen_þifre=input2.nextLine();
				
					Giriþ x=new Giriþ(girilen_id, girilen_þifre);
					Uye üye2=new Uye();
					
					continueLoop = false; 
					dönüþ=üye2.GirisKontrol(x);
					
					}
			
					catch(InputMismatchException e)
					{
						input1.nextLine(); //discard input so user can try again
						System.out.println("\n Tam sayý girmelisiniz.");		
						
					}
					} while ( continueLoop || dönüþ==2 ); 
				   	break;
				   	
			case 2: 
					
				//	veritabaný x1=new veritabaný();
					Uye üye=new Uye();
					int yeni_id=üye.KaçKiþi()+1;
					üye.setId(yeni_id);
					System.out.println("\n Ad giriniz ");
					üye.setAd(input2.nextLine());
					System.out.println("\n Soyad giriniz ");
					üye.setSoyad(input3.nextLine());
					System.out.println("\n Þifre giriniz ");
					üye.setPassword(input4.nextLine());
					System.out.println("\n Cinsiyet giriniz ");
					üye.setCinsiyet(input5.nextLine());
					System.out.println("\n Doðum tarihi giriniz ");
					üye.setDogum_tarihi(input6.nextLine());
					System.out.println("\n TC giriniz ");
					üye.setTC(input7.nextInt());
					System.out.println("\n Adres giriniz ");
					üye.setAdres(input8.nextLine());
					System.out.println("\n Mail giriniz ");
					üye.setMail(input9.nextLine());					
					System.out.println("\n Telefon giriniz ");
					üye.setTel(input10.nextInt());
				    üye.yeniUye(üye);
					//	x1.yeniUye(üye);
					break;		
			

		}
		//return 0;
		
	} //Menu1 end
	
	public void Menu2(int id) throws InterruptedException //throws InterruptedException 
	{
		
		System.out.println(" \n 1-Bilgi Güncelle. \n 2-Rezervasyon Geçmiþi. \n 3-Yeni Rezervasyon. \n 4-Çýkýþ.");
		int cvp=input.nextInt();
		switch(cvp)
		{
			case 1:
					 
					Uye üye=new Uye();					
					System.out.println("\n Güncelleme için ad giriniz ");
					üye.setAd(input2.nextLine());
					System.out.println("\n Güncelleme için soyad giriniz ");
					üye.setSoyad(input3.nextLine());
					System.out.println("\n Güncelleme için þifre giriniz ");
					üye.setPassword(input4.nextLine());
					System.out.println("\n Güncelleme için cinsiyet giriniz ");
					üye.setCinsiyet(input5.nextLine());
					System.out.println("\n Güncelleme için doðum tarihi giriniz ");
					üye.setDogum_tarihi(input6.nextLine());				
					System.out.println("\n Güncelleme için TC giriniz ");
					üye.setTC(input7.nextInt());
					System.out.println("\n Güncelleme için adres giriniz ");
					üye.setAdres(input8.nextLine());
					System.out.println("\n Güncelleme için mail giriniz ");
					üye.setMail(input9.nextLine());
					System.out.println("\n Güncelleme için telefon giriniz ");
					üye.setTel(input10.nextInt());
					üye.setId(id);
					üye.uyeGuncelle(üye);
					//x.uyeGuncelle(üye);
					break;
					
			case 2: 
				    RezervasyonGeçmiþi degisken=new RezervasyonGeçmiþi();
				    degisken.RezervasyonGeçmiþiGörüntüle(id);
					break;		
			case 3:  
	
				SynchronizedRezervasyon y=new SynchronizedRezervasyon();
				String cevap;
		     	RezervasyonÝsteði istek=new RezervasyonÝsteði();
		     	String cevap3;
		     	int cevapp;
				System.out.println("\n Otel þehri giriniz.");
				istek.setOtelÞehri(input1.nextLine());
				System.out.println("\n Otel yýldýz sayýsý giriniz.");
				istek.setYýldýzSayýsý(input2.nextInt());
				System.out.println("\n Otelde kaç gün kalmak istediðinizi giriniz.");
				istek.setKaçGün(input3.nextInt());
				
				System.out.println("\n Otel için günlük ödemek istediðiniz en az ücreti giriniz.");
				istek.setAltFiyat(input4.nextInt());
				System.out.println("\n Otel için günlük ödemek istediðiniz en çok ücreti giriniz.");
				istek.setÜstFÝyat(input5.nextInt());
				System.out.println("\n Otel rezervasyonu baþlangýç tarihi giriniz.");
				istek.setBaþlangýçTarih(input6.nextLine());
				System.out.println("\n Otel rezervasyonu bitiþ tarihi giriniz");
				istek.setBitiþTarih(input7.nextLine());
				System.out.println("\n Otelde kaç kiþilik oda da kalmak istediðinizi giriniz. 1/2/3");
				cevapp=input8.nextInt();
				//istek.setOda(input8.nextLine());
				
				if (cevapp==1) {
									System.out.println("\n Standart odada mý kalmak istersiniz Deluxe odada mý?");
								    cevap3=input9.nextLine();
									if ((cevap3.equals("Standart")) || (cevap3.equals("standart")))  istek.setOda("Standart");
									if ((cevap3.equals("Deluxe")) || (cevap3.equals("Deluxe"))) istek.setOda("Deluxe");
								
								}
				
				if (cevapp==2) {
									System.out.println("\n Tek tip odamýz vardýr. Senior");
									istek.setOda("Senior");
								}
				
				if (cevapp==3) {
									System.out.println("\n Superior odada mý kalmak istersiniz King odada mý?");
									cevap3=input9.nextLine();
									if ((cevap3.equals("Superior")) || (cevap3.equals("superior")))  istek.setOda("Superior");
									if ((cevap3.equals("King")) || (cevap3.equals("king"))) istek.setOda("King");
								}
					
				
				System.out.println("\n Ödeme için hesap kartý mý kedi kartý mý kullanmak istersiniz");
				cevap=input10.nextLine();
		
				if ((cevap.equals("hesap kartý")) || (cevap.equals("hesapkartý")) || (cevap.equals("Hesap kartý"))) {
													BankaKart kart=new BankaKart(id);
													System.out.println("\n Kartýn üzerinde yazan ismi giriniz");
													kart.setSahipAd(input11.nextLine());
													System.out.println("\n Kartýn üzerinde yazan soyismi giriniz");
													kart.setSahipSoyad(input12.nextLine());
													System.out.println("\n Kart numarasý giriniz");
													kart.setKartNo(input13.nextDouble());
													System.out.println("\n Güvenlik numarasý giriniz");
													kart.setGuvenlikNo(input14.nextInt());
													System.out.println("\n Þifre giriniz");
													kart.setÞifreNo(input15.nextInt());
													y.queryReservation(id, istek, kart);
													}
				if ((cevap.equals("kredi kartý")) || (cevap.equals("Kredi kartý")) || (cevap.equals("Kredikartý"))) {
													KrediKart kart=new KrediKart(id);
													System.out.println("\n Kartýn üzerinde yazan ismi giriniz");
													kart.setSahipAd(input11.nextLine());
													System.out.println("\n Kartýn üzerinde yazan soyismi giriniz");
													kart.setSahipSoyad(input12.nextLine());
													System.out.println("\n Kart numarasý giriniz");
													kart.setKartNo(input13.nextDouble());
													System.out.println("\n Güvenlik numarasý giriniz");
													kart.setGuvenlikNo(input14.nextInt());
													System.out.println("\n Þifre giriniz");
													kart.setÞifreNo(input15.nextInt());
													y.queryReservation(id, istek, kart);
					}
				
				break;
					
					

					
			case 4: //return 4;

		}
	//	return 0;
	}
	
}
