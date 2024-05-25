package LABORATORIO3;

public class Pelicula extends Contenido { // COMO EN SERIE, PELICULA ES HIJA DE CONTENIDO. SE EXTIENDE.

	String Productora, PaisOrigen;

	// METODO CONSTRUCTOR
	public Pelicula(String tituloContenido, String descripcion, int fechaEstreno, int duracionMinutos,
			boolean tendencias, String productora, String paisOrigen) {
		super(tituloContenido, descripcion, fechaEstreno, duracionMinutos, tendencias); // Aparece porque es hija de
																						// contenido
		Productora = productora;
		PaisOrigen = paisOrigen;
	}

	// A IGUAL QUE EN SERIE, PASO A CADENA DE CARACTERES LAS REFERENCIAS DE
	// CONTENIDO.CSV

	@Override
	public String toString() {
		String Tendencias = (isTendencias()) ? "Si" : "No";
		return "\n\tTítulo Película: " + getTituloContenido() + "\n	Descripción: " + getDescripcion()
				+ "\n	Fecha de estreno: " + getFechaEstreno() + "\n	Duración (en min): " + getDuracionMinutos()
				+ "\n	Tendencia: " + Tendencias + "\n	Productora: " + Productora + "\n	País: " + PaisOrigen;

	}

	// GETTERS Y SETTERS

	public String getProductora() {
		return Productora;
	}

	public void setProductora(String productora) {
		Productora = productora;
	}

	public String getPaisOrigen() {
		return PaisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		PaisOrigen = paisOrigen;
	}

}