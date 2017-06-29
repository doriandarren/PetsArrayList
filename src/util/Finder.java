package util;

import java.util.ArrayList;


/**
 * Esta clase queda Generica para busqueda de un patron en un ArrayList
 * suu uso es implementado en donde se crea el objeto
 * @author javaPoo
 *
 * @param <T>
 */
public class Finder<T> {

	/**
	 * Interface para crear el objeto con el patron de busqueda
	 * @author alumne
	 *
	 * @param <T>
	 */
	public interface ContainCheker<T>{
		public boolean containCheker(T object, Object patron);
	}
	
	/**
	 * Metodo Generico que encuentra la cualquier objeto dentro de un Array List
	 * 
	 * @param list un ArrayList
	 * @param patron un String
	 * @param cheker un objeto boolean
	 * @return
	 */	
	public ArrayList<T> find(ArrayList<T> list, Object patron, ContainCheker<T> cheker){		
		ArrayList<T> listNew = new ArrayList<T>();				
		for(int i=0; i<list.size(); i++){			
			if(cheker.containCheker(list.get(i), patron)){
				listNew.add(list.get(i));
			}			
		}		
		return listNew;
	}
}
