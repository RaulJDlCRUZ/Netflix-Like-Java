package LABORATORIO3;

public class Serie extends Contenido { // SERIE ES UNA CLASE HIJA DE CONTENIDO. POR ESO CONTENIDO SE "EXTIENDE" POR
										// SERIE. APORTA MAS INFORMACION

	private int numTemporadas, numCapitulos;

	// METODO CONSTRUCTOR

	public Serie(String tituloContenido, String descripcion, int fechaEstreno, int duracionMinutos, boolean tendencias,
			int numTemporadas, int numCapitulos) {
		super(tituloContenido, descripcion, fechaEstreno, duracionMinutos, tendencias); // por ser clase hija, usamos
																						// super. hereda todo esto.
		this.numTemporadas = numTemporadas;
		this.numCapitulos = numCapitulos;
	}

	// TOSTRING. ESTO LO HAGO PARA QUE A LA HORA DE MOSTRAR EL CONTENIDO SE MUESTRE
	// DE FORMA LITERAL Y NO LA REFERENCIA

	@Override
	public String toString() {
		String Tendencias = (isTendencias()) ? "Si" : "No"; // como en promoción, sí o no en lugar de true o false.
		return "\n \tTítulo Serie: " + getTituloContenido() + "\n	Descripción: " + getDescripcion()
				+ "\n	Fecha de estreno: " + getFechaEstreno() + "\n	Duración (en min): " + getDuracionMinutos()
				+ "\n	Tendencia: " + Tendencias + "\n	Temporadas: " + numTemporadas + "\n	Capítulos: " + numCapitulos;
	}

	// GETTERS Y SETTERS

	public int getNumTemporadas() {
		return numTemporadas;
	}

	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public int getNumCapitulos() {
		return numCapitulos;
	}

	public void setNumCapitulos(int numCapitulos) {
		this.numCapitulos = numCapitulos;
	}

}