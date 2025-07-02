package s3_01_abstract_factory;

public class USAddress implements InternationalAddress {
    private String street;
    private String number;
    private String apartment;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public USAddress(String street, String number, String apartment, String city, String state, String zipCode, String country) {
        this.street = street;
        this.number = number;
        this.apartment = apartment;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public String getApartment() {
        return apartment;
    }

    @Override
    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getFormattedAddress() {
        return "St/ " + getStreet() + ", " + getNumber() + " " + getApartment() + ", "
                + getCity() + getState() +  " (" + getZipCode() + ") - " + getCountry();
    }

}
