package LABORATORIO3;

public class Promocion {

    private Long idPromocion;
    private Contenido Contenido;
    private boolean PromoRRSS;
    private boolean PromoPdelSol;

    // METODO CONSTRUCTOR
    public Promocion(Long idPromocion, Contenido Contenido, boolean promoRRSS, boolean promoPdelSol) {
        this.idPromocion = idPromocion;
        this.Contenido = Contenido;
        PromoRRSS = promoRRSS;
        PromoPdelSol = promoPdelSol;
    }

    // GETTERS Y SETTERS
    public Long getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Long idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Contenido getContenido() {
        return Contenido;
    }

    public void setContenido(Contenido contenido) {
        Contenido = contenido;
    }

    public boolean isPromoRRSS() {
        return PromoRRSS;
    }

    public void setPromoRRSS(boolean promoRRSS) {
        PromoRRSS = promoRRSS;
    }

    public boolean isPromoPdelSol() {
        return PromoPdelSol;
    }

    public void setPromoPdelSol(boolean promoPdelSol) {
        PromoPdelSol = promoPdelSol;
    }

    @Override
    public String toString() { // idPromocion+1 porque no queda coherente que sea promocion cero. La primera
                               // promocion la ponemos como promocion 1 y asi.

        String PromoRRSS = (isPromoRRSS()) ? "Si" : "No"; // Con esto (equivale a un if-else en una línea) sustituimos
                                                          // el true, false por un sí o no
        String PromoPdelSol = (isPromoPdelSol()) ? "Si" : "No";
        return "\n\t\t - - Promoción número " + (idPromocion + 1) + " (ID " + idPromocion + ")  - - \n" + Contenido
                + "\n	Promoción a través de Redes Sociales? " + PromoRRSS
                + "\n	Promoción a través de un cartel en la Puerta del Sol? " + PromoPdelSol + "\n";// getClass(): " +
                                                                                                      // getClass() +
                                                                                                      // "\n hashCode():
                                                                                                      // " + hashCode()
        // + "\n toString(): " + super.toString() + "]";
    }
}