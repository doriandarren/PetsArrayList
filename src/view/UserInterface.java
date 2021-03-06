package view;

import java.util.ArrayList;

import main.Ave;
import main.Canido;
import main.Felino;
import main.Mascota;
import main.Person;
import main.Roedor;
import util.Finder;
import util.Input;

public class UserInterface {

	/**
	 * Limpia la pantalla
	 */
	public static void clearScreen(){		
		for(int i=0; i<50;i++){
			System.out.println();
		}
	}
	
	/**
	 * Muestra el menu Principal
	 * @return
	 */
	public static String menuMain(){
		final String menuDescripcion[] = {"[add] [Mascota] Agregar","[del] Eliminar"
				,"[edit] Editar","[search] Consultar","[list] Listado","[salir] Salir"};		
		
		System.out.println("\n***********************************************************************************************");
		System.out.println("\t\t\t\t ---  Men� Principal  ---");
		for(int i=0; i<menuDescripcion.length;i++){
			System.out.print(menuDescripcion[i]+" ");
		}
		System.out.println("\n\nAyuda: [Mascota] = ave / canido / felino / Roedor");		
		System.out.println("***********************************************************************************************");
		String opc = Input.scanLineSecure("Escriba su opci�n: ", 1,false);		
		return opc;
	}
	
	
	/**
	 * Crea un nuevo objeto Mascota
	 * @param opc
	 * @return
	 */
	public static Mascota inputNewRegister(String opc) {
		System.out.println("Nuevo Registro");	
		String nombre;
		float peso;
		float altura;
		float largo;
		
		System.out.println("Formulario para " + opc);
		nombre = Input.scanLineSecure("Escriba el Nombre: ", 1, false);
		peso = Float.valueOf(Input.scanLineSecure("Escriba el Peso: ", 4, false));
		altura = Float.valueOf(Input.scanLineSecure("Escriba el Altura: ", 4, false));
		largo = Float.valueOf(Input.scanLineSecure("Escriba el Largo: ", 4, false));
		
		if(opc.equals("ave")){
			Ave ave = new Ave(nombre, peso, altura, largo);	
			ave.setPropietario(inputNewRegisterPerson());
			return ave;
		}else if(opc.equals("canido")){
			Canido canido = new Canido(nombre, peso, altura, largo);	
			canido.setPropietario(inputNewRegisterPerson());
			return canido;
		}else if(opc.equals("felino")){
			Felino felino = new Felino(nombre, peso, altura, largo);
			felino.setPropietario(inputNewRegisterPerson());
			return felino;
		}else if(opc.equals("roedor")){
			Roedor roedor = new Roedor(nombre, peso, altura, largo);	
			roedor.setPropietario(inputNewRegisterPerson());
			return roedor;
		}
		return null;
	}		
	
	
	/**
	 * Crea un nuevo objeto Pripietario
	 * @return
	 */
	public static Person inputNewRegisterPerson() {
		System.out.println("Datos del Propietario");
		String newName = "";
		String newPhone = "";
		String newEmail = "";
		String newAddress = "";		
		
		newName = Input.scanLineSecure("Escriba Nombre y Apellido: ", 1, false);
		newPhone = Input.scanLineSecure("Tel�fono: ", 5, false);
		newEmail = Input.scanLineSecure("Email: ", 3, false);
		newAddress = Input.scanLineSecure("Direcci�n: ", 2, false);
		
		//Se crea un registro nuevo y se retorna
		Person newPerson = new Person(); 
		
		//Formatear el nombre y el apellido
		String fullName[] = newName.split(" "); 
		String nombre = fullName.length==2 ? fullName[0] : newName;
		String apellido  = fullName.length==2 ? fullName [1] : "";
		
		newPerson.setName(nombre);
		newPerson.setSurname(apellido);
		newPerson.setPhone(newPhone);
		newPerson.setEmail(newEmail);
		newPerson.setAddress(newAddress);
		return newPerson;
	}
	
	
	
	
	/**
	 * Edita un registro 
	 * @param mascota
	 * @return
	 */
	public static Mascota inputEditRegister(Mascota mascota) {
		System.out.println("Editar Registro");	
		String newName = "";
		float newPeso = 0;
		float newAltura = 0;
		float newLargo = 0;	
		
		System.out.println("Formulario para " + mascota.getClass().getSimpleName());
		
		String nameOld = Input.scanLineSecure("Escriba el Nombre: ", 1, true);		
		if(nameOld.isEmpty() || mascota.getNombre().toLowerCase().equals(nameOld.toLowerCase())){
			newName = mascota.getNombre();  
		}else{
			newName = nameOld; 
		}		
		
		String pesoOld = Input.scanLineSecure("Escriba el Peso: ", 4, true);		
		if(pesoOld.isEmpty() || mascota.getPeso() == Float.valueOf(pesoOld)){
			newPeso = mascota.getPeso();
		}else{
			newPeso = Float.valueOf(pesoOld);
		}
				
		String alturaOld = Input.scanLineSecure("Escriba el Altura: ", 4, true);
		if(alturaOld.isEmpty() || mascota.getAltura() == Float.valueOf(alturaOld)){
			 newAltura = mascota.getAltura();
		}else{
			newAltura = Float.valueOf(alturaOld);
		}
		
		
		String largoOld = Input.scanLineSecure("Escriba el Largo: ", 4, true);		
		if(largoOld.isEmpty() || mascota.getLargo() == Float.valueOf(largoOld)){
			newLargo = mascota.getLargo();
		}else{
			newLargo = Float.valueOf(largoOld);
		}
				
		mascota.setNombre(newName);
		mascota.setPeso(newPeso);
		mascota.setAltura(newAltura);
		mascota.setLargo(newLargo);
		mascota.setPropietario(inputEditRegisterPerson(mascota.getPropietario()));		
		return mascota;
	}
		
	
	
