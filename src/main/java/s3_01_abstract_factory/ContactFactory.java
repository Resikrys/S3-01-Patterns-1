package s3_01_abstract_factory;

public interface ContactFactory {
    InternationalAdress createAddress();
    InternationalPhone createPhone();
}
