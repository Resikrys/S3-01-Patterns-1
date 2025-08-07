package s3_01_abstract_factory.model.dto;

import s3_01_abstract_factory.model.product.InternationalPhoneNumber;

public class PhoneNumberDataDTO {
    private String prefix;
    private String phoneNumber;
    private InternationalPhoneNumber.Type type;


    public PhoneNumberDataDTO(String prefix, String phoneNumber, InternationalPhoneNumber.Type type) {
        this.prefix = prefix;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }


    public String getPrefix() { return prefix; }
    public String getPhoneNumber() { return phoneNumber; }
    public InternationalPhoneNumber.Type getType() { return type; }


    @Override
    public String toString() {
        return "PhoneNumberDataDTO{" +
                "prefix='" + prefix + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type +
                '}';
    }
}
