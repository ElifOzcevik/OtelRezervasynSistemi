package project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.print.DocFlavor.INPUT_STREAM;
import project.Rezervasyon�ste�i;

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
		System.out.println(" \n 1-Giri� Yap. \n 2-�ye Ol. ");
		int cvp=input.nextInt();
		switch(cvp)
		{
			case 1: boolean continueLoop = true; 
					//int continueLoop=1;
					int d�n��=0;
					do {
					int girilen_id;
					String girilen_�ifre;
					try {	
					System.out.println("\n id giriniz:");
					girilen_id=input1.nextInt();
				
					//do�ru girilene kadar giri� yapt�rs�n
					System.out.println("\n �ifre giriniz");
					girilen_�ifre=input2.nextLine();
				
					Giri� x=new Giri�(girilen_id, girilen_�ifre);
					Uye �ye2=new Uye();
					
					continueLoop = false; 
					d�n��=�ye2.GirisKontrol(x);
					
					}
			
					catch(InputMismatchException e)
					{
						input1.nextLine(); //discard input so user can try again
						System.out.println("\n Tam say� girmelisiniz.");		
						
					}
					} while ( continueLoop || d�n��==2 ); 
				   	break;
				   	
			case 2: 
					
				//	veritaban� x1=new veritaban�();
					Uye �ye=new Uye();
					int yeni_id=�ye.Ka�Ki�i()+1;
					�ye.setId(yeni_id);
					System.out.println("\n Ad giriniz ");
					�ye.setAd(input2.nextLine());
					System.out.println("\n Soyad giriniz ");
					�ye.setSoyad(input3.nextLine());
					System.out.println("\n �ifre giriniz ");
					�ye.setPassword(input4.nextLine());
					System.out.println("\n Cinsiyet giriniz ");
					�ye.setCinsiyet(input5.nextLine());
					System.out.println("\n Do�um tarihi giriniz ");
					�ye.setDogum_tarihi(input6.nextLine());
					System.out.println("\n TC giriniz ");
					�ye.setTC(input7.nextInt());
					System.out.println("\n Adres giriniz ");
					�ye.setAdres(input8.nextLine());
					System.out.println("\n Mail giriniz ");
					�ye.setMail(input9.nextLine());					
					System.out.println("\n Telefon giriniz ");
					�ye.setTel(input10.nextInt());
				    �ye.yeniUye(�ye);
					//	x1.yeniUye(�ye);
					break;		
			

		}
		//return 0;
		
	} //Menu1 end
	
	public void Menu2(int id) throws InterruptedException //throws InterruptedException 
	{
		
		System.out.println(" \n 1-Bilgi G�ncelle. \n 2-Rezervasyon Ge�mi�i. \n 3-Yeni Rezervasyon. \n 4-��k��.");
		int cvp=input.nextInt();
		switch(cvp)
		{
			case 1:
					 
					Uye �ye=new Uye();					
					System.out.println("\n G�ncelleme i�in ad giriniz ");
					�ye.setAd(input2.nextLine());
					System.out.println("\n G�ncelleme i�in soyad giriniz ");
					�ye.setSoyad(input3.nextLine());
					System.out.println("\n G�ncelleme i�in �ifre giriniz ");
					�ye.setPassword(input4.nextLine());
					System.out.println("\n G�ncelleme i�in cinsiyet giriniz ");
					�ye.setCinsiyet(input5.nextLine());
					System.out.println("\n G�ncelleme i�in do�um tarihi giriniz ");
					�ye.setDogum_tarihi(input6.nextLine());				
					System.out.println("\n G�ncelleme i�in TC giriniz ");
					�ye.setTC(input7.nextInt());
					System.out.println("\n G�ncelleme i�in adres giriniz ");
					�ye.setAdres(input8.nextLine());
					System.out.println("\n G�ncelleme i�in mail giriniz ");
					�ye.setMail(input9.nextLine());
					System.out.println("\n G�ncelleme i�in telefon giriniz ");
					�ye.setTel(input10.nextInt());
					�ye.setId(id);
					�ye.uyeGuncelle(�ye);
					//x.uyeGuncelle(�ye);
					break;
					
			case 2: 
				    RezervasyonGe�mi�i degisken=new RezervasyonGe�mi�i();
				    degisken.RezervasyonGe�mi�iG�r�nt�le(id);
					break;		
			case 3:  
	
				SynchronizedRezervasyon y=new SynchronizedRezervasyon();
				String cevap;
		     	Rezervasyon�ste�i istek=new Rezervasyon�ste�i();
		     	String cevap3;
		     	int cevapp;
				System.out.println("\n Otel �ehri giriniz.");
				istek.setOtel�ehri(input1.nextLine());
				System.out.println("\n Otel y�ld�z say�s� giriniz.");
				istek.setY�ld�zSay�s�(input2.nextInt());
				System.out.println("\n Otelde ka� g�n kalmak istedi�inizi giriniz.");
				istek.setKa�G�n(input3.nextInt());
				
				System.out.println("\n Otel i�in g�nl�k �demek istedi�iniz en az �creti giriniz.");
				istek.setAltFiyat(input4.nextInt());
				System.out.println("\n Otel i�in g�nl�k �demek istedi�iniz en �ok �creti giriniz.");
				istek.set�stF�yat(input5.nextInt());
				System.out.println("\n Otel rezervasyonu ba�lang�� tarihi giriniz.");
				istek.setBa�lang��Tarih(input6.nextLine());
				System.out.println("\n Otel rezervasyonu biti� tarihi giriniz");
				istek.setBiti�Tarih(input7.nextLine());
				System.out.println("\n Otelde ka� ki�ilik oda da kalmak istedi�inizi giriniz. 1/2/3");
				cevapp=input8.nextInt();
				//istek.setOda(input8.nextLine());
				
				if (cevapp==1) {
									System.out.println("\n Standart odada m� kalmak istersiniz Deluxe odada m�?");
								    cevap3=input9.nextLine();
									if ((cevap3.equals("Standart")) || (cevap3.equals("standart")))  istek.setOda("Standart");
									if ((cevap3.equals("Deluxe")) || (cevap3.equals("Deluxe"))) istek.setOda("Deluxe");
								
								}
				
				if (cevapp==2) {
									System.out.println("\n Tek tip odam�z vard�r. Senior");
									istek.setOda("Senior");
								}
				
				if (cevapp==3) {
									System.out.println("\n Superior odada m� kalmak istersiniz King odada m�?");
									cevap3=input9.nextLine();
									if ((cevap3.equals("Superior")) || (cevap3.equals("superior")))  istek.setOda("Superior");
									if ((cevap3.equals("King")) || (cevap3.equals("king"))) istek.setOda("King");
								}
					
				
				System.out.println("\n �deme i�in hesap kart� m� kedi kart� m� kullanmak istersiniz");
				cevap=input10.nextLine();
		
				if ((cevap.equals("hesap kart�")) || (cevap.equals("hesapkart�")) || (cevap.equals("Hesap kart�"))) {
													BankaKart kart=new BankaKart(id);
													System.out.println("\n Kart�n �zerinde yazan ismi giriniz");
													kart.setSahipAd(input11.nextLine());
													System.out.println("\n Kart�n �zerinde yazan soyismi giriniz");
													kart.setSahipSoyad(input12.nextLine());
													System.out.println("\n Kart numaras� giriniz");
													kart.setKartNo(input13.nextDouble());
													System.out.println("\n G�venlik numaras� giriniz");
													kart.setGuvenlikNo(input14.nextInt());
													System.out.println("\n �ifre giriniz");
													kart.set�ifreNo(input15.nextInt());
													y.queryReservation(id, istek, kart);
													}
				if ((cevap.equals("kredi kart�")) || (cevap.equals("Kredi kart�")) || (cevap.equals("Kredikart�"))) {
													KrediKart kart=new KrediKart(id);
													System.out.println("\n Kart�n �zerinde yazan ismi giriniz");
													kart.setSahipAd(input11.nextLine());
													System.out.println("\n Kart�n �zerinde yazan soyismi giriniz");
													kart.setSahipSoyad(input12.nextLine());
													System.out.println("\n Kart numaras� giriniz");
													kart.setKartNo(input13.nextDouble());
													System.out.println("\n G�venlik numaras� giriniz");
													kart.setGuvenlikNo(input14.nextInt());
													System.out.println("\n �ifre giriniz");
													kart.set�ifreNo(input15.nextInt());
													y.queryReservation(id, istek, kart);
					}
				
				break;
					
					

					
			case 4: //return 4;

		}
	//	return 0;
	}
	
}
