package s3_01_abstract_factory;

public class USContactFactory implements ContactFactory {
    @Override
    public InternationalAddress createAddress(String street, int number, int floor, int portal, String city, String zipCode, String country) {
        return new USAddress(street, number, floor, portal, city, zipCode, country);
    }

    @Override
    public InternationalPhoneNumber createPhoneNumber(int prefix, int number, InternationalPhoneNumber.Type type) {
        return new USPhoneNumber(prefix, number, type); // Idem
    }
}