	/**
	 * Edita un Objeto de Person
	 * @param person
	 * @return
	 */
	public static Person inputEditRegisterPerson(Person person) {
		System.out.println("Editar Registro");
		String newName = "";
		String newPhone = "";
		String newEmail = "";
		String newAddress = "";

		String retornStr = Input.scanLineSecure("Escriba Nombre y Apellido: ", 1, true);
		if (retornStr.isEmpty() || person.getFullName().equals(retornStr)) {
			newName = person.getName() + " " + person.getSurname();
		} else {
			newName = retornStr;
		}

		retornStr = Input.scanLineSecure("Tel�fono: ", 5, true);
		if (retornStr.isEmpty() || person.getPhone().equals(retornStr)) {
			newPhone = person.getPhone();
		} else {
			newPhone = retornStr;
		}

		retornStr = Input.scanLineSecure("Email: ", 3, true);
		if (retornStr.isEmpty() || person.getEmail().equals(retornStr)) {
			newEmail = person.getEmail();
		} else {
			newEmail = retornStr;
		}

		retornStr = Input.scanLineSecure("Direcci�n: ", 2, true);
		if (retornStr.isEmpty() || person.getAddress().equals(retornStr)) {
			newAddress = person.getAddress();
		} else {
			newAddress = retornStr;
		}

		// Se crea un registro nuevo y se retorna
		Person newPerson = new Person();

		// Formatear el nombre y el apellido
		String fullName[] = newName.split(" ");
		String nombre = fullName.length == 2 ? fullName[0] : newName;
		String apellido = fullName.length == 2 ? fullName[1] : "";

		// Cargan / Seteo el nuevo objeto
		newPerson.setName(nombre);
		newPerson.setSurname(apellido);
		newPerson.setPhone(newPhone);
		newPerson.setEmail(newEmail);
		newPerson.setAddress(newAddress);
		return newPerson;
	}
		
	
	/**
	 * Ecuentra nombre dentro de ArrayList
	 * @param list ArrayList
	 * @param strSearch String
	 * @return
	 */
	public static ArrayList<Mascota> searchNameOwner(ArrayList<Mascota> list, String strSearch) {			
		Finder<Mascota> finder = new Finder<Mascota>();
		ArrayList<Mascota> resultList = finder.find(list, strSearch, new Finder.ContainCheker<Mascota>() {
			@Override
			public boolean containCheker(Mascota mascota, Object patron) {
				return mascota.getPropietario().getFullName().toLowerCase().contains(((String) patron).toLowerCase());
			}
		});
		return resultList;
	}
	
	/**
	 * Encuentra Email dentro del ArrayList
	 * @param list ArrayList
	 * @param strSearch  String
	 * @return
	 */
	public static ArrayList<Mascota> searchEmailOwner(ArrayList<Mascota> list, String strSearch) {			
		Finder<Mascota> finder = new Finder<Mascota>();
		ArrayList<Mascota> resultList = finder.find(list, strSearch, new Finder.ContainCheker<Mascota>() {
			@Override
			public boolean containCheker(Mascota mascota, Object patron) {
				return mascota.getPropietario().getEmail().toLowerCase().contains(((String) patron).toLowerCase());
			}
		});
		return resultList;
	}
	
