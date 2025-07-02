package s3_01_abstract_factory;

public interface InternationalPhoneNumber {
    enum Type { FIXED, MOBILE }
    String getFormattedPhone();
    String getPrefix();
    String getNumber();
    Type getType();
}
