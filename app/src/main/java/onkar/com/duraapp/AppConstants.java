package onkar.com.duraapp;

import onkar.com.duraapp.model.VerifyResponseModel;

public class AppConstants {
    private static final AppConstants ourInstance = new AppConstants();

    public static AppConstants getInstance() {
        return ourInstance;
    }

    public VerifyResponseModel verifyResponseModel;

    private AppConstants() {
    }
}
