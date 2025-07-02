package s3_01_abstract_factory;

public class SpanishContactFactory implements ContactFactory {
    @Override
    public InternationalAddress createAddress(AddressDataDTO data) {
        return new SpanishAddress(
                data.getStreet(),
                data.getNumber(),
                data.getFloor(),
                data.getPortal(),
                data.getCity(),
                data.getPostalCode(),
                data.getCountry()
        );
    }

    @Override
    public InternationalPhoneNumber createPhoneNumber(PhoneNumberDataDTO data) {
        return new SpanishPhoneNumber(
                data.getPrefix(),
                data.getPhoneNumber(),
                data.getType()
        );
    }
}
