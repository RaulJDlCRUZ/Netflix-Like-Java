package LABORATORIO3;

public class EmpresaMarketing {

    private String NombreEmpresa;
    private Long TelefonoEmpresa;
    private Double PrecioCampaña;

    // CONSTRUCTOR
    public EmpresaMarketing(String nombreEmpresa, Long telefonoEmpresa, Double precioCampaña) {
        NombreEmpresa = nombreEmpresa;
        TelefonoEmpresa = telefonoEmpresa;
        PrecioCampaña = precioCampaña;
    }

    // GETTERS Y SETTERS
    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        NombreEmpresa = nombreEmpresa;
    }

    public Long getTelefonoEmpresa() {
        return TelefonoEmpresa;
    }

    public void setTelefonoEmpresa(Long telefonoEmpresa) {
        TelefonoEmpresa = telefonoEmpresa;
    }

    public Double getPrecioCampaña() {
        return PrecioCampaña;
    }

    public void setPrecioCampaña(Double precioCampaña) {
        PrecioCampaña = precioCampaña;
    }

}