package ejercicio.java.backend.tarjetas;

public enum Marcas 
{
	VISA("Visa",20,16),
	NARA("Tarjeta Naranja",0.5,16),
	AMEX("American express",0.1,15);
	
	private String descripcion;
	private double tasa_anual;
	private int largo_numero;
	
	private Marcas(String descripcion,double tasaAnual,int largoNumero) 
	{
		this.descripcion = descripcion;
		this.tasa_anual = tasaAnual;
		this.largo_numero = largoNumero;
	}
	public String getDescripcion() { return descripcion; };
	public double getTasa_Anual() { return tasa_anual;};
	public int getlargo_Numero() { return largo_numero;};
	
	
}
