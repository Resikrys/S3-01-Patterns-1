package s3_01_abstract_factory;

public class USContactFactory implements ContactFactory {
    @Override
    public InternationalAddress createAddress(AddressDataDTO data) {
        return new USAddress(
                data.getStreet(),
                data.getNumber(),
                data.getApartment(), // Usamos apartment para EE. UU.
                data.getCity(),
                data.getState(),     // ¡Usamos state para EE. UU.!
                data.getZipCode(),   // Usamos zipCode para EE. UU.
                data.getCountry()
        );
    }

    @Override
    public InternationalPhoneNumber createPhoneNumber(PhoneNumberDataDTO data) {
        return new USPhoneNumber(
                data.getPrefix(),
                data.getPhoneNumber(),
                data.getType()
        );
    }
}
