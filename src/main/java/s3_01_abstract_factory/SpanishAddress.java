package s3_01_abstract_factory;

public class SpanishAddress implements InternationalAddress {
    private String street;
    private String number;
    private String floor;
    private String portal;
    private String city;
    private String postalCode;
    private String country;

    public SpanishAddress(String street, String number, String floor, String portal, String city, String postalCode, String country) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.portal = portal;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getFloor() {
        return floor;
    }

    public String getPortal() {
        return portal;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String getFormattedAddress() {
        return "C/ " + getStreet() + ", " + getNumber() + " " + getFloor() + " " + getPortal() + ", "
                + getCity() + " (" + getPostalCode() + ") - " + getCountry();
    }

}
