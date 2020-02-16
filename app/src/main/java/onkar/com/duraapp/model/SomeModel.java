package onkar.com.duraapp.model;

public class SomeModel {
    private String question;
    private String answer;
    private String type;

    public SomeModel(String q, String a, String type) {
        this.question = q;
        this.answer = a;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getType() {
        return type;
    }
}
