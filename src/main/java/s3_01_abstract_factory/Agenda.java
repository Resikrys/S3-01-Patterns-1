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

    // Método para añadir un contacto utilizando la fábrica
    public void addContact(ContactFactory factory, /* parámetros para construir la dirección y el teléfono */) {
        InternationalAddress address = factory.createAddress(/* ... */);
        InternationalPhoneNumber phoneNumber = factory.createPhoneNumber(/* ... */);

        // Aquí podrías configurar los atributos del address y phoneNumber
        // address.setStreet("...");
        // phoneNumber.setPrefix("...");

        this.addresses.add(address);
        this.phoneNumbers.add(phoneNumber);
        System.out.println("Contacto añadido: " + address.getFormattedAddress() + ", " + phoneNumber.getFormattedNumber());
    }

    // ... otros métodos de la agenda
}
