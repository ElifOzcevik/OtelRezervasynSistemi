package project;

public class BankaKart extends Kart {
private String sahipAd;
private String sahipSoyad;
private double kartNo;
private int güvenlikNo;
private int þifreNo;

public BankaKart(int id)
{
	super(id);
	
}

public void setSahipAd(String ad)
{
	this.sahipAd=ad;
	}

public String getSahipAd()
{
	return sahipAd;
	}

public void setSahipSoyad(String soyad)
{
	this.sahipSoyad=soyad;
	}

public String getSahipSoyad()
{
	return sahipSoyad;
	}

public void setKartNo(double kartNo)
{
	this.kartNo=kartNo;
	}

public double getKartNo()
{
	return kartNo;
	}

public void setGuvenlikNo(int No)
{
	this.güvenlikNo=No;
	}

public int getGuvenlikNo()
{
	return güvenlikNo;
	}

public void setÞifreNo(int No)
{
	this.þifreNo=No;
	}

public int getÞifreNo()
{
	return þifreNo;
	}

@Override
public void ödeme() {
	// TODO Auto-generated method stub
	
}

//public void iþlem();

@Override
public void onay() 
{
	System.out.println("\n Ödeme gerçekleþti.");
}


}

