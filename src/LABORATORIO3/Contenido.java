package LABORATORIO3;

public abstract class Contenido {

	private String tituloContenido, Descripcion;
	private int FechaEstreno, DuracionMinutos;
	private boolean tendencias;

	// GETTERS Y SETTERS

	public String getTituloContenido() {
		return tituloContenido;
	}

	public void setTituloContenido(String tituloContenido) {
		this.tituloContenido = tituloContenido;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getFechaEstreno() {
		return FechaEstreno;
	}

	public void setFechaEstreno(int fechaEstreno) {
		FechaEstreno = fechaEstreno;
	}

	public int getDuracionMinutos() {
		return DuracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		DuracionMinutos = duracionMinutos;
	}

	public boolean isTendencias() {
		return tendencias;
	} // equivale a get

	public void setTendencias(boolean tendencias) {
		this.tendencias = tendencias;
	}

	// METODO CONSTRUCTOR

	public Contenido(String tituloContenido, String descripcion, int fechaEstreno, int duracionMinutos,
			boolean tendencias) {
		this.tituloContenido = tituloContenido;
		Descripcion = descripcion;
		FechaEstreno = fechaEstreno;
		DuracionMinutos = duracionMinutos;
		this.tendencias = tendencias;
	}
}