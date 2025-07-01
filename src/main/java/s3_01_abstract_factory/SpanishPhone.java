package s3_01_abstract_factory;

public class SpanishPhone implements InternationalPhone {
    // Implementación de atributos y métodos para números españoles
    // Por ejemplo: prefijo, numero, tipo
    @Override
    public String getFormattedNumber() {
        return "+" + getPrefix() + " " + getPhoneNumber();
    }
}
