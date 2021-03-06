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
		ArrayList<Mascota> listSort = HelperMascota.sortArrayMascotaByName(list);
		
		Assert.assertEquals( "Firulais" ,listSort.get(0).getNombre()); 
		Assert.assertEquals( "Garffiel" ,listSort.get(1).getNombre()); 
		Assert.assertEquals( "Miki" ,listSort.get(2).getNombre()); 
		Assert.assertEquals( "Parrot" ,listSort.get(3).getNombre());
	}
	
	//@Test
	public void sortArrayMascotaByLength(){		
		
		ArrayList<Mascota> list = createArryayList();
		ArrayList<Mascota> listSort = HelperMascota.sortArrayMascotaByLength(list);
		
		int size=list.size()-1;		
		for(int i=0; i<size; i++)
			Assert.assertTrue(listSort.get(i).getLargo()<listSort.get(i+1).getLargo());
		
		showList(listSort);
				
	}
	
	
	//@Test
	public void testSortByOwnerName(){
		ArrayList<Mascota> list = createArryayList();
		ArrayList<Mascota> listSort = HelperMascota.sortArrayMascotaByEmail(list);
		
		Assert.assertEquals("ajordi@poo.com", listSort.get(0).getPropietario().getEmail());
		Assert.assertEquals( "bfredy@poo.com" ,listSort.get(1).getPropietario().getEmail()); 
		Assert.assertEquals( "cmarc@poo.com" ,listSort.get(2).getPropietario().getEmail()); 
		Assert.assertEquals( "josep@poo.com" ,listSort.get(3).getPropietario().getEmail());
		
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
