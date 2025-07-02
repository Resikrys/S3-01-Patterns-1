package s3_01_abstract_factory;

public class SpanishContactFactory implements ContactFactory {
    @Override
    public InternationalAddress createAddress(String street, int number, int floor, int portal, String city, String postalCode, String country) {
        return new SpanishAddress(street, number, floor, portal, city, postalCode, country);
    }

    @Override
    public InternationalPhoneNumber createPhoneNumber(int prefix, int number, InternationalPhoneNumber.Type type) {
        return new SpanishPhoneNumber(prefix, number, type); // Idem
    }
}
