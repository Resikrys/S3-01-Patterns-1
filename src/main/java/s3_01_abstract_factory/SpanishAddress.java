package s3_01_abstract_factory;

public class SpanishAddress implements InternationalAddress {
    private String calle;
    private int numero;
    private int piso;
    private int puerta;
    private String ciudad;
    private int codigoPostal;
    private String pais;

    public SpanishAddress(String calle, int numero, int piso, int puerta, String ciudad, int codigoPostal, String pais) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.puerta  = puerta;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public int getPuerta() {
        return puerta;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String getFormattedAddress() {
        return "C/ " + getCalle() + ", " + getNumero() + " " + getPiso() + " " + getPuerta() + ", "
                + getCiudad() + " (" + getCodigoPostal() + ") - " + getPais();
    }
    // ...
}
