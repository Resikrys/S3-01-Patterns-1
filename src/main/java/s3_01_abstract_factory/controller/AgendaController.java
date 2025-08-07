package s3_01_abstract_factory.controller;

import s3_01_abstract_factory.model.Agenda;
import s3_01_abstract_factory.model.Contact;
import s3_01_abstract_factory.model.dto.AddressDataDTO;
import s3_01_abstract_factory.model.dto.PhoneNumberDataDTO;
import s3_01_abstract_factory.model.factory.ContactFactory;
import s3_01_abstract_factory.model.factory.SpanishContactFactory;
import s3_01_abstract_factory.model.factory.USContactFactory;
import s3_01_abstract_factory.model.product.InternationalPhoneNumber;

import java.util.List;

public class AgendaController {
    private Agenda agenda;

    public AgendaController() {
        this.agenda = new Agenda();
    }

    public void run() {
        System.out.println("--- Agenda Manager ---");

        addSpanishContact("Calle Falsa", "123", "3", "A", "Barcelona", "08001", "Spain", "34", "600123456", InternationalPhoneNumber.Type.MOBILE);

        addUSContact("Elm Street", "13", "Apt 4B", "Springfield", "IL", "62704", "USA", "1", "5551234567", InternationalPhoneNumber.Type.FIXED);

        viewAllContacts();

        filterAndShowContacts("es");

        deleteContact(0);

        viewAllContacts();
    }

    private void addSpanishContact(String street, String number, String floor, String portal, String city, String postalCode, String country, String prefix, String phoneNumber, InternationalPhoneNumber.Type type) {
        AddressDataDTO addressData = new AddressDataDTO(street, number, floor, portal, null, city, postalCode, null, null, country);
        PhoneNumberDataDTO phoneData = new PhoneNumberDataDTO(prefix, phoneNumber, type);
        ContactFactory spanishFactory = new SpanishContactFactory();
        Contact newContact = agenda.addContact(spanishFactory, addressData, phoneData);
        System.out.println("✅ Spanish contact added: " + newContact.getAddress().getFormattedAddress());
    }

    private void addUSContact(String street, String number, String apartment, String city, String state, String zipCode, String country, String prefix, String phoneNumber, InternationalPhoneNumber.Type type) {
        AddressDataDTO addressData = new AddressDataDTO(street, number, null, null, apartment, city, null, zipCode, state, country);
        PhoneNumberDataDTO phoneData = new PhoneNumberDataDTO(prefix, phoneNumber, type);
        ContactFactory usFactory = new USContactFactory();
        Contact newContact = agenda.addContact(usFactory, addressData, phoneData);
        System.out.println("✅ American contact added: " + newContact.getAddress().getFormattedAddress());
    }

    private void viewAllContacts() {
        List<Contact> allContacts = agenda.viewAllContacts();
        System.out.println("\n--- All Contacts in Agenda ---");
        if (allContacts.isEmpty()) {
            System.out.println("Empty agenda.");
        } else {
            for (int i = 0; i < allContacts.size(); i++) {
                Contact contact = allContacts.get(i);
                System.out.println("Contact #" + (i + 1) + ":");
                System.out.println("  Address: " + contact.getAddress().getFormattedAddress());
                System.out.println("  Phone: " + contact.getPhoneNumber().getFormattedPhone());
            }
        }
    }

    private void filterAndShowContacts(String countryCode) {
        List<Contact> filteredContacts = agenda.filterContacts(countryCode);
        System.out.println("\n--- Contacts filtered by country: " + countryCode.toUpperCase() + " ---");
        if (filteredContacts.isEmpty()) {
            System.out.println("No contacts found for this country.");
        } else {
            for (Contact contact : filteredContacts) {
                System.out.println("  - " + contact.getAddress().getFormattedAddress() + " | " + contact.getPhoneNumber().getFormattedPhone());
            }
        }
    }

    private void deleteContact(int index) {
        Contact removedContact = agenda.deleteContact(index);
        if (removedContact != null) {
            System.out.println("\n🗑️ Contact deleted: " + removedContact.getAddress().getFormattedAddress());
        } else {
            System.out.println("\n❌ The contact could not be deleted. Invalid index.");
        }
    }
}
