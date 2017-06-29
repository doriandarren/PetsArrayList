package main;

/**
 * como mascota es abstracta 
 * NO PODRA ser instanciada directamente
 * Solo vale para ser extendida
 * Las clases que extiendan de esta clase deberan implementar
 */

public abstract class Mascota {

	// Obligatorio para que funcione GSON 
	final public String typeClass; 
	
	//Se inyecto la clase Person dentro de esta clase Mascota
	private Person propietario;
	
	private String nombre;
	private float peso;
	private float altura;
	private float largo;
	
	public Mascota(){
		typeClass= getTypeClass(); 
	}
	
	
	public Mascota(String nombre, float peso, float altura, float largo){
		typeClass= getTypeClass(); 
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.largo = largo;
	}
	
	public Mascota(String nombre){
		typeClass= getTypeClass();
		this.nombre = nombre;
	}
	
	
	//metodo que se redefinira 	
	public abstract float getStadoNutricion();
			
	
	/**	  -------------   Metodo ABSTRACTO    -------------- 
	 * debe ser definido en las clases
	 * que extienden de esta clase (Mascota). como mascota es abstracta 
	 * NO PODRA ser instanciada directamente
	 * @return
	 */
	public abstract float getPesoRacion();
	
	/**
	 * Metodo que debe retornar el nombre de la clase, 
	 * Use getClass().getName();  debe definirse en todos los objetos que extienden de
	 * Mascota
	 * @return
	 */
	protected abstract String getTypeClass();
	
	
	
	@Override
	public String toString() {
		return "Esto es una mascota";
	}



	/****************
	 * 
	 * GETER Y SETER	
	 * 
	 ****************/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public Person getPropietario() {
		return propietario;
	}

	public void setPropietario(Person propietario) {
		this.propietario = propietario;
	}
	
	
}
