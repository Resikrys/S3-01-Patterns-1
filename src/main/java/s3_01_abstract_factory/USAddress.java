package s3_01_abstract_factory;

public class USAddress implements InternationalAddress {
    private String street;
    private int number;
    private int floor;
    private int portal;
    private String city;
    private String zipCode;
    private String country;

    public USAddress(String street, int number, int floor, int portal, String city, String zipCode, String country) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.portal = portal;
        this.city = city;
        this.zipCode = zipCode;
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

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String getFormattedAddress() {
        return "St/ " + getStreet() + ", " + getNumber() + " " + getFloor() + " " + getPortal() + ", " + getCity() + " (" + getZipCode() + ") - " + getCountry();
    }
    // ...
}
