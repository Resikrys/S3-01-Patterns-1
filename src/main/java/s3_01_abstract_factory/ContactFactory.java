package s3_01_abstract_factory;

public interface ContactFactory {
    InternationalAddress createAddress(String street, int number, int floor, int portal, String city, String postalCode, String country);
    InternationalPhoneNumber createPhoneNumber(int prefix, int number, InternationalPhoneNumber.Type type);
}
