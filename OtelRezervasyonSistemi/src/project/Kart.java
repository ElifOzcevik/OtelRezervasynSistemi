package project;

public abstract class Kart extends Object {
private int �d;

 public Kart(int id)
 {
	 setId(id);
 }
	


public void setId(int id )
 {
	 this.�d=id;
 }

public int getId()
{
	return �d;
	}

public abstract void �deme();
public abstract void onay();
}