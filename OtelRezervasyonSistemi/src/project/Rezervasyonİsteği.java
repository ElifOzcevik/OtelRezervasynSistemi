package project;

public class Rezervasyonİsteği {
private String otelŞehri;
private int yıldızSAyısı;
private int altFiyat;
private int üstFiyat;
private int kaçGun;
private String başlangıçTarih;
private String bitişTarih;
private String odaÖzellik;

public void setOtelŞehri(String otelŞehri)
{
	this.otelŞehri=otelŞehri;
	}

public String getOtelŞehri()
{
	return otelŞehri;
	}

public void setYıldızSayısı(int yıldızSAyısı)
{
	this.yıldızSAyısı=yıldızSAyısı;
	}

public int getYıldızSayısı()
{
	return yıldızSAyısı;
	}

public void setKaçGün(int gün)
{
	this.kaçGun=gün;
	}

public int getKaçGün()
{
	return kaçGun;
	}

public void setAltFiyat(int altFiyat)
{
	this.altFiyat=altFiyat;
	}

public int getAltFiyat()
{
	return altFiyat;
	}

public void setÜstFİyat(int üstFiyat)
{
	this.üstFiyat=üstFiyat;
	}

public int getÜstFiyat()
{
	return üstFiyat;
	}

public void setBaşlangıçTarih(String tarih)
{
	this.başlangıçTarih=tarih;
	}

public String getBaşlangıçTarih()
{
	return başlangıçTarih;
	}

public void setBitişTarih(String tarih)
{
	this.bitişTarih=tarih;
	}

public String getBitişTarih()
{
	return bitişTarih;
	}

public void setOda(String oda)
{
	this.odaÖzellik=oda;
	}

public String getOda()
{
	return odaÖzellik;
	}

}