	/**
	 * Imprimir lista de registros
	 * @param list
	 */
	public static void printListAll(ArrayList<Mascota> list) {
		if (!list.equals(null) || list.size()>0) {
			// Controlar cuando no exista el Objeto Person
			System.out.println("Listar Todos");
			System.out.println("#\t Tipo \t Nombre \t Peso \t Altura \t Largo");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("---------------------------------------------------------------------");
				System.out.print((i + 1) 
						+"\t"+ list.get(i).getClass().getSimpleName()
						+ "\t" + list.get(i).getNombre() 
						+ "\t" + list.get(i).getPeso()
						+ "\t" + list.get(i).getAltura()
						+ "\t" + list.get(i).getLargo());
			
				System.out.print("\t PROPIETARIO: " + list.get(i).getPropietario().getName()
						+ "\t" + list.get(i).getPropietario().getSurname()
						+ "\t" + list.get(i).getPropietario().getPhone()
						+ "\t" + list.get(i).getPropietario().getEmail()
						+ "\t"	+ list.get(i).getPropietario().getAddress());
				System.out.print("\n---------------------------------------------------------------------");
			
			}
		}else{
			System.out.println("No existe registros \n");
		}
	}
	
	
	/*
	 * Imprimir lista de registros
	 * @param list
	 *
	public static void printListAll(ArrayList<Mascota> list) {
		if (!list.equals(null) || list.size()>0) {
			// Controlar cuando no exista el Objeto Person
			System.out.println("Listar Todos");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("# " + (i + 1) + "\n+Mascota " + list.get(i).getClass().getSimpleName()+"\n"
						+ "Nombre: " + list.get(i).getNombre() + " "
						+ "Peso: " + list.get(i).getPeso() + " " 
						+ "Altura: " + list.get(i).getAltura() + " "
						+ "Largo: " + list.get(i).getLargo() + " " 
						+ "\n++Propietario \n" 
						+ "Nombre: " + list.get(i).getPropietario().getName() + " " 
						+ "Apellido: " + list.get(i).getPropietario().getSurname() + " " 
						+ "Telefono: " + list.get(i).getPropietario().getPhone() + " " 
						+ "Email: " + list.get(i).getPropietario().getEmail() + " " 
						+ "Direcci�n: "	+ list.get(i).getPropietario().getAddress());
			}
		}else{
			System.out.println("No existe registros \n");
		}
	}
	
	 
	 * */
	
	
	
	
	/**
	 *  Imprimir lista de registros
	 * @param mascota
	 */
	public static void printOne(Mascota mascota) {
		if (!mascota.equals(null)) {
			System.out.println("Registro: ");			
			System.out.println("\n+Mascota "+ mascota.getClass().getSimpleName()+"\n"
					+ "Nombre: " + mascota.getNombre() + " "
					+ "Peso: " + mascota.getPeso() + " " 
					+ "Altura: " + mascota.getAltura() + " "
					+ "Largo: " + mascota.getLargo() + " " 
					+ "\n++Propietario \n" 
					+ "Nombre: " + mascota.getPropietario().getName() + " " 
					+ "Apellido: " + mascota.getPropietario().getSurname() + " " 
					+ "Telefono: " + mascota.getPropietario().getPhone() + " " 
					+ "Email: "	+ mascota.getPropietario().getEmail() + " " 
					+ "Direcci�n: "	+ mascota.getPropietario().getAddress());			
		}else{
			System.out.println("No existe registros \n");
		}
	}
		
	
	/**
	 * Imprimir lista de registros Mascota
	 * @param list ArrayList
	 */
	public static void printMascotas(ArrayList<Mascota> list) {
		if (!list.equals(null) || list.size()>0) {
			System.out.println("Listar Todos");
			System.out.println("#\tTipo\tNombre\t\tPeso\tAltura\tLargo");
			for (int i = 0; i < list.size(); i++) {
				System.out.println((i + 1) 
						+"\t"+ list.get(i).getClass().getSimpleName()
						+ "\t" + list.get(i).getNombre() 
						+ "\t\t" + list.get(i).getPeso()
						+ "\t" + list.get(i).getAltura()
						+ "\t" + list.get(i).getLargo());
			}
		}else{
			System.out.println("No existe registros \n");
		}
	}
	
	
	/**
	 * Imprimir lista de registros Person
	 * @param list ArrayList
	 */
	public static void printPropietarios(ArrayList<Mascota> list) {
		if (!list.equals(null) || list.size()>0) {
			System.out.println("Listar Todos");
			System.out.println("#\tNombre\t\tApellido\tTel�fono\tEmail\tDirecci�n");
			for (int i = 0; i < list.size(); i++) {
				System.out.println((i + 1) 
						+ "\t" + list.get(i).getPropietario().getName()
						+ "\t" + list.get(i).getPropietario().getSurname()
						+ "\t" + list.get(i).getPropietario().getPhone()
						+ "\t" + list.get(i).getPropietario().getEmail()
						+ "\t"	+ list.get(i).getPropietario().getAddress());
			}
		}else{
			System.out.println("No existe registros \n");
		}
	}
	
	
}
