package project;



public interface Rezervasyon {
	public void queryReservation(int id, Rezervasyonİsteği istek, Kart kart) throws InterruptedException;
    public void cancelReservation() throws InterruptedException;
    public void makeReservation(int id, Otel otelBilgisi, Rezervasyonİsteği istek, Kart kart, int ucret) throws InterruptedException;
  //  public int seatCount();

}
