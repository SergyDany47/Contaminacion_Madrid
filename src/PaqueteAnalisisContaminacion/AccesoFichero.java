package PaqueteAnalisisContaminacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AccesoFichero {
	private static String ruta = "C:\\Users\\SergioO\\Desktop\\UEM-Casa\\T-3\\Workspace\\ContaminacionMadrid\\horario.csv";

	public static ArrayList<MuestreoDatos> leerDatos() {
		File f = new File(ruta);

		ArrayList<MuestreoDatos> lista = new ArrayList<MuestreoDatos>();
		MuestreoDatos muestreo;
		ArrayList<Float> valores = new ArrayList<Float>();
		String datos[];
		String fecha;

		try {
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			linea = br.readLine();

			while (linea != null) {

				datos = linea.split(";");
				fecha = (datos[7] + "/" + datos[6] + "/" + datos[5]);
				valores = new ArrayList<Float>();

				for (int i = 8; i < datos.length - 1; i += 2) {
					valores.add(Float.parseFloat(datos[i]));
				}
				muestreo = new MuestreoDatos(nombreEstacion(Integer.parseInt(datos[2])),
						nombreMagnitud(Integer.parseInt(datos[3])), fecha, valores);
				lista.add(muestreo);
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static void meterTabla(String tabla) {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\SergioO\\Desktop\\UEM-Casa\\T-3\\Workspace\\ContaminacionMadrid\\pintar.html");
			fw.write(tabla);
			fw.close();
			System.out.println("Se ha exportado la tabla al fichero correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String nombreMagnitud(int magnitud) {
		HashMap<Integer, String> magnitudes = new HashMap<Integer, String>();
		magnitudes.put(1, "Dioxido de Azufre");
		magnitudes.put(6, "Mononoxido de Carbono");
		magnitudes.put(7, "Monoxido de Nitrogeno");
		magnitudes.put(8, "Dioxido de Nitrogeno");
		magnitudes.put(9, "Particulas < 2.5 um");
		magnitudes.put(10, "Particulas < 10 um");
		magnitudes.put(12, "Oxidos de Nitrogeno");
		magnitudes.put(14, "Ozono");
		magnitudes.put(20, "Tolueno");
		magnitudes.put(30, "Benceno");
		magnitudes.put(35, "Etilbenceno");
		magnitudes.put(37, "Metaxileno");
		magnitudes.put(38, "Paraxileno");
		magnitudes.put(39, "Ortoxileno");
		magnitudes.put(42, "Hidrocarburos totales");
		magnitudes.put(43, "Metano");
		magnitudes.put(44, "Hidrocarburos no metanicos(hexano)");
		return magnitudes.get(magnitud);

	}

	public static String nombreEstacion(int estacion) {
		HashMap<Integer, String> estaciones = new HashMap<Integer, String>();
		estaciones.put(4, "Pza. de España");
		estaciones.put(8, "Escuelas Aguirre");
		estaciones.put(11, "Av. Ramón y Cajal");
		estaciones.put(16, "Arturo Soria");
		estaciones.put(17, "Villaverde Alto");
		estaciones.put(18, "C/ Farolillo");
		estaciones.put(24, "Casa de Campo");
		estaciones.put(27, "Barajas");
		estaciones.put(35, "Pza. del Carmen");
		estaciones.put(36, "Moratalaz");
		estaciones.put(38, "Cuatro Caminos");
		estaciones.put(39, "Barrio del Pilar");
		estaciones.put(40, "Vallecas");
		estaciones.put(47, "Méndez Álvaro");
		estaciones.put(48, "Pº. Castellana");
		estaciones.put(49, "Retiro");
		estaciones.put(50, "Pza. Castilla");
		estaciones.put(54, "Ensanche Vallecas ");
		estaciones.put(55, "Urb. Embajada (Barajas)");
		estaciones.put(58, "El Pardo");
		estaciones.put(57, "Sanchinarro");
		estaciones.put(59, "Parque Juan Carlos I");
		estaciones.put(60, "Tres Olivos ");
		return estaciones.get(estacion);

	}
}
