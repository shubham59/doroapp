package onkar.com.duraapp.model;

public class VerifyRequestModel {
    private String email;
    private String code;

    public VerifyRequestModel(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
