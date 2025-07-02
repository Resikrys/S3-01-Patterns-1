package s3_01_abstract_factory;

public interface ContactFactory {
    InternationalAddress createAddress(String street, String number, String floor, String portal, String city, String postalCode, String country);
    InternationalPhoneNumber createPhoneNumber(String prefix, String number, InternationalPhoneNumber.Type type);
}
