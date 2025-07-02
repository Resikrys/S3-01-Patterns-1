package s3_01_abstract_factory;

public class SpanishPhoneNumber implements InternationalPhoneNumber {

    private Type type; //(FIXED/MOBILE)
    private String prefix;
    private String number;

    public SpanishPhoneNumber(String prefix, String number, Type type) {
        this.prefix = prefix;
        this.number = number;
        this.type = type;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String getFormattedPhone() {
        return this.type.name() + ": +" + getPrefix() + " " + getNumber();
    }
}
