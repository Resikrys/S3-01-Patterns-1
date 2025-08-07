package s3_01_abstract_factory;

public interface InternationalAddress {
    String getFormattedAddress();
    String getStreet();
    String getNumber();
    String getCity();
    String getPostalCode(); // Generic name -> US will return zipCode here
    String getCountry();
    String getCountryCode();
}
