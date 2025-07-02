package s3_01_abstract_factory;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<InternationalAddress> addresses;
    private List<InternationalPhoneNumber> phoneNumbers;

    public Agenda() {
        this.addresses = new ArrayList<>();
        this.phoneNumbers = new ArrayList<>();
    }

    public void addContact(
            ContactFactory factory,
            String street, int number, String floor, String portal, String city, String postalCode, String country,
            int prefix, int phoneNumber, InternationalPhoneNumber.Type type
    ) {
        // Now we pass all the required parameters to the factory methods
        InternationalAddress address = factory.createAddress(street, number, floor, portal, city, postalCode, country);
        InternationalPhoneNumber phoneNum = factory.createPhoneNumber(prefix, phoneNumber, type);

        this.addresses.add(address);
        this.phoneNumbers.add(phoneNum); // Store them as a pair or in separate lists as you have it
        System.out.println("--- Contacto Añadido ---");
        System.out.println("Dirección: " + address.getFormattedAddress());
        System.out.println("Teléfono: " + phoneNum.getFormattedPhone());
        System.out.println("------------------------");
    }

    // ... otros métodos de la agenda
}
