package s3_01_abstract_factory.controller;

import s3_01_abstract_factory.model.Agenda;
import s3_01_abstract_factory.model.Contact;
import s3_01_abstract_factory.model.dto.AddressDataDTO;
import s3_01_abstract_factory.model.dto.PhoneNumberDataDTO;
import s3_01_abstract_factory.model.factory.ContactFactory;
import s3_01_abstract_factory.model.factory.SpanishContactFactory;
import s3_01_abstract_factory.model.factory.USContactFactory;
import s3_01_abstract_factory.model.product.InternationalPhoneNumber;

import java.util.Scanner;

public class AgendaController {
    private Agenda agenda;
    private Scanner scanner;

    public AgendaController() {
        this.agenda = new Agenda();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        System.out.println("--- Agenda Manager ---");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add spanish contact");
            System.out.println("2. Add american contact");
            System.out.println("3. See all contact");
            System.out.println("4. Filter contact by country");
            System.out.println("5. Delete a contact");
            System.out.println("0. Exit");

            System.out.print("> ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addSpanishContactFromUser();
                    break;
                case "2":
                    addUSContactFromUser();
                    break;
                case "3":
                    viewAllContacts();
                    break;
                case "4":
                    filterContactsFromUser();
                    break;
                case "5":
                    deleteContactFromUser();
                    break;
                case "0":
                    exit = true;
                    System.out.println("Exiting the schedule manager. See you soon!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }

    private void addSpanishContactFromUser() {
        System.out.println("\n--- Add new spanish contact ---");
        System.out.print("Enter the street: ");
        String street = scanner.nextLine();
        System.out.print("Enter the number: ");
        String number = scanner.nextLine();
        System.out.print("Enter the floor (ex. 3º A): ");
        String floor = scanner.nextLine();
        System.out.print("Enter the portal: ");
        String portal = scanner.nextLine();
        System.out.print("Enter the city: ");
        String city = scanner.nextLine();
        System.out.print("Enter the postal code: ");
        String postalCode = scanner.nextLine();
        System.out.print("Enter the telephone prefix (+34): ");
        String prefix = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Type (FIXED/MOBILE): ");
        String phoneType = scanner.nextLine();

        AddressDataDTO addressData = new AddressDataDTO(street, number, floor, portal, null, city, postalCode, null, null, "Spain");
        PhoneNumberDataDTO phoneData = new PhoneNumberDataDTO(prefix, phoneNumber, InternationalPhoneNumber.Type.valueOf(phoneType.toUpperCase()));

        ContactFactory spanishFactory = new SpanishContactFactory();
        agenda.addContact(spanishFactory, addressData, phoneData);
        System.out.println("✅ Spanish contact added successfully.");
    }

    private void addUSContactFromUser() {
        System.out.println("\n--- Add new american contct ---");
        System.out.print("Enter the street: ");
        String street = scanner.nextLine();
        System.out.print("Enter the number: ");
        String number = scanner.nextLine();
        System.out.print("Enter the apartment (e.g. Apt 4B): ");
        String apartment = scanner.nextLine();
        System.out.print("Enter the city: ");
        String city = scanner.nextLine();
        System.out.print("Enter the state (e.g. IL): ");
        String state = scanner.nextLine();
        System.out.print("Enter the postal code (ZIP): ");
        String zipCode = scanner.nextLine();
        System.out.print("Enter the telephone prefix (+1): ");
        String prefix = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Type (FIXED/MOBILE): ");
        String phoneType = scanner.nextLine();

        AddressDataDTO addressData = new AddressDataDTO(street, number, null, null, apartment, city, null, zipCode, state, "USA");
        PhoneNumberDataDTO phoneData = new PhoneNumberDataDTO(prefix, phoneNumber, InternationalPhoneNumber.Type.valueOf(phoneType.toUpperCase()));

        ContactFactory usFactory = new USContactFactory();
        agenda.addContact(usFactory, addressData, phoneData);
        System.out.println(" ✅ American contact added successfully.");
    }

    private void viewAllContacts() {
        System.out.println("\n--- All Contacts in Agenda ---");
        for (Contact contact : agenda.viewAllContacts()) {
            System.out.println("  - Address: " + contact.getAddress().getFormattedAddress() +
                    " | Telephone: " + contact.getPhoneNumber().getFormattedPhone());
        }
    }

    private void filterContactsFromUser() {
        System.out.println("\n--- Filter contacts ---");
        System.out.print("Enter the country code (es, us): ");
        String countryCode = scanner.nextLine();

        for (Contact contact : agenda.filterContacts(countryCode)) {
            System.out.println(" - Address: " + contact.getAddress().getFormattedAddress() +
                    " | Telephone: " + contact.getPhoneNumber().getFormattedPhone());
        }
    }

    private void deleteContactFromUser() {
        System.out.println("\n--- Delete a contact ---");
        viewAllContacts();
        System.out.print("Enter the index of the contact to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            Contact removedContact = agenda.deleteContact(index);
            if (removedContact != null) {
                System.out.println("🗑️ Contact removed: " + removedContact.getAddress().getFormattedAddress());
            } else {
                System.out.println("❌ Invalid index.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a number.");
        }
    }
}
