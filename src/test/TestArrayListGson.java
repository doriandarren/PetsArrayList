package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import data.GsonHelper;
import main.Ave;
import main.Canido;
import main.Felino;
import main.Mascota;
import main.Person;
import main.Roedor;

public class TestArrayListGson {
	
	@Test
	public void testListToJson(){
		
		ArrayList<Mascota> list = getMockListMascotas();
		
		String strJson = GsonHelper.convertArrayListToGson(list); 
		Assert.assertNotNull(strJson);
		ArrayList<Mascota> results=null;
		
		try{
		   results = GsonHelper.convertGsonToArrayList(strJson); 
		   
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		// Ojo en este test no funciona comparar los objetos con equals
		// porque ?
		Assert.assertEquals(list.get(0).toString(), results.get(0).toString());
		Assert.assertEquals(list.get(1).toString(), results.get(1).toString());
		Assert.assertEquals(list.get(2).toString(), results.get(2).toString());
		Assert.assertEquals(list.get(3).toString(), results.get(3).toString());
	
	}
	
	
	
	 
	public 	ArrayList<Mascota> getMockListMascotas(){
		
		ArrayList<Mascota> list = new ArrayList<Mascota>();  
		
		
		// Mascotas 
		Canido can      = new Canido("Firulais", 40, 0.50f,0.50f);
		Felino felino   =new Felino("Garffiel", 20, 0.20f,0.30f); 
		Ave parrot 		= new Ave("Parro", 0.5f, 0.10f,0.15f); 
		Roedor miki   = new Roedor("Miki", 0.2f, 0.5f,0.1f); 
		
		//Propietarios 
		Person propieCan = new Person("Fredy Campino;0034656000000;fredy@poo.com;Calle Campino"); 
		Person propieFelino = new Person("Alex  Guix;0034656000001; jordi@poo.com;Calle Guix");
		Person propieParrot = new Person("Josep Cardona;0034656000002;josep@poo.com;Calle Cardona");
		Person propieMiki = new Person("Marc  Font;0034656000003;marc@poo.com;Calle font");
		
		// iniciar el propietario a cada mascota
		can.setPropietario(propieCan);
		felino.setPropietario(propieFelino); 	
		parrot.setPropietario(propieParrot); 	
		miki.setPropietario(propieMiki); 
		
		//add a la lista 
		list.add(can);
		list.add(felino);
		list.add(parrot);
		list.add(miki);
		
		return list; 
		
		
	}
	
	

}