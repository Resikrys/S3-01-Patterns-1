package s3_01_abstract_factory;

public class SpanishPhoneNumber implements InternationalPhoneNumber {

    private Type type; //(FIXED/MOBILE)
    private int prefix;
    private int number;

    public SpanishPhoneNumber(int prefix, int number, Type type) {
        this.prefix = prefix;
        this.number = number;
        this.type = type;
    }

    public int getPrefix() {
        return this.prefix;
    }

    public int getNumber() {
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
