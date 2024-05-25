/*
 * EN LA CLASE NETFLIX SE HARAN TODAS LAS OPERACIONES, ES EL NUCLEO DEL PROGRAMA
 * */

package LABORATORIO3;

import java.util.*; //el asterisco simboliza que importamos todo el contenido de ese package. Pese a que no se usen muchos, se hace por comodidad
import EXCEPCIONES.*; //de la misma manera, import todas las excepciones

public class Netflix implements UTILS.Constantes, UTILS.SolucionesAExc { // AÑADIMOS UTILS.CONSTANTES PORQUE USAREMOS
																			// ALGUNAS CONSTANTES PARA CALCULAR EL
																			// PRECIO DE UNA PROMOCION, ASI COMO ALGUNA
																			// SOLUCION PARA AYUDAR AL USUARIO EN CASO
																			// DE ESCRIBIR POR TECLADO UNA ENTRADA NO
																			// ADMITIDA
	private Scanner leer = new Scanner(System.in);
	// para verdadero falso usaremos escáneres estáticos, además de varios métodos
	// para filtrar las opciones booleanas

	// Alternativa a array convencionales []: SERÁN MÁS ÚTILES PARA AÑADIR ELEMENTOS
	// A POSTERIORI.
	private List<Contenido> contenidos = new ArrayList<Contenido>();
	private List<Promocion> promociones = new ArrayList<Promocion>();
	Promocion Promocion; // instanciamos promocion

	// METODO CONSTRUCTOR - NO LO NECESITO / ESTÁ VACÍO
	public Netflix() {
	}

	public void agregarContenido(Contenido contenido) {
		// ESTE METODO SE COMUNICA CON CONTENIDO; TRAE LOS CONTENIDOS DE LA CLASE
		// CONTENIDO A AQUI, Y LOS AGREGA AL ARRAY LIST
		contenidos.add(contenido);
	}

	// MENU 1 - System.out del array contenido
	public void MostrarContenido() {
		for (Contenido c : contenidos)
			System.out.println(c.toString());
	}

	// MENU 2 - Crear una Promocion de un Contenido
	public void CrearPromocion() {
		Contenido contenido = null; // instanciar
		System.out.println("¿Qué contenido de Netflix quieres promocionar?");
		String s = leer.nextLine();
		try {
			contenido = tituloExisteEnContenido(s); // metodo que lance o implemente la excepcion
			boolean promocionRedesSociales = false;
			boolean promocionCartelPdelSol = false; // las dos variables locales de tipo booleanas las inicializamos en
													// falsas, luego con las preguntas lo cambiamos...
			System.out.println("Se promocionará a traves de Redes Sociales. (s/n)");
			promocionRedesSociales = LecturaVF(leer.nextLine().toLowerCase()); // compruebo si lo que he introducido por
																				// teclado es valido

			System.out.println("Se promocionará en el cartel en la Puerta del Sol. (s/n)");
			promocionCartelPdelSol = LecturaVF(leer.nextLine().toLowerCase());

			long l = (promociones.size()); // ES UNICO POR CONTENIDO
			Promocion P = new Promocion(l, contenido, promocionRedesSociales, promocionCartelPdelSol);
			if (P.getContenido() instanceof Serie)
				promocionseriemayoradocemileuros(P);
			System.out.println("¡Promoción creada satisfactoriamente!");
			promociones.add(P);

		} catch (ContenidoNoEncontradoException excepcion) {
			System.out.println(excepcion.getMessage());
		} catch (PromocionSerieMayorADoceKException exc) {
			System.out.println(exc.getMessage());

		}
	}

	// -E- METODO PARA LA EXCEPCION DE ENCONTRAR EL CONTENIDO
	private Contenido tituloExisteEnContenido(String titulo) throws ContenidoNoEncontradoException {
		Contenido contenido = null;
		for (Contenido c : contenidos) {
			if (c.getTituloContenido().toLowerCase().equals(titulo.toLowerCase())) {
				contenido = c;
			}
		}
		if (contenido == null) {
			System.err.println("ERROR 05. ESTÁS INTENTANDO LOCALIZAR UN CONTENIDO QUE NO SE ENCUENTRA EN NETFLIX");
			throw new ContenidoNoEncontradoException("- - -Solución Recomendada - - - \n " + E5);
		}
		return contenido;
	}

	// -E- LA PROMOCION ASCIENDE DE DOCE MIL EUROS?
	private void promocionseriemayoradocemileuros(Promocion p) throws PromocionSerieMayorADoceKException {
		if (CalculoUNAPromocion(p) > LimitePresupuestarioSerie) {
			System.err.println("ERROR 04. SE HA INTENTADO PROMOCIONAR UNA SERIE EXCEDIENDO EL LÍMITE PRESUPUESTARIO DE "
					+ LimitePresupuestarioSerie + " euros.");
			throw new PromocionSerieMayorADoceKException("- - -Solución Recomendada - - - \n " + E4);
		}
	}

