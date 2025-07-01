package s3_01_abstract_factory;

public class USContactFactory {
    @Override
    public InternationalAddress createAddress() {
        return new USAddress(); // Podrías pasar parámetros en el constructor si fuera necesario
    }

    @Override
    public InternationalPhoneNumber createPhoneNumber() {
        return new USPhoneNumber(); // Idem
    }
}
