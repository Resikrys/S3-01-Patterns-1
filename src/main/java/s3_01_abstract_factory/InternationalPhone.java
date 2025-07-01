package s3_01_abstract_factory;

public interface InternationalPhone {
    enum Type { FIXED, MOBILE }
    String getFormattedPhone();
    //Other getters
}
