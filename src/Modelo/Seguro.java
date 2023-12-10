package Modelo;

public class Seguro {
		
		private String tipoSeguro;
		private int costo;
		
		public Seguro(String tipoSeguro, int costo)
		{
			this.tipoSeguro = tipoSeguro;
			this.costo = costo;
		}
		
		public String getTipoSeguro() 
		{
			return tipoSeguro;	
		}
		
		public int getCosto()
		{
			return costo;	
		}
		
	
}
