package PaqueteAnalisisContaminacion;

import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		ArrayList<MuestreoDatos> muestreo = AccesoFichero.leerDatos();
		String tabla = PintarHTML.crearTabla(muestreo);
		AccesoFichero.meterTabla(tabla);

	}

}
