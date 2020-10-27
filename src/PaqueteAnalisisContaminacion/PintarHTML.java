package PaqueteAnalisisContaminacion;

import java.util.ArrayList;

public class PintarHTML {
	public static String crearTabla(ArrayList<MuestreoDatos> datosContaminacion) {
		String horas, cabecera = "<table><tr><th>ESTACION</th><th>MAGNITUD</th><th>FECHA</th>";
		int a, b;

		for (int i = 0; i < 23; i++) {
			a = i;
			b = i + 1;
			horas = "<th>" + a + "-" + b + "</th>";
			cabecera += horas;
		}

		String contenido = "";
		String fin = "<table>";
		for (MuestreoDatos muestreoDatos : datosContaminacion) {
			contenido += "<tr>";
			contenido += "<td>" + muestreoDatos.getEstacion() + "</td>";
			contenido += "<td>" + muestreoDatos.getMagnitud() + "</td>";
			contenido += "<td>" + muestreoDatos.getFecha() + "</td>";
			for (int i = 0; i < muestreoDatos.getValores().size() - 1; i++) {
				contenido += "<td>" + muestreoDatos.getValores().get(i) + "</td>";
			}
			contenido += "<tr>";
		}
		String tabla = cabecera + contenido + fin;
		return tabla;
	}

}
