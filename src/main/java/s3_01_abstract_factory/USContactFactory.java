package s3_01_abstract_factory;

public class USContactFactory implements ContactFactory {
    @Override
    public InternationalAddress createAddress(String street, String number, String floor, String portal, String city, String zipCode, String country) {
        return new USAddress(street, number, floor, portal, city, zipCode, country);
    }

    @Override
    public InternationalPhoneNumber createPhoneNumber(String prefix, String number, InternationalPhoneNumber.Type type) {
        return new USPhoneNumber(prefix, number, type);
    }
}
