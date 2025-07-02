package s3_01_abstract_factory;

public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        ContactFactory spanishFactory = new SpanishContactFactory();
        ContactFactory usFactory = new USContactFactory();

        agenda.addContact(spanishFactory,
                "Plaza de la fuente", "13", "2", "B", "Guipuzkoa", "28314", "Spain",
                "+34", "999760548", InternationalPhoneNumber.Type.MOBILE
        );

        agenda.addContact(usFactory,
                "687 Myah Valley", "13", "2", "B", "West Rosario Haven", "75373-4585", "USA",
                "+1", "870-535-7911", InternationalPhoneNumber.Type.FIXED
        );
    }
}
