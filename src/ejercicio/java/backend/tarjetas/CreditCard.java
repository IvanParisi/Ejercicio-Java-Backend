package ejercicio.java.backend.tarjetas;

import ejercicio.java.backend.exception.ExpDateException;

public interface CreditCard 
{
	public boolean esValida();
	public boolean esDistinta(String x);
	abstract double tasaDeServicio();
	public boolean operar(int importe) throws ExpDateException;
}
