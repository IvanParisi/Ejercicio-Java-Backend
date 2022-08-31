package ejercicio.java.backend.tarjetas;

import java.time.LocalDate;
import java.time.YearMonth;


import ejercicio.java.backend.exception.NumLenghtException;

public class Naranja extends AbstractCreditCard
{
	public Naranja(Marcas marca, String numT, String nombre,String apellido, YearMonth vencimiento) throws NumLenghtException {
		super(marca, numT, nombre, apellido,vencimiento);
	}

	@Override
	public double tasaDeServicio() 
	{
		LocalDate currentdate = LocalDate.now();
		return currentdate.getDayOfMonth() * this.getMarca().getTasa_Anual();
	}
	

}
