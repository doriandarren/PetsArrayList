package view;

import java.util.ArrayList;

import data.FileHelper;
import data.GsonHelper;
import main.Mascota;
import util.Input;

public class PetsArrayList {

	private static final String A_FILE_NAME = "file.txt";
	
	//CONSDTANTES DE MENU
	private final static String ADD = "add";
	
	private static final String DEL = "del";
	private static final String EDIT = "edit";
	private static final String SEARCH = "search";
	private static final String LIST = "list";
	private static final String SALIR = "salir";
	
		
	public static void main(String[] args) {		
		
		String strJson = FileHelper.readFile(A_FILE_NAME);
		ArrayList<Mascota> list = new ArrayList<Mascota>();
		list = GsonHelper.convertGsonToArrayList(strJson);		
		String[] opc;
		
		do{
			opc = UserInterface.menuMain().split(" ");
			
			if(opc.length==2 && opc[0].equals(ADD) 
					&& (opc[1].toLowerCase().equals("ave") 
							|| opc[1].toLowerCase().equals("canido")
							|| opc[1].toLowerCase().equals("felino") 
							|| opc[1].toLowerCase().equals("roedor"))
					){
				//add
				UserInterface.clearScreen();				
				Mascota mascota = UserInterface.inputNewRegister(opc[1]);				
				list.add(mascota);
				//Actualizar GSON
				String strJsonAdd = GsonHelper.convertArrayListToGson(list); 				
				FileHelper.writeFile(strJsonAdd, A_FILE_NAME);	
				
			}else if(opc.length==1 && opc[0].equals(DEL)){
				//del
				UserInterface.clearScreen();
				UserInterface.printListAll(list);
				int index = Integer.valueOf(Input.scanLineSecure("Ingrese el número(#): ", 4, false));				
				String strQues = Input.scanLineSecure("Seguro de Eliminar? s/n: ", 1, false);				
				if(strQues.equals("s")){
					list.remove(index-1);				
					//Actualizar GSON
					String strJsonAdd = GsonHelper.convertArrayListToGson(list); 				
					FileHelper.writeFile(strJsonAdd, A_FILE_NAME);	
				}
								
			}else if(opc.length==1 && opc[0].equals(EDIT)){
				//edit
				UserInterface.clearScreen();
				UserInterface.printMascotas(list);
				int index = Integer.valueOf(Input.scanLineSecure("Ingrese el número(#): ", 4, false));
				index = index - 1;
				UserInterface.clearScreen();
				UserInterface.printOne(list.get(index));				
				Mascota mascotaEdit = UserInterface.inputEditRegister(list.get(index));				
				list.set(index, mascotaEdit);
				
				//Actualizar GSON
				String strJsonAdd = GsonHelper.convertArrayListToGson(list); 				
				FileHelper.writeFile(strJsonAdd, A_FILE_NAME);
				
			}else if(opc.length==1 && opc[0].equals(SEARCH)){
				//search				
				UserInterface.clearScreen();
				System.out.println("Búsqueda por Nombre o Email del Propietario");
				System.out.print("Ingrese el valor a buscar: ");
				String patron = Input.scannLine();								
				if(patron.contains("@")){
					ArrayList<Mascota> listFindEmail = UserInterface.searchEmailOwner(list,patron);
					UserInterface.printListAll(listFindEmail);
				}else{
					ArrayList<Mascota> listFindName = UserInterface.searchNameOwner(list,patron);
					UserInterface.printListAll(listFindName);
				}				
				
			}else if(opc.length==1 && opc[0].equals(LIST)){
				//list
				UserInterface.clearScreen();
				UserInterface.printListAll(list);
			}else{
				//error
				UserInterface.clearScreen();
				System.out.println("Por favor! Ingrese un comando válido");
			}		
		}while(!opc[0].equals(SALIR));
		System.out.println("Hasta luego");
		
	}

}
