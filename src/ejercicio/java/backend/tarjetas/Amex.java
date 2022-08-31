package ejercicio.java.backend.tarjetas;

import java.time.LocalDate;
import java.time.YearMonth;


import ejercicio.java.backend.exception.NumLenghtException;

public class Amex extends AbstractCreditCard
{
	public Amex(Marcas marca, String numT, String nombre,String apellido, YearMonth vencimiento) throws NumLenghtException
	{
		super(marca, numT, nombre, apellido, vencimiento);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public double tasaDeServicio() 
	{
		LocalDate currentdate = LocalDate.now();
		return currentdate.getMonthValue() * this.getMarca().getTasa_Anual();
	}
	
	

}
