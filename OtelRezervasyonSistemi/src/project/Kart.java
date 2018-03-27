package project;

public abstract class Kart extends Object {
private int ýd;

 public Kart(int id)
 {
	 setId(id);
 }
	


public void setId(int id )
 {
	 this.ýd=id;
 }

public int getId()
{
	return ýd;
	}

public abstract void ödeme();
public abstract void onay();
}