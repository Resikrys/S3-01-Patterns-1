package s3_01_abstract_factory;

public class Main {
    public static void main(String[] args) {
        //My code
        Agenda agenda = new Agenda();

        // Crear un contacto español
        ContactFactory spanishFactory = new SpanishContactFactory();
        agenda.addContact(spanishFactory, /* datos para el contacto español */);

        // Crear un contacto de EE. UU.
        ContactFactory usFactory = new USContactFactory();
        agenda.addContact(usFactory, /* datos para el contacto de EE. UU. */);
    }
}
