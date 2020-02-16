package onkar.com.duraapp.model;

public class OwnRequestModel {
    private String ques;
    private String ans;
    private String type;

    public OwnRequestModel(String q, String a, String type) {
        this.ques = q;
        this.ans = a;
        this.type = type;
    }
}