	// MENU 3 - Muestra todas las promociones realizadas
	public void MostrarTodasPromociones() {
		for (Promocion p : promociones)
			System.out.println(p.toString());
	}

	// MENU 4 - Calcula el coste total de las Promociones Realizadas
	public double CalcularPrecioPromocionesRealizadas() {
		// Sumatorio de todas las promociones de todo el contenido
		double costetotalpromociones = 0;
		for (int i = 0; i < promociones.size(); i++) {
			costetotalpromociones += CalculoUNAPromocion(promociones.get(i)); // .get es acceder a un elemento de la
																				// lista. ASÍ EJECUTO EL MÉTODO SEGÚN EL
																				// TOTAL DE CONTENIDOS, Y EL DOUBLE QUE
																				// ME DEVUELVE LO VOY SUMANDO
		}
		System.out.println(
				"El coste total de todas las promociones realizadas es de " + costetotalpromociones + " euros.");
		return costetotalpromociones;
	}

	// MENU 5 - Calculo el coste de Promocion de un Contenido en particular. Primero
	// pido la promocion para ver si existe... y si es asi, la calculo
	public void PedirPromocion() {
		Promocion promocion = null;
		System.out.println(
				"Para calcular una promoción en concreto, introduce el ID de la promoción correspondiente. \nEsto se realiza para evitar reduncdancias, pues"
						+ "es posible hacer distintas promociones de un mismo contenido. \nEn caso de no conocer la "
						+ "ID de su promoción, vuelva al menú y seleccione la opción número 3 para visualizar toda la información relacionada con la promoción. \n");
		try {
			long l = LongsInsteadOfString();
			promocion = nombreAsociadoEnPromocion(l);
			for (Promocion p : promociones) { // VA A SER MÁS COMODO PEDIR UNICAMENTE EL ID DE LA PROMOCION, SIEMPRE ES
												// ÚNICO
				if (p.getIdPromocion().equals(l)) {
					System.out.println("La promoción resultará en unos " + CalculoUNAPromocion(p) + " euros.");
				}
			}
		} catch (PromocionNoExisteException excepcion) {
			System.out.println(excepcion.getMessage());
		}
	}

	// -E- COMPROBAMOS MEDIANTE UNA EXCEPCION SI LA PROMOCION EXISTE
	private Promocion nombreAsociadoEnPromocion(long L) throws PromocionNoExisteException {
		Promocion promocion = null;
		for (Promocion p : promociones) {
			if (p.getIdPromocion().equals(L)) {
				promocion = p;
			}
		}
		if (promocion == null) {
			System.err.println("ERROR 06. HAS INTENTADO CALCULAR EL PRECIO DE UNA PROMOCION QUE NO EXISTE");
			throw new PromocionNoExisteException("- - -Solución Recomendada - - - \n" + E6);
		}
		return promocion;
	}

	// Calculo o algoritmo del MENU 5, una promocion individual
	public double CalculoUNAPromocion(Promocion promociones) {
		double valorpromocion = 0;
		if (promociones.getContenido() instanceof Pelicula) {

			// la palabra clave "instanceof" esta pensada para determinar de que tipo es un
			// objeto. Lo usamos para distinguir de serie o pelicula

			if (promociones.isPromoRRSS())
				valorpromocion += RRSS_PELICULAS;
			if (promociones.isPromoPdelSol())
				valorpromocion += PUERTADELSOL_PELICULAS;
			if (promociones.getContenido().isTendencias())
				valorpromocion += valorpromocion * IMPUESTO_TRENDY_PELICULAS;
		}
		if (promociones.getContenido() instanceof Serie) {

			/*
			 * el caso de las series es distinto. para una pelicula solo depende de su
			 * popularidad (trendy) y de como queremos hacer la campaña.
			 * Con series es distinto. La promocion depende del numero de capitulos de una
			 * serie y del numero de temporadas. Tendremos que crear una serie
			 * que se relacione con la clase "Serie", para poder poner las variables
			 * necesarias.
			 * Para ello, creo un objeto SERIE de tipo Serie, utilizando la lista
			 * promociones para llegar a Contenido, tal y como lo hemos hecho
			 * con las variables booleanas de pelicula.
			 */

			Serie SERIE = (Serie) promociones.getContenido();
			if (promociones.isPromoRRSS())
				valorpromocion += RRSS_SERIES * (SERIE.getNumTemporadas());
			if (promociones.isPromoPdelSol())
				valorpromocion += PUERTADELSOL_SERIES * (SERIE.getNumCapitulos());
			if (promociones.getContenido().isTendencias())
				valorpromocion += valorpromocion * IMPUESTO_TRENDY_SERIES;
		}
		return valorpromocion;
	}

