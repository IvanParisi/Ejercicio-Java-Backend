package ejercicio.java.backend.tarjetas;

public interface CreditCard 
{
	public boolean esValida();
	public boolean esDistinta(String x);
	abstract double tasaDeServicio();
	public boolean operar(int importe);
}
