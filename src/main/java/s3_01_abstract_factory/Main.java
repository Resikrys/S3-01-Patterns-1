package s3_01_abstract_factory;

public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        //Spanish Contact
        AddressDataDTO spanishAddressData = new AddressDataDTO(
                "Calle Falsa", "123", "3", "A", null,
                "Barcelona", "08001", null, null, "Spain"
        );

        PhoneNumberDataDTO spanishPhoneData = new PhoneNumberDataDTO(
                "34", "600123456", InternationalPhoneNumber.Type.MOBILE
        );

        ContactFactory spanishFactory = new SpanishContactFactory();
        agenda.addContact(spanishFactory, spanishAddressData, spanishPhoneData);

        System.out.println("\n");

        //US Contact
        AddressDataDTO usAddressData = new AddressDataDTO(
                "Elm Street", "13", null, null, "Apt 4B", // floor y portal son null para EE. UU.
                "Springfield", null, "62704", "IL", "USA" // postalCode es null para EE. UU.
        );

        PhoneNumberDataDTO usPhoneData = new PhoneNumberDataDTO(
                "1", "5551234567", InternationalPhoneNumber.Type.FIXED
        );

        ContactFactory usFactory = new USContactFactory();
        agenda.addContact(usFactory, usAddressData, usPhoneData);

        //Agenda methods:
        agenda.viewAllContacts();
        agenda.filterContacts("spanish");
        agenda.filterContacts("us");

    }
}
