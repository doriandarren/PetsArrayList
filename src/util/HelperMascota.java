package util;

import java.util.ArrayList;
import java.util.Comparator;

import main.Mascota;

public class HelperMascota {

	public static ArrayList<Mascota> sortArrayMascotaByLength(ArrayList<Mascota> list){
		//Copia
		ArrayList<Mascota> listNew = new ArrayList<Mascota>(); 
		listNew.addAll(list);
		
		listNew.sort(new Comparator<Mascota>() {
			@Override
			public int compare(Mascota o1, Mascota o2) {
				int r=0;
				if(o1.getLargo()<o2.getLargo()){
					r=-1;
				}else if(o1.getLargo()>o2.getLargo()){
					
				}				
				return r;
			}
		});
		return listNew;	
	}
		
	/**
	 * Ordena por nombre de Mascota
	 * @param list
	 * @return
	 */
	public static ArrayList<Mascota> sortArrayMascotaByName(ArrayList<Mascota> list){		
		//Copia
		ArrayList<Mascota> listNew = new ArrayList<Mascota>(); 
		listNew.addAll(list);		
		listNew.sort(new Comparator<Mascota>() {
			@Override
			public int compare(Mascota o1, Mascota o2) {
				return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
			}
		});		
		return listNew;	
	}
	
	
	
	
	
	
	/**
	 * Ordena por Email de Propietario
	 * @param list
	 * @return
	 */
	public static ArrayList<Mascota> sortArrayMascotaByEmail(ArrayList<Mascota> list){
		//Copia
		ArrayList<Mascota> listNew = new ArrayList<Mascota>(); 
		listNew.addAll(list);
		listNew.sort(new Comparator<Mascota>() {
			@Override
			public int compare(Mascota o1, Mascota o2) {
				return o1.getPropietario().getEmail().toLowerCase()
				.compareTo(o2.getPropietario().getEmail().toLowerCase());
			}
		});
		return listNew;	
	}
	
	
}
