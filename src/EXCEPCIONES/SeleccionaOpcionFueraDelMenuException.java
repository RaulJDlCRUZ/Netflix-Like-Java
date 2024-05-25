package EXCEPCIONES;

public class SeleccionaOpcionFueraDelMenuException extends Exception {

	public SeleccionaOpcionFueraDelMenuException(String mensajeerror) {
		super(mensajeerror); // HEREDA, DE AHI EL SUPER
	}
}