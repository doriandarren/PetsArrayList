package main;

public class Felino extends Mascota{

	private float calidadGarras;
	
	public Felino(String nombre, float peso, float altura, float largo) {
		super(nombre, peso, altura, largo);
		this.calidadGarras=1;
	}
	
	public Felino() {
	}

	@Override
	public float getPesoRacion() {
		return 0.2f*getPeso()*(2f-calidadGarras);
	}
	
	@Override
	public float getStadoNutricion() {	
		//peso / (altura * largo)
		return getPeso()/(getAltura() * getLargo());
	}
	
	@Override
	protected String getTypeClass() {
		return getClass().getName();
	}
	
	
	

	public float getCalidadGarras() {
		return calidadGarras;
	}

	public void setCalidadGarras(float calidadGarras) {
		this.calidadGarras = calidadGarras;
	}

	
	
	
}
