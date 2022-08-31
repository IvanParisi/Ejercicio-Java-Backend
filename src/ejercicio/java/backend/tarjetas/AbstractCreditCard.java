package ejercicio.java.backend.tarjetas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;


import ejercicio.java.backend.exception.NumLenghtException;

public abstract class AbstractCreditCard implements CreditCard
{
	private Marcas marca;
	private String numT;
	private String cardholder;
	private YearMonth expDate;
	private int consumo;
	
	public AbstractCreditCard(Marcas marca, String numT, String nombre,String apellido, YearMonth vencimiento) throws NumLenghtException
	{
		if(numT.length() != marca.getlargo_Numero()) { throw new NumLenghtException("Largo del numero incorrecto"); } 
		this.marca = marca;
		this.numT = numT;
		this.cardholder = nombre + " " + apellido;
		this.expDate = vencimiento;

	}
	
	

	public abstract double tasaDeServicio();
	
	public boolean operar(int importe) 
	{
		if(this.esValida()) 
		{
			if(importe < 1000) 
			{
				consumo += importe;
			}
		}
		
		
		return importe < 1000 && this.esValida();
	}
	
	public static double tasaDeOperacion(Marcas marca, int importe) 
	{
		LocalDate currentdate = LocalDate.now();
		double tasa = 0;
		switch(marca) 
		{
			case VISA:
				tasa = importe / (marca.getTasa_Anual() / 12);
			case AMEX:
				tasa =  importe / (currentdate.getMonthValue() * marca.getTasa_Anual());
			case NARA:
				tasa =  importe / (currentdate.getDayOfMonth() * marca.getTasa_Anual());
		}
		return tasa;
	};
	
	public boolean esValida() 
	{
		return expDate.isAfter(YearMonth.now());
	}
	
	public boolean esDistinta(String num) 
	{
		return this.numT.equals(num);
	}
	
	// toString
	@Override
	public String toString() 
	{
		return "Marca: " + marca.getDescripcion() + " Numero De tarjeta: " + String.valueOf(numT) + " Titular: "  + cardholder + " Vencimiento: " + expDate;
		
	}
	// Getters
	public Marcas getMarca() 
	{
		return marca;
	}
	public String getNumT() 
	{
		return numT;
	}
	public String getCardholder() 
	{
		return cardholder;
	}
	public YearMonth getExpDate() 
	{
		return expDate;
	}
}
