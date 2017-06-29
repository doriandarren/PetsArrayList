package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


import main.Ave;
import main.Canido;
import main.Felino;
import main.Mascota;
import main.Person;
import main.Roedor;
import util.Finder;

public class TestFinder {

	//@Test
	public void testFinderByNameMascota(){		
		ArrayList<Mascota> list = createArryayList();		
		Finder<Mascota> finder = new Finder<Mascota>();		
		
		ArrayList<Mascota> resultList = 
		finder.find(list, "Josep", new Finder.ContainCheker<Mascota>(){
			@Override
			public boolean containCheker(Mascota mascota, Object patron) {				
				return mascota.getPropietario().getName().toLowerCase().equals(((String) patron).toLowerCase());
			}
			
		});
		Assert.assertEquals("Parrot", resultList.get(0).getNombre());		
		showList(resultList);		
	}
	
	
	@Test
	public void testFinderByEmailOwner(){		
		ArrayList<Mascota> list = createArryayList();		
		Finder<Mascota> finder = new Finder<Mascota>();		
		
		ArrayList<Mascota> resultList = 
		finder.find(list, "josep@poo.com", new Finder.ContainCheker<Mascota>(){
			@Override
			public boolean containCheker(Mascota mascota, Object patron) {				
				return mascota.getPropietario().getEmail().toLowerCase().equals(((String) patron).toLowerCase());
			}
			
		});
		Assert.assertEquals("Parrot", resultList.get(0).getNombre());		
		showList(resultList);		
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
