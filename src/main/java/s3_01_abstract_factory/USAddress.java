package s3_01_abstract_factory;

public class USAddress implements InternationalAddress {
    private String street;
    private String number;
    private String floor;
    private String portal;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public USAddress(String street, String number, String floor, String portal, String city, String state, String zipCode, String country) {
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

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String getFormattedAddress() {
        return "St/ " + getStreet() + ", " + getNumber() + " " + getFloor() + " " + getPortal() + ", "
                + getCity() + getState() +  " (" + getZipCode() + ") - " + getCountry();
    }

}
