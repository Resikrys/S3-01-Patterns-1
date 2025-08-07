package s3_01_abstract_factory.model.product;

public interface InternationalAddress {
    String getFormattedAddress();
    String getStreet();
    String getNumber();
    String getCity();
    String getPostalCode(); // Generic name -> US will return zipCode here
    String getCountry();
    String getCountryCode();
}
