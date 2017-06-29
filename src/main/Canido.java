package main;

public class Canido extends Mascota{

	private float calidadColmillo;
	
	
	public Canido(String nombre, float peso, float altura, float largo){
		super(nombre,peso,altura,largo);
		this.calidadColmillo=1;
	}
	
	public Canido(String nombre){
		super(nombre);
	}
	
	@Override
	public float getStadoNutricion() {	
		//peso / (altura * largo)
		return getPeso()/(getAltura() * getLargo());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Esto es un perro";
	}

	@Override
	public float getPesoRacion() {
		// 0.3*peso(2-calidadColmillo)
		return 0.3f*getPeso()*(2f-calidadColmillo);
	}

	@Override
	protected String getTypeClass() {
		return getClass().getName();
	}
	
	
	
	public float getCalidadColmillo() {
		return calidadColmillo;
	}

	public void setCalidadColmillo(float calidadColmillo) {
		this.calidadColmillo = calidadColmillo;
	}
	
}
