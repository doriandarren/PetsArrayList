package main;

public class Roedor extends Mascota{

	private float calidadPelaje;
	
	
	
	public Roedor(String nombre, float peso, float altura, float largo) {
		super(nombre, peso, altura, largo);
		this.calidadPelaje=1;
	}
	
	

	@Override
	public float getStadoNutricion() {	
		//peso / (altura * largo)
		return getPeso()/(0.3f * getAltura() * getLargo());
	}
	
	
	@Override
	public float getPesoRacion() {
		return 0.15f*getPeso()*(2f-calidadPelaje);
	}
	
	@Override
	protected String getTypeClass() {
		return getClass().getName();
	}
	
	
	
	

	public float getCalidadPelaje() {
		return calidadPelaje;
	}

	public void setCalidadPelaje(float calidadPelaje) {
		this.calidadPelaje = calidadPelaje;
	}
		
	
}
