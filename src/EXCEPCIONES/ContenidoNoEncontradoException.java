package EXCEPCIONES;

public class ContenidoNoEncontradoException extends Exception {

	public ContenidoNoEncontradoException(String mensajeerror) {
		super(mensajeerror); // HEREDA, DE AHI EL SUPER
	}
}