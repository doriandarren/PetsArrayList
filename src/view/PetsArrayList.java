package view;

import java.util.ArrayList;

import data.FileHelper;
import data.GsonHelper;
import main.Mascota;
import util.Input;

public class PetsArrayList {

	private static final String A_FILE_NAME = "file.txt";
	
	public static void main(String[] args) {
		
		
		String strJson = FileHelper.readFile(A_FILE_NAME);
		ArrayList<Mascota> list = new ArrayList<Mascota>();
		list = GsonHelper.convertGsonToArrayList(strJson);		
		String[] opc;
		
		do{
			opc = UserInterface.menuMain().split(" ");
			
			if(opc.length==2 && opc[0].equals("add") 
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
				
			}else if(opc.length==1 && opc[0].equals("del")){
				//del
				UserInterface.clearScreen();
				UserInterface.printListAll(list);
				int index = Integer.valueOf(Input.scanLineSecure("Ingrese el número(#): ", 4, false));
				list.remove(index-1);
				
				//Actualizar GSON
				String strJsonAdd = GsonHelper.convertArrayListToGson(list); 				
				FileHelper.writeFile(strJsonAdd, A_FILE_NAME);	
				
			}else if(opc.length==1 && opc[0].equals("edit")){
				//edit
				UserInterface.clearScreen();
				UserInterface.printListAll(list);
				int index = Integer.valueOf(Input.scanLineSecure("Ingrese el número(#): ", 4, false));
				index = index - 1;
				UserInterface.clearScreen();
				UserInterface.printOne(list.get(index));				
				Mascota mascotaEdit = UserInterface.inputEditRegister(list.get(index));				
				list.set(index, mascotaEdit);
				
				//Actualizar GSON
				String strJsonAdd = GsonHelper.convertArrayListToGson(list); 				
				FileHelper.writeFile(strJsonAdd, A_FILE_NAME);
				
			}else if(opc.length==1 && opc[0].equals("search")){
				//search
				
				UserInterface.clearScreen();
				String searchInput = Input.scannLine();
				
								
				
				
			}else if(opc.length==1 && opc[0].equals("list")){
				//list
				UserInterface.clearScreen();
				UserInterface.printListAll(list);
			}else{
				//error
				UserInterface.clearScreen();
				System.out.println("Por favor! Ingrese un comando válido");
			}		
		}while(!opc.equals("salir"));
		System.out.println("Hasta luego");
		

	}

}
