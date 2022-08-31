package ejercicio.java.backend.tarjetas;

import java.time.YearMonth;


import ejercicio.java.backend.exception.NumLenghtException;

public class Visa extends AbstractCreditCard
{
	
	public Visa(Marcas marca, String numT, String nombre,String apellido, YearMonth vencimiento) throws NumLenghtException
	{
		super(marca, numT, nombre, apellido, vencimiento);
	}

	@Override
	public double tasaDeServicio() 
	{
		return this.getMarca().getTasa_Anual() / 12;
	}


	

}
