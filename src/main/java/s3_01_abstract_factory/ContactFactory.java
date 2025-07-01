package s3_01_abstract_factory;

public interface ContactFactory {
    InternationalAddress createAddress();
    InternationalPhoneNumber createPhoneNumber();
}
