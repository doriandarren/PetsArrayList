package test;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import main.Mascota;
import main.Person;
import main.Roedor;
import util.HelperMascota;
import main.Ave;
import main.Canido;
import main.Felino;


public class testHelperMascotas {

	
	
	
	@Test
	public void testSortByName(){	
		ArrayList<Mascota> list = createArryayList(); 		
		HelperMascota.sortArrayMascotaByName(list);
		Assert.assertEquals( "Firulais" ,list.get(0).getNombre()); 
		Assert.assertEquals( "Garffiel" ,list.get(1).getNombre()); 
		Assert.assertEquals( "Miki" ,list.get(2).getNombre()); 
		Assert.assertEquals( "Parrot" ,list.get(3).getNombre());
	}
	
	//@Test
	public void sortArrayMascotaByLength(){		
		
		ArrayList<Mascota> list = createArryayList();
		
		HelperMascota.sortArrayMascotaByLength(list);
		
		int size=list.size()-1;		
		for(int i=0; i<size; i++)
			Assert.assertTrue(list.get(i).getLargo()<list.get(i+1).getLargo());
		
		showList(list);
				
	}
	
	
	//@Test
	public void testSortByOwnerName(){
		ArrayList<Mascota> list = createArryayList();
		HelperMascota.sortArrayMascotaByEmail(list);
		
		Assert.assertEquals("ajordi@poo.com", list.get(0).getPropietario().getEmail());
		Assert.assertEquals( "bfredy@poo.com" ,list.get(1).getPropietario().getEmail()); 
		Assert.assertEquals( "cmarc@poo.com" ,list.get(2).getPropietario().getEmail()); 
		Assert.assertEquals( "josep@poo.com" ,list.get(3).getPropietario().getEmail());
				
	}
		
	
	// @Test
	public void testArrayList() {
		ArrayList list = new ArrayList<Mascota>();
		Canido can = new Canido("Firulais", 40f, 0.50f, 0.50f);
		Person propietario = new Person("Luisa Lopez;555555555;luisa@gmail.com;horta 562");
		can.setPropietario(propietario);
		list.add(can);

		showList(list);
	}
	
	
	
	
	private void showList(ArrayList<Mascota> list) {
		System.out.println("Array List size "+ list.size());
		for(int i=0; i<list.size(); i++){
			System.out.println("Nombre: " + list.get(i).getNombre() 
					+ " pesa:"+list.get(i).getPeso()
					+ " Altura:"+list.get(i).getAltura()
					+ " Largo:"+list.get(i).getLargo()
					+ " Propietario: " + list.get(i).getPropietario().getName());
		}		
	}
	
	private ArrayList<Mascota> createArryayList() {

		ArrayList<Mascota> list = new ArrayList<Mascota>();

		// Mascotas
		Canido can = new Canido("Firulais", 40, 0.50f, 0.50f);
		Felino felino = new Felino("Garffiel", 20, 0.20f, 0.30f);
		Ave parrot = new Ave("Parrot", 0.5f, 0.10f, 0.15f);
		Roedor miki = new Roedor("Miki", 0.2f, 0.5f, 0.1f);

		// Propietarios
		Person propieCan = new Person("Fredy Campino;0034656000000;bfredy@poo.com;Calle Campino");
		Person propieFelino = new Person("Alex Guix;0034656000001;ajordi@poo.com;Calle Guix");
		Person propieParrot = new Person("Josep Cardona;0034656000002;josep@poo.com;Calle Cardona");
		Person propieMiki = new Person("Marc Font;0034656000003;cmarc@poo.com;Calle font");

		// iniciar el propietario a cada mascota
		can.setPropietario(propieCan);
		felino.setPropietario(propieFelino);
		parrot.setPropietario(propieParrot);
		miki.setPropietario(propieMiki);

		// add a la lista
		list.add(can);
		list.add(felino);
		list.add(parrot);
		list.add(miki);

		return list;
	}
	
	
}
