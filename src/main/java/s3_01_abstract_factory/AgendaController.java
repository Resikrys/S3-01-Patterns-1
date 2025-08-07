package s3_01_abstract_factory;

import java.util.List;

public class AgendaController {
    private Agenda agenda;

    public AgendaController() {
        this.agenda = new Agenda();
    }

    public void run() {
        System.out.println("--- Agenda Manager ---");

        // Ejemplo de uso:
        // Añadir contacto español
        addSpanishContact("Calle Falsa", "123", "3", "A", "Barcelona", "08001", "Spain", "34", "600123456", InternationalPhoneNumber.Type.MOBILE);

        // Añadir contacto americano
        addUSContact("Elm Street", "13", "Apt 4B", "Springfield", "IL", "62704", "USA", "1", "5551234567", InternationalPhoneNumber.Type.FIXED);

        // Mostrar todos los contactos
        viewAllContacts();

        // Filtrar y mostrar contactos españoles
        filterAndShowContacts("es");

        // Eliminar un contacto
        deleteContact(0); // Elimina el primer contacto

        // Ver agenda después de eliminar
        viewAllContacts();
    }

    private void addSpanishContact(String street, String number, String floor, String portal, String city, String postalCode, String country, String prefix, String phoneNumber, InternationalPhoneNumber.Type type) {
        AddressDataDTO addressData = new AddressDataDTO(street, number, floor, portal, null, city, postalCode, null, null, country);
        PhoneNumberDataDTO phoneData = new PhoneNumberDataDTO(prefix, phoneNumber, type);
        ContactFactory spanishFactory = new SpanishContactFactory();
        Contact newContact = agenda.addContact(spanishFactory, addressData, phoneData);
        System.out.println("✅ Contacto español añadido: " + newContact.getAddress().getFormattedAddress());
    }

    private void addUSContact(String street, String number, String apartment, String city, String state, String zipCode, String country, String prefix, String phoneNumber, InternationalPhoneNumber.Type type) {
        AddressDataDTO addressData = new AddressDataDTO(street, number, null, null, apartment, city, null, zipCode, state, country);
        PhoneNumberDataDTO phoneData = new PhoneNumberDataDTO(prefix, phoneNumber, type);
        ContactFactory usFactory = new USContactFactory();
        Contact newContact = agenda.addContact(usFactory, addressData, phoneData);
        System.out.println("✅ Contacto americano añadido: " + newContact.getAddress().getFormattedAddress());
    }

    private void viewAllContacts() {
        List<Contact> allContacts = agenda.viewAllContacts();
        System.out.println("\n--- Todos los Contactos en la Agenda ---");
        if (allContacts.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (int i = 0; i < allContacts.size(); i++) {
                Contact contact = allContacts.get(i);
                System.out.println("Contacto #" + (i + 1) + ":");
                System.out.println("  Dirección: " + contact.getAddress().getFormattedAddress());
                System.out.println("  Teléfono: " + contact.getPhoneNumber().getFormattedNumber());
            }
        }
    }

    private void filterAndShowContacts(String countryCode) {
        List<Contact> filteredContacts = agenda.filterContacts(countryCode);
        System.out.println("\n--- Contactos filtrados por el país: " + countryCode.toUpperCase() + " ---");
        if (filteredContacts.isEmpty()) {
            System.out.println("No se encontraron contactos para este país.");
        } else {
            for (Contact contact : filteredContacts) {
                System.out.println("  - " + contact.getAddress().getFormattedAddress() + " | " + contact.getPhoneNumber().getFormattedNumber());
            }
        }
    }

    private void deleteContact(int index) {
        Contact removedContact = agenda.deleteContact(index);
        if (removedContact != null) {
            System.out.println("\n🗑️ Contacto eliminado: " + removedContact.getAddress().getFormattedAddress());
        } else {
            System.out.println("\n❌ No se pudo eliminar el contacto. Índice inválido.");
        }
    }
}