	// MENU 6
	public void CalcularCampañaMasiva() {
		int numpelispromocionar = 0;
		EmpresaMarketing empresa = new EmpresaMarketing("Campañas Castilla", (long) 806526526, CostoCampaignMarketing);
		for (Contenido c : contenidos)
			if (c instanceof Pelicula) { // para cada contenido, si es una peli...?
				numpelispromocionar++;

			}
		double masivecampaign = empresa.getPrecioCampaña() * numpelispromocionar;
		System.out.println("La campañaa masiva va a costar un total de " + masivecampaign
				+ " euros. \nLa empresa de marketing responsable es " + empresa.getNombreEmpresa() + " con teléfono "
				+ empresa.getTelefonoEmpresa());

		// hay x pelis, y si por cada peli la empresa de marketing tiene un precio fijo,
		// es un producto

	}

	// MENU 7
	public void PedirSubvenciones() {
		System.out.println("Calculamos las subvenciones de... \n 1. Películas \n 2. Series"); // es booleano, implemento
																								// metodo de filtrado en
																								// Lectura12 y
																								// LongInsteadofString
		boolean booleano = false;
		int opcM7 = (int) LongsInsteadOfString();
		booleano = Lectura12(opcM7);
		if (booleano == true)
			SubvencionesPeliculas();
		else
			SubvencionesSeries();
	}

	// 7.1 PELIS
	public double SubvencionesPeliculas() {
		Ayuntamiento ayuntamiento = new Ayuntamiento("Joaquín Sánchez Rodríguez", (long) 925808080, (int) PTn);
		double subvencionesp = 0;
		for (Promocion p : promociones) {
			if (p.getContenido() instanceof Pelicula) {
				if (p.isPromoPdelSol() == false)
					subvencionesp += 0;
				else {
					if (p.getContenido().isTendencias())
						subvencionesp += PT;
					else
						subvencionesp += ayuntamiento.getSubvencionMinimaPorCartel();
				} // 750
			}
		}
		System.out.println("La subvención que recibimos en base a las películas por parte del Ayuntamiento es de "
				+ subvencionesp + " euros \n" + ayuntamiento.toString());
		return 0;
	}

	// 7.2 SERIES
	public double SubvencionesSeries() {
		Ayuntamiento ayuntamiento = new Ayuntamiento("Borja Iglesias Quintás", (long) 925808182, (int) PTn);
		double subvencioness = 0;
		for (Promocion p : promociones) {
			if (p.getContenido() instanceof Serie) {
				if (p.isPromoPdelSol() == false)
					subvencioness += 0;
				else {
					if (p.getContenido().isTendencias())
						subvencioness += ST;
					else
						subvencioness += STn;
				}
			}
		}
		System.out.println("La subvención que recibimos en base a las series por parte del Ayuntamiento es de "
				+ subvencioness + " euros \n" + ayuntamiento.toString());
		return 0;
	}

	public boolean LecturaVF(String string) { // SÍ O NO?
		boolean b = false;
		boolean salirciclo = false;
		do {
			if (string.toLowerCase().equals("s")) {
				b = true;
				salirciclo = true;
			} else if (string.toLowerCase().equals("n")) {
				b = false;
				salirciclo = true;
			} else {
				System.out.println(
						"El valor introducido por teclado no es válido, inténtelo de nuevo. \nLas opciones válidas son s y n: ");
				string = leer.nextLine();
				LecturaVF(string); // RECURSIVIDAD (BUCLE) HASTA QUE SALGA UN DATO PERMITIDO
			}
		} while (!salirciclo); // NOT SALIR DEL CICLO
		return b;
	}

	public boolean Lectura12(int i) { // UNO O DOS?
		boolean b = false;
		boolean salirciclo = false;
		do {
			if (i == 1) {
				b = true;
				salirciclo = true;
			} else if (i == 2) {
				b = false;
				salirciclo = true;
			} else {
				System.out.println(
						"El valor introducido por teclado no es válido, inténtelo de nuevo. \nLas opciones válidas son 1 y 2: ");
				i = (int) LongsInsteadOfString();
				Lectura12(i);
			}
		} while (!salirciclo);
		return b;
	}

	public static long LongsInsteadOfString() {
		Scanner filtrado = new Scanner(System.in);
		long longo = 0;
		try {
			longo = filtrado.nextLong();
		} catch (InputMismatchException e) {
			System.err.println("ERROR 07. HAS INTRODUCIDO POR TECLADO UN VALOR NO NUMÉRICO EN UNA SOLICITUD NUMÉRICA");
			System.out.println(" - - - Solución Recomendada - - - \n" + E7);
			longo = LongsInsteadOfString();
		}
		return longo;
	}
}// end of class