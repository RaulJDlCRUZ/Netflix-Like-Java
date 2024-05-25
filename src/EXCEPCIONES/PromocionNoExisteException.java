package EXCEPCIONES;

public class PromocionNoExisteException extends Exception {

	public PromocionNoExisteException(String mensajeerror) {
		super(mensajeerror); // HEREDA, DE AHI EL SUPER
	}
}