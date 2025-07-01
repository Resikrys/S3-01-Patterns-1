package s3_01_abstract_factory;

public class SpanishContactFactory implements ContactFactory {
    @Override
    public InternationalAddress createAddress() {
        return new SpanishAddress(); // Podrías pasar parámetros en el constructor si fuera necesario
    }

    @Override
    public InternationalPhoneNumber createPhoneNumber() {
        return new SpanishPhoneNumber(); // Idem
    }
}
