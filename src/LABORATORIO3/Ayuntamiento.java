package LABORATORIO3;

public class Ayuntamiento {

    private String PersonaContacto;
    private long TelefonoContacto;
    private double SubvencionMinimaPorCartel;

    // METODO CONSTRUCTOR
    public Ayuntamiento(String personaContacto, long telefonoContacto, double subvencionMinimaPorCartel) {
        PersonaContacto = personaContacto;
        TelefonoContacto = telefonoContacto;
        SubvencionMinimaPorCartel = subvencionMinimaPorCartel;
    }

    // GETTERS Y SETTERS
    public String getPersonaContacto() {
        return PersonaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        PersonaContacto = personaContacto;
    }

    public long getTelefonoContacto() {
        return TelefonoContacto;
    }

    public void setTelefonoContacto(Long telefonoContacto) {
        TelefonoContacto = telefonoContacto;
    }

    public double getSubvencionMinimaPorCartel() {
        return SubvencionMinimaPorCartel;
    }

    public void setSubvencionMinimaPorCartel(Double subvencionMinimaPorCartel) {
        SubvencionMinimaPorCartel = subvencionMinimaPorCartel;
    }

    @Override
    public String toString() {
        return "Ayuntamiento de Madrid: \n\tPersona de contacto: " + PersonaContacto + "\n\tTeléfono de contacto: "
                + TelefonoContacto
                + "\n\tSubvencion Mínima por cartel de pel�cula: " + SubvencionMinimaPorCartel + " euros";
    }

}