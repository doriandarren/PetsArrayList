package data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

final static Charset ENCODING = StandardCharsets.UTF_8;

	/**
	 * Este metodo lee un archivo y devuelve un String
	 * 
	 * Ejercicio: Lee un archivo y retorna su contenido como una String, 
	 * si el archivo no existe debe crearlo y escribir:
	 * Texto de prueba.
	 * 
	 * Utilice la clase String builder
	 * https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html 
	 * @param aFileName
	 * @return
	 */
	public static String readFile(String aFileName){
				
		StringBuilder fileLines=null;
		List<String> list;
		
		try {			
			list = readSmallTextFile(aFileName);
			int size = list.size();
			fileLines = new StringBuilder();
			for (int i = 0; i < size; i++)
				fileLines.append(list.get(i));
			
		} catch (NoSuchFileException e) {
			
			//writeFile("Texto de prueba", aFileName);
			System.err.format("Importante! La base de datos: \"%s\" Se creo exitosamente.\n", aFileName);
			fileLines = new StringBuilder();
			fileLines.append(" ");
		
		} catch (IOException e) { 
			System.err.format("%s: no such" + " file or directory%n", aFileName);
			fileLines = null;
			//e.printStackTrace();
		}		
		
		return fileLines.toString();
	}
	
	
		
	
	/**
	 * ReWrite a String to a text file to format GSON
	 * @param aLines array width the lines that you want to write 
	 * @param aFileName name of file
	 * @return
	 */
	public static boolean writeFile(String aLines, String aFileName){
		boolean done = true; 
		List<String> list = new ArrayList<String>();		
		list.add(aLines); 		
		try {
			writeSmallTextFile(list,aFileName);
		} catch (IOException e) {
			e.printStackTrace(); 
			done = false; 
		} 
		return done; 
	}
	
		

	private static List<String> readSmallTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	     //if(!Files.exists(path))
	    	//Files.createFile(path);	
	    return Files.readAllLines(path, ENCODING);
	}
		
	private static void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    Files.write(path, aLines, ENCODING, StandardOpenOption.CREATE,
	            StandardOpenOption.TRUNCATE_EXISTING );
    }
	
}
