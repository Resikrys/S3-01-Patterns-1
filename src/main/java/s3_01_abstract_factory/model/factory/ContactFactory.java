package s3_01_abstract_factory.model.factory;

import s3_01_abstract_factory.model.product.InternationalAddress;
import s3_01_abstract_factory.model.product.InternationalPhoneNumber;
import s3_01_abstract_factory.model.dto.AddressDataDTO;
import s3_01_abstract_factory.model.dto.PhoneNumberDataDTO;

public interface ContactFactory {
    InternationalAddress createAddress(AddressDataDTO data);
    InternationalPhoneNumber createPhoneNumber(PhoneNumberDataDTO data);
}
