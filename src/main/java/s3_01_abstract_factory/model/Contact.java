package s3_01_abstract_factory.model;

import s3_01_abstract_factory.model.product.InternationalAddress;
import s3_01_abstract_factory.model.product.InternationalPhoneNumber;

public class Contact {
    private InternationalAddress address;
    private InternationalPhoneNumber phoneNumber;

    public Contact(InternationalAddress address, InternationalPhoneNumber phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public InternationalAddress getAddress() {
        return address;
    }

    public InternationalPhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address=" + address.getFormattedAddress() +
                ", phoneNumber=" + phoneNumber.getFormattedPhone() +
                '}';
    }
}
