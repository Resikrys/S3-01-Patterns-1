package s3_01_abstract_factory;

public class AddressDataDTO {
    private String street;
    private String number;
    private String floor;
    private String portal;
    private String apartment;
    private String city;
    private String postalCode;
    private String zipCode;
    private String state;
    private String country;


    public AddressDataDTO(String street, String number, String floor, String portal, String apartment,
                          String city, String postalCode, String zipCode, String state, String country) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.portal = portal;
        this.apartment = apartment;
        this.city = city;
        this.postalCode = postalCode;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }


    public String getStreet() { return street; }
    public String getNumber() { return number; }
    public String getFloor() { return floor; }
    public String getPortal() { return portal; }
    public String getApartment() { return apartment; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getZipCode() { return zipCode; }
    public String getState() { return state; }
    public String getCountry() { return country; }


    @Override
    public String toString() {
        return "AddressDataDTO{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", floor='" + floor + '\'' +
                ", portal='" + portal + '\'' +
                ", apartment='" + apartment + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
