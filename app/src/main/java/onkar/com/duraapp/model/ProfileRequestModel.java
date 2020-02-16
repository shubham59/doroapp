package onkar.com.duraapp.model;

public class ProfileRequestModel {
    private String name;
    private String email;
    private String mobile;
    private String address;

    private String i_live;
    private String i_am;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return mobile;
    }

    public void setPhone(String phone) {
        this.mobile = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getiLive() {
        return i_live;
    }

    public void setiLive(String iLive) {
        this.i_live = iLive;
    }

    public String getiAm() {
        return i_am;
    }

    public void setiAm(String iAm) {
        this.i_am = iAm;
    }
}
