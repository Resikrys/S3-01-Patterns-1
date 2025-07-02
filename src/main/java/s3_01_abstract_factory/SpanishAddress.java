package s3_01_abstract_factory;

public class SpanishAddress implements InternationalAddress {
    private String street;
    private int number;
    private int floor;
    private int portal;
    private String city;
    private String postalCode;
    private String country;

    public SpanishAddress(String street, int number, int floor, int portal, String city, String postalCode, String country) {
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

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public int getPortal() {
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
