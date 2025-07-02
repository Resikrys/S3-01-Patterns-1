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

    public void addContact(ContactFactory factory, AddressDataDTO addressData, PhoneNumberDataDTO phoneData) {
        InternationalAddress address = factory.createAddress(addressData);
        InternationalPhoneNumber phoneNum = factory.createPhoneNumber(phoneData);

        this.addresses.add(address);
        this.phoneNumbers.add(phoneNum);
        System.out.println("--- Contact Added ---");
        System.out.println("Address: " + address.getFormattedAddress());
        System.out.println("Phone number: " + phoneNum.getFormattedPhone());
        System.out.println("------------------------");
    }

    public void viewAllContacts() {
        if (addresses.isEmpty()) {
            System.out.println("\nEmpty agenda.");
            return;
        }
        System.out.println("\n--- All contacts: ---");
        for (int i = 0; i < addresses.size(); i++) {
            System.out.println("Contact #" + (i + 1));
            System.out.println("  Address: " + addresses.get(i).getFormattedAddress());
            System.out.println("  Phone number: " + phoneNumbers.get(i).getFormattedPhone());
            System.out.println("---------------------------");
        }
    }

    public boolean deleteContact(int index) {
        if (index >= 0 && index < addresses.size()) {
            String removedAddress = addresses.remove(index).getFormattedAddress();
            String removedPhoneNumber = phoneNumbers.remove(index).getFormattedPhone();
            System.out.println("\n--- Deleted Contact ---");
            System.out.println("Erased: " + removedAddress + " / " + removedPhoneNumber);
            System.out.println("-------------------------");
            return true;
        }
        System.out.println("\nInvalid contact index. Can't be removed.");
        return false;
    }

    public void filterContacts(String countryType) {
        System.out.println("\n--- Contacts Filtered by " + countryType.toUpperCase() + " ---");
        boolean found = false;

        for (int i = 0; i < addresses.size(); i++) {
            InternationalAddress address = addresses.get(i);
            InternationalPhoneNumber phoneNumber = phoneNumbers.get(i);

            if ("spanish".equalsIgnoreCase(countryType)) {
                if (address instanceof SpanishAddress && phoneNumber instanceof SpanishPhoneNumber) {
                    System.out.println("Contact #" + (i + 1));
                    System.out.println("  Address: " + address.getFormattedAddress());
                    System.out.println("  Phone number: " + phoneNumber.getFormattedPhone());
                    System.out.println("---------------------------");
                    found = true;
                }
            } else if ("us".equalsIgnoreCase(countryType)) {
                if (address instanceof USAddress && phoneNumber instanceof USPhoneNumber) {
                    System.out.println("Contact #" + (i + 1));
                    System.out.println("  Address: " + address.getFormattedAddress());
                    System.out.println("  Phone number: " + phoneNumber.getFormattedPhone());
                    System.out.println("---------------------------");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No contacts of this type were found '" + countryType + "'.");
        }
        System.out.println("------------------------------------");
    }

}
