package ejercicio.java.backend;

import ejercicio.java.backend.tarjetas.Marcas;
import ejercicio.java.backend.tarjetas.Naranja;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ejercicio.java.backend.exception.ExpDateException;
import ejercicio.java.backend.exception.NumLenghtException;
import ejercicio.java.backend.tarjetas.AbstractCreditCard;
import ejercicio.java.backend.tarjetas.Amex;
import ejercicio.java.backend.tarjetas.CreditCard;
import ejercicio.java.backend.tarjetas.Visa;

public class Principal 
{

	public static void main(String[] args) 
	{
		ArrayList<AbstractCreditCard> tarjetas = new ArrayList<AbstractCreditCard>();
		Visa visaPrueba;
		try 
		{
			visaPrueba = new Visa(Marcas.VISA,"4002568802519484","John ","Doe",YearMonth.of(2022,12));
			tarjetas.add(new Visa(Marcas.VISA,"4002568802519484","Ivan","Parisi",YearMonth.of(2022,06)));
			tarjetas.add(new Naranja(Marcas.NARA,"3713465941706054","Ivan","Parisi",YearMonth.of(2022,12))); 
			tarjetas.add(new Amex(Marcas.NARA,"3713465941706051","Ivan","Parisi",YearMonth.of(2022,12))); 
		} catch (NumLenghtException e) 
		{
			System.out.println(e.getMessage());
		}
		
		
		for(CreditCard x : tarjetas) 
		{
			System.out.println(x.toString());
			System.out.println("La tarjeta es valida: " + x.esValida());
		}
			
		System.out.println("Tasa de operacion : " + AbstractCreditCard.tasaDeOperacion(Marcas.AMEX, 408));
		
		System.out.println("Son iguales: " + tarjetas.get(0).esDistinta(tarjetas.get(1).getNumT()));
		
		try 
		{
			System.out.println("Operacion realizada: " + tarjetas.get(0).operar(300));
		} catch (ExpDateException e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
