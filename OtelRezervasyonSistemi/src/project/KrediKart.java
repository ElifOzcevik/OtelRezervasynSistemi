package project;


public class KrediKart extends Kart {
private String sahipAd;
private String sahipSoyad;
private double kartNo;
private int g�venlikNo;
private int �ifreNo;

public KrediKart(int id)
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
	this.g�venlikNo=No;
	}

public int getGuvenlikNo()
{
	return g�venlikNo;
	}

public void set�ifreNo(int No)
{
	this.�ifreNo=No;
	}

public int get�ifreNo()
{
	return �ifreNo;
	}

public void �deme() {
	// TODO Auto-generated method stub
	
}

@Override
public void onay() 
{
	System.out.println("\n �deme ger�ekle�ti.");
}


//public void i�lem();

//public void Onay();

}

