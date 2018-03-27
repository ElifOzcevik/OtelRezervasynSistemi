package project;

public class Giriþ {
private int id;
private String password;

public Giriþ(int id, String þifre)
{
	this.id=id;
	password=þifre;
	
	}
public void setId(int id)
{
	this.id=id;
	}
public int getId()
{
	return id;
	}

public void setSifre(String þifre)
{
	password=þifre;
	}
public String getSifre()
{
	return password;
	}

}
