package s3_01_abstract_factory.model.product;

public interface InternationalPhoneNumber {
    enum Type { FIXED, MOBILE }
    String getFormattedPhone();
    String getPrefix();
    String getNumber();
    Type getType();
}
