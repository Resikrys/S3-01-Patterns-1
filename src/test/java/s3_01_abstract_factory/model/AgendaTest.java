package s3_01_abstract_factory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import s3_01_abstract_factory.model.dto.AddressDataDTO;
import s3_01_abstract_factory.model.dto.PhoneNumberDataDTO;
import s3_01_abstract_factory.model.factory.ContactFactory;
import s3_01_abstract_factory.model.factory.SpanishContactFactory;
import s3_01_abstract_factory.model.factory.USContactFactory;
import s3_01_abstract_factory.model.product.InternationalPhoneNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda;
    private ContactFactory spanishFactory;
    private ContactFactory usFactory;

    @BeforeEach
    void setUp() {
        agenda = new Agenda();
        spanishFactory = new SpanishContactFactory();
        usFactory = new USContactFactory();
    }

    @Test
    @DisplayName("should add a Spanish contact to the agenda")
    void addSpanishContact_AddsContactToList_WhenCalled() {
        AddressDataDTO spanishAddressData = new AddressDataDTO("Calle Falsa", "123", "3", "A", null,
                "Barcelona", "08001", null, null, "Spain");
        PhoneNumberDataDTO spanishPhoneData = new PhoneNumberDataDTO("34", "600123456", InternationalPhoneNumber.Type.MOBILE);

        Contact addedContact = agenda.addContact(spanishFactory, spanishAddressData, spanishPhoneData);

        assertNotNull(addedContact, "The added contact should not be null");
        assertEquals(1, agenda.viewAllContacts().size(), "Agenda should contain 1 contact after adding one");
        assertEquals("Calle Falsa", addedContact.getAddress().getStreet(), "The street should be correct");
    }

    @Test
    @DisplayName("should remove a contact when a valid index is provided")
    void deleteContact_RemovesContact_WhenValidIndex() {
        agenda.addContact(spanishFactory, new AddressDataDTO("C/ España", "1", null, null, null, "Madrid", "28001", null, null, "Spain"),
                new PhoneNumberDataDTO("34", "600111222", InternationalPhoneNumber.Type.MOBILE));
        agenda.addContact(usFactory, new AddressDataDTO("Elm St", "13", null, null, "Apt 4B", "Springfield", null, "62704", "IL", "USA"),
                new PhoneNumberDataDTO("1", "5551234567", InternationalPhoneNumber.Type.FIXED));

        Contact removedContact = agenda.deleteContact(0);

        assertNotNull(removedContact, "A valid contact should be returned");
        assertEquals(1, agenda.viewAllContacts().size(), "Agenda should contain 1 contact after deletion");
        assertEquals("Elm St", agenda.viewAllContacts().get(0).getAddress().getStreet(), "The remaining contact should be the US one");
    }

    @Test
    @DisplayName("should return null when an invalid index is provided")
    void deleteContact_ReturnsNull_WhenInvalidIndex() {

        Contact removedContact = agenda.deleteContact(99);

        assertNull(removedContact, "A null contact should be returned for an invalid index");
        assertEquals(0, agenda.viewAllContacts().size(), "Agenda size should remain 0");
    }

    @Test
    @DisplayName("should filter and return only Spanish contacts")
    void filterContacts_ReturnsSpanishContacts_WhenCountryCodeIsES() {

        agenda.addContact(spanishFactory, new AddressDataDTO("C/ España", "1", null, null, null, "Madrid", "28001", null, null, "Spain"),
                new PhoneNumberDataDTO("34", "600111222", InternationalPhoneNumber.Type.MOBILE));
        agenda.addContact(usFactory, new AddressDataDTO("Elm St", "13", null, null, "Apt 4B", "Springfield", null, "62704", "IL", "USA"),
                new PhoneNumberDataDTO("1", "5551234567", InternationalPhoneNumber.Type.FIXED));

        List<Contact> spanishContacts = agenda.filterContacts("es");

        assertEquals(1, spanishContacts.size(), "There should be exactly one Spanish contact");
        assertEquals("Spain", spanishContacts.get(0).getAddress().getCountry(), "The filtered contact should be Spanish");
    }

    @Test
    @DisplayName("should return an empty list when no contacts match the country code")
    void filterContacts_ReturnsEmptyList_WhenNoMatch() {

        agenda.addContact(usFactory, new AddressDataDTO("Elm St", "13", null, null, "Apt 4B", "Springfield", null, "62704", "IL", "USA"),
                new PhoneNumberDataDTO("1", "5551234567", InternationalPhoneNumber.Type.FIXED));

        List<Contact> frenchContacts = agenda.filterContacts("fr");

        assertTrue(frenchContacts.isEmpty(), "The list of contacts should be empty");
    }
}