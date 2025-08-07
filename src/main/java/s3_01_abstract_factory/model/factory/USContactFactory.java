package s3_01_abstract_factory.model.factory;

import s3_01_abstract_factory.model.product.InternationalAddress;
import s3_01_abstract_factory.model.product.InternationalPhoneNumber;
import s3_01_abstract_factory.model.product.USAddress;
import s3_01_abstract_factory.model.product.USPhoneNumber;
import s3_01_abstract_factory.model.dto.AddressDataDTO;
import s3_01_abstract_factory.model.dto.PhoneNumberDataDTO;

public class USContactFactory implements ContactFactory {
    @Override
    public InternationalAddress createAddress(AddressDataDTO data) {
        return new USAddress(
                data.getStreet(),
                data.getNumber(),
                data.getApartment(),
                data.getCity(),
                data.getState(),
                data.getZipCode(),
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
