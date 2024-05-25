/*MENU SEGUN REQUISITOS:

5. Se desea que el sistema permita realizar las siguientes consultas:

a. Mostrar toda la información del contenido de la plataforma (se proporcionará al alumno un fichero con la información del contenido).
b. Se podrá realizar una promoción de una película o una serie.
c. Mostrar todas las promociones realizadas.
d. Mostrar coste de todas las promociones realizadas.
e. Calcular coste de promoción de una película o serie en concreto.
f. Calcular el coste de una campaña masiva de marketing.
g. Calcular la subvención que se obtiene a partir de las películas o series

*/
package LABORATORIO3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import EXCEPCIONES.SeleccionaOpcionFueraDelMenuException;

public class Principal implements UTILS.SolucionesAExc {
	static Netflix netflix = new Netflix(); // creo un netflix porque este contenido lo guardo ahi. por ejemplo, al
											// crear al contenido

	public static void main(String[] args)
			throws IOException, InputMismatchException, SeleccionaOpcionFueraDelMenuException {
		leerFichero2("Contenido.csv");
		menu();

	}

	public static void menu() {
		Scanner leer = new Scanner(System.in);
		boolean salir = false;

		do {
			System.out.println("\n  ================ Seleccione una opción: " + "=================================== ");
			System.out.println("||1. Catálogo de series y películas de Netflix.\n"
					+ "||2. Realizar una promoción de una película o una serie.\n"
					+ "||3. Mostrar todas las promociones realizadas.\n"
					+ "||4. Mostrar coste de todas las promociones realizadas.\n"
					+ "||5. Calcular coste de promoción de una película o serie en concreto.\n"
					+ "||6. Calcular el coste de una campaña masiva de marketing.\n"
					+ "||7. Calcular la subvención que se obtiene a partir de las películas o series. \n"
					+ "||8. Salir. ");

			try {
				int menu = RecibeDatosEnRango(leer.nextInt());
				switch (menu) {

					case 1:
						netflix.MostrarContenido();
						break;

					case 2:
						netflix.CrearPromocion();
						break;

					case 3:
						netflix.MostrarTodasPromociones();
						break;

					case 4:
						netflix.CalcularPrecioPromocionesRealizadas();
						break;

					case 5:
						netflix.PedirPromocion();
						break;

					case 6:
						netflix.CalcularCampañaMasiva();
						break;

					case 7:
						netflix.PedirSubvenciones();
						break;

					case 8:
						salir = true;
						break;
				}// Fin del switch
			} catch (InputMismatchException exc) { // excepcion propia de java que detecta entradas por teclado de
													// distinto tipo (Input Mismatch) EJ: LETRA EN VEZ DE NUMERO
				System.err.println("ERROR 03. HAS INTRODUCIDO POR TECLADO UN VALOR NO NUMÉRICO EN UN MENÚ NUMÉRICO");
				System.out.println(" - - - Solución Recomendada - - - \n" + E3);
				leer.nextLine();
			} catch (SeleccionaOpcionFueraDelMenuException excepcion) {
				System.out.println(excepcion.getMessage());
			}
		} while (salir == false);

	}

	private static void leerFichero2(String fichero) throws IOException {
		String titulo, descripcion, tipoContenido, productora, pais;
		int año, duracion, nTemporadas, nCapitulos;
		boolean tendencia;
		String line;
		Contenido contenido; // Instanciar
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			while ((line = br.readLine()) != null) {
				String[] split = line.split(";");
				tipoContenido = split[0];
				titulo = split[1];
				año = Integer.valueOf(split[2]);
				duracion = Integer.valueOf(split[3]);
				descripcion = split[4];
				tendencia = Boolean.valueOf(split[5]);

				// Informacion de una Serie
				if (tipoContenido.charAt(0) == 's') {
					nTemporadas = Integer.valueOf(split[6]);
					nCapitulos = Integer.valueOf(split[7]);
					contenido = new Serie(titulo, descripcion, año, duracion, tendencia, nTemporadas, nCapitulos);
					netflix.agregarContenido(contenido); // con un metodo de la clase netflix, agrego contenido, tanto
															// series como peliculas

					/*
					 * NO HACEMOS EL CONTENIDOS.ADD(CONTENIDO) AQUI PORQUE LA LISTA DE CONTENIDOS
					 * ESTA EN NETFLIX, NO AQUI
					 */
				}
				// Informacion de una Pelicula
				else {
					productora = split[6];
					pais = split[7];
					contenido = new Pelicula(titulo, descripcion, año, duracion, tendencia, productora, pais);
					netflix.agregarContenido(contenido);
				}
			}
		} catch (IOException e) {
			System.err.println("ERROR 01. NO SE PUEDE INICIALIZAR EL PROGRAMA PORQUE NO SE ENCUENTRA EL FICHERO "
					+ fichero + ". MAS DETALLES A CONTINUACION: \n");
			e.printStackTrace();
			System.out.println(" - - - Solución Recomendada - - - \n" + E1);
			System.exit(-1); // codigo de salida erroneo, cierra el programa con problemas (no hay fichero)
		}
	}

	// METODO PARA LA EXCEPCION DE RECIBIR UN NÚMERO QUE NO ESTÁ DENTRO DEL MENÚ
	private static int RecibeDatosEnRango(int a) throws SeleccionaOpcionFueraDelMenuException {
		int opc = a;
		if (opc < 1 || opc > 8) {
			System.err.println("ERROR 02. ESTÁS INTENTANDO COLOCAR UN NÚMERO QUE SE ENCUENTRA FUERA DE RANGO DEL MENÚ");
			throw new SeleccionaOpcionFueraDelMenuException("- - -Solución Recomendada - - - \n " + E2);
		} else
			return opc;
	}
}
