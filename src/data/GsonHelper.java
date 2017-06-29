package data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import main.Ave;
import main.Canido;
import main.Felino;
import main.Mascota;
import main.Roedor;

/**
 * Esta clase requiere la libreria GSON, el artifact (.jar) se puede descargar
 * en:
 * 
 * https://mvnrepository.com/artifact/com.google.code.gson/gson/2.3.1
 * 
 * @author campino
 *
 */
public class GsonHelper {

	private static Map<String, Class> map = new TreeMap<String, Class>();

	/** Adicione las clases que sea necesario */
	static {
		map.put(Mascota.class.getName(), Mascota.class);
		map.put(Felino.class.getName(), Felino.class);
		map.put(Canido.class.getName(), Canido.class);
		map.put(Ave.class.getName(), Ave.class);
		map.put(Roedor.class.getName(), Roedor.class);

	}

	/**
	 * Convierte una lista de mascotas ListMascotas a un String, pone todas las
	 * mascotas en formato JSON. Para visualizar
	 * 
	 * @param list
	 * @return
	 */

	public static String convertArrayListToGson(ArrayList<Mascota> list) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Mascota.class, new MascotaSerializer());
		Type typeToken = new TypeToken<ArrayList<Mascota>>() {
		}.getType();
		Gson gson = builder.create();
		String strList = gson.toJson(list, typeToken);
		return strList;
	}

	/**
	 * Convierte una String con formato JSON a un objeto tipo ListaMascotas
	 * 
	 * @param strJson
	 * @return   el arrayList de mascotas, si strJson no tiene nada retorna null
	 */
	public static ArrayList<Mascota> convertGsonToArrayList(String strJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Mascota.class, new MascotaDeserializer());
		Gson gson = builder.create();
		Type typeToken = new TypeToken<ArrayList<Mascota>>() {
		}.getType();
		ArrayList<Mascota> list = gson.fromJson(strJson, typeToken);		
		list = list!=null ? list : new ArrayList<Mascota>();		
		return list;
	}

	private static class MascotaDeserializer implements JsonDeserializer<Mascota> {

		@SuppressWarnings("rawtypes")
		@Override
		public Mascota deserialize(JsonElement json, Type type, JsonDeserializationContext context)
				throws JsonParseException {

			String typeClass = json.getAsJsonObject().get("typeClass").getAsString();

			Class clazz = map.get(typeClass);
			if (clazz == null)
				throw new RuntimeException("No encuentra el miembro typeClass");
			return context.deserialize(json, clazz);
		}

	}

	private static class MascotaSerializer implements JsonSerializer<Mascota> {

		@SuppressWarnings("rawtypes")
		@Override
		public JsonElement serialize(Mascota mascota, Type type, JsonSerializationContext context) {

			if (mascota.typeClass == null)
				throw new RuntimeException(
						"La clase " + mascota.getClass().getName() + " no redefine el metodo getTypeClass()");

			Class clazz = map.get(mascota.typeClass);

			if (clazz == null)
				throw new RuntimeException("La clase no esta registrada en map: " + mascota.typeClass);
			return context.serialize(mascota, clazz);
		}
	}

}