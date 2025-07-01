package s3_01_abstract_factory;

public class USAddress implements InternationalAddress {
    // Implementación de atributos y métodos para direcciones españolas
    // Por ejemplo: calle, numero, piso, puerta, ciudad, codigoPostal, pais
    @Override
    public String getFormattedAddress() {
        return "C/ " + getStreet() + ", " + getNumber() + " " + getFloor() + " " + getPortal() + ", " + getCity() + " (" + getPostalCode() + ") - " + getCountry();
    }
    // ...
}
