package PaqueteAnalisisContaminacion;

import java.util.ArrayList;

public class MuestreoDatos {
	String estacion;
	private String magnitud;
	private String fecha;
	private ArrayList<Float> valores;

	public MuestreoDatos(String string, String string2, String fecha, ArrayList<Float> valores) {
		super();
		this.estacion = string;
		this.magnitud = string2;
		this.fecha = fecha;
		this.valores = valores;
	}

	public String toString() {
		return "MuestreoDatos [estacion=" + estacion + ", magnitud=" + magnitud + ", fecha=" + fecha + ", valores="
				+ valores + "]";
	}

	public String getEstacion() {
		return estacion;
	}

	public String getMagnitud() {
		return magnitud;
	}

	public String getFecha() {
		return fecha;
	}

	public ArrayList<Float> getValores() {
		return valores;
	}

}
