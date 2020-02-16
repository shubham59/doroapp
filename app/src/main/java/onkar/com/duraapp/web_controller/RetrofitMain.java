package onkar.com.duraapp.web_controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMain {

    public static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.232.212.215:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
