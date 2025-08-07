package s3_01_abstract_factory.model;

import s3_01_abstract_factory.model.dto.AddressDataDTO;
import s3_01_abstract_factory.model.dto.PhoneNumberDataDTO;
import s3_01_abstract_factory.model.factory.ContactFactory;
import s3_01_abstract_factory.model.product.InternationalAddress;
import s3_01_abstract_factory.model.product.InternationalPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contact> contacts;

    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    public Contact addContact(ContactFactory factory, AddressDataDTO addressData, PhoneNumberDataDTO phoneData) {
        InternationalAddress address = factory.createAddress(addressData);
        InternationalPhoneNumber phoneNumber = factory.createPhoneNumber(phoneData);

        Contact newContact = new Contact(address, phoneNumber);
        this.contacts.add(newContact);

        return newContact;
    }

    public List<Contact> viewAllContacts() {
        return new ArrayList<>(this.contacts);
    }


    public Contact deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            return contacts.remove(index);
        }
        return null;
    }

    public List<Contact> filterContacts(String countryCode) {
        List<Contact> filteredContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getAddress().getCountryCode().equalsIgnoreCase(countryCode)) {
                filteredContacts.add(contact);
            }
        }
        return filteredContacts;
    }

}
