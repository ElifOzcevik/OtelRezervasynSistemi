package project;



public interface Rezervasyon {
	public void queryReservation(int id, Rezervasyon�ste�i istek, Kart kart) throws InterruptedException;
    public void cancelReservation() throws InterruptedException;
    public void makeReservation(int id, Otel otelBilgisi, Rezervasyon�ste�i istek, Kart kart, int ucret) throws InterruptedException;
  //  public int seatCount();

}
